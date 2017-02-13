package com.ht.dao;

import com.ht.bean.NoticeType;
import com.ht.common.bean.Pager4EasyUI;

/**
 * ��������DAO
 * @author Administrator
 *
 */	
public interface NoticeTypeDAO extends BaseDAO<NoticeType>{

	/**
	 * ���ݹ�������ģ������
	 * @param pager
	 * @param noticeTypeName
	 * @return
	 */
	public Pager4EasyUI<NoticeType> queryBynoticeTypeName(Pager4EasyUI<NoticeType> pager, String noticeTypeName);
}
