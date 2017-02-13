package com.ht.service;

import java.io.Serializable;

import com.ht.bean.Job;
import com.ht.common.bean.Pager4EasyUI;

public interface JobService extends BaseService<Job> {

	/**
	 * ����ѧ��id��ҳ��ѯ��ѧ���ľ�ҵ��Ϣ
	 * @param pager
	 * @param stuId
	 * @return
	 */
	public Pager4EasyUI<Job> queryByStuId(Pager4EasyUI<Job> pager, Serializable stuId);
	
	/**
	 * ����ʱ��β�ѯָ��ѧ���ľ�ҵ��Ϣ
	 * @param pager ��ҳ���
	 * @param stuId ѧ��id
	 * @param startDay ��ʼʱ��
	 * @param endDay ����ʱ��
	 * @return
	 */
	public Pager4EasyUI<Job> queryByDayAndStuId(Pager4EasyUI<Job> pager, Serializable stuId, String startDay, String endDay);
}
