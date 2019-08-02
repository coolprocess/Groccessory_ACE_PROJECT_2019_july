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
				<security:authorize access="isAuthenticated()">

					<li id="logout"><a href="${contextPath}/perform_logout"><span
							class="glyphicon glyphicon-user"></span>Logout</a></li>

				</security:authorize>
			</ul>
		</div>
	</nav>