package product;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class a_product_listok extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pageno = req.getParameter("pageno");
        int pageNo = 1; // 기본 페이지 번호

        if (pageno == null || pageno.isEmpty()) {
            pageNo = 1;
        } else {
            try {
                pageNo = Integer.parseInt(pageno);
            } catch (NumberFormatException e) {
                // 페이지 번호가 숫자가 아닌 경우, 기본값 1로 설정
                pageNo = 1;
            }
        }

        int spage = (pageNo - 1) * 5; // 페이지 시작 위치 계산

        String hw_select = req.getParameter("hw_select");
        String hw_s_word = req.getParameter("hw_s_word");

        a_product ap = new a_product(spage);
        ArrayList<ArrayList<String>> result = ap.ap_data(hw_select, hw_s_word);

        req.setAttribute("result", result);

        RequestDispatcher rd = req.getRequestDispatcher("./product_view.jsp");
        rd.forward(req, resp);
    }
}
