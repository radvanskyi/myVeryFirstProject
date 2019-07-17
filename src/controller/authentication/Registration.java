package controller.authentication;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.UserDao;
import model.dao.impl.UserDaoImpl;
import model.entity.User;

@WebServlet("/registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserDao userDao;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = new User();
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		user.setFirstName(request.getParameter("firstName"));
		user.setLastName(request.getParameter("lastName"));

		userDao = new UserDaoImpl();
		if (user.getFirstName() != "" && user.getLastName() != "" && 
				user.getEmail() != "" && user.getPassword() != "") {
			
			if (!userExist(user)) {
				userDao.addUser(user);
				response.sendRedirect(getServletContext().getContextPath() + "/successRegistration");
			} else {
				forwardBackToLoginWhenError(request, response);
			}
			
		} else {
			forwardBackToLoginWhenError(request, response);
		}
	}

	private void forwardBackToLoginWhenError(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("jsp/error/error.jsp");
	}
	
	private boolean userExist(User user) {
		User user2 = new User();
		userDao = new UserDaoImpl();
		user2 = userDao.getUserByEmail(user.getEmail());
		if (user.getEmail().equals(user2.getEmail())) {
			return true;
		} else {
			return false;
		}
	}
}
