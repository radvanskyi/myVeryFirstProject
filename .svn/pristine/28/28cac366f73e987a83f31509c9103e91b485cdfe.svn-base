package model.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class Check implements Serializable {

	private static final long serialVersionUID = 8819971036890042534L;

	public static final String NEW_CHECK = "Waiting for acception";
	public static final String CANCELED_CHECK = "The check was canceled";
	public static final String ACCEPTED_CHECK = "The check was accepted";
	public static final String PAID_CHECK = "Payment was successful";
	public static final String WAITING_CAR_APPROV = "Car is waiting for manager approving";
	public static final String SUCCESS_CAR_APPROV = "Car was approved by manager. Thank you for using our services!";
	public static final String REPAIR_CHECK = "Car was returned with damage, the new check was sent to you";
	public static final String REPAIR_SUCCESS = "Car was successfully repaired. Thank you for using our services!";
	public static final String WAITING_FOR_ORDERS = "Check is waiting for more orders or finishing by user";

	private int id;
	private Date date;
	private String description;
	private int price;
	private List<Order> orders;
	private Status status;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> list) {
		this.orders = list;
	}
	@Override
	public String toString() {
		return "Check [id=" + id + ", date=" + date + ", description=" + description + ", price=" + price + ", orders="
				+ orders + "]";
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
}
