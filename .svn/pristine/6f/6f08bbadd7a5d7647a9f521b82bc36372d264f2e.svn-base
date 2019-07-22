package model.entity;

import java.io.Serializable;
import java.util.List;

public class Role implements Serializable {

	private static final long serialVersionUID = -3931854234260430456L;
	
	public static final int ADMIN = 0;
	public static final int MANAGER = 1;
	public static final int CUSTOMER = 2;
	public static final int BLOCKED = 3;
	
	private int id;
	private String name;
	private List<User> users;
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
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
}
