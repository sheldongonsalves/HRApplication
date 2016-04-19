<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1> Check List </h1>

<c:forEach items="${candidate}" var="candidate">

<h2> Applicant name </h2>
<tr><td><c:out value="${candidate.applicantname}" /></td></tr>
<br>

Nationality: 
<tr><td><c:out value="${candidate.citizenstatus}"/></td></tr>
<br>
Job Reference: 
<tr><td><c:out value="${candidate.jobreference}"/></td></tr>
<br>
Job History: 
<tr><td><c:out value="${candidate.jobhistory}"/></td></tr>
<br>
Drug Test Result:
 <tr><td><c:out value="${candidate.drugtestresult}"/></td></tr>
<br>
Veteran Status:  
<tr><td><c:out value="${candidate.veteranstatus}"/></td></tr>
<br>

</c:forEach>

<c:forEach items="${interviewtable}" var="interviewtable">

Coding Test Result: 
<tr><td><c:out value="${interviewtable.codingtestresult}"/></td></tr>
<br>
HR Interview Result: 
<tr><td><c:out value="${interviewtable.hrinterviewresult}"/></td></tr>
<br>
Hiring Manager Interview Result: 
<tr><td><c:out value="${interviewtable.hminterviewresult}"/></td></tr>
<br>
Group Interview Result:
 <tr><td><c:out value="${interviewtable.groupinterviewresult}"/></td></tr>
<br>

</c:forEach>

</body>
</html>
