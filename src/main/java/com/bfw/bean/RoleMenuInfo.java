/**
 * Project Name:costone
 * File Name:RoleMenuInfo.java
 * Package Name:com.bfw.bean
 * Date:2018��6��9������7:56:44
 * Copyright (c) 2018, soulmate.leilei@qq.com All Rights Reserved.
 * ������:Soulmate.leilei
*/

package com.bfw.bean;
/**
 * ClassName:RoleMenuInfo <br/>
 * Function: ��ɫ�˵�ʵ���� <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2018��6��9�� ����7:56:44 <br/>
 * @author   Soulmate.leilei
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public class RoleMenuInfo {
	//��ϵ���
	private Integer roleMenuId;
	//�˵����
	private Integer menuId;
	//��ɫ���
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

