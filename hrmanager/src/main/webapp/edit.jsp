<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.nagarro.models.Employee"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<div class="header">
		<h1>
			HR Manager			
		</h1>
		<p class="welcome">welcome user!</p>
  		<img src="img_girl.jpg" class="welcome1">
  		<img></img>
	</div>
	
			<% Employee e=(Employee)request.getAttribute("empData"); %>
	
<div class="container">

		<form action="updatedEmployee/<%=e.getCode()%>" method="post">
			<div class="form-group">
				<label for="exampleInputEmail1">Employee Code</label> <input
                type="text" field="<%e.getCode();%>" value="<%=e.getCode()%>" class="form-control"
                 name="employeeCode"
					readonly />
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">Employee Name</label> <input
					type="text" field="<%e.getName();%>" value="<%=e.getName()%>" class="form-control" placeholder="Enter Employee Name"
					name="name">
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">Employee Email address</label> <input
					type="email" th:field="${employeeData.employeeEmail}" value="<%=e.getEmail()%>" class="form-control" placeholder="Enter email"
					name="email">
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">Employee Location</label> <input
					type="text" field="<%e.getLocation();%>" value="<%=e.getLocation()%>" class="form-control" placeholder="Enter email"
					name="location">
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">Employee Date of Birth</label> <input
					type="text" field="<%e.getDob();%>" value="<%=e.getDob()%>" class="form-control"
					placeholder="Enter employee date of Birth"
					name="dob">
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>

</body>
</html>