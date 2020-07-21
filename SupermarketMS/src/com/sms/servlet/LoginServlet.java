package com.sms.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sms.pojo.User;
import com.sms.service.UserService;
import com.sms.service.impl.UserServiceImpl;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String checkCode = request.getParameter("checkCode");
				
		HttpSession session = request.getSession();
		String code =session.getAttribute("code").toString();
		
		System.out.println(code);
		
		session.removeAttribute("code");
		
		if(code!= null && code.equalsIgnoreCase(checkCode)){
			
			User user = new User();
			
			System.out.println("即将登录的用户名是："+username+" 密码是："+password);	
		
			user.setUsername(username);
			user.setPassword(password);		
			
			UserService userService = new UserServiceImpl();
			boolean flag = userService.login(user);
			
			if(flag){
				session.setAttribute("user", user);
				request.setAttribute("user", user);
				response.sendRedirect("/SupermarketMS/admin/main.jsp");
				
			}else {
				//登录失败
				//存储提示信息到request 
				request.setAttribute("login_error","用户名或密码错误");
				//转发到登录页面 
				request.getRequestDispatcher("/login.jsp").forward(request,response);
			}
		}else {
			//验证码不一致
			//存储提示信息到request 
			request.setAttribute("cc_error","验证码错误");
			//转发到登录页面 
			request.getRequestDispatcher("/login.jsp").forward(request,response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
