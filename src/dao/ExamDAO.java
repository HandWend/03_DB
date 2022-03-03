package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import domain.ExamVO;
import util.DbUtil;

public class ExamDAO extends DbUtil {

	/**
	 * C:create() 등록하는 메소드
	 * 접근지정자 : public
	 * param : 등록될 값
	 * return : 없음. 
	 */
	public void create(ExamVO vo) {
		//코드작성
		StringBuffer sql = new StringBuffer();
		sql.append("\n INSERT INTO exam "); 
		sql.append("\n (varcharTest, charTest, doubleTest, dateTest, dateTimeTest) ");  
		sql.append("\n VALUES (?, ?, ?, ?, ?) "); 
		
		Connection conn = null;
		PreparedStatement stmt = null;
		int idx = 0;
		try {
			//DB연결
			conn = dbConn();
			//prepareStatement(SQL작성 실행)
			stmt = conn.prepareStatement(sql.toString());
			
			//?에 값설정
			stmt.setString(++idx, vo.getVarcharTest());
			stmt.setString(++idx, vo.getCharTest());
			stmt.setDouble(++idx, vo.getDoubleTest());
			stmt.setDate(++idx, new Date(vo.getDateTest().getTime()));
			stmt.setTimestamp(++idx, vo.getDateTimeTest());
			
			int res = stmt.executeUpdate();
			//결과처리(Select문만 ResultSet 객체 리턴)
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// DbUtil.dbClose(conn, stmt, null);
			dbClose(conn, stmt, null);
		}
		//닫기		
	}

	/**
	 * R:read() 조회하는 메소드
	 * 접근지정자 : public
	 * param : 조회할 값
	 * return : List 
	 */
	public List<ExamVO> read() {

		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT * FROM exam ");
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<ExamVO> list = new ArrayList<ExamVO>();
		//코드작성
		try {
			//드라이버로드

			//DB연결
			conn = dbConn();
			//prepareStatement(SQL작성 실행)
			stmt = conn.prepareStatement(sql.toString());
			rs = stmt.executeQuery();
			//결과처리(Select문만 ResultSet 객체 리턴)
			while(rs.next()) {
				ExamVO vo = new ExamVO(
						rs.getInt("num"),
						rs.getString("varcharTest"),
						rs.getString("charTest"),
						rs.getDouble("doubleTest"),
						rs.getDate("dateTest"),
						rs.getTimestamp("dateTimeTest")
				);
				list.add(vo);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbClose(conn, stmt, null);
		}
		//닫기
		return list;
	}
	// 기존: List<ExamVO>
	public ExamVO read(ExamVO vo) {
		// 코드 작성

		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT * FROM exam WHERE num = ? ");
		
		// return 값으로 쓸 것이기 때문에 전역변수로 사용.
		ExamVO examVo = null;
		// finally
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			// 연결
			conn = dbConn();
			// PreparedStatement (sql문 + 실행)
			stmt = conn.prepareStatement(sql.toString());
			// ResultSet 객체생성
			stmt.setInt(1, vo.getNum());
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				examVo = new ExamVO(
						rs.getInt("num"),
						rs.getString("varcharTest"),
						rs.getString("charTest"),
						rs.getDouble("doubleTest"),
						rs.getDate("dateTest"),
						rs.getTimestamp("dateTimeTest")
				);
			}	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	finally {
			dbClose(conn, stmt, null);
		}	
		// 닫기
		// 코드작성 끝
		return examVo;
	}

	/**
	 * U:update() 수정하는 메소드
	 * 접근지정자 : public
	 * param : 수정될 값
	 * return : 없음. 
	 */
	public void update(ExamVO vo) {
		//코드작성

		StringBuffer sql = new StringBuffer();
		
		// 수행하고자 하는 sql문 작성
		sql.append(" UPDATE exam set varcharTest = ?, doubleTest = ? WHERE ? "); 
		
		Connection conn = null;
		PreparedStatement stmt = null;
		int idx = 0;
		
		try {
			//DB연결
			conn = dbConn();
			//prepareStatement(SQL작성 실행)
			stmt = conn.prepareStatement(sql.toString());
			
			//idx 순서대로 들어감.
			stmt.setString(++idx, vo.getVarcharTest());
			stmt.setDouble(++idx, vo.getDoubleTest());
			stmt.setInt(++idx, vo.getNum());
			
			int res = stmt.executeUpdate();
			//결과처리(Select문만 ResultSet 객체 리턴)
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbClose(conn, stmt, null);
		}
	}

	/**
	 * D:delete() 삭제하는 메소드
	 * 접근지정자 : public
	 * param : 삭제될 키값
	 * return : 없음. 
	 */
	public void delete(ExamVO vo) {
		StringBuffer sql = new StringBuffer();
		sql.append(" DELETE FROM exam WHERE num = ? "); 
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			//드라이버로드
			//DB연결
			conn = dbConn();
			//prepareStatement(SQL작성 실행)
			stmt = conn.prepareStatement(sql.toString());
			stmt.setInt(1, vo.getNum());
			
			int res = stmt.executeUpdate();
			//결과처리(Select문만 ResultSet 객체 리턴)
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbClose(conn, stmt, null);	
		}
	}
}





