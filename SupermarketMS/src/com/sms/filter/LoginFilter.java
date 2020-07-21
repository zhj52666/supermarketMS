package com.sms.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/*")
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest req = (HttpServletRequest)request;
		//1.获取资源请求路径
		String uri = req.getRequestURI();
		//2.判断是否包含登录相关资源路径,要注意排除掉 css/js/图片/验证码等资源
		if(uri.contains("login.jsp") || uri.contains("/login") || uri.contains("/index.jsp") || uri.contains("/checkCode")){
			chain.doFilter(request, response);
		}else {
			//不包含，需要验证用户是否登录
			//3.从获取session中获取user 
			Object user = req.getSession().getAttribute("user");
			if(user != null){
			//登录了。放行 
				chain.doFilter(req, response); 
			}else{
			//没有登录。跳转登录页面 
				req.setAttribute("login_msg","您尚未登录，请登录"); 
				req.getRequestDispatcher("/login.jsp").forward(req,response); 
			}
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
