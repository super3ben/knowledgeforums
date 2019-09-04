<%@ include file="../jsp/indexTop.jsp"%>
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
                   <div class="span8 page-content">

                           <!-- Basic Home Page Template -->
                           <div class="row separator">
                                   <section class="span4 articles-list">
                                           <h3>Featured Articles</h3>
                                           <ul class="articles">
                                           		   <c:forEach var="blog" items="${likeslist}">
                                                   <li class="article-entry standard">
                                                           <h4><a href="<%=basePath%>BlogDetailsServlet?blog_id=${blog.blog_id}">${blog.blog_name}</a></h4>
                                                           <span class="article-meta">${blog.date} in <a href="#" title="View all posts in Server &amp; Database">${blog.categories}</a></span>
                                                           <span class="like-count" id="likeCount${blog.blog_id}" onclick="zan(${blog.blog_id})"  >${blog.likes}</span>
                                                   </li>
                                                   </c:forEach>
                                           </ul>
                                   </section>


                              <section class="span4 articles-list">
                                      <h3>Latest Articles</h3>
                                      <ul class="articles">
                                      		  <c:forEach var="blog" items="${newlist}">
                                              <li class="article-entry standard">
                                                      <h4><a href="<%=basePath%>BlogDetailsServlet?blog_id=${blog.blog_id}">${blog.blog_name}</a></h4>
                                                      <span class="article-meta">${blog.date} in <a href="#" title="View all posts in Server &amp; Database">${blog.categories}</a></span>
                                                      <span class="like-count" id="likeCount${blog.blog_id}" onclick="zan(${blog.blog_id})">${blog.likes}</span>
                                              </li>
                                              </c:forEach>
                                      </ul>
                              </section>
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
                                           <div class="quick-links-widget">
                                                   <h3 class="title">Quick Links</h3>
                                                   <ul id="menu-quick-links" class="menu clearfix">
                                                           <li><a href="<%=basePath%>SpecificBlogServlet">Home</a></li>
                                                           <li><a href="<%=basePath%>jsp/PublishBlog.jsp">PublishBlog </a></li>
                                                           <li><a href="<%=basePath%>getInChat">chat App</a></li>
                                                           <li><a href="<%=basePath%>PageServlet">Articles List</a></li>
                                                           <li><a href="<%=basePath%>/jsp/faq.jsp">FAQs</a></li>
                                                           <li><a href="<%=basePath%>jsp/contact.jsp">Contact</a></li>
                                                   </ul>
                                           </div>
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