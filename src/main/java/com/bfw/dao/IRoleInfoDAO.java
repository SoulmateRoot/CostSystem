/**
 * Project Name:costone
 * File Name:RoleInfoDao.java
 * Package Name:com.bfw.dao
 * Date:2018��5��27������2:49:04
 * Copyright (c) 2018, soulmate.leilei@qq.com All Rights Reserved.
 * ������:Soulmate.leilei
*/

package com.bfw.dao;

import java.util.List;

import javax.management.relation.Role;

import com.bfw.bean.RoleInfo;

/**
 * ClassName:RoleInfoDao <br/>
 * Function: ��ɫ��������ݷ��ʽӿ� <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2018��5��27�� ����2:49:04 <br/>
 * @author   Soulmate.leilei
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public interface IRoleInfoDAO {
	
	/**
	 * 
	 * add:(��ӽ�ɫ����). <br/>
	 * TODO(����������������������� �C ��ѡ).<br/>
	 * TODO(�����������������ִ������ �C ��ѡ).<br/>
	 * TODO(�����������������ʹ�÷��� �C ��ѡ).<br/>
	 * TODO(�����������������ע������ �C ��ѡ).<br/>
	 */
	public int add(RoleInfo info);
	
	/**
	 * 
	 * update:(�޸Ľ�ɫ����). <br/>
	 * TODO(����������������������� �C ��ѡ).<br/>
	 * TODO(�����������������ִ������ �C ��ѡ).<br/>
	 * TODO(�����������������ʹ�÷��� �C ��ѡ).<br/>
	 * TODO(�����������������ע������ �C ��ѡ).<br/>
	 */
	public int update(RoleInfo info);
	
	

	/**
	 * 
	 * list:(����������ѯ��ɫ��Ϣ�б�). <br/>
	 * TODO(����������������������� �C ��ѡ).<br/>
	 * TODO(�����������������ִ������ �C ��ѡ).<br/>
	 * TODO(�����������������ʹ�÷��� �C ��ѡ).<br/>
	 * TODO(�����������������ע������ �C ��ѡ).<br/>
	 */
	public List<RoleInfo> list(RoleInfo info);
	
	/**
	 * 
	 * getcount:(��ȡ�ܼ�¼��). <br/>
	 * TODO(����������������������� �C ��ѡ).<br/>
	 * TODO(�����������������ִ������ �C ��ѡ).<br/>
	 * TODO(�����������������ʹ�÷��� �C ��ѡ).<br/>
	 * TODO(�����������������ע������ �C ��ѡ).<br/>
	 */
	public long getcount(RoleInfo info);
	
	/**
	 * 
	 * getinfo:(����������ѯ��ɫ��Ϣ���޸�ҳ��). <br/>
	 * TODO(����������������������� �C ��ѡ).<br/>
	 * TODO(�����������������ִ������ �C ��ѡ).<br/>
	 * TODO(�����������������ʹ�÷��� �C ��ѡ).<br/>
	 * TODO(�����������������ע������ �C ��ѡ).<br/>
	 */
	public RoleInfo getinfo(RoleInfo info);

}

