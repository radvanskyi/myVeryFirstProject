package controller.manager;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import model.dao.CarDao;
import model.dao.CheckDao;
import model.dao.OrderDao;
import model.dao.StatusDao;
import model.dao.impl.CarDaoImpl;
import model.dao.impl.CheckDaoImpl;
import model.dao.impl.OrderDaoImpl;
import model.dao.impl.StatusDaoImpl;
import model.entity.Check;
import model.entity.Order;
import model.entity.Status;

/* 
 * Servlet approves cars' return by user
 */
@WebServlet("/finishOrder")
public class FinishOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(FinishOrder.class);    
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CheckDao checkDao = new CheckDaoImpl();
		OrderDao orderDao = new OrderDaoImpl();
		CarDao carDao = new CarDaoImpl();
		StatusDao statusDao = new StatusDaoImpl();
		
		int id = Integer.parseInt(request.getParameter("id"));
		Check check = checkDao.getById(id);

		check.setOrders(orderDao.getByCheck(id));
		for (Order o : check.getOrders()) {
			if (!o.getStatus().getName().equals("repair")) {
				o.getCar().setStatus(statusDao.getById(Status.DEFAULT_CAR_STATUS));
				carDao.update(o.getCar());
				o.setStatus(statusDao.getById(Status.RENT_ORDER_STATUS));
				orderDao.update(o);
			}
		}
		
		check.setStatus(statusDao.getById(Status.SUCCESS_CHECK_STATUS));
		check.setDescription(Check.SUCCESS_CAR_APPROV);
		checkDao.update(check);
		logger.info("order was finished");
		request.getRequestDispatcher("/jsp/manager/newOrders.jsp").forward(request, response);
	}

}
