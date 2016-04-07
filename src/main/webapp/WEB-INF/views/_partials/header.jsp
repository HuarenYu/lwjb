<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<nav class="navbar navbar-fixed-top navbar-inverse">
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="/">来我家呗！</a>
    </div>
    <div id="navbar" class="collapse navbar-collapse">
      <ul class="nav navbar-nav">
        <li data-path="/"><a href="/">首页</a></li>
        <li data-path="/item"><a href="/item">出发</a></li>
        <li data-path="/post"><a href="/post">分享</a></li>
        <li data-path="/mall"><a href="/mall">特产</a></li>
        <li data-path="/about"><a href="/about">关于</a></li>
      </ul>
      <shiro:authenticated>
      <ul class="nav navbar-nav navbar-right">
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown"><shiro:principal type="java.lang.String"/> <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="/user/dashboard">个人中心</a></li>
            <li><a href="/user/order">我的订单</a></li>
            <li><a href="/user/item">我的出租</a></li>
            <li><a href="/user/settings">设置</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="/auth/logout">退出</a></li>
          </ul>
        </li>
      </ul>
      </shiro:authenticated>
      <shiro:guest> 
      <form class="navbar-form navbar-right">
        <a href="/auth/login" class="btn btn-success">登陆</a>
        <a href="/auth/register" class="btn btn-default">注册</a>
      </form>
      </shiro:guest>
    </div><!-- /.nav-collapse -->
  </div><!-- /.container -->
</nav><!-- /.navbar -->