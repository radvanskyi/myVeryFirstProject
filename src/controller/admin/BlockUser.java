package controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import model.dao.RoleDao;
import model.dao.UserDao;
import model.dao.impl.RoleDaoImpl;
import model.dao.impl.UserDaoImpl;
import model.entity.Role;
import model.entity.User;

/* 
 * The admin can block or unblock a customer
 */

@WebServlet("/blockUser")
public class BlockUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(BlockUser.class);
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		UserDao userDao = new UserDaoImpl();
		RoleDao roleDao = new RoleDaoImpl();
		User user = userDao.getUserById(id);
		
		if (user.getRole().getName().equals("blocked")) {
			logger.info("Unblocking a customer");
			user.setRole(roleDao.getById(Role.CUSTOMER));
			userDao.updateUser(user);
		} else {
			logger.info("Blocking a customer");
			user.setRole(roleDao.getById(Role.BLOCKED));
			userDao.updateUser(user);
		}
		response.sendRedirect(getServletContext().getContextPath() + "/userList");
	}

}
