package com.ht.service;

import java.io.Serializable;
import java.util.List;

import com.ht.bean.Stu;
import com.ht.common.bean.Pager4EasyUI;

public interface StuService extends BaseService<Stu> {

	/**
	 * ���ݰ༶��Id��ҳ��ѯ�ð༶������ѧ��
	 * @param pager ��ҳ��ѯ
	 * @param gradeId �༶Id
	 * @return
	 */
	public Pager4EasyUI<Stu> queryByGradeIdPager(Pager4EasyUI<Stu> pager, Serializable gradeId);
	
	public Pager4EasyUI<Stu> queryByGradePager(Pager4EasyUI<Stu> pager, Serializable gradeId);
	
	/**
	 * ����ѧ��״̬������Ԥ���� ��ʽ����ѯѧ��
	 * @param pager
	 * @param stuStatus ѧ��״̬
	 * @return
	 */
	public Pager4EasyUI<Stu> stuStatusByPager(Pager4EasyUI<Stu> pager, String stuStatus);
	
	public Pager4EasyUI<Stu> stuStatusByPager1(Pager4EasyUI<Stu> pager, String stuStatus);
	
	/**
	 * ����ѧ��״̬��ѯ�Լ���ѧ��
	 * @param pager
	 * @param stuStatus
	 * @param empId
	 * @return
	 */
	public Pager4EasyUI<Stu> queryBySelf(Pager4EasyUI<Stu> pager, String stuStatus, String empId);
	
	/**
	 * ��������id��ҳ��ѯ�����������ѧ��
	 * @param pager
	 * @param roomId
	 * @return
	 */
	public Pager4EasyUI<Stu> queryByRoomIdPager(Pager4EasyUI<Stu> pager, Serializable roomId);
	
	
	/**
	 * ���ݰ༶id��ѯ�༶��ѧ������
	 * @param gradeId
	 * @return
	 */
	public long gradeCount(String gradeId);
	
	public long gradeCount1(String gradeId);
	
	/**
	 * ���ݰ༶id����Ҫ��ӵ�ѧ����id�����������
	 * @param gradeId
	 * @param stuIds
	 */
	public void addStusToGrade(String gradeId, String[] stuIds);
	
	/**
	 * ��������id����Ҫ��ӵ�ѧ����id�����������
	 * @param roomId
	 * @param stuIds
	 */
	public void addStusToRoom(String roomId, String[] stuIds);
	
	/**
	 * ����ѧ����״̬��ѯѧ���ĸ���
	 * @param stuStatus
	 * @return
	 */
	public long stuStatusCount(String stuStatus);
	
	public long stuStatusCount1(String stuStatus);
	
	public long stuStatusCount(String stuStatus, String empId);

	public List<Stu> queryType(int status);
	/**
	 * ����ѧ������ģ������
	 * @param pager
	 * @param stuName
	 * @param stuStatus
	 * @return
	 */
	public Pager4EasyUI<Stu> queryByStuName(Pager4EasyUI<Stu> pager, String stuName, String stuStatus);
	
	/**
	 * ����Stu����ѧ��״̬
	 * @param t
	 */
	public void updateStuStatus(Stu stu);
	
	public int getRoomStuCount(String roomId);
	
	public int getGradeStuCount(String gradeId);
	
	public String generateStuNo();
	
	/**
	 * ѧ�����е�����֤
	 * @param stu
	 * @return
	 */
	public Stu queryByLogin(Stu stu);
	
}
