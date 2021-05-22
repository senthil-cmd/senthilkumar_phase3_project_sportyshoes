<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>

<head>
<title>BRAND</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
</head>



<body>
	<div class="container">
		<table class="table table-striped">
			<caption>BRAND LIST</caption>
			<thead>
				<tr>
					<th>BRAND ID</th>
					<th>BRAND NAME</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${brandlist}" var="brand">
					<tr>
						<td>${brand.brandId}</td>
						<td>${brand.brandName}</td>
						<td><a type="button" class="btn btn-success"
							href="/updatebrand?id=${brand.brandId}">Update</a></td>
						<td><a type="button" class="btn btn-warning"
							href="/deletebrand?id=${brand.brandId}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div>
			<a class="button" href="/addbrand">Add Brand</a>
		</div>
	</div>
	
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>

</html>