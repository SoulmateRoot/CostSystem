/**
 * Project Name:costone
 * File Name:ExpenseController.java
 * Package Name:com.bfw.controller
 * Date:2018年5月23日上午11:08:01
 * Copyright (c) 2018, soulmate.leilei@qq.com All Rights Reserved.
 * 创建人:Soulmate.leilei
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
 * Function: 报销管理 控制器<br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2018年5月23日 上午11:08:01 <br/>
 * @author   Soulmate.leilei
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
@Controller
@RequestMapping("/expense/")
public class ExpenseController extends Page{
	
	//依赖注入  费用信息类型  业务逻辑接口
	@Autowired
	private ICostInfoService costservice;
	//依赖注入，报销  业务逻辑接口
	@Autowired
	private IExpenseService expenseservice;
	
	/**
	 * @Title: loadadd  
	 * @Description:加载报销单  
	 * @param model
	 * @return      
	 * @return String    
	 * @throws
	 */
	@RequestMapping("loadadd.do")
	public String loadadd(Model model){
		CostInfo info = new CostInfo();
		//设置只查询有效数据 
		info.setCostMark(Comm.MARK_YES);
		//设置查询全部数据 
		info.setStart(-1);
		//查询出数据，封装到list数组中
		List<CostInfo>list=costservice.list(info);
		//封装进model中
		model.addAttribute("list",list);
		return "expense/expense_add";
	}
	
	/**
	 * @Title: add  
	 * @Description: 报销单添加页面 
	 * @return      
	 * @return String    
	 * @throws
	 * @thinking:
	 * 1.拿到前端传输的数据，有ExpenseDetails，有ExpenseAccount。所以方法参数列表为：
	 * 2.HttpSession:
	 * 3.toString方法：
	 * 4.处理时间格式：时间处理编辑器方法（类底部）
	 * 5.ServletRequestDataBinder
	 */
	
	@RequestMapping("add.do")
	public String add(HttpSession session, ExpenseAccount ea, Integer[] costId, 
			Double[] expenseDetailsSmount,Model model){
		//获取当前用户登陆信息
		UserInfo user =(UserInfo)session.getAttribute("user");
		if(ea!=null){
			//判断用户是否为空，将当前用户id设置到 ea.setUserId
			ea.setUserId(user.getUserId());
			ea.setExpenseState(Comm.EXPENSE_STATE_ONE);
		}
		try{
			expenseservice.add(ea, costId, expenseDetailsSmount);
			model.addAttribute("errorinfo","报销提交成功，请等待审核");
		}catch(Exception e){
			e.printStackTrace();
			model.addAttribute("errorinfo", "报销单提交失败");
		}
		return loadadd(model);
	}
	
		//测试是否拿到数据/////////////////
//		System.out.println(ea);
//		if(costId!=null){
//			for(int i=0;i<costId.length;i++){
//				System.out.println("费用编号"+costId[i]+"费用金额"+expenseDetailsSmount[i]);
//			}
//		}
		
	/**
	 * @Title: loadAuditManager  
	 * @Description: 经理审核页面  
	 * @return      
	 * @return String    
	 * @throws
	 */
	@RequestMapping("loadAuditManager.do")
	public String loadAuditManager(ExpenseAccount ea,Model model,HttpServletRequest request){
		//if语句判断是否为空
		if(ea==null){
			//为空则new一个对象
			ea=new ExpenseAccount();
		}
		//进行分页信息设置
		//审核状态设置
		ea.setExpenseState(Comm.EXPENSE_STATE_ONE);
		//设置分页信息
		this.initPage(request);
		//起始记录
		ea.setStart(this.getPageNo());
		//每页显示的记录数量
		ea.setLength(PAGE_NUM_BIG);
		//报销信息列表
		model.addAttribute("list", expenseservice.list(ea));
		// 总记录数
		model.addAttribute("total", expenseservice.getcount(ea));
		//页面返回
		return "expense/expense_audit_manager";
	}
	
	/**
	 * @Title: loadManager  
	 * @Description: 部门经理审核详情页面 
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
	 * 部门经理    提交审核信息
	 */
	@RequestMapping("auditManager.do")
	public String auditManager(AuditHistory ah,Model model,HttpServletRequest request,HttpSession session){
		//拿到当前用户
		UserInfo user=(UserInfo) session.getAttribute("user");
		//判断是否为空
		if(ah!=null){
			ah.setUserId(user.getUserId());
		}
		try {
			expenseservice.auditManager(ah);
			model.addAttribute("errorinfo","报销单审核成功");
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorinfo","报销单审核失败");
		}
		return loadAuditManager(null,model,request);
		
	}
	
	/**
	 * @Title: loadAuditFinance  
	 * @Description: 财务审核页面  查询出待审核报销单
	 * @return      
	 * @return String    
	 * @throws
	 */
	@RequestMapping("loadAuditFinance.do")
	public String loadAuditFinance(ExpenseAccount ea,Model model,HttpServletRequest request){
		//if语句判断是否为空
		if(ea==null){
			//为空则new一个对象
			ea=new ExpenseAccount();
		}
		//进行分页信息设置
		//审核状态设置
		ea.setExpenseState(Comm.EXPENSE_STATE_TWO);
		//设置分页信息
		this.initPage(request);
		//起始记录
		ea.setStart(this.getPageNo());
		//每页显示的记录数量
		ea.setLength(PAGE_NUM_BIG);
		//报销信息列表
		model.addAttribute("list", expenseservice.list(ea));
		// 总记录数
		model.addAttribute("total", expenseservice.getcount(ea));
		//页面返回
		return "expense/expense_audit_finance";
	}
	
	/**
	 * @Title: loadFinance  
	 * @Description: 财务审核详情页面  
	 * @return      
	 * @return String    
	 * @throws
	 */
	@RequestMapping("loadFinance.do")
	public String loadFinance(ExpenseAccount ea,Model model){
		//根据编号查询报销单
		ExpenseAccount exp= expenseservice.getExpenseAccount(ea);
		//根据编号查询报销单明细
		List<Map> list = expenseservice.getExpenseDetailsList(ea);
		//根据编号查询报销单审核历史记录
		List<Map> HistoryList=expenseservice.getAuditHistoryList(ea);
		model.addAttribute("exp",exp);
		model.addAttribute("list",list);
		model.addAttribute("HistoryList",HistoryList);
		return "expense/expense_finance";
	}
	/*
	 * 财务审核提交
	 */
	@RequestMapping("auditFinance.do")
	public String auditFinance(AuditHistory ah,Model model,HttpServletRequest request,HttpSession session){
		//拿到当前用户
		UserInfo user=(UserInfo) session.getAttribute("user");
		//判断是否为空
		if(ah!=null){
			ah.setUserId(user.getUserId());
		}
		try {
			expenseservice.auditManager(ah);
			model.addAttribute("errorinfo","报销单审核成功");
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorinfo","报销单审核失败");
		}
		return loadAuditFinance(null,model,request);
	}
	/**
	 * @Title: mylist  
	 * @Description:我的报销单
	 * @return      
	 * @return String    
	 * @throws
	 */
	@RequestMapping("mylist.do")
	public String mylist(HttpSession session,ExpenseAccount ea,Model model,HttpServletRequest request){
		//拿到当前用户
		UserInfo user=(UserInfo) session.getAttribute("user");
		//if语句判断是否为空
		if(ea!=null){
			ea=new ExpenseAccount();
			
		}
		//进行分页信息设置
		//审核状态设置
		//ea.setExpenseState(Comm.EXPENSE_STATE_TWO);
		//设置分页信息
		ea.setUserId(user.getUserId());
		this.initPage(request);
		//起始记录
		ea.setStart(this.getPageNo());
		//每页显示的记录数量
		ea.setLength(PAGE_NUM_BIG);
		//报销信息列表
		model.addAttribute("list", expenseservice.list(ea));
		// 总记录数
		model.addAttribute("total", expenseservice.getcount(ea));
		//页面返回
		return "expense/expense_mylist";
	}
	
	/**
	 * @Title: myshow  
	 * @Description: 我的报销明细  
	 * @return      
	 * @return String    
	 * @throws
	 */
	@RequestMapping("myshow.do")
	public String myshow(ExpenseAccount ea,Model model){
		//根据编号查询报销单
		ExpenseAccount exp= expenseservice.getExpenseAccount(ea);
		//根据编号查询报销单明细
		List<Map> list = expenseservice.getExpenseDetailsList(ea);
		//根据编号查询报销单审核历史记录
		List<Map> HistoryList=expenseservice.getAuditHistoryList(ea);
		model.addAttribute("exp",exp);
		model.addAttribute("list",list);
		model.addAttribute("HistoryList",HistoryList);
		return "expense/expense_myshow";
	}
	/**
	 * @Title: list  
	 * @Description: 所有报销单列表查询  
	 * @return      
	 * @return String    
	 * @throws
	 */
	@RequestMapping("list.do")
	public String list(HttpSession session,ExpenseAccount ea,Model model,HttpServletRequest request){
		if (ea == null) {
			ea = new ExpenseAccount();
		}
		// 分页信息
		this.initPage(request);
		// 起始记录
		ea.setStart(this.getPageNo());
		// 每页显示记录数
		ea.setLength(PAGE_NUM_BIG);
		model.addAttribute("list", expenseservice.list(ea));
		// 总记录数
		model.addAttribute("total", expenseservice.getcount(ea));

		return "expense/expense_list";
	}
	
	/**
	 * @Title: show  
	 * @Description: 报销单列表查询明细 
	 * @return      
	 * @return String    
	 * @throws
	 */
	@RequestMapping("show.do")
	public String show(ExpenseAccount ea,Model model){
		//根据编号查询报销单
		ExpenseAccount exp= expenseservice.getExpenseAccount(ea);
		//根据编号查询报销单明细
		List<Map> list = expenseservice.getExpenseDetailsList(ea);
		//根据编号查询报销单审核历史记录
		List<Map> HistoryList=expenseservice.getAuditHistoryList(ea);
		model.addAttribute("exp",exp);
		model.addAttribute("list",list);
		model.addAttribute("HistoryList",HistoryList);
		return "expense/expense_show";
	}

	/**
	 * @param request 
	 * @Title: myauditlist  
	 * @Description: 我的审核列表 
	 * @return      
	 * @return String    
	 * @throws
	 */
	@RequestMapping("myauditlist.do")
	public String myauditlist(ExpenseAccount ea,Model model,HttpSession session, HttpServletRequest request){
		if(ea==null){
			ea= new ExpenseAccount();
		}
		//初始化分页
		this.initPage(request);
		//起始页
		ea.setStart(this.getPageNo());
		//每页显示记录数
		ea.setLength(PAGE_NUM_BIG);
		//拿到当前用户
		UserInfo user=(UserInfo)session.getAttribute("user");
		ea.setUserId(user.getUserId());
		model.addAttribute("getLit",expenseservice.getLit(ea));
		model.addAttribute("total",expenseservice.getcount(ea));
		return "expense/expense_myauditlist";
	}
	
	/**
	 * @Title: myauditshow  
	 * @Description: 我的审核详情页面  
	 * @return      
	 * @return String    
	 * @throws
	 */
	@RequestMapping("myauditshow.do")
	public String myauditshow(Model model,ExpenseAccount ea){
		
		//根据编号查询报销单
		ExpenseAccount exp= expenseservice.getExpenseAccount(ea);
		//根据编号查询报销单明细
		List<Map> list = expenseservice.getExpenseDetailsList(ea);
		//根据编号查询报销单审核历史记录
		List<Map> HistoryList=expenseservice.getAuditHistoryList(ea);
		model.addAttribute("exp",exp);
		model.addAttribute("list",list);
		model.addAttribute("HistoryList",HistoryList);
		return "expense/expense_myauditshow";
	}
	
	/**
	 * @Title: initBinder  
	 * @Description:时间属性编辑器  时间格式转换
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