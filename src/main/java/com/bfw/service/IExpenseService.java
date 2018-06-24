/**
 * Project Name:costone
 * File Name:IExpenseService.java
 * Package Name:com.bfw.service
 * Date:2018年6月15日下午10:02:07
 * Copyright (c) 2018, soulmate.leilei@qq.com All Rights Reserved.
 * 创建人:Soulmate.leilei
*/

package com.bfw.service;


import java.util.List;
import java.util.Map;

import com.bfw.bean.AuditHistory;
import com.bfw.bean.ExpenseAccount;
import com.bfw.bean.ExpenseDetails;

/**
 * ClassName:IExpenseService <br/>
 * Function: 报销管理业务逻辑接口 <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2018年6月15日 下午10:02:07 <br/>
 * @author   Soulmate.leilei
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public interface IExpenseService {
	
	/**
	 * @Title: add  
	 * @Description: 添加报销单 
	 * @param ea 报销单
	 * @param costId 报销的费用
	 * @param expenseDetailsSmount 报销的金额   
	 * @return void    
	 * @throws
	 */
	public void add(ExpenseAccount ea, Integer[] costId, Double[] expenseDetailsSmount);
	/**
	 * @Title: list  
	 * @Description:根据条件查询报销单信息
	 * @param ea 查询条件 
	 * @return 返回未审核的报销单
	 * @return List<ExpenseAccount>    
	 * @throws
	 */
	public List<ExpenseAccount> list(ExpenseAccount ea);
	/**
	 * @Title: getcount  
	 * @Description:查询总记录数 
	 * @param ea
	 * @return      
	 * @return long    
	 * @throws
	 */
	public long getcount(ExpenseAccount ea);
	
	/**
	 * @Title: getExpenseAccount  
	 * @Description: 根据编号查询报销单  
	 * @param ea 查询条件
	 * @return 返回单个报销单信息     
	 * @return ExpenseAccount    
	 * @throws
	 */
	public ExpenseAccount getExpenseAccount(ExpenseAccount ea);
	/**
	 * @Title: getExpenseDetailsList  
	 * @Description:  
	 * @param ed 根据编号查询报销单详细
	 * @return  返回报销的明细
	 * @return ExpenseDetails    
	 * @throws
	 */
	public List<Map> getExpenseDetailsList(ExpenseAccount ea);
	/**
	 * @Title: auditManager  
	 * @Description: 经理审核 添加历史记录 
	 * @param ah      
	 * @return void    
	 * @throws
	 */
	public void auditManager(AuditHistory ah);
	/**
	 * @Title: getAuditHistoryList  
	 * @Description: 查询审核历史记录 
	 * @param ea
	 * @return 返回     
	 * @return List<Map>    
	 * @throws
	 */
	public List<Map> getAuditHistoryList(ExpenseAccount ea);
	
	/**
	 * @Title: getLit  
	 * @Description: 根据审核人进行查询报销单 
	 * @param ea
	 * @return      
	 * @return List<ExpenseAccount>    
	 * @throws
	 */
	public List<ExpenseAccount>  getLit(ExpenseAccount ea);
}

