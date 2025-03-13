package hp_setting;

import java.sql.Connection;
import java.sql.PreparedStatement;

import admin.m_db;

public class hp_basic_insert {
	Connection con = null;
	PreparedStatement ps = null;
	String sql = "";
	int result;
	m_db db = new m_db();
	
	public int hp_in(String corp_name,String busi_num,String ceo_name,String ceo_num,String busi_report_num,
			String busi_num_more,String corp_addnum,String corp_add,String info_ad_name,String info_ad_mail){
		try {
			this.con = this.db.getConnection();
			this.sql = "insert table_hp_basic (bidx,corp_name,busi_num,ceo_name,ceo_num,busi_report_num,busi_num_more,"
					+ "corp_addnum,corp_add,info_ad_name,info_ad_mail)"
					+ "values ('0','?','?','?','?','?','?','?','?','?','?')";
			this.ps = this.con.prepareStatement(this.sql);
			this.ps.setString(6, corp_name);
			this.ps.setString(7, busi_num);
			this.ps.setString(8, ceo_name);
			this.ps.setString(9, ceo_num);
			this.ps.setString(10, busi_report_num);
			this.ps.setString(11, busi_num_more);
			this.ps.setString(12, corp_addnum);
			this.ps.setString(13, corp_add);
			this.ps.setString(14, info_ad_name);
			this.ps.setString(15, info_ad_mail);
			
			this.result = this.ps.executeUpdate();
		} catch (Exception e) {
			this.result = 0;			
		}finally {
			try {
				this.ps.close();
				this.con.close();
			} catch (Exception e2) {
				System.out.println("데이터베이스 비정상");
			}
		}
		return result;
	}
}
