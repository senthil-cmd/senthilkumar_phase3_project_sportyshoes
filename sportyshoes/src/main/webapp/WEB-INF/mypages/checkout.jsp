<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>checkout</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="/cart.css">
</head>
<body>
<h3>${name}</h3>
<a href="/userlogin">Login here</a>
<h1 align="center">Sportyshoes</h1>
<c:forEach items="${cart}" var="product">
<div class="row">
  <div class="column" style="background-color:white;">
    <img src="/images/product/${product.productimage}.jpg" alt="product" width="100" height="100">
  </div>
  <div class="column" style="background-color:white;">
   <h4>Name: ${product.productName}</h4>
   <h4><c:set var = "category" value = "${product.productcategory}"/>
						Category: ${category.categoryName}</h4>
   <h4><c:set var = "brand" value = "${product.productBrand}"/>
						Brand: ${brand.brandName}</h4>
   <h4>Description :${product.productfeauter}</h4>
   <h4>Price : ${product.productPrice}Rs</h4>
  </div>
</div>
</c:forEach>
<form:form method="post">
<h2 align="center"><button type="submit" class="btn btn-danger">Oder</button></h2>
		</form:form>
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script
		src="webjars/bootstrap-datepicker/1.0.1/js/bootstrap-datepicker.js"></script>
	<script>
		$('#targetDate').datepicker({
			format : 'dd/mm/yyyy'
		});
	</script>
</body>
</html>