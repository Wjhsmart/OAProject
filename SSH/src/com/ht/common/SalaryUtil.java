package com.ht.common;

/**
 * ���㹤���õ�����
 * @author Administrator
 *
 */
public class SalaryUtil {

	/**
	 * ����ʵ������
	 * @param basicSalary ��������
	 * @param jobSalary ��λ����
	 * @param extraSalary ��������
	 * @param subSalary �۷�����
	 * @return
	 */
	public static double totalSalary(double basicSalary, double jobSalary, double extraSalary, double subSalary) {
		
		return basicSalary + jobSalary + extraSalary - subSalary;
	}
	
	/**
	 * ����Ӧ������
	 * @param basicSalary ��������
	 * @param jobSalary ��λ����
	 * @param extraSalary ��������
	 * @param subSalary �۷�����
	 * @return
	 */
	public static double shouldSalary(double basicSalary, double jobSalary, double extraSalary, double subSalary) {
		
		return basicSalary + jobSalary + extraSalary;
	}
}
