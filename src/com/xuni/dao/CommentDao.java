package com.xuni.dao;

import java.util.List;

import com.xuni.pojo.Comment;

public interface CommentDao {
	
	/**
	 * dao层添加评论
	 * @throws Exception
	 */
	void addComment(Comment comment)throws Exception;
	
	/**
	 * dao层查找博客评论
	 * @return
	 * @throws Exception
	 */
	List<Comment> showBlogComment(int blog_id) throws Exception;
}
