package domain;

import java.util.Date;

public class SoloVO {

	private int num;
	private String naHonJa;
	private Date test;
	
	//default
	public SoloVO() {
	}

	//
	public SoloVO(int num, String naHonJa, Date test) {
		this.num = num;
		this.naHonJa = naHonJa;
		this.test = test;
	}

	@Override
	public String toString() {
		return "SoloVO [num=" + num + ", naHonJa=" + naHonJa + ", test=" + test + "]";
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getNaHonJa() {
		return naHonJa;
	}

	public void setNaHonJa(String naHonJa) {
		this.naHonJa = naHonJa;
	}

	public Date getTest() {
		return test;
	}

	public void setTest(Date test) {
		this.test = test;
	}
	
	
	
	
}
