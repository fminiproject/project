package notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.m_db;

public class m_notice_select {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null; 
	
	String sql="";  
	ArrayList<String> data = null;  //각 컬럼별 값을 저장 
	ArrayList<ArrayList<String>> alldata = null;  
	
	int page = 0;  //첫번째 배열 노드
	int ea = 5; //한페이지당 나타내는 게시물 수
	
	m_db db = new m_db();
	
	public m_notice_select(int pno) {
		if(pno>0) {  //1번 페이징 번호 외에 다른 번호를 클릭했을 때 
			this.page= (pno - 1)*ea; 
			//(페이지번호 - 1)*한페이지당 출력할 개수  
		}
		else {
			this.page= pno; 
		}
	}
	
	//공지 테이블에 있는 전체 데이터 가져오는 메소드 
	public ArrayList<ArrayList<String>> notice_alldata(){
		try {
			this.con = db.getConnection();
			
			this.sql = "select nidx, n_yn, n_subject, n_writer, n_view, n_date, n_filenm, "
					+ "(select count(*) from admin_notice) as total from admin_notice "
					+ "order by nidx desc limit ?,?";  
			this.ps = this.con.prepareStatement(this.sql);
			this.ps.setInt(1, this.page);
			this.ps.setInt(2, this.ea);
			this.rs = this.ps.executeQuery();

			this.alldata = new ArrayList<ArrayList<String>>();
			while(this.rs.next()) {
				this.data = new ArrayList<String>();
				this.data.add(this.rs.getString("nidx"));
				this.data.add(this.rs.getString("n_yn"));
				this.data.add(this.rs.getString("n_subject"));
				this.data.add(this.rs.getString("n_writer"));
				this.data.add(this.rs.getString("n_view"));
				this.data.add(this.rs.getString("n_date"));
				this.data.add(this.rs.getString("total"));
				this.data.add(this.rs.getString("n_filenm"));
				
				this.alldata.add(this.data);
			}
				
		} catch (Exception e) {
			this.alldata = null;
			e.printStackTrace();
			
		} finally {
			try {
				this.rs.close();
				this.ps.close();
				this.con.close();
				
			} catch (SQLException e) {
				this.alldata = null;
			}
		}
		return this.alldata;
	}

	
	//상단노출 공지 데이터 가져오는 메소드
	public ArrayList<ArrayList<String>> notice_topdata(){
		try {
			this.con = db.getConnection();
			
			this.sql = "select nidx, n_yn, n_subject, n_writer, n_view, n_date, n_filenm, "
					+ "(select count(*) from admin_notice) as total from admin_notice "
					+ "where n_yn = 'Y'";  
			this.ps = this.con.prepareStatement(this.sql);
			this.rs = this.ps.executeQuery();
			
			this.alldata = new ArrayList<ArrayList<String>>();
			
			while(this.rs.next()) {
				this.data = new ArrayList<String>();
				this.data.add(this.rs.getString("nidx"));
				this.data.add(this.rs.getString("n_yn"));
				this.data.add(this.rs.getString("n_subject"));
				this.data.add(this.rs.getString("n_writer"));
				this.data.add(this.rs.getString("n_view"));
				this.data.add(this.rs.getString("n_date"));
				this.data.add(this.rs.getString("total"));
				this.data.add(this.rs.getString("n_filenm"));
				
				this.alldata.add(this.data);
			}
			
		} catch (Exception e) {
			this.alldata = null;
			e.printStackTrace();
			
		} finally {
			try {
				this.rs.close();
				this.ps.close();
				this.con.close();
				
			} catch (SQLException e) {
				this.alldata = null;
			}
		}
		return this.alldata;
	}
	
	
	//공지 하나의 데이터만 가져오는 메소드 
	public ArrayList<String> notice_onedata(int nidx){
		try {
			this.con = db.getConnection();
			
			this.sql = "select * from admin_notice where nidx=?";
			this.ps = this.con.prepareStatement(this.sql);
			this.ps.setInt(1, nidx);  
			this.rs = this.ps.executeQuery();
			
			if(this.rs.next()!=false) {  //해당 조건에 맞는 데이터값이 있을때 첫번째결과값만 가져옴
				this.data = new ArrayList<String>();
				
				this.data.add(this.rs.getString("nidx"));
				this.data.add(this.rs.getString("n_yn"));
				this.data.add(this.rs.getString("n_subject"));
				this.data.add(this.rs.getString("n_writer"));
				this.data.add(this.rs.getString("n_filenm"));
				this.data.add(this.rs.getString("n_content"));
				this.data.add(this.rs.getString("n_view"));
				this.data.add(this.rs.getString("n_date"));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				this.rs.close();
				this.ps.close();
				this.con.close();
				
			} catch (Exception e2) {
				
			}
		}
		return this.data;
	}
	
	
	//검색된 공지리스트 가져오는 메소드
	public ArrayList<ArrayList<String>> notice_searchdata(String keyword){
		try {
			this.con = db.getConnection();
			
			this.sql = "select nidx, n_yn, n_subject, n_writer, n_view, n_date, n_filenm, "
					+ "(select count(*) from admin_notice where n_subject like ? ) as total from admin_notice "
					+ "where n_subject like ? order by nidx desc limit ?,?";  
			this.ps = this.con.prepareStatement(this.sql);
			this.ps.setString(1, "%"+keyword+"%");
			this.ps.setString(2, "%"+keyword+"%");
			this.ps.setInt(3, this.page);
			this.ps.setInt(4, this.ea);
			this.rs = this.ps.executeQuery();

			this.alldata = new ArrayList<ArrayList<String>>();
			while(this.rs.next()) {
				this.data = new ArrayList<String>();
				this.data.add(this.rs.getString("nidx"));
				this.data.add(this.rs.getString("n_yn"));
				this.data.add(this.rs.getString("n_subject"));
				this.data.add(this.rs.getString("n_writer"));
				this.data.add(this.rs.getString("n_view"));
				this.data.add(this.rs.getString("n_date"));
				this.data.add(this.rs.getString("total"));
				this.data.add(this.rs.getString("n_filenm"));
				
				this.alldata.add(this.data);
			}
				
		} catch (Exception e) {
			this.alldata = null;
			e.printStackTrace();
			
		} finally {
			try {
				this.rs.close();
				this.ps.close();
				this.con.close();
				
			} catch (SQLException e) {
				this.alldata = null;
			}
		}
		return this.alldata;
	}
}
