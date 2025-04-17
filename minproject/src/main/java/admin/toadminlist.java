package admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class toadminlist extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PrintWriter pw = null;
	m_select ms = new m_select();
	m_update mu = new m_update();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<ArrayList<String>> mlist = this.ms.memberlist();
		request.setAttribute("mlist", mlist);


		RequestDispatcher rd = request.getRequestDispatcher("./admin_list.jsp");
		rd.forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String mid = request.getParameter("mid");
		System.out.println("mid값" + mid);
		String verified = request.getParameter("verified");
		System.out.println("verified값" + verified);
		String result = this.mu.verified(mid,verified);
		
		this.pw = response.getWriter();
		this.pw.write(result);
		System.out.println("회원 승인 결과 :" + result);
		
	}


}
