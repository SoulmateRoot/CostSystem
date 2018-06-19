/**
 * Project Name:costone
 * File Name:SalaryController.java
 * Package Name:com.bfw.controller
 * Date:2018年5月26日下午5:40:31
 * Copyright (c) 2018, soulmate.leilei@qq.com All Rights Reserved.
 * 创建人:Soulmate.leilei
*/

package com.bfw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ClassName:SalaryController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2018年5月26日 下午5:40:31 <br/>
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
	 * loadadd:(薪资管理添加方法). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 */
	@RequestMapping("loadadd.do")
	public String loadadd(){
		return "salary/salary_add";
	}
	
	/**
	 * 
	 * list:(薪资查询方法). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 */
	@RequestMapping("list.do")
	public String list(){
		return "salary/salary_list";
	}
	

}

