<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<title>sportyshoes store</title>
<style type="text/css">
#menubar {
	width: 1000px;
	margin-left: auto;
	margin-right: auto;
	margin-top: 80px;
	height: auto;
}

a {
	text-decoration: none;
	margin-right: -5px;
	padding: 15px 20px;
	color: #6aa25d;
	cursor: pointer;
	-webkit-transition: all 0.2s;
	-moz-transition: all 0.2s;
	-ms-transition: all 0.2s;
	-o-transition: all 0.2s;
	transition: all 0.2s;
}

ul 
{
	align: center;
	text-transform: uppercase;
	text-align: left;
	display: inline;
	margin: 0;
	padding: 15px 4px 17px 0;
	list-style: none;
	-webkit-box-shadow: 0 0 5px rgba(0, 0, 0, 0.15);
	-moz-box-shadow: 0 0 5px rgba(0, 0, 0, 0.15);
	box-shadow: 0 0 5px rgba(0, 0, 0, 0.15);
}

ul li {
	font: bold 12px/18px sans-serif;
	display: inline-block;
	margin-right: -5px;
	position: relative;
	padding: 15px 20px;
	background: #f7f7f7;
	color: #6aa25d;
	cursor: pointer;
	-webkit-transition: all 0.2s;
	-moz-transition: all 0.2s;
	-ms-transition: all 0.2s;
	-o-transition: all 0.2s;
	transition: all 0.2s;
}

ul li :hover {
	background: #6aa25d;
	color: #f7f7f7;
}
</style>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<h3>${name}
		<a href="/adminlogin">Logout</a>
	</h3>
	<h1 align="center">STORE</h1>
	<div  id="menubar">
		<ul>
			<li><a href="/managebrand">BRAND</a></li>
			<li><a href="/managecategory">CATEGORY</a></li>
			<li><a href="/manageproduct">PRODUCT</a></li>
			<li><a href="/managepurchasereport">PURCHASE REPORT</a></li>
			<li><a href="/manageuser">USER DETAILS</a></li>
			<li><a href="/AdminPasswordReset">ADMIN</a></li>
		</ul>
	</div>
	<div>
	<br>
	<br>
	<h3>Purchase Reports</h3>
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
				<c:forEach items="${reportlist}" var="purchaseReport">
					<tr>
						<td>${purchaseReport.purchaseId}</td> 
						<td><fmt:formatDate value="${purchaseReport.date}" pattern="dd/MM/yyyy"/></td> 
						<td><c:set var = "user" value = "${purchaseReport.user}"/>
						${user.userName}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	</div>
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>

</html>