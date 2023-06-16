package net.memet.models;

import java.sql.Time;
import java.util.List;

public class ShoppingHistory {
	private int ShId;
	private List<String> list;
	private int UId;
	private Time time;
	private String address;
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public ShoppingHistory(int shid2, int uid2, List<String> list2, String address2, Time time2){
		this.list = null;
		this.ShId = 0;
		this.list = null;
		this.UId = 0;
		this.time = null;
		this.address = null;
	}
	
	public int getShId() {
		return ShId;
	}
	public void setShId(int shId) {
		ShId = shId;
	}
	public List<String> getList() {
		return list;
	}
	public void setList(List<String> list) {
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
	public void setTime(String address) {
		this.address = address;
	} 
	
	public Time getAdress() {
		return time;
	}
	public void setAdress(String address) {
		this.address = address;
	} 
}
