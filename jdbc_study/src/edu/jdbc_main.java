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

	public class jdbc_main {

		private static void printData(List<BoardDTO> list) {
			for (BoardDTO b : list) {
				System.out.println(b.toString());
			}
		}
		
		private static List <BoardDTO> getData(ResultSet rs1) throws SQLException {

			List <BoardDTO> list = new ArrayList<>();
			
			// Case1 :: List에 삽입하는 방식
			while(rs1.next()) {
//				BoardDTO b = new BoardDTO();
//				b.setID(rs1.getInt("ID"));
//				b.setName(rs1.getString("Name"));
//				b.setCountryCode(rs1.getString("CountryCode"));
//				b.setDistrict(rs1.getString("District"));
//				b.setPopulation(rs1.getInt("Population"));
				
				//Case2 :: 생성자로 모조리 호출하는 방식
				BoardDTO b = new BoardDTO(
						rs1.getInt("ID"),
						rs1.getString("Name"),
						rs1.getString("CountryCode"),
						rs1.getString("District"),
						rs1.getInt("Population"));
				list.add(b);
			}
		return list;
	}
		
		
		public static void main(String[] args) throws ClassNotFoundException, SQLException {
			String driver = "com.mysql.cj.jdbc.Driver";
			
			String url = "jdbc:mysql://10.125.121.184:3306/musthave";
			String sql = "select * from board";
			
			String url1 = "jdbc:mysql://localhost:3306/World";
			String sql1 = "select * from city";
			
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url1, "musthave", "tiger");
			Statement st = con.createStatement();
//			ResultSet rs = st.executeQuery(sql);
			ResultSet rs1 = st.executeQuery(sql1);
			
			List<BoardDTO> list = null;
			try {
				list = getData(rs1);
			}catch (SQLException e) {
				e.printStackTrace();
			}
			
			
			
			//날짜 출력 포맷 정의
			//yyyy/MM/dd hh:mm:ss
//			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
			//숫자 출력 포맷 정의
//			DecimalFormat df = new DecimalFormat("#,###");
			
//			int num = 0;
//			while(rs1.next()) {
//				System.out.println(String.format("%d|%s|%s|%s",
//						rs1.getInt("ID"),
//						rs1.getString("Name"),
//						rs1.getString("CountryCode"),
//						rs1.getString("District")
//						));
//				num++;
//				if(num == 10) {
//					break;
//				}
//			}
			
//			while(rs.next()) {
//			System.out.println(String.format("%d|%s|%s|%s|%s|%s" ,
//					rs.getInt("num"),
//					rs.getString("title"),
//					rs.getString("content"),
//					rs.getString("id"),
//					sf.format(rs.getDate("postdate")),
//					df.format(rs.getInt("visitcount"))
//				
//					));
//		}
		
			rs1.close();
			st.close();
			con.close();
			//Connect 포함 모든것을 Close한 이후 호출할 것
			printData(list);
		}
	}
