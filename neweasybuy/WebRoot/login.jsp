<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>易买网 - 首页</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/jquery-1.8.3.js"></script>
<script type="text/javascript" src="scripts/function.js"></script>
</head>
<body>
	<div id="header" class="wrap">
		<div id="logo">
			<img src="images/logo.gif" />
		</div>
		<div class="help">
			<a href="login.jsp">登录</a>
			<a href="register.jsp">注册</a>
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
	<div id="register" class="wrap">
		<div class="shadow">
			<em class="corner lb"></em> <em class="corner rt"></em>
			<div class="box">
				<h1>欢迎回到易买网</h1>
				<form id="loginForm" method="post" action="userLoginServlet">
					<table>
						<tr>
							<td class="field"></td>
							<td><p style="color:red">${msg}</p></td>
						</tr>
						<tr>
							<td class="field">用户名：</td>
							<td><input class="text" type="text" id="userId"
								name="userId" /> <span></span></td>
						</tr>
						<tr>
							<td class="field">登录密码：</td>
							<td><input class="text" type="password" id="password"
								name="password" /> <span></span></td>
						</tr>
						<tr>
							<td class="field">验证码：</td>
							<td><img src="Number.jsp" id="safeCode" /><a id="changeCode"
								href="#">看不清，换一张</a><br /> <input type="text" name="code" />
							<div class="mess">
									<span></span>
								</div></td>
						</tr>
						<tr>
							<td></td>
							<td><label class="ui-green"><input type="submit"
									name="submit" value="立即登录" />
							</label>
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
		<div class="clear"></div>
	</div>
	<div id="footer">Copyright &copy; 2010 北大青鸟 All Rights Reserved.
		京ICP证1000001号</div>
</body>
</html>