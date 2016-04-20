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



<title>New Applicant Details</title>
</head>
<body background="https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcQVKicit_rgbITlRlAbVK2vU2fZ2QGTkBP0vcFbnxcIO9Wwl_J2">

	<%@ include file="CommonOptions.jsp"%>

<h2>${username}</h2>
<br>
<h3>${rolename}</h3>
<br>	
<h3>Insert New Applicant Details</h3>
<table class="table">
<tr><td><form action="NewApplicantServlet" method="Post">

<tr><td>Name:</td><td><input type="text" id="Name" name="Name" /></td></tr>
<tr><td>Address:</td><td><input type="text" id="Address" name="Address" /></td></tr>
<tr><td>BirthDate:</td><td><input type="date" id="Birthdate" name="Birthdate" /></td></tr>
<tr><td>Education:</td><td><input type="text" id="Education" name="Education" /></td></tr>
<tr><td>Job History:</td><td><input type="text" id="Jobhistory" name="Jobhistory" /></td></tr>
<tr><td>Reference:</td><td><input type="text" id="Reference" name="Reference" /></td></tr>
<tr><td>Veteran Status:</td><td><input type="text" id="Veteranstatus" name="Veteranstatus" /></td></tr>


<tr><td><input type="hidden" name="Add Details" value="1">
<input type="submit" value="Add Details"></td></tr>
</form></td></tr>

</table>

    	<br>
	<br>
	<form action="ApplicantList.jsp" method="post">
	<input type="submit" value="Back">
    </form>
</body>
</html>