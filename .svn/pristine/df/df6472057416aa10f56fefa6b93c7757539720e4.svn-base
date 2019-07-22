package controller.admin;

import java.io.IOException;

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
 * Admin can change the rent price of a car
 */

@WebServlet("/editCar")
public class EditCar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(EditCar.class);
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Editing a car");
		
		int id = Integer.parseInt(request.getParameter("id"));
		CarDao carDao = new CarDaoImpl();
		Car car = carDao.getById(id);
		
		if (request.getParameter("price").matches("^\\d+")) {
			int price = Integer.parseInt(request.getParameter("price"));
			
			car.setPrice(price);
			carDao.update(car);
			response.sendRedirect(getServletContext().getContextPath() + "/carListAdmin");
		} else {
			logger.error("Not valid data while editing a car");
			response.sendRedirect(getServletContext().getContextPath() + "/error");
		}
	}
}
