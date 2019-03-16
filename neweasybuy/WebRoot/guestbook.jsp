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
	<div id="position" class="wrap">
		您现在的位置：<a href="index.html">易买网</a> &gt; 在线留言
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
		</div>
		<div class="main">
			<div class="guestbook">
				<h2>全部留言</h2>
				<ul>
					<c:forEach items="${pageComment.pageList}" var="comment">
						<li>
							<dl>
								<dt>${comment.ecContent}</dt>
								<dd class="author">
									网友：${comment.ecNickName}<span class="timer">${comment.ecReplyTime}</span>
								</dd>
								<dd>${comment.ecReply}</dd>
							</dl>
						</li>
					</c:forEach>
				</ul>
				<div class="clear"></div>
				<div class="pager">
					<ul class="clearfix">
						<li>当前页/总页数: ${pageComment.currPageNo}
							/${pageComment.totalPageCount}</li>
						<c:if test="${pageComment.currPageNo>1}">
							<li><a href="guestbookServlet?pageNo=1">首页</a></li>
							<li><a
								href="guestbookServlet?pageNo=${pageComment.currPageNo-1 }">上一页</a>
							</li>
						</c:if>
						<c:if test="${pageComment.currPageNo<pageComment.totalPageCount}">
							<li><a
								href="guestbookServlet?pageNo=${pageComment.currPageNo+1 }">下一页</a>
							</li>
							<li><a
								href="guestbookServlet?pageNo=${pageComment.totalPageCount}">末页</a>
							</li>
						</c:if>
					</ul>
				</div>
				<div id="reply-box">
					<form action="guestServlet" method="post">
						<table>
							<tr>
								<td class="field">昵称：</td>
								<td><input class="text" type="text" name="guestName"
									 value="${user.euId}" readonly="readonly" />
								</td>
							</tr>
							<tr>
								<td class="field">留言内容：</td>
								<td><textarea name="guestContent"></textarea><span></span>
								</td>
							</tr>
							<tr>
								<td></td>
								<td><label class="ui-blue"><input type="submit"
										name="submit" value="提交留言" /> </label></td>
							</tr>
						</table>
					</form>
				</div>
			</div>
		</div>
		<div class="clear"></div>
	</div>
	<div id="footer">Copyright &copy; 2013 北大青鸟 All Rights Reserved.
		京ICP证1000001号</div>
</body>
</html>
