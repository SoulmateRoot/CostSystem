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
 * Function: �û���¼ <br/>
 * Reason: TODO ADD REASON(��ѡ). <br/>
 * date: 2018��6��12�� ����3:06:34 <br/>
 *
 * @author Soulmate.leilei
 * @version 
 * @since JDK 1.8
 */
@Controller
public class LoginController {

	/**
	 * �û������ҵ���߼��ӿ�
	 */
	@Autowired
	private IUserInfoService userservice;
	
	/**
	 * Ȩ�޹����ҵ���߼��ӿ�
	 */
	@Autowired
	private IAnthorityService anservice;
	
	/**
	 * ��¼
	 * @return
	 */
	@RequestMapping("login.do")
	public String login(UserInfo user,HttpSession session,Model model){
		
		UserInfo userinfo = userservice.isLogin(user);
		if(userinfo!=null){
			//�ѵ�ǰ�û���ŵ�session��
			session.setAttribute("user", userinfo);
			//��ѯ�û���Ӧ�Ĳ˵���Ϣ
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
	 * �˳���¼
	 * @return
	 */
	@RequestMapping("exit.do")
	public String exit(){
		
		return "redirect:login.jsp";
	}
	
}
