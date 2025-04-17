package admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import common.m_db;

public class m_select {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	String sql = null;
	String result = null;
	m_db db = new m_db();
	dto_member dto = new dto_member();
	ArrayList<String> data = null;
	ArrayList<ArrayList<String>> alldata = null;


	
	
	public ArrayList<ArrayList<String>> memberlist() {
		try {
			this.con = this.db.getConnection();
			this.sql = "select * from member order by midx desc";
			this.ps = this.con.prepareStatement(this.sql);
			this.rs = this.ps.executeQuery();
			System.out.println("ResultSet" + this.rs);
			this.alldata = new ArrayList<ArrayList<String>>();
			
			while (this.rs.next()) {
				this.data = new ArrayList<String>();
				this.data.add(String.valueOf(this.rs.getInt("midx")));
				this.data.add(this.rs.getString("mid"));
				this.data.add(this.rs.getString("mpass"));
				this.data.add(this.rs.getString("mname"));
				this.data.add(this.rs.getString("memail"));
				this.data.add(this.rs.getString("mtel"));
				this.data.add(this.rs.getString("mpart"));
				this.data.add(this.rs.getString("mposition"));
				
				String date = this.rs.getString("mdate");
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date d = sdf.parse(date);
				String mdate = sdf.format(d);

				this.data.add(mdate);
				this.data.add(this.rs.getString("verified"));
				
				this.alldata.add(this.data);

			}
			System.out.println("select 모델" + this.alldata);

			
		} catch (Exception e) {
			return null;
			
		} finally {
			try {
				this.rs.close();
				this.ps.close();
				this.con.close();
			} catch (Exception e2) {
			}
		}

		return this.alldata;
	}
	
	
	public String login(dto_member dm) {
		try {
			this.con = this.db.getConnection();
			this.sql = "select mid,mpass,mname,verified from member where mid=? and mpass=?";
			this.ps = this.con.prepareStatement(this.sql);
			
			this.ps.setString(1, dm.getMid());
			this.ps.setString(2, dm.getMpass());
			
			this.rs = this.ps.executeQuery();
			
			if (this.rs.next()) { // 아이디 비밀번호 일치
				this.dto.setMid(this.rs.getString("mid"));
				this.dto.setMpass(this.rs.getString("mpass"));
				this.dto.setMname(this.rs.getString("mname"));
				this.dto.setVerified(this.rs.getString("verified"));
				

				if(this.dto.getVerified().equals("Y")) {
					this.result = "ok";
				} else {
					this.result = "disapproval";
				}
			} else { //아이디 비밀번호 불일치 or null
				this.result = "false";
			}

		} catch (Exception e) {
			this.result = "false";
		} finally {
			try {
				this.rs.close();
				this.ps.close();
				this.con.close();
			} catch (Exception e2) {
			}
		}
		System.out.println(this.result);
		return this.result;

	}
	
	
	public String idcheck (String a) {
		try {
			String mid = a;
			
			this.con = this.db.getConnection();
			this.sql = "select mid from member where mid=?";
			this.ps = this.con.prepareStatement(this.sql);
			
			this.ps.setString(1, mid);
			
			this.rs = this.ps.executeQuery();
			
			//next()는 true false 반환 검색할 게 한 개인 경우 while 불필요
			//중복체크는 단순 검사라 getstring 불필요
			
			if (this.rs.next()) {  //아이디가 있다면
				this.result = "false";
				
			} else { //아이디가 없다면
				this.result = "ok";
			}
			
		} catch (Exception e) {
			this.result = "false";
		} finally {
			try {
				this.rs.close();
				this.ps.close();
				this.con.close();
			} catch (Exception e2) {
			}
		}

		return this.result;
	}
	
	
	
	
}
