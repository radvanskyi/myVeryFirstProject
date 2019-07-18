package controller.manager;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.CheckDao;
import model.dao.OrderDao;
import model.dao.StatusDao;
import model.dao.impl.CheckDaoImpl;
import model.dao.impl.OrderDaoImpl;
import model.dao.impl.StatusDaoImpl;
import model.entity.Check;
import model.entity.Order;
import model.entity.Status;

@WebServlet("/repairOrder")
public class RepairOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CheckDao checkDao = new CheckDaoImpl();
		OrderDao orderDao = new OrderDaoImpl();
		StatusDao statusDao = new StatusDaoImpl();
		
		int id = Integer.parseInt(request.getParameter("id"));
		Order order = orderDao.getById(id);
		order.setStatus(statusDao.getById(Status.REPAIR_ORDER_STATUS));
		orderDao.update(order);
		
		List<Order> orders = new ArrayList<>();
		orders.add(order);
		
		Check check = new Check();
		check.setOrders(orders);
		check.setDate(new Date(System.currentTimeMillis()));
		check.setDescription(Check.REPAIR_CHECK);
		check.setPrice(Integer.parseInt(request.getParameter("price")));
		check.setStatus(statusDao.getById(Status.ACCEPTED_CHECK_STATUS));
		checkDao.createCheck(check);
		
		order.setPassport(order.getPassport());
		order.setStartDate(order.getStartDate());
		order.setEndDate(order.getEndDate());
		order.setDriver(false);
		orderDao.createOrder(order);
		
		order.setCheck(check);
		orderDao.update(order);

		request.getRequestDispatcher("/jsp/manager/newOrders.jsp").forward(request, response);
	}

}
