package model.dao;

import java.util.List;

import model.entity.Car;

public interface CarDao {

	Car getById(int id);
	Car getCarByModel(String model);
	List<Car> getCarsByClass(String c);
	List<Car> getAllCars();
	List<Car> getCarsByPrice(int maxPrice);
	List<Car> getCarsByMark(String mark);
	Car add(Car car);
	void update(Car car);
	void delete(int id);
}
