/**
 * Project Name:costone
 * File Name:ExpenseAccount.java
 * Package Name:com.bfw.bean
 * Date:2018��6��15������2:28:58
 * Copyright (c) 2018, soulmate.leilei@qq.com All Rights Reserved.
 * ������:Soulmate.leilei
*/

package com.bfw.bean;

import java.util.Date;

import com.bfw.utils.BaseBean;



/**
 * ClassName:ExpenseAccount <br/>
 * Function:��������ʵ����. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2018��6��15�� ����2:28:58 <br/>
 * @author   Soulmate.leilei
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public class ExpenseAccount extends BaseBean{
	//�������
	private Integer expenseId;
	//������
	private Integer userId;
	//����������
	private String userName;
	//����ԭ��
	private String expenseName;
	//��������
	private String expenseDesc;
	//����״̬
	private String expenseState;
	//�����ܽ��
	private Double expenseTotal;
	//����ʱ��
	private Date expenseTime;

	//����set  get  ����
	public Date getExpenseTime() {
		return expenseTime;
	}
	public void setExpenseTime(Date expenseTime) {
		this.expenseTime = expenseTime;
	}
	public Integer getExpenseId() {
		return expenseId;
	}
	public void setExpenseId(Integer expenseId) {
		this.expenseId = expenseId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getExpenseName() {
		return expenseName;
	}
	public void setExpenseName(String expenseName) {
		this.expenseName = expenseName;
	}
	public String getExpenseDesc() {
		return expenseDesc;
	}
	public void setExpenseDesc(String expenseDesc) {
		this.expenseDesc = expenseDesc;
	}
	public String getExpenseState() {
		return expenseState;
	}
	public void setExpenseState(String expenseState) {
		this.expenseState = expenseState;
	}
	public Double getExpenseTotal() {
		return expenseTotal;
	}
	public void setExpenseTotal(Double expenseTotal) {
		this.expenseTotal = expenseTotal;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Override
	public String toString() {
		return "ExpenseAccount [expenseId=" + expenseId + ", userId=" + userId + ", expenseName=" + expenseName
				+ ", expenseDesc=" + expenseDesc + ", expenseState=" + expenseState + ", expenseTotal=" + expenseTotal
				+ "]";
	}
	

}

