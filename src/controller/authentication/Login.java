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

import model.dao.UserDao;
import model.dao.impl.UserDaoImpl;
import model.entity.User;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserDao userDao;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		userDao = UserDaoImpl.getUserDaoInstance();
		Locale locale = new Locale(request.getParameter("locale"));
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		User user = userDao.getUserByEmail(email);
		if (user != null && !user.getRole().getName().equals("blocked")) {
			loginUser(request, response, password, user, locale);
		} else {
			forwardBackToLoginWhenError(request, response);
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
			response.sendRedirect(getServletContext().getContextPath() + "/admin");
			break;
		case "customer":
			response.sendRedirect(getServletContext().getContextPath() + "/carList");
			break;
		case "manager":
			response.sendRedirect(getServletContext().getContextPath() + "/orderList");
			break;
		}
	}

	private void forwardBackToLoginWhenError(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("errorMsg", "Password or Email is not valid");
		request.getRequestDispatcher("jsp/authentication/login.jsp").forward(request, response);
	}
}
