package model.dao;

import java.util.List;

import model.entity.Check;

public interface CheckDao {
	
	Check createCheck(Check check);
	Check getById(int id);
	List<Check> getAllChecks();
	void update(Check check);
	void delete(int id);
}
