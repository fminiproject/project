package hp_setting;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import admin.m_db;

public class hp_join_select {
	Connection con = null;
	PreparedStatement ps = null;
	String sql = "";
	m_db db = new m_db();
	ResultSet rs = null;
	
	ArrayList<String> data = null;
	ArrayList<ArrayList<String>> alldata = null;
	
	public ArrayList<ArrayList<String>> hp_datalist_se(){
		
		try {
			this.con = this.db.getConnection();
			this.sql = "select hidx,hp_title,ad_mail,use_point,join_point,join_lv";
			this.ps = this.con.prepareStatement(this.sql);
			this.rs = this.ps.executeQuery();
			
			this.alldata = new ArrayList<ArrayList<String>>();
			
			while(this.rs.next()) {
				this.data = new ArrayList<String>();
				this.data.add(this.rs.getString("hidx"));
				this.data.add(this.rs.getString("hp_title"));
				this.data.add(this.rs.getString("ad_mail"));
				this.data.add(this.rs.getString("use_point"));
				this.data.add(this.rs.getString("join_point"));
				this.data.add(this.rs.getString("join_lv"));
				
				this.alldata.add(this.data);
			}
			
		} catch (Exception e) {
			this.alldata = null;
		}finally {
			try {
				this.ps.close();
				this.rs.close();
				this.con.close();
			} catch (Exception e2) {
				System.out.println("데이터베이스 오류 발생");
			}finally {
				
			}
		}
		
		return this.alldata;
	}
}