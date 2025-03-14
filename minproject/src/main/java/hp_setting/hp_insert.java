package hp_setting;

import java.sql.Connection;
import java.sql.PreparedStatement;

import admin.m_db;

public class hp_insert {
	Connection con = null;
	PreparedStatement ps = null;
	String sql = "";
	int result;
	m_db db = new m_db();
	
	public int hp_in(String hp_title,String ad_mail,String use_point,int join_point,int join_lv,
			String corp_name, String busi_num, String ceo_name, String ceo_num, String busi_report_num,
			String busi_num_more, String corp_addnum, String corp_add, String info_ad_name, String info_ad_mail,
			String no_bank, int account_num, String card_pay, String phone_pay, String coupon_pay,
			int pay_po_min, int pay_po_max, String receipt, String deli_corp, int deli_pay, String deli_day){
		try {
			this.con = this.db.getConnection();
			this.sql = "insert into table_hp_join (hp_title,ad_mail,use_point,join_point,join_lv"
					+ ",corp_name,busi_num,ceo_name,ceo_num,busi_report_num,busi_num_more,)"
					+ ",corp_addnum,corp_add,info_ad_name,info_ad_mail"
					+ ",no_bank,account_num,card_pay,phone_pay,coupon_pay,pay_po_min"
					+ ",pay_po_max,receipt,deli_corp,deli_pay,deli_day"
					+ "values ('?','?','?','?','?','?','?','?','?','?','?','?','?'"
					+ ",'?','?','?','?','?','?','?','?','?','?','?','?','?')";
			this.ps = this.con.prepareStatement(this.sql);
			this.ps.setString(1, hp_title);
			this.ps.setString(2, ad_mail);
			this.ps.setString(3, use_point);
			this.ps.setInt(4, join_point);
			this.ps.setInt(5, join_lv);
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
			this.ps.setString(16, no_bank);
			this.ps.setInt(17, account_num);
			this.ps.setString(18, card_pay);
			this.ps.setString(19, phone_pay);
			this.ps.setString(20, coupon_pay);
			this.ps.setInt(18, pay_po_min);
			this.ps.setInt(19, pay_po_max);
			this.ps.setString(23, receipt);
			this.ps.setString(24, deli_corp);
			this.ps.setInt(25, deli_pay);
			this.ps.setString(26, deli_day);
			
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