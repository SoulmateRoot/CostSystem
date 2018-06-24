/**
 * Project Name:costone
 * File Name:IExpenseDAO.java
 * Package Name:com.bfw.dao
 * Date:2018��6��15������9:28:23
 * Copyright (c) 2018, soulmate.leilei@qq.com All Rights Reserved.
 * ������:Soulmate.leilei
*/

package com.bfw.dao;

import java.util.List;
import java.util.Map;

import com.bfw.bean.AuditHistory;
import com.bfw.bean.ExpenseAccount;
import com.bfw.bean.ExpenseDetails;

/**
 * ClassName:IExpenseDAO <br/>
 * Function: ������������ݷ��ʽ��. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2018��6��15�� ����9:28:23 <br/>
 * @author   Soulmate.leilei
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public interface IExpenseDAO {
	
	/**
	 * @Title: addExpense  
	 * @Description: ��ӱ�����  
	 * @param ea
	 * @return ����Ӱ�������    
	 * @return int    
	 * @throws
	 */
	public int addExpense(ExpenseAccount ea);
	/**
	 * @Title: addExpenseDetails  
	 * @Description: ��ӱ�����ϸ 
	 * @param ed
	 * @return      
	 * @return int    
	 * @throws
	 */
	public int addExpenseDetails(ExpenseDetails ed);
	/**
	 * @Title: list  
	 * @Description: ����������ѯ�����б�
	 * @param ea
	 * @return      
	 * @return List<ExpenseAccount>    
	 * @throws
	 */
	public List<ExpenseAccount>list(ExpenseAccount ea);
	
	/**
	 * @Title: getcount  
	 * @Description:��ѯ�ܼ�¼�� 
	 * @param ea
	 * @return      
	 * @return long    
	 * @throws
	 */
	public long getcount(ExpenseAccount ea);
	/**
	 * @Title: getExpenseAccount  
	 * @Description: ���ݱ�Ų�ѯ������  
	 * @param ea ��ѯ����
	 * @return ���ص�����������Ϣ     
	 * @return ExpenseAccount    
	 * @throws
	 */
	public ExpenseAccount getExpenseAccount(ExpenseAccount ea);
	/**
	 * @Title: getExpenseDetailsList  
	 * @Description:  
	 * @param ed ���ݱ�Ų�ѯ��������ϸ
	 * @return  ���ر�������ϸ
	 * @return ExpenseAccount    
	 * @throws
	 */
	public List<Map> getExpenseDetailsList(ExpenseAccount ea);
	/**
	 * @Title: addAuditHistory  
	 * @Description:���������ʷ��¼ 
	 * @param ah
	 * @return      
	 * @return int    
	 * @throws
	 */
	public int addAuditHistory(AuditHistory ah);
	/**
	 * @Title: updateExpenseAccount  
	 * @Description:�޸ı�����  
	 * @param ea
	 * @return      
	 * @return int    
	 * @throws
	 */
	public int updateExpenseAccount(ExpenseAccount ea);
	/**
	 * @Title: getAuditHistoryList  
	 * @Description: ��ѯ�����ʷ��¼ 
	 * @param ea
	 * @return ����     
	 * @return List<Map>    
	 * @throws
	 */
	public List<Map> getAuditHistoryList(ExpenseAccount ea);
	/**
	 * 
	 * @Title: getLit  
	 * @Description:��������˱�Ž��в�ѯ 
	 * @param ea
	 * @return      
	 * @return List<ExpenseAccount>    
	 * @throws
	 */
	public List<ExpenseAccount> getLit(ExpenseAccount ea);
}

