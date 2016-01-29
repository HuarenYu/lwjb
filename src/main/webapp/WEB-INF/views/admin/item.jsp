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
          <h3 class="panel-title">房屋管理</h3>
        </div>
        <div class="panel-body">
          <div class="action-bar">
            <a href="/admin/item/add" class="btn btn-primary">添加</a>
          </div>
          <table class="table table-hover">
            <thead>
              <tr>
                <th>编号</th>
                <th>名字</th>
                <th>操作</th>
              </tr>
            </thead>
            <tbody id="itemList">
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </div>
<script>
$(function() {
  $(function() {
    $.get('/item/list/1', function(res) {
      var _itemList = '';
      res.data.forEach(function(item) {
        _itemList += tpl_item_admin_list(item);
      });
      $('#itemList').html(_itemList);
    });
  });
});
</script>
<%@ include file="../_partials/footer.jsp" %>