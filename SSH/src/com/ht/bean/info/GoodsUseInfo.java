package com.ht.bean.info;

import java.util.Date;

public class GoodsUseInfo {
	private String useId;//���ñ��
	private String goodsId;//��Ʒ���
	private String goodsName;//��Ʒ����
	private String empId;//Ա�����
	private String empName;//Ա������
	private int quantity;//���õ���Ʒ����
	private Date useDay;//����ʱ��
	private Date ereturnDay;//Ԥ���黹ʱ��
	private Date returnDay;//�黹ʱ��
	private int returnStatus;
	private int checkStatus;
	
	public String getUseId() {
		return useId;
	}
	public void setUseId(String useId) {
		this.useId = useId;
	}
	public String getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Date getUseDay() {
		return useDay;
	}
	public void setUseDay(Date useDay) {
		this.useDay = useDay;
	}
	public Date getEreturnDay() {
		return ereturnDay;
	}
	public void setEreturnDay(Date ereturnDay) {
		this.ereturnDay = ereturnDay;
	}
	public Date getReturnDay() {
		return returnDay;
	}
	public void setReturnDay(Date returnDay) {
		this.returnDay = returnDay;
	}
	
	@Override
	public String toString() {
		return "GoodsUseInfo [useId=" + useId + ", goodsId=" + goodsId + ", goodsName=" + goodsName + ", empId=" + empId
				+ ", empName=" + empName + ", quantity=" + quantity + ", useDay=" + useDay + ", ereturnDay="
				+ ereturnDay + ", returnDay=" + returnDay + "]";
	}
	public int getReturnStatus() {
		return returnStatus;
	}
	public void setReturnStatus(int returnStatus) {
		this.returnStatus = returnStatus;
	}
	public int getCheckStatus() {
		return checkStatus;
	}
	public void setCheckStatus(int checkStatus) {
		this.checkStatus = checkStatus;
	}
	
}
