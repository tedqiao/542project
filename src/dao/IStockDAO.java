package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import vo.*;
import dbc.DatabaseConnection;

public class IStockDAO {
	private DatabaseConnection dbc = null;
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	
	public IStockDAO(){// instance class
		try {
			dbc = new DatabaseConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.conn = this.dbc.getConnection();
	}
	
	public List<StockCompany> getAllStocks() throws Exception {
		List<StockCompany> list = new ArrayList<StockCompany>();
		try {
			String sql = "select a.sid,b.name,a.price_share,a.variation_range from stock a,company b where a.cid = b.cid";
			this.pstmt = this.conn.prepareStatement(sql);
			ResultSet rs = this.pstmt.executeQuery();// get the result set
			while (rs.next()) {
				StockCompany sc = new StockCompany();
				sc.setSid(rs.getString("sid"));
				sc.setName(rs.getString("name"));
				sc.setPrice_share(rs.getDouble("price_share"));
				sc.setVariation_Range(rs.getDouble("variation_range"));
				list.add(sc);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			this.pstmt.close();
			this.dbc.close();
		}
		return list;
	}
	
	public List<StockCompany> getTopTwentyStocks() throws Exception {
		List<StockCompany> list = new ArrayList<StockCompany>();
		try {
			String sql = "select a.sid,b.name,a.price_share,a.variation_range from stock a,company b where a.cid = b.cid limit 20";
			this.pstmt = this.conn.prepareStatement(sql);
			ResultSet rs = this.pstmt.executeQuery();// get the result set
			while (rs.next()) {
				StockCompany sc = new StockCompany();
				sc.setSid(rs.getString("sid"));
				sc.setName(rs.getString("name"));
				sc.setPrice_share(rs.getDouble("price_share"));
				sc.setVariation_Range(rs.getDouble("variation_range"));
				list.add(sc);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			this.pstmt.close();
			this.dbc.close();
		}
		return list;
	}
}
