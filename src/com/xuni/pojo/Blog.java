package com.xuni.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Blog {
    private Integer blog_id;
    private String blog_name;
    private String blog_content;
    private String img;
    private Integer user_id;
    private String categories;
    private String summary;
    private Integer likes;
    private Date date;
    
    private List<Comment> comments =new ArrayList<Comment>();
    
	public Integer getBlog_id() {
		return blog_id;
	}
	public void setBlog_id(Integer blog_id) {
		this.blog_id = blog_id;
	}
	public String getBlog_name() {
		return blog_name;
	}
	public void setBlog_name(String blog_name) {
		this.blog_name = blog_name;
	}
	public String getBlog_content() {
		return blog_content;
	}
	public void setBlog_content(String blog_content) {
		this.blog_content = blog_content;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getCategories() {
		return categories;
	}
	public void setCategories(String categories) {
		this.categories = categories;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public Integer getLikes() {
		return likes;
	}
	public void setLikes(Integer likes) {
		this.likes = likes;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	@Override
	public String toString() {
		return "Blog [blog_id=" + blog_id + ", blog_name=" + blog_name + ", blog_content=" + blog_content + ", img="
				+ img + ", user_id=" + user_id + ", categories=" + categories + ", summary=" + summary + ", likes="
				+ likes + ", date=" + date + ", comments=" + comments + "]";
	}
    
	
    
}