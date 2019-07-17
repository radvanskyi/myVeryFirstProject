package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/return")
public class Return extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String role = (String) request.getSession().getAttribute("role");

        if (role != null) {
            switch (role) {
                case "customer":
                    response.sendRedirect(getServletContext().getContextPath() + "/customer");
                    break;
                case "admin":
                    response.sendRedirect(getServletContext().getContextPath() + "/admin");
                    break;
                case "manager":
                    response.sendRedirect(getServletContext().getContextPath() + "/manager");
                    break;
            }
        } else {
            response.sendRedirect(getServletContext().getContextPath());
        }
    }
}
