package com.ht.dao;

import com.ht.bean.Role;
import com.ht.common.bean.Pager4EasyUI;
/**
 * Ա����ɫDAO
 * @author Administrator
 *
 */
public interface RoleDAO extends BaseDAO<Role>{
	
	
	/**
	 * �������Ʋ�ѯ��ɫid
	 * @return
	 */
	public String queryRoleIdByName(String name);
	
	/**
	 * ���ݽ�ɫ����ģ������
	 * @param pager
	 * @param noticeTypeName
	 * @return
	 */
	public Pager4EasyUI<Role> queryByroleName(Pager4EasyUI<Role> pager, String roleName);
	
	
}
