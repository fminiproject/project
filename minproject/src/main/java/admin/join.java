package admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class join extends HttpServlet {
	PrintWriter pw = null;
	dto_member dn = new dto_member();
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		this.pw = response.getWriter();

		this.dn.setMid(request.getParameter("mid"));
		this.dn.setMpass(request.getParameter("mpass"));
		this.dn.setMname(request.getParameter("mname"));
		this.dn.setMtel(request.getParameter("mtel"));
		this.dn.setMemail(request.getParameter("memail"));
		this.dn.setMpart(request.getParameter("mpart"));
		this.dn.setMposition(request.getParameter("mposition"));
		
		m_insert mi = new m_insert();
		String result =  mi.joinresult(this.dn);
		
		if (result.equals("ok")) {
			this.pw.write("ok");

		} else {
			this.pw.write("false");
		}

		this.pw.close();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("./add_master.jsp");
		rd.forward(request, response);
	}

}
