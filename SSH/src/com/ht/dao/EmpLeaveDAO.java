package com.ht.dao;

import com.ht.bean.EmpLeave;
/**
 * Ա����ٹ���DAO
 * @author xiaoqiang
 *
 */
import com.ht.common.bean.Pager4EasyUI;
public interface EmpLeaveDAO extends BaseDAO<EmpLeave> {

	/**
	 * ����������||�Լ�״̬
	 * @param beanName
	 * @param idName
	 * @param status
	 * @param id
	 */
	public void updateSecondLevel(String beanName,String levelName, String idName, int secondLevel, String id);
	/**
	 * ͨ��Ա��Id��ѯ��ٷ�ҳ
	 * @param pager
	 * @param empId
	 * @return
	 */
	public Pager4EasyUI<EmpLeave> byIdPager(Pager4EasyUI<EmpLeave> pager, String empId);
	/**
	 * ��ѯ��ǰ�����µ���ٷ�ҳ
	 * @param pager
	 * @param depId
	 * @return
	 */
	public Pager4EasyUI<EmpLeave> byDepIdPager(Pager4EasyUI<EmpLeave> pager, String depId);
}
