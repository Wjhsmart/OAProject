package com.ht.dao;

public interface AuthorityRoleDAO {

	/**
	 * ���ݷ�����ȫ�޶����ͽ�ɫ��id��ѯ�Ƿ���Ȩ��
	 * @param methodName ������ȫ�޶���
	 * @param roleId ��ɫ��id
	 * @return �����Ȩ���򷵻�true�� ���򷵻�false
	 */
	public boolean queryByRole(String methodName, String roleId);
}
