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
          <h3 class="panel-title">添加房屋</h3>
        </div>
        <div class="panel-body">
          <form action="/item/add" method="post">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
            <div class="form-group">
              <label for="name">名字:</label>
              <input class="form-control" id="name" type="text" name="name" placeholder="房屋名字">
            </div>
            <div class="form-group">
              <label for="description">简介:</label>
              <textarea class="form-control" name="description" id="description" rows="3" placeholder="给房屋写一段很有吸引力的简介吧:)"></textarea>
            </div>
            <div class="form-group">
              <label for="price">单价:</label>
              <input class="form-control" name="price" id="price" rows="3" placeholder="请输入每天收费">
            </div>
            <div class="form-group">
              <label for="details">详情:</label>
              <!--style给定宽度可以影响编辑器的最终宽度-->
              <script name="details" type="text/plain" id="myEditor" style="width: 100%;">
                <p>房屋详情</p>
              </script>
            </div>
            <div class="form-group">
              <input class="btn btn-primary" type="submit" value="添加">
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
  <link rel="stylesheet" href="/assets/lib/ueditor/themes/default/css/umeditor.min.css">
  <script src="/assets/lib/ueditor/umeditor.config.js"></script>
  <script src="/assets/lib/ueditor/umeditor.min.js"></script>
  <script src="/assets/lib/ueditor/lang/zh-cn/zh-cn.js"></script>
  <script>
    //实例化编辑器
    var um = UM.getEditor('myEditor');
  </script>
<%@ include file="../_partials/footer.jsp" %>