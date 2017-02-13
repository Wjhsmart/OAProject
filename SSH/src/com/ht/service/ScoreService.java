package com.ht.service;

import java.io.Serializable;

import com.ht.bean.Score;
import com.ht.common.bean.Pager4EasyUI;

public interface ScoreService extends BaseService<Score> {

	/**
	 * ���ݰ༶��Id��ѯ�ð༶����ѧ��ָ���γ̵ĳɼ�
	 * @param pager ��ҳ����
	 * @param gradeId �༶��id
	 * @param courseId �γ̵�id
	 * @return
	 */
	public Pager4EasyUI<Score> queryPagerByGradeId(Pager4EasyUI<Score> pager, Serializable gradeId, Serializable courseId);

	/**
	 * ����ѧ��id��ҳ��ѯ��ѧ���ĳɼ�
	 * @param pager
	 * @param stuId
	 * @return
	 */
	public Pager4EasyUI<Score> queryByStuId(Pager4EasyUI<Score> pager, Serializable stuId);
	
	/**
	 * ����ʱ��β�ѯָ��ѧ���ĳɼ�
	 * @param pager ��ҳ���
	 * @param stuId ѧ��id
	 * @param startDay ��ʼʱ��
	 * @param endDay ����ʱ��
	 * @return
	 */
	public Pager4EasyUI<Score> queryByDayAndStuId(Pager4EasyUI<Score> pager, Serializable stuId, String startDay, String endDay);
	
}
