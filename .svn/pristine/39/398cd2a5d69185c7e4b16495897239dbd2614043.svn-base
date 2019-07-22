package controller.manager;

import java.io.IOException;
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
import model.dao.impl.CheckDaoImpl;
import model.dao.impl.OrderDaoImpl;
import model.entity.Check;
import model.entity.Order;

/* 
 * Shows new orders to a manager
 */

@WebServlet("/newOrders")
public class NewOrders extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(NewOrders.class);   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Check> checks = new ArrayList<>();
		OrderDao orderDao = new OrderDaoImpl();
		CheckDao checkDao = new CheckDaoImpl();

		for (Order o : orderDao.getAllOrders()) {
			checks.add(o.getCheck());
		}

		List<Check> unpaid = new ArrayList<>(checkDao.getUnpaid());
		List<Order> returned = new ArrayList<>(orderDao.getReturned());

		for (Check c : unpaid) {
			c.setOrders((List<Order>) orderDao.getByCheck(c.getId()));
		}

		request.setAttribute("unpaid", unpaid);
		request.setAttribute("returned", returned);
		logger.info("List of new orders");
		request.getRequestDispatcher("/jsp/manager/newOrders.jsp").forward(request, response);
	}

}
