package com.ht.bean;

import java.util.Set;

import org.apache.struts2.json.annotations.JSON;

/**
 * �������ͱ�
 * @author Administrator
 *
 */
public class NoticeType {

	private String noticeTypeId; // �������ͱ��
	private String name; // ����
	private String des; // ����
	private int status; // ״̬
	private Set<Notice> notice;
	
	@Override
	public String toString() {
		return "NoticeType [noticeTypeId=" + noticeTypeId + ", name=" + name + ", des=" + des + ", status=" + status
				+ "]";
	}
	@JSON(serialize = false)
	public Set<Notice> getNotice() {
		return notice;
	}
	public void setNotice(Set<Notice> notice) {
		this.notice = notice;
	}
	public String getNoticeTypeId() {
		return noticeTypeId;
	}
	public void setNoticeTypeId(String noticeTypeId) {
		this.noticeTypeId = noticeTypeId;
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
	
}
