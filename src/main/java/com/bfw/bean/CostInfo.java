/**
 * Project Name:costone
 * File Name:CostInfo.java
 * Package Name:com.bfw.bean
 * Date:2018年6月12日下午10:34:01
 * Copyright (c) 2018, soulmate.leilei@qq.com All Rights Reserved.
 * 创建人:Soulmate.leilei
*/

package com.bfw.bean;

import com.bfw.utils.BaseBean;

/**
 * ClassName:CostInfo <br/>
 * Function: 费用管理实体类 <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2018年6月12日 下午10:34:01 <br/>
 * @author   Soulmate.leilei
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public class CostInfo extends BaseBean{ 
	//费用编号
	private Integer costId;
	//费用名称
	private String costName;
	//费用描述
	private String costDesc;
	//费标标识
	private String costMark;
	
	public Integer getCostId() {
		return costId;
	}
	public void setCostId(Integer costId) {
		this.costId = costId;
	}
	public String getCostName() {
		return costName;
	}
	public void setCostName(String costName) {
		this.costName = costName;
	}
	public String getCostDesc() {
		return costDesc;
	}
	public void setCostDesc(String costDesc) {
		this.costDesc = costDesc;
	}
	public String getCostMark() {
		return costMark;
	}
	public void setCostMark(String costMark) {
		this.costMark = costMark;
	}
	
	
	

}

