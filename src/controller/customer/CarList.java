package controller.customer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import model.entity.CarClass;

/* 
 * List of cars for all visitors.
 * But only logged users can make an order
 */

@WebServlet("/carList")
public class CarList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(CarList.class);   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("List of all cars");
		
		CarDao carDao = new CarDaoImpl();
		ClassDao classDao = new ClassDaoImpl();
		List<Car> cars = new ArrayList<>(carDao.getAllCars());
		request.setAttribute("cars", cars);
		
		setMarks(request, cars);
		setClasses(request, classDao.getAll());
		
		request.getRequestDispatcher("/jsp/customer/carList.jsp").forward(request, response);
	}

	void setClasses(HttpServletRequest request, List<CarClass> classes) {
		request.setAttribute("classes", classes);
	}
	

	void setMarks(HttpServletRequest request, List<Car> cars) {
		Set<String> marks = new HashSet<>();
		for (Car c : cars) {
			marks.add(c.getMark());
		}
		request.setAttribute("marks", marks);
	}
}
