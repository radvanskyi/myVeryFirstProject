package model.dao;

import java.util.List;

import model.entity.Car;

public interface CarDao {

	Car getById(int id);
	List<Car> getAllCars();
	Car add(Car car);
	void update(Car car);
	void delete(int id);
}
