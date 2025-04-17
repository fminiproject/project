
package hp_setting;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * doPost 기능은 사용자가 url에 입력한 값을 나에게 전송해서(post) 저장할 때 사용
 * doGet  기능은 내가 이미 가지고 있는 데이터를 가져와(get) url로 내보낼 때 사용
 */


// /admin/admin_siteinfo.jsp  =>  ./hp_joinok.do (hp_join 참조, 가상의 url이 같은 디렉토리 안에 만들어졌기 때문에 ./ 로 경로 설정)
// =>   ./hp_list.do(hp_select 참조)   =>   ./admin_siteinfo_list.jsp

// 순서  :  jsp(<=js)  =>  hp_joinok.do(hp_join.java 참조)  =>  hp_join.java(<=hp_insert(<=m_db))  =>  ./hp_list.do

// 홈페이지에 입력된 값을 받아 hp_insert에서 insert 시킨 후 
public class hp_joinok extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PrintWriter pw = null;	// 서블렛으로 명령어 실행시키기 위해 사용		=> close 해야 함
	hp_insert hi = new hp_insert();		// 가져온 데이터를 데이터를 DB에 insert 시킴
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");	// 한글이 전송되므로 사용
		response.setContentType("text/html;charset=utf-8");		// Javascript에서 한글 사용하기 때문에 사용
		
		/*
		// jsp에 입력된 value값을 가져와서 String 변수에 넣음
		// getParameter() 로 가져오면 다 String형이 됨
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
		*/
		
		/*
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
		*/
		/*
		// hp_insert.java에 매개변수로 위의 String 변수들을 넣음
		int result = this.hi.hp_in(hp_title,ad_mail,use_point,join_point,join_lv,
				corp_name,busi_num,ceo_name,ceo_num,busi_report_num,busi_num_more,
				corp_addnum,corp_add,info_ad_name,info_ad_mail,no_bank,account_num,
				card_pay,phone_pay,coupon_pay,pay_po_min,pay_po_max,receipt,
				deli_corp,deli_pay,deli_day);
		
		// 클라이언트에게 응답을 보내기 위해 PrintWriter 초기화 
		this.pw = response.getWriter();
//		System.out.println(this.pw);
		
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
		*/
		
		// DTO 파일을 새로 불러옴
		hp_DTO dto = new hp_DTO();
		
		
		// DTO ( setter 메소드에 Front-end가 전달한 값을 모두 이관)
		// dto라는 변수에 위에서 가져온 값들 넣음
		dto.setHp_title(request.getParameter("hp_title"));
		dto.setAd_mail(request.getParameter("ad_mail"));
		dto.setUse_point(request.getParameter("use_point"));
		dto.setJoin_point(request.getParameter("join_point"));
		dto.setJoin_lv(request.getParameter("join_lv"));
		dto.setCorp_name(request.getParameter("corp_name"));
		dto.setBusi_num(request.getParameter("busi_num"));
		dto.setCeo_name(request.getParameter("ceo_name"));
		dto.setCeo_num(request.getParameter("ceo_num"));
		dto.setBusi_report_num(request.getParameter("busi_report_num"));
		dto.setBusi_num_more(request.getParameter("busi_num_more"));
		dto.setCorp_addnum(request.getParameter("corp_addnum"));
		dto.setCorp_add(request.getParameter("corp_add"));
		dto.setInfo_ad_name(request.getParameter("info_ad_name"));
		dto.setInfo_ad_mail(request.getParameter("info_ad_mail"));
		dto.setNo_bank(request.getParameter("no_bank"));
		dto.setAccount_num(request.getParameter("account_num"));
		dto.setCard_pay(request.getParameter("card_pay"));
		dto.setPhone_pay(request.getParameter("phone_pay"));
		dto.setCoupon_pay(request.getParameter("coupon_pay"));
		dto.setPay_po_min(request.getParameter("pay_po_min"));
		dto.setPay_po_max(request.getParameter("pay_po_max"));
		dto.setReceipt(request.getParameter("receipt"));
		dto.setDeli_corp(request.getParameter("deli_corp"));
		dto.setDeli_pay(request.getParameter("deli_pay"));
		dto.setDeli_day(request.getParameter("deli_day"));
		
		
		// DTO 값을 insert Model로 전달
		// 값을 넣은 dto를 hp_insert.hp_in 으로 매개변수로 보내고, 그것들을 실행한 다음 그 최종값을 result라는 변수에 담은 후, 그것을 불러와 result_dto라는 변수에 담음
		Integer result_dto = new hp_insert().hp_in(dto);
		
		this.pw = response.getWriter();
		
		if(result_dto == 1) {	// 삽입이 성공할 경우 성공 메시지를 알림
			this.pw.write("<script>"
					+ "alert('정상적으로 설정이 저장되었습니다.');"
					+ "location.href='./hp_list.do';"	// 설정 저장 시 설정이 입력된 페이지로 감
					+ "</script>");
		}else if(result_dto == 0){		// 삽입이 실패할 경우 오류 메시지를 알림
			this.pw.write("<script>"
					+ "alert('설정 저장에 실패했습니다. 다시 시도해 주세요.');"
					+ "history.go(-1);"
					+ "</script>");
		}
		
		this.pw.close();
	}
}