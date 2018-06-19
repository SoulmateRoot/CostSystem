/**
 * Project Name:costone
 * File Name:IMenuInfoDAO.java
 * Package Name:com.bfw.dao
 * Date:2018年6月4日上午6:37:35
 * Copyright (c) 2018, soulmate.leilei@qq.com All Rights Reserved.
 * 创建人:Soulmate.leilei
*/

package com.bfw.dao;

import java.util.List;

import com.bfw.bean.MenuInfo;

/**
 * ClassName:IMenuInfoDAO <br/>
 * Function: 菜单管理数据访问接口 <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2018年6月4日 上午6:37:35 <br/>
 * @author   Soulmate.leilei
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public interface IMenuInfoDAO {
	
	/**
	 * 查询菜单信息
	 * @param menu
	 * @return
	 */
	public List<MenuInfo> list(MenuInfo menu);
	
	/**
	 * @Title: getInfo  
	 * @Description: 根据条件查询菜单信息  
	 * @param info
	 * @return      
	 * @return MenuInfo    
	 * @throws
	 */
	public MenuInfo getInfo(MenuInfo info);
	
	/**
	 * 
	 * @Title: add  
	 * @Description: 添加菜单 
	 * @param info
	 * @return      
	 * @return int    
	 * @throws
	 *
	 */
	public int add(MenuInfo info);
	
	/**
	 * 修改菜单信息
	 * @param info
	 * @return
	 */
	public int update(MenuInfo info);
	
	/**
	 * 根据编号删除菜单信息
	 * @param info
	 * @return
	 */
	public int delete(MenuInfo info);
	
	/**
	 * 根据菜单父级编号查询菜单信息
	 * @param prentMenuId
	 * @return
	 */
	public List<MenuInfo> getMenuList(Integer prentMenuId);
}


