import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBTable {

	public static void main(String[] args) {
		
		Connection conn = null;
		Statement stmt = null;
		String url = "jdbc:oracle:thin:@192.168.0.137:1521:xe";
		String user = "hr";
		String password = "1234";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e1) {
			System.out.println("드라이버 로딩 에러 : " + e1.toString());
			return;
		} catch (SQLException e2) {
			System.out.println("DB 접속 실패 : " +e2.toString());
			return;
		}

		String sql = "create table test01_tbl(num	number(6), id	varchar2(10), name	varchar2(20), age	number(3))";
		
		try {
			System.out.println("DB연결 성공");
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (Exception ex3) {
			System.out.println("SQL 문 수행 오류 : " + ex3.toString());
			return;
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch(Exception ex4) {
			}
		}
		System.out.println("DB 접속 및 SQL 문 수행 성공!");
	}

}
