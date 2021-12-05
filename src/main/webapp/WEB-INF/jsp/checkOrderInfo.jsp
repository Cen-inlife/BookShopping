<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set value="${pageContext.request.contextPath}" var="ctx"></c:set>

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
	<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
	<title>结算页</title>

	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/webbase.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/pages-getOrderInfo.css" />
	<link
			href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.css"
			rel="stylesheet" />
	<link href="${pageContext.request.contextPath}/resources/css/taobao.css"
		  rel="stylesheet" />
</head>

<body>
<!--head-->
<nav class="navbar navbar-fixed-top navbar-inverse" role="navigation">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
				<span class="sr-only">显示导航条</span> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="${ctx}/article/index">网上书城</a>
		</div>
		<div id="navbar" class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li class="active"><a href="${ctx}/article/index">首页</a></li>
				<li><a href="${ctx}/shopCar/showShopCar.do">购物车</a></li>
				<li><a href="${ctx}/order/showOrder.do">我的订单</a></li>
			</ul>

			<ul class="nav navbar-nav navbar-right">
				<c:choose>
					<c:when test="${not empty session_user}">
						<li><a href="#"> <span style='color: red;'></span>
						</a></li>
						<li><a href="#">欢迎[<font color="red">${session_user.name}</font>]访问!</a></li>
						<li><a href="${ctx}/user/logout">退出</a></li>
						<li><a href="${ctx}/register">免费注册</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="#"> <span style='color: red;'></span>
						</a></li>
						<li><a href="${ctx}/login">登录</a></li>
						<li><a href="${ctx}/register">免费注册</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
	</div>
</nav>

<div class="cart py-container">
	<!--logoArea-->
	<div class="logoArea">
		<div><h2 align="center">结算页</h2></div>

	</div>
	<!--主内容-->
	<div class="checkout py-container">
		<div class="checkout-tit">
			<h4 class="tit-txt">填写并核对订单信息</h4>
		</div>
		<div class="checkout-steps">
			<!--收件人信息-->
			<div class="step-tit">
				<h5>收件人信息<span></span></h5>
			</div>
			<div class="step-cont">
				<div class="addressInfo">
					<ul class="addr-detail">
						<li class="addr-item">

							<div>
								<div class="con name"><a href="javascript:;">${session_user.name}</a></div>
								<div class="con name"><a href="javascript:;">${session_user.phone}</a></div>
								<div class="con address">${session_user.address}
									<span class="base" ng-if="address.isDefault=='1'">默认地址</span>
								</div>
								<div class="clearfix"></div>
							</div>

						</li>


					</ul>
					<!--添加地址-->

					<!--确认地址-->
				</div>
				<div class="hr"></div>

			</div>
			<div class="hr"></div>
			<!--支付和送货-->
			<div class="payshipInfo">
				<div class="step-tit">
					<h5>支付方式</h5>
				</div>
				<div class="step-cont">
					<ul class="payType">
						<li class="selected" ng-click="selectPayType('1')">微信付款</li>
					</ul>
				</div>

				<div class="hr"></div>
			</div>
			<div class="linkInfo">
				<div class="step-tit">
					<h5>发票信息</h5>
				</div>
				<div class="step-cont">
					<span>普通发票（电子）</span>
					<span>个人</span>
					<span>明细</span>
				</div>
			</div>
			<div class="cardInfo">
				<div class="step-tit">
					<h5>使用优惠/抵用</h5>
				</div>
			</div>
		</div>
	</div>
</div>

<div class="submit">
	<a class="sui-btn btn-danger btn-xlarge" href="${pageContext.request.contextPath}/order/orderSubmit.do" >提交订单</a>
</div>
</div>
<!-- 底部栏位 -->
<!--页面底部-->
<!--页面底部END-->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/plugins/jquery/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/plugins/jquery.easing/jquery.easing.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/plugins/sui/sui.min.js"></script>
</body>

</html>