/**
 * Project Name:costone
 * File Name:AuditHistory.java
 * Package Name:com.bfw.bean
 * Date:2018��6��18������8:38:39
 * Copyright (c) 2018, soulmate.leilei@qq.com All Rights Reserved.
 * ������:Soulmate.leilei
*/

package com.bfw.bean;

import java.util.Date;

/**
 * ClassName:AuditHistory <br/>
 * Function: ��˵���ʷ��¼ʵ���� <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2018��6��18�� ����8:38:39 <br/>
 * @author   Soulmate.leilei
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public class AuditHistory {
	//��˱��
	private Integer auditId;
	//��Ӧ�ı�����
	private Integer expenseId;
	//����û�
	private Integer userId;
	//���ʱ��
	private Date auditTime;
	//���״̬
	private String auditState;
	//�������
	private String auditDesc;
	public Integer getAuditId() {
		return auditId;
	}
	public void setAuditId(Integer auditId) {
		this.auditId = auditId;
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
	public Date getAuditTime() {
		return auditTime;
	}
	public void setAuditTime(Date auditTime) {
		this.auditTime = auditTime;
	}
	public String getAuditState() {
		return auditState;
	}
	public void setAuditState(String auditState) {
		this.auditState = auditState;
	}
	public String getAuditDesc() {
		return auditDesc;
	}
	public void setAuditDesc(String auditDesc) {
		this.auditDesc = auditDesc;
	}

}

