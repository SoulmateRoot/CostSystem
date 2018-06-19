/**
 * Project Name:costone
 * File Name:RoleMenuInfo.java
 * Package Name:com.bfw.bean
 * Date:2018年6月9日下午7:56:44
 * Copyright (c) 2018, soulmate.leilei@qq.com All Rights Reserved.
 * 创建人:Soulmate.leilei
*/

package com.bfw.bean;
/**
 * ClassName:RoleMenuInfo <br/>
 * Function: 角色菜单实体类 <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2018年6月9日 下午7:56:44 <br/>
 * @author   Soulmate.leilei
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public class RoleMenuInfo {
	//关系编号
	private Integer roleMenuId;
	//菜单编号
	private Integer menuId;
	//角色编号
	private Integer roleId;

	public Integer getRoleMenuId() {
		return roleMenuId;
	}

	public void setRoleMenuId(Integer roleMenuId) {
		this.roleMenuId = roleMenuId;
	}

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

}

