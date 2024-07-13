<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<%@include file="./base.jsp"%>

</head>
<body>
	<div class="container mt-3">

		<div class="col-md-6 offset-md-3">

			<h1 class="text-center mb-3">Fill the Product Details</h1>

			<form action="handel-product" method="post">

				<div class="form-group mb-2">
					<label for="name">Product Name : </label> <input type="text"
						class="form-control" id="name"
						name="name" placeholder="Enter product name here">
				</div>

				<div class="form-group mb-2">
					<label for="description">Product Description : </label>
					<textarea class="form-control" id="description" name="description"
						rows="5" placeholder="Enter product description here"></textarea>
				</div>
				
				<div class="form-group mb-2">
					<label for="price">Price : </label> <input type="text"
						class="form-control" id="price"
						name="price" placeholder="Enter product price here">
				</div>
				
				<div class="container text-center">
					<a href="${ pageContext.request.contextPath }/" class="btn btn-outline-danger">Back</a>
					<button type="submit" class="btn btn-primary">Add</button>
				</div>

			</form>

		</div>

	</div>
</body>
</html>