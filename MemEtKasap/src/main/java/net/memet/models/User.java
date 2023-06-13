package net.memet.models;
enum Role{
	admin,
	user
}

public class User {
	private int Id;
	private String name;
	private String mail;
	private String password;
	private Enum<Role> role;
	
	public User() {
		this.name = null;
		this.mail = null;
		this.Id = 0;
		this.role = null;
		this.password = null;
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

	public Enum<Role> getRole() {
		return role;
	}

	public void setRole(Enum<Role> role) {
		this.role = role;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
