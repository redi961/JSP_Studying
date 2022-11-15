package edu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

class BoardDTO {
	private int ID;
	private String CountryCode;
	private String Name;
	private String District;
	private int Population;
	
	public BoardDTO() {
		// TODO Auto-generated constructor stub
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getCountryCode() {
		return CountryCode;
	}

	public void setCountryCode(String countryCode) {
		CountryCode = countryCode;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getDistrict() {
		return District;
	}

	public void setDistrict(String district) {
		District = district;
	}

	public int getPopulation() {
		return Population;
	}

	public void setPopulation(int population) {
		Population = population;
	}
	
	
}

public class main2 {

	private static void printData(List<BoardDTO> list) {
		for (BoardDTO b : list) {
			System.out.println(b.toString());
		}
	}

	private static List<BoardDTO> getData(ResultSet rs1) {
		
		List<BoardDTO> list = new ArrayList<>();
			
		while(rs1.next()) {
			
			BoardDTO b = new BoardDTO();
			b.setCountryCode(rs1.getInt(0));
		
					rs1.getInt("num");
					rs1.getString("title");
					rs1.getString("content");
					rs1.getString("id");			
		
		}		
		
		return null;	
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/musthave";
		String sql = "select * from board;";

		Class.forName(driver);

		Connection con = DriverManager.getConnection(url, "musthave", "tiger");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);

		List<BoardDTO> list = null;
		try {
			list = getData(rs);
		} catch (Exception e) {
			e.printStackTrace();
		}

		rs.close();
		st.close();
		con.close();

	}
}