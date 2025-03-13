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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<ArrayList<String>> alldata = this.se.hp_data_list();
		
		request.setAttribute("alldata", alldata);
		RequestDispatcher rd = request.getRequestDispatcher("./mail_list.jsp");
		rd.forward(request, response);
	}

}
