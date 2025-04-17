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
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<ArrayList<Object>> alldata = this.se.hp_datalist();
		
		// setString, setInt 등 : 단일 데이터 가져올 때 사용
		// setAttribute() : 배열 값 가져올 때 사용
		// 가져온 배열 데이터를 변수에 담음
		request.setAttribute("alldata", alldata);
		// getRequestDispatcher() : 참조할 페이지 설정
		// 가상의 url은 /admin/hp_list.do 이고, 
		// 페이지 설정은 ./admin_siteinfo.jsp 를 참조하게 되고 이곳으로 데이터 보냄
		// 이 방식으로 접속해야지만 doGet으로 가져온 데이터를 사용할 수 있음
		RequestDispatcher rd = request.getRequestDispatcher("./admin_siteinfo_list.jsp");
		rd.forward(request, response);
	}
}