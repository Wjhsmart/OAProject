package com.ht.bean.info;

import java.util.Date;

public class IncomeInfo {
	
	private String incomeId;//����ı��
	private String empName;//Ա������
	private String incomeTypeName;//������������
	private Date incomeDay;//�����ʱ��
	private String des;//���������
	private double income;//����Ľ��
	private String stuName;//ѧ������
	private int incomeTypeStatus;
	private String incomeTypeId;
	private String stuId;
	
	
	public String getStuId() {
		return stuId;
	}
	public void setStuId(String stuId) {
		this.stuId = stuId;
	}
	public String getIncomeTypeId() {
		return incomeTypeId;
	}
	public void setIncomeTypeId(String incomeTypeId) {
		this.incomeTypeId = incomeTypeId;
	}
	public int getIncomeTypeStatus() {
		return incomeTypeStatus;
	}
	public void setIncomeTypeStatus(int incomeTypeStatus) {
		this.incomeTypeStatus = incomeTypeStatus;
	}
	public String getIncomeId() {
		return incomeId;
	}
	public void setIncomeId(String incomeId) {
		this.incomeId = incomeId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getIncomeTypeName() {
		return incomeTypeName;
	}
	public void setIncomeTypeName(String incomeTypeName) {
		this.incomeTypeName = incomeTypeName;
	}
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
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	
}
