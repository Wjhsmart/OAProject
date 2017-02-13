package com.ht.service;

import java.io.Serializable;

import com.ht.bean.info.SalaryInfo1;
import com.ht.common.bean.Pager4EasyUI;

public interface SalaryInfoService1 {

	/**
	 * ��ҳ��ѯ���ʵķ������
	 * @param pager
	 * @return
	 */
	public Pager4EasyUI<SalaryInfo1> queryByPager(Pager4EasyUI<SalaryInfo1> pager);
	
	/**
	 * �������
	 * @return
	 */
	public long count();
	
	/**
	 * ��ѯָ��ʱ��ε�����
	 * @param pager ��ҳ
	 * @param startDay ��ʼʱ��
	 * @param endDay ����ʱ��
	 * @return
	 */
	public Pager4EasyUI<SalaryInfo1> queryByDay(Pager4EasyUI<SalaryInfo1> pager, Serializable startDay, Serializable endDay);
	
	/**
	 * ����Ա������ģ����ѯ
	 * @param pager ��ҳ
	 * @param empName Ա������
	 * @return
	 */
	public Pager4EasyUI<SalaryInfo1> queryByName(Pager4EasyUI<SalaryInfo1> pager, Serializable empName);
	
	/**
	 * ��ѯָ��ʱ��ε����ݣ���ѯָ��Ա������Ϣ
	 * @param pager ��ҳ
	 * @param startDay ��ʼʱ��
	 * @param endDay ����ʱ��
	 * * @param empId Ա��id
	 * @return
	 */
	public Pager4EasyUI<SalaryInfo1> queryByDayAndEmpId(Pager4EasyUI<SalaryInfo1> pager, Serializable startDay, Serializable endDay, Serializable empId);
	
	public Pager4EasyUI<SalaryInfo1> queryPageEmpId(Pager4EasyUI<SalaryInfo1> pager, Serializable empId);
}
