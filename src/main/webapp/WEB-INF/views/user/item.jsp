<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../_partials/head.jsp" %>
<%@ include file="../_partials/header.jsp" %>
  <div class="row">
    <%@ include file="_sideNav.jsp" %>
    <div class="col-sm-9 col-xs-12">
        <div class="card">暂无动态:)</div>
    </div>
  </div>
<%@ include file="../_partials/footer.jsp" %>
<script>
  $(function () {
    $.get('/shop/user/item')
    .done(function (resp) {
      console.log(resp);
    })
    .fail(function (error) {
      console.log(error);
    });
  });
</script>