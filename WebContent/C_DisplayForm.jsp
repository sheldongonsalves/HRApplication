<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


Name: ${name}
<br>
Address: ${address}
<br>
Birthday: ${birthday}
<br>
Job History: ${jobhistory}
<br>
Reference: ${reference}
<br>
Veteran Status: ${veteran}
<br>

Education: ${education}
<form action="Education" method="post">
<c:if test="${rolename.equals('HR Specialist')}" >
<!-- add part to enter degree information -->
</c:if>
</form>

Drug User: ${druguser}
<form action="DrugUser" method="post">
<c:if test="${rolename.equals('Health Care Professional')}" >
<!-- add part to enter degree information -->
</c:if>
</form>

Citizenship: ${citizenship}
<form action="Citizenship" method="post">
<c:if test="${rolename.equals('Health Care Professional')}" >
<!-- add part to enter degree information -->
</c:if>
</form>




</body>
</html>