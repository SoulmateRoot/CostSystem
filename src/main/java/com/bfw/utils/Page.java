package com.bfw.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * ClassName: Page <br/>
 * Function:�û���ҳ���ļ� <br/>
 * Reason: TODO ADD REASON(��ѡ). <br/>
 * date: 2018��5��29�� ����9:47:49 <br/>
 *
 * @author Soulmate.leilei
 * @version 
 * @since JDK 1.8
 */
public class Page {
	/**
	 * ��ʼ��¼��
	 */
	private int pageNo = 0;
	
	
	/**
	 * ÿҳ��ʾ��¼��
	 */
	public final static  int PAGE_NUM_BIG = 10;
	
	/**
	 * ��ʼ����ҳ��Ϣ
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
