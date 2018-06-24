/**
 * Project Name:costone
 * File Name:ExpenseServiceImpl.java
 * Package Name:com.bfw.service.impl
 * Date:2018��6��15������10:07:12
 * Copyright (c) 2018, soulmate.leilei@qq.com All Rights Reserved.
 * ������:Soulmate.leilei
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
 * Function: ��������ҵ���߼�ʵ����. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2018��6��15�� ����10:07:12 <br/>
 * @author   Soulmate.leilei
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
@Service
@Transactional
public class ExpenseServiceImpl implements IExpenseService {
	
	//����ע��
	@Autowired
	private IExpenseDAO expdao;
	/**
	 * 
	 * TODO ��������ӷ���.
	 * @see com.bfw.service.IExpenseService#add(com.bfw.bean.ExpenseAccount, java.lang.Integer[], java.lang.Double[])
	 */
	public void add(ExpenseAccount ea, Integer[] costId, Double[] expenseDetailsSmount) {
		//��ӱ�����
		expdao.addExpense(ea);
		for(int i=0;i<costId.length;i++){
			ExpenseDetails ed=new ExpenseDetails();
			System.out.println(ed);
			//��ȡ�������
			//ed.setExpenseId(ea.getExpenseId());
			ed.setExpenseId(ea.getExpenseId());
			ed.setCostId(costId[i]);
			ed.setExpenseDetailsAmount(expenseDetailsSmount[i]);
			expdao.addExpenseDetails(ed);
		}
	}
	/**
	 * 
	 * TODO ҵ���߼� ��ѯ�����б�.
	 * @see com.bfw.service.IExpenseService#list(com.bfw.bean.ExpenseAccount)
	 */
	public List<ExpenseAccount> list(ExpenseAccount ea) {
		condition(ea);
		return expdao.list(ea);
	}
	/**
	 * 
	 * TODO ҵ���߼� ��ѯ��ҳ��.
	 * @see com.bfw.service.IExpenseService#getcount(com.bfw.bean.ExpenseAccount)
	 */
	public long getcount(ExpenseAccount ea) {
		condition(ea);
		return expdao.getcount(ea);
	}
	
	/**
	 * @Title: condition  
	 * @Description: ��ѯ���� 
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
	 * TODO ���ݱ�Ų�ѯ������.
	 * @see com.bfw.service.IExpenseService#getExpenseAccount(com.bfw.bean.ExpenseAccount)
	 */
	public ExpenseAccount getExpenseAccount(ExpenseAccount ea) {
		
		return expdao.getExpenseAccount(ea);
	}
	/**
	 * 
	 * TODO ���ݱ�Ų�ѯ��������ϸ.
	 * @see com.bfw.service.IExpenseService#getExpenseDetailsList(com.bfw.bean.ExpenseDetails)
	 */
	public List<Map> getExpenseDetailsList(ExpenseAccount ea) {
		
		return expdao.getExpenseDetailsList(ea);
	}
	/**
	 * 
	 * TODO �������  �����ʷ��¼.
	 * @see com.bfw.service.IExpenseService#auditManager(com.bfw.bean.AuditHistory)
	 */
	public void auditManager(AuditHistory ah) {
		ExpenseAccount ea = new ExpenseAccount();
		ea.setExpenseId(ah.getExpenseId());
		
		//��˲�ͨ��
		if (Comm.EXPENSE_STATE_REONE.equals(ah.getAuditState())) {
			ea.setExpenseState(Comm.EXPENSE_STATE_ZERO);
			// ����
		} else if (Comm.EXPENSE_STATE_DELETE.equals(ah.getAuditState())) {
			ea.setExpenseState(Comm.EXPENSE_STATE_DELETE);
		} else {
			// ���ͨ��
			ea.setExpenseState(ah.getAuditState());
		}
		//�����˼�¼
		expdao.addAuditHistory(ah);
		// �޸ı�����
		expdao.updateExpenseAccount(ea);
	}
	/**
	 * 
	 * TODO ������ˣ����ݱ�������Ų�ѯ�����ʷ��¼
	 * @see com.bfw.service.IExpenseService#getAuditHistoryList(com.bfw.bean.ExpenseAccount)
	 */
	public List<Map> getAuditHistoryList(ExpenseAccount ea) {
		
		return expdao.getAuditHistoryList(ea);
	}
	/**
	 * 
	 * TODO �ҵ����  ��������˽��в�ѯ������.
	 * @see com.bfw.service.IExpenseService#getLit(com.bfw.bean.ExpenseAccount)
	 */
	public List<ExpenseAccount> getLit(ExpenseAccount ea) {
		return expdao.getLit(ea);
	}


	
	
	
}
