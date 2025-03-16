
package hp_setting;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class hp_joinok_update extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PrintWriter pw = null;
	hp_update hu = new hp_update();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String hp_title = request.getParameter("hp_title");
		String ad_mail = request.getParameter("ad_mail");
		String use_point = request.getParameter("use_point");
		String join_point = request.getParameter("join_point");
		String join_lv = request.getParameter("join_lv");
		String corp_name = request.getParameter("corp_name");
		String busi_num = request.getParameter("busi_num");
		String ceo_name = request.getParameter("ceo_name");
		String ceo_num = request.getParameter("ceo_num");
		String busi_report_num = request.getParameter("busi_report_num");
		String busi_num_more = request.getParameter("busi_num_more");
		String corp_addnum = request.getParameter("corp_addnum");
		String corp_add = request.getParameter("corp_add");
		String info_ad_name = request.getParameter("info_ad_name");
		String info_ad_mail = request.getParameter("info_ad_mail");
		String no_bank = request.getParameter("no_bank");
		String account_num = request.getParameter("account_num");
		String card_pay = request.getParameter("card_pay");
		String phone_pay = request.getParameter("phone_pay");
		String coupon_pay = request.getParameter("coupon_pay");
		String pay_po_min = request.getParameter("pay_po_min");
		String pay_po_max = request.getParameter("pay_po_max");
		String receipt = request.getParameter("receipt");
		String deli_corp = request.getParameter("deli_corp");
		String deli_pay = request.getParameter("deli_pay");
		String deli_day = request.getParameter("deli_day");

		
		// hp_update.java에 매개변수로 위의 String 변수들을 넣음
		int result = this.hu.hp_up(hp_title,ad_mail,use_point,join_point,join_lv,
				corp_name,busi_num,ceo_name,ceo_num,busi_report_num,busi_num_more,
				corp_addnum,corp_add,info_ad_name,info_ad_mail,no_bank,account_num,
				card_pay,phone_pay,coupon_pay,pay_po_min,pay_po_max,receipt,
				deli_corp,deli_pay,deli_day);
		
		// 클라이언트에게 응답을 보내기 위해 PrintWriter 초기화 
		this.pw = response.getWriter();
		
		if(result == 1) {	// 삽입이 성공할 경우 성공 메시지를 알림
			this.pw.write("<script>"
					+ "alert('정상적으로 설정이 저장되었습니다.');"
					+ "location.href='./hp_list.do';"	// 설정 저장 시 설정이 입력된 페이지로 감
					+ "</script>");
		}else if(result == 0){		// 삽입이 실패할 경우 오류 메시지를 알림
			this.pw.write("<script>"
					+ "alert('설정 저장에 실패했습니다. 다시 시도해 주세요.');"
					+ "history.go(-1);"
					+ "</script>");
		}
		this.pw.close();
	}
}
