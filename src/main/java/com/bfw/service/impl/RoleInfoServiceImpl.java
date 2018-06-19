/**
 * Project Name:costone
 * File Name:RoleInfoServiceImpl.java
 * Package Name:com.bfw.service.impl
 * Date:2018��5��27������3:04:15
 * Copyright (c) 2018, soulmate.leilei@qq.com All Rights Reserved.
 * ������:Soulmate.leilei
*/

package com.bfw.service.impl;

import java.util.List;

import javax.management.relation.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bfw.bean.RoleInfo;
import com.bfw.dao.IRoleInfoDAO;
import com.bfw.service.IRoleInfoService;
import com.bfw.utils.Comm;

/**
 * ClassName:RoleInfoServiceImpl <br/>
 * Function: ��ɫ����ҵ���߼�ʵ���� <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2018��5��27�� ����3:04:15 <br/>
 * @author   Soulmate.leilei
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
@Service
@Transactional
public class RoleInfoServiceImpl implements IRoleInfoService{
	
	@Autowired
	private IRoleInfoDAO roledao;
	
	/**
	 * 
	 * TODO ��ɫ������ӷ���
	 * @see com.bfw.service.IRoleInfoService#add(com.bfw.bean.RoleInfo)
	 */
	
	public void add(RoleInfo info){
		roledao.add(info);
	}

	/**
	 * 
	 * TODO �������÷�����ʵ�ֹ��ܣ���ѡ��.
	 * @see com.bfw.service.IRoleInfoService#list(com.bfw.bean.RoleInfo)
	 */
	public List<RoleInfo> list(RoleInfo info) {
		condition(info);
		return roledao.list(info);
	}

	/**
	 * 
	 * TODO �������÷�����ʵ�ֹ��ܣ���ѡ��.
	 * @see com.bfw.service.IRoleInfoService#getcount(com.bfw.bean.RoleInfo)
	 */
	public long getcount(RoleInfo info) {
		condition(info);
		return roledao.getcount(info);
	}
	
	/**
	 * 
	 * condition:(��ѯ����). <br/>
	 * TODO(����������������������� �C ��ѡ).<br/>
	 * TODO(�����������������ִ������ �C ��ѡ).<br/>
	 * TODO(�����������������ʹ�÷��� �C ��ѡ).<br/>
	 * TODO(�����������������ע������ �C ��ѡ).<br/>
	 */
	public void condition(RoleInfo info){
		if(info!=null){
			info.setRoleMark(Comm.MARK_YES);
			if(info.getRoleName()!=null &&!info.getRoleName().equals("")){
				info.setRoleName("%"+info.getRoleName()+"%");
			}
		}
		
	}
	
	/**
	 * 
	 * TODO ���ݽ�ɫ��ѯ��Ϣ.
	 * @see com.bfw.service.IRoleInfoService#getInfo(com.bfw.bean.RoleInfo)
	 */
	public RoleInfo getInfo(RoleInfo info) {
		
		return roledao.getinfo(info);
	}

	/**
	 * 
	 * TODO �޸Ľ�ɫ��Ϣ.
	 * @see com.bfw.service.IRoleInfoService#update(com.bfw.bean.RoleInfo)
	 */
	public void update(RoleInfo info) {
		roledao.update(info);
		
	}

	
	/**
	 * 
	 * TODO ���ݱ�Ž��м�ɾ��.
	 * @see com.bfw.service.IRoleInfoService#delete(java.lang.Integer[])
	 */
	public void delete(Integer[] roleId) {
		for(Integer id:roleId){
			
			RoleInfo info = new RoleInfo();
			//��ȡ��ǰid
			info.setRoleId(id);
			//�޸���Ч��ʾ
			info.setRoleMark(Comm.MARK_NO);
			//��ʵɾ���������޸�
			roledao.update(info);
		}
		
	}
	
//���β
}

