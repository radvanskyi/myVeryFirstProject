package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import model.dao.CarDao;
import model.dao.ClassDao;
import model.dao.OrderDao;
import model.dao.StatusDao;
import model.dbutil.DataSourceUtil;
import model.entity.Car;

public class CarDaoImpl implements CarDao {

	private DataSource ds = DataSourceUtil.getDataSource();

	@Override
	public Car getCarByModel(String model) {
		Car car = new Car();
		try (Connection con = ds.getConnection()) {
			String sql = "Select * FROM cars WHERE model = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, model);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				executeCar(car, rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return car;
	}

	private void executeCar(Car car, ResultSet rs) throws SQLException {
		ClassDao classDaoImpl = new ClassDaoImpl();
		StatusDao statusDaoImpl = new StatusDaoImpl();
		car.setId(rs.getInt(1));
		car.setMark(rs.getString(2));
		car.setModel(rs.getString(3));
		car.setPrice(rs.getInt(4));
		car.setCarClass(classDaoImpl.getClass(rs.getInt(5)));
		car.setStatus(statusDaoImpl.getById(rs.getInt(6)));
	}

	@Override
	public List<Car> getCarsByClass(String level) {
		List<Car> cars = new ArrayList<>();
		try (Connection con = ds.getConnection()) {
			String sql = "Select * FROM cars WHERE carClass = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.getResultSet();
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Car car = new Car();
				executeCar(car, rs);
				cars.add(car);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cars;
	}

	@Override
	public List<Car> getAllCars() {
		List<Car> cars = new ArrayList<>();
		try (Connection con = ds.getConnection()) {
			String sql = "SELECT * FROM cars";
			PreparedStatement st = con.prepareStatement(sql);
			st.getResultSet();
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Car car = new Car();
				executeCar(car, rs);
				cars.add(car);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cars;
	}

	@Override
	public List<Car> getCarsByPrice(int maxPrice) {
		List<Car> cars = new ArrayList<>();
		try (Connection con = ds.getConnection()) {
			String sql = "Select * FROM cars WHERE price <= ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.getResultSet();
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Car car = new Car();
				executeCar(car, rs);
				cars.add(car);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cars;
	}

	@Override
	public List<Car> getCarsByMark(String mark) {
		List<Car> cars = new ArrayList<>();
		try (Connection con = ds.getConnection()) {
			String sql = "Select * FROM cars WHERE mark = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.getResultSet();
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Car car = new Car();
				executeCar(car, rs);
				cars.add(car);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cars;
	}

	@Override
	public Car add(Car car) {
		try (Connection con = ds.getConnection()) {
			String sql = "INSERT INTO cars (mark, model, price, carClass) VALUES (?, ?, ?, ?)";
			PreparedStatement st = con.prepareStatement(sql);
			int k = 0;
			st.setString(++k, car.getMark());
			st.setString(++k, car.getModel());
			st.setInt(++k, car.getPrice());
			st.setInt(++k, car.getCarClass().getId());
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return car;
	}

	@Override
	public void delete(int id) {
		OrderDao orderDao = new OrderDaoImpl();
		String sql = "DELETE FROM cars WHERE id = ?";
		try (Connection con = ds.getConnection()) {
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			orderDao.delete(id);
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Car car) {
		String sql = "UPDATE cars SET mark = ?, model = ?, price = ?, carClass = ?, status = ? WHERE id = ?";
		try (Connection con = ds.getConnection()) {
			PreparedStatement st = con.prepareStatement(sql);
			int k = 0;
			st.setString(++k, car.getMark());
			st.setString(++k, car.getModel());
			st.setInt(++k, car.getPrice());
			st.setInt(++k, car.getCarClass().getId());
			st.setInt(++k, car.getStatus().getId());
			st.setInt(++k, car.getId());
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Car getById(int id) {
		Car car = new Car();
		try (Connection con = ds.getConnection()) {
			String sql = "Select * FROM cars WHERE id = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				executeCar(car, rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return car;
	}
}
