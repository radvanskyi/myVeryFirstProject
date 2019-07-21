package controller.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import model.dao.UserDao;
import model.dao.impl.UserDaoImpl;
import model.entity.Role;
import model.entity.User;

/* 
 * List of all managers
 */

@WebServlet("/managerList")
public class ManagerList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(ManagerList.class);   
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("List of all managers");
		
		UserDao userDao = new UserDaoImpl();
		List<User> list = new ArrayList<>(userDao.getUsersByRole(Role.MANAGER));
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("jsp/admin/managerList.jsp").forward(request, response);
	}
}
