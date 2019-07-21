package controller.manager;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import model.dao.CheckDao;
import model.dao.StatusDao;
import model.dao.impl.CheckDaoImpl;
import model.dao.impl.StatusDaoImpl;
import model.entity.Check;
import model.entity.Status;

/* 
 * Manager can decline customers' orders  
 */

@WebServlet("/cancelOrder")
public class CancelOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(CancelOrder.class);   
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Order was canceled by manager");
		int id = Integer.parseInt(request.getParameter("id"));
		String description = Check.CANCELED_CHECK;
		
		CheckDao checkDao = new CheckDaoImpl();
		Check check = checkDao.getById(id);
		StatusDao statusDao = new StatusDaoImpl();
		
		check.setDescription(description);
		check.setStatus(statusDao.getById(Status.CANCELED_CHECK_STATUS));
		checkDao.update(check);
		
		request.getRequestDispatcher("/jsp/manager/newOrders.jsp").forward(request, response);
	}

}
