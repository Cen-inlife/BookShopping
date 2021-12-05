<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!-- 引入c标签 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <c:set value="${pageContext.request.contextPath}" var="ctx"></c:set>

<nav class="navbar navbar-fixed-top navbar-inverse" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <a  class="navbar-brand " style="color: red" href="<c:url value="/article_manager/getAll.action"/>"><font color="red">麦兜书城-后台管理</font></a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
        
        	<ul class="nav navbar-nav">
        		<li class="active"><a href="<c:url value="/article_manager/getAll.action"/>"><font color="#FF0033">商品管理</font></a></li>
	            <li><a href="<c:url value="/articleType_manager/getAll.action"/>"><font color="#FF0033">商品类型管理</font></a></li>
	            <li><a href="<c:url value="/order_manager/getAll.action"/>"><font color="#FF0033">订单管理</font></a></li>
	            <li><a href="${ctx}/user/showUpdateUser.do"><font color="red">修改个人信息</font></a></li>
	            <c:if test="${session_user.role==2}">
		                 <li><a href="<c:url value="/user_manager/userList.action"/>"><font color="#FF0033">用户列表</font></a></li>
		        </c:if>
          	</ul>
          	
             <ul class="nav navbar-nav navbar-right">
					<c:choose>
						<c:when test="${not empty session_user}">
						  	<li><a href="#"> <span style='color: red;'></span>
							</a></li>
							<li><a href="#">欢迎[<font color="red">${session_user.name}</font>]访问!</a></li>
							<li><a href="${pageContext.request.contextPath}/user_manager/logout"><font color="red">退出</font></a></li>
							<li><a href="${pageContext.request.contextPath}/user_manager/showRegisterPage"><font color="green">注册</font></a></li>
						</c:when>
						<c:otherwise>
							<li><a href="#"> <span style='color: red;'></span>
							</a></li>
							<li><a href="${pageContext.request.contextPath}/user_manager/showLoginPage"><font color="green">登录</font></a></li>
							<li><a href="${pageContext.request.contextPath}/user_manager/showRegisterPage"><font color="green">注册</font></a></li>
						</c:otherwise>
						
					</c:choose>
					
					<li><a href="${pageContext.request.contextPath}/article/index"><font color="#FF0033">访问官网</font></a></li>
					
			</ul>
        </div>

    </div>
</nav>
