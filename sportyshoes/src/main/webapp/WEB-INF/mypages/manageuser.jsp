<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>

<head>
<title>User List</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
</head>



<body>
	<div class="container">
		<table class="table table-striped">
			<caption>LIST OF REGISTERED USERS</caption>
			<thead>
				<tr>
				
					<th> NAME</th>
					<th>USER ID</th>
					<th>EMAIL ADDRESS</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listuser}" var="user">
					<tr>
					
						<td>${user.userName}</td>
						<td>${user.uname}</td>
						<td>${user.email}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>

</html>