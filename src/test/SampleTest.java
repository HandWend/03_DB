package test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


import dao.SampleDAO;
import domain.SampleVO;

public class SampleTest { 
 
	public static void main(String[] args) {
		SampleDAO dao =  new SampleDAO();
		SampleVO vo = new SampleVO();
		vo.setStrData("해치웠나");
		//System.out.println(createVo);
		dao.create(vo);
		
		SampleVO readVo = new SampleVO();
		readVo.setNum(1);
	
		SampleVO readVoRes = dao.read(readVo);
		if(readVoRes != null) {
		System.out.print(readVoRes.getNum() + "\t");
		System.out.print(readVoRes.getStrData() + "\t");
		System.out.print(readVoRes.getSampleDate() + "\t");
		}
		
		try {
		System.out.print(readVoRes.getNum() + "\t");
		System.out.print(readVoRes.getStrData() + "\t");
		System.out.print(readVoRes.getSampleDate() + "\t");
		} catch (Exception e) {
			// TODO: handle exception
		}
//		List<SampleVO> list = dao.read();	
//		Iterator<SampleVO> it = list.iterator();
//		while(it.hasNext()) {
//			SampleVO vo = it.next();
//			System.out.print(vo.getNum() + "\t");
//			System.out.print(vo.getStrData() + "\t");
//			System.out.print(vo.getSampleDate() + "\t");
//
//		}
		// num 컬럼이 1번인 데이터를 수정합시다.
		// 기본값으로 초기화 되어짐.
		SampleVO updateVo = new SampleVO();
		updateVo.setNum(1);
		updateVo.setStrData("해치웠다.");
		dao.update(updateVo);
		
		// num컬럼이 1번인 데이터를 삭제합시다.
		SampleVO deleteVo = new SampleVO();
//		deleteVo.setCharTest("고정폭문자열");
		deleteVo.setNum(3);
//		
		dao.delete(deleteVo);
		
		
		
		}

}
