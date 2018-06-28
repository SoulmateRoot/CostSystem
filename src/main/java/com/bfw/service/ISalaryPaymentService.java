/**
 * Project Name:costone
 * File Name:ISalaryPaymentService.java
 * Package Name:com.bfw.service
 * Date:2018年6月27日下午4:04:19
 * Copyright (c) 2018, soulmate.leilei@qq.com All Rights Reserved.
 * 创建人:Soulmate.leilei
*/

package com.bfw.service;

import java.io.InputStream;
import java.util.List;

import com.bfw.bean.SalaryPayment;

/**
 * ClassName:ISalaryPaymentService <br/>
 * Function: 薪资发放的业务逻辑接口 <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2018年6月27日 下午4:04:19 <br/>
 * @author   Soulmate.leilei
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public interface ISalaryPaymentService {
	/**
	 * @Title: add  
	 * @Description:薪资添加  业务逻辑方法 
	 * @param sp      
	 * @return void    
	 * @throws
	 */
	public void add(SalaryPayment sp);
	/**
	 * @throws Exception 
	 * @Title: BatchAdd  
	 * @Description:导入薪资记录进行批量添加 
	 * @param sp      
	 * @return void    
	 * @throws
	 */
	public void BatchAdd(InputStream is) throws Exception;
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

