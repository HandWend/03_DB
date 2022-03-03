package dao;
/**
 * 하면서 느낀 점: 
 * DB열고 닫는 함수를 사용하기 전 과정은 어느 정도 기억에 나믕나
 * 함수를 사용하고 나서는 순서가 꼬여서 그런지 동선에 혼동이 자주 온다.
 * 
 *  create() feedback
 *  1. 실행문, executeQuerty(), executeUpdate();
 *  2. SQL 구문 
 *  3. Date 문법에 대한 이해
 *  4. 함수 사용 위치 및 사용 후 중복구문 없애기
 *  ----
 *  List<SampleVO> read() feedback
 *  1. while문 돌리는 것 기억하고 필요성 인식하기
 *  2.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

import domain.ExamVO;
import domain.SampleVO;
import util.DbUtil;

public class SampleDAO extends DbUtil {

	public void create(SampleVO vo) {

		StringBuffer sql = new StringBuffer();

		sql.append(" \n INSERT INTO sample ");
		sql.append(" \n (num, strDate, sampleDate) ");
		sql.append(" \n VALUES (null, ?, curdate()) ");

		Connection conn = null;
		PreparedStatement stmt = null;
		// SampleVO sampleVo = null; create문에선 쓰이지 않는다.
		
		int idx = 0;

		try {
			// DB연결
			conn = dbConn();
			stmt = conn.prepareStatement(sql.toString());

			// 값설정
			stmt.setString(++idx, vo.getStrData());

			// 실행*****
			int res = stmt.executeUpdate();
			// stmt.setDate(++idx, new Date(vo.getSampleDate().getTime()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbClose(conn, stmt, null);
		}
	}
	
	public List<SampleVO> read() {

		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT * FROM sample ");
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		//개념다시 잡을 것 <>: 제네릭? 이해 못함.
		List<SampleVO> list = new ArrayList<SampleVO>();
		//코드작성
		try {
			//DB연결
			conn = dbConn();
			//prepareStatement(SQL작성 실행)
			stmt = conn.prepareStatement(sql.toString());
			rs = stmt.executeQuery();
			//결과처리(Select문만 ResultSet 객체 리턴)
			while(rs.next()) {
				SampleVO vo = new SampleVO(
						rs.getInt("num"),
						rs.getString("strData"),
						rs.getDate("sampleDate")
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

	public SampleVO read(SampleVO vo) {

		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT * FROM sample" );

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		SampleVO sampleVo = null;
		try {
			//드라이버로드
			conn = dbConn();
			stmt = conn.prepareStatement(sql.toString());
			//idx
			stmt.setInt(1, vo.getNum());
			//쿼리실행
			rs = stmt.executeQuery();
			
			//next()사용법 
			if (rs.next()) {
				sampleVo = new SampleVO(
						rs.getInt("num"),
						rs.getString("strData"),
						rs.getDate("sampleDate")
						);
				}
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			} finally {
				dbClose(conn, stmt, rs);
			}
		return sampleVo;
	}
	
	public void update(SampleVO vo) {
		
		StringBuffer sql = new StringBuffer();
		sql.append(" UPDATE sample SET strData = ?, sampleDate = curdate() WHERE num = ? ");
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		int idx = 0;
		
		// ResultSet rs = null; read()문만 쓰이나?
		
		try {
			//
			conn = dbConn();
			//
			stmt = conn.prepareStatement(sql.toString());
			//
			stmt.setString(++idx, vo.getStrData());
			stmt.setInt(++idx, vo.getNum());
			
			int res = stmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbClose(conn, stmt, null);
		}
	}
	
	public void delete(SampleVO vo) {
		StringBuffer sql = new StringBuffer();
		sql.append(" DELETE FROM sample WHERE num = ? "); 
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
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
			//DB해제
			dbClose(conn, stmt, null);
		}
		
	}
}
