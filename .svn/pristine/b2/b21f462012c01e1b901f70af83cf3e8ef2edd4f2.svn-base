package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import model.dao.StatusDao;
import model.dbutil.DataSourceUtil;
import model.entity.Status;

public class StatusDaoImpl implements StatusDao {
	
	DataSource ds = DataSourceUtil.getDataSource();

	@Override
	public Status getById(int id) {
		String sql = "SELECT * FROM statuses WHERE id = ?";
		Status status = new Status();
		try (Connection con = ds.getConnection()) {
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				status.setId(rs.getInt(1));
				status.setName(rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public List<Status> getAll() {
		String sql = "SELECT * FROM statuses";
		List<Status> statuses = new ArrayList<>();
		try (Connection con = ds.getConnection()) {
			PreparedStatement st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				Status status = new Status();
		        status.setId(rs.getInt(1));
		        status.setName(rs.getString(2));
		        statuses.add(status);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return statuses;
	}
}
