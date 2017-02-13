package com.ht.bean;

import java.util.Date;

import org.apache.struts2.json.annotations.JSON;

/**
 * ��ҵ��Ϣ��
 * @author Administrator
 *
 */
public class Job {

	private String jobId; // �������
	private String company; // ��˾����
	private String jobTitle; // ְλ
	private double salary; // ��н
	private String welfare; // ��������
	private String address; // ��˾��ַ
	private String comPhone; // ��ʽ��ϵ��ʽ
	private Date hireDay; // ��ְʱ��
	private int status; // ״̬��Ĭ��Ϊ����״̬
	
	private Stu stu; // ѧ��
	
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getWelfare() {
		return welfare;
	}
	public void setWelfare(String welfare) {
		this.welfare = welfare;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getComPhone() {
		return comPhone;
	}
	public void setComPhone(String comPhone) {
		this.comPhone = comPhone;
	}
	public Date getHireDay() {
		return hireDay;
	}
	public void setHireDay(Date hireDay) {
		this.hireDay = hireDay;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@JSON(serialize = true)
	public Stu getStu() {
		return stu;
	}
	public void setStu(Stu stu) {
		this.stu = stu;
	}
	@Override
	public String toString() {
		return "Job [jobId=" + jobId + ", company=" + company + ", jobTitle=" + jobTitle + ", salary=" + salary
				+ ", welfare=" + welfare + ", address=" + address + ", comPhone=" + comPhone + ", hireDay=" + hireDay
				+ ", status=" + status + "]";
	}
	
	
}
