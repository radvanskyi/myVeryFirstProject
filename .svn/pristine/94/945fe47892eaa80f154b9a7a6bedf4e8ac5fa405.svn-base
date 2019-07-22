package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import model.dao.ClassDao;
import model.dbutil.DataSourceUtil;
import model.entity.CarClass;

public class ClassDaoImpl implements ClassDao {
	
	DataSource ds = DataSourceUtil.getDataSource();

	@Override
	public CarClass getClass(int id) {
		String sql = "SELECT * FROM classes WHERE id = ?";
		CarClass carClass = new CarClass();
		try (Connection con = ds.getConnection()) {
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				carClass.setId(rs.getInt(1));
				carClass.setName(rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return carClass;
	}

	@Override
	public List<CarClass> getAll() {
		String sql = "SELECT * FROM classes";
		List<CarClass> carClasses = new ArrayList<>();
		try (Connection con = ds.getConnection()) {
			PreparedStatement st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				CarClass carClass = new CarClass();
				carClass.setId(rs.getInt(1));
				carClass.setName(rs.getString(2));
				carClasses.add(carClass);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return carClasses;
	}
}
