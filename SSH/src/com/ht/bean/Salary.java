package com.ht.bean;

import java.util.Date;

/**
 * ��Ӧ���ʷ��ű�
 * 
 * @author xiaoqiang
 *
 */
public class Salary {

	private String salaryId; // ���ʷ��ű��
	private String empId; // Ա�����
	private double extraSalary; // ����
	private double subSalary; // �۷�
	private Date salaryDay; // ����ʱ��
	private double totalSalary; // �ܹ���

	public String getSalaryId() {
		return salaryId;
	}

	public void setSalaryId(String salaryId) {
		this.salaryId = salaryId;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public double getExtraSalary() {
		return extraSalary;
	}

	public void setExtraSalary(double extraSalary) {
		this.extraSalary = extraSalary;
	}

	public double getSubSalary() {
		return subSalary;
	}

	public void setSubSalary(double subSalary) {
		this.subSalary = subSalary;
	}

	public Date getSalaryDay() {
		return salaryDay;
	}

	public void setSalaryDay(Date salaryDay) {
		this.salaryDay = salaryDay;
	}

	public double getTotalSalary() {
		return totalSalary;
	}

	public void setTotalSalary(double totalSalary) {
		this.totalSalary = totalSalary;
	}

}