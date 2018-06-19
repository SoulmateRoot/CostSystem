/**
 * Project Name:costone
 * File Name:MenuController.java
 * Package Name:com.bfw.controller
 * Date:2018年5月22日上午10:49:56
 * Copyright (c) 2018, soulmate.leilei@qq.com All Rights Reserved.
 * 创建人:Soulmate.leilei
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
 * Date:     2018年5月22日 上午10:49:56 <br/>
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
	 * 菜单dTreeJS
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
	 * 菜单主要内容
	 * @return
	 */
	@RequestMapping("menumain.do")
	public String menumain(MenuInfo menu,Model model){
		MenuInfo info=null;
		if(menu!=null && menu.getMenuId()!=null){
			if(menu.getMenuId()==0){
				info=new MenuInfo();
				info.setMenuId(0);
				info.setMenuName("根节点");
				info.setPrentMenuId(-1);
			}else{
				info= menuservice.getInfo(menu);
			}
		}
		model.addAttribute("menu",info);
		return "menu/menu_main";
	}
	/**
	 * 菜单首页信息
	 * @param session
	 * @return
	 */
	@RequestMapping("list.do")
	public String list(){
		
		return "menu/menu_index";
	}
	
	/**
	 * 菜单顶部
	 * @return
	 */
	@RequestMapping("menutop.do")
	public String menutop(){
		return "menu/menu_top";
	}
	
	/**
	 * 加载修改添加页面
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
	 * 添加菜单信息
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
	 * 加载修改修改页面
	 * 
	 * @return
	 */
	@RequestMapping("loadupdate.do")
	public String laodupdate(MenuInfo menu, Model model) {
		// 查询所有的菜单
		List<MenuInfo> list = menuservice.list(menu);
		model.addAttribute("list", list);

		MenuInfo info = menuservice.getInfo(menu);

		model.addAttribute("menu", info);
		return "menu/menu_update";
	}

	/**
	 * 修改菜单信息
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
	 * 删除菜单信息
	 * @param info
	 * @param model
	 * @return
	 */
	@RequestMapping("delete.do")
	public String delete(MenuInfo info, Model model){
		//根据当前菜单的Id查询子菜单
		List<MenuInfo> list =menuservice.getMenuList(info.getMenuId());
		
		if(list!=null && list.size()>0){
			model.addAttribute("info", "对不起，请删除当前菜单的子菜单!");
		}else{
			try {
				
				menuservice.delete(info);
				model.addAttribute("info", "当前菜单删除成功!");
			} catch (Exception e) {
				e.printStackTrace();
				model.addAttribute("info", "对不起，删除菜单失败!");
			}
		}
		
	
		
		
		return "menu/menu_info";
	}
}
