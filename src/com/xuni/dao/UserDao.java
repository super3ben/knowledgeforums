package com.xuni.dao;

import java.sql.SQLException;

import com.xuni.pojo.User;

public interface UserDao {
	/**
	 * dao层查找用户
	 * @param name
	 * @param password
	 * @return
	 */
	User findUserByUserNameAndPwd(String name, String password) throws SQLException;

	User findUsernameById(int id) throws SQLException;
	
	/**
	 * 注册用户
	 * @param user
	 * @throws Exception
	 */
	void register (User user) throws Exception;
	
	/**
	 * 如果用户名在数据库中不存在，就是有效的
	 * @param uname
	 * @return
	 * @throws Exception
	 */
	boolean isValidUname(String name)throws Exception;

	String findNameById(Integer user_id)throws SQLException;
}
