<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

<!DOCTYPE html>
<html>
<head lang="en">
	<meta charset="UTF-8">
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.3.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
  <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
	<title></title>
  <script>
    $(function(){
    	
     $("#capture").click(function(){
    	alert("hhhh");
        $.ajax({
          url: "capture",
          type: "post",
          dataType: "json",
          success: function(data){
            if(data.flag == 1){
            	alert("抓取成功");
            }else{
            	alert("抓取失败");
            }
          },
          error: function(){
            alert("抓取失败");
          }
        });
      }); 
    });
  </script>

</head>
<body>
  <div class="container">
    <!--导航栏开始-->
    <div class="head col-md-offset-3 col-md-6 page-header">
      <nav class="navbar navbar-default navbar-static-top">
        <div class="navbar-header">
          <div class="navbar-brand">
            <a href="#">
              <span class="glyphicon glyphicon-home"></span>
            </a>
          </div>
        </div>
        <div class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li><a id="capture" href="#"><strong>一键抓取</strong></a></li>
            <li><a href="${pageContext.request.contextPath }/list/1"><strong>浏览</strong></a></li>
          </ul>
          <form class="navbar-form navbar-right">
            <div class="form-group input-group">
              <span class="input-group-addon glyphicon glyphicon-search"></span>
              <input type="text" class="form-control" placeholder="search">
            </div>
            <button type="submit" class="btn btn-default">搜索</button>
          </form>
        </div>
      </nav>
    </div>
    <!--导航栏结束-->

    <div class="panel panel-success" style="margin-top: 180px" >
      <div class="panel panel-heading">
        文章列表
      </div>
      <div class="panel-body">
        <table class="table table-hover">
          <caption class="text-center">文章列表</caption>
          <thead>
            <tr>
              <td>作者</td><td>文章名</td><td>文章链接</td><td>回复数</td><td>浏览数</td>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>作者</td><td>文章名</td><td>文章链接</td><td>回复数</td><td>浏览数</td>
            </tr>
            <tr>
              <td>作者</td><td>文章名</td><td>文章链接</td><td>回复数</td><td>浏览数</td>
            </tr>
          </tbody>
        </table>
      </div>
      <div class="panel-footer">

          <ul class="pagination" style="margin-top: 0px; margin-bottom: 0px; margin-left: 400px">
            <li><a href="#">&laquo;</a></li>
            <li><a href="#">1</a></li>
            <li><a href="#">2</a></li>
            <li><a href="#">3</a></li>
            <li><a href="#">4</a></li>
            <li><a href="#">5</a></li>
            <li><a href="#">&raquo;</a></li>
          </ul>

      </div>
    </div>
  </div>
</body>
</html>
