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

@WebServlet("/cancelOrder")
public class CancelOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
