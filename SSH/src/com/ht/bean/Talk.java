package com.ht.bean;

import java.util.Date;

import org.apache.struts2.json.annotations.JSON;

/**
 * ѧ��̸�ı�
 * @author Administrator
 *
 */
public class Talk {

	private String talkId; // ̸�ı��
	private Date talkDay; // ̸��ʱ��
	private String des; // ̸������
	private int status; // ״̬��Ĭ��Ϊ����״̬��0��ʾ�����ã�1��ʾ����
	
	private Emp emp; // Ա��
	private Stu stu; // ѧ��
	
	public String getTalkId() {
		return talkId;
	}
	public void setTalkId(String talkId) {
		this.talkId = talkId;
	}
	public Date getTalkDay() {
		return talkDay;
	}
	public void setTalkDay(Date talkDay) {
		this.talkDay = talkDay;
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
	@JSON(serialize = false)
	public Emp getEmp() {
		return emp;
	}
	public void setEmp(Emp emp) {
		this.emp = emp;
	}
	@JSON(serialize = false)
	public Stu getStu() {
		return stu;
	}
	public void setStu(Stu stu) {
		this.stu = stu;
	}
	
	
	
	
}
