package controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.RoleDao;
import model.dao.UserDao;
import model.dao.impl.RoleDaoImpl;
import model.dao.impl.UserDaoImpl;
import model.entity.Role;
import model.entity.User;

@WebServlet("/blockUser")
public class BlockUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		UserDao userDao = new UserDaoImpl();
		RoleDao roleDao = new RoleDaoImpl();
		User user = userDao.getUserById(id);
		
		if (user.getRole().getName().equals("blocked")) {
			user.setRole(roleDao.getById(Role.CUSTOMER));
			userDao.updateUser(user);
		} else {
			user.setRole(roleDao.getById(Role.BLOCKED));
			userDao.updateUser(user);
		}
		response.sendRedirect(getServletContext().getContextPath() + "/userList");
	}

}
