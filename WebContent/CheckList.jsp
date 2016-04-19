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
<body>

	<%@ include file="CommonOptions.jsp"%>

<h1> Check List </h1>

<c:forEach items="${candidate}" var="candidate">

<h2> Applicant name </h2>
<tr><td><c:out value="${candidate.applicantname}" /></td></tr>
<br>
<br>

<tr>
<td>Nationality: </td>
<td><c:out value="${candidate.citizenstatus}"/></td>
</tr>
<br>
<br>

<tr>
<td>Job Reference: </td>
<td><c:out value="${candidate.jobreference}"/></td>
</tr>
<br>
<br>

<tr>
<td>Job History: </td>
<td><c:out value="${candidate.jobhistory}"/></td>
</tr>
<br>
<br>

<tr>
<td>Drug Test Result: </td>
<td><c:out value="${candidate.drugtestresult}"/></td>
 </tr>
<br>
<br>

<tr>
<td>Veteran Status: </td> 
<td><c:out value="${candidate.veteranstatus}"/></td>
</tr>
<br>
<br>

</c:forEach>

<c:forEach items="${interviewtable}" var="interviewtable">

<tr>
<td>Coding Test Result: </td>
<td><c:out value="${interviewtable.codingtestresult}"/></td>
</tr>
<br>
<br>

<tr>
<td>HR Interview Result: </td>
<td><c:out value="${interviewtable.hrinterviewresult}"/></td>
</tr>
<br>
<br>

<tr>
<td>Hiring Manager Interview Result: </td>
<td><c:out value="${interviewtable.hminterviewresult}"/></td>
</tr>
<br>
<br>

<tr>
<td>Group Interview Result: </td>
<td><c:out value="${interviewtable.groupinterviewresult}"/></td>
</tr>
<br>
<br>

</c:forEach>

</body>
</html>
