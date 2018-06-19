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
 * Function: 防止非法登录. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2018年6月12日 下午4:29:57 <br/>
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
		//获取 response
		HttpServletResponse response=(HttpServletResponse)res;
		//获取request
		HttpServletRequest request=(HttpServletRequest)req;
		//获取session
		HttpSession session=request.getSession();
		//获取当前用户登录信息
		UserInfo user=(UserInfo)session.getAttribute("user");
		//获取当前项目的工程名称
		String loginjsp = request.getContextPath()+"/login_info.jsp";
		//返回IE地址栏地址
		StringBuffer url = request.getRequestURL();
		//System.out.println(url.toString());
		//使用if语句进行条件判断，
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


//request.getSchema()，返回的是当前连接使用的协议，一般应用返回的是http、SSL返回的是https；
//
//request.getServerName()，返回当前页面所在的服务器的名字；
//
//request.getServerPort()，返回当前页面所在的服务器使用的端口，80；
//
//request.getContextPath()，返回当前页面所在的应用的名字。


