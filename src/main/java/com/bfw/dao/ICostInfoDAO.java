/**
 * Project Name:costone
 * File Name:ICostInfoDAO.java
 * Package Name:com.bfw.dao
 * Date:2018��6��12������10:40:25
 * Copyright (c) 2018, soulmate.leilei@qq.com All Rights Reserved.
 * ������:Soulmate.leilei
*/

package com.bfw.dao;

import java.util.List;

import com.bfw.bean.CostInfo;

/**
 * ClassName:ICostInfoDAO <br/>
 * Function: ���ù������ݷ��ʲ�ӿ� <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2018��6��12�� ����10:40:25 <br/>
 * @author   Soulmate.leilei
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public interface ICostInfoDAO {
	
	/**
	 * @Title: add  
	 * @Description:������Ϣ
	 * @param info
	 * @return ����Ӱ�������     
	 * @return int    
	 * @throws
	 */
	public int add(CostInfo info);
	
	/**
	 * @Title: list  
	 * @Description: ��ѯ�����б�ģ����ѯ��
	 * @param info
	 * @return ����ֵΪ ����  
	 * @return List<CostInfo>    
	 * @throws
	 */
	public List<CostInfo> list(CostInfo info);
	/**
	 * @Title: getcount  
	 * @Description:��ȡ  ������
	 * @param info
	 * @return      
	 * @return long    
	 * @throws
	 */
	public long getcount(CostInfo info);
	/**
	 * @Title: getinfo  
	 * @Description: ����������ȡ������Ϣ�������޸�ҳ�� 
	 * @param info
	 * @return      
	 * @return CostInfo    
	 * @throws
	 */
	public CostInfo getinfo(CostInfo info);
	/**
	 * @Title: update  
	 * @Description:���·�����Ϣ 
	 * @param info
	 * @return      
	 * @return int    
	 * @throws
	 */
	public int update(CostInfo info);

}

