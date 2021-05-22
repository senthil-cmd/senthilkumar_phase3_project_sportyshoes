<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<br>
	<br>
	<h3>Purchase Reports On <fmt:formatDate value="${purchaseReport.date}" pattern="dd/MM/yyyy"/></h3>
	<div class="container">
		<table class="table table-striped">
			<caption>purchase list</caption>
			<thead>
				<tr>
					<th>Oder ID</th>
					<th>Oder Date</th>
					<th>Customer Name</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${purchasebydate}" var="purchaseReport">
					<tr>
						<td>${purchaseReport.purchaseId}</td> 
						<td><fmt:formatDate value="${purchaseReport.date}" pattern="dd/MM/yyyy"/></td> 
						<td><c:set var = "user" value = "${purchaseReport.user}"/>
						${user.userName}</td>
					</tr>
					<c:set var = "productlist" value = "${purchaseReport.product}"/>
				</c:forEach>
			</tbody>
		</table>
		
		<table class="table table-striped">
			<caption>PRODUCT LIST</caption>
			<thead>
				<tr>
					<th>ODER ID</th>
					<th>PRODUCT ID</th>
					<th>PRODUCT NAME</th>
					<th>PRODUCT PRICE</th>
					<th>CATEGORY</th>
					<th>BRAND</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${purchasebydate}" var="purchaseReport">
			<c:set var = "productlist" value = "${purchaseReport.product}"/>
			
				<c:forEach items="${productlist}" var="product">

					<tr>
						<td>${purchaseReport.purchaseId}</td>
						<td>${product.productId}</td>
						<td>${product.productName}</td>
						<td>${product.productPrice}</td>
						<td>
						<c:set var = "category" value = "${product.productcategory}"/>
						${category.categoryName}
						</td>
						<td>
						<c:set var = "brand" value = "${product.productBrand}"/>
						${brand.brandName}
						
						</td>
					</tr>
				</c:forEach>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</body>
</html>