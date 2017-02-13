package com.ht.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ht.bean.Role;
import com.ht.bean.Stu;
import com.ht.common.bean.ControllerResult;
import com.ht.common.bean.Pager4EasyUI;
import com.ht.common.web.WebUtil;
import com.ht.service.AuthorityRoleService;
import com.ht.service.EmpService;
import com.ht.service.RoleService;

public class RoleAction extends BaseAction {

	private static final long serialVersionUID = 2658462578469970784L;

	private RoleService roleService;
	private HttpServletRequest req;
	private Role role;
	private List<Role> rows; // ���ظ�easyui�Ľ��
	private long total; // ���ظ�easyui����ҳ��
	private ControllerResult result;
	private String id;
	private String name;
	private String value;
	private AuthorityRoleService authorityRoleService;

	public void setAuthorityRoleService(AuthorityRoleService authorityRoleService) {
		this.authorityRoleService = authorityRoleService;
	}
	
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	public void setEmpId(String empId) {
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	@Override
	public void setServletRequest(HttpServletRequest req) {
		this.req = req;
	}

	public List<Role> getRows() {
		return rows;
	}

	public ControllerResult getResult() {
		return result;
	}

	public long getTotal() {
		return total;
	}

	public void setEmpService(EmpService empService) {
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String query() {
		String roleId = WebUtil.getRoleId(req);
		String methodName = RoleAction.class.getName() + ".query";
		boolean f = authorityRoleService.queryByRole(methodName, roleId);
		if (f == false) {
			result = ControllerResult.setFailResult("��Ǹ����û��Ȩ�޲���");
			return "query";
		}
		System.out.println("����Role--queryPage...");
		Pager4EasyUI<Role> pager = new Pager4EasyUI<Role>();
		pager.setPageNo(WebUtil.getPageNo(req));
		pager.setPageSize(WebUtil.getPageSize(req));
		pager = roleService.queryByPager("Role", pager);
		rows = pager.getRows();
		total = pager.getTotal();
		System.out.println(pager.getRows());
		return "query";
	}

	public String add() {
		String roleId = WebUtil.getRoleId(req);
		String methodName = RoleAction.class.getName() + ".add";
		boolean f = authorityRoleService.queryByRole(methodName, roleId);
		if (f == false) {
			result = ControllerResult.setFailResult("��Ǹ����û��Ȩ�޲���");
			return "add";
		}
		role.setStatus(1);
		System.out.println("����add����..." + role.getName() + role.getDes());
		roleService.save(role);
		result = ControllerResult.setSuccessResult("��ӳɹ�");
		return "add";
	}

	public String update() {
		String roleId = WebUtil.getRoleId(req);
		String methodName = RoleAction.class.getName() + ".update";
		boolean f = authorityRoleService.queryByRole(methodName, roleId);
		if (f == false) {
			result = ControllerResult.setFailResult("��Ǹ����û��Ȩ�޲���");
			return "update";
		}
		System.out.println("����update����...");
		roleService.update(role);
		result = ControllerResult.setSuccessResult("�޸ĳɹ�");
		return "update";
	}

	public String frost() {
		String roleId = WebUtil.getRoleId(req);
		String methodName = RoleAction.class.getName() + ".frost";
		boolean f = authorityRoleService.queryByRole(methodName, roleId);
		if (f == false) {
			result = ControllerResult.setFailResult("��Ǹ����û��Ȩ�޲���");
			return "status";
		}
		Role role = roleService.queryById(Role.class, id);
		if (role.getStatus() == 1) {
			result = ControllerResult.setSuccessResult("����ɹ�");
			roleService.updateStatus("Role", "roleid", 0, id);
		} else {
			result = ControllerResult.setFailResult("�Ѿ��������ˣ������ٶ���");
		}
		return "status";
	}

	public String activation() {
		String roleId = WebUtil.getRoleId(req);
		String methodName = RoleAction.class.getName() + ".activation";
		boolean f = authorityRoleService.queryByRole(methodName, roleId);
		if (f == false) {
			result = ControllerResult.setFailResult("��Ǹ����û��Ȩ�޲���");
			return "status";
		}
		Role role = roleService.queryById(Role.class, id);
		if (role.getStatus() == 0) {
			result = ControllerResult.setSuccessResult("����ɹ�");
			roleService.updateStatus("Role", "roleid", 1, id);
		} else {
			result = ControllerResult.setFailResult("�Ѿ������ˣ������ټ���");
		}
		return "status";
	}
	
	public String queryRoleIdByName() {
		String roleId = WebUtil.getRoleId(req);
		String methodName = RoleAction.class.getName() + ".queryRoleIdByName";
		boolean f = authorityRoleService.queryByRole(methodName, roleId);
		if (f == false) {
			result = ControllerResult.setFailResult("��Ǹ����û��Ȩ�޲���");
			return "queryRoleIdByName";
		}
		String id = roleService.queryRoleIdByName("������");
		System.out.println(id);
		return "queryRoleIdByName";
	}
	
	public String fuzzySearch() {
		String roleId = WebUtil.getRoleId(req);
		String methodName = RoleAction.class.getName() + ".fuzzySearch";
		boolean f = authorityRoleService.queryByRole(methodName, roleId);
		if (f == false) {
			result = ControllerResult.setFailResult("��Ǹ����û��Ȩ�޲���");
			return "fuzzySearch";
		}
		System.out.println("����queryBynoticeTypeName������");
		Pager4EasyUI<Role> pager = new Pager4EasyUI<Role>();
		pager.setPageNo(WebUtil.getPageNo(req));
		pager.setPageSize(WebUtil.getPageSize(req));
		if (name.equals("roleName")) {
			pager = roleService.queryByroleName(pager, value);
		}
		rows = pager.getRows();
		total = pager.getTotal();
		if (rows != null) {
			result = ControllerResult.setSuccessResult("���ҳɹ�");
		} else {
			result = ControllerResult.setFailResult("û�м�¼");
		}
		return "fuzzySearch";
	}
	
	public String queryRoleIdByName1(){
		Pager4EasyUI<Stu> pager = new Pager4EasyUI<Stu>();
		pager.setPageNo(WebUtil.getPageNo(req));
		pager.setPageSize(WebUtil.getPageSize(req));
		
		return "queryRoleIdByName1";
	}
	
}
