package com.xuni.dao;

import java.sql.SQLException;

import com.xuni.pojo.User;

public interface UserDao {
	/**
	 * dao������û�
	 * @param name
	 * @param password
	 * @return
	 */
	User findUserByUserNameAndPwd(String name, String password) throws SQLException;

	User findUsernameById(int id) throws SQLException;
	
	/**
	 * ע���û�
	 * @param user
	 * @throws Exception
	 */
	void register (User user) throws Exception;
	
	/**
	 * ����û��������ݿ��в����ڣ�������Ч��
	 * @param uname
	 * @return
	 * @throws Exception
	 */
	boolean isValidUname(String name)throws Exception;

	String findNameById(Integer user_id)throws SQLException;
}
