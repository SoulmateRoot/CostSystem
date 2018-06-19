/**
 * Project Name:costone
 * File Name:RoleController.java
 * Package Name:com.bfw.controller
 * Date:2018年5月20日下午3:36:11
 * Copyright (c) 2018, soulmate.leilei@qq.com All Rights Reserved.
 * 创建人:Soulmate.leilei
*/

package com.bfw.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bfw.bean.RoleInfo;
import com.bfw.service.IRoleInfoService;
import com.bfw.utils.Comm;
import com.bfw.utils.Page;

/**
 * ClassName:RoleController <br/>
 * Function:角色管理控制器 <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2018年5月20日 下午3:36:11 <br/>
 * @author   Soulmate.leilei
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
@Controller
@RequestMapping("/role/")
public class RoleController extends Page{
	@Autowired
	private IRoleInfoService roleservice;
	/**
	 * 
	 * list:(查询角色信息列表). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(前端页面传入请求，经过前端控制器调用控制器查询与之对应的方法).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 */
	
	@RequestMapping("list.do")
	public String list(RoleInfo info,Model model,HttpServletRequest request){
		
		if(info==null){
			info = new RoleInfo();
		}
		//分页信息
		this.initPage(request);
		//起始记录
		info.setStart(this.getPageNo());
		//每页显示记录数
		info.setLength(PAGE_NUM_BIG);
		model.addAttribute("list", roleservice.list(info));
		//总记录数
		model.addAttribute("total", roleservice.getcount(info));
		return "role/role_list";
	}
	
	/**
	 * 
	 * loadAdd:(添加角色跳转页面). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 */
	@RequestMapping("loadadd.do")
	public String loadAdd(){
		return "role/role_add";
		
	}
	/**
	 * 
	 * add:(添加角色方法). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 */
	@RequestMapping("add.do")
	public String add(RoleInfo info,Model model,HttpServletRequest request){
		try{
			if(info==null){
				info=new RoleInfo();
			}
			info.setRoleMark(Comm.MARK_YES);
			roleservice.add(info);
		}catch(Exception e){
			model.addAttribute("errorinfo","角色添加失败");
			e.printStackTrace();
		}
		info=null;
		return list(info,model,request);
		
	}
	
	/**
	 * 
	 * loadUpdate:(跳转修改页面控制器). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 */
	@RequestMapping("loadupdate.do")
	public String loadUpdate(RoleInfo info,Model model){
		//查询角色信息 ：第一个参数名称为jsp页面 jstl foreach循环名称
		model.addAttribute("role",roleservice.getInfo(info));
		return "role/role_update";
	}
	
	/**
	 * update:(角色修改页面 ). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 */
	@RequestMapping("update.do")
	public String update(RoleInfo info,Model model,HttpServletRequest request){
		try{
			roleservice.update(info);
		}catch(Exception e){
			e.printStackTrace();
			model.addAttribute("errorinfo","角色修改失败");
		}
		
		
		return list(null,model,request);
	}
	
	/**
	 * 
	 * delete:(删除方法). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 */
	@RequestMapping("delete.do")
	public String delete(Integer[] roleId,Model model,HttpServletRequest request){
		try{
			roleservice.delete(roleId);
		}catch(Exception e){
			e.printStackTrace();
			model.addAttribute("errorinfo","角色删除失败");
		}
		
		
		return list(null,model,request);
	}
	
	
	
	
	
	
}




/**
 * 
 * ==：等于。equals：相同。两个长得一样的人，只能说长的相同(equals)，但是不等于他们俩是一个人。
 * 你只要记住equals，==就不用记了。楼主你感受一下。
 * ----------------------------------------------------------------
 * 术语来讲的区别：
 * 1.==是判断两个变量或实例是不是指向同一个内存空间   
 *  equals是判断两个变量或实例所指向的内存空间的值是不是相同 
 *  2.==是指对内存地址进行比较    equals()是对字符串的内容进行比较
 *  3.==指引用是否相同    equals()指的是值是否相同

 * 
 */
