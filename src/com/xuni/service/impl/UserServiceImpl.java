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
		/*1.判断用户名是否唯一
		   判断用户名，密码长度
		   是否为空判断
		  2.用户注册（写入用户信息）
		 */
		
		boolean bRet = userDao.isValidUname(user.getName());
		if(bRet) {
			ManagerThreadLocal.startTransacation();        //开启事务
			try {				
				userDao.register(user);
				ManagerThreadLocal.commit();           //提交事务
			} catch (Exception e) {
				ManagerThreadLocal.rollback();          //事务回滚  
				throw e;
			}finally{
				ManagerThreadLocal.close();  //释放资源
			}
			
		}else{
			throw new RuntimeException("用户名已被占用");
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
