/**
 * Project Name:costone
 * File Name:MenuInfo.java
 * Package Name:com.bfw.bean
 * Date:2018年5月22日下午2:31:21
 * Copyright (c) 2018, soulmate.leilei@qq.com All Rights Reserved.
 * 创建人:Soulmate.leilei
*/

package com.bfw.bean;
/**
 * ClassName:MenuInfo <br/>
 * Function: 菜单管理实体类 <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2018年5月22日 下午2:31:21 <br/>
 * @author   Soulmate.leilei
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public class MenuInfo {

	/**
	 * 菜单编号
	 */
	private Integer menuId;
	
	/**
	 * 菜单的父级id
	 */
	private Integer prentMenuId;
	
	/**
	 * 父级菜单名称
	 */
	private String prentName;
	
	/**
	 * 菜单名称
	 */
	private String menuName;
	
	/**
	 * 菜单URL地址
	 */
	private String menuUrl;
	
	

	public String getPrentName() {
		return prentName;
	}

	public void setPrentName(String prentName) {
		this.prentName = prentName;
	}

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public Integer getPrentMenuId() {
		return prentMenuId;
	}

	public void setPrentMenuId(Integer prentMenuId) {
		this.prentMenuId = prentMenuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuUrl() {
		return menuUrl;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}
	
	
	
}
