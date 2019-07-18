package controller.manager;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.CheckDao;
import model.dao.StatusDao;
import model.dao.impl.CheckDaoImpl;
import model.dao.impl.StatusDaoImpl;
import model.entity.Check;
import model.entity.Status;

@WebServlet("/confirmOrder")
public class ConfirmOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		CheckDao checkDao = new CheckDaoImpl();
		StatusDao statusDao = new StatusDaoImpl();
		Check check = checkDao.getById(id);
		
		check.setStatus(statusDao.getById(Status.ACCEPTED_CHECK_STATUS));
		check.setDescription(Check.ACCEPTED_CHECK);
		checkDao.update(check);
		
		request.getRequestDispatcher("/jsp/manager/newOrders.jsp").forward(request, response);
	}

}
