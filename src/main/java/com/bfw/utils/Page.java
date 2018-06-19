package com.bfw.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * ClassName: Page <br/>
 * Function:用户分页类文件 <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2018年5月29日 上午9:47:49 <br/>
 *
 * @author Soulmate.leilei
 * @version 
 * @since JDK 1.8
 */
public class Page {
	/**
	 * 起始记录数
	 */
	private int pageNo = 0;
	
	
	/**
	 * 每页显示记录数
	 */
	public final static  int PAGE_NUM_BIG = 10;
	
	/**
	 * 初始化分页信息
	 */
	public void initPage(HttpServletRequest request){
		String page_str = request.getParameter("pager.offset");
		if(page_str!=null && !page_str.equals("")){
			pageNo = Integer.parseInt(page_str);
		}
	}


	public int getPageNo() {
		return pageNo;
	}


	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}





	public static int getPageNumBig() {
		return PAGE_NUM_BIG;
	}
}
