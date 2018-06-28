/**
 * Project Name:costone
 * File Name:ISalaryPaymentDAO.java
 * Package Name:com.bfw.dao
 * Date:2018年6月27日下午3:49:33
 * Copyright (c) 2018, soulmate.leilei@qq.com All Rights Reserved.
 * 创建人:Soulmate.leilei
*/

package com.bfw.dao;

import java.util.List;

import com.bfw.bean.SalaryPayment;

/**
 * ClassName:ISalaryPaymentDAO <br/>
 * Function:薪资 管理数据访问接口<br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2018年6月27日 下午3:49:33 <br/>
 * @author   Soulmate.leilei
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public interface ISalaryPaymentDAO {
	/**
	 * @Title: add  
	 * @Description: 添加薪资发放记录  方法接口 
	 * @param sp      
	 * @return 返回  影响的行数
	 * @throws
	 */
	public int add(SalaryPayment sp);
	/**
	 * @Title: list  
	 * @Description: 查询薪资发放记录
	 * @param sp
	 * @return      
	 * @return List<SalaryPayment>    
	 * @throws
	 */
	public List<SalaryPayment>list (SalaryPayment sp);
	/**
	 * @Title: getcount  
	 * @Description: 查询总数
	 * @param sp
	 * @return      
	 * @return long    
	 * @throws
	 */
	public long getcount(SalaryPayment sp);
}

