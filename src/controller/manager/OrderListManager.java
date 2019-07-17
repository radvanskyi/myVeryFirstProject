package controller.manager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.CheckDao;
import model.dao.OrderDao;
import model.dao.impl.CheckDaoImpl;
import model.dao.impl.OrderDaoImpl;
import model.entity.Check;
import model.entity.Order;

@WebServlet("/orderListManager")
public class OrderListManager extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CheckDao checkDao = new CheckDaoImpl();
		List<Check> checks = new ArrayList<>(checkDao.getAllChecks());
		OrderDao orderDao = new OrderDaoImpl();

		for (Order o : orderDao.getAllOrders()) {
			checks.add(o.getCheck());
		}

		for (Check c : checks) {
			c.setOrders((List<Order>) orderDao.getByCheck(c.getId()));
		}

		request.setAttribute("checks", checks);
		request.getRequestDispatcher("/jsp/manager/orderList.jsp").forward(request, response);;
	}

}
