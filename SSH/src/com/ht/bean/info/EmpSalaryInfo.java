package com.ht.bean.info;

public class EmpSalaryInfo {

	private String empId; // Ա�����	(������t_emp��)
	private String deptName; // ����	(������t_dept��)
	private String roleName; // ��ɫ	(������t_role��)
	private String name; // Ա������	(������t_emp��)
	private String idCard; // ���֤��	(������t_emp��)
	private String gender; // �Ա�	(������t_emp��)
	private String bankName; // ����������	(������t_emp��)
	private String accountName; // ���п�����	(������t_emp��)
	private String accountNo; // �����˺�	(������t_emp��)
	private double basicSalary; // ��������	(������t_salaryinfo��)
	private double jobSalary; // ��λ����	(������t_salaryinfo��)
	private String salaryinfoId;
	
	
	public String getSalaryinfoId() {
		return salaryinfoId;
	}
	public void setSalaryinfoId(String salaryinfoId) {
		this.salaryinfoId = salaryinfoId;
	}
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
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	
}
