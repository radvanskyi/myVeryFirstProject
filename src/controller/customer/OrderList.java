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
 * Show all customer's orders
 */

@WebServlet("/orderList")
public class OrderList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(OrderList.class);   

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Making order");
		
		OrderDao orderDao = new OrderDaoImpl();
		CarDao carDao = new CarDaoImpl();
		UserDao userDao = new UserDaoImpl();
		StatusDao statusDao = new StatusDaoImpl();
		
		int id = Integer.parseInt(request.getParameter("id"));
		String email = (String) request.getSession().getAttribute("email");
		Date startDate = Date.valueOf(request.getParameter("startDate"));
		Date endDate = Date.valueOf(request.getParameter("finishDate"));
		Date currentDate = new Date(System.currentTimeMillis());
		String needDriver = request.getParameter("driver");
		String passport = request.getParameter("passport");
		
		boolean driver = false;
		if (needDriver != null) {
			driver = "on".equals(needDriver);
		}
		
		if(startDate.before(currentDate) || endDate.before(startDate)) {
			logger.info("Wrong input data");
			response.sendRedirect("/jsp/error/error.jsp");
		} else {
			Order order = new Order();
			order.setCar(carDao.getById(id));
			order.setUser(userDao.getUserByEmail(email));
			order.setStartDate(startDate);
			order.setEndDate(endDate);
			order.setStatus(statusDao.getById(Status.WAIT_ORDER_STATUS));
			order.setPassport(passport);
			order.setDriver(driver);
			
			orderDao.createOrder(order);
			logger.info("Order has been made");
			response.sendRedirect("/userOrders");
		}
	}

}
