package com.ht.bean;

/**
 * ��Ӧ���ʻ�����Ϣ��
 * 
 * @author xiaoqiang
 *
 */
public class SalaryInfo {

	private String salaryinfoId; // ����������
//	private String empId; // Ա�����
	private double basicSalary; // ��������
	private double jobSalary; // ��λ����
	
	private Emp emp;

	public Emp getEmp() {
		return emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	public String getSalaryinfoId() {
		return salaryinfoId;
	}

	public void setSalaryinfoId(String salaryinfoId) {
		this.salaryinfoId = salaryinfoId;
	}

//	public String getEmpId() {
//		return empId;
//	}
//
//	public void setEmpId(String empId) {
//		this.empId = empId;
//	}

	public double getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(double basicSalary) {
		this.basicSalary = basicSalary;
	}

	public double getJobSalary() {
		return jobSalary;
	}

	public void setJobSalary(double jobSalary) {
		this.jobSalary = jobSalary;
	}

}
