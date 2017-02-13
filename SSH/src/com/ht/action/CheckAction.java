package com.ht.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ht.bean.Check;
import com.ht.common.bean.ControllerResult;
import com.ht.common.bean.Pager4EasyUI;
import com.ht.common.web.WebUtil;
import com.ht.service.AuthorityRoleService;
import com.ht.service.CheckService;

public class CheckAction extends BaseAction {

	private static final long serialVersionUID = 966476494460127760L;

	private CheckService checkService;
	private Check check;
	private HttpServletRequest req;
	private List<Check> rows;
	private long total;
	private ControllerResult result;
	private String startDay;
	private String endDay;
	private String value; // ģ��������ֵ
	private AuthorityRoleService authorityRoleService;
	
	public void setAuthorityRoleService(AuthorityRoleService authorityRoleService) {
		this.authorityRoleService = authorityRoleService;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	public void setStartDay(String startDay) {
		this.startDay = startDay;
	}
	
	public void setEndDay(String endDay) {
		this.endDay = endDay;
	}
	
	public Check getCheck() {
		return check;
	}

	public void setCheck(Check check) {
		this.check = check;
	}

	public List<Check> getRows() {
		return rows;
	}

	public long getTotal() {
		return total;
	}

	public ControllerResult getResult() {
		return result;
	}

	public void setCheckService(CheckService checkService) {
		this.checkService = checkService;
	}

	@Override
	public void setServletRequest(HttpServletRequest req) {
		this.req = req;
	}
	
	public String pager() {
		String roleId = WebUtil.getRoleId(req);
		String methodName = CheckAction.class.getName() + ".pager";
		boolean f = authorityRoleService.queryByRole(methodName, roleId);
		if (f == false) {
			result = ControllerResult.setFailResult("��Ǹ����û��Ȩ�޲���");
			return "pager";
		}
		Pager4EasyUI<Check> pager = new Pager4EasyUI<Check>();
		pager.setPageNo(WebUtil.getPageNo(req));
		pager.setPageSize(WebUtil.getPageSize(req));
		pager = checkService.queryByPager("Check", pager);
		List<Check> checks = new ArrayList<Check>();
		if (!WebUtil.getRole(req).equals("�ܾ���") && !WebUtil.getRole(req).equals("У��") && !WebUtil.getRole(req).equals("��������")) {
			for (Check c : pager.getRows()) {
				if (c.getEmp().getEmpId().equals(WebUtil.getEmp(req).getEmpId())) {
					checks.add(c);
				}
			}
			pager.setRows(checks);
		}
		rows = pager.getRows();
		total = rows.size();
		return "pager";
	}
	
	public String add() {
		String roleId = WebUtil.getRoleId(req);
		String methodName = CheckAction.class.getName() + ".add";
		boolean f = authorityRoleService.queryByRole(methodName, roleId);
		if (f == false) {
			result = ControllerResult.setFailResult("��Ǹ����û��Ȩ�޲���");
			return "add";
		}
		if (check.getRoom().getRoomId().equals("") || check.getRoom().getRoomId() == null) {
			check.setRoom(null);
		} else if (check.getGrade().getGradeId().equals("") || check.getGrade().getGradeId() == null) {
			check.setGrade(null);
		}
		checkService.save(check);
		result = ControllerResult.setSuccessResult("��ӳɹ�");
		return "add";
	}
	
	public String update() {
		String roleId = WebUtil.getRoleId(req);
		String methodName = CheckAction.class.getName() + ".update";
		boolean f = authorityRoleService.queryByRole(methodName, roleId);
		if (f == false) {
			result = ControllerResult.setFailResult("��Ǹ����û��Ȩ�޲���");
			return "update";
		}
		if (check.getRoom().getRoomId().equals("") || check.getRoom().getRoomId() == null) {
			check.setRoom(null);
		} else if (check.getGrade().getGradeId().equals("") || check.getGrade().getGradeId() == null) {
			check.setGrade(null);
		}
		checkService.update(check);
		result = ControllerResult.setSuccessResult("�޸ĳɹ�");
		return "update";
	}
	
	public String pagerByDay() {
		String roleId = WebUtil.getRoleId(req);
		String methodName = CheckAction.class.getName() + ".pagerByDay";
		boolean f = authorityRoleService.queryByRole(methodName, roleId);
		if (f == false) {
			result = ControllerResult.setFailResult("��Ǹ����û��Ȩ�޲���");
			return "pagerByDay";
		}
		Pager4EasyUI<Check> pager = new Pager4EasyUI<Check>();
		pager.setPageNo(WebUtil.getPageNo(req));
		pager.setPageSize(WebUtil.getPageSize(req));
		pager = checkService.queryByDay(pager, startDay, endDay, "Check", "checktime");
		rows = pager.getRows();
		if (rows != null) {
			result = ControllerResult.setSuccessResult("���ҳɹ�");
		} else {
			result = ControllerResult.setFailResult("û�м�¼");
		}
		return "pagerByDay";
	}
	
	public String pagerByName() {
		String roleId = WebUtil.getRoleId(req);
		String methodName = CheckAction.class.getName() + ".pagerByName";
		boolean f = authorityRoleService.queryByRole(methodName, roleId);
		System.out.println("roleId:" + roleId + ", method:" + methodName + ", f:" + f);
		if (f == false) {
			result = ControllerResult.setFailResult("��Ǹ����û��Ȩ�޲���");
			return "pagerByName";
		}
		Pager4EasyUI<Check> pager = new Pager4EasyUI<Check>();
		pager.setPageNo(WebUtil.getPageNo(req));
		pager.setPageSize(WebUtil.getPageSize(req));
		pager = checkService.queryByEmpName(pager, value, "Check");
		rows = pager.getRows();
		if (rows != null) {
			result = ControllerResult.setSuccessResult("���ҳɹ�");
		} else {
			result = ControllerResult.setFailResult("û�м�¼");
		}
		return "pagerByName";
	}
}
