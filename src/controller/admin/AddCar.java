package controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.CarDao;
import model.dao.ClassDao;
import model.dao.impl.CarDaoImpl;
import model.dao.impl.ClassDaoImpl;
import model.entity.Car;

@WebServlet("/addCar")
public class AddCar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
			response.sendRedirect("jsp/error/error.jsp");
		}
	}
}
