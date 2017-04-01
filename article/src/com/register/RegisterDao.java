package com.register;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.JdbcUtils;

public class RegisterDao implements RegisterService {
 //实现接口   重写添加新的注册用户的方法
	private JdbcUtils jdbcUtils;
	public RegisterDao() {
		// TODO Auto-generated constructor stub
		jdbcUtils = new JdbcUtils();
	}

	/* 完成对用户注册的dao的编写
	 * @see com.register.service.RegisterService#registerUser(java.util.List)
	 */
	@Override
	public boolean registerUser(List<Object> params) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			jdbcUtils.getConnection();  //获得jdbc连接
			//将新的注册用户添加到到数据库的用户表中
			String sql = "insert into userinfo(username,pswd) values(?,?)";			
			flag = jdbcUtils.updateByPreparedStatement(sql, params);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			//关闭数据库连接			
			jdbcUtils.releaseConn();
			
		}
		
		
		return flag;
	}

}