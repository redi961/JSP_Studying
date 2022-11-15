package edu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;



public class main {
	
	
	
	private static void printData(List<BoardDTO> list) {
		for (BoardDTO b : list) {
			System.out.println(b.toString());
		}
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		
		String driver = "com.mysql.cj.jdbc.Driver";
		//String url = "jdbc:mysql://localhost:3306/musthave";
		//String url = "jdbc:mysql://localhost:3306/world";
		String url = "jdbc:mysql://localhost:3306/musthave";
		String sql = "select * from board;";		
		//String sql = "select * from city";
		
		Class.forName(driver);
		
		 
		//데이터 베이스 연결
		//Connection con = DriverManager.getConnection(url,"musthave","tiger");
		// 
		//Statement st = con.createStatement();
		//SELECT문의 결과를 저장하는 객체
		//ResultSet rs = st.executeQuery(sql);
		
		Connection con = DriverManager.getConnection(url,"musthave","1q2w3e4r");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		/*
		 * 
		int num=0;
		while(rs1.next()) {
			
			System.out.println(String.format("%s | %s | %d",
					rs1.getString("Name"),
					rs1.getString("CountryCode"),
					rs1.getInt("Population")));
			num++;
			if(num==6)break;
		}
		 */
		
		//날짜 출력 포맷 정의
		//yyyy/MM/dd hh:mm:ss
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		//숫자 출력 포맷 정의
		DecimalFormat df = new DecimalFormat("#,###");
		
		
		/*
			
		while(rs.next()) {
			System.out.println(String.format("%d|%s|%s|%s|%s|%s",
					rs.getInt("num"),
					rs.getString("title"),
					rs.getString("content"),
					rs.getString("id"),
					sf.format(rs.getDate("postdate")),
					df.format(rs.getInt("visitcount"))
					));
		}
		
		 * */
		
		/*
		rs.next();
		System.out.println(rs.getString("title"));

		while(rs.next()){
			System.out.println(rs.getString("title"));
		}
		*/
		
		
		rs.close();
		st.close();
		con.close();
		
	}
}