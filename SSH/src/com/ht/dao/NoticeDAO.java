package com.ht.dao;

import java.util.List;

import com.ht.bean.Notice;

/**
 * �����DAO
 * @author Administrator
 *
 */
public interface NoticeDAO extends BaseDAO<Notice>{

	/**
	 * ��ѯ���µ�ǰ3����
	 * @return
	 */
	public List<Notice> queryNewNotice();
}
