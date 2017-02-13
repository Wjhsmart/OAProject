package com.ht.service;

import com.ht.bean.NoticeType;
import com.ht.common.bean.Pager4EasyUI;
/**
 * ��������Service
 * @author Administrator
 *
 */
public interface NoticeTypeService extends BaseService<NoticeType>{

	/**
	 * ���ݹ�������ģ������
	 * @param pager
	 * @param noticeTypeName
	 * @return
	 */
	public Pager4EasyUI<NoticeType> queryBynoticeTypeName(Pager4EasyUI<NoticeType> pager, String noticeTypeName);
}
