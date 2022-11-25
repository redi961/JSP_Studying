package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Sqlconnection {
	static Connection con;
	static PreparedStatement psmt;
	static ResultSet rs;
	Scanner sc = new Scanner(System.in);
	
	public Sqlconnection() {
		String url = "jdbc:mysql://localhost:3306/importtest";
		String userid = "root";
		String pwd = "tiger";

		try { /* 드라이버를 찾는 과정 */
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 로드 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try { /* 데이터베이스를 연결하는 과정 */
			System.out.println("데이터베이스 연결 준비...");
			con = DriverManager.getConnection(url, userid, pwd);
			System.out.println("데이터베이스 연결 성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void sqlRun() {

		String query = "SELECT * FROM 학과"; /* SQL 문 */

		try { /* 데이터베이스에 질의 결과를 가져오는 과정 */
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(query);

			System.out.println(" 제목줄 ");
			while (rs.next()) {
				System.out.print("\t" + rs.getString(1));
				System.out.print("\t" + rs.getString(2));
				System.out.println("\t" + rs.getString(3));
			}
			//con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void sqladd() {
		String query = "INSERT INTO 학과 (학과번호, 학과명, 전화번호)" + "Value (?, ?, ?)";
		try {
			PreparedStatement ps = con.prepareCall(query);
			System.out.print("학과번호를 입력하세요 :: ");
			ps.setString(1, sc.nextLine());
			System.out.print("학과명을 입력하세요 :: ");
			ps.setString(2, sc.nextLine());
			System.out.print("전화번호를 입력하세요 :: ");
			ps.setString(3, sc.nextLine());
			
			ps.executeUpdate();
			ps.close();
			System.out.println("==== 칼럼 추가완료 ====");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void sqlUpdate() {
		String query = "UPDATE 학과 set 학과번호 = '09' WHERE 학과번호 = ? ";

		try {
			PreparedStatement ps = con.prepareCall(query);
			ps.setString(1, "10");
			ps.executeUpdate();
			ps.close();
			System.out.println("=== 수정이 성공적으로 진행되었습니다. ===");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void sqlDel() {
		String query = "DELETE FROM 학과 where 학과번호 = ?";

		try {
			System.out.print("삭제할 학과의 학과번호를 입력하세요 :: ");
			String snum = sc.next();
			PreparedStatement ps = con.prepareCall(query);
			ps.setString(1, snum);
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void sqlSel() {
		String query = "SELECT * FROM 학과 where 학과번호 = ?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			System.out.print("학과번호를 입력하세요 :: ");
			ps.setString(1, sc.nextLine());
			rs = ps.executeQuery();
			while(rs.next()) {
				System.out.print("\t" + rs.getString(1));
				System.out.print("\t" + rs.getString(2));
				System.out.println("\t" + rs.getString(3));
			}
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	private void callp() {
		String query = "CALL insert학과 (?, ?, ?) ";
		try {
			PreparedStatement ps = con.prepareCall(query);
			
			System.out.print("학과번호를 입력하세요 :: ");
			ps.setString(1, sc.nextLine());
			System.out.print("학과명을 입력하세요 :: ");
			ps.setString(2, sc.nextLine());
			System.out.print("전화번호를 입력하세요 :: ");
			ps.setString(3, sc.nextLine());
			
			ps.executeUpdate();
			ps.close();
			System.out.println("==== 칼럼 추가완료 ====");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		int choice;
		Scanner in = new Scanner(System.in);
		Sqlconnection sc = new Sqlconnection();
		while (true) {
			System.out.println("MYSQL Java CRUD Operation");
			System.out.println("1. Insert");
			System.out.println("2. Update");
			System.out.println("3. Delete");
			System.out.println("4. Select");
			System.out.println("5. List up tables");
			System.out.println("6. Call Procedure");
			System.out.println("7. Exit");
			System.out.println("Enter a choice :: ");
			choice = in.nextInt();
			System.out.println("==========================");
			switch (choice) {
			case 1: {
				sc.sqladd();
				break;
			}case 2: {
				sc.sqlUpdate();
				break;
			}case 3: {
				sc.sqlDel();
				break;
			}case 4: {
				sc.sqlSel();
				break;
			}case 5: {
				sc.sqlRun();
				break;
			}case 6: {
				sc.callp();
				break;
			}case 7: {
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
				break;
			}default :
				System.out.println("잘못된 입력 입니다.");
				break;
			}
			System.out.println("-----------------------------------------------");
		}

	}
}