<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

  <head>
	<base href="<%=basePath%>">
	
	<title>产品管理系统欢迎您</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">	
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		
<script type="text/javascript">
function login(){
	var th = document.form1;
	if(th.username.value==""){
		alert("用户名不能为空！");
		th.username.focus();
		return;
	}
	if(th.pswd.value==""){
		alert("密码不能为空！");
		th.pswd.focus();
		return;
	}
	//DAO设计模式：分离页面显示和数据操作  让程序代码更容易维护增强程序的可移植性    
	   
	
	//将login登录的具体功能交给servlet去处理  
	//servlet在服务器端获得客户端的访问请求信息和动态的生成对客户端的响应消息
	th.action = "<%=path%>/servlet/LoginAction";
	th.submit();


}

</script>
	
  </head>
  
  <body>
  
   <div style="text-align:center">   
   <form name="form1" action="" method="post">
   <table  style="margin:auto">   
   <tr>   		
   		<td colspan="2">
   		   <h1 align="center">登录 </h1> 
   		</td>   		
   	</tr>
   	<tr>
   		<td>用户名：</td>
   		<td><input type="text" name="username"></input></td>   		
   	</tr>
   	<tr>
   		<td>密	码：</td>
   		<td><input type="password" name="pswd"></input></td>   		
   	</tr>
   		<tr>
   		
   		<td colspan="2" align="center">
   		<button type="button" name="" value="" onclick="login()">登录</button>
   		<button type="button" name="" value="" onclick="javascript:location.href='register.jsp'">注册</button>
   		</td>   		
   	</tr>   
   
   </table>
   </form>
  </div>
 
   
  </body>
</html>  