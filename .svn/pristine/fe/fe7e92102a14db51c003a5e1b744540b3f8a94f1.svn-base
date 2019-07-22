package model.dao;

import java.util.List;

import model.entity.User;

public interface UserDao {

    User getUserById(int id);
    List<User> getAllUsers();
    User addUser(User user);
    User addManager(User user);
	User getUserByEmail(String email);
	List<User> getUsersByRole(int role);
	void updateUser(User user);
	void delete(int id);
}

