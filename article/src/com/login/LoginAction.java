package com.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginAction extends HttpServlet {//处理登录的servlet
     
	private LoginService service;
	/**
	 * Constructor of the object.
	 */
	public LoginAction() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
		
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		
		//servlet输出类似于io流  通过向客户端发送输出流 通过输出流来响应   返回PrintWriter
		//可以向客户端输出一些数据
		PrintWriter out = response.getWriter();
		
		String path = request.getContextPath();
		//通过请求对象获得传过来的username参数   即表单上填写的用户名
		String username = request.getParameter("username");
		String pswd = request.getParameter("pswd");  //得到密码
		
		//新建一个list集合  将用户名和密码添加到集合里面去
		List<Object> params = new ArrayList<Object>();
		params.add(username);
		params.add(pswd);
		boolean flag = service.login(params);  //将得到的用户名和密码作为一个用户对象传进去 
		//调用login方法判断表单上填写的用户名是否存在于数据库的用户表中
		
		if (flag) { //如果该用户存在
			//得到当前的会话对象   并将username属性的值设置为表单上输入的用户名
			request.getSession().setAttribute("username", username);
			//响应重定向到登陆成功后的产品页面
			response.sendRedirect(path+"/main.jsp");
		}else{
			//如果用户不存在 则重新回到登录页面			
			response.sendRedirect(path+"/index.jsp");
		}
		
		
		
		
		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		
		service = new LoginDao();
	}

}
