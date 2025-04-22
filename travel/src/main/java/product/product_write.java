package product;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import admin.m_db;
@MultipartConfig(
		fileSizeThreshold = 1024 * 1024 * 5, //5MB
		maxFileSize = 1024 * 1024 * 50,	//최대용량 50MB
		maxRequestSize = 1024 * 1024 * 500
	)
public class product_write extends HttpServlet{
	private static final long serialVersionUID = 1L;
	Connection con = null;
	PreparedStatement pst = null;
	String sql = "";
	m_db db = new m_db();
	ResultSet rs = null;
	PrintWriter pw = null;
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		this.pw = resp.getWriter();
		 String pcode = req.getParameter("pcode");
		    try {
		        this.con = this.db.getConnection();
		        this.sql = "SELECT COUNT(*) FROM p_register WHERE pcode = ?";
		        this.pst = this.con.prepareStatement(this.sql);
		        this.pst.setString(1, pcode);
		        this.rs = this.pst.executeQuery();
		        
		        if (rs.next()) {
		            int count = rs.getInt(1);
		            if (count > 0) {
		                this.pw.write("dup");
		            } else {
		                this.pw.write("nodup");
		            }
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		    } finally {
		        try {
		            if (this.rs != null) this.rs.close();
		            if (this.pst != null) this.pst.close();
		            if (this.con != null) this.con.close();
		            this.pw.close();
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		    }
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		this.pw = resp.getWriter();
		Part pfile = req.getPart("pimg");
		long fs = pfile.getSize();
		
		try {
			
			this.con = this.db.getConnection();
			String pbigca = req.getParameter("pbigca");
			String pcode = req.getParameter("pcode");
			String pname = req.getParameter("pname");
			
			String pprice = req.getParameter("pprice");
			String psale = req.getParameter("psale");
			String pcount = req.getParameter("pcount");
			String psell = req.getParameter("psell");
			String psoldout = req.getParameter("psoldout");
			String pdetail = req.getParameter("pdetail");
			String pimg = pfile.getSubmittedFileName();
			
			int result = 0;
			
			if(fs == 0) {
				this.sql = "insert into p_register (pidx,pbigca,pcode,pname,pprice,psale,pcount,psell,psoldout,pimg,pdetail,pdate) "
						+ "values ('0',?,?,?,?,?,?,?,?,?,?,now())";
				this.pst = this.con.prepareStatement(this.sql);
				this.pst.setString(1, pbigca);
				this.pst.setString(2, pcode);
				this.pst.setString(3, pname);
				this.pst.setString(4, pprice);
				this.pst.setString(5, psale);
				this.pst.setString(6, pcount);
				this.pst.setString(7, psell);
				this.pst.setString(8, psoldout);
				this.pst.setString(9, pimg);
				this.pst.setString(10, pdetail);
				
				result = this.pst.executeUpdate();
				if(result > 0) {
					this.pw.write("<script>"
							+ "alert('상품이 정상 등록 되었습니다.');"
							+ "location.href = './a_product_listok.do';"
							+ "</script>");
				}else {
                    this.pw.write("<script>"
                            + "alert('상품 등록에 실패했습니다.');"
                            + "history.go(-1);"
                            + "</script>");
				}
			}else {
				product_img pi = new product_img(pfile, pbigca, pcode, pname, pprice, psale, pcount, psell, psoldout, pimg, pdetail, req);
				String msg = pi.msg;
				
				if(msg.equals("ok")) {
	                 this.pw.write("<script>"
	                            + "alert('상품이 정상 등록 되었습니다.');"
	                            + "location.href = './a_product_listok.do';"
	                            + "</script>");
				}else if (pi.msg.equals("error")) {
                    this.pw.write("<script>"
                            + "alert('파일 업로드 또는 데이터베이스 저장 중 오류가 발생했습니다.');"
                            + "history.go(-1);"
                            + "</script>");
                } else {
                    this.pw.write("<script>"
                            + "alert('상품 등록에 실패했습니다.');"
                            + "history.go(-1);"
                            + "</script>");
				}
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
            this.pw.write("<script>"
                    + "alert('상품 등록 중 오류가 발생했습니다.');"
                    + "history.go(-1);"
                    + "</script>");
		}finally {
			try {
				this.pst.close();
				this.con.close();
				this.pw.close();
			}catch (Exception e) {
				
			}
		}
	}
}
