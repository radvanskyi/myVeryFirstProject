package controller.customer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import model.dao.OrderDao;
import model.dao.impl.OrderDaoImpl;
import model.entity.Check;
import model.entity.Order;

/* 
 * Shows all customer's orders
 */

@WebServlet("/userOrders")
public class UserOrders extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(UserOrders.class);   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = (String)request.getSession().getAttribute("email");
		OrderDao orderDao = new OrderDaoImpl();
		
		List<Check> checkList = new ArrayList<>();
		List<Order> waitList = new ArrayList<>();
		
		for (Order o : orderDao.getAllOrders()) {
			if (o.getUser().getEmail().equals(email)) {
				if (o.getStatus().getName().equals("waiting")) {
					waitList.add(o);
				} else {
					checkList.add(o.getCheck());
				}
			}
		}
		
		for (Check c : checkList) {
			c.setOrders((List<Order>)orderDao.getByCheck(c.getId())); 
		}
		logger.info("List of all customer orders");
		request.setAttribute("checkList", checkList);
		request.setAttribute("waitList", waitList);
		request.getRequestDispatcher("/jsp/customer/customerOrders.jsp").forward(request, response);
	}
}
