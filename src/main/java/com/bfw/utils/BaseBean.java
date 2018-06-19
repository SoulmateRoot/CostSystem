package com.bfw.utils;

/**
 * 
 * ClassName: BaseBean <br/>
 * Function:所有实体类的父类 <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2018年5月28日 下午8:26:22 <br/>
 *
 * @author Soulmate.leilei
 * @version 
 * @since JDK 1.8
 */
public class BaseBean {

	//起始记录
	private int start;
	
	//每次查询的条数
	private int length;

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
	
	
	
}
