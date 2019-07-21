package controller.admin;

import java.io.IOException;

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
 * The admin can add new car to the Database
 */

@WebServlet("/addCar")
public class AddCar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(AddCar.class);
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		logger.info("Adding a car");
		
		ClassDao classDao = new ClassDaoImpl();
		Car car = new Car();
		car.setMark(request.getParameter("mark"));
		car.setModel(request.getParameter("model"));
		car.setPrice(Integer.parseInt(request.getParameter("price")));
		car.setCarClass(classDao.getClass(Integer.parseInt(request.getParameter("carClass"))));
		
		if (car.getPrice() > 0 && car.getCarClass().getId() >= 0 && car.getCarClass().getId() < 10) {
			CarDao carDao = new CarDaoImpl();
			carDao.add(car);
			response.sendRedirect(getServletContext().getContextPath() + "/carListAdmin");
		} else {
			logger.error("Not valid information while adding a car");
			response.sendRedirect("jsp/error/error.jsp");
		}
	}
}
