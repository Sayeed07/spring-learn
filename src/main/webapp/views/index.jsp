<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
	<head>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/static/lib/bootstrap/css/bootstrap.min.css" type="text/css">
	</head>

	<body>
		<div class=" border-bottom box-shadow" style="padding: 1%">
			<div class="row">
				<div class="col-md-5">
				
				</div>
				<div class="col-md-7 align-items-right" style="padding: 1%">
					<a class="p-2 text-dark" href="#">Contact</a> 
					<a class="btn btn-outline-primary" href="<%=request.getContextPath()%>/registration/student/studentSignup">student sign-up</a>&nbsp;
					<a class="btn btn-outline-primary" href="<%=request.getContextPath()%>/views/teacherSignup.jsp">teacher sign-up</a>&nbsp;
					<a class="btn btn-outline-warning" href="<%=request.getContextPath()%>/views/uploadImage.jsp">upload image</a>
					<a class="btn btn-outline-success" href="<%=request.getContextPath()%>/views/test.jsp">Test</a>
					<a class="btn btn-outline-success" href="">teacher login</a>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-3">
				<div class="card" style="width: 18rem;">
				 <!--  <img class="card-img-top" src=".../100px180/?text=Image cap" alt="Card image cap">  -->
				  <div class="card-body">
				    <h5 class="card-title">Card title</h5>
				    <p class="card-text">Some quick example text to build on the card title</p>
				  </div>
				  <ul class="list-group list-group-flush">
				    <li class="list-group-item"><a href="<%=request.getContextPath()%>/registration/teacher/find-all">View Teachers Info</a></li>
				    <li class="list-group-item"><a href="<%=request.getContextPath()%>/registration/student/find-all">View Students Info</a></li>
				    <li class="list-group-item"><a href="<%=request.getContextPath()%>/registration/photo/find-all">View Photos Info</a></li>
				    <li class="list-group-item"><a href="#">Others</a></li>
				  </ul>
				  <div class="card-body">
				    <a href="#" class="card-link">Card link</a>
				    <a href="#" class="card-link">Another link</a>
				  </div>
				</div>
			</div>
			<div class="col-md-9">
				
				<div class="">
					<table class="table">
						<thead>
							<tr>
								<th scope="col">Teacher Id</th>
								<th scope="col">Teacher Name</th>
								<th scope="col">Department</th>
								<th scope="col">Action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${teachers}" var="teacher">
								<tr>
									<th scope="row">${teacher.teacherId}</th>
									<td>${teacher.teacherName}</td>
									<td>${teacher.department}</td>
									<td>
										<a class="btn btn-outline-success" href="<%=request.getContextPath()%>/registration/student/edit?teacherId=${teacher.teacherId}">EDIT</a>
										<a class="btn btn-outline-danger" href="<%=request.getContextPath()%>/registration/student/delete?teacherId=${teacher.teacherId}">DELETE</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					
					<br/>
					
					<table class="table">
						<thead>
							<tr>
								<th scope="col">Id</th>
								<th scope="col">Name</th>
								<th scope="col">Roll</th>
								<th scope="col">Batch</th>
								<th scope="col">Phone</th>
								<th scope="col">Course Teacher</th>
								<th scope="col">CT Department</th>
								<th scope="col">CT Id</th>
								<th scope="col">Action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${students}" var="student">
								<tr>
									<th scope="row">${student.studentId}</th>
									<td>${student.studentName}</td>
									<td>${student.studentRoll}</td>
									<td>${student.studentBatch}</td>
									<td>${student.phoneNumber}</td>
									<td>${student.getTeacher().teacherName}</td>
									<td>${student.getTeacher().department}</td>
									<td>${student.getTeacher().teacherId}</td>
									<td>
										<a class="btn btn-outline-success" href="<%=request.getContextPath()%>/registration/student/edit?studentId=${student.studentId}">EDIT</a>
										<a class="btn btn-outline-danger" href="<%=request.getContextPath()%>/registration/student/delete?studentId=${student.studentId}">DELETE</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					
					<br/>
					
					<table class="table">
						<thead>
							<tr>
								<th scope="col">Id</th>
								<th scope="col">Photo</th>
								<th scope="col">Title</th>
								<th scope="col">Description</th>
								<th scope="col">Price</th>
								<th scope="col">Action</th>
							</tr>
						</thead>
						<tbody>
						
							<form class="form-inline" name="signupForm" action="<%=request.getContextPath()%>/registration/photo/searchPrice" method="post">
								<div class="form-group">
									<input class="form-control mr-sm-2" type="search" name="productTitle" placeholder="Search" aria-label="Search" required>
								</div>
								<button class="btn btn-outline-success" type="submit">Find</button>&nbsp;
							</form>
							
							<div class="row_chart_wrapper">
								<c:if test="${imageName==null || imageName==''}">
									<div class="row_chart">
										<img class="img img-thumbnail" src="<c:url value="/photos/"></c:url>download.png" />
									</div>
								</c:if>
								
								<c:if test="${imageName!=null && imageName!=''}">
									<div class="row_chart">
										<img class="img img-thumbnail" src="<c:url value="/photos/"></c:url>${imageName}" />
									</div>
								</c:if>
								
							</div>
							
							<c:forEach items="${photoDatas}" var="photoData">
								
								
				
								<tr>
									<th scope="row">${photoData.productId}</th>
									<td><img src="<c:url value="/photos/"></c:url>${photoData.imageName}" class="img img-thumbnail" /></td>
									<td>${photoData.productTitle}</td>
									<td>${photoData.productDescription}</td>
									<td>${photoData.productPrice}</td>
									<td>
										<a class="btn btn-outline-success" href="<%=request.getContextPath()%>/registration/photo/edit?productId=${photoData.productId}">EDIT</a>
										<a class="btn btn-outline-danger" href="<%=request.getContextPath()%>/registration/photo/delete?productId=${photoData.productId}">DELETE</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</body>
</html>
