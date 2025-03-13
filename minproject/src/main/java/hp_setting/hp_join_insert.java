package hp_setting;

import java.sql.Connection;
import java.sql.PreparedStatement;

import admin.m_db;

public class hp_join_insert {
	Connection con = null;
	PreparedStatement ps = null;
	String sql = "";
	int result;
	m_db db = new m_db();
	
	public int hp_in(String hp_title,String ad_mail,String use_point,String join_point,String join_lv){
		try {
			this.con = this.db.getConnection();
			this.sql = "insert into table_hp_join (hidx,hp_title,ad_mail,use_point,join_point,join_lv)"
					+ "values ('0','?','?','?','?','?')";
			this.ps = this.con.prepareStatement(this.sql);
			this.ps.setString(1, hp_title);
			this.ps.setString(2, ad_mail);
			this.ps.setString(3, use_point);
			this.ps.setString(4, join_point);
			this.ps.setString(5, join_lv);
			
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