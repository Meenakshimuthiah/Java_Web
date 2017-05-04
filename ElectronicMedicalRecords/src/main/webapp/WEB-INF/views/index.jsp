<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
 <title>Bootstrap Example</title>
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
<body bgcolor="#ffffff">
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
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">Home</a></li>
        <li><a href="#">About</a></li>
        <li><a href="#">Services</a></li>
        <li><a href="#">Contact</a></li>
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
      <form class="form-horizontal" action="${contextPath}/user/login" method="post">
			<div class="row">
				<div class="row">
					<div class="form group">
						<h2>Login</h2>
					</div>
				</div>

				<div class="row">
					<label class="control-label col-xs-2" for="prog">User name</label>
				</div>
				<div class="row">
					<div class="col-xs-2">
						<input type="text" class="form-control" name="username" required />
					</div>
				</div>
				<div class="row">
					<label class="control-label col-xs-2" for="prog">password</label>
				</div>
				<div class="row">
					<div class="col-xs-2">
						<input type="password" class="form-control" name="password"
							required />
					</div>
				</div>

				<div class="row">
					<br /> <input type="submit" class="btn btn-info" value="Login" />
				</div>
			</div>
			
		</form>
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

