package com.ht.bean;

import java.util.Set;

/**
 * ���ű�
 * @author ������
 *
 */
public class Dept {
	
	private String depId; // ���ű��
	private String name; // ����
	private String des; // ����
	private int status; // ״̬��Ĭ�Ͽ���
	private String empId; 
	
	
	private Set<Emp> emps; // ������Emp��
	
	
	public String getDepId() {
		return depId;
	}
	public void setDepId(String depId) {
		this.depId = depId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	
	public Set<Emp> getEmps() {
		return emps;
	}
	
	public void setEmps(Set<Emp> emps) {
		this.emps = emps;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}

	

	
}
