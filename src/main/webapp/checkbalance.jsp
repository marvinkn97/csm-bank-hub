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
<title>Check Account Balance</title>
</head>
<body>


	<jsp:include page="/includes/navbar.jsp" />

	<main>

		<div class="container-md mt-4">

			<h2 class="text-center display-4 mt-3">Account Details</h2>

			<div class="card mt-4">
				<div class="card-body">

					<form>

						<div class="row p-2">
							<input class="form-control col-lg-4" type="search"
								placeholder="Search Account Number" aria-label="Search"
								id="accNumberId" name="accNumber">
							<button class="btn btn-outline-success col-lg-2 ml-2"
								type="button" onclick="searchAccount()">Search</button>
						</div>

						<div class="row">

							<div class="form-group col-md-4">
								<label for="bNameId">Bank Name</label> <input type="text"
									class="form-control" id="bNameId" name="bankName"
									readonly="readonly">
							</div>

							<div class="form-group col-md-4">
								<label for="accNoId">Account Number</label> <input type="text"
									class="form-control" id="accNoId" name="accNumber"
									readonly="readonly">
							</div>

							<div class="form-group col-md-4">
								<label for="accNameId">Account Name</label> <input type="text"
									class="form-control" id="accNameId" name="accName"
									readonly="readonly">
							</div>

							<div class="form-group col-md-4">
								<label for="phoneId">Phone Number</label> <input type="text"
									class="form-control" id="phoneId" name="phoneNo"
									readonly="readonly">
							</div>

							<div class="form-group col-md-4">
								<label for="emailId">Email</label> <input type="text"
									class="form-control" id="emailId" name="email"
									readonly="readonly">
							</div>

							<div class="form-group col-md-4">
								<label for="accTypeId">Account Type</label> <input type="text"
									class="form-control" id="accTypeId" name="accType"
									readonly="readonly">
							</div>

							<div class="form-group col-md-4">
								<label for="balanceId">Balance</label> <input type="text"
									class="form-control" id="balanceId" name="balance"
									readonly="readonly">
							</div>

						</div>
					</form>
				</div>
			</div>
		</div>
	</main>

	<jsp:include page="includes/footer.jsp"></jsp:include>


	<script type="text/javascript">
		function searchAccount() {
			let accountNumber = $("#accNumberId").val();
			//alert(bankSearchName);

			// Make an AJAX request to fetch data
			$.ajax({
				type : 'GET',
				url : 'getAccountByAccNo', // Replace with the actual API endpoint
				data : {
					accountNo : accountNumber
				},
				success : function(data) {

					if (data) {
						   $("#bNameId").val(data.bankVO.bankName);
					        $("#accNoId").val(data.accountNo);
					        $("#accNameId").val(data.name);
					        $("#phoneId").val(data.phoneNo);
					        $("#emailId").val(data.email);
					        $("#accTypeId").val(data.accountType);
					        $("#balanceId").val(data.balance);
					        
					        console.log(data);

					} else {
						// Handle case where no data is returned
						alert("Account not found");
					}

				},
				error : function(xhr, status, error) {
					console.error('Error fetching data:', status, error);
				}
			});
		}
	</script>
</body>
</html>