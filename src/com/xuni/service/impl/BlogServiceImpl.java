package com.xuni.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xuni.dao.BlogDao;
import com.xuni.dao.impl.BlogDaoImpl;
import com.xuni.dto.PageBean;
import com.xuni.pojo.Blog;
import com.xuni.service.BlogService;
import com.xuni.util.ManagerThreadLocal;

public class BlogServiceImpl implements BlogService {
	
	BlogDao dao = new BlogDaoImpl();
	@Override
	public List<Blog> showNewBlog() throws Exception {
		List<Blog> blog = new ArrayList<>();
		try {	
			blog = dao.showNewBlogs();	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return blog;
	}
	@Override
	public List<Blog> showLikesBlogs() throws Exception {
		List<Blog> list = new ArrayList<>();
		try {
			list = dao.showLikesBlogs();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public void publishBlog(Blog blog) throws Exception {
		try {
			ManagerThreadLocal.startTransacation();//开启事物
			dao.addBlog(blog);
			ManagerThreadLocal.commit();//提交事务
		} catch (Exception e) {
			ManagerThreadLocal.rollback();//回滚事务
			throw e;
		}finally{
			try {
				ManagerThreadLocal.close();
			} catch (Exception e) {
				e.printStackTrace();
			}//关闭
		}
		
	}
	@Override
	public Blog showBlogDetails(int blog_id) throws Exception {
		try {
			return dao.showBlogDetails(blog_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<Blog> showAllBlog() throws Exception {
		try {
			return dao.findAllBlog();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public void addLikes(String bid) throws Exception {
		dao.addLikes(bid);
	}
	@Override
	public PageBean findBlogsPage(int currentPage, int pageSize) throws Exception {
		int count = dao.fingAllPage();
		int totalPage = (int) Math.ceil(count*1.0/pageSize); 
		List<Blog> blogs = dao.findBlogs(currentPage,pageSize);
		PageBean pageBean = new PageBean();
		pageBean.setCount(count);
		pageBean.setCurrentPage(currentPage);
		pageBean.setPageSize(pageSize);
		pageBean.setTotalPage(totalPage);
		pageBean.setBlogs(blogs);
		return pageBean;
	}
	
	
	@Override
	public List<Blog> searchBlog(String searchContext) {
		try {
			return dao.findBlogsByContextAmbigiously(searchContext);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
