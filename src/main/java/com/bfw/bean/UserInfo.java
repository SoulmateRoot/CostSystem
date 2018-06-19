/**
 * Project Name:costone
 * File Name:UserInfo.java
 * Package Name:com.bfw.bean
 * Date:2018年5月31日下午1:30:40
 * Copyright (c) 2018, soulmate.leilei@qq.com All Rights Reserved.
 * 创建人:Soulmate.leilei
*/

package com.bfw.bean;

import com.bfw.utils.BaseBean;

/**
 * ClassName:UserInfo <br/>
 * Function: 用户信息实体类 <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2018年5月31日 下午1:30:40 <br/>
 * @author   Soulmate.leilei
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public class UserInfo extends BaseBean {
	//用户编号
	private Integer userId;
	//角色编号
	private Integer roleId;
	//用户姓名
	private String userName;
	//用户性别
	private String userSex;
	//用户年龄
	private int userAge;
	//用户账户
	private String userAccount;
	//用户 密码
	private String userPassword;
	//用户薪资
	private Double userSalary;
	//用户标识
	private String userMark;
	//角色名称
	private String roleName;
	
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserSex() {
		return userSex;
	}
	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}
	public int getUserAge() {
		return userAge;
	}
	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public Double getUserSalary() {
		return userSalary;
	}
	public void setUserSalary(Double userSalary) {
		this.userSalary = userSalary;
	}
	public String getUserMark() {
		return userMark;
	}
	public void setUserMark(String userMark) {
		this.userMark = userMark;
	}
	
	
	

}

