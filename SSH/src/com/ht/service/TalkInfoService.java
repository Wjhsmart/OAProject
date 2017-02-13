package com.ht.service;

import java.io.Serializable;

import com.ht.bean.info.TalkInfo;
import com.ht.common.bean.Pager4EasyUI;

public interface TalkInfoService {

	/**
	 * ��ҳ��ѯָ�����ֶ�
	 * @param pager
	 * @return
	 */
	public Pager4EasyUI<TalkInfo> queryByPager(Pager4EasyUI<TalkInfo> pager);
	
	/**
	 * �������
	 * @return
	 */
	public long count();
	
	/**
	 * ����ѧ��id��ѯ��ѧ����̸�ļ�¼ 
	 * @param pager ��ҳ���
	 * @param stuId ѧ��id
	 * @return
	 */
	public Pager4EasyUI<TalkInfo> queryByStuId(Pager4EasyUI<TalkInfo> pager, Serializable stuId);
	
	/**
	 * ����ѧ��id��ָ��ʱ��β�ѯ��ѧ����̸�ļ�¼
	 * @param pager
	 * @param stuId
	 * @param startDay
	 * @param endDay
	 * @return
	 */
	public Pager4EasyUI<TalkInfo> queryByDayAndStuId(Pager4EasyUI<TalkInfo> pager, Serializable stuId, String startDay, String endDay);

}
