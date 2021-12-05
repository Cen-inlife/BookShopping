<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 引入c标签 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- 给项目取简称 -->
 <c:set value="${pageContext.request.contextPath}" var="ctx"></c:set>
    <!-- 横幅导航条开始 -->
	<nav class="navbar navbar-fixed-top navbar-default" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">显示导航条</span> <span class="icon-bar"></span> <span
						class="icon-bar"></span> <span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="${ctx}/article/index"><font color="#228b22">麦兜书城</font></a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="${ctx}/article/index"><font color="#228b22">首页</font></a></li>
					<li><a href="${ctx}/shopCar/showShopCar.do"><font color="#228b22">购物车</font></a></li>
					<li><a href="${ctx}/order/showOrder.do"><font color="#228b22">我的订单</font></a></li>
					<li><a href="${ctx}/user/showUpdateUser.do"><font color="red">修改个人信息</font></a></li>
				</ul>

				<ul class="nav navbar-nav navbar-right">
					<c:choose>
						<c:when test="${not empty session_user}">
						  	<li><a href="#"> <span style='color: red;'></span>
							</a></li>
							<li><a href="#">欢迎[<font color="red">${session_user.name}</font>]访问!</a></li>
							<li><a href="${ctx}/user/logout"><font color="red">退出</font></a></li>
							<li><a href="${ctx}/register"><font color="#228b22">注册</font></a></li>
							<!--管理员才能有这个菜单栏-->
							<c:if test="${session_user.role==2}">
							<li><a href="${ctx}/article_manager/getAll.action"><font color="#red">后台管理</font></a></li>
							</c:if>
						</c:when>
						<c:otherwise>
							<li><a href="#"> <span style='color: red;'></span>
							</a></li>
							<li><a href="${ctx}/login"><font color="#228b22">登录</font></a></li>
							<li><a href="${ctx}/register"><font color="#228b22">注册</font></a></li>
						</c:otherwise>
					</c:choose>
				</ul>
			</div>
		</div>
	</nav>