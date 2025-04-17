package notice;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class notice_modify_view extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Integer result = null;
	String alert = null;
	
	noticeDTO ndto = null;
	m_notice_update nu = null;   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String nidx = request.getParameter("nidx");
		
		m_notice_select ns = new m_notice_select(0);
		ArrayList<String> n_modify_view = ns.notice_onedata(Integer.parseInt(nidx));

		request.setAttribute("n_view", n_modify_view);  //1개의 게시물 데이터 내용을 jsp로 전달 
		RequestDispatcher rd = request.getRequestDispatcher("../notice/notice_modify.jsp");
		rd.forward(request, response);
	}

}
