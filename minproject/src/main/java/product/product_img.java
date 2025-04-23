package product;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import common.m_db;

public class product_img {
	Connection con = null;
	PreparedStatement pst = null;
	m_db db = new m_db();
	
	String sql = "";
	int result = 0;
	public String msg = "";
	String pbigca,pcode,pname,pprice,psale,pcount,psell,psoldout,pdetail,pimg;
	
	public product_img(Part pfile, String pbigca, String pcode, String pname
			, String pprice, String psale, String pcount, String psell,String psoldout,String img, String pdetail, HttpServletRequest req) throws Exception{
		this.pbigca = pbigca;
		this.pcode = pcode;
		this.pname = pname;
		this.pprice = pprice;
		this.psale = psale;
		this.pcount = pcount;
		this.psell = psell;
		this.psoldout = psoldout;
		this.pdetail = pdetail;
		this.pimg = pimg;
		
		long fs = pfile.getSize();
		String filenm = pfile.getSubmittedFileName();
		String url = req.getServletContext().getRealPath("/product_file/");
		try {
			pfile.write(url+filenm);
			this.fileok(filenm);
		}catch (Exception e) {
			this.fileok("error");
		}
		
	}
	private String fileok(String data) throws Exception{
		if(data.equals("error")) {
			this.msg = "error";
		}else {
			try {
				this.con = this.db.getConnection();
				this.sql = "insert into p_register (pdix,pbigca,pcode,pname,pprice,psale,pcount,psell,psoldout,pimg,pdetail) "
						+ "valus ('0',?,?,?,?,?,?,?,?,?,?,now())";
				this.pst = this.con.prepareStatement(this.sql);
				this.pst.setString(1, pbigca);
				this.pst.setString(2, pcode);
				this.pst.setString(3, pname);
				this.pst.setString(4, pprice);
				this.pst.setString(5, psale);
				this.pst.setString(6, pcount);
				this.pst.setString(7, psell);
				this.pst.setString(8, psoldout);
				this.pst.setString(9, data);
				this.pst.setString(10, pdetail);
				
				result = this.pst.executeUpdate();
				if(this.result > 0) {
					this.msg = "ok";
				}else {
					this.msg = "NO";
				}
			}catch (Exception e) {
				System.out.println(e.getMessage());
				this.msg="error";
			}finally {
				try {
					this.pst.close();
					this.con.close();
				}catch (Exception e) {
				
				}
				
			}
		}
		return this.msg;
	}
	
}
