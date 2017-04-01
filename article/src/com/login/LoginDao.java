package com.login;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.jdbc.JdbcUtils;

public class LoginDao implements LoginService {

	private JdbcUtils jdbcUtils;
	public LoginDao() {
		// TODO Auto-generated constructor stub
		jdbcUtils = new JdbcUtils();
	}

	@Override
	public boolean login(List<Object> params) {
		// TODO Auto-generated method stub
		boolean flag = false;
		
		try {
			jdbcUtils.getConnection();  //获得jdbc数据库连接
			//定义sql语句
			String sql = "select * from userinfo where username = ? and pswd = ?";
			//执行sql语句并将执行后的结果放到map集合中  
			Map<String, Object> map = jdbcUtils.findSimpleResult(sql, params);
			//三元表达式  如果map不为空则flag返回true   即如果查询到表单输入的用户存在在数据库中则返回TRUE
			flag = !map.isEmpty()?true:false;			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			
		//关闭数据库
		jdbcUtils.releaseConn();
			
		}
		
		return flag;
	}	

}