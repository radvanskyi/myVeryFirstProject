package controller.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.CarDao;
import model.dao.impl.CarDaoImpl;
import model.entity.Car;

/* 
 * List of all cars for the admin
 */

@WebServlet("/carListAdmin")
public class CarListAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CarDao carDao = new CarDaoImpl();
		List<Car> list = new ArrayList<>(carDao.getAllCars());

		request.setAttribute("list", list);
		request.getRequestDispatcher("jsp/admin/carListAdmin.jsp").forward(request, response);
	}
}
