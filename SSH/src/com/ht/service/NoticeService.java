package com.ht.service;

import java.util.List;

import com.ht.bean.Notice;
/**
 * �����Service
 * @author Administrator
 *
 */
public interface NoticeService extends BaseService<Notice>{

	/**
	 * ��ѯ���µ�3������
	 * @return
	 */
	public List<Notice> queryNewNotice();
}
