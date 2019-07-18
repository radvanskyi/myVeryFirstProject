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

@WebServlet("/newOrders")
public class NewOrders extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Check> checks = new ArrayList<>();
		OrderDao orderDao = new OrderDaoImpl();

		for (Order o : orderDao.getAllOrders()) {
			checks.add(o.getCheck());
		}

		List<Check> unpaid = new ArrayList<>();
		List<Check> returned = new ArrayList<>();

		for (Check c : checks) {
			c.setOrders((List<Order>) orderDao.getByCheck(c.getId()));
			if (c.getStatus().getName().equals("not paid")) {
				unpaid.add(c);
			}
			if (c.getStatus().getName().equals("success")) {
				for (Order o : c.getOrders()) {
					if (o.getStatus().getName().equals("returned")) {
						returned.add(c);
					}
				}
			}
		}

		request.setAttribute("unpaid", unpaid);
		request.setAttribute("returned", returned);

		request.getRequestDispatcher("/jsp/manager/newOrders.jsp").forward(request, response);
	}

}
