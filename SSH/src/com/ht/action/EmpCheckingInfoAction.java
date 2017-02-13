package com.ht.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ht.bean.EmpCheckingInfo;
import com.ht.common.bean.ControllerResult;
import com.ht.common.bean.Pager4EasyUI;
import com.ht.common.web.WebUtil;
import com.ht.service.EmpCheckingInfoService;

public class EmpCheckingInfoAction extends BaseAction{

	private static final long serialVersionUID = -7729023950940034742L;

	private EmpCheckingInfoService empCheckingInfoService;
	private HttpServletRequest req;
	private EmpCheckingInfo empCheckingInfo;
	private List<EmpCheckingInfo> rows; // ���ظ�easyui�Ľ��
	private long total; // ���ظ�easyui����ҳ��
	private ControllerResult result;
	
	public void setEmpCheckingInfoService(EmpCheckingInfoService empCheckingInfoService) {
		this.empCheckingInfoService = empCheckingInfoService;
	}

	@Override
	public void setServletRequest(HttpServletRequest req) {
		this.req = req;
	}

	public EmpCheckingInfo getEmpCheckingInfo() {
		return empCheckingInfo;
	}

	public void setEmpCheckingInfo(EmpCheckingInfo empCheckingInfo) {
		this.empCheckingInfo = empCheckingInfo;
	}
	
	public List<EmpCheckingInfo> getRows() {
		return rows;
	}

	public ControllerResult getResult() {
		return result;
	}
	
	public long getTotal() {
		return total;
	}
	
	public String query() {
		System.out.println("����EmpCheckingInfoAction -- queryPage...");
		Pager4EasyUI<EmpCheckingInfo> pager = new Pager4EasyUI<EmpCheckingInfo>();
		pager.setPageNo(WebUtil.getPageNo(req));
		pager.setPageSize(WebUtil.getPageSize(req));
		pager = empCheckingInfoService.queryByPager("EmpCheckingInfo", pager);
		rows = pager.getRows();
		total = pager.getTotal();
		return "query";
	}
	
	public String add() {
		System.out.println("���� EmpCheckingInfoAction --  add����...");
		empCheckingInfoService.save(empCheckingInfo);
		result = ControllerResult.setSuccessResult("��ӳɹ�");
		return "add";
	}
	
	public String update() {
		System.out.println("����EmpCheckingInfoAction --  update����...");
		empCheckingInfoService.update(empCheckingInfo);
		result = ControllerResult.setSuccessResult("�޸ĳɹ�");
		return "update";
	}
	
}
