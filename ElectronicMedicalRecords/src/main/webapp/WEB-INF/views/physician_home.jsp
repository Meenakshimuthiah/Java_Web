<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
.navbar {
	margin-bottom: 0;
	border-radius: 0;
}

/* Set height of the grid so .sidenav can be 100% (adjust as needed) */
.row.content {
	height: 450px
}

/* Set gray background color and 100% height */
.sidenav {
	padding-top: 20px;
	background-color: #ffffff;
	height: 100%;
}

/* Set black background color, white text and some padding */
footer {
	background-color: #555;
	color: white;
	padding: 15px;
}

/* On small screens, set height to 'auto' for sidenav and grid */
@media screen and (max-width: 767px) {
	.sidenav {
		height: auto;
		padding: 15px;
	}
	.row.content {
		height: auto;
	}
}
</style>


</head>
<body>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />

	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">MediCorp</a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav navbar-right">
					<li class="active"><a href="#">Home</a></li>
					<li><a href="#">About</a></li>
					<li><a href="#">Services</a></li>
					<li><a href="#">Contact</a></li>
					<li><a href="${contextPath}/user/logout">logout</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container-fluid text-center">
		<div class="row content">
			<div class="col-sm-2 sidenav">
				<img
					src="${pageContext.servletContext.contextPath}/resources/images/doctorf.jpg"
					alt="img" width="180" height="430">
			</div>
			<div class="col-sm-8 text-left">
				<h2>Search Patient</h2>
				<form action="${contextPath}/physician/search_patient"
					onsubmit="return validate()" name="myForm">
					<div class="row">
						<label class="control-label col-sm-3" for="prog">Search
							Query</label>
						<div class="col-xs-2">
							<input type="text" class="form-control" id="prog" name="query">
						</div>
					</div>
					<br /> <input type="submit" class="btn btn-info" value="Search">
				</form>
			</div>
			<div class="col-sm-2 sidenav">
				<img
					src="${pageContext.servletContext.contextPath}/resources/images/doctorm.jpg"
					alt="Cinque Terre" width="180" height="430">
			</div>
		</div>
	</div>
	<br>
	<br>
	<br>
	<footer class="container-fluid text-center">
		<p>Footer Text</p>
	</footer>
</body>
</html>