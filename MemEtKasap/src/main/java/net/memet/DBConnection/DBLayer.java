package net.memet.DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class DBLayer {
	private static Connection conn;
	public static String url = "jdbc:mysql://localhost:3306/memet?serverTimezone=Turkey";
	public static String dbname ="root";
	public static String pass = "";
	public static Connection connect() throws SQLException {
			System.out.println("Baglanti basarili");
			conn = DriverManager.getConnection(url, dbname, pass);
		return conn;
	}
}
