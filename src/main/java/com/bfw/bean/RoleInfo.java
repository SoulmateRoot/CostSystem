/**
 * Project Name:costone
 * File Name:RoleInfo.java
 * Package Name:com.bfw.bean
 * Date:2018��5��27������2:37:04
 * Copyright (c) 2018, soulmate.leilei@qq.com All Rights Reserved.
 * ������:Soulmate.leilei
*/

package com.bfw.bean;

import com.bfw.utils.BaseBean;

/**
 * ClassName:RoleInfo <br/>
 * Function: ��ɫ����ʵ���� <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2018��5��27�� ����2:37:04 <br/>
 * @author   Soulmate.leilei
 * @version  1.0
 * @since    JDK 1.8
 * @see 	 
 */
public class RoleInfo extends BaseBean{
	//��ɫ���
	private Integer roleId;
	//��ɫ����
	private String roleName;
	//��ɫ����
	private String roleDesc;
	//��ɫ��ʶ
	private String roleMark;

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	public String getRoleMark() {
		return roleMark;
	}

	public void setRoleMark(String roleMark) {
		this.roleMark = roleMark;
	}

}

