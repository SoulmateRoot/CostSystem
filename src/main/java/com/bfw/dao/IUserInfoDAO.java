/**
 * Project Name:costone
 * File Name:IUserInfoDAO.java
 * Package Name:com.bfw.dao
 * Date:2018年5月31日下午2:10:18
 * Copyright (c) 2018, soulmate.leilei@qq.com All Rights Reserved.
 * 创建人:Soulmate.leilei
*/

package com.bfw.dao;

import java.util.List;

import com.bfw.bean.UserInfo;

/**
 * ClassName:IUserInfoDAO <br/>
 * Function: 用户管理数据访问接口 <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2018年5月31日 下午2:10:18 <br/>
 * @author   Soulmate.leilei
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public interface IUserInfoDAO {
	
	/**
	 * 
	 * add:(用户添加接口方法). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 */
	public int add(UserInfo user);
	/**
	 * 
	 * @Title: update  
	 * @Description:修改用户
	 * @param user
	 * @return      
	 * @return int    
	 * @throws
	 *
	 */
	public int update(UserInfo user);
	
	
	
	/**
	 * 
	 * @Title: getUser  
	 * @Description: 根据条件查询用户
	 * @param user
	 * @return      
	 * @return UserInfo    
	 * @throws
	 *
	 */
	public UserInfo getUser(UserInfo user);
	
	/**
	 * 
	 * @Title: list  
	 * @Description:根据条件查询用户信息  
	 * @param user
	 * @return      
	 * @return List<UserInfo>    
	 * @throws
	 *
	 */
	public List<UserInfo> list(UserInfo user);
	/**
	 * 
	 * @Title: getcount  
	 * @Description:获取用户信息总记录数 
	 * @param user
	 * @return      
	 * @return long    
	 * @throws
	 *
	 */
	public long getcount(UserInfo user);
	
	/**
	 * 
	 * @Title: isLogin  
	 * @Description: 根据用户账号查询 用户信息
	 * @param user
	 * @return      
	 * @return UserInfo    
	 * @throws
	 *
	 */
	public UserInfo login(UserInfo user);
}

