<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<html>
<head>
<title>Online Groccessory Shopping Web Site</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
	
</head>
<body>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Groccessory Shop</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="${contextPath}">Home</a></li>
				<security:authorize access="hasAuthority('ROLE_ADMIN')">
					<li><a href="${contextPath}/admin/category">Category
							Operations</a></li>
					<li><a href="${contextPath}/admin/productp">Product
							Operations</a></li>
				</security:authorize>

			</ul>
			<security:authorize access="!hasAuthority('ROLE_ADMIN')">

				<li><a href="${contextPath}/products">Products</a></li>

				<li><a href="${contextPath}/category" class="dropdown-toggle"
					data-toggle="dropdown">Categories<b class="caret"></b></a>

					<ul class="dropdown-menu">
						<c:forEach items="${catlist}" var="cat">
							<li><a href="${contextPath}/CategorizedProducts/${cat.cid}">${cat.cname}</a></li>

						</c:forEach>

					</ul></li>

			</security:authorize>


			<ul class="nav navbar-nav navbar-right">
				<security:authorize access="isAnonymous()">
					<li><a href="${contextPath}/reg"><span
							class="glyphicon glyphicon-user"></span> Sign Up</a></li>
					<li><a href="${contextPath}/login"><span
							class="glyphicon glyphicon-log-in"></span> Login</a></li>
				</security:authorize>

				<security:authorize access="hasAuthority('ROLE_USER')">


					<li><a href="${contextPath}/customer/myCart"><span
							class="glyphicon glyphicon-shopping-cart"
							style="margin-left: 2px; margin-right: 2px;"></span> <span
							style="border-radius: 10px; background-color: red; color: white; padding: 8px; margin-right: 2px;">${cart.cartQuantity}</span>My

							Cart</a></li>


				</security:authorize>

				<security:authorize access="isAuthenticated()">

					<li id="logout"><a href="${contextPath}/perform_logout"><span
							class="glyphicon glyphicon-user"></span>Logout</a></li>

				</security:authorize>
			</ul>
		</div>
	</nav>
	<div class="container">
  <h2>Groceessory Items Execlusively</h2>  
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">
      <div class="item active">
        <img src="/groccessoryfront/resources/images/basmathi.jpg" alt="rice" style="width:80%;">
      </div>

      <div class="item">
        <img src="/groccessoryfront/resources/images/greendal.jpg" alt="dal" style="width:80%;">
      </div>
    
      <div class="item">
        <img src="/groccessoryfront/resources/images/vijay1.jpg" alt="oil" style="width:80%;">
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>

	