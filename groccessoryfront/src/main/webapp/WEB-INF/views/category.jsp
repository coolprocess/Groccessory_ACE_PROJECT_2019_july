<%@include file="header.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<form:form id="catForm" modelAttribute="category"
	action="${contextPath}/admin/catprocess" method="post">

	<div class="table-responsive">

		<center>
			<h2>Category form</h2> 	</center>
		</br>

		<div class="container">

			<div class="row">

				<div class=col-sm-3></div>

				<div class="col-sm-6">

					<div class="form-group">

						<form:input path="cid" type="hidden" />

						<label for="cname">Category Name:</label>

						<form:input path="cname" name="cname" id="cname"
							required="true"  class="form-control" />

					</div>

					<div class="form-group">

						<label for="cdesc">Category Description:</label>

						<form:input path="cdesc" name="cdesc" id="cdesc"
							class="form-control" />

					</div>

					<button type="submit" class="btn btn-default">Add Category</button>
			
				</div>

			</div>

		</div>

	</div>



	
	

	<div class="table-responsive">

		<table border="2" align="center" class="table table-inverse"
			style="width: 70%">

			<tr>

				<th>Category Name</th>

				<th>Category Description</th>

				<th>Edit Category</th>

				<th>Delete Category</th>



			</tr>

			<c:forEach items="${catlist}" var="cat">



				<tr>

					<td>${cat.cname}</td>

					<td>${cat.cdesc}</td>

					<td><a href="${contextPath}/admin/updateCat/${cat.cid}"><button
								type="button" class="btn btn-primary">Edit</button></a></td>

					<td><a href="${contextPath}/admin/deleteCat/${cat.cid}"><button
								type="button" class="btn btn-danger">Delete</button></a></td>





				</tr>

			</c:forEach>

		</table>

	</div>

</form:form>


