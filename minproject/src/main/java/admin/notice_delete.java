package admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class notice_delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PrintWriter pw = null;
	Connection con = null;
	PreparedStatement ps = null;
	
	String sql = "";  
	int result= 0;
	
	m_db db = new m_db(); //db정보 모델 가져옴

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		this.pw = response.getWriter();
		
		String nidx = request.getParameter("nidx");
		String[]n_ch = request.getParameterValues("n_ch");
		
		System.out.println(nidx);
		System.out.println(n_ch);
		try {
			this.con = this.db.getConnection(); 
			
			//리스트에서 삭제한경우 
			if(n_ch != null && n_ch.length > 0 && nidx == null) {//null체크 먼저 할것
				int w=0;
				while(w<n_ch.length) {
					this.sql = "delete from notice where nidx=?";
					this.ps = this.con.prepareStatement(this.sql);
					this.ps.setString(1, n_ch[w]);  
					this.result = this.ps.executeUpdate();
					
					w++;
				}
				
			//내용보기에서 삭제한경우
			} else if((n_ch == null || n_ch.length == 0) && nidx != null){
				this.sql = "delete from notice where nidx=?";
				this.ps = this.con.prepareStatement(this.sql);
				this.ps.setString(1, nidx);  
				this.result = this.ps.executeUpdate();
			}
		
			if(this.result>0) {
				this.pw.write("<script>"
							+"alert('삭제완료되었습니다');"
							+"location.href='./notice_list.do';"
							+"</script>");
			}

		} catch (Exception e) {
			System.out.println("result에러");
			System.out.println(e);
			
		} finally {
			try {
				this.pw.close();
				this.ps.close();
				this.con.close();
			
			} catch (Exception e2) {
				System.out.println("DB접속 해제권한 오류");
				System.out.println(e2);
			}
		}
	}
}
