package net.memet.models;

public class Category {
	private int CId;
	private String Cname;
	
	Category(){
		this.CId = 0;
		this.Cname = null;
	}
	
	public Category(String cname) {
		super();
		Cname = cname;
	}

	public Category(int cId, String cname) {
		super();
		CId = cId;
		Cname = cname;
	}

	public int getCId() {
		return CId;
	}
	public void setCId(int cId) {
		CId = cId;
	}
	public String getCname() {
		return Cname;
	}
	public void setCname(String cname) {
		Cname = cname;
	}
	
}
