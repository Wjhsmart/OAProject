package com.ht.bean;

/**
 * Ȩ�޺ͽ�ɫ�Ĺ�����ϵ��
 * @author Administrator
 *
 */
public class AuthorityRole {

	private int authorityRoleId; // ������ϵ��id
	
	private Authority authority; // Ȩ��
	private Role role; // ��ɫ

	public int getAuthorityRoleId() {
		return authorityRoleId;
	}

	public void setAuthorityRoleId(int authorityRoleId) {
		this.authorityRoleId = authorityRoleId;
	}

	public Authority getAuthority() {
		return authority;
	}

	public void setAuthority(Authority authority) {
		this.authority = authority;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}


}
