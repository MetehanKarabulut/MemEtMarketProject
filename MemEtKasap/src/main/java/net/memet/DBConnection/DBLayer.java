package net.memet.DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class DBLayer {
	private Connection conn;
	private String url = "jdbc:mysql://localhost:3306/memet?serverTimezone=Turkey";
	private String dbname ="root";
	private String pass = "";
	public Connection connect() throws SQLException {
			System.out.println("Baglanti basarili");
			conn = DriverManager.getConnection(url, dbname, pass);
		return conn;
	}
	
	public void getList() throws SQLException{
		if(conn == null) {
			System.out.println("Baglaniyor");
			connect();
		}
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from users");
			System.out.println("id\t"+"adı\t"+"email\t");
			while(rs.next()) {
				System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t");
			}
			
		}catch(Exception e){
			System.out.println(e);
		}
		
	}
	
	public boolean login(String mail, String password)throws SQLException{
		if(conn == null) {
			System.out.println("Baglaniyor");
			connect();
		}
		ResultSet rs = null;
		try {
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from users where mail ='"+mail+"'&password='"+password+"'");		
		}catch(Exception e){
			System.out.println(e);
		}
		return (rs != null);
	}	
}
