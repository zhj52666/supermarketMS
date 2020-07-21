<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="/SupermarketMS/admin/main.jsp">首页</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li><a href="/SupermarketMS/admin/checkstand.jsp">收银台<span class="sr-only">(current)</span></a></li>
        <li><a href="/SupermarketMS/categoryShow">商品分类管理</a></li>
        <li><a href="/SupermarketMS/productShow">商品库存管理</a></li>
        <li><a href="/SupermarketMS/toSaleShow">销售统计</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">其他功能 <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">角色管理</a></li>
            <li><a href="#">权限管理</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">用户管理</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">系统管理</a></li>
          </ul>
        </li>
      </ul>        
      <ul class="nav navbar-nav navbar-right">
        <li><a href="/SupermarketMS/logout">退出登录</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">${user.username}<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">简介</a></li>
            <li><a href="#">关于</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">联系我</a></li>
          </ul>
        </li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>