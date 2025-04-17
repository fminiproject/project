package admin;

import java.sql.Connection;
import java.sql.PreparedStatement;

import common.m_db;

public class m_update {
	Connection con = null;
	PreparedStatement ps = null;
	String sql = null;
	String result = null;
	int qresult = 0;
	m_db db = new m_db();
	

	public String verified(String mid,String verified) {
		try {
			this.con = this.db.getConnection();
			
			if(verified.equals("")||verified==null) {
				return null;
			} 
			
			this.sql = "update member set verified=? where mid=?";
			this.ps = this.con.prepareStatement(this.sql);
			
			this.ps.setString(1, verified);
			this.ps.setString(2, mid);
			qresult = this.ps.executeUpdate();
			
			if (qresult > 0 ) {
				
				if (verified.equals("Y")) {
					this.result = "verified";	
				} else {
					this.result = "unverified";	
				}


			} else {
				this.result = null;
			}
			
			
		} catch (Exception e) {
		} finally {
			try {
				this.ps.close();
				this.con.close();
			} catch (Exception e2) {
			}
		}

		
		
		
		return this.result;
	}

};