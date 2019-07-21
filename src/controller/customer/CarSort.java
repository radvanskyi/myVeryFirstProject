package controller.customer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import model.dao.CarDao;
import model.dao.impl.CarDaoImpl;
import model.entity.Car;

/* 
 * A customer can sort cars by price and car names.
 * Also he can choose cars of defined mark or class
 */

@WebServlet("/carSort")
public class CarSort extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(CarSort.class);   
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Cars sorting");
		CarDao carDao = new CarDaoImpl();
		List<Car> cars = new ArrayList<>(carDao.getAllCars());
		Iterator<Car> it = cars.iterator();
		
		CarList carList = new CarList();
		carList.setMarks(request, cars);
		carList.setClasses(request, cars);
		
		if (request.getParameter("mark") != null) {
			while(it.hasNext()) {
				if(!it.next().getMark().equals(request.getParameter("mark"))) {
					logger.info("Sorting by mark");
					it.remove();
				}
			}
			request.setAttribute("cars", cars);
		}
		
		if (request.getParameter("carClass") != null) {
			while(it.hasNext()) {
				if(!it.next().getCarClass().getName().equals(request.getParameter("carClass"))) {
					logger.info("Sorting by class");
					it.remove();
				}
			}
			request.setAttribute("cars", cars);
		}
		
		if (Boolean.valueOf(request.getParameter("price"))) {
			List<Car> carsByPrice = new ArrayList<>(carDao.getAllCars());
			Collections.sort(carsByPrice, new Comparator<Car>() {
				@Override
				public int compare(Car c1, Car c2) {
					return c1.getPrice() - c2.getPrice();
				}
			});
			logger.info("Sorting by price");
			request.setAttribute("cars", carsByPrice);
		}
		
		if (Boolean.valueOf(request.getParameter("model"))) {
			List<Car> carsByModel = new ArrayList<>(carDao.getAllCars());
			Collections.sort(carsByModel, new Comparator<Car>() {
				@Override
				public int compare(Car c1, Car c2) {
					return c1.getModel().compareTo(c2.getModel());
				}
			});
			logger.info("Sorting by model");
			request.setAttribute("cars", carsByModel);
		}
		
		
		request.getRequestDispatcher("/jsp/customer/carList.jsp").forward(request, response);
	}
}
