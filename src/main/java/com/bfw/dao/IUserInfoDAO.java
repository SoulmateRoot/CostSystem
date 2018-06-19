/**
 * Project Name:costone
 * File Name:IUserInfoDAO.java
 * Package Name:com.bfw.dao
 * Date:2018��5��31������2:10:18
 * Copyright (c) 2018, soulmate.leilei@qq.com All Rights Reserved.
 * ������:Soulmate.leilei
*/

package com.bfw.dao;

import java.util.List;

import com.bfw.bean.UserInfo;

/**
 * ClassName:IUserInfoDAO <br/>
 * Function: �û��������ݷ��ʽӿ� <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2018��5��31�� ����2:10:18 <br/>
 * @author   Soulmate.leilei
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public interface IUserInfoDAO {
	
	/**
	 * 
	 * add:(�û���ӽӿڷ���). <br/>
	 * TODO(����������������������� �C ��ѡ).<br/>
	 * TODO(�����������������ִ������ �C ��ѡ).<br/>
	 * TODO(�����������������ʹ�÷��� �C ��ѡ).<br/>
	 * TODO(�����������������ע������ �C ��ѡ).<br/>
	 */
	public int add(UserInfo user);
	/**
	 * 
	 * @Title: update  
	 * @Description:�޸��û�
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
	 * @Description: ����������ѯ�û�
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
	 * @Description:����������ѯ�û���Ϣ  
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
	 * @Description:��ȡ�û���Ϣ�ܼ�¼�� 
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
	 * @Description: �����û��˺Ų�ѯ �û���Ϣ
	 * @param user
	 * @return      
	 * @return UserInfo    
	 * @throws
	 *
	 */
	public UserInfo login(UserInfo user);
}

