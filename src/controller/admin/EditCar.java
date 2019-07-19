package controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.CarDao;
import model.dao.impl.CarDaoImpl;
import model.entity.Car;

@WebServlet("/editCar")
public class EditCar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		CarDao carDao = new CarDaoImpl();
		Car car = carDao.getById(id);
		
		if (request.getParameter("price").matches("^\\d+")) {
			int price = Integer.parseInt(request.getParameter("price"));
			
			car.setPrice(price);
			carDao.update(car);
			response.sendRedirect(getServletContext().getContextPath() + "/carListAdmin");
		} else {
			response.sendRedirect(getServletContext().getContextPath() + "/error");
		}
	}
}
