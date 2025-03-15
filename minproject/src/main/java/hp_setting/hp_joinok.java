
package hp_setting;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class hp_joinok extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PrintWriter pw = null;
	hp_insert hi = new hp_insert();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");	// front-end에서 한글이 전송될 경우에만 사용
		response.setContentType("text/html;charset=utf-8");		// Javascript에서 한글 사용할 경우
		
		String hp_title = request.getParameter("hp_title");
		String ad_mail = request.getParameter("ad_mail");
		String use_point = request.getParameter("use_point");
		String join_point = String.valueOf(request.getParameter("join_point"));
		String join_lv = String.valueOf(request.getParameter("join_lv"));
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
		
		int result = this.hi.hp_in(hp_title,ad_mail,use_point,join_point,join_lv,
				corp_name,busi_num,ceo_name,ceo_num,busi_report_num,busi_num_more,
				corp_addnum,corp_add,info_ad_name,info_ad_mail,no_bank,account_num,
				card_pay,phone_pay,coupon_pay,pay_po_min,pay_po_max,receipt,
				deli_corp,deli_pay,deli_day);
		this.pw = response.getWriter();
		if(result != 0) {
			this.pw.write("<script>"
					+ "alert('정상적으로 설정이 저장되었습니다.');"
					+ "location.href='./hp_join_list.do';"
					+ "</script>");
		}else {
			this.pw.write("<script>"
					+ "alert('저장 실패');"
					+ "history.go(-1);"
					+ "</script>");
		}
	}

}

