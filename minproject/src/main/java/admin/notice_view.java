package admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class notice_view extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String nidx = request.getParameter("nidx");
		
		//조회수 +1증가 
		m_update vc = new m_update();
		vc.viewcount(Integer.parseInt(nidx));
		
		//공지 상세페이지 보기
		m_select nv = new m_select(Integer.parseInt(nidx));
		ArrayList<String> n_view = nv.notice_onedata(Integer.parseInt(nidx));
		request.setAttribute("n_view", n_view);  //1개의 게시물 데이터 내용을 jsp로 전달 
		RequestDispatcher rd = request.getRequestDispatcher("./notice_view.jsp");
		rd.forward(request, response);
		
		
		
		
		




	}

}
