/**
 * Project Name:costone
 * File Name:RoleController.java
 * Package Name:com.bfw.controller
 * Date:2018��5��20������3:36:11
 * Copyright (c) 2018, soulmate.leilei@qq.com All Rights Reserved.
 * ������:Soulmate.leilei
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
 * Function:��ɫ��������� <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2018��5��20�� ����3:36:11 <br/>
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
	 * list:(��ѯ��ɫ��Ϣ�б�). <br/>
	 * TODO(����������������������� �C ��ѡ).<br/>
	 * TODO(ǰ��ҳ�洫�����󣬾���ǰ�˿��������ÿ�������ѯ��֮��Ӧ�ķ���).<br/>
	 * TODO(�����������������ʹ�÷��� �C ��ѡ).<br/>
	 * TODO(�����������������ע������ �C ��ѡ).<br/>
	 */
	
	@RequestMapping("list.do")
	public String list(RoleInfo info,Model model,HttpServletRequest request){
		
		if(info==null){
			info = new RoleInfo();
		}
		//��ҳ��Ϣ
		this.initPage(request);
		//��ʼ��¼
		info.setStart(this.getPageNo());
		//ÿҳ��ʾ��¼��
		info.setLength(PAGE_NUM_BIG);
		model.addAttribute("list", roleservice.list(info));
		//�ܼ�¼��
		model.addAttribute("total", roleservice.getcount(info));
		return "role/role_list";
	}
	
	/**
	 * 
	 * loadAdd:(��ӽ�ɫ��תҳ��). <br/>
	 * TODO(����������������������� �C ��ѡ).<br/>
	 * TODO(�����������������ִ������ �C ��ѡ).<br/>
	 * TODO(�����������������ʹ�÷��� �C ��ѡ).<br/>
	 * TODO(�����������������ע������ �C ��ѡ).<br/>
	 */
	@RequestMapping("loadadd.do")
	public String loadAdd(){
		return "role/role_add";
		
	}
	/**
	 * 
	 * add:(��ӽ�ɫ����). <br/>
	 * TODO(����������������������� �C ��ѡ).<br/>
	 * TODO(�����������������ִ������ �C ��ѡ).<br/>
	 * TODO(�����������������ʹ�÷��� �C ��ѡ).<br/>
	 * TODO(�����������������ע������ �C ��ѡ).<br/>
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
			model.addAttribute("errorinfo","��ɫ���ʧ��");
			e.printStackTrace();
		}
		info=null;
		return list(info,model,request);
		
	}
	
	/**
	 * 
	 * loadUpdate:(��ת�޸�ҳ�������). <br/>
	 * TODO(����������������������� �C ��ѡ).<br/>
	 * TODO(�����������������ִ������ �C ��ѡ).<br/>
	 * TODO(�����������������ʹ�÷��� �C ��ѡ).<br/>
	 * TODO(�����������������ע������ �C ��ѡ).<br/>
	 */
	@RequestMapping("loadupdate.do")
	public String loadUpdate(RoleInfo info,Model model){
		//��ѯ��ɫ��Ϣ ����һ����������Ϊjspҳ�� jstl foreachѭ������
		model.addAttribute("role",roleservice.getInfo(info));
		return "role/role_update";
	}
	
	/**
	 * update:(��ɫ�޸�ҳ�� ). <br/>
	 * TODO(����������������������� �C ��ѡ).<br/>
	 * TODO(�����������������ִ������ �C ��ѡ).<br/>
	 * TODO(�����������������ʹ�÷��� �C ��ѡ).<br/>
	 * TODO(�����������������ע������ �C ��ѡ).<br/>
	 */
	@RequestMapping("update.do")
	public String update(RoleInfo info,Model model,HttpServletRequest request){
		try{
			roleservice.update(info);
		}catch(Exception e){
			e.printStackTrace();
			model.addAttribute("errorinfo","��ɫ�޸�ʧ��");
		}
		
		
		return list(null,model,request);
	}
	
	/**
	 * 
	 * delete:(ɾ������). <br/>
	 * TODO(����������������������� �C ��ѡ).<br/>
	 * TODO(�����������������ִ������ �C ��ѡ).<br/>
	 * TODO(�����������������ʹ�÷��� �C ��ѡ).<br/>
	 * TODO(�����������������ע������ �C ��ѡ).<br/>
	 */
	@RequestMapping("delete.do")
	public String delete(Integer[] roleId,Model model,HttpServletRequest request){
		try{
			roleservice.delete(roleId);
		}catch(Exception e){
			e.printStackTrace();
			model.addAttribute("errorinfo","��ɫɾ��ʧ��");
		}
		
		
		return list(null,model,request);
	}
	
	
	
	
	
	
}




/**
 * 
 * ==�����ڡ�equals����ͬ����������һ�����ˣ�ֻ��˵������ͬ(equals)�����ǲ�������������һ���ˡ�
 * ��ֻҪ��סequals��==�Ͳ��ü��ˡ�¥�������һ�¡�
 * ----------------------------------------------------------------
 * ��������������
 * 1.==���ж�����������ʵ���ǲ���ָ��ͬһ���ڴ�ռ�   
 *  equals���ж�����������ʵ����ָ����ڴ�ռ��ֵ�ǲ�����ͬ 
 *  2.==��ָ���ڴ��ַ���бȽ�    equals()�Ƕ��ַ��������ݽ��бȽ�
 *  3.==ָ�����Ƿ���ͬ    equals()ָ����ֵ�Ƿ���ͬ

 * 
 */
