<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
 <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
        <head>
                <meta name="viewport" content="width=device-width, initial-scale=1.0">

                <title>Knowledge Forums Theme</title>

                <link rel="shortcut icon" href="<%=basePath%>/images/favicon.png" />

                <!-- Style Sheet-->
                <link rel="stylesheet" href="<%=basePath%>css/style.css"/>
                <link rel='stylesheet' id='bootstrap-css-css'  href='<%=basePath%>css/bootstrap5152.css?ver=1.0' type='text/css' media='all' />
                <link rel='stylesheet' id='responsive-css-css'  href='<%=basePath%>css/responsive5152.css?ver=1.0' type='text/css' media='all' />
                <link rel='stylesheet' id='pretty-photo-css-css'  href='<%=basePath%>js/prettyphoto/prettyPhotoaeb9.css?ver=3.1.4' type='text/css' media='all' />
                <link rel='stylesheet' id='main-css-css'  href='<%=basePath%>css/main5152.css?ver=1.0' type='text/css' media='all' />
                <link rel='stylesheet' id='custom-css-css'  href='<%=basePath%>css/custom5152.html?ver=1.0' type='text/css' media='all' />


                <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
                <!--[if lt IE 9]>
                <script src="js/html5.js"></script>
                <![endif]-->

        </head>

        <body>

                <!-- Start of Header -->
                <div class="header-wrapper">
                        <header>
                                <div class="container">


                                        <div class="logo-container">
                                                <!-- Website Logo -->
                                                <a href="<%=basePath%>/jsp/index-2.jsp"  title="Knowledge Forums Theme">
                                                        <img src="<%=basePath%>/images/logo.png" alt="Knowledge Forums Theme">
                                                </a>
                                                <span class="tag-line">欢迎登录：:${user.name }</span>
                                        </div>


                                        <!-- Start of Main Navigation -->
                                        <nav class="main-nav">
                                                <div class="menu-top-menu-container">
                                                        <ul id="menu-top-menu" class="clearfix">
                                                                <li class="current-menu-item"><a href="<%=basePath%>SpecificBlogServlet">Home</a></li>
                                                                <li><a href="<%=basePath%>jsp/PublishBlog.jsp">PublishBlog</a></li>
                                                                <li><a href="<%=basePath%>getInChat">chat APP</a></li>
                                                                <li><a href="<%=basePath%>PageServlet">Articles List</a></li>
                                                                <li><a href="<%=basePath%>/jsp/faq.jsp">FAQs</a></li>
                                                                <li><a href="#">Skins</a>
                                                                        <ul class="sub-menu">
                                                                                <li><a href="<%=basePath%>/jsp/blue-skin.jsp">Blue Skin</a></li>
                                                                                <li><a href="<%=basePath%>/jsp/green-skin.jsp">Green Skin</a></li>
                                                                                <li><a href="<%=basePath%>/jsp/red-skin.jsp">Red Skin</a></li>
                                                                                <li><a href="<%=basePath%>/jsp/index-2.jsp">Default Skin</a></li>
                                                                        </ul>
                                                                </li>
                                                                <li><a href="#">More</a>
                                                                        <ul class="sub-menu">
                                                                                <li><a href="<%=basePath%>/jsp/full-width.jsp">Full Width</a></li>
                                                                                <li><a href="<%=basePath%>/jsp/elements.jsp">Elements</a></li>
                                                                                <li><a href="<%=basePath%>/jsp/page.jsp">Sample Page</a></li>
                                                                        </ul>
                                                                </li>
                                                                <li><a href="<%=basePath%>/jsp/contact.jsp">Contact</a></li>
                                                        </ul>
                                                </div>
                                        </nav>
                                        <!-- End of Main Navigation -->

                                </div>
                        </header>
                </div>
                <!-- End of Header -->

