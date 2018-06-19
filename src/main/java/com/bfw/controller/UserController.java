/**
 * Project Name:costone
 * File Name:UserController.java
 * Package Name:com.bfw.controller
 * Date:2018年5月21日下午9:29:40
 * Copyright (c) 2018, soulmate.leilei@qq.com All Rights Reserved.
 * 创建人:Soulmate.leilei
*/

package com.bfw.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bfw.bean.RoleInfo;
import com.bfw.bean.UserInfo;
import com.bfw.service.IRoleInfoService;
import com.bfw.service.IUserInfoService;
import com.bfw.utils.Comm;
import com.bfw.utils.Page;

/**
 * ClassName:UserController <br/>
 * Function: 用户管理控制器 <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2018年5月21日 下午9:29:40 <br/>
 * @author   Soulmate.leilei
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
@Controller
@RequestMapping("/user/")
public class UserController extends Page{
	//用户业务逻辑 依赖注入
	@Autowired
	private IUserInfoService userservice;
	//角色业务逻辑 依赖注入
	@Autowired
	private IRoleInfoService roleservice;
	
	
	/**
	 * @Title: list  
	 * @Description:查询用户信息
	 * @param user
	 * @param model
	 * @param request
	 * @return      
	 * @return String    
	 * @throws
	 *
	 */
	@RequestMapping("list.do")
	public String list(UserInfo info,Model model,HttpServletRequest request){
		if(info==null){
			info = new UserInfo();
		}
		info.setUserMark(Comm.MARK_YES);
		//分页信息
		this.initPage(request);
		//设置起始记录
		info.setStart(this.getPageNo());
		//每页显示记录数
		info.setLength(PAGE_NUM_BIG);
		//得到list数据,使用业务逻辑层list接口方法
		model.addAttribute("list" ,userservice.list(info));
		//总记录数，使用业务逻辑层getcount方法
		model.addAttribute("total",userservice.getcount(info));
		return "user/user_list";
	}
	
	/**
	 * @Title: loadadd  
	 * @Description: 加载用户添加页面 同时拿到所有角色信息 
	 * @param model
	 * @return      
	 * @return String    
	 * @throws
	 *
	 */
	@RequestMapping("loadadd.do")
	public String loadadd(Model model){
		//实例化实体类
		RoleInfo info = new RoleInfo();
		//调用实体类起始页属性，赋值为-1
		info.setStart(-1);
		//创建list数组，将从service层方法中得到的用户数据封装进去
		List<RoleInfo> list = roleservice.list(info);
		//使用视图进行
		model.addAttribute("list", list);
		//返回相应显示前端页面
		return "user/user_add";
	}
	/**
	 * @Title: add  
	 * @Description: 添加用户 
	 * @return      
	 * @return String    
	 * @throws
	 *
	 */
	@RequestMapping("add.do")
	public String add(UserInfo user,Model model,HttpServletRequest request){
		try{
			//1. 如果用户为不存在，则new一个新用户
			if(user == null){
				user=new UserInfo();
			}
			//2. 设置标识有效
			user.setUserMark(Comm.MARK_YES);
			//3. 进行service方法数据接收
			userservice.add(user);
		}catch(Exception e){
			//错误提示
			e.printStackTrace();
			model.addAttribute("errorinfo", "用户添加失败");
		}
		return list (null,model,request);
	}
	
	/**
	 * @Title: check  
	 * @Description: 验证帐号是否存在  
	 * @param user
	 * @return      
	 * @return String    
	 * @throws
	 *
	 */
	//类底部讲解注释    1.1
	//produces="text/html; charset=UTF-8"
	@RequestMapping("check.do")
	@ResponseBody
	public  String check(UserInfo user){
		UserInfo userinfo =  userservice.getUser(user);
		if(userinfo!=null){
			return "帐号已经存在啦，再想一个名号吧";
		}else{
			return "ok! 帐号可以使用";
		}
		//if语句节点
	}
	
	/**
	 * loadupdate:(加载修改页面). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 */
	@RequestMapping("loadupdate.do")
	public String loadupdate(UserInfo user,Model model){
				//实例化实体类
				RoleInfo info = new RoleInfo();
				//调用实体类起始页属性，赋值为-1
				info.setStart(-1);
				//创建list数组，将从service层方法中得到的用户数据封装进去
				List<RoleInfo> list = roleservice.list(info);
				//使用视图进行
				model.addAttribute("list", list);
		
		UserInfo userinfo=userservice.getUser(user);
		model.addAttribute("userinfo",userinfo);
		return "user/user_update";
	}
	/**
	 * @Title: update  
	 * @Description:修改用户方法 
	 * @param user
	 * @param model
	 * @param request
	 * @return      
	 * @return String    
	 * @throws
	 */
	@RequestMapping("update.do")
	public String update(UserInfo user,Model model,HttpServletRequest request){
		try{
			System.out.println(user);
			userservice.update(user);
		}catch(Exception e){
			e.getStackTrace();
			model.addAttribute("errorinfo","角色修改失败");
		}
		return list(null,model,request);
	}
	
	@RequestMapping("delete.do")
	public String delete(Integer[] userId,Model model,HttpServletRequest request){
		try{
			
			userservice.delete(userId);
		}catch(Exception e){
			e.printStackTrace();
			model.addAttribute("errorinfo","角色删除失败");
		}
		return list(null,model,request);
	}
	
	/**
	 * showuser:(查看用户详情页面). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 */
	@RequestMapping("showuser.do")
	public String showuser(UserInfo user,Model model){
		UserInfo userinfo=userservice.getUser(user);
		model.addAttribute("userinfo",userinfo);
		return "user/user_show";
	}
	
}

//知识注释：
/**
 *  1.1
 * @ResponseBody
	@Responsebody 注解表示该方法的返回的结果直接写入 HTTP 响应正文（ResponseBody）中，一般在异步获取数据时使用，
	通常是在使用 @RequestMapping 后，返回值通常解析为跳转路径，加上 @Responsebody 后返回结果不会被解析为跳转路径，而是直接写入HTTP 响应正文中。
	作用：
	该注解用于将Controller的方法返回的对象，通过适当的HttpMessageConverter转换为指定格式后，写入到Response对象的body数据区。
	使用时机：
	返回的数据不是html标签的页面，而是其他某种格式的数据时（如json、xml等）使用；
 */


