<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>
   <%@include file="navbar.jsp" %>
	<div class="container">
	<h1 class="text-center">Add Blogs</h1>
		<form action="save" method="post">
			<div class="mb-3">
				<label for="title" class="form-label">Title </label> <input
					type="text" class="form-control" name="title1"
					placeholder="Enter your title here">

			</div>
			<div class="mb-3">
				<label for="decription" class="form-label">
					Description</label>
				<textarea class="form-control" 
				name="decription"
				placeholder="Enter your Description Here"
					rows="7"></textarea>
			</div>
		<!--  	<div class="mb-3">
				<label for="decription" class="form-label">Description</label> <input
					type="text" class="form-control" name="decription"
					placeholder="Enter your Description Here">
			</div>

-->
			<button type="submit" class="btn btn-primary">Save Blog +</button>
		</form>
	</div>

</body>
</html>