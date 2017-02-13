package com.ht.bean;

import java.util.Set;

import org.apache.struts2.json.annotations.JSON;

/**
 * Ա����ɫ��
 * @author ������
 *
 */
public class Role {
	
	private String roleId; // ��ɫ���
	private String name; // ����
	private String des; // ����
	private int status; // ״̬��Ĭ��Ϊ����
	
	private Set<Emp>emps;//������Ա����
	private Set<AuthorityRole> authorityRoles; // ����Ȩ�޹�����
	
	@JSON(serialize=false)
	public Set<Emp> getEmps() {
		return emps;
	}
	public void setEmps(Set<Emp> emps) {
		this.emps = emps;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@JSON(serialize=false)
	public Set<AuthorityRole> getAuthorityRoles() {
		return authorityRoles;
	}
	public void setAuthorityRoles(Set<AuthorityRole> authorityRoles) {
		this.authorityRoles = authorityRoles;
	}
	
	
}
