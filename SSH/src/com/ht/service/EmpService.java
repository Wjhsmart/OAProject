package com.ht.service;

import java.io.Serializable;
import java.util.List;

import com.ht.bean.Emp;
import com.ht.common.bean.Pager4EasyUI;

public interface EmpService extends BaseService<Emp> {

	/**
	 * ���е�����֤
	 * @param emp
	 * @return
	 */
	public Emp queryByLogin(Emp emp);
	
	/**
	 * ͨ������IDȥ��Ա����ҳ
	 * @param pager
	 * @param depId
	 * @return
	 */
	public Pager4EasyUI<Emp> queryByPager2(Pager4EasyUI<Emp> pager, String depId);
	/**
	 * ͨ������IDȥͳ���ж��ٸ�Ա��
	 * @param depId
	 * @return
	 */
	public Long depIdCount(String depId);
	
	public List<Emp> queryType(int status);
	
	/**
	 * ���ݽ�ɫ����Idȥ��ѯ���ڸý�ɫ���Ƶ�����Ա��
	 * @param pager��ҳ��ѯ
	 * @param empIdԱ��Id
	 * @return
	 */
	public Pager4EasyUI<Emp> queryByEmpIdPager(Pager4EasyUI<Emp> pager, Serializable roleId);
	/**
	 * ����Ա��Id��ѯԱ�����ܸ���
	 * @param empId
	 * @return
	 */
	public long empCount(String roleId);
	
	/**
	 * ���ݽ�ɫid��Ա��
	 * @param pager
	 * @param roleId
	 * @return
	 */
	public Pager4EasyUI<Emp> queryEmpByRoleId(Pager4EasyUI<Emp> pager, String roleId);
	
	public long empRoleIdCount(String roleId);
	
	/**
	 * ����Ա��������ѯԱ��
	 * @param pager
	 * @param empName
	 * @return
	 */
	public Pager4EasyUI<Emp> queryByName(Pager4EasyUI<Emp> pager, Serializable empName,Serializable beanObject);
	
	/**
	 * ���Ա��֮ǰ����֤���䣬��ѯ���ݿ��Ƿ��Ѿ�����
	 * @param emp
	 * @return
	 */
	public boolean queryByEmail(Emp emp);
	
	public Pager4EasyUI<Emp> queryByPagerEmpId(Pager4EasyUI<Emp> pager, String empId);
	
	public Emp QueryEmp(String empId);
	
	public void updateSalaryInfo(Emp emp);
}
