package com.ht.dao;

import com.ht.bean.info.EmpSalaryInfo;
import com.ht.common.bean.Pager4EasyUI;

public interface EmpSalaryInfoDAO extends BaseDAO<EmpSalaryInfo> {
	
	/**
	 * ���ʻ�����Ϣ���зֲ��鿴
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Pager4EasyUI<EmpSalaryInfo> queryEmpSalaryInfoPage(int status, Pager4EasyUI<EmpSalaryInfo> pager);
	
	/**
	 * ��ҳ����
	 * @param beanName
	 * @param status
	 * @return
	 */
	public long countStatus(int status);
	
	public Pager4EasyUI<EmpSalaryInfo> queryEmpSalaryInfoName(int status, Pager4EasyUI<EmpSalaryInfo> pager, String name, String value);
	
	public long countName(int status, String name, String value);
}
