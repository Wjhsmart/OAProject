package com.ht.bean;

import java.util.Date;

import org.apache.struts2.json.annotations.JSON;

/**
 * ѧ��������
 * @author Asa
 *
 */
public class StuFeedback {

	private String feedbackId; //�������
	private Date feedbackDay; //����ʱ��
	private String des; //��������
	private int status; //״̬��Ĭ�Ͽ���
	
	private Stu stu; // ѧ��
	
	public String getFeedbackId() {
		return feedbackId;
	}
	public void setFeedbackId(String feedbackId) {
		this.feedbackId = feedbackId;
	}
	public Date getFeedbackDay() {
		return feedbackDay;
	}
	public void setFeedbackDay(Date feedbackDay) {
		this.feedbackDay = feedbackDay;
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
	public Stu getStu() {
		return stu;
	}
	public void setStu(Stu stu) {
		this.stu = stu;
	}
	
}
