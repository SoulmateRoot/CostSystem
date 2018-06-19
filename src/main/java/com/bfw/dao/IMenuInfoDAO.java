/**
 * Project Name:costone
 * File Name:IMenuInfoDAO.java
 * Package Name:com.bfw.dao
 * Date:2018��6��4������6:37:35
 * Copyright (c) 2018, soulmate.leilei@qq.com All Rights Reserved.
 * ������:Soulmate.leilei
*/

package com.bfw.dao;

import java.util.List;

import com.bfw.bean.MenuInfo;

/**
 * ClassName:IMenuInfoDAO <br/>
 * Function: �˵��������ݷ��ʽӿ� <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2018��6��4�� ����6:37:35 <br/>
 * @author   Soulmate.leilei
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public interface IMenuInfoDAO {
	
	/**
	 * ��ѯ�˵���Ϣ
	 * @param menu
	 * @return
	 */
	public List<MenuInfo> list(MenuInfo menu);
	
	/**
	 * @Title: getInfo  
	 * @Description: ����������ѯ�˵���Ϣ  
	 * @param info
	 * @return      
	 * @return MenuInfo    
	 * @throws
	 */
	public MenuInfo getInfo(MenuInfo info);
	
	/**
	 * 
	 * @Title: add  
	 * @Description: ��Ӳ˵� 
	 * @param info
	 * @return      
	 * @return int    
	 * @throws
	 *
	 */
	public int add(MenuInfo info);
	
	/**
	 * �޸Ĳ˵���Ϣ
	 * @param info
	 * @return
	 */
	public int update(MenuInfo info);
	
	/**
	 * ���ݱ��ɾ���˵���Ϣ
	 * @param info
	 * @return
	 */
	public int delete(MenuInfo info);
	
	/**
	 * ���ݲ˵�������Ų�ѯ�˵���Ϣ
	 * @param prentMenuId
	 * @return
	 */
	public List<MenuInfo> getMenuList(Integer prentMenuId);
}


