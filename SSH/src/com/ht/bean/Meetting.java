package com.ht.bean;

import java.util.Date;

import org.apache.struts2.json.annotations.JSON;
/**
 * ���ֻ��
 * @author Xiao-Qiao
 *
 */
public class Meetting {

	private String meettingId;// ���ֻ���
	private Date meettingDay;// ���ֻ�ʱ��
	private Date createdDay;// ���ʱ��
	private String des;// ���ֻ�����
	private int status;// ״̬��Ĭ��Ϊ����
	
	private Emp emp; // Ա��

	public String getMeettingId() {
		return meettingId;
	}
	public void setMeettingId(String meettingId) {
		this.meettingId = meettingId;
	}
	@JSON(serialize = true)
	public Emp getEmp() {
		return emp;
	}
	public void setEmp(Emp emp) {
		this.emp = emp;
	}
	public Date getMeettingDay() {
		return meettingDay;
	}
	public void setMeettingDay(Date meettingDay) {
		this.meettingDay = meettingDay;
	}
	public Date getCreatedDay() {
		return createdDay;
	}
	public void setCreatedDay(Date createdDay) {
		this.createdDay = createdDay;
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
	@Override
	public String toString() {
		return "Meetting [meettingId=" + meettingId + ", meettingDay=" + meettingDay + ", createdDay=" + createdDay
				+ ", des=" + des + ", status=" + status + "]";
	}
}
