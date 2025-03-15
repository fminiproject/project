package admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

public class m_update {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	String sql = "";
	Integer result = null;
	
	m_db db = new m_db();
	
	ArrayList<String> one_notice = null;  //1개 공지데이터만 저장시킴 
	
	//조회수 +1
	public void viewcount(int nidx) {
		try {
			this.con = this.db.getConnection();
			
			this.sql = "update notice set n_view = n_view+1 where nidx=?";
			this.ps = this.con.prepareStatement(this.sql);
			this.ps.setInt(1, nidx);  
			this.ps.executeUpdate();  
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			try {
				this.ps.close();
				this.con.close();
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	
	//공지 내용 수정 
	public Integer n_modify(String nidx, String n_yn, String n_subject, String n_writer, String n_content) {
		try {
			this.con = this.db.getConnection();
			
			this.sql = "update notice set n_yn=?,n_subject=?,n_writer=?,n_content=?,n_filenm='null' where nidx=?";
			this.ps = this.con.prepareStatement(this.sql);
			this.ps.setString(1, n_yn); 
			this.ps.setString(2, n_subject);
			this.ps.setString(3, n_writer);
			this.ps.setString(4, n_content);
			this.ps.setString(5, nidx);
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
				System.out.println("db해제 오류 / e2:" + e2);
			}
		}
		
		return this.result;
	}

	//첨부파일 포함 공지내용 수정 
	public Integer n_modify_withf(String nidx, String n_yn, String n_subject, String n_writer, String n_content, Part n_filenm, HttpServletRequest request) {
		try {
			this.con = this.db.getConnection();
			
			String filenm = n_filenm.getSubmittedFileName();  //파일명 가져옴
			String url = request.getServletContext().getRealPath("/notice_file/");  //첨부파일 저장될 경로 지정
			n_filenm.write(url+filenm);
			
			this.sql = "update notice set n_yn=?,n_subject=?,n_writer=?,n_content=?,n_filenm=?,n_file=? where nidx=?";
			this.ps = this.con.prepareStatement(this.sql);
			this.ps.setString(1, n_yn);
			this.ps.setString(2, n_subject);
			this.ps.setString(3, n_writer);
			this.ps.setString(4, n_content);
			this.ps.setString(5, filenm);
			this.ps.setString(6, url);
			this.ps.setString(7, nidx);
			this.result = this.ps.executeUpdate();  //db에 저장 
		
		} catch (Exception e) {
			this.result = null;
			System.out.println("e : "+ e);
			e.printStackTrace();
			
		} finally {
			try {
				this.ps.close();
				this.con.close();
				
			} catch (Exception e2) {
				System.out.println("파일첨부수정 db해제 오류 / e2:" + e2);
				
			}
		}
		
		return this.result;
	}
	
}
