package com.ht.bean;

import java.util.Date;

/**
 * �����
 * @author interface
 *
 */
public class Income{
	private String incomeId;//����ı��
//	private String incomeTypeId;//�������͵ı��
	private Date incomeDay;//�����ʱ��
	private String des;//���������
	private double income;//����Ľ��
//	private String empId;//Ա�����
//	private String stuId;//ѧ���ı��
	
	private Emp emp;
	private Stu stu;
	private IncomeType it;
	
	public String getIncomeId() {
		return incomeId;
	}
	public void setIncomeId(String incomeId) {
		this.incomeId = incomeId;
	}
//	public String getIncomeTypeId() {
//		return incomeTypeId;
//	}
//	public void setIncomeTypeId(String incomeTypeId) {
//		this.incomeTypeId = incomeTypeId;
//	}
	public Date getIncomeDay() {
		return incomeDay;
	}
	public void setIncomeDay(Date incomeDay) {
		this.incomeDay = incomeDay;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public double getIncome() {
		return income;
	}
	public void setIncome(double income) {
		this.income = income;
	}
//	public String getEmpId() {
//		return empId;
//	}
//	public void setEmpId(String empId) {
//		this.empId = empId;
//	}
//	public String getStuId() {
//		return stuId;
//	}
//	public void setStuId(String stuId) {
//		this.stuId = stuId;
//	}
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
	public IncomeType getIt() {
		return it;
	}
	public void setIt(IncomeType it) {
		this.it = it;
	}
}
