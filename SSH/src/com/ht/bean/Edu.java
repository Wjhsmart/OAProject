package com.ht.bean;

import java.util.Date;

/**
 * Ա������������
 * @author ������
 *
 */

public class Edu {
	
	private String eduId; // �����������
	private	String empId; // Ա����ţ���Դ��Ա����
	private String school; // ��ҵѧУ
	private Date startDay; // ��ʼʱ��
	private Date endDay; // ����ʱ��
	private String des; // ����
	public String getEduId() {
		return eduId;
	}
	public void setEduId(String eduId) {
		this.eduId = eduId;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public Date getStartDay() {
		return startDay;
	}
	public void setStartDay(Date startDay) {
		this.startDay = startDay;
	}
	public Date getEndDay() {
		return endDay;
	}
	public void setEndDay(Date endDay) {
		this.endDay = endDay;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}

}
