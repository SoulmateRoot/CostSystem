/**
 * Project Name:costone
 * File Name:UserInfoServiceImpl.java
 * Package Name:com.bfw.service.impl
 * Date:2018年5月31日下午2:43:16
 * Copyright (c) 2018, soulmate.leilei@qq.com All Rights Reserved.
 * 创建人:Soulmate.leilei
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
 * Function: 业务逻辑接口实现类. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2018年5月31日 下午2:43:16 <br/>
 * @author   Soulmate.leilei
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
@Service
@Transactional
public class UserInfoServiceImpl implements IUserInfoService {
	//依赖注入，自动装配
	@Autowired
	private IUserInfoDAO userdao;
	
	
	/**
	 * 
	 * TODO 添加用户信息 业务逻辑方法.
	 * @see com.bfw.service.IUserInfoService#add(com.bfw.bean.UserInfo)
	 */
	public void add(UserInfo user) {
		userdao.add(user);
	}
	
	/**
	 * 
	 * TODO 修改用户   业务逻辑方法.
	 * @see com.bfw.service.IUserInfoService#update(com.bfw.bean.UserInfo)
	 */
	public void update(UserInfo user) {
		userdao.update(user);
	}
	/**
	 * 
	 * TODO 删除用户  业务逻辑方法.
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
	 * TODO 业务逻辑  得到根据编号得到用户信息.
	 * @see com.bfw.service.IUserInfoService#getUser(com.bfw.bean.UserInfo)
	 */
	public UserInfo getUser(UserInfo user) {
		//通过数据访问接口，返回查询出的数据
		return userdao.getUser(user);
	}
	
	
	/**
	 * 
	 * TODO 业务逻辑   查询用户.
	 * @see com.bfw.service.IUserInfoService#list(com.bfw.bean.UserInfo)
	 */
	public List<UserInfo> list(UserInfo info) {
		condition(info);
		//condition2(info);
		return userdao.list(info);
		
	}
	/**
	 * 
	 * TODO 业务逻辑  所有页数.
	 * @see com.bfw.service.IUserInfoService#getcount(com.bfw.bean.UserInfo)
	 */
	public long getcount(UserInfo info) {
		condition(info);
		return userdao.getcount(info);
	}
	
	/**
	 * 
	 * @Title: condition  
	 * @Description: 查询条件
	 * @param user      
	 * @return void    
	 * @throws
	 *
	 */
	public void condition(UserInfo user){
		//user不能为空
		if(user!=null){
			//设置标识有效
			user.setUserMark(Comm.MARK_YES);
			//判断用户名是否为空
			if(user.getUserName()!=null&&!user.getUserName().equals("")){
				user.setUserName("%"+user.getUserName()+"%");
			}
			
			if(user.getRoleName()!=null&&!user.getRoleName().equals("")){
				user.setRoleName("%"+user.getRoleName()+"%");
				}
		}
	}
	
	//根据角色进行模糊查询。。。待定
	public void condition2(RoleInfo roleinfo){
			//user不能为空
			if(roleinfo!=null){
				//设置标识有效
				roleinfo.setRoleMark(Comm.MARK_YES);
				//判断用户名是否为空
				if(roleinfo.getRoleName()!=null&&!roleinfo.getRoleName().equals("")){
				roleinfo.setRoleName("%"+roleinfo.getRoleName()+"%");
				}
			}
		}

	
	/**
	 * 
	 * TODO 业务逻辑  用户登录.
	 * @see com.bfw.service.IUserInfoService#isLogin(com.bfw.bean.UserInfo)
	 */
	public UserInfo isLogin(UserInfo user) {
		
		return userdao.login(user);
	}

	




	
//类结尾	
}




/*
 * 1、@Autowired与@Resource都可以用来装配bean. 都可以写在字段上,或写在setter方法上。
 * 2、@Autowired默认按类型装配（这个注解是属业spring的），默认情况下必须要求依赖对象必须存在，如果要允许null值，可以设置它的required属性为false，
 * 如：@Autowired(required=false) ，如果我们想使用名称装配可以结合@Qualifier注解进行使用，如下：Java代码@Autowired() 
 * @Qualifier("baseDao")    
 * 
 * 
 * 
 * 
 */

