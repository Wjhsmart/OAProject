package com.ht.bean;

import java.util.Date;

/**
 * ѧ���ܽ��
 * @author Administrator
 *
 */
public class Summary {

	private String summaryId; // �ܽ���
	private Date summaryDay; // �ܽ�ʱ��
	private int term; // �ڼ���ѧ�ڵ��ܽ�
	private String des; // �ܽ�����
	private int status; // ״̬��Ĭ��Ϊ����״̬��0��ʾ�����ã�1��ʾ����
	
	private Emp emp; // Ա��
	private Stu stu; // ѧ��
	
	public String getSummaryId() {
		return summaryId;
	}
	public void setSummaryId(String summaryId) {
		this.summaryId = summaryId;
	}
	public Date getSummaryDay() {
		return summaryDay;
	}
	public void setSummaryDay(Date summaryDay) {
		this.summaryDay = summaryDay;
	}
	public int getTerm() {
		return term;
	}
	public void setTerm(int term) {
		this.term = term;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
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
	public Stu getStu() {
		return stu;
	}
	public void setStu(Stu stu) {
		this.stu = stu;
	}
	
	
	
	
}
