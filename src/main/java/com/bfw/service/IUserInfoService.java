/**
 * Project Name:costone
 * File Name:IUserInfoService.java
 * Package Name:com.bfw.service
 * Date:2018年5月31日下午2:35:58
 * Copyright (c) 2018, soulmate.leilei@qq.com All Rights Reserved.
 * 创建人:Soulmate.leilei
*/

package com.bfw.service;

import java.util.List;

import com.bfw.bean.UserInfo;

/**
 * ClassName:IUserInfoService <br/>
 * Function: 用户管理业务逻辑接口. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2018年5月31日 下午2:35:58 <br/>
 * @author   Soulmate.leilei
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public interface IUserInfoService {
	
	/**
	 * @Title: add  
	 * @Description:添加用户业务逻辑方法 
	 * @param user      
	 * @return void    
	 * @throws
	 */
	public void add(UserInfo user);
	
	/**
	 * @Title: update  
	 * @Description: 修改用户业务逻辑方法  
	 * @param user      
	 * @return void    
	 * @throws
	 */
	public void update(UserInfo user);
	/**
	 * @Title: delete  
	 * @Description: 删除方法 
	 * @param userId      
	 * @return void    
	 * @throws
	 */
	public void  delete(Integer[] userId);
	
	/**
	 * @Title: getUser  
	 * @Description: 根据条件查询用户信息  
	 * @param user
	 * @return      
	 * @return UserInfo    
	 * @throws
	 */
	public UserInfo getUser(UserInfo user);
	/**
	 * @Title: list  
	 * @Description:查询用户信息 列表
	 * @param user
	 * @return      
	 * @return List<UserInfo>    
	 * @throws
	 */
	public List<UserInfo> list(UserInfo info);
	/**
	 * @Title: getcount  
	 * @Description:获取用户信息总记录数 
	 * @param user
	 * @return      
	 * @return long    
	 * @throws
	 */
	public long getcount(UserInfo info);
	
	/**
	 * 
	 * @Title: isLogin  
	 * @Description: 用户登录  
	 * @param user
	 * @return      
	 * @return UserInfo    
	 * @throws
	 *
	 */
	public UserInfo isLogin(UserInfo user);
	
	
	
}



