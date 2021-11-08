import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBSerch {

	public static void main(String[] args) {
		
		Connection conn = null;
		Statement stmt = null;
		String url = "jdbc:oracle:thin:@192.168.0.137:1521:xe";
		String user = "hr";
		String password = "1234";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException ex1) {
			System.out.println("드라이버 로딩 에러 : " + ex1.toString());
			return;
		} catch (Exception ex2) {
			System.out.println("DB 접속 실패 : " + ex2.toString());
			return;
		}
		
		try {
			stmt = conn.createStatement();
			String sql = "select * from TEST01_TBL";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				String s = rs.getInt("num") + "\t";
				s += rs.getString("id") + "\t";
				s += rs.getString("name") + "\t";
				s += rs.getInt("age") + "\t";
				System.out.println(s);
			}
		} catch (Exception e) {
			System.out.println("SELECT 실패! : " + e.getMessage());
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
		}
	}

}
