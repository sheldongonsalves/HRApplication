<!-- yash -->


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>
</head>
<body background="https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcQVKicit_rgbITlRlAbVK2vU2fZ2QGTkBP0vcFbnxcIO9Wwl_J2">

	<%@ include file="CommonOptions.jsp"%>
<h2>Welcome, ${username}</h2>
<h3>${rolename}</h3>
<br>
<h3>Applicant List</h3>
	<table class="table">
		<tr>
			<th>Applicant ID</th>
			<th>Applicant Name</th>
		</tr>


		<c:forEach var="item" items="${applicantlist}">
			
				<tr>
					<td><c:out value="${item.applicantid}"></c:out></td>
					<td><c:out value="${item.applicantname}"></c:out></td>
					<form action="ApplicantServlet" method="post">
					<td><input type="hidden" name="applicantid" value="${item.applicantid}"> 
					<input type="submit" value="view details"></td>
					
					</form>
				</tr>
			
		</c:forEach>

	</table>

	<!--  	<form action="/NewApplicant.jsp">
		<input type="hidden" name="add" value="${Loginid}">
		<input type="submit" name="add" value="Add New Applicant" >
		</form>-->


	<c:if test="${roleid.equals(3)}">
		<!-- need to confirm loginid and role id -->
	<!--  	<form action="NewApplicant.jsp" method="post">
			<input type="button" value="Add Applicant">
		</form>  -->
		
		<a href="NewApplicant.jsp"> Add new applicant </a>
		
	</c:if>
	

    
</body>
</html>