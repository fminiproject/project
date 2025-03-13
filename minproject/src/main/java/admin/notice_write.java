package admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@MultipartConfig(
	fileSizeThreshold = 1024 * 1024 * 2,  //2MB
	maxFileSize = 1024 * 1024 * 20,  //20MB
	maxRequestSize = 1024*1024 * 500  //500MB 
)
public class notice_write extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PrintWriter pw = null;    
	Integer result = null;
	m_insert mi = new m_insert();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		this.pw = response.getWriter();
		
		try {
			String n_yn = request.getParameter("n_yn");
			String n_subject = request.getParameter("n_subject");
			String n_writer = request.getParameter("n_writer");
			String n_content = request.getParameter("n_content");
			Part n_filenm = request.getPart("n_filenm");
			
			if(n_yn==null) {
				n_yn = "N";
			}
			
			long filesize = n_filenm.getSize();  //파일용량 가져옴
			
			if(filesize==0) { //첨부파일 없을경우 
				this.result = this.mi.insert_notice(n_yn, n_subject, n_writer, n_content);
			
			}else {  //첨부파일 있을경우 
				this.result = this.mi.insert_notice_withf(n_yn, n_subject, n_writer, n_content, n_filenm, request);
			}
			
			
			if(this.result > 0) {
				this.pw.write("<script>"
								+"alert('공지가 등록되었습니다');"
								+"location.href='./notice_list.do';"
								+"</script>");
				
			}else {
				this.pw.write("<script>"
							+"alert('오류발생으로 공지가 등록되지 않았습니다');"
							+"history.go(-1);"
							+"</script>");
			}
			this.pw.close();


		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
	}

}
