<%@ include file="../jsp/indexTop2.jsp"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<link rel="stylesheet" href="<%=basePath %>kindeditor/themes/default/default.css" />
<link rel="stylesheet" href="<%=basePath %>kindeditor/plugins/code/prettify.css" />
<script charset="utf-8" src="<%=basePath %>kindeditor/kindeditor-all.js"></script>
<script charset="utf-8" src="<%=basePath %>/kindeditor/lang/zh-CN.js"></script>
<script charset="utf-8" src="<%=basePath %>kindeditor/plugins/code/prettify.js"></script>
<script type="text/javascript">
	var editor;
	KindEditor.ready(function(K) {
		editor = K.create('textarea[name="content"]', {
			allowFileManager : true
		});
		
		K('input[name=submit]').click(function(e) {
			editor.sync();
			/* alert(editor.html()); */
			 $.ajax({
                 "url":"http://localhost:8080/knowledgeforums/publishBlogServlet",                       
                 "data":$("form").serialize(),                          
                 "type":"POST",                          
                 "success":function(){
                	 editor.html("");
                	 alert("发布成功");
                 },                         
                 "error":function(){
                      alert("服务器繁忙,请稍后重试");
                 },                         
                 "dataType":"json",                      
           	});
		});

		
	});
	
</script>                <!-- Start of Page Container -->
                <div class="page-container">
                        <div class="container">
                                <div class="row">

                                        <!-- start of page content -->
                                        <div class="span8 page-content">

                                                <article class="type-page hentry clearfix">
                                                        <h1 class="post-title">
                                                                <a href="#">发布博客</a>
                                                        </h1>
                                                        <hr>
                                                </article>

												<%--action="<%=basePath %>publishBlogServlet" --%>
                                                <form id="contact-form" class="row"  method="post">

                                                        <div class="span2">
                                                                <label for="name">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;标&nbsp;&nbsp;&nbsp;&nbsp;题 <span>*</span> </label>
                                                        </div>
                                                        <div class="span6">
                                                                <input type="text" name="title" id="title" class="required input-xlarge" value="" title="* Please provide your title">
                                                        </div>

                                                        <div class="span2">
                                                                <label for="category">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;分&nbsp;&nbsp;&nbsp;&nbsp;类 <span>*</span></label>
                                                        </div>
                                                        <div class="span6">
                                                                <select id="category" name="category">
																		<option value="娱乐"> 娱乐</option>
																		<option value="文化"> 文史</option>
																		<option value="股票"> 股票</option>
																		<option value="教育"> 教育</option>
																		<option value="科技"> 科技</option>
																		<option value="新闻"> 新闻</option>
																		<option value="军事"> 军事</option>
															    </select>
                                                        </div>

                                                        <div class="span2">
                                                                <label for="message">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;摘&nbsp;&nbsp;&nbsp;&nbsp;要 <span>*</span> </label>
                                                        </div>
                                                        <div class="span6">
                                                                <textarea name="summary" id="message" class="required span6" rows="3" title="* Please enter your message"></textarea>
                                                        </div>
                                                        <div class="span2">
                                                                <label for="message">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;内&nbsp;&nbsp;&nbsp;&nbsp;容 <span>*</span> </label>
                                                        </div>
                                                        <div class="span6">
                                                                <textarea name="content" style="width:800px;height:720px;visibility:hidden;" class="required span6">请输入你的博客内容</textarea>
                                                        </div>

                                                        <div class="span6 offset2 "></div>
                                                        <div class="span6 offset2 "></div>
                                                        <div class="span6 offset2 "></div>
                                                        <div class="span6 offset2 "></div>
                                                        <div class="span6 offset2 "></div>
                                                        <div class="span6 offset2 "></div>
                                                        <div class="span6 offset2 bm30">
                                                                <input type="submit" name="submit" value="发布博客" class="btn btn-inverse" ">
                                                        </div>

                                                        <div class="span8 offset2" id="message-sent"></div>
                                                </form>
                                        </div>
                                </div>
                        </div>
                </div>
                <!-- End of Page Container -->
<%@ include file="../jsp/indexBottom.jsp"%>
        </body>
</html>

