package model.entity;

import java.io.Serializable;
import java.util.List;

public class Car implements Serializable {
	
	private static final long serialVersionUID = 2549828747875585203L;
	
	private int id;
	private String mark;
	private String model;
	private int price;
	private CarClass carClass;
	private Status status;
	private List<Order> orders;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public CarClass getCarClass() {
		return carClass;
	}
	public void setCarClass(CarClass carClass) {
		this.carClass = carClass;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	@Override
	public String toString() {
		return "Car [id=" + id + ", mark=" + mark + ", model=" + model + ", price=" + price + ", carClass=" + carClass
				+ ", status=" + status + ", orders=" + orders + "]";
	}
}
