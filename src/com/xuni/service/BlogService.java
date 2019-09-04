package com.xuni.service;

import java.util.List;

import com.xuni.dto.PageBean;
import com.xuni.pojo.Blog;

public interface BlogService {
	/**
	 * ���²���
	 * @return
	 * @throws Exception
	 */
	List<Blog> showNewBlog()throws Exception;
	
	/**
	 * �������
	 * @return
	 * @throws Exception
	 */
	List<Blog> showLikesBlogs() throws Exception;
	
	/**
	 * ��������
	 * @param blog_id
	 * @return
	 * @throws Exception
	 */
	Blog showBlogDetails(int blog_id) throws Exception;
	/**
	 * ��������
	 * @param blog
	 */
	void publishBlog(Blog blog) throws Exception;
	/**
	 * service��չʾ���в���
	 * @return
	 */
	List<Blog> showAllBlog() throws Exception;
	/**
	 * service�����
	 * @param bid
	 */
	void addLikes(String bid) throws Exception;
	/**
	 * service���ҳ��ѯ
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	PageBean findBlogsPage(int currentPage, int pageSize)throws Exception;
	/**
	 * ��ѯ����
	 * @param searchContext
	 * @return
	 */
	List<Blog> searchBlog(String searchContext);
}
