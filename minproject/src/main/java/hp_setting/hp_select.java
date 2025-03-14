package hp_setting;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import admin.m_db;

public class hp_select {
	Connection con = null;
	PreparedStatement ps = null;
	String sql = "";
	m_db db = new m_db();
	ResultSet rs = null;
	
	ArrayList<String> data = null;
	ArrayList<ArrayList<String>> alldata = null;
	
	public ArrayList<ArrayList<String>> hp_datalist_bs(){
		
		try {
			this.con = this.db.getConnection();
			this.sql = "select * from ";
			this.ps = this.con.prepareStatement(this.sql);
			this.rs = this.ps.executeQuery();
			
			this.data = new ArrayList<String>();
			
			while(this.rs.next()) {
				this.data.add(this.rs.getString("bidx"));
				this.data.add(this.rs.getString("corp_name"));
				this.data.add(this.rs.getString("busi_num"));
				this.data.add(this.rs.getString("ceo_name"));
				this.data.add(this.rs.getString("ceo_num"));
				this.data.add(this.rs.getString("busi_report_num"));
				this.data.add(this.rs.getString("busi_num_more"));
				this.data.add(this.rs.getString("corp_addnum"));
				this.data.add(this.rs.getString("corp_add"));
				this.data.add(this.rs.getString("info_ad_name"));
				this.data.add(this.rs.getString("info_ad_mail"));
				
				this.alldata.add(this.data);
			}
			
		} catch (Exception e) {
			this.data = null;
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