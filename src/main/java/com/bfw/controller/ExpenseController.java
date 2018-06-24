/**
 * Project Name:costone
 * File Name:ExpenseController.java
 * Package Name:com.bfw.controller
 * Date:2018��5��23������11:08:01
 * Copyright (c) 2018, soulmate.leilei@qq.com All Rights Reserved.
 * ������:Soulmate.leilei
*/

package com.bfw.controller;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bfw.bean.AuditHistory;
import com.bfw.bean.CostInfo;
import com.bfw.bean.ExpenseAccount;
import com.bfw.bean.UserInfo;
import com.bfw.service.ICostInfoService;
import com.bfw.service.IExpenseService;
import com.bfw.utils.Comm;
import com.bfw.utils.Page;

/**
 * ClassName:ExpenseController <br/>
 * Function: �������� ������<br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2018��5��23�� ����11:08:01 <br/>
 * @author   Soulmate.leilei
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
@Controller
@RequestMapping("/expense/")
public class ExpenseController extends Page{
	
	//����ע��  ������Ϣ����  ҵ���߼��ӿ�
	@Autowired
	private ICostInfoService costservice;
	//����ע�룬����  ҵ���߼��ӿ�
	@Autowired
	private IExpenseService expenseservice;
	
	/**
	 * @Title: loadadd  
	 * @Description:���ر�����  
	 * @param model
	 * @return      
	 * @return String    
	 * @throws
	 */
	@RequestMapping("loadadd.do")
	public String loadadd(Model model){
		CostInfo info = new CostInfo();
		//����ֻ��ѯ��Ч���� 
		info.setCostMark(Comm.MARK_YES);
		//���ò�ѯȫ������ 
		info.setStart(-1);
		//��ѯ�����ݣ���װ��list������
		List<CostInfo>list=costservice.list(info);
		//��װ��model��
		model.addAttribute("list",list);
		return "expense/expense_add";
	}
	
	/**
	 * @Title: add  
	 * @Description: ���������ҳ�� 
	 * @return      
	 * @return String    
	 * @throws
	 * @thinking:
	 * 1.�õ�ǰ�˴�������ݣ���ExpenseDetails����ExpenseAccount�����Է��������б�Ϊ��
	 * 2.HttpSession:
	 * 3.toString������
	 * 4.����ʱ���ʽ��ʱ�䴦��༭����������ײ���
	 * 5.ServletRequestDataBinder
	 */
	
	@RequestMapping("add.do")
	public String add(HttpSession session, ExpenseAccount ea, Integer[] costId, 
			Double[] expenseDetailsSmount,Model model){
		//��ȡ��ǰ�û���½��Ϣ
		UserInfo user =(UserInfo)session.getAttribute("user");
		if(ea!=null){
			//�ж��û��Ƿ�Ϊ�գ�����ǰ�û�id���õ� ea.setUserId
			ea.setUserId(user.getUserId());
			ea.setExpenseState(Comm.EXPENSE_STATE_ONE);
		}
		try{
			expenseservice.add(ea, costId, expenseDetailsSmount);
			model.addAttribute("errorinfo","�����ύ�ɹ�����ȴ����");
		}catch(Exception e){
			e.printStackTrace();
			model.addAttribute("errorinfo", "�������ύʧ��");
		}
		return loadadd(model);
	}
	
		//�����Ƿ��õ�����/////////////////
//		System.out.println(ea);
//		if(costId!=null){
//			for(int i=0;i<costId.length;i++){
//				System.out.println("���ñ��"+costId[i]+"���ý��"+expenseDetailsSmount[i]);
//			}
//		}
		
	/**
	 * @Title: loadAuditManager  
	 * @Description: �������ҳ��  
	 * @return      
	 * @return String    
	 * @throws
	 */
	@RequestMapping("loadAuditManager.do")
	public String loadAuditManager(ExpenseAccount ea,Model model,HttpServletRequest request){
		//if����ж��Ƿ�Ϊ��
		if(ea==null){
			//Ϊ����newһ������
			ea=new ExpenseAccount();
		}
		//���з�ҳ��Ϣ����
		//���״̬����
		ea.setExpenseState(Comm.EXPENSE_STATE_ONE);
		//���÷�ҳ��Ϣ
		this.initPage(request);
		//��ʼ��¼
		ea.setStart(this.getPageNo());
		//ÿҳ��ʾ�ļ�¼����
		ea.setLength(PAGE_NUM_BIG);
		//������Ϣ�б�
		model.addAttribute("list", expenseservice.list(ea));
		// �ܼ�¼��
		model.addAttribute("total", expenseservice.getcount(ea));
		//ҳ�淵��
		return "expense/expense_audit_manager";
	}
	
	/**
	 * @Title: loadManager  
	 * @Description: ���ž����������ҳ�� 
	 * @param ea
	 * @return      
	 * @return String    
	 * @throws
	 */
	@RequestMapping("loadManager.do")
	public String loadManager(ExpenseAccount ea,Model model){
		ExpenseAccount exp= expenseservice.getExpenseAccount(ea);
		List<Map> list = expenseservice.getExpenseDetailsList(ea);
		model.addAttribute("exp",exp);
		model.addAttribute("list",list);
		return "expense/expense_manager";
	}
	/*
	 * ���ž���    �ύ�����Ϣ
	 */
	@RequestMapping("auditManager.do")
	public String auditManager(AuditHistory ah,Model model,HttpServletRequest request,HttpSession session){
		//�õ���ǰ�û�
		UserInfo user=(UserInfo) session.getAttribute("user");
		//�ж��Ƿ�Ϊ��
		if(ah!=null){
			ah.setUserId(user.getUserId());
		}
		try {
			expenseservice.auditManager(ah);
			model.addAttribute("errorinfo","��������˳ɹ�");
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorinfo","���������ʧ��");
		}
		return loadAuditManager(null,model,request);
		
	}
	
	/**
	 * @Title: loadAuditFinance  
	 * @Description: �������ҳ��  ��ѯ������˱�����
	 * @return      
	 * @return String    
	 * @throws
	 */
	@RequestMapping("loadAuditFinance.do")
	public String loadAuditFinance(ExpenseAccount ea,Model model,HttpServletRequest request){
		//if����ж��Ƿ�Ϊ��
		if(ea==null){
			//Ϊ����newһ������
			ea=new ExpenseAccount();
		}
		//���з�ҳ��Ϣ����
		//���״̬����
		ea.setExpenseState(Comm.EXPENSE_STATE_TWO);
		//���÷�ҳ��Ϣ
		this.initPage(request);
		//��ʼ��¼
		ea.setStart(this.getPageNo());
		//ÿҳ��ʾ�ļ�¼����
		ea.setLength(PAGE_NUM_BIG);
		//������Ϣ�б�
		model.addAttribute("list", expenseservice.list(ea));
		// �ܼ�¼��
		model.addAttribute("total", expenseservice.getcount(ea));
		//ҳ�淵��
		return "expense/expense_audit_finance";
	}
	
	/**
	 * @Title: loadFinance  
	 * @Description: �����������ҳ��  
	 * @return      
	 * @return String    
	 * @throws
	 */
	@RequestMapping("loadFinance.do")
	public String loadFinance(ExpenseAccount ea,Model model){
		//���ݱ�Ų�ѯ������
		ExpenseAccount exp= expenseservice.getExpenseAccount(ea);
		//���ݱ�Ų�ѯ��������ϸ
		List<Map> list = expenseservice.getExpenseDetailsList(ea);
		//���ݱ�Ų�ѯ�����������ʷ��¼
		List<Map> HistoryList=expenseservice.getAuditHistoryList(ea);
		model.addAttribute("exp",exp);
		model.addAttribute("list",list);
		model.addAttribute("HistoryList",HistoryList);
		return "expense/expense_finance";
	}
	/*
	 * ��������ύ
	 */
	@RequestMapping("auditFinance.do")
	public String auditFinance(AuditHistory ah,Model model,HttpServletRequest request,HttpSession session){
		//�õ���ǰ�û�
		UserInfo user=(UserInfo) session.getAttribute("user");
		//�ж��Ƿ�Ϊ��
		if(ah!=null){
			ah.setUserId(user.getUserId());
		}
		try {
			expenseservice.auditManager(ah);
			model.addAttribute("errorinfo","��������˳ɹ�");
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorinfo","���������ʧ��");
		}
		return loadAuditFinance(null,model,request);
	}
	/**
	 * @Title: mylist  
	 * @Description:�ҵı�����
	 * @return      
	 * @return String    
	 * @throws
	 */
	@RequestMapping("mylist.do")
	public String mylist(HttpSession session,ExpenseAccount ea,Model model,HttpServletRequest request){
		//�õ���ǰ�û�
		UserInfo user=(UserInfo) session.getAttribute("user");
		//if����ж��Ƿ�Ϊ��
		if(ea!=null){
			ea=new ExpenseAccount();
			
		}
		//���з�ҳ��Ϣ����
		//���״̬����
		//ea.setExpenseState(Comm.EXPENSE_STATE_TWO);
		//���÷�ҳ��Ϣ
		ea.setUserId(user.getUserId());
		this.initPage(request);
		//��ʼ��¼
		ea.setStart(this.getPageNo());
		//ÿҳ��ʾ�ļ�¼����
		ea.setLength(PAGE_NUM_BIG);
		//������Ϣ�б�
		model.addAttribute("list", expenseservice.list(ea));
		// �ܼ�¼��
		model.addAttribute("total", expenseservice.getcount(ea));
		//ҳ�淵��
		return "expense/expense_mylist";
	}
	
	/**
	 * @Title: myshow  
	 * @Description: �ҵı�����ϸ  
	 * @return      
	 * @return String    
	 * @throws
	 */
	@RequestMapping("myshow.do")
	public String myshow(ExpenseAccount ea,Model model){
		//���ݱ�Ų�ѯ������
		ExpenseAccount exp= expenseservice.getExpenseAccount(ea);
		//���ݱ�Ų�ѯ��������ϸ
		List<Map> list = expenseservice.getExpenseDetailsList(ea);
		//���ݱ�Ų�ѯ�����������ʷ��¼
		List<Map> HistoryList=expenseservice.getAuditHistoryList(ea);
		model.addAttribute("exp",exp);
		model.addAttribute("list",list);
		model.addAttribute("HistoryList",HistoryList);
		return "expense/expense_myshow";
	}
	/**
	 * @Title: list  
	 * @Description: ���б������б��ѯ  
	 * @return      
	 * @return String    
	 * @throws
	 */
	@RequestMapping("list.do")
	public String list(HttpSession session,ExpenseAccount ea,Model model,HttpServletRequest request){
		if (ea == null) {
			ea = new ExpenseAccount();
		}
		// ��ҳ��Ϣ
		this.initPage(request);
		// ��ʼ��¼
		ea.setStart(this.getPageNo());
		// ÿҳ��ʾ��¼��
		ea.setLength(PAGE_NUM_BIG);
		model.addAttribute("list", expenseservice.list(ea));
		// �ܼ�¼��
		model.addAttribute("total", expenseservice.getcount(ea));

		return "expense/expense_list";
	}
	
	/**
	 * @Title: show  
	 * @Description: �������б��ѯ��ϸ 
	 * @return      
	 * @return String    
	 * @throws
	 */
	@RequestMapping("show.do")
	public String show(ExpenseAccount ea,Model model){
		//���ݱ�Ų�ѯ������
		ExpenseAccount exp= expenseservice.getExpenseAccount(ea);
		//���ݱ�Ų�ѯ��������ϸ
		List<Map> list = expenseservice.getExpenseDetailsList(ea);
		//���ݱ�Ų�ѯ�����������ʷ��¼
		List<Map> HistoryList=expenseservice.getAuditHistoryList(ea);
		model.addAttribute("exp",exp);
		model.addAttribute("list",list);
		model.addAttribute("HistoryList",HistoryList);
		return "expense/expense_show";
	}

	/**
	 * @param request 
	 * @Title: myauditlist  
	 * @Description: �ҵ�����б� 
	 * @return      
	 * @return String    
	 * @throws
	 */
	@RequestMapping("myauditlist.do")
	public String myauditlist(ExpenseAccount ea,Model model,HttpSession session, HttpServletRequest request){
		if(ea==null){
			ea= new ExpenseAccount();
		}
		//��ʼ����ҳ
		this.initPage(request);
		//��ʼҳ
		ea.setStart(this.getPageNo());
		//ÿҳ��ʾ��¼��
		ea.setLength(PAGE_NUM_BIG);
		//�õ���ǰ�û�
		UserInfo user=(UserInfo)session.getAttribute("user");
		ea.setUserId(user.getUserId());
		model.addAttribute("getLit",expenseservice.getLit(ea));
		model.addAttribute("total",expenseservice.getcount(ea));
		return "expense/expense_myauditlist";
	}
	
	/**
	 * @Title: myauditshow  
	 * @Description: �ҵ��������ҳ��  
	 * @return      
	 * @return String    
	 * @throws
	 */
	@RequestMapping("myauditshow.do")
	public String myauditshow(Model model,ExpenseAccount ea){
		
		//���ݱ�Ų�ѯ������
		ExpenseAccount exp= expenseservice.getExpenseAccount(ea);
		//���ݱ�Ų�ѯ��������ϸ
		List<Map> list = expenseservice.getExpenseDetailsList(ea);
		//���ݱ�Ų�ѯ�����������ʷ��¼
		List<Map> HistoryList=expenseservice.getAuditHistoryList(ea);
		model.addAttribute("exp",exp);
		model.addAttribute("list",list);
		model.addAttribute("HistoryList",HistoryList);
		return "expense/expense_myauditshow";
	}
	
	/**
	 * @Title: initBinder  
	 * @Description:ʱ�����Ա༭��  ʱ���ʽת��
	 * @param bin      
	 * @return void    
	 * @throws
	 */
	@InitBinder
	public void initBinder(ServletRequestDataBinder bin) {
		bin.registerCustomEditor(Date.class, new CustomDateEditor(
				new SimpleDateFormat("yyyy-MM-dd"), true));
	}
	
}