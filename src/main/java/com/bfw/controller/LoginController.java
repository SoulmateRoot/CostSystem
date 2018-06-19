package com.bfw.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bfw.bean.UserInfo;
import com.bfw.service.IAnthorityService;
import com.bfw.service.IUserInfoService;

/**
 * 
 * ClassName: LoginController <br/>
 * Function: 用户登录 <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2018年6月12日 下午3:06:34 <br/>
 *
 * @author Soulmate.leilei
 * @version 
 * @since JDK 1.8
 */
@Controller
public class LoginController {

	/**
	 * 用户管理的业务逻辑接口
	 */
	@Autowired
	private IUserInfoService userservice;
	
	/**
	 * 权限管理的业务逻辑接口
	 */
	@Autowired
	private IAnthorityService anservice;
	
	/**
	 * 登录
	 * @return
	 */
	@RequestMapping("login.do")
	public String login(UserInfo user,HttpSession session,Model model){
		
		UserInfo userinfo = userservice.isLogin(user);
		if(userinfo!=null){
			//把当前用户存放到session中
			session.setAttribute("user", userinfo);
			//查询用户对应的菜单信息
			List<Map> list = anservice.getMenuList(userinfo.getRoleId());
			model.addAttribute("list", list);
			
			return "main/index";
		}
		
		return "redirect:login.jsp";
	}
	
	@RequestMapping("bootm.do")
	public String bootm(){
		return "main/bootm";
	}
	
	/**
	 * 退出登录
	 * @return
	 */
	@RequestMapping("exit.do")
	public String exit(){
		
		return "redirect:login.jsp";
	}
	
}
