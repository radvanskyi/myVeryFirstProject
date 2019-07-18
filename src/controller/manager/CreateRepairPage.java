package controller.manager;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.OrderDao;
import model.dao.impl.OrderDaoImpl;
import model.entity.Order;

@WebServlet("/createRepairPage")
public class CreateRepairPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderDao orderDao = new OrderDaoImpl();
		int id = Integer.parseInt(request.getParameter("id"));
		Order order = orderDao.getById(id);
		
		request.setAttribute("order", order);
		request.getRequestDispatcher("/jsp/manager/repairPage.jsp").forward(request, response);
	}

}
