package com.ht.bean;

import java.util.Date;

/**
 * ѧ����ٱ�
 * @author Asa
 *
 */
public class StuLeave {

	private String leaveId; //ѧ����ٱ��
	private Date startTime; //��ʼʱ��
	private Date endTime; //����ʱ��
	private Date leaveDay; //�ύʱ��
	private String des; //���˵��
	private int status; //״̬��Ĭ�Ͽ���
	private int firstLevel; //�ο���ʦ��ˣ�Ĭ�ϲ�ͨ��
	private int secondLevel; //��������ˣ�Ĭ�ϲ�ͨ��
	private int pass; //ͨ��״̬��Ĭ�ϲ�ͨ��
	
	private Stu stu; // ѧ��
	
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
	public Stu getStu() {
		return stu;
	}
	public void setStu(Stu stu) {
		this.stu = stu;
	}
	
}
