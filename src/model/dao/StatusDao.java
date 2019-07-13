package model.dao;

import java.util.List;

import model.entity.Status;

public interface StatusDao {

	Status getById(int id);
	List<Status> getAll();
}
