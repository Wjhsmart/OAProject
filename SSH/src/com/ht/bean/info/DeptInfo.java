package com.ht.bean.info;

public class DeptInfo {

	private String depId; // ���ű��
	private String depName; // ��������
	private String empId; // �����˱��
	private String empId2;

	private String empName; // ����������
	private String empName2;

	@Override
	public String toString() {
		return "DeptInfo [depId=" + depId + ", depName=" + depName + ", empId=" + empId + ", empId2=" + empId2
				+ ", empName=" + empName + ", empName2=" + empName2 + ", des=" + des + ", status=" + status + "]";
	}

	public String getEmpId2() {
		return empId2;
	}

	public void setEmpId2(String empId2) {
		this.empId2 = empId2;
	}

	public String getEmpName2() {
		return empName2;
	}

	public void setEmpName2(String empName2) {
		this.empName2 = empName2;
	}

	private String des; // ����
	private int status; // ״̬��Ĭ�Ͽ���

	public String getDepId() {
		return depId;
	}

	public void setDepId(String depId) {
		this.depId = depId;
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
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

}
