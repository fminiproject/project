package admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.DistributedManager;

public class loginout extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PrintWriter pw = null;
	dto_member dm = new dto_member();
	m_select ms = new m_select();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		this.pw = response.getWriter();
		
		dm.setMid(request.getParameter("mid"));
		dm.setMpass(request.getParameter("mpass"));
		


		String result = this.ms.login(this.dm);
		this.pw.write(result);	
		System.out.println(result);
		
		this.dm = ms.dto;
		
		if (result.equals("ok")) {
			HttpSession session = request.getSession();
			//mid,mname,verified
			
			session.setAttribute("dto", this.dm);
			
		}
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		session.invalidate();
		
		
		RequestDispatcher rd = request.getRequestDispatcher("./index.jsp");
		rd.forward(request, response);
	}
}
