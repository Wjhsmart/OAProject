package com.ht.bean.info;

import java.util.Date;

/**
 * ѧ��̸�Ĺ����Ӧ��Bean
 * @author Administrator
 *
 */
public class TalkInfo {

	private String talkId; // ̸�ı��
	private String empId; // Ա���ı��
	private String empName; // Ա��������
	private String stuId; // ѧ���ı��
	private String stuName; // ѧ��������
	private Date talkDay; // ̸��ʱ��
	private String des; // ̸������
	private int status; // ״̬
	
	
	public String getTalkId() {
		return talkId;
	}
	public void setTalkId(String talkId) {
		this.talkId = talkId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public Date getTalkDay() {
		return talkDay;
	}
	public void setTalkDay(Date talkDay) {
		this.talkDay = talkDay;
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
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getStuId() {
		return stuId;
	}
	public void setStuId(String stuId) {
		this.stuId = stuId;
	}
}
