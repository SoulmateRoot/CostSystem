/**
 * Project Name:costone
 * File Name:MenuInfo.java
 * Package Name:com.bfw.bean
 * Date:2018��5��22������2:31:21
 * Copyright (c) 2018, soulmate.leilei@qq.com All Rights Reserved.
 * ������:Soulmate.leilei
*/

package com.bfw.bean;
/**
 * ClassName:MenuInfo <br/>
 * Function: �˵�����ʵ���� <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2018��5��22�� ����2:31:21 <br/>
 * @author   Soulmate.leilei
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public class MenuInfo {

	/**
	 * �˵����
	 */
	private Integer menuId;
	
	/**
	 * �˵��ĸ���id
	 */
	private Integer prentMenuId;
	
	/**
	 * �����˵�����
	 */
	private String prentName;
	
	/**
	 * �˵�����
	 */
	private String menuName;
	
	/**
	 * �˵�URL��ַ
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
