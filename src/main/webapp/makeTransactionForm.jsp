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
<title>Make Transaction</title>
</head>
<body>

	<jsp:include page="/includes/navbar.jsp" />

	<main>
		<div class="container-md mt-4">

			<h2 class="text-center display-4 mt-3">Make Payment</h2>

			<div class="card mt-4">
				<div class="card-header">Transaction Form</div>
				<div class="card-body">

					<form action="./createBank" method="post">
						<div class="row">

							<div class="form-group col-md-4">
								<label for="">Account Number</label> <input type="text"
									class="form-control" id="" name=""
									placeholder="Enter Account Number" required="required">
							</div>
							
							<div class="form-group col-md-4">
									<label for="">Transaction Type</label> <select
										class="form-control" name="" id="" onchange="">
										<option value="0">--select--</option>
										<option value="Credit">Deposit</option>
										<option value="Debit">Withdraw</option>
									</select>
								</div>
							

							<div class="form-group col-md-4">
								<label for="">Amount</label> <input type="text"
									class="form-control" id="" name=""
									placeholder="Enter Transaction Amount">
							</div>

		
							
						</div>

						<div class="mt-2 text-center">
							<input type="submit" class="btn btn-success" value="Save"
								required="required">
						</div>
					</form>
				</div>
			</div>
		</div>
	</main>

	<jsp:include page="includes/footer.jsp"></jsp:include>

</body>
</html>