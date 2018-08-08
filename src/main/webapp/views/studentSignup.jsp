<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
	<head>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/static/lib/bootstrap/css/bootstrap.min.css" type="text/css">
		<script src="../js/bootstrap.min.js"></script>	
	</head>
	
	<body>
		<center style="width:50%; border:1px solid #adadad;margin:20px auto;">
			<form class="form-horizontal" name="signupForm" action="<%=request.getContextPath()%>/registration/student/save-or-update" method="post">
				<fieldset>
					<legend style="color:green;padding:10px">Register For Teacher Account</legend>
					
					<div class="form-group">
						<div class="col-md-10">
						    <select class="form-control" name="teacherId">
								<option value="">Select Teachers</option>
								<c:forEach items="${teachers}" var="teacher">
									<option value="${teacher.teacherId}">${teacher.teacherName}(${teacher.department})</option>
								</c:forEach>
						    </select>
					    </div>
					</div>				
					
					<div class="form-group"><div class="col-md-10"><input name="studentId" type="hidden" class="form-control input-md" value="${student.studentId}"> </div></div>
					
					<div class="form-group"><div class="col-md-10"><input name="studentName" type="text" placeholder="Full Name" class="form-control input-md" value="${student.studentName}" required> </div></div>
				
					<div class="form-group"><div class="col-md-10"><input name="studentRoll" type="text" placeholder="Studdent Roll" class="form-control input-md" value="${student.studentRoll}" required> </div></div>
					
					<div class="form-group"><div class="col-md-10"><input name="studentBatch" type="text" placeholder="Studdent Batch" class="form-control input-md" value="${student.studentBatch}" required> </div></div>
					
					<div class="form-group"><div class="col-md-10"><input name="phoneNumber" type="text" placeholder="Phone Number" class="form-control input-md" value="${student.phoneNumber}" required> </div></div>
					
					<div class="form-group"><div class="col-md-10" ><input class="btn btn-success" type="submit" value="Register" class=""/> &nbsp; <a href="<%=request.getContextPath()%>/views/index.jsp">Go Home</a></div></div>
					
				</fieldset>
			</form>	
			
			<label id="customAlert" style="color:red"></label>
			
			<c:if test="${!empty message}">
				<h1>${message}</h1> 
			</c:if>
		</center>
	</body>
</html>

