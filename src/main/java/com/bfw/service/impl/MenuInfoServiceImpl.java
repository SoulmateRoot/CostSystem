/**
 * Project Name:costone
 * File Name:IMenuInfoServiceImpl.java
 * Package Name:IMenuInfoService
 * Date:2018年6月4日上午8:57:43
 * Copyright (c) 2018, soulmate.leilei@qq.com All Rights Reserved.
 * 创建人:Soulmate.leilei
*/

package com.bfw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bfw.bean.MenuInfo;
import com.bfw.dao.IMenuInfoDAO;
import com.bfw.service.IMenuInfoService;

/**
 * ClassName:IMenuInfoServiceImpl <br/>
 * Function: 菜单管理业务逻辑实现类 <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2018年6月4日 上午8:57:43 <br/>
 * @author   Soulmate.leilei
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
@Service
@Transactional
public class MenuInfoServiceImpl implements IMenuInfoService {
	//依赖注入
	@Autowired
	private IMenuInfoDAO menudao;
	
	/**
	 * 
	 * TODO 查询菜单.
	 * @see com.bfw.service.IMenuInfoService#list(com.bfw.bean.MenuInfo)
	 */
	public List<MenuInfo> list(MenuInfo info) {
		// TODO Auto-generated method stub
		return menudao.list(info);
	}

	/**
	 * 
	 * TODO 添加页面  查询所有菜单）.
	 * @see com.bfw.service.IMenuInfoService#getInfo(com.bfw.bean.MenuInfo)
	 */
	public MenuInfo getInfo(MenuInfo info) {
		
		// TODO Auto-generated method stub
		return menudao.getInfo(info);
	}

	/**
	 * 
	 * TODO 添加菜单
	 * @see com.bfw.service.IMenuInfoService#add(com.bfw.bean.MenuInfo)
	 */
	public void add(MenuInfo info) {
		menudao.add(info);
		
	}

	public void update(MenuInfo info) {
		menudao.update(info);
		
	}

	public void delete(MenuInfo info) {
		menudao.delete(info);
	}

	public List<MenuInfo> getMenuList(Integer prentMenuId) {
		// TODO Auto-generated method stub
		return menudao.getMenuList(prentMenuId);
	}

}
