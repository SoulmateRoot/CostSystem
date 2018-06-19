package com.bfw.utils;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bfw.bean.UserInfo;

/**
 * 
 * ClassName: LoginFilter <br/>
 * Function: ��ֹ�Ƿ���¼. <br/>
 * Reason: TODO ADD REASON(��ѡ). <br/>
 * date: 2018��6��12�� ����4:29:57 <br/>
 *
 * @author Soulmate.leilei
 * @version 
 * @since JDK 1.8
 */
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		//��ȡ response
		HttpServletResponse response=(HttpServletResponse)res;
		//��ȡrequest
		HttpServletRequest request=(HttpServletRequest)req;
		//��ȡsession
		HttpSession session=request.getSession();
		//��ȡ��ǰ�û���¼��Ϣ
		UserInfo user=(UserInfo)session.getAttribute("user");
		//��ȡ��ǰ��Ŀ�Ĺ�������
		String loginjsp = request.getContextPath()+"/login_info.jsp";
		//����IE��ַ����ַ
		StringBuffer url = request.getRequestURL();
		//System.out.println(url.toString());
		//ʹ��if�����������жϣ�
		if(user!=null){
			
			chain.doFilter(request, response);
		}else if(url.toString().contains("/login.jsp")){
			chain.doFilter(request, response);
		}else if(url.toString().contains("/login_info.jsp")){
			chain.doFilter(request, response);
		}else if(url.toString().contains("/res/")){
			chain.doFilter(request, response);
		}else if(url.toString().contains("login.do")){
			chain.doFilter(request, response);
		}else{
			response.sendRedirect(loginjsp);
		}
	
	}
	

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

}


//request.getSchema()�����ص��ǵ�ǰ����ʹ�õ�Э�飬һ��Ӧ�÷��ص���http��SSL���ص���https��
//
//request.getServerName()�����ص�ǰҳ�����ڵķ����������֣�
//
//request.getServerPort()�����ص�ǰҳ�����ڵķ�����ʹ�õĶ˿ڣ�80��
//
//request.getContextPath()�����ص�ǰҳ�����ڵ�Ӧ�õ����֡�


