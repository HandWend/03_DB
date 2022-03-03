package test.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 
 * @author smart19
 * folder - make libs
 * 암기 그 자체
 */
public class SimpleJDBCDAO {

	public static void main(String[] args) throws Exception {
		
		String url = "jdbc:mysql://localhost:3306/smart?characterEncoding=UTF-8&serverTimezone=Asia/Seoul";
		String user = "root";
		String password = "smart";
		String sql = "SELECT * FROM exam";
		
		// 1. 드라이버 로드 (package.Driver)
		// 빨간 메시지라고 다 에러가 아니다.
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// 2. DB연결
		Connection conn = DriverManager.getConnection(url, user, password);
		
		// 3. SQL문 작성(Statement, PrepareStatement)
		// Statement 만들기(java.sql.Statemet)
		// 
		Statement stmt = conn.createStatement();
		
		// 4. SQL문 실행(java.sql.Resultset)
		ResultSet rs = stmt.executeQuery(sql);
		
		// 5. SELECT문 RESULTSET 객체 반환, int 반환
		rs.next();
		System.out.println(rs.getString("varcharTest"));
		System.out.println(rs.getString("charTest"));
		System.out.println(rs.getString("intTest"));
		
		rs.close();
		stmt.close();
		conn.close();
	}

}
