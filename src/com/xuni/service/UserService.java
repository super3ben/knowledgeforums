package com.xuni.service;

import com.xuni.pojo.User;

public interface UserService {
	/**
	 * ͨ���û�������������û�
	 * @param name
	 * @param password
	 * @return
	 */
	User login(String name, String password) throws Exception;
	
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
	/**
	 * ͨ��id�ĵ��û���
	 * @param user_id
	 * @return
	 */
	String findUserNameById(Integer user_id)throws Exception;;
}
