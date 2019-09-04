package com.xuni.dao.impl;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.xuni.dao.BlogDao;
import com.xuni.pojo.Blog;
import com.xuni.pojo.User;
import com.xuni.util.C3P0Util;

public class BlogDaoImpl implements BlogDao{

	@Override
	public List<Blog> showNewBlogs() throws Exception {
		QueryRunner query = new QueryRunner(C3P0Util.getDataSource());
		List<Blog> list = query.query("SELECT  * FROM blog ORDER BY date DESC LIMIT 4", new BeanListHandler<Blog>(Blog.class));
		return list;

	}

	@Override
	public List<Blog> showLikesBlogs() throws Exception {
		QueryRunner query = new QueryRunner(C3P0Util.getDataSource());
		List<Blog> list = query.query("SELECT  * FROM blog ORDER BY likes DESC LIMIT 4", new BeanListHandler<Blog>(Blog.class));
		return list;

	}

	@Override
	public void addBlog(Blog blog) throws Exception {
		QueryRunner query = new QueryRunner(C3P0Util.getDataSource());
		query.update("INSERT INTO blog(user_id,blog_name,summary,categories,blog_content,DATE,likes,img,state) "
				+ "VALUES(?,?,?,?,?,?,?,?,?);", blog.getUser_id(),blog.getBlog_name(),blog.getSummary(),blog.getCategories(),
				blog.getBlog_content(),blog.getDate(),0,null,0);
	}

	@Override
	public Blog showBlogDetails(int blog_id) throws Exception {
		Blog blog = new Blog();
		QueryRunner query = new QueryRunner(C3P0Util.getDataSource());
		blog = query.query("SELECT * FROM blog WHERE blog_id=?", 
				new BeanHandler<Blog>(Blog.class),blog_id);
		return blog;
	}

	@Override
	public void addLikes(int blog_id) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public List<Blog> findAllBlog() throws Exception {
		QueryRunner query = new QueryRunner(C3P0Util.getDataSource());
		List<Blog> blogs = query.query("SELECT * FROM blog", new BeanListHandler<Blog>(Blog.class));
		return blogs;
	}

	@Override
	public void addLikes(String bid) throws Exception {
		QueryRunner query = new QueryRunner(C3P0Util.getDataSource());
		query.update("UPDATE blog SET likes=(likes+1) WHERE blog_id=?",bid);
	}

	@Override
	public int fingAllPage() throws Exception {
		QueryRunner query = new QueryRunner(C3P0Util.getDataSource());
		long l = (Long) query.query("SELECT COUNT(*) FROM blog", new ScalarHandler(1));
		return (int) l;
	}

	@Override
	public List<Blog> findBlogs(int currentPage, int pageSize) throws Exception {
		QueryRunner query = new QueryRunner(C3P0Util.getDataSource());
		return query.query("SELECT * FROM blog LIMIT ?,?", new BeanListHandler<Blog>(Blog.class), (currentPage-1)*pageSize,pageSize);
	}

	@Override
	public List<Blog> findBlogsByContextAmbigiously(String context) throws SQLException {
		QueryRunner query = new QueryRunner(C3P0Util.getDataSource());
		System.out.println(context);
		List<Blog> list = query.query("SELECT * FROM blog WHERE blog_name LIKE ?", new BeanListHandler<Blog>(Blog.class),"%"+context+"%");
		return list;
	}
}
