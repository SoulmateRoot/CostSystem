/**
 * Project Name:costone
 * File Name:AuditHistory.java
 * Package Name:com.bfw.bean
 * Date:2018年6月18日下午8:38:39
 * Copyright (c) 2018, soulmate.leilei@qq.com All Rights Reserved.
 * 创建人:Soulmate.leilei
*/

package com.bfw.bean;

import java.util.Date;

/**
 * ClassName:AuditHistory <br/>
 * Function: 审核的历史记录实体类 <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2018年6月18日 下午8:38:39 <br/>
 * @author   Soulmate.leilei
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public class AuditHistory {
	//审核编号
	private Integer auditId;
	//对应的报销单
	private Integer expenseId;
	//审核用户
	private Integer userId;
	//审核时间
	private Date auditTime;
	//审核状态
	private String auditState;
	//审核描述
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

