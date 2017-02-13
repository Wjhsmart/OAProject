package com.ht.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.json.annotations.JSON;

import com.ht.bean.Emp;
import com.ht.bean.Notice;
import com.ht.bean.NoticeType;
import com.ht.common.bean.ControllerResult;
import com.ht.common.bean.Pager4EasyUI;
import com.ht.common.web.WebUtil;
import com.ht.service.AuthorityRoleService;
import com.ht.service.NoticeService;

public class NoticeAction extends BaseAction {

	private static final long serialVersionUID = 3707616821973126188L;

	private NoticeService noticeService;
	private AuthorityRoleService authorityRoleService;
	private HttpServletRequest req;
	private Notice notice;
	private List<Notice> rows; // ���ظ�easyui�Ľ��
	private long total; // ���ظ�easyui����ҳ��
	private ControllerResult result;
	private String id;
	private String startDay;
	private String endDay;

	public void setId(String id) {
		this.id = id;
	}
	public void setAuthorityRoleService(AuthorityRoleService authorityRoleService) {
		this.authorityRoleService = authorityRoleService;
	}

	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}

	@Override
	public void setServletRequest(HttpServletRequest req) {
		this.req = req;
	}

	@JSON(serialize = false)
	public Notice getNotice() {
		return notice;
	}

	public void setNotice(Notice notice) {
		this.notice = notice;
	}

	public List<Notice> getRows() {
		return rows;
	}

	public ControllerResult getResult() {
		return result;
	}

	public long getTotal() {
		return total;
	}

	public void setStartDay(String startDay) {
		this.startDay = startDay;
	}

	public void setEndDay(String endDay) {
		this.endDay = endDay;
	}

	public String query() {
		String roleId = WebUtil.getRoleId(req);
		String methodName = NoticeAction.class.getName() + ".query";
		if (authorityRoleService.queryByRole(methodName, roleId)) {
			Pager4EasyUI<Notice> pager = new Pager4EasyUI<Notice>();
			pager.setPageNo(WebUtil.getPageNo(req));
			pager.setPageSize(WebUtil.getPageSize(req));
			pager = noticeService.queryByPager("Notice", pager);
			rows = pager.getRows();
			total = pager.getTotal();
			result = ControllerResult.setSuccessResult("��ѯ�ɹ�");
		} else {
			result = ControllerResult.setFailResult("��Ǹ����û��Ȩ�޲���");
		}
		return "query";
	}

	public String add() {
		String roleId = WebUtil.getRoleId(req);
		String methodName = NoticeAction.class.getName() + ".add";
		if (authorityRoleService.queryByRole(methodName, roleId)) {
			NoticeType noticeType = new NoticeType();
			noticeType.setNoticeTypeId(req.getParameter("notice.typeId"));
			Emp emp = WebUtil.getEmp(req);
			Emp e = new Emp();
			e.setEmpId(emp.getEmpId());
			notice.setEmp(e);
			notice.setNoticetype(noticeType);
			notice.setStatus(1);
			System.out.println("����add����");
			noticeService.save(notice);
			result = ControllerResult.setSuccessResult("��ӳɹ�");
		} else {
			result = ControllerResult.setFailResult("��Ǹ����û��Ȩ�޲���");
		}
		return "add";
	}

	public String update() {
		String roleId = WebUtil.getRoleId(req);
		String methodName = NoticeAction.class.getName() + ".update";
		if (authorityRoleService.queryByRole(methodName, roleId)) {
				NoticeType noticeType = new NoticeType();
				noticeType.setNoticeTypeId(req.getParameter("notice.typeId"));
				notice.setNoticetype(noticeType);
				noticeService.update(notice);
				result = ControllerResult.setSuccessResult("�޸ĳɹ�");
			
		} else {
			result = ControllerResult.setFailResult("��Ǹ����û��Ȩ�޲���");
		}
		return "update";
	}

	public String pagerByDay(){
		String roleId = WebUtil.getRoleId(req);
		String methodName = NoticeAction.class.getName() + ".pagerByDay";
		if (authorityRoleService.queryByRole(methodName, roleId)) {
			System.out.println("����pagerByDay����--����ʱ��ȥ��ѯ...");
			Pager4EasyUI<Notice> pager = new Pager4EasyUI<Notice>();
			pager.setPageNo(WebUtil.getPageNo(req));
			pager.setPageSize(WebUtil.getPageSize(req));
			pager = noticeService.queryByDay(pager, startDay, endDay, "Notice", "noticeDay");
			rows = pager.getRows();
			if (rows != null) {
				result = ControllerResult.setSuccessResult("���ҳɹ�");
			} else {
				result = ControllerResult.setFailResult("û�м�¼");
			}
		} else {
			result = ControllerResult.setFailResult("��Ǹ����û��Ȩ�޲���");
		}
		return "pagerByDay";
	}
	
	public String frost() {
		String roleId = WebUtil.getRoleId(req);
		String methodName = NoticeAction.class.getName() + ".frost";
		if (authorityRoleService.queryByRole(methodName, roleId)) {
			Notice notice = noticeService.queryById(Notice.class, id);
			if (notice.getStatus() == 1) {
				result = ControllerResult.setSuccessResult("����ɹ�");
				noticeService.updateStatus("Notice", "noticeid", 0, id);
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
		String methodName = NoticeAction.class.getName() + ".activation";
		if (authorityRoleService.queryByRole(methodName, roleId)) {
			Notice notice = noticeService.queryById(Notice.class, id);
			if (notice.getStatus() == 0) {
				result = ControllerResult.setSuccessResult("����ɹ�");
				noticeService.updateStatus("Notice", "noticeid", 1, id);
			} else {
				result = ControllerResult.setFailResult("�Ѿ������ˣ������ټ���");
			}
		} else {
			result = ControllerResult.setFailResult("��Ǹ����û��Ȩ�޲���");
		}
		return "status";
	}
}
