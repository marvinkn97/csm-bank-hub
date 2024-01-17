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
	<script src="https://code.jquery.com/jquery-2.2.4.js"
	integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI="
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
	crossorigin="anonymous"></script>
<title>Create Bank</title>
</head>
<body>

	<jsp:include page="/includes/navbar.jsp" />

	<main>
		<div class="container-md mt-4">

			<h2 class="text-center display-4 mt-3">Create Bank</h2>

			<div class="card mt-4">
				<div class="card-header">Bank Registration Form</div>
				<div class="card-body">

					<form action="./createBank" method="post">
						<div class="row">

							<div class="form-group col-md-4">
								<label for="ifscCodeId">Bank Code</label> <input type="text"
									class="form-control" id="ifscCodeId" name="ifscCode"
									placeholder="Enter Bank Code" required="required">
							</div>

							<div class="form-group col-md-4">
								<label for="bankNameId">Bank Name</label> <input type="text"
									class="form-control" id="bankNameId" name="bankName"
									placeholder="Enter Bank Name">
							</div>


						</div>

						<div class="mt-2 text-center">
							<input type="submit" class="btn btn-success" value="Save" required="required">
						</div>
					</form>
				</div>
			</div>
		</div>
	</main>

    <jsp:include page="includes/footer.jsp"></jsp:include>

</body>
</html>