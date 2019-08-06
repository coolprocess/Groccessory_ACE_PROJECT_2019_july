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

<title>Add Products</title>

<jsp:include page="header.jsp"></jsp:include>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<c:set var="image" value="${contextPath}/resources" />

</head>

<body>

	<div class="container">

		<div class="row">

			<div class="col-md-2">

				<h2 style="text-align: center">Categories</h2>

				</br>

				<ul class="list-group">

					<c:forEach items="${catlist}" var="cat">

						<li class="list-group-item"><a
							href="${contextPath}/CategorizedProducts/${cat.cid}">${cat.cname}</a></li>

					</c:forEach>

			</ul>

			</div>

			<div class="col-md-10">
			<c:forEach items = "${catproductlist}" var="products">
			<div class="col-sm-4" style="text-align: center">



						<a href="${contextPath}/productDisplay/${products.productId}"><img

							src="${image}/${products.productId}.jpg" class="img-thumbnail">

							<h3>${products.productName}</h3> </a>

						<h3>${products.productPrice}</h3>



					</div>

			

				  

				  </c:forEach>

		</div>

		</div>

		</div>

       

        </body>

       <%--  <%@include file="footer.jsp"%> --%>

        </html>