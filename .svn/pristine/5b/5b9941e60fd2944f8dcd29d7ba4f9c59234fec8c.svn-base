package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/* 
 * Servlet returns users on their pages 
 * according to their roles
 * or on the login page if user
 * doesn't log in 
 */
@WebServlet("/return")
public class Return extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(Return.class);   
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String role = (String) request.getSession().getAttribute("role");

        if (role != null) {
            switch (role) {
                case "customer":
                	logger.info("==> customer");
                    response.sendRedirect(getServletContext().getContextPath() + "/customer");
                    break;
                case "admin":
                	logger.info("==> admin");
                    response.sendRedirect(getServletContext().getContextPath() + "/admin");
                    break;
                case "manager":
                	logger.info("==> manager");
                    response.sendRedirect(getServletContext().getContextPath() + "/manager");
                    break;
            }
        } else {
        	logger.info("Nobody logged in");
            response.sendRedirect(getServletContext().getContextPath());
        }
    }
}
