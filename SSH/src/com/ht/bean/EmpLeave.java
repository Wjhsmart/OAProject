package com.ht.bean;

import java.util.Date;

/**
 * ��ӦԱ����ٱ�
 * 
 * @author xiaoqiang
 *
 */
public class EmpLeave {

	private String leaveId; // ��ٱ��
	private Date startTime; // ��ʼʱ��
	private Date endTime; // ����ʱ��
	private Date leaveDay; // �ύʱ��
	private String des; // �������
	private int status; // ���״̬
	private int firstLevel; // ֱ����˾��ˣ�Ĭ��Ϊ��ͨ��
	private int secondLevel; // �ϰ���ˣ�Ĭ��Ϊ��ͨ��
	private int pass; // �Ƿ�ͨ����Ĭ��Ϊ��ͨ��
	private int leaveCount;
	private Emp emp;

	public String getLeaveId() {
		return leaveId;
	}

	public void setLeaveId(String leaveId) {
		this.leaveId = leaveId;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Date getLeaveDay() {
		return leaveDay;
	}

	public void setLeaveDay(Date leaveDay) {
		this.leaveDay = leaveDay;
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

	public int getFirstLevel() {
		return firstLevel;
	}

	public void setFirstLevel(int firstLevel) {
		this.firstLevel = firstLevel;
	}

	public int getSecondLevel() {
		return secondLevel;
	}

	public void setSecondLevel(int secondLevel) {
		this.secondLevel = secondLevel;
	}

	public int getPass() {
		return pass;
	}

	public void setPass(int pass) {
		this.pass = pass;
	}

	
	public Emp getEmp() {
		return emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	public int getLeaveCount() {
		return leaveCount;
	}

	public void setLeaveCount(int leaveCount) {
		this.leaveCount = leaveCount;
	}

}
