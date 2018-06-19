/**
 * Project Name:costone
 * File Name:RoleInfoService.java
 * Package Name:com.bfw.service
 * Date:2018��5��27������3:01:43
 * Copyright (c) 2018, soulmate.leilei@qq.com All Rights Reserved.
 * ������:Soulmate.leilei
*/

package com.bfw.service;

import java.util.List;

import javax.management.relation.Role;

import com.bfw.bean.RoleInfo;

/**
 * ClassName:RoleInfoService <br/>
 * Function:��ɫ����ҵ���߼��ӿ� <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2018��5��27�� ����3:01:43 <br/>
 * @author   Soulmate.leilei
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public interface IRoleInfoService {
	
	/**
	 * 
	 * add:(��ӽ�ɫ��Ϣ). <br/>
	 * TODO(����������������������� �C ��ѡ).<br/>
	 * TODO(�����������������ִ������ �C ��ѡ).<br/>
	 * TODO(�����������������ʹ�÷��� �C ��ѡ).<br/>
	 * TODO(�����������������ע������ �C ��ѡ).<br/>
	 */
	public void add(RoleInfo info);
	
	/**
	 * update:(�޸Ľ�ɫ��Ϣ). <br/>
	 * TODO(����������������������� �C ��ѡ).<br/>
	 * TODO(�����������������ִ������ �C ��ѡ).<br/>
	 * TODO(�����������������ʹ�÷��� �C ��ѡ).<br/>
	 * TODO(�����������������ע������ �C ��ѡ).<br/>
	 */
	public void update(RoleInfo info);
	/**
	 * delete:(���ݱ�Ž���ɾ��). <br/>
	 * TODO(����������������������� �C ��ѡ).<br/>
	 * TODO(�����������������ִ������ �C ��ѡ).<br/>
	 * TODO(�����������������ʹ�÷��� �C ��ѡ).<br/>
	 * TODO(�����������������ע������ �C ��ѡ).<br/>
	 */
	public void delete(Integer[] roleId);
	/**
	 * list:(���ݵ��̲�ѯ��ɫ��Ϣ). <br/>
	 * TODO(����������������������� �C ��ѡ).<br/>
	 * TODO(�����������������ִ������ �C ��ѡ).<br/>
	 * TODO(�����������������ʹ�÷��� �C ��ѡ).<br/>
	 * TODO(�����������������ע������ �C ��ѡ).<br/>
	 */
	public List<RoleInfo> list(RoleInfo info);
	/**
	 * getcount:(��ȡ�ܼ�¼��). <br/>
	 * TODO(����������������������� �C ��ѡ).<br/>
	 * TODO(�����������������ִ������ �C ��ѡ).<br/>
	 * TODO(�����������������ʹ�÷��� �C ��ѡ).<br/>
	 * TODO(�����������������ע������ �C ��ѡ).<br/>
	 */
	public long getcount(RoleInfo info);
	/**
	 * getInfo:(����������ѯ��ɫ��Ϣ). <br/>
	 * TODO(����������������������� �C ��ѡ).<br/>
	 * TODO(�����������������ִ������ �C ��ѡ).<br/>
	 * TODO(�����������������ʹ�÷��� �C ��ѡ).<br/>
	 * TODO(�����������������ע������ �C ��ѡ).<br/>
	 */
	public RoleInfo getInfo(RoleInfo info);

}

