package com.xuni.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.xuni.dao.CommentDao;
import com.xuni.pojo.Blog;
import com.xuni.pojo.Comment;
import com.xuni.util.C3P0Util;

public class CommentDaoImpl implements CommentDao{



	@Override
	public List<Comment> showBlogComment(int blog_id) throws Exception {
		QueryRunner query = new QueryRunner(C3P0Util.getDataSource());
		List<Comment> list = query.query("SELECT * FROM comment where blog_id=?",
				new BeanListHandler<Comment>(Comment.class),blog_id);
	System.out.println(list);
		return list;
	}

	@Override
	public void addComment(Comment comment) throws Exception {
		QueryRunner query = new QueryRunner(C3P0Util.getDataSource());
		query.update("insert into comment(user_id,blog_id,comment,c_date) values(?,?,?,?)"
				,comment.getUser_id(),comment.getBlog_id(),comment.getComment(),comment.getC_date());
		
	}

}
