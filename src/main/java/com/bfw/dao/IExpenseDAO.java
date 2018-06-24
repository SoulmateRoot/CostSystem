/**
 * Project Name:costone
 * File Name:IExpenseDAO.java
 * Package Name:com.bfw.dao
 * Date:2018年6月15日下午9:28:23
 * Copyright (c) 2018, soulmate.leilei@qq.com All Rights Reserved.
 * 创建人:Soulmate.leilei
*/

package com.bfw.dao;

import java.util.List;
import java.util.Map;

import com.bfw.bean.AuditHistory;
import com.bfw.bean.ExpenseAccount;
import com.bfw.bean.ExpenseDetails;

/**
 * ClassName:IExpenseDAO <br/>
 * Function: 报销管理的数据访问借口. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2018年6月15日 下午9:28:23 <br/>
 * @author   Soulmate.leilei
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public interface IExpenseDAO {
	
	/**
	 * @Title: addExpense  
	 * @Description: 添加报销单  
	 * @param ea
	 * @return 返回影响的行数    
	 * @return int    
	 * @throws
	 */
	public int addExpense(ExpenseAccount ea);
	/**
	 * @Title: addExpenseDetails  
	 * @Description: 添加报销明细 
	 * @param ed
	 * @return      
	 * @return int    
	 * @throws
	 */
	public int addExpenseDetails(ExpenseDetails ed);
	/**
	 * @Title: list  
	 * @Description: 根据条件查询报销列表
	 * @param ea
	 * @return      
	 * @return List<ExpenseAccount>    
	 * @throws
	 */
	public List<ExpenseAccount>list(ExpenseAccount ea);
	
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
	 * @return ExpenseAccount    
	 * @throws
	 */
	public List<Map> getExpenseDetailsList(ExpenseAccount ea);
	/**
	 * @Title: addAuditHistory  
	 * @Description:添加审批历史记录 
	 * @param ah
	 * @return      
	 * @return int    
	 * @throws
	 */
	public int addAuditHistory(AuditHistory ah);
	/**
	 * @Title: updateExpenseAccount  
	 * @Description:修改报销单  
	 * @param ea
	 * @return      
	 * @return int    
	 * @throws
	 */
	public int updateExpenseAccount(ExpenseAccount ea);
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
	 * 
	 * @Title: getLit  
	 * @Description:根据审核人编号进行查询 
	 * @param ea
	 * @return      
	 * @return List<ExpenseAccount>    
	 * @throws
	 */
	public List<ExpenseAccount> getLit(ExpenseAccount ea);
}

