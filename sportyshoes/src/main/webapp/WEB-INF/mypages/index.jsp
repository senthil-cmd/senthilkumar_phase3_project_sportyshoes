<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sportyshoes</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="/indexstyle.css">
</head>
<body>
<h4>${name}<a href="/userlogin">Login here</a></h4>
<h1 align="center">Sportyshoes.com</h1>
 <h4 align="right"><a type="button" class="btn btn-success"
							href="/checkout">Check out</a></h4>
<c:forEach items="${productlist}" var="product">
<div class="row">
  <div class="column" style="background-color:white;">
    <img src="/images/product/${product.productimage}.jpg" alt="product" width="300" height="300">
  </div>
  <div class="column" style="background-color:white;">
   <h4>Name: ${product.productName}</h4>
   <h4><c:set var = "category" value = "${product.productcategory}"/>
						Category: ${category.categoryName}</h4>
   <h4><c:set var = "brand" value = "${product.productBrand}"/>
						Brand: ${brand.brandName}</h4>
   <h4>Description :${product.productfeauter}</h4>
   <h4>Price : ${product.productPrice}Rs</h4>
   <h4><a type="button" class="btn btn-success"
							href="/cart?id=${product.productId}">ADD TO CART</a></h4>
  </div>
</div>
</c:forEach>
</body>
 <footer>
     <div class="footer">
       Developed  by senthilkumar<a href="/adminlogin">Admin Login</a>
</div>
</footer>
</html>