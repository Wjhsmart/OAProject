package com.ht.service;

import java.io.Serializable;

import com.ht.bean.StuChecking;
import com.ht.common.bean.Pager4EasyUI;

public interface StuCheckingService extends BaseService<StuChecking> {

	/**
	 * ���ݰ༶��Id��ѯ����ѧ��������Ϣ
	 * @param pager ��ҳ����
	 * @param gradeId �༶��id
	 * @return
	 */
	public Pager4EasyUI<StuChecking> queryPagerByGradeId(Pager4EasyUI<StuChecking> pager, Serializable gradeId, int month);
}
