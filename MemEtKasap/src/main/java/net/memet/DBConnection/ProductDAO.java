package net.memet.DBConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import net.memet.models.Product;

public class ProductDAO {
	public void addProduct(Product product)throws IOException, SQLException {
		Connection conn = DBLayer.connect();
		
		PreparedStatement pstm = conn.prepareStatement("Insert Into peoducts (Cid,name,stock,price)values(?,?,?,?,?);");
		pstm.setInt(1, product.getPId());
		pstm.setInt(2, product.getCId());
		pstm.setString(3, product.getPname());
		pstm.setFloat(4, product.getStock());
		pstm.setFloat(5, product.getPrice());
		pstm.executeUpdate();
	}
	
	public boolean UpdateProduct(Product product) throws SQLException {
		Connection conn = DBLayer.connect();
		PreparedStatement pstm = conn.prepareStatement("Update * from products where Pid=?");
		pstm.setInt(1, product.getPId());
		pstm.setInt(2, product.getCId());
		pstm.setString(3, product.getPname());
		pstm.setFloat(4, product.getStock());
		pstm.setFloat(5, product.getPrice());
		return pstm.executeUpdate()>0;
		
	}
	
	public boolean DeleteProduct(int id) throws SQLException {
		Connection conn = DBLayer.connect();
		PreparedStatement pstm = conn.prepareStatement("Delete form products where Pid = ?");
		pstm.setInt(1, id);
		return pstm.executeUpdate() > 0;
	}
	
	@SuppressWarnings("null")
	public List<Product> SellectAllProducts() throws SQLException{
		List<Product> products = null;
		Connection conn = DBLayer.connect();
		PreparedStatement pstm = conn.prepareStatement("Select * form products");
		ResultSet rs = pstm.executeQuery();		
		while (rs.next()) {
			int Pid = rs.getInt("Pid");
			int Cid = rs.getInt("Pid");
			String name = rs.getString("name");
			float stock = rs.getFloat("stock");
			float price = rs.getFloat("price");
			products.add(new Product(Pid, Cid, name, stock, price));
		}
		return products;
	}
}
