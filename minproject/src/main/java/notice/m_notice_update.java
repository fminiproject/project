package notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import common.m_db;

public class m_notice_update {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	String sql = "";
	Integer result = null;
	
	m_db db = new m_db();
	
	ArrayList<String> one_notice = null;  //1개 공지데이터만 저장시킴 
	
	//공지 조회수 +1
	public void viewcount(int nidx) {
		try {
			this.con = this.db.getConnection();
			
			this.sql = "update admin_notice set n_view = n_view+1 where nidx=?";
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
	public Integer modify_notice(noticeDTO ndto) {
		try {
			this.con = this.db.getConnection();
			
			this.sql = "update admin_notice set n_yn=?,n_subject=?,n_writer=?,n_content=?,n_filenm=? where nidx=?";
			this.ps = this.con.prepareStatement(this.sql);
			this.ps.setString(1, ndto.getN_yn()); 
			this.ps.setString(2, ndto.getN_subject());
			this.ps.setString(3, ndto.getN_writer());
			this.ps.setString(4, ndto.getN_content());
			this.ps.setString(5, ndto.getN_filenm());
			this.ps.setInt(6, ndto.getNidx());
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

}
