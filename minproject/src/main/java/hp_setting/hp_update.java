package hp_setting;

import java.sql.Connection;
import java.sql.PreparedStatement;

import common.m_db;

public class hp_update {
	Connection con = null;			// DB에 쿼리문 넣기 위해 사용, close 해야 함
	PreparedStatement ps_del = null;	// sql문을 실행하기 위해 사용, close 해야 함
	PreparedStatement ps = null;	// sql문을 실행하기 위해 사용, close 해야 함
	String sql_del = "";			// sql_delete 쿼리문을 작성하기 위한 변수
	String sql_in = "";				// sql_insert 쿼리문을 작성하기 위한 변수
	int result;						// 쿼리 실행 결과 값을 단순화해서 반환하기 위해 사용
	m_db db = new m_db();
	
	// 
	public int hp_up(String hp_title,String ad_mail,String use_point,String join_point,String join_lv
			,String corp_name,String busi_num,String ceo_name,String ceo_num,String busi_report_num
			,String busi_num_more,String corp_addnum,String corp_add,String info_ad_name,String info_ad_mail
			,String no_bank,String account_num,String card_pay,String phone_pay,String coupon_pay
			,String pay_po_min,String pay_po_max,String receipt,String deli_corp,String deli_pay,String deli_day){
		try {
			this.con = this.db.getConnection();		// DB 연결
			
			// 테이블의 모든 데이터 삭제
			this.sql_del = "delete from homepage;";
			this.ps_del = this.con.prepareStatement(this.sql_del);
			this.ps_del.executeUpdate();
			System.out.println(this.ps_del);
			
			// 다시 데이터 넣음
			this.sql_in = "insert into homepage (hp_title, ad_mail, use_point, join_point, join_lv"
					+ ", corp_name, busi_num, ceo_name, ceo_num, busi_report_num, busi_num_more"
					+ ", corp_addnum, corp_add, info_ad_name, info_ad_mail"
					+ ", no_bank, account_num, card_pay, phone_pay, coupon_pay, pay_po_min"
					+ ", pay_po_max, receipt, deli_corp, deli_pay, deli_day)"
					+ " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
			
			this.ps = this.con.prepareStatement(this.sql_in);
			
			this.ps.setString(1, hp_title);
			this.ps.setString(2, ad_mail);
			this.ps.setString(3, use_point);
			this.ps.setInt(4, Integer.parseInt(join_point));
			this.ps.setInt(5, Integer.parseInt(join_lv));
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
			this.ps.setLong(17, Long.parseLong(account_num));	// long형으로 변환
			this.ps.setString(18, card_pay);
			this.ps.setString(19, phone_pay);
			this.ps.setString(20, coupon_pay);
			this.ps.setInt(21, Integer.parseInt(pay_po_min));
			this.ps.setInt(22, Integer.parseInt(pay_po_max));
			this.ps.setString(23, receipt);
			this.ps.setString(24, deli_corp);
			this.ps.setInt(25, Integer.parseInt(deli_pay));
			this.ps.setString(26, deli_day);
			
			System.out.println(this.ps);
			
//			System.out.println("파라미터 설정 완료");
			
			this.result = this.ps.executeUpdate();	// 쿼리 실행하고 reseult에 값 넣음, 성공 시 1 반환
//			System.out.println("삽입 결과 : " + this.result);
			
		} catch (Exception e) {
			this.result = 0;	// 실패 시 0으로 초기화
			System.out.println("데이터베이스에 삽입 작업 실패");
			e.printStackTrace();
		}finally {
			try {
				this.ps.close();
				this.ps_del.close();
				this.con.close();
			} catch (Exception e2) {
				System.out.println("데이터베이스 비정상");
			}
		}
		return this.result;
	}
}