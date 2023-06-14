package net.memet.models;

public class Product {
	private int PId;
	private int CId;
	private String Pname;
	private float stock;
	private float price;
	
	Product(){
		this.CId = 0;
		this.PId = 0;
		this.Pname = null;
		this.stock = 0;
		this.price = 0;
	}
	public Product(int cId, String pname, float stock, float price) {
		super();
		CId = cId;
		Pname = pname;
		this.stock = stock;
		this.price = price;
	}
	public Product(int pId, int cId, String pname, float stock, float price) {
		super();
		PId = pId;
		CId = cId;
		Pname = pname;
		this.stock = stock;
		this.price = price;
	}
	public int getPId() {
		return PId;
	}
	public void setPId(int pId) {
		PId = pId;
	}
	public int getCId() {
		return CId;
	}
	public void setCId(int cId) {
		CId = cId;
	}
	public String getPname() {
		return Pname;
	}
	public void setPname(String pname) {
		Pname = pname;
	}
	public float getStock() {
		return stock;
	}
	public void setStock(float stock) {
		this.stock = stock;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
}
