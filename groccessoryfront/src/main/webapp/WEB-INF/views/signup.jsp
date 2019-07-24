<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@include file="header.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page</title>
</head>
<body>
	<form:form id="regForm" modelAttribute="customer" action="signupProcess"
		method="post">

		<h2 style="text-align: center">Registration form</h2>
		<br/>

		<div class="container">
			<div class="row">

				<div class=col-sm-3></div>

				<div class="col-sm-6">

					<div class="form-group">

						<label for="firstName">First Name:</label>
						<form:input path="firstName" name="firstName" id="firstName"
							required='required' pattern="[a-zA-Z]{4,}" class="form-control"
							title="min 4 max 12 char" />

						<form:errors path="firstName" style="color: red" />


					</div>

					<div class="form-group">

						<label for="lastName">Last Name:</label>

						<form:input path="lastName" name="lastName" id="lastName"
							required='required' pattern="[a-zA-Z]{4,12}" class="form-control"
							title="min 4 max 12 char" />

						<form:errors path="lastName" style="color: red" />

					</div>

					<div class="form-group">

						<label for="address">Address:</label>

						<form:input path="address" name="address" id="address"
							required='required' class="form-control" novalidate="true" />

					</div>

					<div class="form-group">

						<label for="email">Email:</label>

						<form:input path="email" name="email" id="email" required='required'
							class="form-control" />

						<form:errors path="email" style="color: red" />

					</div>

					<div class="form-group">

						<label for="password">Password:</label>

						<form:input path="password" type="password" id="password"
							required='required' pattern="[a-zA-Z0-9]{8,12}" class="form-control"
							title="min-8 max-12 char" />

						<form:errors path="password" />

					</div>

					<div class="form-group">

						<label for="password">Confirm Password:</label>

						<form:input path="confirmPassword" type="password"
							id="confirmPassword" required='required' pattern="[a-zA-Z0-9]{8,12}"
							title="min-4 max-12 char" class="form-control" />

					</div>



					<div style="color: red">${errorPass}</div>

					<form:input path="is_Active" hidden="true" value="TRUE" />

					<div class="form-group">

						<label for="mobile">Mobile:</label>

						<form:input path="mobile" name="mobile" id="mobile"
							required='required' pattern="[0-9]{10}" class="form-control" />

						<form:errors path="mobile" />

					</div>

					<button type="submit" class="btn btn-default">Register</button>



				</div>

			</div>

		</div>



	</form:form>

	<script type="text/javascript">
		function validateConPass() {

			if (document.getElementById("password").value != document

			.getElementById("confirmPassword").value) {

				document.getElementById("passerror").innerHTML = "password and confirm password should be same";

				return false;

			} else {

				return true;

			}

		}
	</script>

</body>
</html>