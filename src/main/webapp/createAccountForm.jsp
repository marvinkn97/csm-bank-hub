<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-2.2.4.js"
	integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI="
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
	crossorigin="anonymous"></script>
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
								<label for="emailId">Email</label> <input type="email"
									class="form-control" id="emailId" name="email"
									placeholder="Enter Email">
							</div>

						</div>

						<div class="row">
							<div class="form-group col-md-4">
								<label for="bankNameId">Select Bank</label> <select
									class="form-control" name="bankId" id="bankNameId">
									<option value="0">--select--</option>
									<c:forEach items="${bankVOList}" var="b">
										<option value='${b.bankId}'>${b.bankName}</option>
									</c:forEach>
								</select>
							</div>


							<div class="form-group col-md-4">
								<label for="accountTypeId">Select Account Type</label> <select
									class="form-control" name="accountType" id="accountTypeId">
									<option value="0">--select--</option>
									<option value="current">CURRENT ACCOUNT</option>
									<option value="savings">SAVINGS ACCOUNT</option>
									<option value="salary">SALARY ACCOUNT</option>
									<option value="fixed">FIXED DEPOSIT ACCOUNT</option>
									<option value="business">BUSINESS ACCOUNT</option>
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


	<script type="text/javascript">
		
	</script>
</body>
</html>