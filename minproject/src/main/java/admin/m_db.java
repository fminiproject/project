package admin;

import java.sql.Connection;
import java.sql.DriverManager;

//Database 연결 모델
public class m_db {
	
	public static Connection getConnection() throws Exception {
		String db_driver = "com.mysql.jdbc.Driver";
		String db_url = "jdbc:mysql://kbsn.or.kr:3306/chang_f"; 
		String db_user = "chang_f";
		String db_passswd = "f2025chang";
				
		Class.forName(db_driver);
		Connection con = DriverManager.getConnection(db_url, db_user, db_passswd);
		System.out.println(con);
	
		return con; 
		
	}
}