package com.ht.bean;

import java.util.Set;

import org.apache.struts2.json.annotations.JSON;

/**
 * Ȩ�ޱ�
 * 
 * @author Administrator
 *
 */
public class Authority {

	private int authorityId; // Ȩ�޵�id
	private String name; // ������ȫ�޶���
	private String des; // ������
	
	private Set<AuthorityRole> authorityRoles; // ����Ȩ�޹�ϵ 

	public int getAuthorityId() {
		return authorityId;
	}

	public void setAuthorityId(int authorityId) {
		this.authorityId = authorityId;
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
	@JSON(serialize=false)
	public Set<AuthorityRole> getAuthorityRoles() {
		return authorityRoles;
	}

	public void setAuthorityRoles(Set<AuthorityRole> authorityRoles) {
		this.authorityRoles = authorityRoles;
	}

}
