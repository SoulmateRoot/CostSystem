/**
 * Project Name:costone
 * File Name:IMenuInfoServiceImpl.java
 * Package Name:IMenuInfoService
 * Date:2018��6��4������8:57:43
 * Copyright (c) 2018, soulmate.leilei@qq.com All Rights Reserved.
 * ������:Soulmate.leilei
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
 * Function: �˵�����ҵ���߼�ʵ���� <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2018��6��4�� ����8:57:43 <br/>
 * @author   Soulmate.leilei
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
@Service
@Transactional
public class MenuInfoServiceImpl implements IMenuInfoService {
	//����ע��
	@Autowired
	private IMenuInfoDAO menudao;
	
	/**
	 * 
	 * TODO ��ѯ�˵�.
	 * @see com.bfw.service.IMenuInfoService#list(com.bfw.bean.MenuInfo)
	 */
	public List<MenuInfo> list(MenuInfo info) {
		// TODO Auto-generated method stub
		return menudao.list(info);
	}

	/**
	 * 
	 * TODO ���ҳ��  ��ѯ���в˵���.
	 * @see com.bfw.service.IMenuInfoService#getInfo(com.bfw.bean.MenuInfo)
	 */
	public MenuInfo getInfo(MenuInfo info) {
		
		// TODO Auto-generated method stub
		return menudao.getInfo(info);
	}

	/**
	 * 
	 * TODO ��Ӳ˵�
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
