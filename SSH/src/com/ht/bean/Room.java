package com.ht.bean;

import java.util.Set;

/**
 * �����
 * @author Asa
 *
 */
public class Room {
	
	private String roomId; //������
	private String name; //����
	private String stuId; //���᳤���
	private int quantity; //�����������
	private int status; //״̬��Ĭ�Ͽ���
	
	private Set<Stu> stus; //����stu��
	private Stu stu;
	
	private Set<Check> checks;
	
	public String getRoomId() {
		return roomId;
	}
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStuId() {
		return stuId;
	}
	public void setStuId(String stuId) {
		this.stuId = stuId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Set<Stu> getStus() {
		return stus;
	}
	public void setStus(Set<Stu> stus) {
		this.stus = stus;
	}
	public Stu getStu() {
		return stu;
	}
	public void setStu(Stu stu) {
		this.stu = stu;
	}
	public Set<Check> getChecks() {
		return checks;
	}
	public void setChecks(Set<Check> checks) {
		this.checks = checks;
	}
	
}
