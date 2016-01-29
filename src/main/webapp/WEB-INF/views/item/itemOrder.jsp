<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../_partials/head.jsp" %>
<%@ include file="../_partials/header.jsp" %>
<div class="row">
  <div class="col-xs-12 col-sm-6 col-sm-offset-3">
    <div class="order-box card card-default">
      <div class="card-heading">
        <h3 class="card-title">立即预定</h3>
      </div>
      <div class="card-body">
        <form id="orderAddForm" class="form-horizontal" action="/order/add" method="post">
          <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
          <div class="form-group">
            <label class="col-sm-3 control-label">预定：</label>
            <div class="col-sm-9">
              <input type="hidden" name="itemId" value="${item.id}">
              <input type="hidden" name="comment" value="${item.name}">
              <input class="form-control" type="text" value="${item.name}" disabled>
            </div>
          </div>
          <div class="form-group">
            <label for="consumerName" class="col-sm-3 control-label">姓名：</label>
            <div class="col-sm-9">
              <input id="consumerName" class="form-control" type="text" name="consumerName">
            </div>
          </div>
          <div class="form-group">
            <label for="phone" class="col-sm-3 control-label">联系电话：</label>
            <div class="col-sm-9">
              <input id="phone" class="form-control" type="text" name="consumerPhone">
            </div>
          </div>
        </form>
      </div>
      <div class="card-footer">
        <div class="order-action">
          <input id="orderBtn" type="submit" class="btn btn-success" value="立即预定">
        </div>
      </div>
    </div>
  </div>
</div>
<script>
  $form = $('#orderAddForm');
  $('#orderBtn').on('click', function(e) {
    $.post('/order/add', $form.serialize(), function(resp) {
      if (resp.statusCode != 200) {
        alert(resp.statusMsg);
        return;
      }
      alert("提交成功，工作人员会尽快与你联系，安排行程。");
    });
  });
</script>
<%@ include file="../_partials/footer.jsp" %>
