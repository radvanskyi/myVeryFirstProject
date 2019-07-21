package controller.customer;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import model.dao.CheckDao;
import model.dao.OrderDao;
import model.dao.StatusDao;
import model.dao.impl.CheckDaoImpl;
import model.dao.impl.OrderDaoImpl;
import model.dao.impl.StatusDaoImpl;
import model.entity.Check;
import model.entity.Order;
import model.entity.Status;

/* 
 * Create a check to send it to a customer for payment
 */

@WebServlet("/makeCheck")
public class MakeCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(MakeCheck.class);   

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Creating a check");
		OrderDao orderDao = new OrderDaoImpl();
		List<Order> orders = new ArrayList<>();
		CheckDao checkDao = new CheckDaoImpl();
		StatusDao statusDao = new StatusDaoImpl();
		Check check = new Check();
		
		String email = (String) request.getSession().getAttribute("email");
		
		for (Order o : orderDao.getAllOrders()) {
			if (o.getUser().getEmail().equals(email) && o.getStatus().getName().equals("waiting")) {
				logger.info("Creating a list of orders");
				orders.add(o);
			}
		}

		check.setOrders(orders);
		check.setDate(new Date(System.currentTimeMillis()));
		check.setDescription(Check.NEW_CHECK);
		check.setPrice(totalPrice(check));
		check.setStatus(statusDao.getById(Status.DEFAULT_CHECK_STATUS));
		checkDao.createCheck(check);

		for (Order o : orders) {
			o.setStatus(statusDao.getById(Status.RENT_ORDER_STATUS));
			o.setCheck(check);
			logger.info("Updating order");
			orderDao.update(o);
		}
		
		response.sendRedirect(getServletContext().getContextPath() + "/userOrders");
	}

	private int totalPrice(Check check) {
		int sum = 0;
		List<Order> orders = check.getOrders();
		for (Order o : orders) {
			sum += orderPrice(o);
		}
		return sum;
	}

	private int orderPrice(Order o) {
		int carPrice = o.getCar().getPrice();
		LocalDate startDate = o.getStartDate().toLocalDate();
		LocalDate endDate = o.getEndDate().toLocalDate();
		
		int total = ((endDate.getYear() - startDate.getYear()) * 360)
				+ ((endDate.getMonth().getValue() - startDate.getMonth().getValue()) * 30) 
				+ (endDate.getDayOfMonth() - startDate.getDayOfMonth());
		
		total *= carPrice;
		if (o.isDriver()) {
			total += 500;
		}
		
		return total;
	}
}
