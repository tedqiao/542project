package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import vo.*;
import dbc.DatabaseConnection;

public class IHoldDAO {
	private DatabaseConnection dbc = null;
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	
	public IHoldDAO(){// instance class
		try {
			dbc = new DatabaseConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.conn = this.dbc.getConnection();
	}
	
	public List<Hold> getAllHoldById(Hold hold) throws Exception {
		List<Hold> list = new ArrayList<Hold>();
		try {
			String sql = "select sid, shares from hold where userid = ?";
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1, hold.getuserID());
			ResultSet rs = this.pstmt.executeQuery();// get the result set
			while (rs.next()) {
				Hold hd = new Hold();
				hd.setuserID(hold.getSid());
				hd.setSid(rs.getString("sid"));
				hd.setshares(rs.getInt("shares"));
				list.add(hd);
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
