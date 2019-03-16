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
<script type="text/javascript">
	$(function(){
		$(".status").change(function(){
			//拿到状态的所指定的值
			var statu=$(this).val();
			var eoId=$(this).prev().val();
			var data="eoId="+eoId+"&statu="+statu;
			$.post("changStatuServlet",data,function(result){
				if(result=="true"){
					alert("状态修改成功！");
				}else{
					alert("状态修改失败！");
				}
			});
		});
	});
</script>
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
				<li><a href="index.html">首页</a></li>
				<li><a href="user.html">用户</a></li>
				<li><a href="product.html">商品</a></li>
				<li class="current"><a href="order.html">订单</a></li>
				<li><a href="guestbook.html">留言</a></li>
				<li><a href="news.html">新闻</a></li>
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
			<h2>订单管理</h2>
			<div class="manage">
				<div class="search"></div>
				<div class="spacer"></div>
				<form id="orderForm" method="post" action="orderServlet">
					订单号：<input type="text" class="text" name="entityId" id="entityId" />
					订货人：<input type="text" class="text" name="userName" /> <label
						class="ui-blue"><input type="submit" name="submit"
						value="查询" /> </label>
				</form>
				<table class="list">
					<c:forEach items="${orderDTOList}" var="orderDTO">
						<tr>
							<th colspan="2">单号：${orderDTO.order.eoId}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								时间：${orderDTO.order.eoCreateTTime}</th>
							<th colspan="2">
							<input type="hidden" class="eoId" value="${orderDTO.order.eoId}"/>
							<select name="status" class="status">
									<option value="1"
										<c:if test="${orderDTO.order.eoStatus==1}">selected="selected" </c:if>>待审核</option>
									<option value="2" <c:if test="${orderDTO.order.eoStatus==2}">selected="selected" </c:if>>审核通过</option>
									<option value="3" <c:if test="${orderDTO.order.eoStatus==3}">selected="selected" </c:if>>配货</option>
									<option value="4" <c:if test="${orderDTO.order.eoStatus==4}">selected="selected" </c:if>>发货</option>
									<option value="5" <c:if test="${orderDTO.order.eoStatus==5}">selected="selected" </c:if>>收货确认</option>

							</select>
							</th>
						</tr>
						<c:forEach items="${orderDTO.details}" var="orderDetail"
							varStatus="oo">
							<tr>
								<td class="first w4 c"><img
									src="../files/${orderDetail.pic}" />${orderDetail.name}</td>
								<td>${orderDetail.price}</td>
								<td>${orderDetail.eodQuantity}</td>
								<c:if test="${oo.first}">
									<td class="w1 c" rowspan="2">总计：${orderDTO.order.eoCost}</td>
								</c:if>
							</tr>
						</c:forEach>
					</c:forEach>

				</table>
				<div class="pager">
					<ul class="clearfix">
						<li>当前页/总页数: ${pageOrder.currPageNo}
							/${pageOrder.totalPageCount}</li>
						<c:if test="${pageOrder.currPageNo>1}">
							<li><a href="orderServlet?pageNo=1">首页</a></li>
							<li><a href="orderServlet?pageNo=${pageOrder.currPageNo-1 }">上一页</a>
							</li>
						</c:if>
						<c:if test="${pageOrder.currPageNo<pageOrder.totalPageCount}">
							<li><a href="orderServlet?pageNo=${pageOrder.currPageNo+1 }">下一页</a>
							</li>
							<li><a
								href="orderServlet?pageNo=${pageOrder.totalPageCount}">末页</a></li>
						</c:if>
					</ul>
				</div>
			</div>
		</div>
		<div class="clear"></div>
	</div>
	<div id="footer">Copyright &copy; 2013 北大青鸟 All Rights Reserved.
		京ICP证1000001号</div>
</body>
</html>
