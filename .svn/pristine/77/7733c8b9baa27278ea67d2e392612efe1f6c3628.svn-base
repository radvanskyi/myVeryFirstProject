package controller.customer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import model.dao.CarDao;
import model.dao.ClassDao;
import model.dao.impl.CarDaoImpl;
import model.dao.impl.ClassDaoImpl;
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
		List<Car> cars = carDao.getAllCars();
		ClassDao classDao = new ClassDaoImpl();
		
		CarList carList = new CarList();
		carList.setMarks(request, cars);
		carList.setClasses(request, classDao.getAll());
		
		String mark = request.getParameter("mark");
		String carClass = request.getParameter("carClass");
		if (mark != null) {
			List<Car> carsByMark = new ArrayList<>(carDao.getCarsByMark(mark));
			logger.info("Cars sorting by mark");
			request.setAttribute("cars", carsByMark);
		} else if (carClass != null) {
			List<Car> carsByClass = new ArrayList<>(carDao.getCarsByClass(carClass));
			logger.info("Cars sorting by carClass: " + carClass);
			request.setAttribute("cars", carsByClass);
		} else if (Boolean.valueOf(request.getParameter("price"))) {
			logger.info("Sorting by price");
			request.setAttribute("cars", carDao.getAllCars("price","ASC"));
		} else if (Boolean.valueOf(request.getParameter("model"))) {
			logger.info("Sorting by model");
			request.setAttribute("cars", carDao.getAllCars("model","ASC"));
		} else {
			request.setAttribute("cars", carDao.getAllCars());
		}
		
		request.getRequestDispatcher("/jsp/customer/carList.jsp").forward(request, response);
	}
}
