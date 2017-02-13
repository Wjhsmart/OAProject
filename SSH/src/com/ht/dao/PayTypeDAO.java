package com.ht.dao;

import java.util.List;

import com.ht.bean.PayType;
import com.ht.common.bean.Pager4EasyUI;

public interface PayTypeDAO extends BaseDAO<PayType> {
	
	/**
	 * �鿴�Ƿ񱻶���
	 * @param name
	 * @param status
	 * @param pager
	 * @return
	 */
	public Pager4EasyUI<PayType> queryFreeze(String name, int status, Pager4EasyUI<PayType> pager);
	

	/**
	 * ��ҳ����
	 * @param beanName
	 * @return
	 */
	public long countStatus(String beanName, int status);
	
	/**
	 * ��������ѯ
	 * @param pager
	 * @param name
	 * @param value
	 * @param status
	 * @return
	 */
	public Pager4EasyUI<PayType> queryPayTypeName(Pager4EasyUI<PayType> pager, String name, String value);


	public List<PayType> queryType(int status);
	
	public long countName(String name, String value);
}
