package com.ht.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.ht.bean.Course;
import com.ht.common.bean.ControllerResult;
import com.ht.common.bean.Pager4EasyUI;
import com.ht.common.web.WebUtil;
import com.opensymphony.xwork2.ActionSupport;
import com.ht.service.AuthorityRoleService;
import com.ht.service.CourseService;

public class CourseAction extends ActionSupport implements ServletRequestAware{

	private static final long serialVersionUID = -937554594318645021L;
	
	private HttpServletRequest req;
	
	private Course course;
	private CourseService courseService;
	private AuthorityRoleService authorityRoleService;
	private List<Course> rows;
	private long total;
	private ControllerResult result;
	private String id;
	private String name;
	private String value;
	
	public void setId(String id) {
		this.id = id;
	}

	@Override
	public void setServletRequest(HttpServletRequest req) {
		this.req = req;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public List<Course> getRows() {
		return rows;
	}

	public long getTotal() {
		return total;
	}

	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}
	
	public void setAuthorityRoleService(AuthorityRoleService authorityRoleService) {
		this.authorityRoleService = authorityRoleService;
	}
	
	public String pager(){
		String roleId = WebUtil.getRoleId(req);
		String methodName = CourseAction.class.getName() + ".pager";
		boolean f = authorityRoleService.queryByRole(methodName, roleId);
		System.out.println("roleId:" + roleId + ", methodName:" + methodName + ", f:" + f);
		if (f == false) {
			result = ControllerResult.setFailResult("��Ǹ,��û��Ȩ�޲���");
			return "pager";
		}
		Pager4EasyUI<Course> pager = new Pager4EasyUI<Course>();
		pager.setPageNo(WebUtil.getPageNo(req));
		pager.setPageSize(WebUtil.getPageSize(req));
		pager = courseService.queryByPager("Course", pager);
		rows = pager.getRows();
		total = pager.getTotal();
		result = ControllerResult.setSuccessResult("��ѯ�ɹ�");
		return "pager";
	}
	
	public String add(){
		String roleId = WebUtil.getRoleId(req);
		String methodName = CourseAction.class.getName() + ".add";
		boolean f = authorityRoleService.queryByRole(methodName, roleId);
		System.out.println("roleId:" + roleId + ", methodName:" + methodName + ", f:" + f);
		if (f == false) {
			result = ControllerResult.setFailResult("��Ǹ,��û��Ȩ�޲���");
			return "add";
		}
		course.setStatus(1);
		courseService.save(course);
		result = ControllerResult.setSuccessResult("��ӳɹ�");
		return "add";
	}
	
	public String update(){
		String roleId = WebUtil.getRoleId(req);
		String methodName = CourseAction.class.getName() + ".update";
		boolean f = authorityRoleService.queryByRole(methodName, roleId);
		System.out.println("roleId:" + roleId + ", methodName:" + methodName + ", f:" + f);
		if (f == false) {
			result = ControllerResult.setFailResult("��Ǹ,��û��Ȩ�޲���");
			return "update";
		}
		course.setStatus(1);
		courseService.update(course);
		result = ControllerResult.setSuccessResult("���³ɹ�");
		return "update";
	}
	
	public String frost() {
		String roleId = WebUtil.getRoleId(req);
		String methodName = CourseAction.class.getName() + ".frost";
		Course course = courseService.queryById(Course.class, id);
		if (authorityRoleService.queryByRole(methodName, roleId)) {
			if (course.getStatus() == 1) {
				result = ControllerResult.setSuccessResult("����ɹ�");
				courseService.updateStatus("Course", "courseId", 0, id);
			} else {
				result = ControllerResult.setFailResult("�Ѿ��������ˣ������ٶ���");
			}
		} else {
			result = ControllerResult.setFailResult("��Ǹ,��û��Ȩ�޲���");
		}
		return "status";
	}
	
	public String activation() {
		String roleId = WebUtil.getRoleId(req);
		String methodName = CourseAction.class.getName() + ".activation";
		Course course = courseService.queryById(Course.class, id);
		if (authorityRoleService.queryByRole(methodName, roleId)) {
			if (course.getStatus() == 0) {
				result = ControllerResult.setSuccessResult("����ɹ�");
				courseService.updateStatus("Course", "courseId", 1, id);
			} else {
				result = ControllerResult.setFailResult("�Ѿ������ˣ������ټ���");
			}
		} else {
			result = ControllerResult.setFailResult("��Ǹ,��û��Ȩ�޲���");
		}
		return "status";
	}
	
	public ControllerResult getResult() {
		return result;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public String fuzzySearch() {
		String roleId = WebUtil.getRoleId(req);
		String methodName = CourseAction.class.getName() + ".fuzzySearch";
		if (authorityRoleService.queryByRole(methodName, roleId)) {
			Pager4EasyUI<Course> pager = new Pager4EasyUI<Course>();
			pager.setPageNo(WebUtil.getPageNo(req));
			pager.setPageSize(WebUtil.getPageSize(req));
			if (name.equals("courseName")) {
				pager = courseService.queryByCourseName(pager, value);
			}
			rows = pager.getRows();
			total = pager.getTotal();
			if (rows != null) {
				result = ControllerResult.setSuccessResult("���ҳɹ�");
			} else {
				result = ControllerResult.setFailResult("û�м�¼");
			}
		} else {
			result = ControllerResult.setFailResult("��Ǹ,��û��Ȩ�޲���");
		}
		return "fuzzySearch";
	}

}
