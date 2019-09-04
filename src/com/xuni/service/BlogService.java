package com.xuni.service;

import java.util.List;

import com.xuni.dto.PageBean;
import com.xuni.pojo.Blog;

public interface BlogService {
	/**
	 * 最新博客
	 * @return
	 * @throws Exception
	 */
	List<Blog> showNewBlog()throws Exception;
	
	/**
	 * 点赞最多
	 * @return
	 * @throws Exception
	 */
	List<Blog> showLikesBlogs() throws Exception;
	
	/**
	 * 博客详情
	 * @param blog_id
	 * @return
	 * @throws Exception
	 */
	Blog showBlogDetails(int blog_id) throws Exception;
	/**
	 * 发布博客
	 * @param blog
	 */
	void publishBlog(Blog blog) throws Exception;
	/**
	 * service层展示所有博客
	 * @return
	 */
	List<Blog> showAllBlog() throws Exception;
	/**
	 * service层点赞
	 * @param bid
	 */
	void addLikes(String bid) throws Exception;
	/**
	 * service层分页查询
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	PageBean findBlogsPage(int currentPage, int pageSize)throws Exception;
	/**
	 * 查询博客
	 * @param searchContext
	 * @return
	 */
	List<Blog> searchBlog(String searchContext);
}
