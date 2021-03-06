import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatementExam02 {

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.137:1521:xe", "hr", "1234");
			
		      String sql = "create table syh1012(id varchar2(10), password varchar2(10))";
			pstmt = con.prepareStatement(sql);
			int updateCount = pstmt.executeUpdate();
			System.out.println("CreateCount : " + updateCount);

			sql = "insert into syh1012 values(?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "syh2022");
			pstmt.setString(2, "1111");
			updateCount = pstmt.executeUpdate();
			System.out.println("InsetCount : " + updateCount);

			sql = "select * from syh1012";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.print("Id : " + rs.getString(1));
				System.out.println(" , Password : " + rs.getString(2));
			}

			sql = "drop table syh1012";
			pstmt = con.prepareStatement(sql);
			updateCount = pstmt.executeUpdate();
			System.out.println("DropCount : " + updateCount);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException sqle) {
			}
		}
	}


}
