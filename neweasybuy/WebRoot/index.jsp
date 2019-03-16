<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>易买网 - 首页</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/jquery-1.8.3.js"></script>
<script type="text/javascript" src="scripts/function.js"></script>
</head>
<body>
	<c:if test="${empty newsList}">
		<script type="text/javascript">
			location.href = "homeServlet";
		</script>
	</c:if>
	<div id="welcomeImage">
		<img width="100%" height="150" src="images/banner.jpg" alt="welcome" />
	</div>
	<div id="header" class="wrap">
		<div id="logo">
			<img src="images/logo.gif" />
		</div>
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
				<li class="first"><a href="#">音乐</a>
				</li>
				<li><a href="#">影视</a>
				</li>
				<li><a href="#">少儿</a>
				</li>
				<li><a href="#">动漫</a>
				</li>
				<li><a href="#">小说</a>
				</li>
				<li><a href="#">外语</a>
				</li>
				<li><a href="#">数码相机</a>
				</li>
				<li><a href="#">笔记本</a>
				</li>
				<li><a href="#">羽绒服</a>
				</li>
				<li><a href="#">秋冬靴</a>
				</li>
				<li><a href="#">运动鞋</a>
				</li>
				<li><a href="#">美容护肤</a>
				</li>
				<li><a href="#">家纺用品</a>
				</li>
				<li><a href="#">婴幼奶粉</a>
				</li>
				<li><a href="#">饰品</a>
				</li>
				<li class="last"><a href="#">Investor Relations</a>
				</li>
			</ul>
		</div>
	</div>
	<div id="main" class="wrap">
		<div class="lefter">
			<div class="box">
				<h2>商品分类</h2>
				<dl>
					<c:forEach items="${mapPc}" var="dataMap">
						<c:set var="paCategory" value="${dataMap.key}"></c:set>
						<c:set var="clCategory" value="${dataMap.value}"></c:set>
						<dt>${paCategory.epcName}</dt>
						<c:forEach items="${clCategory}" var="cCategory">
						<dd>
							<a href="productlistServlet?id=${cCategory.epcId}">${cCategory.epcName}</a>
						</dd>
						</c:forEach>
					</c:forEach>
				</dl>
			</div>
			<div class="spacer"></div>
			<div class="last-view">
				<h2>最近浏览</h2>
				<dl class="clearfix">
				<c:forEach items="${list}" var="product">
					<dt>
						<img src="files/${product.epFileName}" width="90%" height="90%"/>
					</dt>
					<dd>
						<a href="productviewServlet?id=${product.epId}" target="_self">${product.epName}</a><a
							href="productviewServlet?id=${product.epId}"></a>
					</dd>
					</c:forEach>
				</dl>
			</div>
		</div>
		<div class="main">
			<div class="price-off">
				<div class="slideBox">
					<ul id="slideBox">
						<li><img src="images/product/banner_1.jpg" />
						</li>
						<li><img src="images/product/banner_2.jpg" />
						</li>
						<li><img src="images/product/banner_3.jpg" />
						</li>
						<li><img src="images/product/banner_4.jpg" />
						</li>
					</ul>
				</div>
				<h2>商品列表</h2>
				<ul class="product clearfix">
					<c:forEach items="${pbProduct.pageList}" var="product">
						<li>
							<dl>
								<dt>
									<a href="productviewServlet?id=${product.epId}" target="_self"><img
										src="files/${product.epFileName}" />
									</a>
								</dt>
								<dd class="title">
									<a href="productviewServlet?id=${product.epId}" target="_self">${product.epName}</a>
								</dd>
								<dd class="price">￥${product.epPrice }</dd>
							</dl></li>
					</c:forEach>
				</ul>
				当前页/总页数: ${pbProduct.currPageNo} /${pbProduct.totalPageCount}
				<c:if test="${pbProduct.currPageNo>1}">
					<a href="homeServlet?pageNo=1">首页</a>
					<a href="homeServlet?pageNo=${pbProduct.currPageNo-1 }">上一页</a>
				</c:if>
				<c:if test="${pbProduct.currPageNo<pbProduct.totalPageCount}">
					<a href="homeServlet?pageNo=${pbProduct.currPageNo+1 }">下一页</a>
					<a href="homeServlet?pageNo=${pbProduct.totalPageCount}">末页</a>
				</c:if>
			</div>
			<div class="side">
				<div class="spacer"></div>
				<div class="news-list">
					<h4>新闻动态</h4>
					<ul>
						<c:forEach items="${newsList}" var="news">
							<li><a href="newsShowServlet?id=${news.enId}" target="_self">${news.enTitle}</a>
							</li>
						</c:forEach>
					</ul>
				</div>
			</div>
			<div class="spacer clear"></div>
		</div>
	</div>
	<div id="footer">Copyright &copy; 2013 北大青鸟 All Rights Reserved.
		京ICP证1000001号</div>
</body>
</html>
