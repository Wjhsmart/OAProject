package com.ht.bean;

import java.util.Set;

import org.apache.struts2.json.annotations.JSON;

/**
 * ֧�����ͱ�
 * @author interface
 *
 */
public class PayType {

	private String payTypeId;//֧�������
	private String name;//����
	private String des;//����
	private int status;//״̬��Ĭ��Ϊ����
	
	private Set<Pay> pays;
	
	public String getPayTypeId() {
		return payTypeId;
	}
	public void setPayTypeId(String payTypeId) {
		this.payTypeId = payTypeId;
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
	
	@JSON(serialize=false)
	public Set<Pay> getPays() {
		return pays;
	}
	public void setPays(Set<Pay> pays) {
		this.pays = pays;
	}
	
}
