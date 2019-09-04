package com.xuni.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.xuni.dao.UserDao;
import com.xuni.pojo.User;
import com.xuni.util.C3P0Util;

public class UserDaoImpl implements UserDao {

	@Override
	public User findUserByUserNameAndPwd(String name, String password) throws SQLException {
		QueryRunner query = new QueryRunner(C3P0Util.getDataSource());
		return query.query("SELECT  * FROM USER WHERE NAME=? AND PASSWORD=?", 
				new BeanHandler<User>(User.class),name,password);
	}
	
	
	@Override
	public User findUsernameById(int id) throws SQLException {
		QueryRunner query = new QueryRunner(C3P0Util.getDataSource());
		return query.query("SELECT  * FROM USER WHERE user_id = ?", 
				new BeanHandler<User>(User.class),id);
	}
	
	@Override
	public void register(User user) throws Exception {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		qr.update("INSERT INTO USER(name,password) VALUE (?,?)",user.getName(),user.getPassword());
		
	}


	@Override
	public boolean isValidUname(String name) throws Exception {
        boolean bRet = true;
		
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        List<User> list =  (List<User>) qr.query("select * from user where name =?",new BeanHandler<User>(User.class),name);		
		if(list != null){
			bRet = false;			
		}
		return bRet;
	}


	@Override
	public String findNameById(Integer user_id) throws SQLException {
		 QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return (String) qr.query("SELECT NAME FROM USER WHERE user_id=? ", new ScalarHandler(1), user_id);
	}


}
