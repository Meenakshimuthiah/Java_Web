<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
   .navbar {
      margin-bottom: 0;
      border-radius: 0;
    }
    
    /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
    .row.content {height: 450px}
    
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
      .row.content {height:auto;} 
    }
  </style>
</head>
<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

	<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#">MediCorp</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav navbar-right">
        <li class="active"><a href="#">Home</a></li>
        <li><a href="#">About</a></li>
        <li><a href="#">Services</a></li>
        <li><a href="#">Contact</a></li>
        <li>
                    <a href = "${contextPath}/user/logout">logout</a></li>
      </ul>
      
    </div>
  </div>
</nav>
  
<div class="container-fluid text-center">    
  <div class="row content">
    <div class="col-sm-2 sidenav">
      <img src="${pageContext.servletContext.contextPath}/resources/images/doctorf.jpg" alt = "img" width="180" height="430">
    </div>
    <div class="col-sm-8 text-left"> 
  
			<ul class="nav nav-pills">
				<li><a href="admin_home.jsp">Home</a></li>
			<li><a
				href="${contextPath}/physician/add_physician">Add Physician</a></li>
			<li class="active"><a href="${contextPath}/patient/add_patient">Add Patient</a></li>
			</ul>


			<div class="tab-content">
				<div class="tab-pane active" id="tab1">
					<div class="container center_div">
						<form:form action="${contextPath}/patient/add_patient"
							modelAttribute="patient" method="post">

							<table>
								<tr>
									<td>Name:</td>
									<td><form:input path="name" size="30" required="required" />
										<font color="red"><form:errors path="name" /></font></td>
								</tr>

								<tr>
									<td>Location</td>
									<td><form:input path="location" size="30"
											required="required" /> <font color="red"><form:errors
												path="location" /></font></td>
								</tr>


								<tr>
									<td>Contact</td>
									<td><form:input path="contact" size="30"
											required="required" /> <font color="red"><form:errors
												path="contact" /></font></td>
								</tr>
								<tr>
									<td>User name:</td>
									<td><form:input path="username" size="30"
											required="required" /> <form:errors path="username" /></td>
								</tr>
								<tr>
									<td>Password:</td>
									<td><form:password path="password" size="30"
											required="required" /> <font color="red"><form:errors
												path="password" /></font></td>
								</tr>

								<tr>
									<td>Role</td>
									<td><form:input path="role" size="30" value="patient"
											readonly="true" /> <form:errors path="role" /></td>
								</tr>

								<tr>
									<td>Age</td>
									<td><form:input path="age" size="30" /> <form:errors
											path="age" /></td>
								</tr>

								<tr>
									<td>Gender</td>
									<td><form:input path="gender" size="30" /> <form:errors
											path="gender" /></td>
								</tr>


								<tr>
									<td colspan="2"><input type="submit" value="Add Patient" /></td>
								</tr>
							</table>

						</form:form>

					</div>
				</div>
			
		</div>
    </div>
    <div class="col-sm-2 sidenav">
       <img src="${pageContext.servletContext.contextPath}/resources/images/doctorm.jpg" alt="Cinque Terre" width="180" height="430">
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