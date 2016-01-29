<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="_partials/head.jsp" %>
<%@ include file="_partials/header.jsp" %>
<div class="row">
  <div class="col-xs-12">
    <div class="card index-banner">
      <h3>春节去哪儿？来我家呗！</h3>
      <p>和侗族人民一起过一个原生态的春节，杀猪，做年糕，上山采集，喝米酒，唱戏。带你体验最原滋原味的侗乡春节文化。</p>
    </div>
  </div>
</div>
<div class="row">
  <div class="item-list"></div>
</div>
<script>
  $(function() {
    $.get('/item/list/1', function(res) {
      var _itemList = '';
      res.data.forEach(function(item) {
        _itemList += tpl_item(item);
      });
      $('.item-list').html(_itemList);
    });
  });
</script>
<%@ include file="_partials/footer.jsp" %>