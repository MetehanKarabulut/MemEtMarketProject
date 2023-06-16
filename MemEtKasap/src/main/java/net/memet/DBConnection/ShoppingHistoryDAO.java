package net.memet.DBConnection;

import java.io.IOException;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.List;

import net.memet.models.Product;
import net.memet.models.ShoppingHistory;

public class ShoppingHistoryDAO {
	public void AddShoppingHistory(ShoppingHistory history)throws IOException, SQLException {
		Connection conn = DBLayer.connect();
		PreparedStatement pstm = conn.prepareStatement("Insert Into shoppingHisory (name)values(?)");
		pstm.setInt(1, history.getShId());
		pstm.setInt(2, history.getUId());
		pstm.setArray(3, (Array) history.getList());
		pstm.setString(5, history.getAddress());
		pstm.executeUpdate();
		
	}
	
	public boolean UpdateShoppingHistory(ShoppingHistory history) throws SQLException {
		Connection conn = DBLayer.connect();
		PreparedStatement pstm = conn.prepareStatement("Update * from historys where Shid=?");
		pstm.setInt(1, history.getShId());
		pstm.setArray(2, (Array) history.getList());
		pstm.setLong(3, history.getUId());
		pstm.setTime(4, history.getTime());
		pstm.setString(5, history.getAddress());
		return pstm.executeUpdate()>0;
	}
	
	public boolean DeleteShoppingHistory(int id) throws SQLException {
		Connection conn = DBLayer.connect();
		PreparedStatement pstm = conn.prepareStatement("Delete from ShoppingHistorys where Shid = ?");
		pstm.setInt(1, id);
		return pstm.executeUpdate() > 0;
	}
	
	@SuppressWarnings("null")
	public List<ShoppingHistory> SellectAllShoppingHistorys() throws SQLException{
		List<ShoppingHistory> ShoppingHistorys = null;
		Connection conn = DBLayer.connect();
		PreparedStatement pstm = conn.prepareStatement("Select * form ShoppingHistorys");
		ResultSet rs = pstm.executeQuery();		
		while (rs.next()) {
			int Shid = rs.getInt("Shid");
			int Uid = rs.getInt("Uid");
			@SuppressWarnings("unchecked")
			List<String> list = (List<String>) rs.getArray("List");
			String address = rs.getString("address");
			Time time = rs.getTime("time");
			ShoppingHistorys.add(new ShoppingHistory(Shid, Uid, list, address, time));
		}
		return ShoppingHistorys;
	}
}
