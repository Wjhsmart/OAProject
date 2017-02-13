package com.ht.dao;


import com.ht.bean.Grade;
import com.ht.common.bean.Pager4EasyUI;

public interface GradeDAO extends BaseDAO<Grade> {
	
	/**
	 * ���ݰ༶����ģ������
	 * @param pager
	 * @param gradeName
	 * @return
	 */
	public Pager4EasyUI<Grade> queryByGradeName(Pager4EasyUI<Grade> pager, String gradeName);
	
	
}
