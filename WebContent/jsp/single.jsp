<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="../jsp/indexTop.jsp"%>
<script type="text/javascript">
	
	
	function zan(bid){
		var url="http://localhost:8081/knowledgeforums/AddLikes?bid=" + bid;
		$.ajax({
			   type: "POST",
			   url: url,
			   success: function(msg){
				  
				 var count = $("#likeCount").text(); 
				 count = parseInt(count)+1;
				 $("#likeCount").text(count);
				 $("#zanname").css("color","currentColor");
			   }
			});		
	}
	</script>
                <!-- Start of Page Container -->
                <div class="page-container">
                        <div class="container">
                                <div class="row">

                                        <!-- start of page content -->
                                        <div class="span8 page-content">

                                                <ul class="breadcrumb">
                                                        <li><a href="#">Knowledge Base Theme</a><span class="divider">/</span></li>
                                                        <li><a href="#" title="View all posts in Server &amp; Database">Server &amp; Database</a> <span class="divider">/</span></li>
                                                        <li class="active">Integrating WordPress with Your Website</li>
                                                </ul>

                                                <article class=" type-post format-standard hentry clearfix">

                                                        <h1 class="post-title"><a href="#">${blog.blog_name}</a></h1>

                                                        <div class="post-meta clearfix">
                                                                <span class="date">${blog.date}</span>
                                                                <span class="category"><a href="#" title="View all posts in Server &amp; Database">${blog.categories}</a></span>
                                                                <span class="comments"><a href="#" title="Comment on Integrating WordPress with Your Website">3 Comments</a></span>
                                                                <span class="like-count" id="likeCount" onclick="zan(${blog.blog_id})">${blog.likes}</span>
                                                        </div><!-- end of post meta -->

                                                        <p>${blog.blog_content}</p></article>

                                                <div class="like-btn">
                                                         <span class="like-it"  id="zanname" onclick="zan(${blog.blog_id})">${blog.blog_name}</span>

                                                </div>

                                                <section id="comments">

                                                        <h3 id="comments-title">${listcom.size()}Comments</h3>

                                                        <ol class="commentlist">
                                                        
															<c:forEach var="comment" items="${listcom }" varStatus="loop" >
                                                                <li class="comment even thread-even depth-1" id="li-comment-2">
                                                                        <article id="comment-2">
                                                                                <a href="#">
                                                                                        <img alt="" src="http://1.gravatar.com/avatar/50a7625001317a58444a20ece817aeca?s=60&amp;d=http%3A%2F%2F1.gravatar.com%2Favatar%2Fad516503a11cd5ca435acc9bb6523536%3Fs%3D60&amp;r=G" class="avatar avatar-60 photo" height="60" width="60">
                                                                                </a>
                                                                                <div class="comment-meta">

                                                                                        <h5 class="author">
                                                                                                <cite class="fn">
                                                                                                        <a href="#" rel="external nofollow" class="url">${list[loop.index] }</a>
                                                                                                </cite>
                                                                                        </h5>
                                                                                        <p class="date">
                                                                                                <a href="#">
                                                                                                        <time datetime="2013-02-26T13:18:47+00:00">${comment.c_date}</time>
                                                                                                </a>
                                                                                        </p>

                                                                                </div><!-- end .comment-meta -->

                                                                                <div class="comment-body">
                                                                                        <p>${comment.comment}</p>
                                                                                </div><!-- end of comment-body -->

                                                                        </article><!-- end of comment -->
                                                                </li>
															</c:forEach>            
                                                        </ol>

                                                        <div id="respond">

                                                                <h3>Leave a Reply</h3>

                                                                <div class="cancel-comment-reply">
                                                                        <a rel="nofollow" id="cancel-comment-reply-link" href="#" style="display:none;">Click here to cancel reply.</a>
                                                                </div>


                                                                <form action="<%=basePath%>PublishComment?blog_id=${blog.blog_id}" method="post" id="comment">
                                                                        <div>
                                                                                <label for="comment">Comment</label>
                                                                                <textarea class="span8" name="comment" id="comment" cols="58" rows="10"></textarea>
                                                                        </div>
                                                                        <p class="allowed-tags">You can use these HTML tags and attributes <small></small></p>

                                                                        <div>
                                                                                <input class="btn" name="submit" type="submit" id="submit"  value="Submit Comment">
                                                                        </div>

                                                                </form>

                                                        </div>

                                                </section><!-- end of comments -->

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
                                                                   <c:forEach var="blog" items="${likeslist}">
				                                                   <li class="article-entry standard">
				                                                           <h4><a href="<%=basePath%>BlogDetailsServlet?blog_id=${blog.blog_id}">${blog.blog_name}</a></h4>
				                                                           <span class="article-meta">${blog.date} in <a href="#" title="View all posts in Server &amp; Database">${blog.categories}</a></span>
				                                                           <span class="like-count">${blog.likes}</span>
				                                                   </li>
				                                                   </c:forEach>
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
