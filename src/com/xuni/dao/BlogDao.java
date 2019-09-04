package com.xuni.dao;

import java.sql.SQLException;
import java.util.List;

import com.xuni.pojo.Blog;

public interface BlogDao {
	/**
	 * dao层查找最新博客
	 * @return
	 * @throws Exception
	 */
	List<Blog> showNewBlogs()throws Exception;
	
	/**
	 * dao层查找最爱博客
	 * @return
	 * @throws Exception
	 */
	List<Blog> showLikesBlogs() throws Exception;
	
	/**
	 * dao层查找博客详情
	 * @return
	 * @throws Exception
	 */
	Blog showBlogDetails(int blog_id) throws Exception;
	/**
	 * dao层添加博客
	 * @param blog
	 * @throws Exception
	 */
	void addBlog(Blog blog) throws Exception;
	/**
	 * dao层点赞
	 * @param blog_id
	 */
	void addLikes(int blog_id)throws Exception;
	/**
	 * dao层查询所有博客
	 * @return
	 * @throws Exception
	 */
	List<Blog> findAllBlog()throws Exception;
	/**
	 * dao层点赞
	 * @param bid
	 * @throws Exception
	 */
	void addLikes(String bid) throws Exception;
	/**
	 * 查询blog总数
	 * @return
	 * @throws Exception
	 */
	int fingAllPage()throws Exception;
	/**
	 * 查询特定页的blogs
	 * @param currentPage
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	List<Blog> findBlogs(int currentPage, int pageSize)throws Exception;
	/**
	 * 对标题进行模糊查询
	 * @param context
	 * @return
	 */
	List<Blog> findBlogsByContextAmbigiously(String context) throws SQLException ;
}
