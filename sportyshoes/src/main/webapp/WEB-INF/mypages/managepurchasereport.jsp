<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>manage purchase</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<h1 align="center">List purchase by Date</h1>
	<br>
	<br>
	<div class="container">
			<form:form method="post" modelAttribute="purchasereports">
			<fieldset class="form-group">
				<form:label path="date">Enter the Date</form:label>
				<form:input path="date" type="text" class="form-control"
					required="required" />
				<form:errors path="date" cssClass="text-warning" />
		</fieldset>
		<button type="submit" class="btn btn-danger">List purchase</button>
		</form:form>
	</div>
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script
		src="webjars/bootstrap-datepicker/1.0.1/js/bootstrap-datepicker.js"></script>
	<script>
		$('#targetDate').datepicker({
			format : 'yyyy/mm/dd'
		});
	</script>
</body>
</html>