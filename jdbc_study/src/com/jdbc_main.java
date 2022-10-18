package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class jdbc_main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost::3306/musthave";
		String sql = "select * from board";
		
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url);
		Statement st = con.createStatement();
		ResultSet rs = rs.executeQuery(sql);
		
		rs.next();
		System.out.println(rs.getString("title"));
		
		rs.close();
		st.close();
		con.close();
	}
}


