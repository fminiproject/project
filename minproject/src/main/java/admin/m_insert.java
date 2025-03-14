package admin;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

public class m_insert {
	Connection con = null;
	PreparedStatement ps = null;
	
	String sql = "";
	Integer result = null;
	
	m_db db = new m_db();
	
	public Integer insert_notice(String n_yn, String n_subject, String n_writer, String n_content) {
		try {
			this.con = this.db.getConnection();
	
				this.sql = "insert into notice (nidx, n_yn, n_subject, n_writer, n_content, n_date) values ('0',?,?,?,?,now());";
				this.ps = this.con.prepareStatement(this.sql);
				this.ps.setString(1, n_yn);
				this.ps.setString(2, n_subject);
				this.ps.setString(3, n_writer);
				this.ps.setString(4, n_content);
				this.result = this.ps.executeUpdate(); 
			
		} catch (Exception e) {
			this.result = null;
			System.out.println("e : "+ e);
			e.printStackTrace();
			
		} finally {
			try {
				this.ps.close();
				this.con.close();
				
			} catch (Exception e2) {
				System.out.println("e2:" + e2);
				
			}
		}
		
		return this.result;
	}
	
	public Integer insert_notice_withf(String n_yn, String n_subject, String n_writer, String n_content, Part n_filenm, HttpServletRequest request) {
		try {
			this.con = this.db.getConnection();
			
			String filenm = n_filenm.getSubmittedFileName();  //파일명 가져옴
			String url = request.getServletContext().getRealPath("/notice_file/");  //첨부파일 저장될 경로 지정
			n_filenm.write(url+filenm);
			
			this.sql = "insert into notice (nidx,n_yn,n_subject,n_writer,n_filenm,n_file,n_content,n_date) values ('0',?,?,?,?,?,?,now())";
			this.ps = this.con.prepareStatement(this.sql);
			this.ps.setString(1, n_yn);
			this.ps.setString(2, n_subject);
			this.ps.setString(3, n_writer);
			this.ps.setString(4, filenm);
			this.ps.setString(5, url);
			this.ps.setString(6, n_content);
			this.result = this.ps.executeUpdate();  //db에 저장 
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				this.ps.close();
				this.con.close();
				
			} catch (Exception e2) {
				System.out.println("e2:" + e2);
				
			}
		}
		
		return this.result;
	}
	
	
}
