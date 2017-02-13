 package com.ht.service;

import java.util.List;

import com.ht.bean.Duty;
import com.ht.bean.info.TodayDutyInfo;
import com.ht.common.bean.Pager4EasyUI;

/**
 * ֵ�����Service
 * @author xiaoqiang
 *
 */
public interface DutyService extends BaseService<Duty> {

	public Pager4EasyUI<Duty> queryByPager2(Pager4EasyUI<Duty> pager);
	
	/**
	 * ��ѯ�����ֵ����Ϣ
	 * @return
	 */
	public List<TodayDutyInfo> queryByToday();
}
