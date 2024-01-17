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
<title>🏦Bank App🏦</title>
</head>
<body>

	<jsp:include page="/includes/navbar.jsp" />

	<main>
		<div class="container-md px-5">
			<!-- Table -->
			<div class="mt-3">

				<h2 class="text-center display-4 mt-3">Available Banks</h2>
			</div>

			<div class="row p-2">
				<input class="form-control col-lg-4" type="search"
					placeholder="Search Bank Name" aria-label="Search" id="searchId"
					name="bankName">
				<button class="btn btn-outline-success col-lg-2 ml-2" type="button"
					onclick="searchBank()">Search</button>
			</div>



			<table class="table table-bordered table-striped mt-3">
				<thead class="thead-dark">
					<tr>
						<th>#SNO</th>
						<th>BANK IFSC CODE</th>
						<th>BANK NAME</th>
					</tr>
				</thead>
				<tbody id="tbid">
					<c:forEach items="${bankVOList}" var="bank" varStatus="counter">
						<tr>
							<td>${counter.count}</td>
							<td>${bank.ifscCode}</td>
							<td>${bank.bankName}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div>
			<c:forEach items="${pageList}" var="pn">
					<a class="btn btn-success" href="./getAllBanks?pageNo=${pn}">${pn+1}</a>
				</c:forEach>
			</div>
		</div>

	</main>

	<jsp:include page="/includes/footer.jsp" />

	<script>
		function searchBank() {
			let bankSearchName = $("#searchId").val();
			//alert(bankSearchName);

			// Make an AJAX request to fetch data
			$.ajax({
				type : 'GET',
				url : 'getBankByName', // Replace with the actual API endpoint
				data : {
					bankName : bankSearchName
				},
				success : function(data) {
					// Assuming 'data' is HTML content, use .html() to set it inside the element with id 'tbid'
					$('#tbid').html(data);
				},
				error : function(xhr, status, error) {
					console.error('Error fetching data:', status, error);
				}
			});
		}
	</script>
</body>
</html>