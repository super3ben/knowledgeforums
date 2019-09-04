package com.xuni.service.impl;

import java.sql.SQLException;

import com.xuni.dao.UserDao;
import com.xuni.dao.impl.UserDaoImpl;
import com.xuni.pojo.User;
import com.xuni.service.UserService;
import com.xuni.util.ManagerThreadLocal;

public class UserServiceImpl implements UserService {
	UserDao userDao = new UserDaoImpl();

	@Override
	public User login(String name, String password) throws Exception {
		try {
			return userDao.findUserByUserNameAndPwd(name, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public void register(User user) throws Exception{
		/*1.�ж��û����Ƿ�Ψһ
		   �ж��û��������볤��
		   �Ƿ�Ϊ���ж�
		  2.�û�ע�ᣨд���û���Ϣ��
		 */
		
		boolean bRet = userDao.isValidUname(user.getName());
		if(bRet) {
			ManagerThreadLocal.startTransacation();        //��������
			try {				
				userDao.register(user);
				ManagerThreadLocal.commit();           //�ύ����
			} catch (Exception e) {
				ManagerThreadLocal.rollback();          //����ع�  
				throw e;
			}finally{
				ManagerThreadLocal.close();  //�ͷ���Դ
			}
			
		}else{
			throw new RuntimeException("�û����ѱ�ռ��");
		}
		
		
	}

	@Override
	public boolean isValidUname(String name) throws Exception {
		boolean bRet ;	
			bRet = userDao.isValidUname(name);			
			  
		return bRet;
	}

	@Override
	public String findUserNameById(Integer user_id) {
		String name = null;
		try {
			name = userDao.findNameById(user_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return name;
	}
}
