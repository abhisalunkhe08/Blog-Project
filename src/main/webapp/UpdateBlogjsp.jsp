<%@page import="com.blog.entity.Blogs"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>
	<%@include file="navbar.jsp"%>
	<div class="container d-flex justify-content-center">
	
	<div class="col-md-6">
			<h2>Update Blog</h2>
			<%
				Blogs blog = (Blogs) request.getAttribute("blog");
			%>
			<form action="updateBlog" method="post">
				<input type="hidden" name="id" value="<%= blog.getId() %>">
				<div class="mb-3">
					<label for="title" class="form-label">Title</label>
					<input type="text" class="form-control" id="title" name="title" value="<%= blog.getTitle() %>">
				</div>
				<div class="mb-3">
					<label for="content" class="form-label">Content</label>
					<textarea class="form-control" id="content" name="content" rows="10"><%= blog.getDesc()%></textarea>
				</div>
				<button type="submit" class="btn btn-primary">Update</button>
			</form>
		</div>
	
	
	
	
	
	
	
	</div>
</body>
</html>