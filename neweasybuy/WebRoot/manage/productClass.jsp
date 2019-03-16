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
<script type="text/javascript">
		function delCategory(epcId) {
			if (confirm("是否要删除用户信息？")) {
				$.post("categoryDelServlet", "epcId=" + epcId, callBack);
				function callBack(data) {
					if(data=="true"){
						location.href="manage-result.jsp?msg=true";
					}else{
						location.href="manage-result.jsp?msg=false";
					}
				}
			}else{
				return false;
			}

		}
	</script>
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
				<dd><a href="userServlet">用户管理</a></dd>
			  <dt>商品信息</dt>
				<dd><em><a href="productClass-add.jsp">新增</a></em><a href="productClassServlet">分类管理</a></dd>
				<dd><em><a href="productAddServlet">新增</a></em><a href="productServlet">商品管理</a></dd>
				<dt>订单管理</dt>
				<dd><a href="orderServlet">订单管理</a></dd>
				<dt>留言管理</dt>
				<dd><a href="commentServlet">留言管理</a></dd>
				<dt>新闻管理</dt>
				<dd><em><a href="news-add.jsp">新增</a></em><a href="newsServlet">新闻管理</a></dd>
				</dl>
			</div>
		</div>
		<div class="main">
			<h2>分类管理</h2>
			<div class="manage">
				<table class="list">

					<tr>
						<th>编号</th>
						<th>分类名称</th>
						<th>操作</th>
					</tr>
					<c:forEach items="${mapPc}" var="dataMap">
					 <c:set var="paCategory" value="${dataMap.key}"></c:set>
					 <c:set var="clCategory" value="${dataMap.value}"></c:set>
						<tr>
							<td class="first w4 c">${paCategory.epcId}</td>
							<td>${paCategory.epcName}</td>
							<td class="w1 c"><a href="prClassmfyServlet?id=${paCategory.epcId}">修改</a> <a
								class="manageDel" href="javascript:delCategory(${paCategory.epcId})">删除</a>
							</td>
						</tr>
						<c:forEach items="${clCategory}" var="cCategory">						
							<tr>
								<td class="first w4 c">${cCategory.epcId}</td>
								<td class="childClass">${cCategory.epcName}</td>
								<td class="w1 c"><a href="prClassmfyServlet?id=${cCategory.epcId}">修改</a>
									<a class="manageDel" href="javascript:delCategory(${cCategory.epcId})">删除</a>
								</td>
							</tr>
						</c:forEach>
					</c:forEach>
				</table>
			</div>
		</div>
		<div class="clear"></div>
		<div class="pager">
			<ul class="clearfix">
				<li>当前页/总页数: ${pCategory.currPageNo} /${pCategory.totalPageCount}</li>
				<c:if test="${pCategory.currPageNo>1}">
					<li><a href="productClassServlet?pageNo=1">首页</a>
					</li>
					<li><a href="productClassServlet?pageNo=${pCategory.currPageNo-1 }">上一页</a>
					</li>
				</c:if>
				<c:if test="${pCategory.currPageNo<pCategory.totalPageCount}">
					<li><a href="productClassServlet?pageNo=${pCategory.currPageNo+1 }">下一页</a>
					</li>
					<li><a href="productClassServlet?pageNo=${pCategory.totalPageCount}">末页</a>
					</li>
				</c:if>
			</ul>
		</div>
	</div>
	<div id="footer">Copyright &copy; 2013 北大青鸟 All Rights Reserved.
		京ICP证1000001号</div>
</body>
</html>