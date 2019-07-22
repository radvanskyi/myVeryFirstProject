package controller.customer;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import model.dao.CarDao;
import model.dao.OrderDao;
import model.dao.StatusDao;
import model.dao.UserDao;
import model.dao.impl.CarDaoImpl;
import model.dao.impl.OrderDaoImpl;
import model.dao.impl.StatusDaoImpl;
import model.dao.impl.UserDaoImpl;
import model.entity.Order;
import model.entity.Status;

/* 
 * A customer can order a car.
 * He can't make an order in the past and
 * return date can't be before order date
 */

@WebServlet("/rentCar")
public class RentCar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(RentCar.class); 
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Order car page");

		OrderDao orderDao = new OrderDaoImpl();
		CarDao carDao = new CarDaoImpl();
		UserDao userDao = new UserDaoImpl();
		StatusDao statusDao = new StatusDaoImpl();

		Date current = new Date(System.currentTimeMillis());
		int id = Integer.parseInt(request.getParameter("id"));
		String email = (String)request.getSession().getAttribute("email");
		Date startDate = Date.valueOf(request.getParameter("startDate"));
		Date endDate = Date.valueOf(request.getParameter("endDate"));
		String driver = request.getParameter("driver");
		String passport = request.getParameter("passport");
		
		boolean needDriver = false;
		if (driver != null) {
			logger.info("Driver is on");
			needDriver = driver.equals("on");
		}
		
		if (startDate.before(current) || endDate.before(startDate)) {
			logger.info("Wrong input data");
			response.sendRedirect("jsp/error/error.jsp");
		} else {
			logger.info("Order was made");
			Order order = new Order();
			order.setPassport(passport);
			order.setUser(userDao.getUserByEmail(email));
			order.setCar(carDao.getById(id));
			order.setStartDate(startDate);
			order.setEndDate(endDate);
			order.setDriver(needDriver);
			order.setStatus(statusDao.getById(Status.WAIT_ORDER_STATUS));
			orderDao.createOrder(order);
			response.sendRedirect(getServletContext().getContextPath() + "/userOrders");
		}
		
	}
}
