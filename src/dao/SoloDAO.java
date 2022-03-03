package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import domain.SoloVO;
import util.DbUtil;

public class SoloDAO extends DbUtil {

	//CRUD
	//CREATE
	public void create(SoloVO vo) {
		//SQL구문작성 더해주기 위한 StringBuffer
		StringBuffer sql = new StringBuffer();
		//SQL구문작성***
		sql.append(" INSERT INTO solo ");
		sql.append(" (num, strMan, charMan, dateMan)" );
		sql.append(" VALUES (null, ?, ?, curdate()) ");
		//***
		int idx = 1;
		//finally 위한 null값 주기
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			//DB실행(Conn, stmt, rs)
			conn = dbConn();
			//create은 return 값이 없다.
			//stmt = sql이 String타입이기에 sql또한 String으로 변환시켜주기 위해 toString()을 사용한다.
			stmt = conn.prepareStatement(sql.toString());
			//값 설정***
			stmt.setString(idx++, vo.getNaHonJa());
			
			//실행하는 변수 하나 작성
			//executeUpdate()는 변수타입을 int로 받는다.***
			int res = stmt.executeUpdate();
		} catch (Exception e) { // 다양한 상황 모두 예외처리를 해 주겠다.
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbClose(conn, stmt, null);
		}
	}
	
	public List<SoloVO> read(SoloVO vo) {
		
		
		return null;
		
	}
}
