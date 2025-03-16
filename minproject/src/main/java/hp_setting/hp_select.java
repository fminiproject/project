package hp_setting;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import admin.m_db;

public class hp_select {
	Connection con = null;			// DB에 쿼리문 넣기 위해 사용, close 해야 함
	PreparedStatement ps = null;	// sql문을 실행하기 위해 사용, close 해야 함
	String sql = "";				// sql 쿼리문을 작성하기 위한 변수
	m_db db = new m_db();			// db 정보 가져옴
	ResultSet rs = null;			// SQL 쿼리 실행 후 반환된 결과 데이터를 저장하고, 순차적으로 접근할 수 있는 방법
	
	ArrayList<Object> data = null;
	ArrayList<ArrayList<Object>> alldata = null;
	
	public ArrayList<ArrayList<Object>> hp_datalist(){
		
		try {
			this.con = this.db.getConnection();
			this.sql = "select * from homepage;";
			this.ps = this.con.prepareStatement(this.sql);
			this.rs = this.ps.executeQuery();
//			System.out.println(this.rs);
			
			this.alldata = new ArrayList<ArrayList<Object>>();
			
			
			while(this.rs.next()) {
				this.data = new ArrayList<Object>();
				this.data.add(this.rs.getString("hp_title"));
				this.data.add(this.rs.getString("ad_mail"));
				this.data.add(this.rs.getString("use_point"));
				this.data.add(this.rs.getInt("join_point"));
				this.data.add(this.rs.getInt("join_lv"));
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
				this.data.add(this.rs.getString("no_bank"));
				this.data.add(this.rs.getLong("account_num"));
				this.data.add(this.rs.getString("card_pay"));
				this.data.add(this.rs.getString("phone_pay"));
				this.data.add(this.rs.getString("coupon_pay"));
				this.data.add(this.rs.getInt("pay_po_min"));
				this.data.add(this.rs.getInt("pay_po_max"));
				this.data.add(this.rs.getString("receipt"));
				this.data.add(this.rs.getString("deli_corp"));
				this.data.add(this.rs.getInt("deli_pay"));
				this.data.add(this.rs.getString("deli_day"));
//				System.out.println(this.data);
				
				this.alldata.add(this.data);
//				System.out.println(this.alldata);
			}
			
		} catch (Exception e) {
			this.data = null;
			e.printStackTrace();
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