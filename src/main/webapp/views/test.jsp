<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
	<head>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/static/lib/bootstrap/css/bootstrap.min.css" type="text/css">
		<script src="${pageContext.request.contextPath}/static/lib/bootstrap/js/cityTest.js" type="text/javascript"></script>	
	</head>
	
	<body>
		<center style="width:50%; border:1px solid #adadad;margin:20px auto;">
			<form class="form-horizontal" name="signupForm" action="<%=request.getContextPath()%>/registration/test" method="post">
				<fieldset>
					<legend style="color:green;padding:10px">Register Your Location</legend>
					
					<div class="form-group">
						<div class="col-md-10">
						    <select class="form-control" name="district" id="district" onchange="setThana()" required>
								<option value="">Select District</option>
								<option value="Bangladesh">Bangladesh</option>
								<option value="Australia">Australia</option>
								<option value="UnitedStates">United States</option>
						    </select>
					    </div>
					</div>
					
					<div class="form-group">
						<div class="col-md-10">
						    <select class="form-control" name="thana" id="thana" required>
								<option value="">Select Thana</option>
								<option value="">Please select a distrivt</option>
						    </select>
					    </div>
					</div>			
					
					<div class="form-group"><div class="col-md-10" ><input class="btn btn-success" type="submit" value="Register" class=""/> &nbsp; <a href="<%=request.getContextPath()%>/views/index.jsp">Go Home</a></div></div>
					
				</fieldset>
			</form>	
			
			<label id="customAlert" style="color:red"></label>
			
			<c:if test="${!empty message}">
				<h1 style="color:green">${message}</h1> 
			</c:if>
		</center>
	</body>
</html>

