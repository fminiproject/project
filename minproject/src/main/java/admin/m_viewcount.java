package admin;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class m_viewcount {
	Connection con = null;
	PreparedStatement ps = null;
	
	String sql = "";
	Integer result = null;
	
	m_db db = new m_db();
	
	public void viewcount(int nidx) {
		try {
			this.con = this.db.getConnection();
			
			this.sql = "update notice set n_view = n_view+1 where nidx=?";
			this.ps = this.con.prepareStatement(this.sql);
			this.ps.setInt(1, nidx);  
			this.ps.executeUpdate();  
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
}
