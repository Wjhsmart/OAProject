package com.ht.action;

import java.util.List;

import com.ht.bean.Stu;
import com.ht.bean.StuFeedback;
import com.ht.common.bean.ControllerResult;
import com.ht.common.bean.Pager4EasyUI;
import com.ht.common.web.WebUtil;
import com.ht.service.AuthorityRoleService;
import com.ht.service.StuFeedbackService;

/**
 * ѧ��������Action
 * @author Administrator
 *
 */
public class StuFeedbackAction extends BaseAction {

	private static final long serialVersionUID = 7549139032955507240L;
	
	private StuFeedbackService stuFeedbackService;
	private AuthorityRoleService authorityRoleService;
	private List<StuFeedback> rows;
	private long total;
	private ControllerResult result;
	
	private String id;
	private String stuName;
	private String startDay;
	private String endDay;
	private StuFeedback stuFeedback;

	public void setStuFeedbackService(StuFeedbackService stuFeedbackService) {
		this.stuFeedbackService = stuFeedbackService;
	}

	public void setAuthorityRoleService(AuthorityRoleService authorityRoleService) {
		this.authorityRoleService = authorityRoleService;
	}

	public List<StuFeedback> getRows() {
		return rows;
	}

	public long getTotal() {
		return total;
	}

	public ControllerResult getResult() {
		return result;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public void setStartDay(String startDay) {
		this.startDay = startDay;
	}

	public void setEndDay(String endDay) {
		this.endDay = endDay;
	}

	public StuFeedback getStuFeedback() {
		return stuFeedback;
	}

	public void setStuFeedback(StuFeedback stuFeedback) {
		this.stuFeedback = stuFeedback;
	}

	public String pager() {
		String roleId = WebUtil.getRoleId(req);
		String methodName = StuFeedbackAction.class.getName() + ".pager";
		if (authorityRoleService.queryByRole(methodName, roleId)) {
			setPager("pager");
		} else {
			result = ControllerResult.setFailResult("��Ǹ����û��Ȩ�޲���");
		}
		return "pager";
	}
	
	public String frost() {
		String roleId = WebUtil.getRoleId(req);
		String methodName = StuFeedbackAction.class.getName() + ".frost";
		if (authorityRoleService.queryByRole(methodName, roleId)) {
			StuFeedback stuFeedback = stuFeedbackService.queryById(StuFeedback.class, id);
			if (stuFeedback.getStatus() == 1) {
				result = ControllerResult.setSuccessResult("����ɹ�");
				stuFeedbackService.updateStatus("StuFeedback", "feedbackId", 0, id);
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
		String methodName = StuFeedbackAction.class.getName() + ".activation";
		if (authorityRoleService.queryByRole(methodName, roleId)) {
			StuFeedback stuFeedback = stuFeedbackService.queryById(StuFeedback.class, id);
			if (stuFeedback.getStatus() == 0) {
				result = ControllerResult.setSuccessResult("����ɹ�");
				stuFeedbackService.updateStatus("StuFeedback", "feedbackId", 1, id);
			} else {
				result = ControllerResult.setFailResult("�Ѿ������ˣ������ټ���");
			}
		} else {
			result = ControllerResult.setFailResult("��Ǹ����û��Ȩ�޲���");
		}
		
		return "status";
	}
	
	public String pagerByStuName() {
		String roleId = WebUtil.getRoleId(req);
		String methodName = StuFeedbackAction.class.getName() + ".pagerByStuName";
		if (authorityRoleService.queryByRole(methodName, roleId)) {
			setPager("pagerByStuName");
		} else {
			result = ControllerResult.setFailResult("��Ǹ����û��Ȩ�޲���");
		}
		return "pagerByStuName";
	}
	
	public String pagerByDay() {
		String roleId = WebUtil.getRoleId(req);
		String methodName = StuFeedbackAction.class.getName() + ".pagerByDay";
		if (authorityRoleService.queryByRole(methodName, roleId)) {
			setPager("pagerByDay");
		} else {
			result = ControllerResult.setFailResult("��Ǹ����û��Ȩ�޲���");
		}
		
		return "pagerByDay";
	}
	
	private void setPager(String method) {
		String stuId = WebUtil.getStuId(req);
		Pager4EasyUI<StuFeedback> pager = new Pager4EasyUI<StuFeedback>();
		pager.setPageNo(WebUtil.getPageNo(req));
		pager.setPageSize(WebUtil.getPageSize(req));
		if (method.equals("pager")) {
			pager = stuFeedbackService.queryByPager("StuFeedback", pager);
		} else {
			if (method.equals("pagerByStuName")) {
				pager = stuFeedbackService.queryByStuName(pager, stuName, "StuFeedback");
			} else if (method.equals("pagerByDay")) {
				pager = stuFeedbackService.queryByDay(pager, startDay, endDay, "StuFeedback", "feedbackDay");
			} else if (method.equals("pagerByStuId")) {
				pager = stuFeedbackService.queryByStuId(pager, stuId);
			} else if (method.equals("pagerByDay1")) {
				pager = stuFeedbackService.queryByDayAndStuId(pager, stuId, startDay, endDay);
			}
		}
		rows = pager.getRows();
		if (rows != null && rows.size() > 0) {
			result = ControllerResult.setSuccessResult("���ҳɹ�");
		} else {
			result = ControllerResult.setFailResult("û�м�¼");
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
	
	public String add() {
		Stu stu = new Stu();
		stu.setStuId(WebUtil.getStuId(req));
		stuFeedback.setStu(stu);
		stuFeedback.setStatus(1);
		stuFeedbackService.save(stuFeedback);
		result = ControllerResult.setSuccessResult("��ӷ����ɹ�");
		return "add";
	}
	
	public String edit() {
		Stu stu = new Stu();
		stu.setStuId(WebUtil.getStuId(req));
		stuFeedback.setStu(stu);
		stuFeedback.setStatus(1);
		stuFeedbackService.update(stuFeedback);
		result = ControllerResult.setSuccessResult("�޸ĳɹ�");
		return "edit";
	}

}
