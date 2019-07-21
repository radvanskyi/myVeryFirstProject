package controller.authentication;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import model.dao.UserDao;
import model.dao.impl.UserDaoImpl;
import model.entity.User;

/* 
 * Log in servlet. Redirect users according their roles
 */

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(Login.class);   
	
	private UserDao userDao;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		userDao = new UserDaoImpl();
		Locale locale = new Locale(request.getParameter("locale"));
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		User user = userDao.getUserByEmail(email);
		if (user.getFirstName() == null && user.getLastName() == null && user.getPassword() == null) {
			forwardBackToLoginWhenError(request, response);
		} else if (!user.getRole().getName().equals("blocked")) {
			loginUser(request, response, password, user, locale);
		} else {
			response.sendRedirect("jsp/error/error.jsp");
		}
	}

	private void loginUser(HttpServletRequest request, HttpServletResponse response, String password, User user, Locale locale)
			throws ServletException, IOException {
		if (user.getPassword() != null && user.getPassword().equals(password)) {
			HttpSession session = request.getSession();
			session.setAttribute("locale", locale);
			session.setAttribute("email", user.getEmail());
			session.setAttribute("role", user.getRole().getName());
			Cookie cookie = new Cookie("email", user.getEmail());
			response.addCookie(cookie);
			redirectUserByRole(response, user);
		} else {
			forwardBackToLoginWhenError(request, response);
		}
	}

	private void redirectUserByRole(HttpServletResponse response, User user) throws IOException {
		switch (user.getRole().getName()) {
		case "admin":
			logger.info("Admin");
			response.sendRedirect(getServletContext().getContextPath() + "/admin");
			break;
		case "customer":
			logger.info("Customer");
			response.sendRedirect(getServletContext().getContextPath() + "/customer");
			break;
		case "manager":
			logger.info("Manager");
			response.sendRedirect(getServletContext().getContextPath() + "/manager");
			break;
		}
	}

	private void forwardBackToLoginWhenError(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		logger.info("Wrong input data while login");
		response.sendRedirect("jsp/error/error.jsp");
	}
}
