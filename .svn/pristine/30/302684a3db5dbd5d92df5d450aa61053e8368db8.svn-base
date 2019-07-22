package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import model.dao.RoleDao;
import model.dbutil.DataSourceUtil;
import model.entity.Role;

public class RoleDaoImpl implements RoleDao {
			
	DataSource ds = DataSourceUtil.getDataSource();
	
	@Override
	public Role getById(int id) {
		String sql = "SELECT * FROM roles WHERE id = ?";
		Role role = new Role();
		try (Connection con = ds.getConnection()) {
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				executeRole(rs, role);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return role;
	}

	@Override
	public List<Role> getAllRoles() {
		String sql = "SELECT * FROM roles";
		List <Role> roles = new ArrayList<>();
		try (Connection con = ds.getConnection()) {
			PreparedStatement st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Role role = new Role();
				executeRole(rs, role);
		        roles.add(role);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return roles;
	}

	private void executeRole(ResultSet rs, Role role) throws SQLException {
		role.setId(rs.getInt(1));
		role.setName(rs.getString(2));
	}
}
