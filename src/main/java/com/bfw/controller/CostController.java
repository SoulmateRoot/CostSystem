/**
 * Project Name:costone
 * File Name:CostController.java
 * Package Name:com.bfw.controller
 * Date:2018年5月22日下午9:44:03
 * Copyright (c) 2018, soulmate.leilei@qq.com All Rights Reserved.
 * 创建人:Soulmate.leilei
*/

package com.bfw.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bfw.bean.CostInfo;
import com.bfw.service.ICostInfoService;
import com.bfw.utils.Comm;
import com.bfw.utils.Page;

/**
 * ClassName:CostController <br/>
 * Function: 费用管理控制器 <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2018年5月22日 下午9:44:03 <br/>
 * @author   Soulmate.leilei
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
@Controller
@RequestMapping("/cost/")
public class CostController extends Page{
	
	//依赖注入
	@Autowired
	private ICostInfoService costservice;
	
	/**
	 * list:(费用查询). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 */
	@RequestMapping("list.do")
	public String list(CostInfo info,Model model,HttpServletRequest request){
		//判断用户是否为空
		if(info==null){
			info=new CostInfo();
		}
		//分页信息
		this.initPage(request);
		//起始记录
		info.setStart(this.getPageNo());
		//设置显示条数
		info.setLength(PAGE_NUM_BIG);
		//返回显示
		model.addAttribute("list",costservice.list(info));
		model.addAttribute("total",costservice.getcount(info));
		return "cost/cost_list";
	}
	
	/**
	 * loadadd:(加载费用添加页面). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 */
	@RequestMapping("loadadd.do")
	public String loadadd(){
		return "cost/cost_add";
	}
	/**
	 * @Title: add  
	 * @Description:费用添加 
	 * @param info
	 * @param model
	 * @return      
	 * @return String    
	 * @throws
	 */
	@RequestMapping("add.do")
	public String add(CostInfo info,Model model,HttpServletRequest request){
		try{
			if(info!=null){
				info.setCostMark(Comm.MARK_YES);
			}
			costservice.add(info);
		}catch(Exception e){
			model.addAttribute("errorinfo","费用添加失败");
			e.printStackTrace();
		}
		return list(null,model,request);
	}
	/**
	 * loadadd:(费用修改). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 */
	@RequestMapping("loadupdate.do")
	public String loadupdate(CostInfo info,Model model){
		model.addAttribute("cost",costservice.getinfo(info));
		return "cost/cost_update";
	}
	/**
	 * @Title: update  
	 * @Description:费用修改方法
	 * @param info
	 * @param model
	 * @param request
	 * @return      
	 * @return String    
	 * @throws
	 */
	@RequestMapping("update.do")
	public String update(CostInfo info,Model model,HttpServletRequest request){
		try {
			costservice.update(info);
		} catch (Exception e) {
			//异常信息抛出显示
			model.addAttribute("errorinfo","费用信息修改失败");
			e.printStackTrace();
		}
		return list(null,model,request);
	}
	/**
	 * @Title: delete  
	 * @Description: 费用信息删除方法  
	 * @param costid
	 * @param model
	 * @param request
	 * @return      
	 * @return String    
	 * @throws
	 */
	@RequestMapping("delete.do")
	public String delete(Integer[] costId,Model model,HttpServletRequest request){
		try {
			costservice.delete(costId);
			model.addAttribute("errorinfo", "费用信息删除成功");
		} catch (Exception e) {
			//异常信息抛出显示
			model.addAttribute("errorinfo","费用信息删除失败");
			e.printStackTrace();
		}
		return list(null,model,request);
	}
	
	
	

}

