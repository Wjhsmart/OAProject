package com.ht.common;

import org.apache.struts2.ServletActionContext;

/**
 * �����洢��������
 * @author Administrator
 *
 */
public class Constants {
	
	public static final String PATH_UPLOAD = ServletActionContext.getServletContext().getRealPath("/") + "upload"; // ��ȡ�������ϵ�uploadĿ¼
	
	public static final String PATH_EXCEL = ServletActionContext.getServletContext().getRealPath("/") + "excel\\"; // ��ȡ�������ϵ�excelĿ¼
	
	public static final String SALARY_NAME = "salary.xls";
	
	public static final String CHECKING_NAME = "checking.xls";
}
