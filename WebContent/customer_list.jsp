<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.techpalle.model.Customer" %>
    <%@ page import="java.util.ArrayList" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer list</title>
<!-- CDN > Content Delivery Network -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</head>
<body>

<header style="color:white">

	<nav class="navbar navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Customer Management</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="<%= request.getContextPath()%>/table>">Customer</a>
        </li>
      </ul>
    </div>
  </div>
</nav>

</header>
	<br/>
	<br/>
	
	<div class="container"  >
	<h2 align="center">Customer List</h2>
	<hr>
		<form action="insertForm" >
 					<button  class="btn btn-success">Add Customer</button>
		</form>

	<table class="table">
		  <thead> 
		    <tr>
		      <th scope="col">Id</th>
		      <th scope="col">Name</th>
		      <th scope="col">Email</th>
		      <th scope="col">Mobile</th>
		      <th scope="col">Action</th>
		    </tr>
		  </thead>
		  
		  <tbody>
				<c:forEach var="i" items="${al}">
					<tr>
							<td><c:out value="${i.id}"></c:out></td>	
							<td><c:out value="${i.name}"></c:out></td>
							<td><c:out value="${i.email}"></c:out></td>
							<td><c:out value="${i.mobile}"></c:out></td>
																		<!-- Queary String -->
							<td>
								<a href="editForm?id=<c:out value="${i.id}"></c:out>"><button type="button" class="btn btn-outline-warning">Edit</button></a>
								 &nbsp;&nbsp; 
								 <a href="delete?id=<c:out value="${i.id}"></c:out>"><button type="button" class="btn btn-outline-danger">Delete</button></a>
							 </td>
					</tr>		
				</c:forEach>	
		  </tbody>
		  <br/>
     </table>
     </div>
</body>
</html>