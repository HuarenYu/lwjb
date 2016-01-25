<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../_partials/head.jsp" %>
<%@ include file="../_partials/header.jsp" %>
<div class="row">
  <div class="col-xs-12 col-sm-9">
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
    
    <div class="item-details">
      <div class="panel panel-default">
        <div class="panel-heading">
          <h3 class="panel-title">家园详情</h3>
        </div>
        <div class="panel-body">
          <table class="table table-hover">
              <thead>
                <tr>
                  <th>日期</th>
                  <th>体验项目</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <th scope="row">2016-02-06</th>
                  <td>杀猪</td>
                </tr>
                <tr>
                  <th scope="row">2016-02-07</th>
                  <td>打粑粑</td>
                </tr>
                <tr>
                  <th scope="row">2016-02-08</th>
                  <td>春游</td>
                </tr>
                <tr>
                  <th scope="row">2016-02-09</th>
                  <td>听侗戏</td>
                </tr>
              </tbody>
            </table>
        </div>
      </div>
    
    </div>
  </div>

  <div class="col-xs-12 col-sm-3">
    <div class="panel panel-default">
      <div class="panel-heading">
        <h3 class="panel-title">立即预定</h3>
      </div>
      <div class="panel-body">
        <table class="table table-hover">
            <thead>
              <tr>
                <th>日期</th>
                <th>体验项目</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <th scope="row">2016-02-06</th>
                <td>杀猪</td>
              </tr>
              <tr>
                <th scope="row">2016-02-07</th>
                <td>打粑粑</td>
              </tr>
              <tr>
                <th scope="row">2016-02-08</th>
                <td>春游</td>
              </tr>
              <tr>
                <th scope="row">2016-02-09</th>
                <td>听侗戏</td>
              </tr>
            </tbody>
          </table>
      </div>
    </div>
  </div>
</div>
<%@ include file="../_partials/footer.jsp" %>
