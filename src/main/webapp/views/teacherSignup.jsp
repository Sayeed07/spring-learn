<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<head>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/static/lib/bootstrap/css/bootstrap.min.css" type="text/css">
		<script src="../js/bootstrap.min.js"></script>	
	</head>
	
	<body>
		<center style="width:50%; border:1px solid #adadad;margin:20px auto;">
			<form class="form-horizontal" name="signupForm" action="<%=request.getContextPath()%>/registration/teacher/save" method="post">
				<fieldset>
					<legend style="color:green;padding:10px">Register For Teacher Account</legend>
					
					<div class="form-group"><div class="col-md-10"><input name="teacherId" type="hidden" class="form-control input-md" value="${teacher.teacherId}"> </div></div>
					
					<div class="form-group"><div class="col-md-10"><input name="teacherName" type="text" placeholder="Full Name" class="form-control input-md" value="${teacher.teacherName}" required> </div></div>
				
					<div class="form-group"><div class="col-md-10"><input name="department" type="text" placeholder="Department Name" class="form-control input-md" value="${teacher.department}" required> </div></div>
					
					<div class="form-group"><div class="col-md-10" ><input class="btn btn-success" type="submit" value="Register" class=""/> &nbsp; <a href="<%=request.getContextPath()%>/views/index.jsp">Go Home</a></div></div>
					
				</fieldset>
			</form>	
			
			<c:if test="${!empty message}">
				<h1>${message}</h1> 
			</c:if>
		</center>
	</body>
</html>

