package com.ht.bean.info;

import java.io.Serializable;

/**
 * ����ֵ�����ʦ��Ϣ�����ƣ��绰���ص㣩
 * @author Administrator
 *
 */
public class TodayDutyInfo implements Serializable {

	private static final long serialVersionUID = -8678951910013837233L;
	private String name; // Ա������
	private String add; // �ص�
	private String phone; // Ա���绰

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdd() {
		return add;
	}

	public void setAdd(String add) {
		this.add = add;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
