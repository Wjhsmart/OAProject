package com.ht.service;

import java.io.Serializable;

import com.ht.bean.GoodsApp;
import com.ht.bean.info.GoodsAppInfo;
import com.ht.common.bean.Pager4EasyUI;

public interface GoodsAppService extends BaseService<GoodsApp>{
	public Pager4EasyUI<GoodsAppInfo> queryByPager(Pager4EasyUI<GoodsAppInfo> pager);
	
	/**
	 * ��ҳ��ѯ�Լ����깺
	 * @param pager
	 * @return
	 */
	public Pager4EasyUI<GoodsAppInfo> queryBySelf(Pager4EasyUI<GoodsAppInfo> pager, Serializable empId);
	
	/**
	 * �����깺�����
	 * @param beanName
	 * @param levelName
	 * @param idName
	 * @param secondLevel
	 * @param id
	 */
	public void updateAppStatus(String beanName, String levelName, String idName, int secondLevel, String id);
}
