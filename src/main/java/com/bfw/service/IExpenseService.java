/**
 * Project Name:costone
 * File Name:IExpenseService.java
 * Package Name:com.bfw.service
 * Date:2018��6��15������10:02:07
 * Copyright (c) 2018, soulmate.leilei@qq.com All Rights Reserved.
 * ������:Soulmate.leilei
*/

package com.bfw.service;


import java.util.List;
import java.util.Map;

import com.bfw.bean.AuditHistory;
import com.bfw.bean.ExpenseAccount;
import com.bfw.bean.ExpenseDetails;

/**
 * ClassName:IExpenseService <br/>
 * Function: ��������ҵ���߼��ӿ� <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2018��6��15�� ����10:02:07 <br/>
 * @author   Soulmate.leilei
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public interface IExpenseService {
	
	/**
	 * @Title: add  
	 * @Description: ��ӱ����� 
	 * @param ea ������
	 * @param costId �����ķ���
	 * @param expenseDetailsSmount �����Ľ��   
	 * @return void    
	 * @throws
	 */
	public void add(ExpenseAccount ea, Integer[] costId, Double[] expenseDetailsSmount);
	/**
	 * @Title: list  
	 * @Description:����������ѯ��������Ϣ
	 * @param ea ��ѯ���� 
	 * @return ����δ��˵ı�����
	 * @return List<ExpenseAccount>    
	 * @throws
	 */
	public List<ExpenseAccount> list(ExpenseAccount ea);
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
	 * @return ExpenseDetails    
	 * @throws
	 */
	public List<Map> getExpenseDetailsList(ExpenseAccount ea);
	/**
	 * @Title: auditManager  
	 * @Description: ������� �����ʷ��¼ 
	 * @param ah      
	 * @return void    
	 * @throws
	 */
	public void auditManager(AuditHistory ah);
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
	 * @Title: getLit  
	 * @Description: ��������˽��в�ѯ������ 
	 * @param ea
	 * @return      
	 * @return List<ExpenseAccount>    
	 * @throws
	 */
	public List<ExpenseAccount>  getLit(ExpenseAccount ea);
}

