package controller.authentication;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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

		userDao = UserDaoImpl.getUserDaoInstance();
		if (user.getFirstName() != "" && user.getLastName() != "" && 
				user.getEmail() != "" && user.getPassword() != "") {
			
			if (userDao.addUser(user) != null && !userExist(user)) {
				response.sendRedirect(getServletContext().getContextPath() + "/jsp/authentication/successRegistration.jsp");
			} else {
				forwardBackToLoginWhenError(request, response);
			}
			
		} else {
			forwardBackToLoginWhenError(request, response);
		}
	}

	private void forwardBackToLoginWhenError(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/authentication/registration.jsp");
		rd.forward(request, response);
	}
	
	private boolean userExist(User user) {
		User user2 = new User();
		userDao = UserDaoImpl.getUserDaoInstance();
		user2 = userDao.getUserByEmail(user.getEmail());
		if (user.getEmail().equals(user2.getEmail())) {
			return true;
		} else {
			return false;
		}
	}
}
