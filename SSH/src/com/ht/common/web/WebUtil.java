package com.ht.common.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ht.bean.Emp;
import com.ht.bean.Stu;

/**
 * ���ڻ�ȡWeb�����Ĺ�����
 * @author Administrator
 *
 */
public class WebUtil {
	
	public static final int PAGE_NO = 1;
	public static final int PAGE_SIZE = 20;

	/**
	 * ��ȡҳ��ҳ��
	 * @param req
	 * @return
	 */
	public static int getPageNo(HttpServletRequest req) {
		String pageNoStr = req.getParameter("page");
		if (pageNoStr != null && !pageNoStr.equals("")) {
			return Integer.valueOf(pageNoStr);
		}
		return PAGE_NO;
	}
	
	/**
	 * ��ȡÿҳ��ʾ�Ĵ�С
	 * @param req
	 * @return
	 */
	public static int getPageSize(HttpServletRequest req) {
		String pageSizeStr = req.getParameter("rows");
		if (pageSizeStr != null && !pageSizeStr.equals("")) {
			return Integer.valueOf(pageSizeStr);
		}
		return PAGE_SIZE;
	}
	
	/**
	 * ��ȡ��ǰ����Ľ�ɫ
	 * @return
	 */
	public static String getRole(HttpServletRequest req) {
		HttpSession session = req.getSession();
		Emp emp = (Emp) session.getAttribute("emp");
		if (emp != null) {
			return emp.getRole().getName();
		} else {
			return null;
		}
	}
	
	/**
	 * ��ȡ��ǰ�����˺ŵĽ�ɫid
	 * @param req
	 * @return
	 */
	public static String getRoleId(HttpServletRequest req) {
		HttpSession session = req.getSession();
		Object obj = session.getAttribute("emp");
		if (obj == null) {
			obj = session.getAttribute("stu");
		}
		if (obj != null) {
			if (obj instanceof Emp) {
				Emp emp = (Emp) obj;
				return emp.getRole().getRoleId();
			} else if (obj instanceof Stu) {
				Stu stu = (Stu) obj;
				return stu.getRoleId();
			}
		}
		return null;
	}
	
	/**
	 * ��ȡ��ǰ��emp
	 * @param req
	 * @return
	 */
	public static Emp getEmp(HttpServletRequest req) {
		HttpSession session = req.getSession();
		return (Emp) session.getAttribute("emp");
	}
	
	/**
	 * ��ȡ��ǰ�����ѧ��id
	 * @param req
	 * @return
	 */
	public static String getStuId(HttpServletRequest req) {
		HttpSession session = req.getSession();
		Stu stu = (Stu) session.getAttribute("stu");
		if (stu != null) {
			return stu.getStuId();
		}
		return null;
	}
	
}
