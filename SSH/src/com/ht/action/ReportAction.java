package com.ht.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ht.bean.Report;
import com.ht.common.bean.ControllerResult;
import com.ht.common.bean.Pager4EasyUI;
import com.ht.common.web.WebUtil;
import com.ht.service.AuthorityRoleService;
import com.ht.service.ReportService;

public class ReportAction extends BaseAction {

	private static final long serialVersionUID = -8800619177828973772L;

	private ReportService reportService;
	private Report report;
	private HttpServletRequest req;
	private List<Report> rows;
	private String startDay;
	private String endDay;
	private String value;
	private String id;
	private AuthorityRoleService authorityRoleService;
	
	public void setAuthorityRoleService(AuthorityRoleService authorityRoleService) {
		this.authorityRoleService = authorityRoleService;
	}
	public void setId(String id) {
		this.id = id;
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

	@Override
	public void setServletRequest(HttpServletRequest req) {
		this.req = req;
	}

	public List<Report> getRows() {
		return rows;
	}

	public long getTotal() {
		return total;
	}

	public ControllerResult getResult() {
		return result;
	}

	private long total;
	private ControllerResult result;

	public void setReportService(ReportService reportService) {
		this.reportService = reportService;
	}

	public Report getReport() {
		return report;
	}

	public void setReport(Report report) {
		this.report = report;
	}

	public String pager() {
		String roleId = WebUtil.getRoleId(req);
		String methodName = ReportAction.class.getName() + ".pager";
		boolean f = authorityRoleService.queryByRole(methodName, roleId);
		if (f == false) {
			result = ControllerResult.setFailResult("��Ǹ����û��Ȩ�޲���");
			return "pager";
		}
		Pager4EasyUI<Report> pager = new Pager4EasyUI<Report>();
		pager.setPageNo(WebUtil.getPageNo(req));
		pager.setPageSize(WebUtil.getPageSize(req));
		pager = reportService.queryByPager("Report", pager);
		List<Report> reports = new ArrayList<Report>();
		if (
				!WebUtil.getRole(req).equals("�ܾ���") && !WebUtil.getRole(req).equals("У��") &&!WebUtil.getRole(req).equals("��������") &&
				!WebUtil.getRole(req).equals("��������") && !WebUtil.getRole(req).equals("��������") &&!WebUtil.getRole(req).equals("��������")) {
			for (Report r : pager.getRows()) {
				if (WebUtil.getEmp(req).getEmpId().equals(r.getEmp().getEmpId())) {
					reports.add(r);
				}
			}
			pager.setRows(reports);
		}
		rows = pager.getRows();
		total =  pager.getRows().size();
		return "pager";
	}

	public String add() {
		String roleId = WebUtil.getRoleId(req);
		String methodName = ReportAction.class.getName() + ".add";
		boolean f = authorityRoleService.queryByRole(methodName, roleId);
		if (f == false) {
			result = ControllerResult.setFailResult("��Ǹ����û��Ȩ�޲���");
			return "add";
		}
		report.setStatus(1);
		reportService.save(report);
		result = ControllerResult.setSuccessResult("��ӳɹ�");
		return "add";
	}

	public String update() {
		String roleId = WebUtil.getRoleId(req);
		String methodName = ReportAction.class.getName() + ".update";
		boolean f = authorityRoleService.queryByRole(methodName, roleId);
		if (f == false) {
			result = ControllerResult.setFailResult("��Ǹ����û��Ȩ�޲���");
			return "update";
		}
		report.setStatus(1);
		reportService.update(report);
		result = ControllerResult.setSuccessResult("�޸ĳɹ�");
		return "update";
	}

	public String pagerByDay() {
		String roleId = WebUtil.getRoleId(req);
		String methodName = ReportAction.class.getName() + ".pagerByDay";
		boolean f = authorityRoleService.queryByRole(methodName, roleId);
		if (f == false) {
			result = ControllerResult.setFailResult("��Ǹ����û��Ȩ�޲���");
			return "pagerByDay";
		}
		Pager4EasyUI<Report> pager = new Pager4EasyUI<Report>();
		pager.setPageNo(WebUtil.getPageNo(req));
		pager.setPageSize(WebUtil.getPageSize(req));
		pager = reportService.queryByDay(pager, startDay, endDay, "Report", "reportday");
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
		String methodName = ReportAction.class.getName() + ".pagerByName";
		boolean f = authorityRoleService.queryByRole(methodName, roleId);
		if (f == false) {
			result = ControllerResult.setFailResult("��Ǹ����û��Ȩ�޲���");
			return "pagerByName";
		}
		Pager4EasyUI<Report> pager = new Pager4EasyUI<Report>();
		pager.setPageNo(WebUtil.getPageNo(req));
		pager.setPageSize(WebUtil.getPageSize(req));
		pager = reportService.queryByEmpName(pager, value, "Report");
		rows = pager.getRows();
		if (rows != null) {
			result = ControllerResult.setSuccessResult("���ҳɹ�");
		} else {
			result = ControllerResult.setFailResult("û�м�¼");
		}
		return "pagerByName";
	}

	public String frost() {
		String roleId = WebUtil.getRoleId(req);
		String methodName = ReportAction.class.getName() + ".frost";
		boolean f = authorityRoleService.queryByRole(methodName, roleId);
		if (f == false) {
			result = ControllerResult.setFailResult("��Ǹ����û��Ȩ�޲���");
			return "status";
		}
		Report report = reportService.queryById(Report.class, id);
		if (report.getStatus() == 1) {
			result = ControllerResult.setSuccessResult("����ɹ�");
			reportService.updateStatus("Report", "reportId", 0, id);
		} else {
			result = ControllerResult.setFailResult("�Ѿ��������ˣ������ٶ���");
		}
		return "status";
	}

	public String activation() {
		String roleId = WebUtil.getRoleId(req);
		String methodName = ReportAction.class.getName() + ".activation";
		boolean f = authorityRoleService.queryByRole(methodName, roleId);
		if (f == false) {
			result = ControllerResult.setFailResult("��Ǹ����û��Ȩ�޲���");
			return "status";
		}
		Report report = reportService.queryById(Report.class, id);
		if (report.getStatus() == 0) {
			result = ControllerResult.setSuccessResult("����ɹ�");
			reportService.updateStatus("Report", "reportId", 1, id);
		} else {
			result = ControllerResult.setFailResult("�Ѿ������ˣ������ټ���");
		}
		return "status";
	}

}
