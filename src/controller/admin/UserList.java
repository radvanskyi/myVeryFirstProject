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
import model.entity.User;

/* 
 * List of all customers
 */

@WebServlet("/userList")
public class UserList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(UserList.class);   
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("List of all customers");
		
		UserDao userDao = new UserDaoImpl();
		List<User> list = new ArrayList<>();
		List<User> tempList = new ArrayList<>(userDao.getAllUsers());
		for (User user : tempList) {
			if (user.getRole().getName().equals("customer") || user.getRole().getName().equals("blocked")) {
				list.add(user);
			}
		}
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("jsp/admin/userList.jsp").forward(request, response);
	}
}
