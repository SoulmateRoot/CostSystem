/**
 * Project Name:costone
 * File Name:MenuController.java
 * Package Name:com.bfw.controller
 * Date:2018��5��22������10:49:56
 * Copyright (c) 2018, soulmate.leilei@qq.com All Rights Reserved.
 * ������:Soulmate.leilei
*/

package com.bfw.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bfw.bean.MenuInfo;
import com.bfw.service.IMenuInfoService;

/**
 * ClassName:MenuController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2018��5��22�� ����10:49:56 <br/>
 * @author   Soulmate.leilei
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
@Controller
@RequestMapping("/menu/")
public class MenuController {
	@Autowired
	private IMenuInfoService menuservice;
	

	/**
	 * �˵�dTreeJS
	 * @return
	 */
	@RequestMapping("menuleft.do")
	public String menuleft(Model model,MenuInfo info){
		
		List<MenuInfo> list = menuservice.list(info);
		
		if(list!=null && list.size()>0){
			for(MenuInfo men:list){
				if(men.getPrentMenuId()==null){
					men.setPrentMenuId(0);
				}
			}
		}
		
		model.addAttribute("list", list);
		
		return "menu/menu_left";
	}
	
	
	/**
	 * �˵���Ҫ����
	 * @return
	 */
	@RequestMapping("menumain.do")
	public String menumain(MenuInfo menu,Model model){
		MenuInfo info=null;
		if(menu!=null && menu.getMenuId()!=null){
			if(menu.getMenuId()==0){
				info=new MenuInfo();
				info.setMenuId(0);
				info.setMenuName("���ڵ�");
				info.setPrentMenuId(-1);
			}else{
				info= menuservice.getInfo(menu);
			}
		}
		model.addAttribute("menu",info);
		return "menu/menu_main";
	}
	/**
	 * �˵���ҳ��Ϣ
	 * @param session
	 * @return
	 */
	@RequestMapping("list.do")
	public String list(){
		
		return "menu/menu_index";
	}
	
	/**
	 * �˵�����
	 * @return
	 */
	@RequestMapping("menutop.do")
	public String menutop(){
		return "menu/menu_top";
	}
	
	/**
	 * �����޸����ҳ��
	 * 
	 * @return
	 */
	@RequestMapping("loadadd.do")
	public String laodadd(MenuInfo info, Model model) {

		List<MenuInfo> list = menuservice.list(info);

		model.addAttribute("list", list);

		model.addAttribute("menu", info);

		return "menu/menu_add";
	}

	/**
	 * ��Ӳ˵���Ϣ
	 * 
	 * @param info
	 * @param model
	 * @return
	 */
	@RequestMapping("add.do")
	public String add(MenuInfo info, Model model) {

		try {
			menuservice.add(info);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "menu/menu_info";
	}

	
	/**
	 * �����޸��޸�ҳ��
	 * 
	 * @return
	 */
	@RequestMapping("loadupdate.do")
	public String laodupdate(MenuInfo menu, Model model) {
		// ��ѯ���еĲ˵�
		List<MenuInfo> list = menuservice.list(menu);
		model.addAttribute("list", list);

		MenuInfo info = menuservice.getInfo(menu);

		model.addAttribute("menu", info);
		return "menu/menu_update";
	}

	/**
	 * �޸Ĳ˵���Ϣ
	 * 
	 * @param info
	 * @param model
	 * @return
	 */
	@RequestMapping("update.do")
	public String update(MenuInfo info, Model model) {

		try {

			menuservice.update(info);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "menu/menu_info";
	}
	
	/**
	 * ɾ���˵���Ϣ
	 * @param info
	 * @param model
	 * @return
	 */
	@RequestMapping("delete.do")
	public String delete(MenuInfo info, Model model){
		//���ݵ�ǰ�˵���Id��ѯ�Ӳ˵�
		List<MenuInfo> list =menuservice.getMenuList(info.getMenuId());
		
		if(list!=null && list.size()>0){
			model.addAttribute("info", "�Բ�����ɾ����ǰ�˵����Ӳ˵�!");
		}else{
			try {
				
				menuservice.delete(info);
				model.addAttribute("info", "��ǰ�˵�ɾ���ɹ�!");
			} catch (Exception e) {
				e.printStackTrace();
				model.addAttribute("info", "�Բ���ɾ���˵�ʧ��!");
			}
		}
		
	
		
		
		return "menu/menu_info";
	}
}
