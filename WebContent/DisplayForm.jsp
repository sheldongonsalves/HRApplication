<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>
</head>
<body>

<c:forEach items="${candidate}" var="candidate">
<form action="Education" method="post">

Name:  
<tr><td><c:out value="${candidate.applicantname}" /></td></tr>
<br>
Address: 
<tr><td><c:out value="${candidate.address}"/></td></tr>
<br>
Birthday: 
<tr><td><c:out value="${candidate.birthdate}"/></td></tr>
<br>
Job History: 
<tr><td><c:out value="${candidate.jobhistory}"/></td></tr>
<br>
Reference:
 <tr><td><c:out value="${candidate.jobreference}"/></td></tr>
<br>
Veteran Status:  
<tr><td><c:out value="${candidate.veteranstatus}"/></td></tr>
<br>

</form>
</c:forEach>




</body>
</html>