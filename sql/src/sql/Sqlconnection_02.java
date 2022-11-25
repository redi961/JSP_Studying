package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Sqlconnection_02 {
	static Connection con;
	static PreparedStatement psmt;
	static ResultSet rs;
	Scanner sc = new Scanner(System.in);

	public Sqlconnection_02() {
		String url = "jdbc:mysql://localhost:3306/pnusw17";
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
		String query = "select * from 학생\r\n" 
						+ "inner join 성적 on 성적.학생번호 = 학생.학생번호\r\n"
						+ "inner join 학과 on 학과.학과 = 학생.학과\r\n" 
						+ "inner join 강의 on 강의.강좌이름 = 성적.강좌이름"; /* SQL 문 */

		try { /* 데이터베이스에 질의 결과를 가져오는 과정 */
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				System.out.print("\t" + rs.getString(1));
				System.out.print("\t" + rs.getString(2));
				System.out.print("\t" + rs.getString(3));
				System.out.print("\t" + rs.getString(4));
				System.out.print("\t\t" + rs.getString(5));
				System.out.print("\t" + rs.getString(6));
				System.out.print("\t" + rs.getString(7));
				System.out.println("\t" + rs.getString(8));
			}
			// con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void sqlRun2() {
		String query = "select * from 학생";
		try { /* 데이터베이스에 질의 결과를 가져오는 과정 */
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				System.out.print("\t" + rs.getString(1));
				System.out.print("\t" + rs.getString(2));
				System.out.print("\t" + rs.getString(3));
				System.out.println("\t" + rs.getString(4));
			}
			// con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void sqladd() {
		String query = "INSERT INTO 학생 (학생번호, 학생이름, 주소, 학과)" + "Value (?, ?, ?, ?)";
		try {
			PreparedStatement ps = con.prepareCall(query);
			System.out.print("학생번호를 입력하세요 :: (숫자) ");
			ps.setInt(1, sc.nextInt());
			System.out.print("학생이름을 입력하세요 :: ");
			ps.setString(2, sc.next());
			System.out.print("주소를 입력하세요 :: ");
			ps.setString(3, sc.next());
			System.out.print("학과이름을 입력하세요 :: ");
			ps.setString(4, sc.next());
			ps.executeUpdate();
			ps.close();
			System.out.println("==== 칼럼 추가완료 ====");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void sqlUpdate() {
		String query = "UPDATE 학생 set 학생번호 = ?, 학생이름 =  ?, 주소 = ?, 학과 = ?" + "WHERE 학생번호 = ?";
		try {
			PreparedStatement ps = con.prepareCall(query);
			System.out.print("수정할 학생의 학생번호를 입력하세요 :: (숫자) ");
			ps.setInt(5, sc.nextInt());
			System.out.print("새로운 학생번호를 입력하세요 :: (숫자) ");
			ps.setInt(1, sc.nextInt());
			System.out.print("새로운 학생이름을 입력하세요 :: ");
			ps.setString(2, sc.next());
			System.out.print("새로운 주소를 입력하세요 :: ");
			ps.setString(3, sc.next());
			System.out.print("새로운 학과를 입력하세요 :: ");
			ps.setString(4, sc.next());
			ps.executeUpdate();
			ps.close();
			System.out.println("=== 수정이 성공적으로 이뤄졌습니다. ===");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void sqlDel() {
		String query = "DELETE FROM 학생 where 학생번호 = ?";

		try {
			System.out.print("삭제할 학생의 학생번호를 입력하세요 :: (번호) ");
			PreparedStatement ps = con.prepareCall(query);
			ps.setInt(1, sc.nextInt());
			ps.executeUpdate();
			ps.close();
			System.out.println("=== 칼럼이 삭제되었습니다 ===");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void sqlSel() {
		String query = "SELECT * FROM 학생 where 학생번호 = ?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			System.out.print("학생번호를 입력하세요 :: ");
			ps.setString(1, sc.nextLine());
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.print("\t" + rs.getString(1));
				System.out.print("\t" + rs.getString(2));
				System.out.print("\t" + rs.getString(3));
				System.out.println("\t" + rs.getString(4));
			}
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		int choice;
		Scanner in = new Scanner(System.in);
		Sqlconnection_02 sc = new Sqlconnection_02();
		while (true) {
			System.out.println("MYSQL Java CRUD Operation");
			System.out.println("1. Insert");
			System.out.println("2. Update");
			System.out.println("3. Delete");
			System.out.println("4. Select");
			System.out.println("5. List up joined All Tables");
			System.out.println("6. List up only Student Table");
			System.out.println("7. Exit");
			System.out.println("Enter a choice :: ");
			choice = in.nextInt();
			System.out.println("==========================");
			switch (choice) {
			case 1: {
				sc.sqladd();
				break;
			}
			case 2: {
				sc.sqlUpdate();
				break;
			}
			case 3: {
				sc.sqlDel();
				break;
			}
			case 4: {
				sc.sqlSel();
				break;
			}
			case 5: {
				sc.sqlRun();
				break;
			}
			case 6: {
				sc.sqlRun2();
				break;
			}
			case 7: {
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
				break;
			}
			default:
				System.out.println("잘못된 입력 입니다.");
				break;
			}
			System.out.println("-----------------------------------------------");
		}

	}
}