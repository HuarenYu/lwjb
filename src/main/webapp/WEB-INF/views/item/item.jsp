<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../_partials/head.jsp" %>
<%@ include file="../_partials/header.jsp" %>
<div class="row">
  <div class="col-xs-12 col-sm-9">    
    <div class="card item-detail">
      <h3 class="title">${item.name}</h3>
      <div class="item-content">
        ${item.details}
      </div>
    </div>
  </div>
  <div class="col-xs-12 col-sm-3">
    <div class="order-box card card-default">
      <div class="card-heading">
        <h3 class="card-title">立即预定</h3>
      </div>
      <div class="card-body">
        <div class="order-price text-danger">¥${item.price}/天</div>
      </div>
      <div class="card-footer">
        <div class="order-action">
          <a href="/item/${item.id}/order" class="btn btn-success">立即预定</a>
        </div>
      </div>
    </div>
  </div>
</div>
<%@ include file="../_partials/footer.jsp" %>
