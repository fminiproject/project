package hp_setting;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class hp_join_joinok extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PrintWriter pw = null;
	hp_join_insert hi = new hp_join_insert(); 
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");	// front-end에서 한글이 전송될 경우에만 사용
		response.setContentType("text/html;charset=utf-8");		// Javascript에서 한글 사용할 경우
		
		String hp_title = request.getParameter("hp_title");
		String ad_mail = request.getParameter("ad_mail");
		String use_point = request.getParameter("use_point");
		String join_point = request.getParameter("join_point");
		String join_lv = request.getParameter("join_lv");
		
		int result = this.hi.hp_in(hp_title,ad_mail,use_point,join_point,join_lv);
		this.pw = response.getWriter();
		if(result > 0) {
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
