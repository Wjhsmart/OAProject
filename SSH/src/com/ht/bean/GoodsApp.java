package com.ht.bean;

import java.util.Date;

/**
 * ��Ʒ�깺��
 * @author Administrator
 *
 */
public class GoodsApp {

	private String goodsAppId; // ��Ʒ�깺���
	private String empId; // Ա�����
	private String goodsTypeId;
	private Date appDay; // �깺ʱ��
	private String goodsName; // �깺����Ʒ����
	private double price;
	private int quantity; // �깺��Ʒ������
	private String des; // �깺��Ʒ������
	private int status; // ״̬��Ĭ�Ͽ���
	private int appStatus; // �깺״̬���ɹ���Ϊ1��ʧ����Ϊ0
	public String getGoodsAppId() {
		return goodsAppId;
	}
	public void setGoodsAppId(String goodsAppId) {
		this.goodsAppId = goodsAppId;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public Date getAppDay() {
		return appDay;
	}
	public void setAppDay(Date appDay) {
		this.appDay = appDay;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
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
	public int getAppStatus() {
		return appStatus;
	}
	public void setAppStatus(int appStatus) {
		this.appStatus = appStatus;
	}
	public String getGoodsTypeId() {
		return goodsTypeId;
	}
	public void setGoodsTypeId(String goodsTypeId) {
		this.goodsTypeId = goodsTypeId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
}
