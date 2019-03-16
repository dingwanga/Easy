<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>易买网 - 首页</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="scripts/function.js"></script>
</head>
<body>
<div id="header" class="wrap">
	<div id="logo"><img src="images/logo.gif" /></div>
	<div class="help">
			<c:if test="${not empty user}">
				<span>欢迎您${user.euId},今天是${today}</span>
			</c:if>
			<c:if test="${not empty user}">
				<a href="shopping.html" id="shoppingBag" class="shopping">购物车X件</a>
			</c:if>
			<c:if test="${empty user}">
				<a href="login.jsp">登录</a>
			</c:if>
			<c:if test="${not empty user}">
				<a class="button" id="logout" href="loginOutServlet">注销</a>
			</c:if>
			<a href="register.jsp">注册</a>
			<c:if test="${not empty user}">
				<a href="guestbookServlet">留言</a>
			</c:if>
			<c:if test="${user.euStatus==2}">
				<a href="manage/index.jsp">后台管理</a>
			</c:if>
		</div>
	<div class="navbar">
		<ul class="clearfix">
			<li class="current"><a href="index.jsp">首页</a></li>
				<c:forEach items="${mapPc}" var="dataMap">
				<c:set var="paCategory" value="${dataMap.key}"></c:set>
				<li><a href="#">${paCategory.epcName}</a>
				</li>
				</c:forEach>
				<li><a href="#">促销</a>
				</li>
		</ul>
	</div>
</div>
<div id="childNav">
	<div class="wrap">
		<ul class="clearfix">
			<li class="first"><a href="#">音乐</a></li>
			<li><a href="#">影视</a></li>
			<li><a href="#">少儿</a></li>
			<li><a href="#">动漫</a></li>
			<li><a href="#">小说</a></li>
			<li><a href="#">外语</a></li>
			<li><a href="#">数码相机</a></li>
			<li><a href="#">笔记本</a></li>
			<li><a href="#">羽绒服</a></li>
			<li><a href="#">秋冬靴</a></li>
			<li><a href="#">运动鞋</a></li>
			<li><a href="#">美容护肤</a></li>
			<li><a href="#">家纺用品</a></li>
			<li><a href="#">婴幼奶粉</a></li>
			<li><a href="#">饰品</a></li>
			<li class="last"><a href="#">Investor Relations</a></li>
		</ul>
	</div>
</div>
<div id="register" class="wrap">
	<div class="shadow">
		<em class="corner lb"></em>
		<em class="corner rt"></em>
		<div class="box">
			<h1>欢迎注册易买网</h1>
			<ul class="steps clearfix">
				<li class="finished"><em></em>填写注册信息</li>
				<li class="last-current"><em></em>注册成功</li>
			</ul>
			<div class="msg">
				<c:if test="${msg eq 'true'}">	
						<p style="color:green">恭喜：操作成功！</p>
						<p style="color:green">正在进入首页...</p>
						<script type="text/javascript">
							setTimeout("location.href='index.jsp'", 1000);
						</script>
					</c:if>
					<c:if test="${msg eq 'false'}">	
						<p style="color:red">操作失败！</p>
						<p style="color:red">正在返回首页...</p>
						<script type="text/javascript">
							setTimeout("location.href='index.jsp'", 1000);
						</script>
					</c:if>
			</div>
		</div>
	</div>
</div>
<div id="footer">
	Copyright &copy; 2013 北大青鸟 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
