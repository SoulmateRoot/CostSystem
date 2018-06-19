/**
 * Project Name:costone
 * File Name:UserController.java
 * Package Name:com.bfw.controller
 * Date:2018��5��21������9:29:40
 * Copyright (c) 2018, soulmate.leilei@qq.com All Rights Reserved.
 * ������:Soulmate.leilei
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
 * Function: �û���������� <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2018��5��21�� ����9:29:40 <br/>
 * @author   Soulmate.leilei
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
@Controller
@RequestMapping("/user/")
public class UserController extends Page{
	//�û�ҵ���߼� ����ע��
	@Autowired
	private IUserInfoService userservice;
	//��ɫҵ���߼� ����ע��
	@Autowired
	private IRoleInfoService roleservice;
	
	
	/**
	 * @Title: list  
	 * @Description:��ѯ�û���Ϣ
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
		//��ҳ��Ϣ
		this.initPage(request);
		//������ʼ��¼
		info.setStart(this.getPageNo());
		//ÿҳ��ʾ��¼��
		info.setLength(PAGE_NUM_BIG);
		//�õ�list����,ʹ��ҵ���߼���list�ӿڷ���
		model.addAttribute("list" ,userservice.list(info));
		//�ܼ�¼����ʹ��ҵ���߼���getcount����
		model.addAttribute("total",userservice.getcount(info));
		return "user/user_list";
	}
	
	/**
	 * @Title: loadadd  
	 * @Description: �����û����ҳ�� ͬʱ�õ����н�ɫ��Ϣ 
	 * @param model
	 * @return      
	 * @return String    
	 * @throws
	 *
	 */
	@RequestMapping("loadadd.do")
	public String loadadd(Model model){
		//ʵ����ʵ����
		RoleInfo info = new RoleInfo();
		//����ʵ������ʼҳ���ԣ���ֵΪ-1
		info.setStart(-1);
		//����list���飬����service�㷽���еõ����û����ݷ�װ��ȥ
		List<RoleInfo> list = roleservice.list(info);
		//ʹ����ͼ����
		model.addAttribute("list", list);
		//������Ӧ��ʾǰ��ҳ��
		return "user/user_add";
	}
	/**
	 * @Title: add  
	 * @Description: ����û� 
	 * @return      
	 * @return String    
	 * @throws
	 *
	 */
	@RequestMapping("add.do")
	public String add(UserInfo user,Model model,HttpServletRequest request){
		try{
			//1. ����û�Ϊ�����ڣ���newһ�����û�
			if(user == null){
				user=new UserInfo();
			}
			//2. ���ñ�ʶ��Ч
			user.setUserMark(Comm.MARK_YES);
			//3. ����service�������ݽ���
			userservice.add(user);
		}catch(Exception e){
			//������ʾ
			e.printStackTrace();
			model.addAttribute("errorinfo", "�û����ʧ��");
		}
		return list (null,model,request);
	}
	
	/**
	 * @Title: check  
	 * @Description: ��֤�ʺ��Ƿ����  
	 * @param user
	 * @return      
	 * @return String    
	 * @throws
	 *
	 */
	//��ײ�����ע��    1.1
	//produces="text/html; charset=UTF-8"
	@RequestMapping("check.do")
	@ResponseBody
	public  String check(UserInfo user){
		UserInfo userinfo =  userservice.getUser(user);
		if(userinfo!=null){
			return "�ʺ��Ѿ�������������һ�����Ű�";
		}else{
			return "ok! �ʺſ���ʹ��";
		}
		//if���ڵ�
	}
	
	/**
	 * loadupdate:(�����޸�ҳ��). <br/>
	 * TODO(����������������������� �C ��ѡ).<br/>
	 * TODO(�����������������ִ������ �C ��ѡ).<br/>
	 * TODO(�����������������ʹ�÷��� �C ��ѡ).<br/>
	 * TODO(�����������������ע������ �C ��ѡ).<br/>
	 */
	@RequestMapping("loadupdate.do")
	public String loadupdate(UserInfo user,Model model){
				//ʵ����ʵ����
				RoleInfo info = new RoleInfo();
				//����ʵ������ʼҳ���ԣ���ֵΪ-1
				info.setStart(-1);
				//����list���飬����service�㷽���еõ����û����ݷ�װ��ȥ
				List<RoleInfo> list = roleservice.list(info);
				//ʹ����ͼ����
				model.addAttribute("list", list);
		
		UserInfo userinfo=userservice.getUser(user);
		model.addAttribute("userinfo",userinfo);
		return "user/user_update";
	}
	/**
	 * @Title: update  
	 * @Description:�޸��û����� 
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
			model.addAttribute("errorinfo","��ɫ�޸�ʧ��");
		}
		return list(null,model,request);
	}
	
	@RequestMapping("delete.do")
	public String delete(Integer[] userId,Model model,HttpServletRequest request){
		try{
			
			userservice.delete(userId);
		}catch(Exception e){
			e.printStackTrace();
			model.addAttribute("errorinfo","��ɫɾ��ʧ��");
		}
		return list(null,model,request);
	}
	
	/**
	 * showuser:(�鿴�û�����ҳ��). <br/>
	 * TODO(����������������������� �C ��ѡ).<br/>
	 * TODO(�����������������ִ������ �C ��ѡ).<br/>
	 * TODO(�����������������ʹ�÷��� �C ��ѡ).<br/>
	 * TODO(�����������������ע������ �C ��ѡ).<br/>
	 */
	@RequestMapping("showuser.do")
	public String showuser(UserInfo user,Model model){
		UserInfo userinfo=userservice.getUser(user);
		model.addAttribute("userinfo",userinfo);
		return "user/user_show";
	}
	
}

//֪ʶע�ͣ�
/**
 *  1.1
 * @ResponseBody
	@Responsebody ע���ʾ�÷����ķ��صĽ��ֱ��д�� HTTP ��Ӧ���ģ�ResponseBody���У�һ�����첽��ȡ����ʱʹ�ã�
	ͨ������ʹ�� @RequestMapping �󣬷���ֵͨ������Ϊ��ת·�������� @Responsebody �󷵻ؽ�����ᱻ����Ϊ��ת·��������ֱ��д��HTTP ��Ӧ�����С�
	���ã�
	��ע�����ڽ�Controller�ķ������صĶ���ͨ���ʵ���HttpMessageConverterת��Ϊָ����ʽ��д�뵽Response�����body��������
	ʹ��ʱ����
	���ص����ݲ���html��ǩ��ҳ�棬��������ĳ�ָ�ʽ������ʱ����json��xml�ȣ�ʹ�ã�
 */


