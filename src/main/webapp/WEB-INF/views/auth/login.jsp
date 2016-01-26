<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../_partials/head.jsp" %>
<%@ include file="../_partials/header.jsp" %>
<div class="row">
  <div class="col-sm-12 col-md-6 col-md-offset-3">
    <div class="panel panel-default">
      <div class="panel-heading">
        <h3 class="panel-title">登陆</h3>
      </div>
      <div class="panel-body">
        <form class="form-horizontal" action="/auth/login" method="post">
          <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
          <div class="form-group">
            <label for="username" class="col-sm-3 control-label">用户名：</label>
            <div class="col-sm-9">
              <input id="username" class="form-control" type="text" name="username">
            </div>
          </div>
          <div class="form-group">
            <label for="password" class="col-sm-3 control-label">密码：</label>
            <div class="col-sm-9">
              <input id="password" class="form-control" type="password" name="password">
            </div>
          </div>
          <div class="form-group">
            <div class="col-sm-offset-3 col-sm-9">
              <div class="checkbox">
                <label for="rememberMe">
                  <input id="rememberMe" type="checkbox" name="rememberMe" value="true"> 记住
                </label>
              </div>
            </div>
          </div>
          <div class="form-group">
            <div class="col-sm-offset-3 col-sm-9">
              <button type="submit" class="btn btn-default">登陆</button>
            </div>
          </div>
        </form>
      </div>
    </div>
  </div>
</div>
<%@ include file="../_partials/footer.jsp" %>