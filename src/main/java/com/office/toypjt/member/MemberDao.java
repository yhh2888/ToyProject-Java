package com.office.toypjt.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.office.ex.MemberDto;



public class MemberDao {
	
	public final String DRIVER = "com.mysql.cj.jdbc.Driver";
	public final String URL = "jdbc:mysql://localhost:3306/db_member";
	public final String USER = "root";
	public final String PASSWORD = "1234";
	
	public int insertNewMember(MemberDto memberDto) {
	
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = -1;
		
		try {
			Class.forName(DRIVER);
			
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			String sql = "";
			
			pstmt = conn.prepareStatement(sql);
			
			// set
			
			result = pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
		
		return result;
		
	}
	

}
