package com.ht.bean;

import java.util.Date;

/**
 * ѧ�����ڱ�
 * @author Asa
 *
 */
public class StuChecking {

	private String checkingId; //ѧ�����ڱ��
	private Date checkingDay; //��������
	private String checking1; //���� 
	private String checking2; //����
	private String checking3; //����
	
	private Stu stu; // ѧ��
	
	public String getCheckingId() {
		return checkingId;
	}
	public void setCheckingId(String checkingId) {
		this.checkingId = checkingId;
	}
	public Date getCheckingDay() {
		return checkingDay;
	}
	public void setCheckingDay(Date checkingDay) {
		this.checkingDay = checkingDay;
	}
	public String getChecking1() {
		return checking1;
	}
	public void setChecking1(String checking1) {
		this.checking1 = checking1;
	}
	public String getChecking2() {
		return checking2;
	}
	public void setChecking2(String checking2) {
		this.checking2 = checking2;
	}
	public String getChecking3() {
		return checking3;
	}
	public void setChecking3(String checking3) {
		this.checking3 = checking3;
	}
	public Stu getStu() {
		return stu;
	}
	public void setStu(Stu stu) {
		this.stu = stu;
	}
	
}
