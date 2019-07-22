package controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import model.dao.UserDao;
import model.dao.impl.UserDaoImpl;
import model.entity.User;

/* 
 * Admin can add new manager 
 */

@WebServlet("/addManager")
public class AddManager extends HttpServlet {
	private static final long serialVersionUID = -9042715943935337228L;
	private static final Logger logger = Logger.getLogger(AddManager.class);
	
	UserDao userDao;
	
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Adding a manager");
		
		User user = new User();
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		user.setFirstName(request.getParameter("firstName"));
		user.setLastName(request.getParameter("lastName"));

		if (user.getFirstName() != "" && user.getLastName() != "" && 
				user.getEmail() != "" && user.getPassword() != "") {
        	if (!userExist(user)) {
				userDao.addManager(user);
				response.sendRedirect(getServletContext().getContextPath() + "/managerList");
			} else {
				logger.error("The user is already exists");
				response.sendRedirect("jsp/error/error.jsp");
			}
        } else {
        	logger.error("Not valid information while adding a manager");
        	response.sendRedirect("jsp/error/error.jsp");
        }
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
