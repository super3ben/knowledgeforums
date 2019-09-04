package com.xuni.service;

import java.util.List;

import com.xuni.pojo.Comment;

public interface CommentService {
	/**
	 * ��������
	 * @param comment
	 * @throws Exception
	 */
	void addComment(Comment comment)throws Exception;
	
	/**
	 * ��ʾ��������
	 * @param blog_id
	 * @return
	 * @throws Exception
	 */
	List<Comment> showBlogComment(int blog_id) throws Exception;
}
