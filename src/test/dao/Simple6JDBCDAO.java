package test.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

/**
 * 
 * @author smart19
 * folder - make libs
 * 암기 그 자체
 */
public class Simple6JDBCDAO {

	public static void main(String[] args) {
		String paramVarchar = "varcharTest";
		String paramChar = "charTest";
		double paramInt = 200.001;
		// java.sql.date 사용할 때 날짜 넣는 법
		Date paramDate = new Date(System.currentTimeMillis());
		Timestamp paramDateTime = new Timestamp(System.currentTimeMillis());
		
		
		String url = "jdbc:mysql://localhost:3306/smart?characterEncoding=UTF-8&serverTimezone=Asia/Seoul";
		String user = "root";
		String password = "smart";
		String sql = "INSERT INTO exam VALUES (?, ?, ?, ?, ?)" ;
		
		// PreparedStatement
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		
		
		try {
			// 1. 드라이버 로드 (package.Driver)
			// 빨간 메시지라고 다 에러가 아니다.
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 2. DB연결
			conn = DriverManager.getConnection(url, user, password);
			
			// 3. SQL문 작성(Statement, PrepareStatement)
			// Statement 만들기(java.sql.Statement)
			
			stmt = conn.prepareStatement(sql);
			
			// ?에 순서대로 값이 들어감.
			stmt.setString(1, paramVarchar);
			stmt.setString(2, paramChar);
			stmt.setDouble(3, paramInt);
			stmt.setDate(4, paramDate);
			stmt.setTimestamp(5, paramDateTime);
			
			
			// 4. SQL문 실행(java.sql.Resultset), PreparedStatement의 특징
			// SELECT문: rs = stmt.executeQuery();
			int res = stmt.executeUpdate();
			if (res > 0) {
				System.out.println(res + "개의 행이 추가되었습니다.");
			} else {
				System.out.println("등록실패했습니다");
			}
			
			// 5. SELECT문 RESULTSET 객체 반환, int 반환
			
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
