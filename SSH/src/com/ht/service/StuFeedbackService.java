package com.ht.service;

import java.io.Serializable;

import com.ht.bean.StuFeedback;
import com.ht.common.bean.Pager4EasyUI;

public interface StuFeedbackService extends BaseService<StuFeedback> {

	/**
	 * ����ѧ��id��ҳ��ѯ��ѧ���ķ�����Ϣ
	 * @param pager ��ҳ���
	 * @param stuId ѧ��id
	 * @return
	 */
	public Pager4EasyUI<StuFeedback> queryByStuId(Pager4EasyUI<StuFeedback> pager, Serializable stuId);
	
	/**
	 * ����ʱ��β�ѯָ��ѧ���ķ�����Ϣ
	 * @param pager ��ҳ���
	 * @param stuId ѧ��id
	 * @param startDay ��ʼʱ��
	 * @param endDay ����ʱ��
	 * @return
	 */
	public Pager4EasyUI<StuFeedback> queryByDayAndStuId(Pager4EasyUI<StuFeedback> pager, Serializable stuId, String startDay, String endDay);
	
}
