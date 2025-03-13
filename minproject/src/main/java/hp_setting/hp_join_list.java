package hp_setting;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class hp_join_list extends HttpServlet {
	private static final long serialVersionUID = 1L;
	hp_join_select se = new hp_join_select();
	hp_basic_select bs = new hp_basic_select();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<ArrayList<String>> alldata_se = this.se.hp_datalist_se();
		ArrayList<ArrayList<String>> alldata_bs = this.bs.hp_datalist_bs();
		
		request.setAttribute("alldata_se", alldata_se);
		request.setAttribute("alldata_bs", alldata_bs);
		RequestDispatcher rd = request.getRequestDispatcher(".../webapp/admin/admin_siteinfo.jsp");
		rd.forward(request, response);
	}

}
