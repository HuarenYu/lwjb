<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="_partials/head.jsp" %>
<%@ include file="_partials/header.jsp" %>
<div class="row">
  <div class="col-xs-12 col-sm-9">
    <div class="card about-detail">
      <form action="/proccessFileUpload?${_csrf.parameterName}=${_csrf.token}" method="post" enctype="multipart/form-data">
        <input type="file" name="image">
        <input type="submit" value="upload">
      </form>
    </div>
  </div>
  <div class="col-xs-12 col-sm-3">
    <div class="card card-default">
      <div class="card-heading">
        <h3 class="card-title">联系我们</h3>
      </div>
      <div class="card-body">
        <p>电话：18514031568</p>
        <p>邮箱：codegeek@qq.com</p>
      </div>
    </div>
    <div class="card card-default">
      <div class="card-heading">
        <h3 class="card-title">加入我们</h3>
      </div>
      <div class="card-body">
        <p>如果你也想和我们一起重建家园，赶快联系我们吧！</p>
      </div>
    </div>
  </div>
</div>
<%@ include file="_partials/footer.jsp" %>