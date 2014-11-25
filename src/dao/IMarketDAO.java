package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vo.Market;
import dbc.DatabaseConnection;
/** The Overall Market logic class     
* @author Chengjiao Yang  
*/  
public class IMarketDAO {
	private DatabaseConnection dbc = null;
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	
	public IMarketDAO(){// instance class
		try {
			dbc = new DatabaseConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.conn = this.dbc.getConnection();
	}
	
	/** This function is to get the Overall Market Information 
	  * @param null  
	  * @return Market VO
	  * @exception exceptions database exceptions
	  */ 
	public Market getMarket() throws Exception {
		Market market = new Market();
		try {
			String sql = "select marketIndex,VariationRange,OverallCapital from market";
			this.pstmt = this.conn.prepareStatement(sql);
			ResultSet rs = this.pstmt.executeQuery();// get the result set
			if (rs.next()) {
				market.setMarketIndex(rs.getString("marketIndex"));
				market.setVariationRange(rs.getDouble("VariationRange"));
				market.setOverallCapital(rs.getDouble("OverallCapital"));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			this.pstmt.close();
			this.dbc.close();
		}
		return market;
	}
}
