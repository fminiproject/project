package admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class notice_modify_view extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String nidx = request.getParameter("nidx");
		String n_yn = request.getParameter("n_yn");
		String n_subject = request.getParameter("n_subject");
		String n_writer = request.getParameter("n_writer");
		String n_content = request.getParameter("n_content");
		String n_filenm = request.getParameter("n_filenm");
		System.out.println(nidx);
		
		ArrayList<String> n_modify_view = new ArrayList<String>();
		n_modify_view.add(nidx);
		n_modify_view.add(n_yn);
		n_modify_view.add(n_subject);
		n_modify_view.add(n_writer);
		n_modify_view.add(n_content);
		n_modify_view.add(n_filenm);
		
		System.out.println(n_modify_view);
		request.setAttribute("n_view", n_modify_view);  //1개의 게시물 데이터 내용을 jsp로 전달 
		RequestDispatcher rd = request.getRequestDispatcher("./notice_modify.jsp");
		rd.forward(request, response);
	}

}
