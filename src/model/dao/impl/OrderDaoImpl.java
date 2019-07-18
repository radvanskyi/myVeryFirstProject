package model.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import model.dao.CarDao;
import model.dao.CheckDao;
import model.dao.OrderDao;
import model.dao.StatusDao;
import model.dao.UserDao;
import model.dbutil.DataSourceUtil;
import model.entity.Order;

public class OrderDaoImpl implements OrderDao {
	
	DataSource ds = DataSourceUtil.getDataSource();
	UserDao userDao = new UserDaoImpl();
	CheckDao checkDao = new CheckDaoImpl();
	CarDao carDao = new CarDaoImpl();
	StatusDao statusDao = new StatusDaoImpl();

	@Override
	public Order createOrder(Order order) {
		String sql = "INSERT INTO orders (passport, user_id, car, startDate, endDate, driver, status) VALUES (?, ?, ?, ?, ?, ?, ?)";
		int k = 0;
		try (Connection con = ds.getConnection()) {
			PreparedStatement st = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			st.setString(++k, order.getPassport());
			st.setInt(++k, order.getUser().getId());
			st.setInt(++k, order.getCar().getId());
			st.setDate(++k, order.getStartDate());
			st.setDate(++k, order.getEndDate());
			st.setBoolean(++k, order.isDriver());
			st.setInt(++k, order.getStatus().getId());
			st.executeUpdate();
			
			ResultSet rs = st.getGeneratedKeys();
			if (rs.next()) {
				int id = rs.getInt(1);
				order.setId(id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return order;
	}

	@Override
	public Order getById(int id) {
		Order order = new Order();
		String sql = "SELECT * FROM orders WHERE id = ?";
		try (Connection con = ds.getConnection()) {
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
		        executeOrder(order, rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return order;
	}

	private void executeOrder(Order order, ResultSet rs) throws SQLException {
		order.setId(rs.getInt(1));
		order.setPassport(rs.getString(2));
		order.setUser(userDao.getUserById(rs.getInt(3)));
		order.setCheck(checkDao.getById(rs.getInt(4)));
		order.setCar(carDao.getById(rs.getInt(5)));
		order.setStartDate(rs.getDate(6));
		order.setEndDate(rs.getDate(7));
		order.setDriver(rs.getBoolean(8));
		order.setStatus(statusDao.getById(rs.getInt(9)));
	}

	@Override
	public List<Order> getByCheck(int id) {
		List<Order> orders = new ArrayList<>();
		String sql = "SELECT * FROM orders WHERE check_id = ?";
		try (Connection con = ds.getConnection()) {
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Order order = new Order();
		        executeOrder(order, rs);
		        orders.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orders;
	}

	@Override
	public List<Order> getAllOrders() {
		List<Order> orders = new ArrayList<>();
		String sql = "SELECT * FROM orders";
		try (Connection con = ds.getConnection()) {
			PreparedStatement st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Order order = new Order();
		        executeOrder(order, rs);
		        orders.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orders;
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM orders WHERE id = ?";
		try (Connection con = ds.getConnection()) {
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void deleteByCarId(int id) {
		String sql = "DELETE FROM orders WHERE car = ?";
		try (Connection con = ds.getConnection()) {
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Order order) {
		String sql = "UPDATE orders SET passport = ?, user_id = ?, check_id = ?, car = ?, startDate = ?, endDate = ?, driver = ?, status = ? WHERE id = ?";
		try (Connection con = ds.getConnection()) {
			int k = 0;
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(++k, order.getPassport());
            st.setInt(++k, order.getUser().getId());
            st.setInt(++k, order.getCheck().getId());
            st.setInt(++k, order.getCar().getId());
            st.setDate(++k, new Date(order.getStartDate().getTime()));
            st.setDate(++k, new Date(order.getEndDate().getTime()));
            st.setBoolean(++k, order.isDriver());
            st.setInt(++k, order.getStatus().getId());
            st.setInt(++k, order.getId());
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} 

}
