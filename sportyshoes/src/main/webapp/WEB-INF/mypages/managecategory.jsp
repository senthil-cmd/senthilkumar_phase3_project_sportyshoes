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
			<caption>CATEGORY LIST</caption>
			<thead>
				<tr>
					<th>CATEGORY ID</th>
					<th>CATEGORY NAME</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${categorylist}" var="category">
					<tr>
						<td>${category.category}</td>
						<td>${category.categoryName}</td>
						<td><a type="button" class="btn btn-success"
							href="/updatecategory?id=${category.category}">Update</a></td>
						<td><a type="button" class="btn btn-warning"
							href="/deletecategory?id=${category.category}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div>
			<a class="button" href="/addcategory">Add Category</a>
		</div>
	</div>
	
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>

</html>