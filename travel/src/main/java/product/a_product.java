package product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import admin.m_db;

public class a_product {
	Connection con = null;
	PreparedStatement pst = null;
	String sql = "";
	m_db db = new m_db();
	ResultSet rs = null;
	
	ArrayList<String> p_data = null;
	ArrayList<ArrayList<String>> palldata = null;
	int spage = 0;
	int ea = 5;
	
	public a_product() {
		
	}
	public a_product(int s) {
		this.spage = s;
	}
	
	
	public ArrayList<ArrayList<String>> ap_data(String hw_select ,String hw_s_word){
		try {
			// 전체 상품 조회
			if (hw_s_word == null || hw_s_word.isEmpty()) {
				this.con = this.db.getConnection();
				this.sql = "select pidx,pcode,pimg,pname,pbigca,psmallca,pprice,psale,pcount,psell,psoldout, (select count(*) from p_register) as alltotal "
						+ "from p_register order by pprice desc limit ?,?"; 
				this.pst = this.con.prepareStatement(this.sql);
				this.pst.setInt(1, this.spage);
				this.pst.setInt(2, this.ea);
				
				this.rs = this.pst.executeQuery();

				this.palldata = new ArrayList<ArrayList<String>>();
				while (this.rs.next()) {
					this.p_data = new ArrayList<String>();
					this.p_data.add(this.rs.getString("pidx"));
					this.p_data.add(this.rs.getString("pcode"));
					this.p_data.add(this.rs.getString("pimg"));
					this.p_data.add(this.rs.getString("pname"));
					this.p_data.add(this.rs.getString("pbigca"));
					this.p_data.add(this.rs.getString("psmallca"));
					this.p_data.add(this.rs.getString("pprice"));
					this.p_data.add(this.rs.getString("psale"));
					this.p_data.add(this.rs.getString("pcount"));
					this.p_data.add(this.rs.getString("psell"));
					this.p_data.add(this.rs.getString("psoldout"));
					this.p_data.add(this.rs.getString("alltotal"));
					this.palldata.add(this.p_data);
				}
			}else { 
			//상품명 검색 조회
			if("selname".equals(hw_select)) {
			this.con = this.db.getConnection();
			this.sql = "select pidx,pcode,pimg,pname,pbigca,psmallca,pprice,psale,pcount,psell,psoldout, (select count(*) from p_register WHERE pname LIKE ?) as alltotal "
					+ "from p_register where pname LIKE ? order by pprice desc limit ?,?";

			this.pst = this.con.prepareStatement(this.sql);
			this.pst.setString(1, "%"+hw_s_word+"%");
			this.pst.setString(2, "%"+hw_s_word+"%");
			this.pst.setInt(3, this.spage);
			this.pst.setInt(4, this.ea);
			this.rs = this.pst.executeQuery();
			
			
			this.palldata = new ArrayList<ArrayList<String>>();
			while(this.rs.next()) {
				this.p_data = new ArrayList<String>();
				this.p_data.add(this.rs.getString("pidx"));
				this.p_data.add(this.rs.getString("pcode"));
				this.p_data.add(this.rs.getString("pimg"));
				this.p_data.add(this.rs.getString("pname"));
				this.p_data.add(this.rs.getString("pbigca"));
				this.p_data.add(this.rs.getString("psmallca"));
				this.p_data.add(this.rs.getString("pprice"));
				this.p_data.add(this.rs.getString("psale"));
				this.p_data.add(this.rs.getString("pcount"));
				this.p_data.add(this.rs.getString("psell"));
				this.p_data.add(this.rs.getString("psoldout"));
				this.p_data.add(this.rs.getString("alltotal"));
				this.palldata.add(this.p_data);
			}
			}
			//상품코드 검색 조회
			else if ("selcode".equals(hw_select)) {
				this.con = this.db.getConnection();
				this.sql = "select pidx,pcode,pimg,pname,pbigca,psmallca,pprice,psale,pcount,psell,psoldout, (select count(*) from p_register WHERE pcode LIKE ?) as alltotal "
						+ "from p_register where pcode LIKE ? order by pprice desc limit ?,?";
				this.pst = this.con.prepareStatement(this.sql);
				this.pst.setString(1, "%"+hw_s_word+"%");
				this.pst.setString(2, "%"+hw_s_word+"%");
				this.pst.setInt(3, this.spage);
				this.pst.setInt(4, this.ea);
				this.rs = this.pst.executeQuery();
				
				
				this.palldata = new ArrayList<ArrayList<String>>();
				while(this.rs.next()) {
					this.p_data = new ArrayList<String>();
					this.p_data.add(this.rs.getString("pidx"));
					this.p_data.add(this.rs.getString("pcode"));
					this.p_data.add(this.rs.getString("pimg"));
					this.p_data.add(this.rs.getString("pname"));
					this.p_data.add(this.rs.getString("pbigca"));
					this.p_data.add(this.rs.getString("psmallca"));
					this.p_data.add(this.rs.getString("pprice"));
					this.p_data.add(this.rs.getString("psale"));
					this.p_data.add(this.rs.getString("pcount"));
					this.p_data.add(this.rs.getString("psell"));
					this.p_data.add(this.rs.getString("psoldout"));
					this.p_data.add(this.rs.getString("alltotal"));
					this.palldata.add(this.p_data);
			}
			}
			}
		}catch (Exception e) {
			this.palldata = null;
			System.out.println("뭐임??"+e.getMessage());
			e.printStackTrace();
		}finally {
			try {
				this.rs.close();
				this.pst.close();
				this.con.close();
			}catch (Exception e) {
				
			}
		}
		
		
		
		return this.palldata;
	}
}
