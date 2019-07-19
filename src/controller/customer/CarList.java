package controller.customer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.CarDao;
import model.dao.impl.CarDaoImpl;
import model.entity.Car;

@WebServlet("/carList")
public class CarList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CarDao carDao = new CarDaoImpl();
		List<Car> cars = new ArrayList<>(carDao.getAllCars());
		request.setAttribute("cars", cars);
		
		setMarks(request, cars);
		setClasses(request, cars);
		
		request.getRequestDispatcher("jsp/customer/carList.jsp").forward(request, response);
	}

	void setClasses(HttpServletRequest request, List<Car> list) {
		Set<String> classes = new HashSet<>();
		for (Car c : list) {
			classes.add(c.getCarClass().getName());
		}
		request.setAttribute("classes", classes);
	}

	void setMarks(HttpServletRequest request, List<Car> list) {
		Set<String> marks = new HashSet<>();
		for (Car c : list) {
			marks.add(c.getMark());
		}
		request.setAttribute("marks", marks);
	}
}
