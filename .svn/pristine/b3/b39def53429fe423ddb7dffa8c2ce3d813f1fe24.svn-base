package controller.manager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import model.dao.OrderDao;
import model.dao.impl.OrderDaoImpl;

/* 
 * Shows all orders to a manager
 */

@WebServlet("/orderListManager")
public class OrderListManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(OrderListManager.class);   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		OrderDao orderDao = new OrderDaoImpl();

		logger.info("List of all orders");
		request.setAttribute("orders", orderDao.getAllOrders());
		request.getRequestDispatcher("/jsp/manager/orderList.jsp").forward(request, response);;
	}

}
