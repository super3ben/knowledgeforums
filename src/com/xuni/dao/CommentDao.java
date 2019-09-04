package com.xuni.dao;

import java.util.List;

import com.xuni.pojo.Comment;

public interface CommentDao {
	
	/**
	 * dao���������
	 * @throws Exception
	 */
	void addComment(Comment comment)throws Exception;
	
	/**
	 * dao����Ҳ�������
	 * @return
	 * @throws Exception
	 */
	List<Comment> showBlogComment(int blog_id) throws Exception;
}
