<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ page import="model.HrLogin"%>
<%@ page import="model.HrRole"%>
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
	<form>
		<h3>
			<c:out value="${user.hrRole.rolename} " /> Interview
		</h3>
		<input type="radio" name="status" value="pass" checked> Pass<br>
		<input type="radio" name="status" value="fail"> Fail<br>
		<br>

		<h4>Any Comments?</h4>
		<input type="text" name="comment" value="${param.comment}"><br>
		<hr>
		<c:if test="${user.hrRole.rolename != 'HR Manager'}" >
			<h3>Taken Coding Test?</h3>
			<input type="radio" name="test" value="yes" checked> Yes 
			<input type="radio" name="test" value="no"> No<br>
			<h3>Dose the Applicant Pass or Fail?</h3>
			<input type="radio" name="teststatus" value="pass" checked>
			Pass <input type="radio" name="teststatus" value="fail"> Fail<br>
		</c:if>
		<input type="submit" value="Submit">
	</form>
</body>
</html>