package com.xuni.dao;

import java.sql.SQLException;
import java.util.List;

import com.xuni.pojo.Blog;

public interface BlogDao {
	/**
	 * dao��������²���
	 * @return
	 * @throws Exception
	 */
	List<Blog> showNewBlogs()throws Exception;
	
	/**
	 * dao����������
	 * @return
	 * @throws Exception
	 */
	List<Blog> showLikesBlogs() throws Exception;
	
	/**
	 * dao����Ҳ�������
	 * @return
	 * @throws Exception
	 */
	Blog showBlogDetails(int blog_id) throws Exception;
	/**
	 * dao����Ӳ���
	 * @param blog
	 * @throws Exception
	 */
	void addBlog(Blog blog) throws Exception;
	/**
	 * dao�����
	 * @param blog_id
	 */
	void addLikes(int blog_id)throws Exception;
	/**
	 * dao���ѯ���в���
	 * @return
	 * @throws Exception
	 */
	List<Blog> findAllBlog()throws Exception;
	/**
	 * dao�����
	 * @param bid
	 * @throws Exception
	 */
	void addLikes(String bid) throws Exception;
	/**
	 * ��ѯblog����
	 * @return
	 * @throws Exception
	 */
	int fingAllPage()throws Exception;
	/**
	 * ��ѯ�ض�ҳ��blogs
	 * @param currentPage
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	List<Blog> findBlogs(int currentPage, int pageSize)throws Exception;
	/**
	 * �Ա������ģ����ѯ
	 * @param context
	 * @return
	 */
	List<Blog> findBlogsByContextAmbigiously(String context) throws SQLException ;
}
