/**
 * Project Name:costone
 * File Name:SalaryPayment.java
 * Package Name:com.bfw.bean
 * Date:2018��6��27������3:43:27
 * Copyright (c) 2018, soulmate.leilei@qq.com All Rights Reserved.
 * ������:Soulmate.leilei
*/

package com.bfw.bean;

import java.util.Date;

import com.bfw.utils.BaseBean;

/**
 * ClassName:SalaryPayment <br/>
 * Function: н�ʷ���ʵ���� <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2018��6��27�� ����3:43:27 <br/>
 * @author   Soulmate.leilei
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public class SalaryPayment extends BaseBean{
	//н�ʱ��
	private Integer paymentId;
	//��ȡн�ʵ��û�
	private Integer userId;
	//����ʱ��
	private Date paymentTime;
	//���Ž��
	private double paymentMoney;
	
	private String userName;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Date getPaymentTime() {
		return paymentTime;
	}
	public void setPaymentTime(Date paymentTime) {
		this.paymentTime = paymentTime;
	}
	public double getPaymentMoney() {
		return paymentMoney;
	}
	public void setPaymentMoney(double paymentMoney) {
		this.paymentMoney = paymentMoney;
	}
	@Override
	public String toString() {
		return "SalaryPayment [paymentId=" + paymentId + ", userId=" + userId + ", paymentTime=" + paymentTime
				+ ", paymentMoney=" + paymentMoney + ", userName=" + userName + ", getUserName()=" + getUserName()
				+ ", getPaymentId()=" + getPaymentId() + ", getUserId()=" + getUserId() + ", getPaymentTime()="
				+ getPaymentTime() + ", getPaymentMoney()=" + getPaymentMoney() + ", getStart()=" + getStart()
				+ ", getLength()=" + getLength() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	

}

