<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="../jsp/indexTop.jsp"%>
<script type="text/javascript" src="<%=basePath%>js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
	
	
	function zan(bid){
		var url="http://localhost:8080/knowledgeforums/AddLikes?bid=" + bid;
		$.ajax({
			   type: "POST",
			   url: url,
			   success: function(msg){
				  
				 var count = $("#likeCount"+bid).text(); 
				 count = parseInt(count)+1;
				 $("#likeCount"+bid).text(count);
			   }
			});		
	}
</script>
                <!-- Start of Page Container -->
                <div class="page-container">
                        <div class="container">
                                <div class="row">

                                        <!-- start of page content -->
                                        <div class="span8 main-listing">

                                              	<c:forEach items="${pageBean.blogs }" var="blog">
                                              		<article class="format-standard type-post hentry clearfix">

                                                        <header class="clearfix">

                                                                <h3 class="post-title">
                                                                        <a href="<%=basePath%>BlogDetailsServlet?blog_id=${blog.blog_id}">${blog.blog_name }</a>
                                                                </h3>

                                                                <div class="post-meta clearfix">
                                                                        <span class="date">${blog.date }</span>
                                                                        <span class="category"><a href="#" title="View all posts in Server &amp; Database">${blog.categories } </a></span>
                                                                        <span class="comments"><a href="#" title="Comment on Integrating WordPress with Your Website">3 Comments</a></span>
                                                                        <span class="like-count" id="likeCount${blog.blog_id}" onclick="zan(${blog.blog_id})" >${blog.likes }</span>
                                                                    <%--   <input type="button" onclick="zan(${blog.blog_id})"/>--%>  
                                                                </div><!-- end of post meta -->
                                                        </header>
                                                        <p>${blog.summary } . . . <a class="readmore-link" href="http://knowledgebase.inspirythemes.com/integrating-wordpress-with-your-website/">Read more</a></p>
                                              	  </article>
                                              	</c:forEach>
                                                <div id="pagination">
                                                		 <a href="<%=basePath%>PageServlet?currentPage=1" class="btn">首页</a>
                                                        <a href="<%=basePath%>PageServlet?currentPage=${pageBean.currentPage==1?1:pageBean.currentPage-1}" class="btn">&lt;&lt;上一页 </a>
                                                        <a  class="btn">第${pageBean.currentPage }页/共${pageBean.totalPage }页</a>
                                                        <a href="<%=basePath%>PageServlet?currentPage=${pageBean.currentPage==pageBean.totalPage?pageBean.totalPage:pageBean.currentPage+1}" class="btn">下一页 &gt;&gt;</a>
                                                         <a href="<%=basePath%>PageServlet?currentPage=${pageBean.totalPage }" class="btn">尾页 </a>
                                                </div>
                                        </div>
                                        <!-- end of page content -->
                                        <!-- start of sidebar -->
                                        <aside class="span4 page-sidebar">

                                                <section class="widget">
                                                        <div class="support-widget">
                                                                <h3 class="title">Support</h3>
                                                                <p class="intro">Need more support? If you did not found an answer, contact us for further help.</p>
                                                        </div>
                                                </section>


                                                <section class="widget">
                                                        <h3 class="title">Featured Articles</h3>
                                                        <ul class="articles">
                                                                <li class="article-entry standard">
                                                                        <h4><a href="<%=basePath%>/jsp/single.jsp">Integrating WordPress with Your Website</a></h4>
                                                                        <span class="article-meta">25 Feb, 2013 in <a href="#" title="View all posts in Server &amp; Database">Server &amp; Database</a></span>
                                                                        <span class="like-count">66</span>
                                                                </li>
                                                                <li class="article-entry standard">
                                                                        <h4><a href="<%=basePath%>/jsp/single.jsp">WordPress Site Maintenance</a></h4>
                                                                        <span class="article-meta">24 Feb, 2013 in <a href="#" title="View all posts in Website Dev">Website Dev</a></span>
                                                                        <span class="like-count">15</span>
                                                                </li>
                                                                <li class="article-entry video">
                                                                        <h4><a href="<%=basePath%>/jsp/single.jsp">Meta Tags in WordPress</a></h4>
                                                                        <span class="article-meta">23 Feb, 2013 in <a href="#" title="View all posts in Website Dev">Website Dev</a></span>
                                                                        <span class="like-count">8</span>
                                                                </li>
                                                                <li class="article-entry image">
                                                                        <h4><a href="<%=basePath%>/jsp/single.jsp">WordPress in Your Language</a></h4>
                                                                        <span class="article-meta">22 Feb, 2013 in <a href="#" title="View all posts in Advanced Techniques">Advanced Techniques</a></span>
                                                                        <span class="like-count">6</span>
                                                                </li>
                                                        </ul>
                                                </section>



                                                <section class="widget"><h3 class="title">分类</h3>
                                                        <ul>
                                                                <li><a href="#" title="Lorem ipsum dolor sit amet,">新闻</a> </li>
                                                                <li><a href="#" title="Lorem ipsum dolor sit amet,">股票</a></li>
                                                                <li><a href="#" title="Lorem ipsum dolor sit amet,">教育</a></li>
                                                                <li><a href="#" title="Lorem ipsum dolor sit amet, ">科技</a></li>
                                                                <li><a href="#" title="Lorem ipsum dolor sit amet,">文史</a></li>
                                                                <li><a href="#" title="Lorem ipsum dolor sit amet,">娱乐</a></li>
                                                                <li><a href="#" title="Lorem ipsum dolor sit amet, ">军事</a></li>
                                                        </ul>
                                                </section>

                                                <section class="widget">
                                                        <h3 class="title">Recent Comments</h3>
                                                        <ul id="recentcomments">
                                                                <li class="recentcomments"><a href="#" rel="external nofollow" class="url">John Doe</a> on <a href="#">Integrating WordPress with Your Website</a></li>
                                                                <li class="recentcomments">saqib sarwar on <a href="#">Integrating WordPress with Your Website</a></li>
                                                                <li class="recentcomments"><a href="#" rel="external nofollow" class="url">John Doe</a> on <a href="#">Integrating WordPress with Your Website</a></li>
                                                                <li class="recentcomments"><a href="#" rel="external nofollow" class="url">Mr WordPress</a> on <a href="#">Installing WordPress</a></li>
                                                        </ul>
                                                </section>

                                        </aside>
                                        <!-- end of sidebar -->
                                </div>
                        </div>
                </div>
                <!-- End of Page Container -->
<%@ include file="../jsp/indexBottom.jsp"%>
               
        </body>
</html>
