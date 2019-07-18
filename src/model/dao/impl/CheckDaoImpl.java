package model.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import model.dao.CheckDao;
import model.dao.StatusDao;
import model.dbutil.DataSourceUtil;
import model.entity.Check;

public class CheckDaoImpl implements CheckDao {

	private DataSource ds = DataSourceUtil.getDataSource();
	
	@Override
	public Check createCheck(Check check) {
		String sql = "INSERT INTO checks (date, description, price, status) VALUES (?, ?, ?, ?)";
		int k = 0;
		try(Connection con = ds.getConnection()) {
			PreparedStatement st = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			st.setDate(++k, check.getDate());
			st.setString(++k, check.getDescription());
			st.setInt(++k, check.getPrice());
			st.setInt(++k,  check.getStatus().getId());
			st.executeUpdate();
			
			ResultSet rs = st.getGeneratedKeys();
			if (rs.next()) {
				int id = rs.getInt(1);
				check.setId(id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public Check getById(int id) {
		String sql = "SELECT * FROM checks WHERE id = ?";
		Check check = new Check();
		try(Connection con = ds.getConnection()) {
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				executeCheck(check, rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return check;
	}

	private void executeCheck(Check check, ResultSet rs) throws SQLException {
		StatusDao statusDao = new StatusDaoImpl();
		check.setId(rs.getInt(1));
		check.setDate(rs.getDate(2));
		check.setDescription(rs.getString(3));
		check.setPrice(rs.getInt(4));
		check.setStatus(statusDao.getById(rs.getInt(5)));
	}

	@Override
	public List<Check> getAllChecks() {
		String sql = "SELECT * FROM checks";
		List<Check> checks	= new ArrayList<>();
		try(Connection con = ds.getConnection()) {
			PreparedStatement st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				Check check = new Check();
				executeCheck(check, rs);
				checks.add(check);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return checks;
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM checks WHERE id = ?";
		try (Connection con = ds.getConnection()) {
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Check check) {
		String sql = "UPDATE checks SET date = ?, description = ?, price = ?, status = ? WHERE id = ?";
		int k = 0;
		try(Connection con = ds.getConnection()) {
			PreparedStatement st = con.prepareStatement(sql);
			st.setDate(++k, new Date(check.getDate().getTime()));
            st.setString(++k, check.getDescription());
            st.setInt(++k, check.getPrice());
            st.setInt(++k, check.getStatus().getId());
            st.setInt(++k, check.getId());
            st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
