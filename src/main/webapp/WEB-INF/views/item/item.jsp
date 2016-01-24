<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../_partials/head.jsp" %>
<%@ include file="../_partials/header.jsp" %>
<div class="row">
  <div class="col-sm-12">
    <div class="index-carousel">
      <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
        <!-- Indicators -->
        <ol class="carousel-indicators">
          <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
          <li data-target="#carousel-example-generic" data-slide-to="1"></li>
          <li data-target="#carousel-example-generic" data-slide-to="2"></li>
        </ol>
        <!-- Wrapper for slides -->
        <div class="carousel-inner" role="listbox">
          <div class="item active">
            <img src="http://i3.mifile.cn/a4/T1.QYjBgVT1RXrhCrK.jpg" alt="...">
          </div>
          <div class="item">
            <img src="http://i3.mifile.cn/a4/T1.QYjBgVT1RXrhCrK.jpg" alt="...">
          </div>
          <div class="item">
            <img src="http://i3.mifile.cn/a4/T1.QYjBgVT1RXrhCrK.jpg" alt="...">
          </div>
        </div>
        <!-- Controls -->
        <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
          <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
          <span class="sr-only">Previous</span>
        </a>
        <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
          <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
          <span class="sr-only">Next</span>
        </a>
      </div>
    </div>
  </div>
</div>
<div class="row">
  <div class="items">
    <div class="col-xs-12 col-sm-6 col-md-3">
      <div class="thumbnail">
        <img src="/assets/dist/images/52.jpg" alt="...">
        <div class="caption">
          <h3>Thumbnail label</h3>
          <p>...</p>
          <p>
            <a href="#" class="btn btn-primary" role="button">Button</a>
            <a href="#" class="btn btn-default" role="button">Button</a>
          </p>
        </div>
      </div>
    </div>
  </div>
</div>
<%@ include file="../_partials/footer.jsp" %>