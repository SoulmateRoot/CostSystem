/**
 * Project Name:costone
 * File Name:IUserInfoService.java
 * Package Name:com.bfw.service
 * Date:2018��5��31������2:35:58
 * Copyright (c) 2018, soulmate.leilei@qq.com All Rights Reserved.
 * ������:Soulmate.leilei
*/

package com.bfw.service;

import java.util.List;

import com.bfw.bean.UserInfo;

/**
 * ClassName:IUserInfoService <br/>
 * Function: �û�����ҵ���߼��ӿ�. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2018��5��31�� ����2:35:58 <br/>
 * @author   Soulmate.leilei
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public interface IUserInfoService {
	
	/**
	 * @Title: add  
	 * @Description:����û�ҵ���߼����� 
	 * @param user      
	 * @return void    
	 * @throws
	 */
	public void add(UserInfo user);
	
	/**
	 * @Title: update  
	 * @Description: �޸��û�ҵ���߼�����  
	 * @param user      
	 * @return void    
	 * @throws
	 */
	public void update(UserInfo user);
	/**
	 * @Title: delete  
	 * @Description: ɾ������ 
	 * @param userId      
	 * @return void    
	 * @throws
	 */
	public void  delete(Integer[] userId);
	
	/**
	 * @Title: getUser  
	 * @Description: ����������ѯ�û���Ϣ  
	 * @param user
	 * @return      
	 * @return UserInfo    
	 * @throws
	 */
	public UserInfo getUser(UserInfo user);
	/**
	 * @Title: list  
	 * @Description:��ѯ�û���Ϣ �б�
	 * @param user
	 * @return      
	 * @return List<UserInfo>    
	 * @throws
	 */
	public List<UserInfo> list(UserInfo info);
	/**
	 * @Title: getcount  
	 * @Description:��ȡ�û���Ϣ�ܼ�¼�� 
	 * @param user
	 * @return      
	 * @return long    
	 * @throws
	 */
	public long getcount(UserInfo info);
	
	/**
	 * 
	 * @Title: isLogin  
	 * @Description: �û���¼  
	 * @param user
	 * @return      
	 * @return UserInfo    
	 * @throws
	 *
	 */
	public UserInfo isLogin(UserInfo user);
	
	
	
}



