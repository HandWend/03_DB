package test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import dao.ExamDAO;
import domain.ExamVO;

public class Test {

	public static void main(String[] args) {
		ExamDAO dao = new ExamDAO();
		ExamVO createVo = new ExamVO(0, "가변폭문자열", "고정폭문자열", 0.123, 
				new Date(), new Timestamp(System.currentTimeMillis()));
		//System.out.println(createVo);
		
		
		//dao.create(createVo);
		ExamVO readVo = new ExamVO();
		readVo.setNum(1);
	
		ExamVO readVoRes = dao.read(readVo);
//		if(readVoRes != null) {
//		System.out.print(readVoRes.getNum() + "\t");
//		System.out.print(readVoRes.getVarcharTest() + "\t");
//		System.out.print(readVoRes.getCharTest() + "\t");
//		System.out.print(readVoRes.getDoubleTest() + "\t");
//		System.out.print(readVoRes.getDateTest() + "\t");
//		System.out.println(readVoRes.getDateTimeTest() + "\t");
//		}
		
		try {
		System.out.print(readVoRes.getNum() + "\t");
		System.out.print(readVoRes.getVarcharTest() + "\t");
		System.out.print(readVoRes.getCharTest() + "\t");
		System.out.print(readVoRes.getDoubleTest() + "\t");
		System.out.print(readVoRes.getDateTest() + "\t");
		System.out.println(readVoRes.getDateTimeTest() + "\t");
		} catch (Exception e) {
			// TODO: handle exception
		}
		// num 컬럼이 1번인 데이터를 수정합시다.
		// 기본값으로 초기화 되어짐.
		ExamVO updateVo = new ExamVO();
		updateVo.setNum(1);
		updateVo.setVarcharTest("바꿀값");
		updateVo.setDoubleTest(123.12);
		dao.update(updateVo);
		
		// num컬럼이 1번인 데이터를 삭제합시다.
		ExamVO deleteVo = new ExamVO();
		deleteVo.setCharTest("고정폭문자열");
		deleteVo.setNum(1);
		
		dao.delete(deleteVo);
		
		
//		List<ExamVO> list = dao.read();	
//		Iterator<ExamVO> it = list.iterator();
//		while(it.hasNext()) {
//			ExamVO vo = it.next();
//			System.out.print(vo.getNum() + "\t");
//			System.out.print(vo.getVarcharTest() + "\t");
//			System.out.print(vo.getCharTest() + "\t");
//			System.out.print(vo.getDoubleTest() + "\t");
//			System.out.print(vo.getDateTest() + "\t");
//			System.out.println(vo.getDateTimeTest() + "\t");
//		}
		}

}
