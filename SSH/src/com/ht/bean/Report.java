package com.ht.bean;

import java.util.Date;

/**
 * ������־��
 * 
 * @author Xiao-Qiao
 *
 */
public class Report {

	private String reportId;// ������־���
	private Date reportDay;// ��־ʱ��
	private String des;// ����
	private int status;// ״̬��Ĭ��Ϊ����

	private Emp emp;

	public String getReportId() {
		return reportId;
	}

	public void setReportId(String reportId) {
		this.reportId = reportId;
	}

	public Date getReportDay() {
		return reportDay;
	}

	public void setReportDay(Date reportDay) {
		this.reportDay = reportDay;
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

}
