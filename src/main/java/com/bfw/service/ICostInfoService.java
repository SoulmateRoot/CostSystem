/**
 * Project Name:costone
 * File Name:ICostInfoService.java
 * Package Name:com.bfw.service
 * Date:2018��6��12������10:52:51
 * Copyright (c) 2018, soulmate.leilei@qq.com All Rights Reserved.
 * ������:Soulmate.leilei
*/

package com.bfw.service;

import java.util.List;

import com.bfw.bean.CostInfo;

/**
 * ClassName:ICostInfoService <br/>
 * Function: ���ù���  ҵ���߼��ӿ�. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2018��6��12�� ����10:52:51 <br/>
 * @author   Soulmate.leilei
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public interface ICostInfoService {

	/**
	 * @Title: add  
	 * @Description: ������ӷ���  
	 * @param info
	 * @return      
	 * @return int    
	 * @throws
	 */
	public void add(CostInfo info);
	
	/**
	 * @Title: list  
	 * @Description: ��ѯ�����б� 
	 * @param info
	 * @return      
	 * @return List<CostInfo>    
	 * @throws
	 */
	public List<CostInfo> list(CostInfo info);
	/**
	 * @Title: getcount  
	 * @Description: ��ҳ�� 
	 * @param info
	 * @return ����ֵ Ϊlong,�����ͷ�ֹҳ��̫��
	 * @return long    
	 * @throws
	 */
	public long getcount(CostInfo info);
	/**
	 * @Title: getinfo  
	 * @Description: ���� �޸ķ���ҳ��
	 * @param info
	 * @return   FK_Reference_3	menu_id	cost	menu_info	menu_id	RESTRICT	RESTRICT	   
	 * @return CostInfo    
	 * @throws
	 */
	public CostInfo getinfo(CostInfo info);
	/**
	 * @Title: update  
	 * @Description: �޸ķ�����Ϣ 
	 * @param info      
	 * @return void    
	 * @throws
	 */
	public void update(CostInfo info);
	/**
	 * 
	 * @Title: delete  
	 * @Description: ����ɾ��ҵ���߼����� 
	 * @param costid      
	 * @return void    
	 * @throws
	 *
	 */
	public void delete(Integer[] costIds);
}


