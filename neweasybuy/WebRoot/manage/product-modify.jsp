<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理 - 易买网</title>
<link type="text/css" rel="stylesheet" href="../css/style.css" />
<script type="text/javascript" src="../scripts/jquery-1.8.3.js"></script>
<script type="text/javascript" src="../scripts/function.js"></script>
</head>
<body>
	<div id="header" class="wrap">
		<div id="logo">
			<img src="../images/logo.gif" />
		</div>
		<div class="help">
			<a href="../index.jsp">返回前台页面</a>
		</div>
		<div class="navbar">
			<ul class="clearfix">
				<li><a href="index.html">首页</a>
				</li>
				<li><a href="user.html">用户</a>
				</li>
				<li class="current"><a href="product.html">商品</a>
				</li>
				<li><a href="order.html">订单</a>
				</li>
				<li><a href="guestbook.html">留言</a>
				</li>
				<li><a href="news.html">新闻</a>
				</li>
			</ul>
		</div>
	</div>
	<div id="childNav">
		<div class="welcome wrap">管理员${user.euId}您好，今天是${today}，欢迎回到管理后台。</div>
	</div>
	<div id="position" class="wrap">
		您现在的位置：<a href="index.html">易买网</a> &gt; 管理后台
	</div>
	<div id="main" class="wrap">
		<div id="menu-mng" class="lefter">
			<div class="box">
				<dl>
					<dt>用户管理</dt>
					<dd>
						<a href="userServlet">用户管理</a>
					</dd>
					<dt>商品信息</dt>
					<dd>
						<em><a href="productClass-add.jsp">新增</a>
						</em><a href="productClassServlet">分类管理</a>
					</dd>
					<dd>
						<em><a href="productAddServlet">新增</a>
						</em><a href="productServlet">商品管理</a>
					</dd>
					<dt>订单管理</dt>
					<dd>
						<a href="orderServlet">订单管理</a>
					</dd>
					<dt>留言管理</dt>
					<dd>
						<a href="commentServlet">留言管理</a>
					</dd>
					<dt>新闻管理</dt>
					<dd>
						<em><a href="news-add.jsp">新增</a>
						</em><a href="newsServlet">新闻管理</a>
					</dd>
				</dl>
			</div>
		</div>
		<div class="main">
			<h2>修改商品</h2>
			<div class="manage">
				<form action="productUpdateServlet"
					enctype="multipart/form-data" method="post">
					<input type="hidden" value="${product.epId}" name="epId"/>
					<table class="form">
						<tr>
							<td class="field">商品名称(*)：</td>
							<td><input type="text" class="text" name="productName"
								value="${product.epName}" />
							</td>
						</tr>
						<tr>
							<td class="field">描述：</td>
							<td><input type="text" class="text" name="productName"
								value="${product.epDescription}" />
							</td>
						</tr>
						<tr>
							<td class="field">所属分类：</td>
							<td><select name="parentId">
									<c:forEach items="${pMap}" var="dataMap">
										<c:set var="paCategory" value="${dataMap.key}"></c:set>
										<c:set var="clCategory" value="${dataMap.value}"></c:set>
										<option value="${paCategory.epcId}">${paCategory.epcName}</option>
										<c:forEach items="${clCategory}" var="cCategory"
											varStatus="ca">
											<option value="${cCategory.epcId}">└
												${cCategory.epcName}</option>
										</c:forEach>
									</c:forEach>
							</select></td>
						</tr>
						<tr>
							<td class="field">商品价格(*)：</td>
							<td><input type="text" class="text tiny" name="productPrice"
								value="${product.epPrice}" /> 元</td>
						</tr>

						<tr>
							<td class="field">库存(*)：</td>
							<td><input type="text" class="text tiny" name="productNumber"
								value="${product.epStock}" />
							</td>
						</tr>
						<tr>
							<td class="field"></td>
							<td><p style="color:red">${msg}</p></td>
						</tr>
						<tr>
							<td class="field">商品图片：</td>
							<td><input type="file" class="text" name="photo" />
							</td>
						</tr>
						<tr>
							<td></td>
							<td><label class="ui-blue"><input type="submit"
									name="submit" value="确定" />
							</label>
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
		<div class="clear"></div>
	</div>
	<div id="footer">Copyright &copy; 2013 北大青鸟 All Rights Reserved.
		京ICP证1000001号</div>
</body>
</html>