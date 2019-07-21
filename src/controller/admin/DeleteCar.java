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

/* 
 * Admin can delete a car from the Database
 */

@WebServlet("/deleteCar")
public class DeleteCar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(DeleteCar.class);

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Deleting a manager");
		
		int id = Integer.parseInt(request.getParameter("id"));
		CarDao carDao = new CarDaoImpl();
		
		carDao.delete(id);
		response.sendRedirect(getServletContext().getContextPath() + "/carListAdmin");
	}

}
