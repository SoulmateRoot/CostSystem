/**
 * Project Name:costone
 * File Name:UserInfo.java
 * Package Name:com.bfw.bean
 * Date:2018��5��31������1:30:40
 * Copyright (c) 2018, soulmate.leilei@qq.com All Rights Reserved.
 * ������:Soulmate.leilei
*/

package com.bfw.bean;

import com.bfw.utils.BaseBean;

/**
 * ClassName:UserInfo <br/>
 * Function: �û���Ϣʵ���� <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2018��5��31�� ����1:30:40 <br/>
 * @author   Soulmate.leilei
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public class UserInfo extends BaseBean {
	//�û����
	private Integer userId;
	//��ɫ���
	private Integer roleId;
	//�û�����
	private String userName;
	//�û��Ա�
	private String userSex;
	//�û�����
	private int userAge;
	//�û��˻�
	private String userAccount;
	//�û� ����
	private String userPassword;
	//�û�н��
	private Double userSalary;
	//�û���ʶ
	private String userMark;
	//��ɫ����
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

