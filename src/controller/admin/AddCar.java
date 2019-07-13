package controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.impl.CarDaoImpl;
import model.dao.impl.ClassDaoImpl;
import model.entity.Car;

@WebServlet("/addCar")
public class AddCar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (request.getParameter("price").matches("^\\d+") && request.getParameter("carClass").matches("\\d")) {
			Car car = new Car();
			car.setMark(request.getParameter("mark"));
			car.setModel(request.getParameter("model"));
			car.setPrice(Integer.parseInt(request.getParameter("price")));
			car.setCarClass(new ClassDaoImpl().getClass(Integer.parseInt(request.getParameter("carClass"))));
			
			new CarDaoImpl().add(car);
			response.sendRedirect(getServletContext().getContextPath() + "/carListAdmin");
		} else {
			response.sendRedirect("jsp/error/error.jsp");
		}
	}
}
