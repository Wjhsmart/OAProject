package com.ht.dao;

import com.ht.bean.info.EmpInfo;
import com.ht.common.bean.Pager4EasyUI;

public interface EmpInfoDAO {
	/**
	 * ��ҳ��ѯָ�����ֶ�
	 * @param pager
	 * @return
	 */
	public Pager4EasyUI<EmpInfo> queryByPager(Pager4EasyUI<EmpInfo> pager);
	
	/**
	 * �������
	 * @return
	 */
	public long count();
}
