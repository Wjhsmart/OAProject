package com.ht.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.ht.bean.Emp;
import com.ht.bean.Summary;
import com.ht.common.bean.ControllerResult;
import com.ht.common.bean.Pager4EasyUI;
import com.ht.common.web.WebUtil;
import com.ht.service.AuthorityRoleService;
import com.ht.service.SummaryService;

public class SummaryAction extends BaseAction {

	private static final long serialVersionUID = -6854677902641212233L;
	
	private SummaryService summaryService;
	private AuthorityRoleService authorityRoleService;
	private Summary summary;
	private List<Summary> rows;
	private long total;
	private ControllerResult result;
	
	private String id;
	private String startDay; // ��ʼʱ��
	private String endDay; // ����ʱ��
	private String name; // �ж���ʲô����
	private String value; // ģ��������ֵ
	
	private HttpSession session;

	public List<Summary> getRows() {
		return rows;
	}

	public long getTotal() {
		return total;
	}

	public ControllerResult getResult() {
		return result;
	}

	public void setSummaryService(SummaryService summaryService) {
		this.summaryService = summaryService;
	}

	public void setAuthorityRoleService(AuthorityRoleService authorityRoleService) {
		this.authorityRoleService = authorityRoleService;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setStartDay(String startDay) {
		this.startDay = startDay;
	}

	public void setEndDay(String endDay) {
		this.endDay = endDay;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void setSummary(Summary summary) {
		this.summary = summary;
	}

	public Summary getSummary() {
		return summary;
	}

	public String pager() {
		String roleId = WebUtil.getRoleId(req);
		String methodName = SummaryAction.class.getName() + ".pager";
		if (authorityRoleService.queryByRole(methodName, roleId)) {
			setPager("pager");
		} else {
			result = ControllerResult.setFailResult("��Ǹ����û��Ȩ�޲���");
		}
		
		return "pager";
	}
	
	public String add() {
		String roleId = WebUtil.getRoleId(req);
		String methodName = SummaryAction.class.getName() + ".add";
		if (authorityRoleService.queryByRole(methodName, roleId)) {
			session = req.getSession();
			Emp e = (Emp) session.getAttribute("emp");
			Emp emp = new Emp();
			emp.setEmpId(e.getEmpId());
			summary.setEmp(emp);
			summary.setStatus(1);
			summaryService.save(summary);
			result = ControllerResult.setSuccessResult("��ӳɹ�");
		} else {
			result = ControllerResult.setFailResult("��Ǹ����û��Ȩ�޲���");
		}
		
		return "add";
	}
	
	public String edit() {
		String roleId = WebUtil.getRoleId(req);
		String methodName = SummaryAction.class.getName() + ".edit";
		if (authorityRoleService.queryByRole(methodName, roleId)) {
			summary.setStatus(1);
			summaryService.update(summary); // ����
			result = ControllerResult.setSuccessResult("�޸ĳɹ�");
		} else {
			result = ControllerResult.setFailResult("��Ǹ����û��Ȩ�޲���");
		}
		
		return "edit";
	}
	
	public String frost() {
		String roleId = WebUtil.getRoleId(req);
		String methodName = SummaryAction.class.getName() + ".frost";
		if (authorityRoleService.queryByRole(methodName, roleId)) {
			Summary summary = summaryService.queryById(Summary.class, id);
			if (summary.getStatus() == 1) {
				result = ControllerResult.setSuccessResult("����ɹ�");
				summaryService.updateStatus("Summary", "summaryId", 0, id);
			} else {
				result = ControllerResult.setFailResult("�Ѿ��������ˣ������ٶ���");
			}
		} else {
			result = ControllerResult.setFailResult("��Ǹ����û��Ȩ�޲���");
		}
		
		return "status";
	}
	
	public String activation() {
		String roleId = WebUtil.getRoleId(req);
		String methodName = SummaryAction.class.getName() + ".activation";
		if (authorityRoleService.queryByRole(methodName, roleId)) {
			Summary summary = summaryService.queryById(Summary.class, id);
			if (summary.getStatus() == 0) {
				result = ControllerResult.setSuccessResult("����ɹ�");
				summaryService.updateStatus("Summary", "summaryId", 1, id);
			} else {
				result = ControllerResult.setFailResult("�Ѿ������ˣ������ټ���");
			}
		} else {
			result = ControllerResult.setFailResult("��Ǹ����û��Ȩ�޲���");
		}
		
		return "status";
	}
	
	/**
	 * ��������ģ������
	 * @return
	 */
	public String pagerByName() {
		String roleId = WebUtil.getRoleId(req);
		String methodName = SummaryAction.class.getName() + ".pagerByName";
		if (authorityRoleService.queryByRole(methodName, roleId)) {
			setPager("pagerByName");
		} else {
			result = ControllerResult.setFailResult("��Ǹ����û��Ȩ�޲���");
		}
		return "pagerByName";
	}
	
	/**
	 * ����ʱ���ģ������
	 * @return
	 */
	public String pagerByDay() {
		String roleId = WebUtil.getRoleId(req);
		String methodName = SummaryAction.class.getName() + ".pagerByDay";
		if (authorityRoleService.queryByRole(methodName, roleId)) {
			setPager("pagerByDay");
		} else {
			result = ControllerResult.setFailResult("��Ǹ����û��Ȩ�޲���");
		}
		return "pagerByDay";
	}
	
	private void setPager(String method) {
		String stuId = WebUtil.getStuId(req);
		Pager4EasyUI<Summary> pager = new Pager4EasyUI<Summary>();
		pager.setPageNo(WebUtil.getPageNo(req));
		pager.setPageSize(WebUtil.getPageSize(req));
		if (method.equals("pager")) {
			pager = summaryService.queryByPager("Summary", pager);
			rows = pager.getRows();
		} else {
			if (method.equals("pagerByName")) {
				if (name.equals("stuName")) {
					pager = summaryService.queryByStuName(pager, value, "Summary");
				} else if (name.equals("empName")) {
					pager = summaryService.queryByEmpName(pager, value, "Summary");
				}
			} else if (method.equals("pagerByDay")) {
				pager = summaryService.queryByDay(pager, startDay, endDay, "Summary", "summaryDay");
			} else if (method.equals("pagerByStuId")) {
				pager = summaryService.queryByStuId(pager, stuId);
			} else if (method.equals("pagerByDay1")) {
				pager = summaryService.queryByDayAndStuId(pager, stuId, startDay, endDay);
			}
			rows = pager.getRows();
			if (rows != null && rows.size() > 0) {
				result = ControllerResult.setSuccessResult("���ҳɹ�");
			} else {
				result = ControllerResult.setFailResult("û�м�¼");
			}
		}
		total = pager.getTotal();
	}
	
	public String pagerByStuId() {
		setPager("pagerByStuId");
		return "pagerByStuId";
	}
	
	public String pagerByDay1() {
		setPager("pagerByDay1");
		return "pagerByDay1";
	}
	
	
}
