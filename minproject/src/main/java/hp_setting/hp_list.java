package hp_setting;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class hp_list extends HttpServlet {
	private static final long serialVersionUID = 1L;
	hp_select se = new hp_select();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<ArrayList<Object>> alldata = this.se.hp_datalist();
		
		request.setAttribute("alldata", alldata);
		RequestDispatcher rd = request.getRequestDispatcher("./admin_siteinfo.jsp");
		rd.forward(request, response);
	}

}
