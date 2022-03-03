package test.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * @author smart19
 * folder - make libs
 * 암기 그 자체
 */
public class Simple3JDBCDAO {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/smart?characterEncoding=UTF-8&serverTimezone=Asia/Seoul";
		String user = "root";
		String password = "smart";
		String sql = "SELECT * FROM exam";
		
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		
		
		try {
			// 1. 드라이버 로드 (package.Driver)
			// 빨간 메시지라고 다 에러가 아니다.
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 2. DB연결
			conn = DriverManager.getConnection(url, user, password);
			
			// 3. SQL문 작성(Statement, PrepareStatement)
			// Statement 만들기(java.sql.Statement)
			// 
			stmt = conn.createStatement();
			
			// 4. SQL문 실행(java.sql.Resultset)
			 rs = stmt.executeQuery(sql);
			
			// 5. SELECT문 RESULTSET 객체 반환, int 반환
			while (rs.next()) {
			
				System.out.printf("varcharTest: %s\n",rs.getString("varcharTest"));
				System.out.printf("charTest: %s\n",rs.getString("charTest"));
				System.out.printf("intTest: %s\n",rs.getString("intTest"));
				System.out.printf("dateTest: %s\n",rs.getString("dateTest"));
				System.out.printf("dateTimeTest: %s\n",rs.getString("dateTimeTest"));

				System.out.println();
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (stmt != null) stmt.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	
		
		
	}

}
