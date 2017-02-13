package com.ht.bean.info;

import java.util.Date;

public class GoodsInfo {
	private String goodsId; // ��Ʒ���
	private String name; // ����
	private int quantity; // ����
	private String des; // ����
	private double unitPrice; // ����
	private Date buyDay; // ����ʱ��
	private String goodsTypeId; // ��Ʒ���ͱ��
	private String goodsTypeName;// ��Ʒ��������
	private int status; // ״̬��Ĭ�Ͽ���
	
	public String getGoodsId() {
		return goodsId;
	}
	
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
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
	
	public double getUnitPrice() {
		return unitPrice;
	}
	
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	public Date getBuyDay() {
		return buyDay;
	}
	
	public void setBuyDay(Date buyDay) {
		this.buyDay = buyDay;
	}
	
	public String getGoodsTypeId() {
		return goodsTypeId;
	}
	
	public void setGoodsTypeId(String goodsTypeId) {
		this.goodsTypeId = goodsTypeId;
	}
	
	
	public String getGoodsTypeName() {
		return goodsTypeName;
	}

	public void setGoodsTypeName(String goodsTypeName) {
		this.goodsTypeName = goodsTypeName;
	}

	public int getStatus() {
		return status;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "GoodsInfo [goodsId=" + goodsId + ", name=" + name + ", quantity=" + quantity + ", des=" + des
				+ ", unitPrice=" + unitPrice + ", buyDay=" + buyDay + ", goodsTypeId=" + goodsTypeId
				+ ", goodsTypename=" + goodsTypeName + ", status=" + status + "]";
	}
	
}
