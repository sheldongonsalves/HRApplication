<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<title>Interview JSP</title>
</head>
<body>
<body
	background="https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcQVKicit_rgbITlRlAbVK2vU2fZ2QGTkBP0vcFbnxcIO9Wwl_J2">
	<%@ include file="CommonOptions.jsp"%>

	<div class="col-xs-12">

		<h3 align="right">${username}<br> ${rolename}
		</h3>
		<br>
		<h3 align="center">Interview Details</h3>

		<form action="Interview" method="post">
			<h3>
				<c:out value="${user.hrRole.rolename} " />
				Interview
			</h3>
			<input type="radio" name="status" value="Pass"> Pass<br>
			<input type="radio" name="status" value="Fail"> Fail<br>
			<br>

			<h4>Any Comments?</h4>
			<input type="text" name="comment" value="${param.comment}"><br>
			<hr>
			<c:if test="${user.hrRole.rolename != 'HR Manager'}">
				<c:forEach items="${interviewresult}" var="interview">

					<c:if test="${interview.codingtest!='Taken'}">

						<h3>Taken Coding Test?</h3>
						<input type="radio" name="test" value="Taken"> Yes 
			    <input type="radio" name="test" value="NotTaken"> No<br>
						<h3>Does the Applicant Pass or Fail?</h3>
						<input type="radio" name="teststatus" value="Pass">
			Pass <input type="radio" name="teststatus" value="Fail"> Fail<br>

					</c:if>

				</c:forEach>
				<!--<c:forEach items="${interviewresult}" var="interview">

				<c:if test="${interview.codingtestresult!='Pass'||interview.codingtestresult!='Fail'}">

					<h3>Does the Applicant Pass or Fail?</h3>
					<input type="radio" name="teststatus" value="Pass">
			Pass <input type="radio" name="teststatus" value="Fail"> Fail<br>

				</c:if>

			</c:forEach>-->
			</c:if>
			<input type="submit" value="Submit">
		</form>

		<br> <br>
		<form action="DisplayForm.jsp" method="post">
			<input type="submit" value="Back">
		</form>
	</div>
</body>
</html>
