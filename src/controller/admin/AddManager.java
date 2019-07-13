package controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.UserDao;
import model.dao.impl.UserDaoImpl;
import model.entity.Role;
import model.entity.User;

@WebServlet("/addManager")
public class AddManager extends HttpServlet {

	private static final long serialVersionUID = -9042715943935337228L;

	UserDao userDao;
	
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		User user = new User();
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		user.setFirstName(request.getParameter("firstName"));
		user.setLastName(request.getParameter("lastName"));

        if (user.getFirstName() != "" && user.getLastName() != "" && 
				user.getEmail() != "" && user.getPassword() != "") {
        	
        	userDao = UserDaoImpl.getUserDaoInstance();
        	if (userDao.addUser(user) != null && !userExist(user)) {
        		userDao.update(user, Role.MANAGER);
				response.sendRedirect(getServletContext().getContextPath() + "/managerList");
        	} else {
        		request.setAttribute("errorMsg", "Can't sign up. Such user has already signed up.");
        		request.getRequestDispatcher("/jsp/authentication/registration.jsp").forward(request, response);
        	}
        } else {
        	request.setAttribute("errorMsg", "Please, input data in all fields!");
			request.getRequestDispatcher(getServletContext().getContextPath() + "/jsp/authentication/registration.jsp").forward(request, response);
        }
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
