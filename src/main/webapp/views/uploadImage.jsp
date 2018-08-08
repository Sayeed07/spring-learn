<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/lib/bootstrap/css/bootstrap.min.css"
	type="text/css">
<script src="../js/bootstrap.min.js"></script>
</head>

<body>
	<center
		style="width: 50%; border: 1px solid #adadad; margin: 20px auto;">
		<form class="form-horizontal" name="signupForm" action="<%=request.getContextPath()%>/registration/photo/save" enctype="multipart/form-data" method="post">
			<fieldset>
				<legend style="color: green; padding: 10px">Upload new data
					information</legend>

				<div class="form-group">
					<div class="col-md-10">
						<input name="productId" type="hidden" class="form-control input-md" value="${updatePhotoData.productId}">
					</div>
				</div>

				<div class="form-group">
					<div class="col-md-10">
						<label>Upload image</label> 
						<input type="file" class="form-control-file" name="photo" required>
					</div>
				</div>

				<div class="form-group">
					<div class="col-md-10">
						<input name="productTitle" type="text" placeholder="Title" class="form-control input-md" value="${updatePhotoData.productTitle}" required>
					</div>
				</div>

				<div class="form-group">
					<div class="col-md-10">
						<input name="productDescription" type="text" placeholder="Description" class="form-control input-md" value="${updatePhotoData.productDescription}" required>
					</div>
				</div>

				<div class="form-group">
					<div class="col-md-10">
						<input name="ProductPrice" type="text" placeholder="Price" class="form-control input-md" value="${updatePhotoData.productPrice}" required>
					</div>
				</div>

				<div class="form-group">
					<div class="col-md-10">
						<input class="btn btn-success" type="submit" value="Register" class="" /> &nbsp; <a href="<%=request.getContextPath()%>/views/index.jsp">Go Home</a>
					</div>
				</div>

			</fieldset>
		</form>

		<label id="customAlert" style="color: red"></label>

		<c:if test="${!empty message}">
			<h1>${message}</h1>
		</c:if>
	</center>
</body>
</html>

