<%@ include file="../jsp/indexTop.jsp"%>

                <!-- Start of Page Container -->
                <div class="page-container">
                        <div class="container">
                                <div class="row">

                                        <!-- start of page content -->
                                        <div class="span8 page-content">

                                                <article class=" type-page  hentry clearfix">
                                                        <h1 class="post-title"><a href="#">Sample Page</a></h1>

                                                        <hr>

                                                        <p>This is an example page. It’s different from a blog post because it will stay in one place and will show up in your site navigation (in most themes). Most people start with an About page that introduces them to potential site visitors. It might say something like this:</p>

                                                        <blockquote>
                                                                <p>Hi there! I’m a bike messenger by day, aspiring actor by night, and this is my blog. I live in Los Angeles, have a great dog named Jack, and I like piña coladas. (And gettin’ caught in the rain.)</p>
                                                        </blockquote>

                                                        <p>…or something like this:</p>

                                                        <blockquote>
                                                                <p>The XYZ Doohickey Company was founded in 1971, and has been providing quality doohickeys to the public ever since. Located in Gotham City, XYZ employs over 2,000 people and does all kinds of awesome things for the Gotham community.</p>
                                                        </blockquote>

                                                        <p>As a new WordPress user, you should go to <a href="#">your dashboard</a> to delete this page and create new pages for your content. Have fun!</p>

                                                </article>

                                                <div id="respond">

                                                        <h3>Leave a Reply</h3>

                                                        <div class="cancel-comment-reply">
                                                                <a rel="nofollow" id="cancel-comment-reply-link" href="#" style="display:none;">Click here to cancel reply.</a>
                                                        </div>


                                                        <form action="#" method="post" id="commentform">


                                                                <p class="comment-notes">Your email address will not be published. Required fields are marked <span class="required">*</span></p>

                                                                <div>
                                                                        <label for="author">Name *</label>
                                                                        <input class="span4" type="text" name="author" id="author" value="" size="22">
                                                                </div>

                                                                <div>
                                                                        <label for="email">Email *</label>
                                                                        <input class="span4" type="text" name="email" id="email" value="" size="22">
                                                                </div>

                                                                <div>
                                                                        <label for="url">Website</label>
                                                                        <input class="span4" type="text" name="url" id="url" value="" size="22">
                                                                </div>


                                                                <div>
                                                                        <label for="comment">Comment</label>
                                                                        <textarea class="span8" name="comment" id="comment" cols="58" rows="10"></textarea>
                                                                </div>

                                                                <p class="allowed-tags">You can use these HTML tags and attributes <small><code>&lt;a href="#" title=""&gt; &lt;abbr title=""&gt; &lt;acronym title=""&gt; &lt;b&gt; &lt;blockquote cite=""&gt; &lt;cite&gt; &lt;code&gt; &lt;del datetime=""&gt; &lt;em&gt; &lt;i&gt; &lt;q cite=""&gt; &lt;strike&gt; &lt;strong&gt; </code></small></p>

                                                                <div>
                                                                        <input class="btn" name="submit" type="submit" id="submit" value="Submit Comment">
                                                                </div>

                                                        </form>

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
                                                        <h3 class="title">Latest Articles</h3>
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



                                                <section class="widget"><h3 class="title">Categories</h3>
                                                        <ul>
                                                                <li><a href="#" title="Lorem ipsum dolor sit amet,">Advanced Techniques</a> </li>
                                                                <li><a href="#" title="Lorem ipsum dolor sit amet,">Designing in WordPress</a></li>
                                                                <li><a href="#" title="Lorem ipsum dolor sit amet,">Server &amp; Database</a></li>
                                                                <li><a href="#" title="Lorem ipsum dolor sit amet, ">Theme Development</a></li>
                                                                <li><a href="#" title="Lorem ipsum dolor sit amet,">Website Dev</a></li>
                                                                <li><a href="#" title="Lorem ipsum dolor sit amet,">WordPress for Beginners</a></li>
                                                                <li><a href="#" title="Lorem ipsum dolor sit amet, ">WordPress Plugins</a></li>
                                                        </ul>
                                                </section>


                                                <section class="widget">
                                                        <h3 class="title">Tags</h3>
                                                        <div class="tagcloud">
                                                                <a href="#" class="btn btn-mini">basic</a>
                                                                <a href="#" class="btn btn-mini">beginner</a>
                                                                <a href="#" class="btn btn-mini">blogging</a>
                                                                <a href="#" class="btn btn-mini">colour</a>
                                                                <a href="#" class="btn btn-mini">css</a>
                                                                <a href="#" class="btn btn-mini">date</a>
                                                                <a href="#" class="btn btn-mini">design</a>
                                                                <a href="#" class="btn btn-mini">files</a>
                                                                <a href="#" class="btn btn-mini">format</a>
                                                                <a href="#" class="btn btn-mini">header</a>
                                                                <a href="#" class="btn btn-mini">images</a>
                                                                <a href="#" class="btn btn-mini">plugins</a>
                                                                <a href="#" class="btn btn-mini">setting</a>
                                                                <a href="#" class="btn btn-mini">templates</a>
                                                                <a href="#" class="btn btn-mini">theme</a>
                                                                <a href="#" class="btn btn-mini">time</a>
                                                                <a href="#" class="btn btn-mini">videos</a>
                                                                <a href="#" class="btn btn-mini">website</a>
                                                                <a href="#" class="btn btn-mini">wordpress</a>
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
