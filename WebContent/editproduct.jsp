<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改商品页</title>
</head>
<body>
	<form action="ProductEdit2Servlet" method="post" >
		<input type="hidden" name="id" value="${product.id }" />
	    商品名称：<input type="text" name="name" value="${product.name }"/><br>
	    商品描述：<input type="text" name="description" value="${product.description }"/><br>
	    商品图片：<input type="image" name="listimg" src="images/${product.listimg }" width="180" height="150"/><br>
	    商品价格：<input type="text" name="price" value="${product.price }"/><br>
	    打折价：   <input type="text" name="discountprice" value="${product.discountprice }"/><br>
	    <input type="submit" value="修改">
	    <a href="ProductListServlet">返回商品菜单</a>
	</form>
</body>
</html>