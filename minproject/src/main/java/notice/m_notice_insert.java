package notice;

import java.sql.Connection;
import java.sql.PreparedStatement;

import common.m_db;

public class m_notice_insert{
	Connection con = null;
	PreparedStatement ps = null;
	
	String sql = "";
	Integer result = null;
	
	m_db db = new m_db();
//	noticeDTO ndto = new noticeDTO() //=>이걸 쓰면 컨트롤러에서 담은 값 초기화되버림
	
	public Integer insert_notice(noticeDTO ndto) {
		try {
			this.con = this.db.getConnection();  //db연결

			this.sql = "insert into admin_notice values ('0',?,?,?,?,?,?,now());";
			this.ps = this.con.prepareStatement(this.sql);
			this.ps.setString(1, ndto.getN_yn());
			this.ps.setString(2, ndto.getN_subject());
			this.ps.setString(3, ndto.getN_writer());
			this.ps.setString(4, ndto.getN_filenm());  ////첨부파일 없을경우 null, 있으면 가져온 파일명 저장
			this.ps.setString(5, ndto.getN_content());
			this.ps.setInt(6, ndto.getN_view());
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
}
