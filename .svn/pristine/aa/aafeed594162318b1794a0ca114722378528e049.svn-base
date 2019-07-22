package controller.customer;

import java.io.IOException;

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
 * Allows a customer to return a car back  
 */

@WebServlet("/returnCar")
public class ReturnCar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(ReturnCar.class);   
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CheckDao checkDao = new CheckDaoImpl();
		OrderDao orderDao = new OrderDaoImpl();
		StatusDao statusDao = new StatusDaoImpl();
		
		int id = Integer.parseInt(request.getParameter("id"));
		Check check = checkDao.getById(id);
		
		check.setStatus(statusDao.getById(Status.SUCCESS_CHECK_STATUS));
		check.setDescription(Check.WAITING_CAR_APPROV);
		checkDao.update(check);
		
		check.setOrders(orderDao.getByCheck(id));
		for (Order o : check.getOrders()) {
			o.setStatus(statusDao.getById(Status.RETURN_ORDER_STATUS));
			orderDao.update(o);
		}
		logger.info("Car was retuned");
		response.sendRedirect(getServletContext().getContextPath() + "/userOrders");
	}

}
