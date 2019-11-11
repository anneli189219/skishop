<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示购物车</title>
</head>
<body>
	<h1 align="center">购物车列表</h1>
	<c:if test="${empty(cart.map) }">
		<table border="3" align="center">
			<tr>
				<td><a href="ProductListServlet">您还没购任何商品</a></td>
				<td><a href="ProductListServlet">返回商品菜单</a></td>
			</tr>
		</table>
   </c:if>
   
	<c:if test="${!empty(cart.map) }">
		<table border="3" align="center">
			<tr>
				<td>商品名称</td>
				<td>商品描述</td>
				<td>单价</td>
				<td>数量</td>
				<td>小计</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${cart.map}" var="entry">
				<tr>
					<td>${entry.value.product.name}</td>
					<td>${entry.value.product.description}</td>
					<td>${entry.value.product.discountprice}</td>
					<td><input type="text" name="count"
						value="${entry.value.count}" style="width: 50" /></td>
					<td>${entry.value.price}</td>
					<td><a href="DelCartServlet?id=${entry.value.product.id}">删除</a></td>
				</tr>
			</c:forEach>

			<tr>
				<td colspan="3">总价</td>
				<td colspan="1">${cart.price}</td>
				<td colspan="1"><a href="ClearCartServlet">清空购物车</a></td>
				<td colspan="1"><a href="ProductListServlet">返回商品菜单</a></td>

			</tr>

		</table>
	</c:if>
</body>
</html>