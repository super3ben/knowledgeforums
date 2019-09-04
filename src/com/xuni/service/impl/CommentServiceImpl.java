package com.xuni.service.impl;

import java.util.List;

import com.xuni.dao.CommentDao;
import com.xuni.dao.impl.CommentDaoImpl;
import com.xuni.pojo.Comment;
import com.xuni.service.CommentService;

public class CommentServiceImpl implements CommentService{

	@Override
	public void addComment(Comment comment) throws Exception {
		CommentDaoImpl dao = new CommentDaoImpl();
		dao.addComment(comment);
	}

	@Override
	public List<Comment> showBlogComment(int blog_id) throws Exception {
		CommentDaoImpl dao = new CommentDaoImpl();
		List<Comment> list = dao.showBlogComment(blog_id);
		
		return list;
	}

}
