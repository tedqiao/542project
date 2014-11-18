package dao;

import java.sql.*;

import vo.*;
import dbc.DatabaseConnection;

public class IInvestorsDAO {
	private DatabaseConnection dbc = null;
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	
	public IInvestorsDAO(){// instance class
		try {
			dbc = new DatabaseConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.conn = this.dbc.getConnection();
	}
	
	public Investors getInvestorById(Investors investor) throws Exception {
		try {
			String sql = "select userName, sex, userID, Assets from investors where userID = ?";
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1, investor.getuserID());
			ResultSet rs = this.pstmt.executeQuery();
			if (rs.next()) {
				investor.setuserName(rs.getString("userName"));
				investor.setsex(rs.getString("sex"));
				investor.setAssets(rs.getDouble("Assets"));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			this.pstmt.close();
			this.dbc.close();
		}
		return investor;
	}
	
}
