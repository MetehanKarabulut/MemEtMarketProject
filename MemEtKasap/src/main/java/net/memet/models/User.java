package net.memet.models;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.String;

enum Role{
	admin,
	user
}

public class User {
	private int Id;
	private String name;
	private String mail;
	private String password;
	private String role;
	private String address;
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public User(String name, String mail, String password, String role, String address) {
		super();
		this.name = name;
		this.mail = mail;
		this.password = password;
		this.role = role;
		this.address = address;
	}

	public User(int id, String name, String mail, String password, String role, String address) {
		super();
		Id = id;
		this.name = name;
		this.mail = mail;
		this.password = password;
		this.role = role;
		this.address = address;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
