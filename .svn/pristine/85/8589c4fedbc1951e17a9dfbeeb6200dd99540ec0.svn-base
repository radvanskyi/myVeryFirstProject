package controller.customer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import model.dao.OrderDao;
import model.dao.impl.OrderDaoImpl;
import model.entity.Order;
import model.entity.Status;

/* 
 * A customer can delete his orders before payment  
 */

@WebServlet("/deleteTempOrders")
public class DeleteTempOrders extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(DeleteTempOrders.class);   
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderDao orderDao = new OrderDaoImpl();
		String email = (String)request.getSession().getAttribute("email");
		
		for (Order o : orderDao.getAllOrders()) {
			if (o.getUser().getEmail().equals(email) && o.getStatus().getId() == (Status.WAIT_ORDER_STATUS)) {
				logger.info("Deleting temp orders");
				orderDao.delete(o.getId());
			}
		}
		
		response.sendRedirect(getServletContext().getContextPath() + "/userOrders");
	}

}
