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
	
	public List<HoldCompany> getAllHoldById(HoldCompany hold) throws Exception {
		List<HoldCompany> list = new ArrayList<HoldCompany>();
		try {
			String sql = "select c.name, a.shares, b.sid from (select sid, shares from hold where userid = ?) a, stock b, company c where b.cid = c.cid and a.sid = b.sid";
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1, hold.getuserID());
			ResultSet rs = this.pstmt.executeQuery();// get the result set
			while (rs.next()) {
				HoldCompany hc = new HoldCompany();
				hc.setuserID(hold.getSid());
				hc.setSid(rs.getString("sid"));
				hc.setshares(rs.getInt("shares"));
				hc.setName(rs.getString("name"));
				list.add(hc);
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
