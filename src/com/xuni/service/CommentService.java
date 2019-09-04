package com.xuni.service;

import java.util.List;

import com.xuni.pojo.Comment;

public interface CommentService {
	/**
	 * 发布评论
	 * @param comment
	 * @throws Exception
	 */
	void addComment(Comment comment)throws Exception;
	
	/**
	 * 显示博客评论
	 * @param blog_id
	 * @return
	 * @throws Exception
	 */
	List<Comment> showBlogComment(int blog_id) throws Exception;
}
