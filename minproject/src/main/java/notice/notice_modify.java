package notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import common.m_file;
import common.m_message;

@MultipartConfig(
	fileSizeThreshold = 1024 * 1024 * 2,  //2MB
	maxFileSize = 1024 * 1024 * 20,  //20MB
	maxRequestSize = 1024*1024 * 500  //500MB 
)
public class notice_modify extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Integer result = null;
	String alert = null;
	
	noticeDTO ndto = new noticeDTO();
	m_notice_update nu = null;   
	m_message msg = null;
	m_file mf = null;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String nidx = request.getParameter("nidx");
		String n_yn = request.getParameter("n_yn");
		String n_subject = request.getParameter("n_subject");
		String n_writer = request.getParameter("n_writer");
		String n_content = request.getParameter("n_content");
		Part n_filenm = request.getPart("n_filenm");
		String current_f = request.getParameter("current_f");
		
		if(n_yn==null){ n_yn = "N";}

		this.mf = new m_file();
		String save ="/notice_file/";
		String fnm = mf.file_attach(n_filenm, save, request);
		
		if(fnm==null){ fnm = current_f; }
		
		this.ndto.setNidx(Integer.parseInt(nidx));
		this.ndto.setN_yn(n_yn);
		this.ndto.setN_subject(n_subject);
		this.ndto.setN_writer(n_writer);
		this.ndto.setN_filenm(fnm);
		this.ndto.setN_content(n_content);
		
		this.nu = new m_notice_update();
		this.result = this.nu.modify_notice(this.ndto);
		
		this.msg = new m_message();
		if(this.result >0 ) {
			this.alert="alert('공지가 수정되었습니다');"+"location.href='../notice/notice_view.do?nidx=" + this.ndto.getNidx() + "';";
			
		} else {
			this.alert="alert('시스템문제로 공지가 수정되지 않았습니다.');"+"location.href='../notice/notice_view.do?nidx=" + this.ndto.getNidx() + "';";
			
		}
		this.msg.message(this.alert,response);

	}

}
