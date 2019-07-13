package model.dao;

import java.util.List;

import model.entity.Role;

public interface RoleDao {

	Role getById(int id);
	List<Role> getAllRoles();
}
