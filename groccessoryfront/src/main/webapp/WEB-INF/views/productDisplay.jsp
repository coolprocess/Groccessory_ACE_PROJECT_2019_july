<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<%@ page language="java" contentType="text/html;"%>

<html>

<head>

<meta charset="utf-8">

<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html;">

<title>Products Description</title>

<jsp:include page="header.jsp"></jsp:include>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

	<c:set var="image" value="${contextPath}/resources" />

</head>

<body>

	<div class="container">

		<div class="row">

			<div class="col-sm-6">

				<h2 style="text-align: center">${product.productName}</h2>

				<img style="text-align: center"
					src="${image}/${product.productId}.jpg" class="img-responsive"
					alt="${product.productName}">

			</div>

			<div class="col-sm-6">

				<br /> <br />

				<h3>Description:</h3>

				${product.productDesc}

				<h3>Cost:</h3>

				<h4 style="color: black">${product.productPrice}</h4>


			</div>

			<div class="col-sm-6">

				<security:authorize access="!hasAuthority('ROLE_ADMIN')">

					<form
						action="${contextPath}/customer/addToCart/${product.productId}">

						<h4 style="color: black">Enter Quantity</h4>

						<input type="number" class="form-control" name="quantity"
							required="true"> <br />

						<button class="btn btn-primary col-sm-5">Add to cart</button>

					</form>

				</security:authorize>

			</div>

		</div>



	</div>



</body>

<%-- <%@include file="footer.jsp"%> --%>

</html>