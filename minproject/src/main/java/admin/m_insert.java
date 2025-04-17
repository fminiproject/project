package admin;

import java.sql.Connection;
import java.sql.PreparedStatement;

import common.m_db;

public class m_insert {
	Connection con = null;
	PreparedStatement ps = null;
	String sql = null;
	String result = null;
	m_db db = new m_db();

	
	
	public String joinresult(dto_member dn) {
	
		
		try {
			
			this.con = this.db.getConnection();
			this.sql = "insert into member(midx,mid,mpass,mname,memail,mtel,mpart,mposition,mdate,verified)"
					+ "values(0,?,?,?,?,?,?,?,now(),'N'); ";
			this.ps = this.con.prepareStatement(sql);

			
			this.ps.setString(1, dn.getMid());
			this.ps.setString(2, dn.getMpass());
			this.ps.setString(3, dn.getMname());
			this.ps.setString(4, dn.getMemail());
			this.ps.setString(5, dn.getMtel());
			this.ps.setString(6, dn.getMpart());
			this.ps.setString(7, dn.getMposition());
			
			int sqlresult = this.ps.executeUpdate();
			if (sqlresult > 0) {
				this.result = "ok";
			}
			
			
		} catch (Exception e) {
			this.result = "false";
		} finally {
			try {
				
				this.con.close();
			} catch (Exception e2) {
			}
		}
		
	
		
		return this.result;
	}
	

}
