package net.memet.DBConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import net.memet.models.Category;

public class CategoryDAO {
	
	public void AddCategory(Category category)throws IOException, SQLException {
		Connection conn = DBLayer.connect();
		
		PreparedStatement pstm = conn.prepareStatement("Insert Into categories (name)values(?);");
		pstm.setString(1, category.getCname());
		pstm.executeUpdate();
	}
	
	@SuppressWarnings("null")
	public List<Category> SellectAllCategory() throws SQLException{
		List<Category> categories = null;
		Connection conn = DBLayer.connect();
		PreparedStatement pstm = conn.prepareStatement("Select * form categories");
		ResultSet rs = pstm.executeQuery();		
		while (rs.next()) {
			String name = rs.getString("Cname");
			categories.add(new Category(name));
		}
		return categories;
	}
	
	public Category SellectCategoryById(int id) throws SQLException {
		Category category = null;
		Connection conn = DBLayer.connect();
		PreparedStatement pstm = conn.prepareStatement("Select * form categories where Cid = ?");
		pstm.setInt(1, id);
		ResultSet rs = pstm.executeQuery();		
		while(rs.next()){
			int id1 = rs.getInt("Cid");
			String name = rs.getString("name");
			category = new Category(id1, name);
		}
		return category;
	}
	
	public boolean UpdateCategory(Category category) throws SQLException {
		Connection conn = DBLayer.connect();
		PreparedStatement pstm = conn.prepareStatement("Update * from categories where Cid=?");
		pstm.setInt(1, category.getCId());
		pstm.setString(2, category.getCname());	
		return pstm.executeUpdate()>0;	
	}
	
	public boolean DeleteCategory(int id) throws SQLException {
		Connection conn = DBLayer.connect();
		PreparedStatement pstm = conn.prepareStatement("Delete form categories where Cid = ?");
		pstm.setInt(1, id);
		return pstm.executeUpdate() > 0;
	}
}
