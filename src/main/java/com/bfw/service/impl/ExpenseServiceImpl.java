/**
 * Project Name:costone
 * File Name:ExpenseServiceImpl.java
 * Package Name:com.bfw.service.impl
 * Date:2018年6月15日下午10:07:12
 * Copyright (c) 2018, soulmate.leilei@qq.com All Rights Reserved.
 * 创建人:Soulmate.leilei
*/

package com.bfw.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bfw.bean.AuditHistory;
import com.bfw.bean.ExpenseAccount;
import com.bfw.bean.ExpenseDetails;
import com.bfw.dao.IExpenseDAO;
import com.bfw.service.IExpenseService;
import com.bfw.utils.Comm;

/**
 * ClassName:ExpenseServiceImpl <br/>
 * Function: 报销管理业务逻辑实现类. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2018年6月15日 下午10:07:12 <br/>
 * @author   Soulmate.leilei
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
@Service
@Transactional
public class ExpenseServiceImpl implements IExpenseService {
	
	//依赖注入
	@Autowired
	private IExpenseDAO expdao;
	/**
	 * 
	 * TODO 报销单添加方法.
	 * @see com.bfw.service.IExpenseService#add(com.bfw.bean.ExpenseAccount, java.lang.Integer[], java.lang.Double[])
	 */
	public void add(ExpenseAccount ea, Integer[] costId, Double[] expenseDetailsSmount) {
		//添加报销单
		expdao.addExpense(ea);
		for(int i=0;i<costId.length;i++){
			ExpenseDetails ed=new ExpenseDetails();
			System.out.println(ed);
			//获取报销编号
			//ed.setExpenseId(ea.getExpenseId());
			ed.setExpenseId(ea.getExpenseId());
			ed.setCostId(costId[i]);
			ed.setExpenseDetailsAmount(expenseDetailsSmount[i]);
			expdao.addExpenseDetails(ed);
		}
	}
	/**
	 * 
	 * TODO 业务逻辑 查询报销列表.
	 * @see com.bfw.service.IExpenseService#list(com.bfw.bean.ExpenseAccount)
	 */
	public List<ExpenseAccount> list(ExpenseAccount ea) {
		condition(ea);
		return expdao.list(ea);
	}
	/**
	 * 
	 * TODO 业务逻辑 查询总页数.
	 * @see com.bfw.service.IExpenseService#getcount(com.bfw.bean.ExpenseAccount)
	 */
	public long getcount(ExpenseAccount ea) {
		condition(ea);
		return expdao.getcount(ea);
	}
	
	/**
	 * @Title: condition  
	 * @Description: 查询条件 
	 * @param ea      
	 * @return void    
	 * @throws
	 */
	public void condition(ExpenseAccount ea){
		if (ea != null) {
			if (ea.getUserName() != null && !ea.getUserName().equals("")) {
				ea.setUserName("%" + ea.getUserName() + "%");
			}
		}
	}
	/**
	 * 
	 * TODO 根据编号查询报销单.
	 * @see com.bfw.service.IExpenseService#getExpenseAccount(com.bfw.bean.ExpenseAccount)
	 */
	public ExpenseAccount getExpenseAccount(ExpenseAccount ea) {
		
		return expdao.getExpenseAccount(ea);
	}
	/**
	 * 
	 * TODO 根据编号查询报销单明细.
	 * @see com.bfw.service.IExpenseService#getExpenseDetailsList(com.bfw.bean.ExpenseDetails)
	 */
	public List<Map> getExpenseDetailsList(ExpenseAccount ea) {
		
		return expdao.getExpenseDetailsList(ea);
	}
	/**
	 * 
	 * TODO 经理审核  添加历史记录.
	 * @see com.bfw.service.IExpenseService#auditManager(com.bfw.bean.AuditHistory)
	 */
	public void auditManager(AuditHistory ah) {
		ExpenseAccount ea = new ExpenseAccount();
		ea.setExpenseId(ah.getExpenseId());
		
		//审核不通过
		if (Comm.EXPENSE_STATE_REONE.equals(ah.getAuditState())) {
			ea.setExpenseState(Comm.EXPENSE_STATE_ZERO);
			// 作废
		} else if (Comm.EXPENSE_STATE_DELETE.equals(ah.getAuditState())) {
			ea.setExpenseState(Comm.EXPENSE_STATE_DELETE);
		} else {
			// 审核通过
			ea.setExpenseState(ah.getAuditState());
		}
		//添加审核记录
		expdao.addAuditHistory(ah);
		// 修改报销单
		expdao.updateExpenseAccount(ea);
	}
	/**
	 * 
	 * TODO 财务审核，根据报销单编号查询审核历史记录
	 * @see com.bfw.service.IExpenseService#getAuditHistoryList(com.bfw.bean.ExpenseAccount)
	 */
	public List<Map> getAuditHistoryList(ExpenseAccount ea) {
		
		return expdao.getAuditHistoryList(ea);
	}
	/**
	 * 
	 * TODO 我的审核  根据审核人进行查询报销单.
	 * @see com.bfw.service.IExpenseService#getLit(com.bfw.bean.ExpenseAccount)
	 */
	public List<ExpenseAccount> getLit(ExpenseAccount ea) {
		return expdao.getLit(ea);
	}


	
	
	
}
