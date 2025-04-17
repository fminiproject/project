package notice;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.m_db;
import common.m_message;


public class notice_delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con = null;
	PreparedStatement ps = null;
	
	String sql = "";  
	int result= 0;
	String alert="";
	
	m_db db = new m_db(); //db정보 모델 가져옴   
	m_message msg = new m_message();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String nidx = request.getParameter("nidx");
		String[]n_ch = request.getParameterValues("n_ch");
		try {
			this.con = this.db.getConnection(); 
			
			this.sql = "delete from admin_notice where nidx=?";
			this.ps = this.con.prepareStatement(this.sql);
			
			//리스트에서 삭제한경우 
			if(n_ch != null && n_ch.length > 0 && nidx == null) {//체크박스 체크건이 있는경우(null체크 먼저 할것)
				int w=0;
				while(w<n_ch.length) {			
					this.ps.setString(1, n_ch[w]);  
					this.result = this.ps.executeUpdate();
					
					w++;
				}
				
			//내용보기에서 삭제한경우
			} else if((n_ch == null || n_ch.length == 0) && nidx != null){
				this.ps.setString(1, nidx);  
				this.result = this.ps.executeUpdate();
			}
			
			if(this.result>0) {
				this.alert="alert('공지가 삭제되었습니다');"+"location.href='../notice/notice_list.do';";
			}else {
				this.alert="alert('시스템 문제로 공지삭제에 실패했습니다');"+"location.href='../notice/notice_list.do';";
			}
			this.msg.message(this.alert,response);

		} catch (Exception e) {
			System.out.println("result에러");
			System.out.println(e);
			
		} finally {
			try {
				this.ps.close();
				this.con.close();
			
			} catch (Exception e2) {
				System.out.println("DB접속 해제권한 오류");
				System.out.println(e2);
			}
		}
		
	}

	

}
