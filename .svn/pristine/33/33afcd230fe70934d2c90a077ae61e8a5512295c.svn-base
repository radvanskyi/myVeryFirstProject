package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import model.dao.RoleDao;
import model.dao.UserDao;
import model.dbutil.DataSourceUtil;
import model.entity.Role;
import model.entity.User;

public class UserDaoImpl implements UserDao {

    private DataSource ds = DataSourceUtil.getDataSource();

    @Override
    public User getUserById(int id) {
    	String sql = "SELECT * FROM users WHERE id = ?";
        User user = new User();
        try (Connection con = ds.getConnection()) {
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
            	executeUser(user, rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

	private void executeUser(User user, ResultSet rs) throws SQLException {
		RoleDao roleDao = new RoleDaoImpl();
		user.setId(rs.getInt(1));
		user.setEmail(rs.getString(2));
		user.setPassword(rs.getString(3));
		user.setFirstName(rs.getString(4));
		user.setLastName(rs.getString(5));
		user.setRole(roleDao.getById(rs.getInt(6)));
	}

    @Override
    public List<User> getAllUsers() {
    	String sql = "SELECT * FROM users";
        List<User> users = new ArrayList<>();
        try (Connection con = ds.getConnection()){
            PreparedStatement st = con.prepareStatement(sql);
            st.getResultSet();
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                User user = new User();
                executeUser(user, rs);
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    @Override
    public User addUser(User user) {
    	String sql = "INSERT INTO users (email, password, firstName, lastName, role) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = ds.getConnection()) {
        	int k = 0;
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(++k, user.getEmail());
            st.setString(++k, user.getPassword());
            st.setString(++k, user.getFirstName());
            st.setString(++k, user.getLastName());
            st.setInt(++k, Role.CUSTOMER);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

	@Override
	public User getUserByEmail(String email) {
		String sql = "SELECT * FROM users WHERE email = ?";
		User user = new User();
		try (Connection con = ds.getConnection()) {
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, email);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				executeUser(user, rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM users WHERE id = ?";
		try (Connection con = ds.getConnection()) {
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public User addManager(User user) {
		String sql = "INSERT INTO users (email, password, firstName, lastName, role) VALUES (?, ?, ?, ?, ?)";
		try(Connection con = ds.getConnection()) {
			int k = 0;
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(++k, user.getEmail());
            st.setString(++k, user.getPassword());
            st.setString(++k, user.getFirstName());
            st.setString(++k, user.getLastName());
            st.setInt(++k, Role.MANAGER);
            st.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public List<User> getUsersByRole(int role) {
		String sql = "SELECT * FROM users WHERE role = ?";
		List<User> users = new ArrayList<>();
		try (Connection connection = ds.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, role);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				User user = new User();
				executeUser(user, rs);
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public void updateUser(User user) {
		String sql = "UPDATE users SET email = ?, password = ?, firstName = ?, lastName = ?, role = ? WHERE id = ?";
		try (Connection con = ds.getConnection()) {
			int k = 0;
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(++k, user.getEmail());
            st.setString(++k, user.getPassword());
            st.setString(++k, user.getFirstName());
            st.setString(++k, user.getLastName());
            st.setInt(++k, user.getRole().getId());
            st.setInt(++k, user.getId());
            st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
