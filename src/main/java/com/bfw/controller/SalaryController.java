/**
 * Project Name:costone
 * File Name:SalaryController.java
 * Package Name:com.bfw.controller
 * Date:2018��5��26������5:40:31
 * Copyright (c) 2018, soulmate.leilei@qq.com All Rights Reserved.
 * ������:Soulmate.leilei
*/

package com.bfw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ClassName:SalaryController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2018��5��26�� ����5:40:31 <br/>
 * @author   Soulmate.leilei
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
@Controller
@RequestMapping("/salary/")
public class SalaryController {
	
	/**
	 * 
	 * loadadd:(н�ʹ�����ӷ���). <br/>
	 * TODO(����������������������� �C ��ѡ).<br/>
	 * TODO(�����������������ִ������ �C ��ѡ).<br/>
	 * TODO(�����������������ʹ�÷��� �C ��ѡ).<br/>
	 * TODO(�����������������ע������ �C ��ѡ).<br/>
	 */
	@RequestMapping("loadadd.do")
	public String loadadd(){
		return "salary/salary_add";
	}
	
	/**
	 * 
	 * list:(н�ʲ�ѯ����). <br/>
	 * TODO(����������������������� �C ��ѡ).<br/>
	 * TODO(�����������������ִ������ �C ��ѡ).<br/>
	 * TODO(�����������������ʹ�÷��� �C ��ѡ).<br/>
	 * TODO(�����������������ע������ �C ��ѡ).<br/>
	 */
	@RequestMapping("list.do")
	public String list(){
		return "salary/salary_list";
	}
	

}

