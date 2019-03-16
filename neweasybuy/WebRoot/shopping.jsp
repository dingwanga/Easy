<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>易买网 - 首页</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/jquery-1.8.3.js"></script>
<script type="text/javascript">
	function changNum(op,id){
		var num= parseInt($("#number"+id).val());
		if(op=="+"){
			num++;
		}else if(op=="-"){
			if(num>1){
				num--;
			}else{
				alert("商品数量不能小于1");
			}
		}
		$("#number"+id).val(num);
		window.location.href="updateNumServlet?id="+id+"&num="+num;
	}
</script>
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
				<li class="current"><a href="index.jsp">首页</a>
				</li>
				<c:forEach items="${mapPc}" var="dataMap">
					<c:set var="paCategory" value="${dataMap.key}"></c:set>
					<li><a href="#">${paCategory.epcName}</a></li>
				</c:forEach>
				<li><a href="#">促销</a></li>
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
	<div id="position" class="wrap">
		您现在的位置：<a href="index.html">易买网</a> &gt; 购物车
	</div>
	<div class="wrap">
		<c:choose>
			<c:when test="${empty sessionScope.cart.lines}">
				<h2 align="center" style="color:red">没有商品，请您先去购物！</h2>
			</c:when>
			<c:otherwise>
				<div id="shopping">
					<form action="showAdrressServlet" method="post">
						<table>
							<tr>
								<th>商品名称</th>
								<th>商品价格</th>
								<th>购买数量</th>
								<th>小计</th>
								<th>操作</th>
							</tr>
							<c:forEach items="${cart.lines}" var="line">
								<tr id="product_id_0">
									<td class="thumb"><img
										src="files/${line.product.epFileName}" width="110"
										height="106" /> <a href="product-view.html">${line.product.epDescription}</a>
									</td>
									<td class="price" id="price_id_0"><span>￥${line.product.epPrice}</span>
										<input type="hidden" value="99" /></td>
									<td class="number"><span name="del"
										onclick="changNum('-',${line.product.epId})">-</span> <input
										id="number${line.product.epId}" type="text" name="number"
										value="${line.count}"
										onblur="changNum('',${line.product.epId})" /> <span name="add"
										onclick="changNum('+',${line.product.epId})">+</span></td>
									<td class="price">${line.sum}</td>
									<td class="delete"><a
										href="delCartServlet?id=${line.product.epId}">删除</a>
									</td>
								</tr>
							</c:forEach>
						</table>
						<div class="total">
							<span id="total">总计：￥${cart.total}</span>
						</div>
						<div class="button">
							<input type="submit" value="" />
						</div>
					</form>
					<a href="clearCartServlet" style="color:green">清空购物车</a>
				</div>
			</c:otherwise>
		</c:choose>
	</div>
	<div id="footer">Copyright &copy; 2013 北大青鸟 All Rights Reserved.
		京ICP证1000001号</div>
</body>
</html>
