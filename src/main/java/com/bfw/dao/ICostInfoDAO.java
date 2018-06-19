/**
 * Project Name:costone
 * File Name:ICostInfoDAO.java
 * Package Name:com.bfw.dao
 * Date:2018年6月12日下午10:40:25
 * Copyright (c) 2018, soulmate.leilei@qq.com All Rights Reserved.
 * 创建人:Soulmate.leilei
*/

package com.bfw.dao;

import java.util.List;

import com.bfw.bean.CostInfo;

/**
 * ClassName:ICostInfoDAO <br/>
 * Function: 费用管理数据访问层接口 <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2018年6月12日 下午10:40:25 <br/>
 * @author   Soulmate.leilei
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public interface ICostInfoDAO {
	
	/**
	 * @Title: add  
	 * @Description:费用信息
	 * @param info
	 * @return 返回影响的行数     
	 * @return int    
	 * @throws
	 */
	public int add(CostInfo info);
	
	/**
	 * @Title: list  
	 * @Description: 查询费用列表（模糊查询）
	 * @param info
	 * @return 返回值为 数组  
	 * @return List<CostInfo>    
	 * @throws
	 */
	public List<CostInfo> list(CostInfo info);
	/**
	 * @Title: getcount  
	 * @Description:获取  总条数
	 * @param info
	 * @return      
	 * @return long    
	 * @throws
	 */
	public long getcount(CostInfo info);
	/**
	 * @Title: getinfo  
	 * @Description: 根据条件获取费用信息，加载修改页面 
	 * @param info
	 * @return      
	 * @return CostInfo    
	 * @throws
	 */
	public CostInfo getinfo(CostInfo info);
	/**
	 * @Title: update  
	 * @Description:跟新费用信息 
	 * @param info
	 * @return      
	 * @return int    
	 * @throws
	 */
	public int update(CostInfo info);

}

