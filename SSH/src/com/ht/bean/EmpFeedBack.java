package com.ht.bean;

import java.util.Date;

import org.apache.struts2.json.annotations.JSON;
/**
 * Ա��������
 * @author Xiao-Qiao
 *
 */
public class EmpFeedBack {

	private String feedBackId;// �������
	private Date feedBackDay;// ����ʱ��
	private String des;// ��������
	private int status;// ״̬��Ĭ��Ϊ����
	
	private Emp emp; // Ա��

	public Date getFeedBackDay() {
		return feedBackDay;
	}
	public void setFeedBackDay(Date feedBackDay) {
		this.feedBackDay = feedBackDay;
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
	@JSON(serialize = true)
	public Emp getEmp() {
		return emp;
	}
	public void setEmp(Emp emp) {
		this.emp = emp;
	}
	public String getFeedBackId() {
		return feedBackId;
	}
	public void setFeedBackId(String feedBackId) {
		this.feedBackId = feedBackId;
	}

}
