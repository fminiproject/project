package admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class m_select {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null; 
	
	String sql="";  
	ArrayList<String> data = null;  //각 컬럼별 값을 저장 
	ArrayList<ArrayList<String>> alldata = null;  //데이터베이스 전체 데이터 
	
	int page = 0;  //첫번째 배열 노드
	int ea = 5; //한페이지당 나타내는 게시물 수 (=>3개) 
	
	m_db db = new m_db();
	
	public m_select(int p) {
		if(p>0) {  //1번 페이징 번호 외에 다른 번호를 클릭했을 때 
			
			this.page= (p - 1)*ea; //sql 쿼리문에서 limit를 사용하기위함
			//(페이지번호 - 1)*한페이지당 출력할 개수  
		}
		else {
			this.page= p; 
		}
	}
	
	
	public ArrayList<ArrayList<String>> notice_data(){
		try {
			this.con = db.getConnection();
			
			this.sql = "select nidx, n_subject, n_writer, n_view, n_date, "
					+ "(select count(*) from notice) as total from notice "
					+ "order by nidx desc limit ?,?";  //기본은 limit0,3
			this.ps = this.con.prepareStatement(this.sql);
			this.ps.setInt(1, this.page);
			this.ps.setInt(2, this.ea);
			this.rs = this.ps.executeQuery();
			
			this.alldata = new ArrayList<ArrayList<String>>();
			
			while(this.rs.next()) {
				this.data = new ArrayList<String>();
				this.data.add(this.rs.getString("nidx"));
				this.data.add(this.rs.getString("n_subject"));
				this.data.add(this.rs.getString("n_writer"));
				this.data.add(this.rs.getString("n_view"));
				this.data.add(this.rs.getString("n_date"));
				this.data.add(this.rs.getString("total"));
				
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
