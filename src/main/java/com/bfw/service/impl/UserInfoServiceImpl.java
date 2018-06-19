/**
 * Project Name:costone
 * File Name:UserInfoServiceImpl.java
 * Package Name:com.bfw.service.impl
 * Date:2018��5��31������2:43:16
 * Copyright (c) 2018, soulmate.leilei@qq.com All Rights Reserved.
 * ������:Soulmate.leilei
*/

package com.bfw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bfw.bean.RoleInfo;
import com.bfw.bean.UserInfo;
import com.bfw.dao.IUserInfoDAO;
import com.bfw.service.IUserInfoService;
import com.bfw.utils.Comm;

/**
 * ClassName:UserInfoServiceImpl <br/>
 * Function: ҵ���߼��ӿ�ʵ����. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2018��5��31�� ����2:43:16 <br/>
 * @author   Soulmate.leilei
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
@Service
@Transactional
public class UserInfoServiceImpl implements IUserInfoService {
	//����ע�룬�Զ�װ��
	@Autowired
	private IUserInfoDAO userdao;
	
	
	/**
	 * 
	 * TODO ����û���Ϣ ҵ���߼�����.
	 * @see com.bfw.service.IUserInfoService#add(com.bfw.bean.UserInfo)
	 */
	public void add(UserInfo user) {
		userdao.add(user);
	}
	
	/**
	 * 
	 * TODO �޸��û�   ҵ���߼�����.
	 * @see com.bfw.service.IUserInfoService#update(com.bfw.bean.UserInfo)
	 */
	public void update(UserInfo user) {
		userdao.update(user);
	}
	/**
	 * 
	 * TODO ɾ���û�  ҵ���߼�����.
	 * @see com.bfw.service.IUserInfoService#delete(java.lang.Integer[])
	 */
	public void delete(Integer[] userId) {
		for(Integer id:userId){
			UserInfo user=new UserInfo();
			user.setUserId(id);
			user.setUserMark(Comm.MARK_NO);
			userdao.update(user);
		}	
		
			
		}

	/**
	 * 
	 * TODO ҵ���߼�  �õ����ݱ�ŵõ��û���Ϣ.
	 * @see com.bfw.service.IUserInfoService#getUser(com.bfw.bean.UserInfo)
	 */
	public UserInfo getUser(UserInfo user) {
		//ͨ�����ݷ��ʽӿڣ����ز�ѯ��������
		return userdao.getUser(user);
	}
	
	
	/**
	 * 
	 * TODO ҵ���߼�   ��ѯ�û�.
	 * @see com.bfw.service.IUserInfoService#list(com.bfw.bean.UserInfo)
	 */
	public List<UserInfo> list(UserInfo info) {
		condition(info);
		//condition2(info);
		return userdao.list(info);
		
	}
	/**
	 * 
	 * TODO ҵ���߼�  ����ҳ��.
	 * @see com.bfw.service.IUserInfoService#getcount(com.bfw.bean.UserInfo)
	 */
	public long getcount(UserInfo info) {
		condition(info);
		return userdao.getcount(info);
	}
	
	/**
	 * 
	 * @Title: condition  
	 * @Description: ��ѯ����
	 * @param user      
	 * @return void    
	 * @throws
	 *
	 */
	public void condition(UserInfo user){
		//user����Ϊ��
		if(user!=null){
			//���ñ�ʶ��Ч
			user.setUserMark(Comm.MARK_YES);
			//�ж��û����Ƿ�Ϊ��
			if(user.getUserName()!=null&&!user.getUserName().equals("")){
				user.setUserName("%"+user.getUserName()+"%");
			}
			
			if(user.getRoleName()!=null&&!user.getRoleName().equals("")){
				user.setRoleName("%"+user.getRoleName()+"%");
				}
		}
	}
	
	//���ݽ�ɫ����ģ����ѯ����������
	public void condition2(RoleInfo roleinfo){
			//user����Ϊ��
			if(roleinfo!=null){
				//���ñ�ʶ��Ч
				roleinfo.setRoleMark(Comm.MARK_YES);
				//�ж��û����Ƿ�Ϊ��
				if(roleinfo.getRoleName()!=null&&!roleinfo.getRoleName().equals("")){
				roleinfo.setRoleName("%"+roleinfo.getRoleName()+"%");
				}
			}
		}

	
	/**
	 * 
	 * TODO ҵ���߼�  �û���¼.
	 * @see com.bfw.service.IUserInfoService#isLogin(com.bfw.bean.UserInfo)
	 */
	public UserInfo isLogin(UserInfo user) {
		
		return userdao.login(user);
	}

	




	
//���β	
}




/*
 * 1��@Autowired��@Resource����������װ��bean. ������д���ֶ���,��д��setter�����ϡ�
 * 2��@AutowiredĬ�ϰ�����װ�䣨���ע������ҵspring�ģ���Ĭ������±���Ҫ���������������ڣ����Ҫ����nullֵ��������������required����Ϊfalse��
 * �磺@Autowired(required=false) �����������ʹ������װ����Խ��@Qualifierע�����ʹ�ã����£�Java����@Autowired() 
 * @Qualifier("baseDao")    
 * 
 * 
 * 
 * 
 */

