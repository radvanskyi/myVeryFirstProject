package controller.admin;

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
import model.dao.impl.CarDaoImpl;
import model.entity.Car;

/* 
 * Edit car page
 */

@WebServlet("/editCarPage")
public class EditCarPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(EditCarPage.class);   
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Starting editing a car");
		
		int id = Integer.parseInt(request.getParameter("id"));
		CarDao carDao = new CarDaoImpl();
		List<Car> cars = new ArrayList<>();

		Car car = carDao.getById(id);
		cars.add(car);
		
		request.setAttribute("cars", cars);
		request.getRequestDispatcher("/jsp/admin/editCar.jsp").forward(request, response);
	}
}
