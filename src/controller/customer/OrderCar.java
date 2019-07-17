package controller.customer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.CarDao;
import model.dao.impl.CarDaoImpl;
import model.entity.Car;

@WebServlet("/orderCar")
public class OrderCar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CarDao carDao = new CarDaoImpl();
		int id = Integer.parseInt(request.getParameter("id"));
		Car car = carDao.getById(id);
		System.out.println(car);
		
		request.setAttribute("id", id);
		request.setAttribute("mark", car.getMark());
		request.setAttribute("model", car.getModel());
		request.setAttribute("price", car.getPrice());
		request.setAttribute("carClass", car.getCarClass().getName());
		request.getRequestDispatcher("/jsp/customer/orderList.jsp").forward(request, response);
	}
}
