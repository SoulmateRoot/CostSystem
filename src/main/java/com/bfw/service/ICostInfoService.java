/**
 * Project Name:costone
 * File Name:ICostInfoService.java
 * Package Name:com.bfw.service
 * Date:2018年6月12日下午10:52:51
 * Copyright (c) 2018, soulmate.leilei@qq.com All Rights Reserved.
 * 创建人:Soulmate.leilei
*/

package com.bfw.service;

import java.util.List;

import com.bfw.bean.CostInfo;

/**
 * ClassName:ICostInfoService <br/>
 * Function: 费用管理  业务逻辑接口. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2018年6月12日 下午10:52:51 <br/>
 * @author   Soulmate.leilei
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public interface ICostInfoService {

	/**
	 * @Title: add  
	 * @Description: 费用添加方法  
	 * @param info
	 * @return      
	 * @return int    
	 * @throws
	 */
	public void add(CostInfo info);
	
	/**
	 * @Title: list  
	 * @Description: 查询费用列表 
	 * @param info
	 * @return      
	 * @return List<CostInfo>    
	 * @throws
	 */
	public List<CostInfo> list(CostInfo info);
	/**
	 * @Title: getcount  
	 * @Description: 总页数 
	 * @param info
	 * @return 返回值 为long,长类型防止页数太多
	 * @return long    
	 * @throws
	 */
	public long getcount(CostInfo info);
	/**
	 * @Title: getinfo  
	 * @Description: 加载 修改费用页面
	 * @param info
	 * @return   FK_Reference_3	menu_id	cost	menu_info	menu_id	RESTRICT	RESTRICT	   
	 * @return CostInfo    
	 * @throws
	 */
	public CostInfo getinfo(CostInfo info);
	/**
	 * @Title: update  
	 * @Description: 修改费用信息 
	 * @param info      
	 * @return void    
	 * @throws
	 */
	public void update(CostInfo info);
	/**
	 * 
	 * @Title: delete  
	 * @Description: 费用删除业务逻辑方法 
	 * @param costid      
	 * @return void    
	 * @throws
	 *
	 */
	public void delete(Integer[] costIds);
}


