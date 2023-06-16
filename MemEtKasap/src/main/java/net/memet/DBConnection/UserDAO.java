package net.memet.DBConnection;

import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import net.memet.models.User;

public class UserDAO {
	
	public void InsertUser(User user)throws IOException, SQLException {
		Connection conn = DBLayer.connect();
		
		PreparedStatement pstm = conn.prepareStatement("Insert Into users (name,mail,password,role,address)values(?,?,?,?,?);");
		pstm.setString(1, user.getName());
		pstm.setString(2, user.getMail());
		pstm.setString(3, user.getPassword());
		pstm.setString(4, "user");
		pstm.setString(5, user.getAddress());
		pstm.executeUpdate();
	}
	
	@SuppressWarnings("null")
	public List<User> SellectAllUsers() throws SQLException{
		List<User> users = null;
		Connection conn = DBLayer.connect();
		PreparedStatement pstm = conn.prepareStatement("Select * form users");
		ResultSet rs = pstm.executeQuery();		
		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String mail = rs.getString("mail");
			String password = rs.getString("password");
			String role= rs.getString("role");
			String address = rs.getString("address");
			users.add(new User(id, name, mail, password, role, address));
		}
		
		return users;
	}
	
	public User SellectUserById(int id) throws SQLException {
		User user = null;
		Connection conn = DBLayer.connect();
		PreparedStatement pstm = conn.prepareStatement("Select * form users where Id = ?");
		pstm.setInt(1, id);
		ResultSet rs = pstm.executeQuery();		
		while(rs.next()){
			int id1 = rs.getInt("id");
			String name = rs.getString("name");
			String mail = rs.getString("mail");
			String password = rs.getString("password");
			String role= rs.getString("role");
			String address = rs.getString("address");
			user = new User(id1, name, mail, password, role, address);
		}
		return user;
	}
	
	public boolean UpdateUser(User user) throws SQLException {
		Connection conn = DBLayer.connect();
		PreparedStatement pstm = conn.prepareStatement("Update * from users where id=?");
		pstm.setInt(1, user.getId());
		pstm.setString(2, user.getName());
		pstm.setString(3, user.getMail());
		pstm.setString(4, user.getPassword());
		pstm.setString(5, user.getRole());
		pstm.setString(6, user.getAddress());
		
		return pstm.executeUpdate()>0;
		
	}
	
	public boolean DeleteUser(int id) throws SQLException {
		Connection conn = DBLayer.connect();
		PreparedStatement pstm = conn.prepareStatement("Delete form users where Id = ?");
		pstm.setInt(1, id);
		return pstm.executeUpdate() > 0;
	}
}
