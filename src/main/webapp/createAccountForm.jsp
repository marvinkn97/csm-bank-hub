<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<title>Create Account Form</title>
</head>
<body>


	<jsp:include page="/includes/navbar.jsp" />

	<main>

		<div class="container-md mt-4">

			<h2 class="text-center display-4 mt-3">Create Account</h2>

			<div class="card mt-4">
				<div class="card-header">Account Registration Form</div>
				<div class="card-body">

					<form action="./createAccount" method="post">
						<div class="row">

							<div class="form-group col-md-4">
								<label for="accNameId">Account Name</label> <input type="text"
									class="form-control" id="accNameId" name="accName"
									placeholder="Enter Account Name">
							</div>

							<div class="form-group col-md-4">
								<label for="phoneId">Phone Number</label> <input type="text"
									class="form-control" id="phoneId" name="phoneNo"
									placeholder="Enter Phone Number">
							</div>

							<div class="form-group col-md-4">
								<label for="phoneId">Email</label> <input type="email"
									class="form-control" id="phoneId" name="phoneNo"
									placeholder="Enter Phone Number">
							</div>

						</div>

						<div class="row">
							<div class="form-group col-md-4">
								<label for="">Select Bank</label> <select class="form-control"
									name="" id="" onchange="">
									<option value="0">--select--</option>
								</select>
							</div>


							<div class="form-group col-md-4">
								<label for="accountTypeId">Select Account Type</label> <select
									class="form-control" name="accountType" id="accountTypeId">
									<option value="0">--select--</option>
									<option value="current account">CURRENT ACCOUNT</option>
									<option value="0">--select--</option>
								</select>
							</div>

						</div>

						<div class="mt-2 text-center">
							<input type="submit" class="btn btn-success" value="Save">
						</div>
					</form>
				</div>
			</div>
		</div>
	</main>

	<jsp:include page="includes/footer.jsp"></jsp:include>

</body>
</html>