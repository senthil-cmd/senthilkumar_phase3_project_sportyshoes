<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>

<head>
<title>Product List</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
</head>



<body>
	<div class="container">
		<table class="table table-striped">
			<caption>PRODUCT LIST</caption>
			<thead>
				<tr>
					<th>PRODUCT ID</th>
					<th>PRODUCT NAME</th>
					<th>PRODUCT PRICE</th>
					<th>CATEGORY</th>
					<th>BRAND</th>
					<th>QTY</th>
					<th>PRODUCT FEATURE</th>
					<th>PRODUCT IMAGE</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${productlist}" var="product">

					<tr>
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
						<td>${product.qty}</td>
						<td>${product.productfeauter}</td>
						<td>${product.productimage}</td>
						<td><a type="button" class="btn btn-success"
							href="/updateproduct?id=${product.productId}">Update</a></td>
						<td><a type="button" class="btn btn-warning"
							href="/deleteproduct?id=${product.productId}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div>
			<h4><a class="button" href="/addproduct">Add Product</a></h4>
		</div>
	</div>
	
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>

</html>