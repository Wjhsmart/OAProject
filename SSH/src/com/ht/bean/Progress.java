package com.ht.bean;

import java.util.Date;

/**
 * ��Ӧ�γ̽��ȱ�
 * 
 * @author xiaoqiang
 *
 */
public class Progress {

	private String progressId; // �γ̽��ȱ��
	private String des; // ��������
	private Date progressDay; // ��ӽ��ȵ�ʱ��
	private int status; // ״̬��Ĭ��Ϊ����
	
	private Emp emp; // ����emp��
	private Grade grade; // ����grade��

	public String getProgressId() {
		return progressId;
	}

	public void setProgressId(String progressId) {
		this.progressId = progressId;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public Date getProgressDay() {
		return progressDay;
	}

	public void setProgressDay(Date progressDay) {
		this.progressDay = progressDay;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Emp getEmp() {
		return emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

}
