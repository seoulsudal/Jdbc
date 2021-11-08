import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBdata {

	public static void main(String[] args) {
		
		Connection conn = null;
		Statement stmt = null;
		String url = "jdbc:oracle:thin:@192.168.0.137:1521:xe";
		String user = "hr";
		String password = "1234";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException ex1) {
			System.out.println("드라이버 로딩 에러 : " + ex1.toString());
			return;
		} catch (Exception ex2) {
			System.out.println("DB 접속 실패 : " + ex2.toString());
			return;
		}
		
		try {
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("DB연결 성공");
			stmt = conn.createStatement();
			String sql = "insert into test01_tbl values(2, 'id02', '강감찬', 30)";
			System.out.println("SQL : " + sql);
			int result = stmt.executeUpdate(sql);
			System.out.println(result + "개의 Data 입력 성공!!");
		} catch (Exception e) {
			System.out.println("Data 입력 실패!! : " + e.getMessage());
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				} 
				} catch (Exception e) {
			}
			System.out.println("DB 접속 및 SQL 문 수행 성공!");
		}

	}

}
