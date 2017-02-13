package com.ht.dao;

import java.util.List;

import com.ht.bean.Duty;
import com.ht.bean.info.TodayDutyInfo;
import com.ht.common.bean.Pager4EasyUI;

/**
 * ֵ�����DAO
 * @author xiaoqiang
 *
 */
public interface DutyDAO extends BaseDAO<Duty> {
	
	public Pager4EasyUI<Duty> queryByPager2(Pager4EasyUI<Duty> pager);
	
	/**
	 * ��ѯ�����ֵ����Ϣ
	 * @return
	 */
	public List<TodayDutyInfo> queryByToday();
}
