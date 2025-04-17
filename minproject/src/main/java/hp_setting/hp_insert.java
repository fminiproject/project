package hp_setting;

import java.sql.Connection;
import java.sql.PreparedStatement;

import common.m_db;

public class hp_insert {
	Connection con = null;			// DB에 쿼리문 넣기 위해 사용, close 해야 함
	PreparedStatement ps_del = null;	// sql문을 실행하기 위해 사용, close 해야 함
	PreparedStatement ps = null;	// sql문을 실행하기 위해 사용, close 해야 함
	String sql_del = "";
	String sql = "";				// sql 쿼리문을 작성하기 위한 변수
//	int result;						// 쿼리 실행 결과 값을 단순화해서 반환하기 위해 사용
	Integer result = 0;
	m_db db = new m_db();
	
	/*
	public int hp_in(String hp_title,String ad_mail,String use_point,String join_point,String join_lv
			,String corp_name,String busi_num,String ceo_name,String ceo_num,String busi_report_num
			,String busi_num_more,String corp_addnum,String corp_add,String info_ad_name,String info_ad_mail
			,String no_bank,String account_num,String card_pay,String phone_pay,String coupon_pay
			,String pay_po_min,String pay_po_max,String receipt,String deli_corp,String deli_pay,String deli_day){
		try {
			this.con = this.db.getConnection();		// DB 연결
			
			if(this.con != null) {
				System.out.println("DB 연결 성공");
			}else if(this.con == null) {
				System.out.println("DB 연결 실패");
			}
			
			
			
			System.out.println(hp_title);
			System.out.println(ad_mail);
			System.out.println(use_point);
			System.out.println(join_point);
			System.out.println(join_lv);
			System.out.println(corp_name);
			System.out.println(busi_num);
			System.out.println(ceo_name);
			System.out.println(ceo_num);
			System.out.println(busi_report_num);
			System.out.println(busi_num_more);
			System.out.println(corp_addnum);
			System.out.println(corp_add);
			System.out.println(info_ad_name);
			System.out.println(info_ad_mail);
			System.out.println(no_bank);
			System.out.println(account_num);
			System.out.println(card_pay);
			System.out.println(phone_pay);
			System.out.println(coupon_pay);
			System.out.println(pay_po_min);
			System.out.println(pay_po_max);
			System.out.println(receipt);
			System.out.println(deli_corp);
			System.out.println(deli_pay);
			System.out.println(deli_day);
			
			
			// 먼저 있는 데이터 모두 삭제
			this.sql_del = "delete from homepage;";
			this.ps_del = this.con.prepareStatement(this.sql_del);
			this.ps_del.executeUpdate();
			
			// 쿼리문 작성
			this.sql = "insert into homepage (hp_title, ad_mail, use_point, join_point, join_lv"
					+ ", corp_name, busi_num, ceo_name, ceo_num, busi_report_num, busi_num_more"
					+ ", corp_addnum, corp_add, info_ad_name, info_ad_mail"
					+ ", no_bank, account_num, card_pay, phone_pay, coupon_pay, pay_po_min"
					+ ", pay_po_max, receipt, deli_corp, deli_pay, deli_day)"
					+ " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
//			System.out.println("sql 준비 완료 : " + this.sql);
			
			this.ps = this.con.prepareStatement(this.sql);	// 작성한 쿼리문 변수로 태워 안전하게 연결된 DB에 전달하기 위해 사용
//			System.out.println(this.ps);
			
			// 파라미터 설정
			this.ps.setString(1, hp_title);		// 첫 번째 ?에 hp_title이라는 변수로 가져온 값 설정
			this.ps.setString(2, ad_mail);
			this.ps.setString(3, use_point);
			this.ps.setInt(4, Integer.parseInt(join_point));	// int형으로 변환
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
			
//			System.out.println(this.ps);
			
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
	*/
	
	// DTO 파일을 매개변수로 불러온 뒤 그것을 h라는 변수에 담음
	public Integer hp_in(hp_DTO h) {
//		System.out.println("모델에서 받은 데이터" + h.getAccount_num());
		
		try {
			this.con = this.db.getConnection();
			
			this.sql_del = "delete from homepage;";
			this.ps_del = this.con.prepareStatement(this.sql_del);
			this.ps_del.executeUpdate();
			
			this.sql = "insert into homepage (hp_title, ad_mail, use_point, join_point, join_lv"
					+ ", corp_name, busi_num, ceo_name, ceo_num, busi_report_num, busi_num_more"
					+ ", corp_addnum, corp_add, info_ad_name, info_ad_mail"
					+ ", no_bank, account_num, card_pay, phone_pay, coupon_pay, pay_po_min"
					+ ", pay_po_max, receipt, deli_corp, deli_pay, deli_day)"
					+ " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
			
			// DTO에서 getter 이용해서 DB에 저장
			this.ps = this.con.prepareStatement(this.sql);
			this.ps.setString(1, h.getHp_title());
			this.ps.setString(2, h.getAd_mail());
			this.ps.setString(3, h.getUse_point());
			this.ps.setInt(4, Integer.parseInt(h.getJoin_point()));
			this.ps.setInt(5, Integer.parseInt(h.getJoin_lv()));
			this.ps.setString(6, h.getCorp_name());
			this.ps.setString(7, h.getBusi_num());
			this.ps.setString(8, h.getCeo_name());
			this.ps.setString(9, h.getCeo_num());
			this.ps.setString(10, h.getBusi_report_num());
			this.ps.setString(11, h.getBusi_num_more());
			this.ps.setString(12, h.getCorp_addnum());
			this.ps.setString(13, h.getCorp_add());
			this.ps.setString(14, h.getInfo_ad_name());
			this.ps.setString(15, h.getInfo_ad_mail());
			this.ps.setString(16, h.no_bank);
			this.ps.setLong(17, Long.parseLong(h.getAccount_num()));
			this.ps.setString(18, h.getCard_pay());
			this.ps.setString(19, h.getPhone_pay());
			this.ps.setString(20, h.getCoupon_pay());
			this.ps.setInt(21, Integer.parseInt(h.getPay_po_min()));
			this.ps.setInt(22, Integer.parseInt(h.getPay_po_max()));
			this.ps.setString(23, h.getReceipt());
			this.ps.setString(24, h.getDeli_corp());
			this.ps.setInt(25, Integer.parseInt(h.getDeli_pay()));
			this.ps.setString(26, h.getDeli_day());
			
			this.result = this.ps.executeUpdate();
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