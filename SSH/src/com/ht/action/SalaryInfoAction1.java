package com.ht.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.ht.bean.Emp;
import com.ht.bean.Salary;
import com.ht.bean.info.SalaryInfo1;
import com.ht.common.Constants;
import com.ht.common.SalaryUtil;
import com.ht.common.bean.ControllerResult;
import com.ht.common.bean.Pager4EasyUI;
import com.ht.common.web.ExportExcel;
import com.ht.common.web.WebUtil;
import com.ht.service.AuthorityRoleService;
import com.ht.service.SalaryInfoService1;
import com.ht.service.SalaryService;

public class SalaryInfoAction1 extends BaseAction {

	private static final long serialVersionUID = -568585051781682343L;

	private SalaryInfo1 salaryInfo;
	private SalaryInfoService1 salaryInfoService1;
	private AuthorityRoleService authorityRoleService;
	private SalaryService salaryService;
	private List<SalaryInfo1> rows;
	private long total;
	private ControllerResult result;
	
	private String empName;
	private String startDay;
	private String endDay;
	
	private HttpSession session;
	
	private int number;
	private String fileName;
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public InputStream getInputStream() throws Exception {
		FileInputStream inputStream = null;
		if (number == 1) {
			fileName = "slary.xls";
			inputStream = new FileInputStream(new File(Constants.PATH_EXCEL + Constants.SALARY_NAME));
		}
		return inputStream;
	}

	public SalaryInfo1 getSalaryInfo() {
		return salaryInfo;
	}

	public void setSalaryInfo(SalaryInfo1 salaryInfo) {
		this.salaryInfo = salaryInfo;
	}

	public List<SalaryInfo1> getRows() {
		return rows;
	}

	public void setAuthorityRoleService(AuthorityRoleService authorityRoleService) {
		this.authorityRoleService = authorityRoleService;
	}

	public long getTotal() {
		return total;
	}

	public ControllerResult getResult() {
		return result;
	}

	public void setSalaryInfoService1(SalaryInfoService1 salaryInfoService1) {
		this.salaryInfoService1 = salaryInfoService1;
	}

	public void setSalaryService(SalaryService salaryService) {
		this.salaryService = salaryService;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public void setStartDay(String startDay) {
		this.startDay = startDay;
	}

	public void setEndDay(String endDay) {
		this.endDay = endDay;
	}

	public String pager() {
		String roleId = WebUtil.getRoleId(req);
		String methodName = SalaryInfoAction1.class.getName() + ".pager";
		if (authorityRoleService.queryByRole(methodName, roleId)) {
			setPager("pager");
		} else {
			result = ControllerResult.setFailResult("��Ǹ����û��Ȩ�޲���");
		}
		
		return "pager";
	}
	
	private void setSalary(String method) {
		String empId = salaryInfo.getEmpId();
		double basicSalary = salaryInfo.getBasicSalary();
		double jobSalary = salaryInfo.getJobSalary();
		double extraSalary = salaryInfo.getExtraSalary();
		double subSalary = salaryInfo.getSubSalary();
		
		Salary salary = new Salary();
		salary.setEmpId(empId);
		salary.setExtraSalary(extraSalary);
		salary.setSubSalary(subSalary);
		salary.setSalaryDay(salaryInfo.getSalaryDay());
		salary.setTotalSalary(SalaryUtil.totalSalary(basicSalary, jobSalary, extraSalary, subSalary));
		
		if (method.equals("add")) {
			salaryService.save(salary);
			result = ControllerResult.setSuccessResult("��ӳɹ�");
		} else if (method.equals("edit")) {
			salary.setSalaryId(salaryInfo.getSalaryId());
			salaryService.update(salary);
			result = ControllerResult.setSuccessResult("���³ɹ�");
		}
	}
	
	public String add() {
		String roleId = WebUtil.getRoleId(req);
		String methodName = SalaryInfoAction1.class.getName() + ".add";
		if (authorityRoleService.queryByRole(methodName, roleId)) {
			setSalary("add");
		} else {
			result = ControllerResult.setFailResult("��Ǹ����û��Ȩ�޲���");
		}
		
		return "add";
	}
	
	public String edit() {
		String roleId = WebUtil.getRoleId(req);
		String methodName = SalaryInfoAction1.class.getName() + ".edit";
		if (authorityRoleService.queryByRole(methodName, roleId)) {
			setSalary("edit");
		} else {
			result = ControllerResult.setFailResult("��Ǹ����û��Ȩ�޲���");
		}
		
		return "edit";
	}
	
	public String pagerByName() {
		String roleId = WebUtil.getRoleId(req);
		String methodName = SalaryInfoAction1.class.getName() + ".pagerByName";
		if (authorityRoleService.queryByRole(methodName, roleId)) {
			setPager("queryByName");
		} else {
			result = ControllerResult.setFailResult("��Ǹ����û��Ȩ�޲���");
		}
		
		return "pagerByName";
	}
	
	public String pagerByDay() {
		String roleId = WebUtil.getRoleId(req);
		String methodName = SalaryInfoAction1.class.getName() + ".pagerByDay";
		if (authorityRoleService.queryByRole(methodName, roleId)) {
			setPager("queryByDay");
		} else {
			result = ControllerResult.setFailResult("��Ǹ����û��Ȩ�޲���");
		}
		
		return "pagerByDay";
	}
	
	private void setPager(String method) {
		session = req.getSession();
		String role = WebUtil.getRole(req);
		Pager4EasyUI<SalaryInfo1> pager = new Pager4EasyUI<SalaryInfo1>();;
		pager.setPageNo(WebUtil.getPageNo(req));
		pager.setPageSize(WebUtil.getPageSize(req));
		if (method.equals("pager")) {
			if(role.equals("�ܾ���") || role.equals("��������")) {
				pager = salaryInfoService1.queryByPager(pager);
			} else {
				Emp emp = (Emp) session.getAttribute("emp");
				pager = salaryInfoService1.queryPageEmpId(pager, emp.getEmpId());
			}
		} else if (method.equals("queryByDay")) {
			if (role.equals("�ܾ���") || role.equals("��������")) {
				pager = salaryInfoService1.queryByDay(pager, startDay, endDay);
			} else {
				Emp emp = (Emp) session.getAttribute("emp");
				pager = salaryInfoService1.queryByDayAndEmpId(pager, startDay, startDay, emp.getEmpId());
			}
		} else if (method.equals("queryByName")) {
			pager = salaryInfoService1.queryByName(pager, empName);
		}
		total = pager.getTotal();
		rows = pager.getRows();
		if (rows != null && rows.size() > 0) {
			result = ControllerResult.setSuccessResult("���ҳɹ�");
		} else {
			result = ControllerResult.setFailResult("û�м�¼");
		}
		
	}
	
	public String exportData() throws Exception {
		session = req.getSession();
		String role = WebUtil.getRole(req);
		Pager4EasyUI<SalaryInfo1> pager = new Pager4EasyUI<SalaryInfo1>();;
		pager.setPageNo(WebUtil.getPageNo(req));
		pager.setPageSize(WebUtil.getPageSize(req));
		if(role.equals("�ܾ���") || role.equals("��������")) {
			pager = salaryInfoService1.queryByPager(pager);
		} else {
			Emp emp = (Emp) session.getAttribute("emp");
			pager = salaryInfoService1.queryPageEmpId(pager, emp.getEmpId());
		}
		rows = pager.getRows();
		if (rows != null && rows.size() > 0) {
			Map<String,String> titleMap = new LinkedHashMap<String,String>();
			titleMap.put("empName", "Ա������");
			titleMap.put("basicSalary", "��������");
			titleMap.put("jobSalary", "��λ����");
			titleMap.put("extraSalary", "��������");
			titleMap.put("subSalary", "�۷�����");
			titleMap.put("shouldSalary", "ʵ������");
			titleMap.put("totalSalary", "Ӧ������");
			titleMap.put("salaryDay", "����ʱ��");
			String sheetName = "Ա������";
			File file = new File(Constants.PATH_EXCEL);
			if (!file.exists()) {
				file.mkdir();
			}
			ExportExcel.excelExport(rows, titleMap, sheetName, "salary", Constants.PATH_EXCEL);
			// ExcelUtil.excleOut(pager.getRows(), Constants.PATH_EXCEL + Constants.SALARY_NAME);
			result = ControllerResult.setSuccessResult("�����ɹ�");
		} else {
			result = ControllerResult.setFailResult("����ʧ��");
		}
		return "exportData";
	}
	
}
