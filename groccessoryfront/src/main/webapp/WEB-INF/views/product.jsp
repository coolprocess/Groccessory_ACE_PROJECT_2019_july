	<%@include file="header.jsp"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	
	<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
	
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<c:set var="image" value="${contextPath}/resources" />
	
	<form:form id="prodForm" modelAttribute="product"
		action="${contextPath}/admin/prodProcess" enctype="multipart/form-data" method="post">
		<div class="table-responsive">
	
			<h2 style="text-align: center">Products form</h2>
	
			</br>
	
			<div class="container">
	
				<div class="row">
	
					<div class=col-sm-3></div>
	
					<div class="col-sm-6">
	
						<div class="form-group">
	
							<form:input type="hidden" path="productId" />
	
							<label for="productName">Product Name:</label>
	
							<form:input path="productName" name="productName"
								id="producttName" class="form-control" required="true"
								pattern="[a-zA-Z0-9]{4,50}" />
	
						</div>
	
						<div class="form-group">
	
							<label for="productDesc">Product Description:</label>
	
							<form:input path="productDesc" name="productDesc" id="productDesc"
								class="form-control" />
	
						</div>
	
						<div class="form-group">
	
							<label for="productPrice">Price:</label>
	
							<form:input path="productPrice" name="productPrice"
								required="true" pattern="[0-9]{0,5}" id="productPrice"
								class="form-control" />
	
						</div>
	
						<div class="form-group">
	
							<label for="category">Category:</label>
	
							<div class="dropdown">
	
								<form:select path="category.cid" class="form-control"
									required="true">
	
									<form:option value="0" label="---Select Category---" />
	
									<form:options items="${catlist}" itemValue="cid"
										itemLabel="cname" />
	
								</form:select>
	
							</div>
	
						</div>
	
						<div class="form-group">
	
							<label for="stock">Stock</label>
	
							<form:input path="stock" name="stock" id="stock"
								class="form-control" required="true" />
	
						</div>
	
						<div class="form-group">
	
							<label for="pimage">Upload Image:</label>
	
							<form:input path="pimage" type="file" class="form-control"
								required="true" />
	
	
	
						</div>
	
	
	
						<button type="submit" class="btn btn-default">Add Product</button>
	
	
	
					</div>
	
				</div>
	
			</div>
	
		</div>
	
	</form:form>
	
	<div class="table-responsive">
	
		<table border="2" align="center" class="table table-inverse"
			style="width: 80%">
	
			<tr>
	
				<th style="text-align: center">Image</th>
	
				<th style="text-align: center">Name</th>
	
				<th style="text-align: center">Description</th>
	
				<th style="text-align: center">Price</th>
	
				<th style="text-align: center">Stock</th>
	
				<th style="text-align: center">Edit Product</th>
	
				<th style="text-align: center">Delete Product</th>
	
			</tr>
	
			<c:forEach items="${prodlist}" var="products">
	
	
	
				<tr style="text-align: center">
	
					<td><img src="${image}/${products.productId}.jpg"
						style="width: 50px; height: 50px;">
					<td><a
						href="${contextPath}/productDisplay/${products.productId}">${products.productName}
	
					</a></td>
	
					<td>${products.productDesc}</td>
	
					<td>${products.productPrice}</td>
	
					<td>${products.stock}</td>
	
	
	
					<td><a
						href="${contextPath}/admin/updateProduct/${products.productId}"><button
								type="button" class="btn btn-primary">Edit</button></a></td>
	
					<td><a
						href="${contextPath}/admin/deleteProduct/${products.productId}"><button
								type="button" class="btn btn-danger">Delete</button></a></td>
	
				</tr>
	
			</c:forEach>
	
		</table>
	
	</div>
