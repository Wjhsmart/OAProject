package com.ht.service;

import java.io.Serializable;

import com.ht.bean.Summary;
import com.ht.common.bean.Pager4EasyUI;

public interface SummaryService extends BaseService<Summary> {

	/**
	 * ����ѧ��id��ҳ��ѯ��ѧ����̸����Ϣ
	 * @param pager
	 * @param stuId
	 * @return
	 */
	public Pager4EasyUI<Summary> queryByStuId(Pager4EasyUI<Summary> pager, Serializable stuId);
	
	/**
	 * ����ʱ��β�ѯָ��ѧ����̸����Ϣ
	 * @param pager ��ҳ���
	 * @param stuId ѧ��id
	 * @param startDay ��ʼʱ��
	 * @param endDay ����ʱ��
	 * @return
	 */
	public Pager4EasyUI<Summary> queryByDayAndStuId(Pager4EasyUI<Summary> pager, Serializable stuId, String startDay, String endDay);
	
}
