package model.dao;

import java.util.List;

import model.entity.User;

public interface UserDao {

    User getUserById(int id);
    List<User> getAllUsers();
    User addUser(User user);
	User getUserByEmail(String email);
	List<User> getUsersByRole(int role);
	void update(User user, int role);
	void delete(int id);
}

