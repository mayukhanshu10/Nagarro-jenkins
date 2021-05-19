<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.nagarro.models.Employee"%>
<%@page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<%@page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<style>
.welcome
{
  position :absolute;
  right:6vw

  
}

.button
{
  position:relative;
  top:10px;
  float:right;
}
.welcome1
{
  position :absolute;
  right:6vw;
  top:5vw
}
	.header{
     	padding: 10px;
  		text-align: center;
  		background: #EE82EE;
  		color: white;
     }
    
.footer {
  width: 100%;
  text-align: center;
  padding: 10px;
    		background: #EE82EE;

  color: white;
  position: absolute;
  bottom: 0px;
}
        
  font-size: 30px;
</style>

<body>
	<div class="header">
		<h1>
			HR Manager			
		</h1>
		<p class="welcome">welcome user!</p>
  		<img src="img_girl.jpg" class="welcome1">
  		<img></img>
	</div>
    
     <div class="button">
      <button>Upload Employee Details</button>
        <button>Download Employee Details</button>
      </div>
   
    	<div class="container">
		<div class="row">


			<div class="col-md-12">
				<h4>Employee Listings</h4>
				<div class="table-responsive">


					<table id="mytable" class="table table-bordered table-striped">

						<thead>

							<th>Employee Code</th>
							<th>Employee Name</th>
							<th>Location</th>
							<th>Email</th>
							<th>Date of Birth</th>
							<th>Action</th>
						</thead>

						<tbody>
						<%	
						List<Employee> employees =(List<Employee>) request.getAttribute("empList");
						if(employees!=null) {
							for(Employee emp : employees) {
								%>
							<tr>
								<td><%=emp.getCode()%></td>
								<td><%=emp.getName()%></td>
								<td><%=emp.getLocation()%></td>
								<td><%=emp.getEmail()%></td>
								<td><%=emp.getDob()%></td>
								<td> <a href="updateEmployee/<%=emp.getCode()%>" class="btn btn-primary">Edit</a>							
							</tr>
							<%
							}
							}
							%>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
    
    <div class="footer">
    	<h1>
			 <small> Copyright &copy;Nagarro Software Pvt. Limited</small>
		</h1>
    </div>
    	
</body>
</html>
