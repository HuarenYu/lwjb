<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../_partials/head.jsp" %>
<%@ include file="../_partials/header.jsp" %>
  <div class="row">
    <div class="col-xs-12 col-sm-3">
      <%@ include file="_sideNav.jsp" %>
    </div>
    <div class="col-xs-12 col-sm-9">
      <div class="panel panel-default">
        <div class="panel-heading">
          <h3 class="panel-title">后台</h3>
        </div>
        <div class="panel-body">
          <p>订单数：</p>
          <p>用户数：</p>
          <p>房源：</p>
        </div>
      </div>
    </div>
  </div>
<%@ include file="../_partials/footer.jsp" %>