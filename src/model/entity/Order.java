package model.entity;

import java.io.Serializable;
import java.sql.Date;

public class Order implements Serializable {

	private static final long serialVersionUID = -1737859893948370664L;

	private int id;
	private String passport;
	private User user;
	private Car car;
	private Check check;
	private Date startDate;
	private Date endDate;
	private boolean driver;
	private Status status;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public Check getCheck() {
		return check;
	}
	public void setCheck(Check check) {
		this.check = check;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", user=" + user + ", car=" + car + ", check=" + check + ", startDate=" + startDate
				+ ", endDate=" + endDate + "]";
	}
	public boolean isDriver() {
		return driver;
	}
	public void setDriver(boolean driver) {
		this.driver = driver;
	}
	public String getPassport() {
		return passport;
	}
	public void setPassport(String passport) {
		this.passport = passport;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
}
