package com.ht.service;

import com.ht.bean.EmpLeave;
import com.ht.common.bean.Pager4EasyUI;
/**
 * Ա����ٹ���Service
 * @author xiaoqiang
 *
 */
public interface EmpLeaveService extends BaseService<EmpLeave> {
	/**
	 * ���������ˣ��ϰ壩
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
