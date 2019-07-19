package controller.customer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.entity.Car;

@WebServlet("/carSort")
public class CarSort extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Car> list = new ArrayList<>();
		Iterator<Car> it = list.iterator();
		
		if (request.getParameter("mark") != null) {
			while(it.hasNext()) {
				if(!it.next().getMark().equals(request.getParameter("mark"))) {
					it.remove();
				}
			}
			request.setAttribute("list", list);
		}
		
		if (request.getParameter("carClass") != null) {
			while(it.hasNext()) {
				if(it.next().getCarClass().getName().equals(request.getParameter("carClass"))) {
					it.remove();
				}
			}
			request.setAttribute("list", list);
		}
		
		if (Boolean.valueOf(request.getParameter("price"))) {
			List<Car> carsByPrice = new ArrayList<>();
			Collections.sort(carsByPrice, new Comparator<Car>() {
				@Override
				public int compare(Car c1, Car c2) {
					return c1.getPrice() - c2.getPrice();
				}
			});
			request.setAttribute("list", carsByPrice);
		}
		
		if (Boolean.valueOf(request.getParameter("model"))) {
			List<Car> carsByModel = new ArrayList<>();
			Collections.sort(carsByModel, new Comparator<Car>() {
				@Override
				public int compare(Car c1, Car c2) {
					return c1.getModel().compareTo(c2.getModel());
				}
			});
			request.setAttribute("list", carsByModel);
		}
		
		CarList carList = new CarList();
		carList.setMarks(request, list);
		carList.setClasses(request, list);
		
		request.getRequestDispatcher("/jsp/customer/carList.jsp").forward(request, response);
	}
}
