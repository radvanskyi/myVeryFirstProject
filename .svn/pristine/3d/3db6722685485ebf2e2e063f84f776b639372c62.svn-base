package model.entity;

import java.io.Serializable;
import java.util.List;

public class Status implements Serializable {

	private static final long serialVersionUID = -7143212818468087330L;

	public static final int DEFAULT_CAR_STATUS = 0;
	public static final int DISABLED_CAR_STATUS = 1;
	public static final int RENT_ORDER_STATUS = 2;
	public static final int REPAIR_ORDER_STATUS = 3;
	public static final int DEFAULT_CHECK_STATUS = 4;
	public static final int PAID_CHECK_STATUS = 5;
	public static final int CANCELED_CHECK_STATUS = 6;
	public static final int ACCEPTED_CHECK_STATUS = 7;
	public static final int SUCCESS_CHECK_STATUS = 8;
	public static final int RETURN_ORDER_STATUS = 9;
	public static final int WAIT_ORDER_STATUS = 10;
	
	private int id;
	private String name;
	private List<Car> cars;
	private List<Order> orders;
	private List<Check> checks;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Car> getCars() {
		return cars;
	}
	public void setCars(List<Car> cars) {
		this.cars = cars;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	public List<Check> getChecks() {
		return checks;
	}
	public void setChecks(List<Check> checks) {
		this.checks = checks;
	}
}
