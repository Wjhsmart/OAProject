package com.ht.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ht.bean.EmpLeave;
import com.ht.common.bean.ControllerResult;
import com.ht.common.bean.Pager4EasyUI;
import com.ht.common.web.WebUtil;
import com.ht.service.AuthorityRoleService;
import com.ht.service.EmpLeaveService;

import freemarker.core.ParseException;

public class EmpLeaveAction extends BaseAction {

	private static final long serialVersionUID = -8811264984527474026L;

	private EmpLeaveService empLeaveService;
	private EmpLeave empLeave;
	private HttpServletRequest req;
	private List<EmpLeave> rows;
	private long total;
	private ControllerResult result;
	private String id;
	private String value;
	private String startDay;
	private String endDay;
	private AuthorityRoleService authorityRoleService;
	
	public void setAuthorityRoleService(AuthorityRoleService authorityRoleService) {
		this.authorityRoleService = authorityRoleService;
	}
	
	public void setStartDay(String startDay) {
		this.startDay = startDay;
	}

	public void setEndDay(String endDay) {
		this.endDay = endDay;
	}
	
	public void setValue(String value) {
		this.value = value;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public void setServletRequest(HttpServletRequest req) {
		this.req = req;
	}

	public void setEmpLeaveService(EmpLeaveService empLeaveService) {
		this.empLeaveService = empLeaveService;
	}

	public EmpLeave getEmpLeave() {
		return empLeave;
	}

	public void setEmpLeave(EmpLeave empLeave) {
		this.empLeave = empLeave;
	}

	public ControllerResult getResult() {
		return result;
	}

	public long getTotal() {
		return total;
	}

	public List<EmpLeave> getRows() {
		return rows;
	}

	public String pager() {
		String roleId = WebUtil.getRoleId(req);
		String methodName = EmpLeaveAction.class.getName() + ".pager";
		boolean f = authorityRoleService.queryByRole(methodName, roleId);
		if (f == false) {
			result = ControllerResult.setFailResult("��Ǹ����û��Ȩ�޲���");
			return "pager";
		}
		Pager4EasyUI<EmpLeave> pager = new Pager4EasyUI<EmpLeave>();
		pager.setPageNo(WebUtil.getPageNo(req));
		pager.setPageSize(WebUtil.getPageSize(req));
		pager = empLeaveService.queryByPager("EmpLeave", pager);
		rows = pager.getRows();
		total = pager.getRows().size();
		return "pager";
	}

	public String secondPager() throws ParseException, java.text.ParseException {
		String roleId = WebUtil.getRoleId(req);
		String methodName = EmpLeaveAction.class.getName() + ".secondPager";
		boolean f = authorityRoleService.queryByRole(methodName, roleId);
		if (f == false) {
			result = ControllerResult.setFailResult("��Ǹ����û��Ȩ�޲���");
			return "secondPager";
		}
		Pager4EasyUI<EmpLeave> pager = new Pager4EasyUI<EmpLeave>();
		pager.setPageNo(WebUtil.getPageNo(req));
		pager.setPageSize(WebUtil.getPageSize(req));
		pager = empLeaveService.queryByPager("EmpLeave", pager);
		List<EmpLeave> leaves = new ArrayList<EmpLeave>();
		for (EmpLeave el : pager.getRows()) {
			int a = daysBetween(el.getStartTime(), el.getEndTime());
			String roleStr = getRoleName(el);
			if ((a >= 3 && el.getFirstLevel() == 1) || roleStr.equals("У��") || roleStr.equals("��������") || roleStr.equals("��������") || roleStr.equals("��������") || roleStr.equals("��������")) {
				el.setLeaveCount(a);
				leaves.add(el);
			}
		}
		rows = leaves;
		total = rows.size();
		return "secondPager";
	}
	
	public String add() {
		String roleId = WebUtil.getRoleId(req);
		String methodName = EmpLeaveAction.class.getName() + ".add";
		boolean f = authorityRoleService.queryByRole(methodName, roleId);
		if (f == false) {
			result = ControllerResult.setFailResult("��Ǹ����û��Ȩ�޲���");
			return "add";
		}
		empLeave.setStatus(1);
		empLeave.setFirstLevel(2);
		empLeave.setSecondLevel(2);
		empLeave.setPass(2);
		empLeave.setLeaveDay(new Date());
		empLeaveService.save(empLeave);
		result = ControllerResult.setSuccessResult("����ɹ�");
		return "add";
	}

	public String update() throws ParseException, java.text.ParseException {
		String roleId = WebUtil.getRoleId(req);
		String methodName = EmpLeaveAction.class.getName() + ".update";
		boolean f = authorityRoleService.queryByRole(methodName, roleId);
		if (f == false) {
			result = ControllerResult.setFailResult("��Ǹ����û��Ȩ�޲���");
			return "update";
		}
		empLeave.setStatus(1);
		empLeave.setPass(2);
		empLeave.setLeaveDay(new Date());
		empLeaveService.update(empLeave);
		result = ControllerResult.setSuccessResult("�޸ĳɹ�");
		return "update";
	}

	public String byIdPager() throws ParseException, java.text.ParseException {
		String roleId = WebUtil.getRoleId(req);
		String methodName = EmpLeaveAction.class.getName() + ".byIdPager";
		boolean f = authorityRoleService.queryByRole(methodName, roleId);
		if (f == false) {
			result = ControllerResult.setFailResult("��Ǹ����û��Ȩ�޲���");
			return "byIdPager";
		}
		Pager4EasyUI<EmpLeave> pager = new Pager4EasyUI<EmpLeave>();
		pager.setPageNo(WebUtil.getPageNo(req));
		pager.setPageSize(WebUtil.getPageSize(req));
		System.out.println(req.getParameter("empId"));
		pager = empLeaveService.byIdPager(pager, req.getParameter("empId"));
		List<EmpLeave> leaves = new ArrayList<EmpLeave>();
		for (EmpLeave el : pager.getRows()) {
			el.setLeaveCount(daysBetween(el.getStartTime(), el.getEndTime()));
			leaves.add(el);
		}
		rows = leaves;
		total = rows.size();
		return "byIdPager";
	}
	
	public int daysBetween(Date smdate,Date bdate) throws ParseException, java.text.ParseException    
    {    
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd-HH");  
        smdate=sdf.parse(sdf.format(smdate));  
        bdate=sdf.parse(sdf.format(bdate));  
        Calendar cal = Calendar.getInstance();    
        cal.setTime(smdate);    
        long time1 = cal.getTimeInMillis();                 
        cal.setTime(bdate);    
        long time2 = cal.getTimeInMillis();         
        long between_days=(time2-time1)/(1000*3600*24);  
            
       return Integer.parseInt(String.valueOf(between_days));           
    }
	
	public String firstPager() throws ParseException, java.text.ParseException {
		String roleId = WebUtil.getRoleId(req);
		String methodName = EmpLeaveAction.class.getName() + ".firstPager";
		boolean f = authorityRoleService.queryByRole(methodName, roleId);
		if (f == false) {
			result = ControllerResult.setFailResult("��Ǹ����û��Ȩ�޲���");
			return "firstPager";
		}
		Pager4EasyUI<EmpLeave> pager = new Pager4EasyUI<EmpLeave>();
		pager.setPageNo(WebUtil.getPageNo(req));
		pager.setPageSize(WebUtil.getPageSize(req));
		pager = empLeaveService.byDepIdPager(pager, WebUtil.getEmp(req).getDept().getDepId());
		List<EmpLeave> leaves = new ArrayList<EmpLeave>();
		for (EmpLeave el : pager.getRows()) {
			if (!el.getEmp().getRole().getRoleId().equals(WebUtil.getEmp(req).getRole().getRoleId())) {
			el.setLeaveCount(daysBetween(el.getStartTime(), el.getEndTime()));
			leaves.add(el);
			}
		}
		rows = leaves;
		return "firstPager";
	}
	
	public String acceptFirst() {
		String roleId = WebUtil.getRoleId(req);
		String methodName = EmpLeaveAction.class.getName() + ".acceptFirst";
		boolean f = authorityRoleService.queryByRole(methodName, roleId);
		if (f == false) {
			result = ControllerResult.setFailResult("��Ǹ����û��Ȩ�޲���");
			return "firstLevel";
		}
		empLeaveService.updateSecondLevel("EmpLeave", "firstLevel", "leaveId", 1, id);
		if (Integer.valueOf(req.getParameter("leaveCount")) < 3) {
			updatePass(1, id);
		}
		result = ControllerResult.setSuccessResult("���ܳɹ�");
		return "firstLevel";
	}
	
	public String refuseFirst() {
		String roleId = WebUtil.getRoleId(req);
		String methodName = EmpLeaveAction.class.getName() + ".refuseFirst";
		boolean f = authorityRoleService.queryByRole(methodName, roleId);
		if (f == false) {
			result = ControllerResult.setFailResult("��Ǹ����û��Ȩ�޲���");
			return "firstLevel";
		}
		empLeaveService.updateSecondLevel("EmpLeave", "firstLevel", "leaveId", 0, id);
		updatePass(0, id);
		result = ControllerResult.setSuccessResult("�ؾ��ɹ�");
		return "firstLevel";
	}
	
	public String acceptSecond() {
		String roleId = WebUtil.getRoleId(req);
		String methodName = EmpLeaveAction.class.getName() + ".acceptSecond";
		boolean f = authorityRoleService.queryByRole(methodName, roleId);
		if (f == false) {
			result = ControllerResult.setFailResult("��Ǹ����û��Ȩ�޲���");
			return "secondLevel";
		}
		empLeaveService.updateSecondLevel("EmpLeave", "secondLevel", "leaveId", 1, id);
		result = ControllerResult.setSuccessResult("���ܳɹ�");
		updatePass(1, id);
		return "secondLevel";
	}
	
	public String refuseSecond() {
		String roleId = WebUtil.getRoleId(req);
		String methodName = EmpLeaveAction.class.getName() + ".refuseSecond";
		boolean f = authorityRoleService.queryByRole(methodName, roleId);
		if (f == false) {
			result = ControllerResult.setFailResult("��Ǹ����û��Ȩ�޲���");
			return "secondLevel";
		}
		empLeaveService.updateSecondLevel("EmpLeave", "secondLevel", "leaveId", 0, id);
		updatePass(0, id);
		result = ControllerResult.setSuccessResult("�ؾ��ɹ�");
		return "secondLevel";
	}
	
	public String activationStatus() {
		String roleId = WebUtil.getRoleId(req);
		String methodName = EmpLeaveAction.class.getName() + ".activationStatus";
		boolean f = authorityRoleService.queryByRole(methodName, roleId);
		if (f == false) {
			result = ControllerResult.setFailResult("��Ǹ����û��Ȩ�޲���");
			return "status";
		}
		if (value.equals("0")) {
			empLeaveService.updateSecondLevel("EmpLeave", "status", "leaveId", 1, id);
			result = ControllerResult.setSuccessResult("����ɹ�");
		} else {
			result = ControllerResult.setFailResult("�Ѿ������ˣ������ٶ���");
		}
		return "status";
	}
	
	public String freezeStatus() {
		String roleId = WebUtil.getRoleId(req);
		String methodName = EmpLeaveAction.class.getName() + ".freezeStatus";
		boolean f = authorityRoleService.queryByRole(methodName, roleId);
		if (f == false) {
			result = ControllerResult.setFailResult("��Ǹ����û��Ȩ�޲���");
			return "status";
		}
		if (value.equals("1")) {
			empLeaveService.updateSecondLevel("EmpLeave", "status", "leaveId", 0, id);
			result = ControllerResult.setSuccessResult("����ɹ�");
		} else {
			result = ControllerResult.setFailResult("�Ѿ������ˣ������ټ���");
		}
		return "status";
	}
	
	public void updatePass(int value, String id) {
		empLeaveService.updateSecondLevel("EmpLeave", "pass", "leaveId", value, id);
	}
	
	public String pagerByDay() throws ParseException, java.text.ParseException {
		String roleId = WebUtil.getRoleId(req);
		String methodName = EmpLeaveAction.class.getName() + ".pagerByDay";
		boolean f = authorityRoleService.queryByRole(methodName, roleId);
		if (f == false) {
			result = ControllerResult.setFailResult("��Ǹ����û��Ȩ�޲���");
			return "pagerByDay";
		}
		Pager4EasyUI<EmpLeave> pager = new Pager4EasyUI<EmpLeave>();
		pager.setPageNo(WebUtil.getPageNo(req));
		pager.setPageSize(WebUtil.getPageSize(req));
		pager.setRows(new ArrayList<EmpLeave>());
		pager = empLeaveService.queryByDay(pager, startDay, endDay, "EmpLeave", "startTime");
		if (pager.getRows().size() > 0) {
		List<EmpLeave> leaves = new ArrayList<EmpLeave>();
		for (EmpLeave el : pager.getRows()) {
			if (!WebUtil.getRole(req).equals("�ܾ���")) {
				if (WebUtil.getEmp(req).getDept().getDepId().equals(el.getEmp().getDept().getDepId())) {
					el.setLeaveCount(daysBetween(el.getStartTime(), el.getEndTime()));
					leaves.add(el);
				}
			} else {
				int a = daysBetween(el.getStartTime(), el.getEndTime());
				String roleStr = el.getEmp().getRole().getName();
				if ((a >= 3 && el.getFirstLevel() == 1) || roleStr.equals("У��") || roleStr.equals("��������") || roleStr.equals("��������") || roleStr.equals("��������") || roleStr.equals("��������")) {
					el.setLeaveCount(daysBetween(el.getStartTime(), el.getEndTime()));
					leaves.add(el);
				}
			}
		}
		if (leaves.size() < 1) {
			result = ControllerResult.setFailResult("û�м�¼");
		}
		pager.setRows(leaves);
		}
		rows = pager.getRows();
		if (rows.size() > 0) {
			result = ControllerResult.setSuccessResult("���ҳɹ�");
		} else {
			result = ControllerResult.setFailResult("û�м�¼");
		}
		return "pagerByDay";
	}
	
	public String pagerByName() throws ParseException, java.text.ParseException {
		String roleId = WebUtil.getRoleId(req);
		String methodName = EmpLeaveAction.class.getName() + ".pagerByName";
		boolean f = authorityRoleService.queryByRole(methodName, roleId);
		if (f == false) {
			result = ControllerResult.setFailResult("��Ǹ����û��Ȩ�޲���");
			return "pagerByName";
		}
		Pager4EasyUI<EmpLeave> pager = new Pager4EasyUI<EmpLeave>();
		pager.setPageNo(WebUtil.getPageNo(req));
		pager.setPageSize(WebUtil.getPageSize(req));
		pager.setRows( new ArrayList<EmpLeave>());
		pager = empLeaveService.queryByEmpName(pager, value, "EmpLeave");
		if (pager.getRows().size() > 0) {
			List<EmpLeave> leaves = new ArrayList<EmpLeave>();
				for (EmpLeave el : pager.getRows()) {
					if (!WebUtil.getRole(req).equals("�ܾ���")) {
						if (WebUtil.getEmp(req).getDept().getDepId().equals(el.getEmp().getDept().getDepId())) {
							el.setLeaveCount(daysBetween(el.getStartTime(), el.getEndTime()));
							leaves.add(el);
						}
					} else {
						int a = daysBetween(el.getStartTime(), el.getEndTime());
						String roleStr = el.getEmp().getRole().getName();
						if ((a >= 3 && el.getFirstLevel() == 1) || roleStr.equals("У��") || roleStr.equals("��������") || roleStr.equals("��������") || roleStr.equals("��������") || roleStr.equals("��������")) {
							el.setLeaveCount(daysBetween(el.getStartTime(), el.getEndTime()));
							leaves.add(el);
						}
					}
				}
			if (leaves.size() < 1) {
				result = ControllerResult.setFailResult("û�м�¼");
			}
			pager.setRows(leaves);
		}
		rows = pager.getRows();
		if (rows.size() > 0) {
			result = ControllerResult.setSuccessResult("���ҳɹ�");
		} else {
			result = ControllerResult.setFailResult("û�м�¼");
		}
		return "pagerByName";
	}
	
	public String getRoleName(EmpLeave el) {
		return el.getEmp().getRole().getName();
	}
}
