package com.ht.bean.info;

import java.util.Date;

/**
 * ����ѧ�����ڵĵ��뵼��
 * @author Administrator
 *
 */
public class StuCheckingInfo {

	private String stuId;
	private String stuName;
	private Date checkingDay; //��������
	private String checking1; //���� 
	private String checking2; //����
	private String checking3; //����
	
	public String getStuId() {
		return stuId;
	}
	public void setStuId(String stuId) {
		this.stuId = stuId;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
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
	
	
}
