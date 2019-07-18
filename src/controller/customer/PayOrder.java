package controller.customer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.CarDao;
import model.dao.CheckDao;
import model.dao.OrderDao;
import model.dao.StatusDao;
import model.dao.impl.CarDaoImpl;
import model.dao.impl.CheckDaoImpl;
import model.dao.impl.OrderDaoImpl;
import model.dao.impl.StatusDaoImpl;
import model.entity.Car;
import model.entity.Check;
import model.entity.Order;
import model.entity.Status;

@WebServlet("/payOrder")
public class PayOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CheckDao checkDao = new CheckDaoImpl();
		StatusDao statusDao = new StatusDaoImpl();
		OrderDao orderDao = new OrderDaoImpl();
		CarDao carDao = new CarDaoImpl();

		int id = Integer.parseInt(request.getParameter("id"));
		String repair = request.getParameter("repair");
		Car car;
		
		Check check = checkDao.getById(id);
		check.setOrders(orderDao.getByCheck(id));
		
		if (repair == null) {
			for (Order o : check.getOrders()) {
				car = o.getCar();
				car.setStatus(statusDao.getById(Status.DISABLED_CAR_STATUS));
				carDao.update(car);
			}
			check.setStatus(statusDao.getById(Status.PAID_CHECK_STATUS));
			check.setDescription(Check.PAID_CHECK);
			
			checkDao.update(check);
		} else {
			for(Order o : check.getOrders()) {
				car = o.getCar();
				car.setStatus(statusDao.getById(Status.DEFAULT_CAR_STATUS));
				carDao.update(car);
			}
			check.setStatus(statusDao.getById(Status.SUCCESS_CHECK_STATUS));
			check.setDescription(Check.REPAIR_SUCCESS);
			checkDao.update(check);
		}
		
		response.sendRedirect(getServletContext().getContextPath() + "/userOrders");
	}

}
