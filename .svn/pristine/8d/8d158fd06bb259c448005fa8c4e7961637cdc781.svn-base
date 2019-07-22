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
 * Manager can accept customers' orders  
 */

@WebServlet("/confirmOrder")
public class ConfirmOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(ConfirmOrder.class);   
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Order was confirmed");
		int id = Integer.parseInt(request.getParameter("id"));
		
		CheckDao checkDao = new CheckDaoImpl();
		StatusDao statusDao = new StatusDaoImpl();
		Check check = checkDao.getById(id);
		
		check.setStatus(statusDao.getById(Status.ACCEPTED_CHECK_STATUS));
		check.setDescription(Check.ACCEPTED_CHECK);
		checkDao.update(check);
		
		response.sendRedirect(getServletContext().getContextPath() + "/newOrders");		
	}

}
