package com.xuni.service;

import com.xuni.pojo.User;

public interface UserService {
	/**
	 * 通过用户名和密码查找用户
	 * @param name
	 * @param password
	 * @return
	 */
	User login(String name, String password) throws Exception;
	
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
	/**
	 * 通过id的到用户名
	 * @param user_id
	 * @return
	 */
	String findUserNameById(Integer user_id)throws Exception;;
}
