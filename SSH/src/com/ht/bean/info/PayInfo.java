package com.ht.bean.info;

import java.util.Date;

public class PayInfo {
	
	private String payId;//֧�����
	private String empName;//Ա������
	private String payTypeName;//֧������
	private Date payDay;//֧��ʱ��
	private String des;//����
	private double pay;//֧�����
	private String toName;//�տ�������
	private String toPhone;//�տ��˺���
	private int payTypeStatus;
	private String payTypeId;
	
	
	public String getPayTypeId() {
		return payTypeId;
	}
	public void setPayTypeId(String payTypeId) {
		this.payTypeId = payTypeId;
	}
	public String getPayId() {
		return payId;
	}
	public void setPayId(String payId) {
		this.payId = payId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getPayTypeName() {
		return payTypeName;
	}
	public void setPayTypeName(String payTypeName) {
		this.payTypeName = payTypeName;
	}
	public Date getPayDay() {
		return payDay;
	}
	public void setPayDay(Date payDay) {
		this.payDay = payDay;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public double getPay() {
		return pay;
	}
	public void setPay(double pay) {
		this.pay = pay;
	}
	public String getToName() {
		return toName;
	}
	public void setToName(String toName) {
		this.toName = toName;
	}
	public String getToPhone() {
		return toPhone;
	}
	public void setToPhone(String toPhone) {
		this.toPhone = toPhone;
	}
	public int getPayTypeStatus() {
		return payTypeStatus;
	}
	public void setPayTypeStatus(int payTypeStatus) {
		this.payTypeStatus = payTypeStatus;
	}
}
