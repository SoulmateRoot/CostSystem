/**
 * Project Name:costone
 * File Name:ISalaryPaymentDAO.java
 * Package Name:com.bfw.dao
 * Date:2018��6��27������3:49:33
 * Copyright (c) 2018, soulmate.leilei@qq.com All Rights Reserved.
 * ������:Soulmate.leilei
*/

package com.bfw.dao;

import java.util.List;

import com.bfw.bean.SalaryPayment;

/**
 * ClassName:ISalaryPaymentDAO <br/>
 * Function:н�� �������ݷ��ʽӿ�<br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2018��6��27�� ����3:49:33 <br/>
 * @author   Soulmate.leilei
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public interface ISalaryPaymentDAO {
	/**
	 * @Title: add  
	 * @Description: ���н�ʷ��ż�¼  �����ӿ� 
	 * @param sp      
	 * @return ����  Ӱ�������
	 * @throws
	 */
	public int add(SalaryPayment sp);
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

