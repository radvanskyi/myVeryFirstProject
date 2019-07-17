package controller.customer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.OrderDao;
import model.dao.impl.OrderDaoImpl;
import model.entity.Order;
import model.entity.Status;

@WebServlet("/deleteTempOrders")
public class DeleteTempOrders extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderDao orderDao = new OrderDaoImpl();
		String email = (String)request.getSession().getAttribute("email");
		
		for (Order o : orderDao.getAllOrders()) {
			if (o.getUser().getEmail().equals(email) && o.getStatus().getId() == (Status.WAIT_ORDER_STATUS)) {
				orderDao.delete(o.getId());
			}
		}
		
		response.sendRedirect(getServletContext().getContextPath() + "/userOrders");
	}

}
