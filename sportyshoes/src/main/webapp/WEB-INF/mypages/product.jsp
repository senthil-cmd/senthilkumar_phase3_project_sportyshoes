<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
<title>Add/update brand</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
</head>

<body>
	<div class="container">
		<form:form method="post" modelAttribute ="product">
			<form:hidden path="productId" />
			<fieldset class="form-group">
				<form:label path="productName">Product Name</form:label>
				<form:input path="productName" type="text" class="form-control"
					required="required" />
				<form:errors path="productName" cssClass="text-warning"></form:errors>
			</fieldset>
			<fieldset class="form-group">
				<form:label path="productPrice">Set Price</form:label>
				<form:input path="productPrice" class="form-control"
					required="required" />
				<form:errors path="productPrice" cssClass="text-warning"></form:errors>
			</fieldset>
			<fieldset class="form-group">
			<form:label path="productcategory">Select Category</form:label>
				<form:select path="productcategory">
					<c:forEach items="${productcategory}" var="category">
						<form:option value="${category.category}"
							label="${category.categoryName}" />
					</c:forEach>
				</form:select>
			</fieldset>
			<fieldset class="form-group">
				<form:label path="productBrand">Select Brand</form:label>
				<form:select path="productBrand">
					<c:forEach items="${brand}" var="brand">
						<form:option value="${brand.brandId}" label="${brand.brandName}" />
					</c:forEach>
				</form:select>
			</fieldset> 
			<fieldset class="form-group">
				<form:label path="qty">quantity</form:label>
				<form:input path="qty" type="text" class="form-control"
					required="required" />
			</fieldset>
			<fieldset class="form-group">
				<form:label path="productfeauter">product feature</form:label>
				<form:input path="productfeauter" type="text" class="form-control"
					required="required" />
			</fieldset>
			<fieldset class="form-group">
				<form:label path="productimage">product feature</form:label>
				<form:input path="productimage" type="text" class="form-control"
					required="required" />
			</fieldset>
			<button type="submit" class="btn btn-danger">Add</button>
		</form:form>
	</div>

	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script
		src="webjars/bootstrap-datepicker/1.0.1/js/bootstrap-datepicker.js"></script>

</body>
</html>