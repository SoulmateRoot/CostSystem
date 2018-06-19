/**
 * Project Name:costone
 * File Name:RoleInfo.java
 * Package Name:com.bfw.bean
 * Date:2018年5月27日下午2:37:04
 * Copyright (c) 2018, soulmate.leilei@qq.com All Rights Reserved.
 * 创建人:Soulmate.leilei
*/

package com.bfw.bean;

import com.bfw.utils.BaseBean;

/**
 * ClassName:RoleInfo <br/>
 * Function: 角色管理实体类 <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2018年5月27日 下午2:37:04 <br/>
 * @author   Soulmate.leilei
 * @version  1.0
 * @since    JDK 1.8
 * @see 	 
 */
public class RoleInfo extends BaseBean{
	//角色编号
	private Integer roleId;
	//角色名称
	private String roleName;
	//角色描述
	private String roleDesc;
	//角色标识
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

