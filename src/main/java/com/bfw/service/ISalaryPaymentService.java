/**
 * Project Name:costone
 * File Name:ISalaryPaymentService.java
 * Package Name:com.bfw.service
 * Date:2018��6��27������4:04:19
 * Copyright (c) 2018, soulmate.leilei@qq.com All Rights Reserved.
 * ������:Soulmate.leilei
*/

package com.bfw.service;

import java.io.InputStream;
import java.util.List;

import com.bfw.bean.SalaryPayment;

/**
 * ClassName:ISalaryPaymentService <br/>
 * Function: н�ʷ��ŵ�ҵ���߼��ӿ� <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2018��6��27�� ����4:04:19 <br/>
 * @author   Soulmate.leilei
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public interface ISalaryPaymentService {
	/**
	 * @Title: add  
	 * @Description:н�����  ҵ���߼����� 
	 * @param sp      
	 * @return void    
	 * @throws
	 */
	public void add(SalaryPayment sp);
	/**
	 * @throws Exception 
	 * @Title: BatchAdd  
	 * @Description:����н�ʼ�¼����������� 
	 * @param sp      
	 * @return void    
	 * @throws
	 */
	public void BatchAdd(InputStream is) throws Exception;
	/**
	 * @Title: list  
	 * @Description: ��ѯн�ʷ��ż�¼
	 * @param sp
	 * @return      
	 * @return List<SalaryPayment>    
	 * @throws
	 */
	public List<SalaryPayment>list (SalaryPayment sp);
	/**
	 * @Title: getcount  
	 * @Description: ��ѯ����
	 * @param sp
	 * @return      
	 * @return long    
	 * @throws
	 */
	public long getcount(SalaryPayment sp);
	
	
	
}

