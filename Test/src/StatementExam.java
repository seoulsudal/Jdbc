import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementExam {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "hr";
		String passwd = "1234";
		
		BufferedReader in_empno = new BufferedReader(new InputStreamReader(System.in));
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
			conn = DriverManager.getConnection(url, user, passwd);
			String empno; 
			
			System.out.print("사원번호 입력 : ");
			empno = in_empno.readLine();
			
			String sql = "select FIRST_NAME, JOB_ID, SALARY from EMPLOYEES where EMPLOYEE_ID = " + empno;
			
			stmt = conn.createStatement(); 
			rs = stmt.executeQuery(sql); 

			while (rs.next()) {
				System.out.println("FIRST_NAME : " + rs.getString(1) + "   JOB_ID : " + rs.getString(2) + "   sal : " + rs.getString(3));
			}
		} catch (Exception e) {
			System.out.println(" 실패!! : " + e.getMessage());
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception ex) {
			}
		}
	}
} 
