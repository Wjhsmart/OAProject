package com.ht.bean;

import java.util.Date;

/**
 * �����
 * @author Administrator
 *
 */
public class Notice {

	private String noticeId; // ������
	private String name; // �������
	private String des; // ��������
	private Date noticeDay; // ����ʱ��
	private int status; //״̬
	private NoticeType noticetype; //��������
	
	private Emp emp; // ������
	
	public NoticeType getNoticetype() {
		return noticetype;
	}
	
	public void setNoticetype(NoticeType noticetype) {
		this.noticetype = noticetype;
	}
	public String getNoticeId() {
		return noticeId;
	}
	public void setNoticeId(String noticeId) {
		this.noticeId = noticeId;
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
	public Date getNoticeDay() {
		return noticeDay;
	}
	public void setNoticeDay(Date noticeDay) {
		this.noticeDay = noticeDay;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

	public Emp getEmp() {
		return emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}
}
