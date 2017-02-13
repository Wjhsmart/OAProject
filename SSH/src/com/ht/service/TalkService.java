package com.ht.service;

import java.io.Serializable;

import com.ht.bean.Talk;
import com.ht.common.bean.Pager4EasyUI;

public interface TalkService extends BaseService<Talk> {

	/**
	 * ����Ա�������������ļ�����ģ���������ݣ�ע�⣺�����Ǻ�Emp�γɶ��һ�Ĺ�ϵ�ſ��Ե��ô˷���
	 * @param pager ��ҳ��ѯ
	 * @param empName Ա������
	 * @param beanObject ��ļ�����
	 * @return
	 */
	public Pager4EasyUI<Talk> queryByEmpName(Pager4EasyUI<Talk> pager, Serializable empName, Serializable beanObject);
}
