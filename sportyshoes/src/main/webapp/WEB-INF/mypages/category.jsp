<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>

<head>
<title>Add/update Category</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">

</head>

<body>
	<div class="container">
	<form:form method="post" modelAttribute="category">
			<form:hidden path="category" />
			<fieldset class="form-group">
				<form:label path="categoryName">Category Name</form:label>
				<form:input path="categoryName" type="text" class="form-control"
					required="required" />
				<form:errors path="categoryName" cssClass="text-warning" ></form:errors>
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