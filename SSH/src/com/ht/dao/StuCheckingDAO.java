package com.ht.dao;

import java.io.Serializable;

import com.ht.bean.StuChecking;
import com.ht.common.bean.Pager4EasyUI;

public interface StuCheckingDAO extends BaseDAO<StuChecking> {

	/**
	 * ���ݰ༶��Id��ѯ����ѧ��������Ϣ��Ȼ�������·ݣ���ѯ���յ���Ϣ
	 * @param pager ��ҳ����
	 * @param gradeId �༶��id
	 * @param month �·�
	 * @return
	 */
	public Pager4EasyUI<StuChecking> queryPagerByGradeId(Pager4EasyUI<StuChecking> pager, Serializable gradeId, int month);
	
}
