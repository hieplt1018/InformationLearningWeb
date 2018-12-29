<%-- 
    Document   : newsSide
    Created on : Dec 29, 2018, 9:26:53 AM
    Author     : Admin
--%>

<%@page import="model.News"%>
<%@page import="java.util.ArrayList"%>
<%@page import="controller.NewsUpdateControl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    NewsUpdateControl newsCtr = new NewsUpdateControl();
    ArrayList<News> newsListPost = newsCtr.getNewsPost();
    ArrayList<News> newsGiaoVuList = newsCtr.getNewsGiaoVu();
    ArrayList<News> newsTTKTList = newsCtr.getNewsTTKT();    
%>
     

<!-- post widget -->
<div class="aside-widget">
    <div class="section-title">
        <h2>Tin mới</h2>
    </div>

    <div class="post post-thumb">
        <a class="post-img" href="<%=newsListPost.get(0).getUrl()%>"><img src="<%=newsListPost.get(0).getImage()%>" alt=""></a>
        <div class="post-body">
            <div class="post-meta">
                <a class="post-category cat-2" href="#"><%=newsListPost.get(0).getCategory()%></a>
            </div>
            <h3 class="post-title"><a href="<%=newsListPost.get(0).getUrl()%>"><%=newsListPost.get(0).getTitle()%></a></h3>
        </div> 
    </div>

    <div class="post post-thumb">
        <a class="post-img" href="<%=newsGiaoVuList.get(1).getUrl()%>"><img src="<%=newsGiaoVuList.get(1).getImage()%>" alt=""></a>
        <div class="post-body">
            <div class="post-meta">
                <a class="post-category cat-3" href="#"><%=newsGiaoVuList.get(1).getCategory()%></a>
            </div>
            <h3 class="post-title"><a href="<%=newsGiaoVuList.get(1).getUrl()%>"><%=newsGiaoVuList.get(1).getTitle()%></a></h3>
        </div>
    </div>
</div>
<!-- /post widget -->

<!-- catagories -->
<div class="aside-widget">
    <div class="section-title">
        <h2>Catagories</h2>
    </div>
    <div class="category-widget">
        <ul>
            <li><a href="#" class="cat-2">Tin tức<span>74</span></a></li>
            <li><a href="#" class="cat-4">TTKT<span>41</span></a></li>
            <li><a href="#" class="cat-3">Giáo vụ<span>35</span></a></li>
        </ul>
    </div>
</div>
<!-- /catagories -->

<!-- tags -->
<div class="aside-widget">
    <div class="tags-widget">
        <ul>
            <li><a href="#">Chrome</a></li>
            <li><a href="#">CSS</a></li>
            <li><a href="#">Tutorial</a></li>
            <li><a href="#">Backend</a></li>
            <li><a href="#">JQuery</a></li>
            <li><a href="#">Design</a></li>
            <li><a href="#">Development</a></li>
            <li><a href="#">JavaScript</a></li>
            <li><a href="#">Website</a></li>
        </ul>
    </div>
</div>
<!-- /tags -->

<!-- archive -->
<div class="aside-widget">
    <div class="section-title">
        <h2>Archive</h2>
    </div>
    <div class="archive-widget">
        <ul>
            <li><a href="#">Jan 2018</a></li>
            <li><a href="#">Feb 2018</a></li>
            <li><a href="#">Mar 2018</a></li>
        </ul>
    </div>
</div>
<!-- /archive -->