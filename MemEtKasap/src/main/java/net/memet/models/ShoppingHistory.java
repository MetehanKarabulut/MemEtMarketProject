package net.memet.models;

import java.sql.Time;
import java.util.List;

public class ShoppingHistory {
	private int ShId;
	private List<Product> list;
	private int UId;
	private Time time;
	
	ShoppingHistory(){
		this.list = null;
		this.ShId = 0;
		this.UId = 0;
		this.time = null;
	}
	
	public int getShId() {
		return ShId;
	}
	public void setShId(int shId) {
		ShId = shId;
	}
	public List<Product> getList() {
		return list;
	}
	public void setList(List<Product> list) {
		this.list = list;
	}
	public int getUId() {
		return UId;
	}
	public void setUId(int uId) {
		UId = uId;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	} 
}
