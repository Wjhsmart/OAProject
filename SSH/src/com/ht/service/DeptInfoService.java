package com.ht.service;

import com.ht.bean.info.DeptInfo;
import com.ht.common.bean.Pager4EasyUI;

public interface DeptInfoService {
	/**
	 * ʵ�ֲ��ŷ�ҳ����
	 * 
	 * @return
	 */
	public Pager4EasyUI<DeptInfo> queryByPager(Pager4EasyUI<DeptInfo> pager);
	
	public Pager4EasyUI<DeptInfo> queryBeforeEmp(Pager4EasyUI<DeptInfo> pager, String beforeId);
}
