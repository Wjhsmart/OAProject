package com.ht.bean;

import java.util.Date;

/**
 * Ա������������
 * @author ������
 *
 */

public class Exp {
	
	private String expId; // �����������
	private String empId; // Ա����ţ���Դ��Ա����
	private String company; // ��˾����
	private Date startDay; // ��ְʱ��
	private Date endDay; // ��ְʱ��
	private String jobTitle; // ְλ
	private String des; //��������
	public String getExpId() {
		return expId;
	}
	public void setExpId(String expId) {
		this.expId = expId;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
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
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	

}
