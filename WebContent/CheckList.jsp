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

<title>CheckList JSP</title>
</head>
<body background="https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcQVKicit_rgbITlRlAbVK2vU2fZ2QGTkBP0vcFbnxcIO9Wwl_J2">

	<%@ include file="CommonOptions.jsp"%>

<h3 align="right">${username}<br>
${rolename}</h3>

<br>
<h3 align="center"> Applicant Check List </h3>

<c:forEach items="${candidate}" var="candidate">

<h3> Applicant name: <c:out value="${candidate.applicantname}" /> </h3>

<br>
<br>
</c:forEach>

<table class="table">

<c:forEach items="${candidate}" var="candidate">

<tr>
<td>Nationality: </td>
<td><c:out value="${candidate.citizenstatus}"/></td>
</tr>


<tr>
<td>Job Reference: </td>
<td><c:out value="${candidate.jobreference}"/></td>
</tr>


<tr>
<td>Job History: </td>
<td><c:out value="${candidate.jobhistory}"/></td>
</tr>

<tr>
<td>Drug Test Result: </td>
<td><c:out value="${candidate.drugtestresult}"/></td>
 </tr>


<tr>
<td>Veteran Status: </td> 
<td><c:out value="${candidate.veteranstatus}"/></td>
</tr>


</c:forEach>

<c:forEach items="${interviewtable}" var="interviewtable">

<tr>
<td>Coding Test Result: </td>
<td><c:out value="${interviewtable.codingtestresult}"/></td>
</tr>


<tr>
<td>HR Interview Result: </td>
<td><c:out value="${interviewtable.hrinterviewresult}"/></td>
</tr>


<tr>
<td>Hiring Manager Interview Result: </td>
<td><c:out value="${interviewtable.hminterviewresult}"/></td>
</tr>


<tr>
<td>Group Interview Result: </td>
<td><c:out value="${interviewtable.groupinterviewresult}"/></td>
</tr>



</c:forEach>

</table>

	<br>
	<form action="DisplayForm.jsp" method="post">
	<input type="submit" value="Back">
    </form>
    
</body>
</html>
