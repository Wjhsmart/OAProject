package com.ht.dao;

import java.io.Serializable;
import java.util.List;

import com.ht.common.bean.Pager4EasyUI;

public interface BaseDAO<T> {

	/**
	 * ���ݴ��ݽ����Ķ��󱣴�������ݿ�
	 * @param t
	 */
	public void save(T t);
	
	/**
	 * ���ݴ��ݽ�������ɾ�����ݿ��е�����
	 * @param t
	 */
	public void delete(T t);
	
	/**
	 * ���ݴ��ݽ����Ķ���������ݿ��е�����
	 * @param t
	 */
	public void update(T t);
	
	/**
	 * ����Id��ѯ���ݿ��е�����
	 * @param clazz
	 * @param s
	 * @return
	 */
	public T queryById(Class<?> clazz, Serializable s);
	
	/**
	 * MySQL�ķ�ʽ��ҳ��ѯ���ݿ��е�����
	 * @param beanName
	 * @param pager
	 * @return
	 */
	public Pager4EasyUI<T> queryByPager(String beanName, Pager4EasyUI<T> pager);
	
	/**
	 * ���ݴ��ݽ����ļ�������ѯ���ݿ��е���������
	 * @return
	 */
	public List<T> queryAll(String beanName);
	
	/**
	 * ���㴫�ݽ���������������ݵ��ܸ���
	 * @param clazz
	 * @return
	 */
	public long count(String beanName);
	
	/**
	 * ���ݶ���ļ�������id�ֶε����ƣ���״̬������״̬
	 * @param beanName ������
	 * @param idName ������Ӧ��id������
	 * @param status ״̬
	 * @param id id
	 * @return
	 */
	public void updateStatus(String beanName, String idName, int status, String id);
	
	/**
	 * ����ѧ�������������ļ�����ģ���������ݣ�ע�⣺�����Ǻ�Stu�γɶ��һ�Ĺ�ϵ�ſ��Ե��ô˷���
	 * @param pager ��ҳ��ѯ
	 * @param stuName ѧ������
	 * @param beanObject ��ļ�����
	 * @return
	 */
	public Pager4EasyUI<T> queryByStuName(Pager4EasyUI<T> pager, Serializable stuName, Serializable beanObject);
	
	/**
	 * ����Ա�������������ļ�����ģ���������ݣ�ע�⣺�����Ǻ�Emp�γɶ��һ�Ĺ�ϵ�ſ��Ե��ô˷���
	 * @param pager ��ҳ��ѯ
	 * @param empName Ա������
	 * @param beanObject ��ļ�����
	 * @return
	 */
	public Pager4EasyUI<T> queryByEmpName(Pager4EasyUI<T> pager, Serializable empName, Serializable beanObject);
	
	/**
	 * ����ʱ������������ݴ��ݽ����Ŀ�ʼʱ��ͽ���ʱ�䣬�Ͷ���ļ��������Ϳ�ʼ������ʱ����������ƽ�������
	 * @param pager ��ҳ����
	 * @param startDay ��ʼʱ��
	 * @param endDay ����ʱ��
	 * @param beanObject ����ļ�����
	 * @param attrName ��������Ҫƥ���������
	 * @return
	 */
	public Pager4EasyUI<T> queryByDay(Pager4EasyUI<T> pager, Serializable startDay,
			Serializable endDay, Serializable beanObject, Serializable attrName);
}
