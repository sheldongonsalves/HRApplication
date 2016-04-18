<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ page import="model.HrLogin"%>
<%@ page import="model.HrRole"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Interview</title>
</head>
<body>
	<form>
		<h3>
			<c:out value="${user.hrRole.rolename} " /> Interview
		</h3>
		<input type="radio" name="status" value="pass" ${passchecked}> Pass<br>
		<input type="radio" name="status" value="fail" ${failchecked}> Fail<br>
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