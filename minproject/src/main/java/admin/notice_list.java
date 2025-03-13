package admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class notice_list extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pageNo = request.getParameter("pageNo");  //사용자가 페이지 번호 클릭시 해당값을 받는 역할 
		//스트링으로 받고 넘길때 Integer.parseInt로 변환해서넘김 
		
		if(pageNo==null){  //게시판에 최초 접속시 페이지 배열번호를 0으로 처리  
			pageNo = "0";
		}
		
		
		m_select ms = new m_select(Integer.parseInt(pageNo));
		ArrayList<ArrayList<String>> result = ms.notice_data();
		request.setAttribute("result", result); 
		
		RequestDispatcher rd = request.getRequestDispatcher("./notice_list.jsp");
		rd.forward(request, response);

	}

}
