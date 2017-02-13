package com.ht.service;

import java.io.Serializable;

import com.ht.bean.StuLeave;
import com.ht.common.bean.Pager4EasyUI;

public interface StuLeaveService extends BaseService<StuLeave> {

	/**
	 * ����ѧ��id��ҳ��ѯ��ѧ���������Ϣ
	 * @param pager
	 * @param stuId
	 * @return
	 */
	public Pager4EasyUI<StuLeave> queryByStuId(Pager4EasyUI<StuLeave> pager, Serializable stuId);
	
	/**
	 * ����ʱ��β�ѯָ��ѧ���������Ϣ
	 * @param pager ��ҳ���
	 * @param stuId ѧ��id
	 * @param startDay ��ʼʱ��
	 * @param endDay ����ʱ��
	 * @return
	 */
	public Pager4EasyUI<StuLeave> queryByDayAndStuId(Pager4EasyUI<StuLeave> pager, Serializable stuId, String startDay, String endDay);
	
	/**
	 * 
	 * ���ڰ����κ��ο���ʦͨ��ѧ�����������
	 * @param fieldName �ֶε����ƣ����ο���ʦ����firstlevel�������δ���secondlevel
	 * @param stuLeave �����Ϣ�Ķ���
	 */
	public void updateLeaveStatus(StuLeave stuLeave, String fieldName);
	
}
