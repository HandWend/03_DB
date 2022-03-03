package domain;

import java.sql.Timestamp;
import java.util.Date;
/**
 * 
 * @author smart19
 *
 */
public class ExamVO {

	//필드
	private int num;
	private String varcharTest;
	private String charTest;
	private double doubleTest;
	private Date dateTest;
	private Timestamp dateTimeTest;
	

	// default constructor
	public ExamVO() {
	}
	
	//using fields
	public ExamVO(int num, String varcharTest, String charTest, double doubleTest, Date dateTest,
			Timestamp dateTimeTest) {
		this.num = num;
		this.varcharTest = varcharTest;
		this.charTest = charTest;
		this.doubleTest = doubleTest;
		this.dateTest = dateTest;
		this.dateTimeTest = dateTimeTest;
	}

	//override toString()
	@Override
	public String toString() {
		return "ExamVO [num=" + num + ", varcharTest=" + varcharTest + ", charTest=" + charTest + ", doubleTest="
				+ doubleTest + ", dateTest=" + dateTest + ", dateTimeTest=" + dateTimeTest + "]";
	}
	
	//getters & setters
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getVarcharTest() {
		return varcharTest;
	}
	public void setVarcharTest(String varcharTest) {
		this.varcharTest = varcharTest;
	}
	public String getCharTest() {
		return charTest;
	}
	public void setCharTest(String charTest) {
		this.charTest = charTest;
	}
	public double getDoubleTest() {
		return doubleTest;
	}
	public void setDoubleTest(double doubleTest) {
		this.doubleTest = doubleTest;
	}
	public Date getDateTest() {
		return dateTest;
	}
	public void setDateTest(Date dateTest) {
		this.dateTest = dateTest;
	}
	public Timestamp getDateTimeTest() {
		return dateTimeTest;
	}
	public void setDateTimeTest(Timestamp dateTimeTest) {
		this.dateTimeTest = dateTimeTest;
	}
	
			 
}
