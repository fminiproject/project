package notice;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class notice_search extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pageNo = request.getParameter("pageNo"); 
		if(pageNo==null){ pageNo = "0"; }  //게시판에 최초 접속시 페이지 배열번호를 0으로 처리  
		
		String keyword = request.getParameter("n_search"); 
		
		m_notice_select ns =  new m_notice_select(Integer.parseInt(pageNo));
		ArrayList<ArrayList<String>> s_result = ns.notice_searchdata(keyword);
		ArrayList<ArrayList<String>> result_top = ns.notice_topdata();
		
		request.setAttribute("keyword", keyword); 
		request.setAttribute("s_result", s_result);
		request.setAttribute("result_top", result_top);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("../notice/notice_list_search.jsp");
		rd.forward(request, response);
		
		
	}

}
