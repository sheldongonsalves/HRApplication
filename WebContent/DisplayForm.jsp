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
<h1> HR Application </h1>


<c:if test="${roleid.equals(1)||roleid.equals(6)||roleid.equals(7)}" >
<form action="CheckList" method="post">
 <input type="submit" value="CheckList">
 </form>
</c:if>

<c:forEach items="${candidate}" var="candidate">

<h2> Applicant Details </h2>

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

</c:forEach>

<br>
<c:forEach items="${candidate}" var="candidate">
Education: ${candidate.education}
</c:forEach>

<c:if test="${roleid.equals(2)}" > 
<form action="Education" method="post">   
	<input type="text" name="education"><br>
	<input type="submit">
	</form>
	
	<c:forEach items="${applicantUpdate}" var="applicantUpdate">
	Updated Education:
	 <tr><td><c:out value="${applicantUpdate.education}"/></td></tr>
	</c:forEach>
	</c:if>
<br>
<br>



  


<c:forEach items="${candidate}" var="candidate">
Drug Test: ${candidate.drugtestresult} <br>
</c:forEach>
<br>

<c:if test="${roleid.equals(4)}"> 

	
<form action="DrugUser" method="post">   

Update test results: <br>
	
Standard Panel Test:
  	<input type="radio" name="test1" value="Pass" > Pass
  	<input type="radio" name="test1" value="Fail"> Fail<br> 


Dot Test:
 	<input type="radio" name="test2" value="Pass" > Pass
  	<input type="radio" name="test2" value="Fail"> Fail<br> 

Alcohol Test:
 	<input type="radio" name="test3" value="Pass"> Pass 
 	<input type="radio" name="test3" value="Fail"> Fail <br>   
 
 	<input type="submit" value="submit">
	
	</form>
	<c:forEach items="${applicantUpdate}" var="applicantUpdate">
	Updated Drug Test:
	 <tr><td><c:out value="${applicantUpdate.drugtestresult}"/></td></tr>
	</c:forEach>
	</c:if>
<br>





<c:forEach items="${candidate}" var="candidate">
Citizen: ${candidate.citizenstatus}
</c:forEach>


<c:if test="${roleid.equals(5)}" > 
<form action="Citizenship" method="post">   
<input type="radio" name="citizenship" value="Yes"> Citizen <br>
 <input type="radio" name="citizenship" value="No"> Not a citizen <br>
  <input type="submit" value="submit"> 
	</form>
	
	<c:forEach items="${applicantUpdate}" var="applicantUpdate">
	Updated Citizenship:
	 <tr><td><c:out value="${applicantUpdate.citizenstatus}"/></td></tr>
	</c:forEach>
	</c:if>
<br>
<br>




<c:if test="${roleid.equals(1)}" >
<form action="Reject" method="post">
 Candidate not the best fit:
 <input type="submit" value="Reject"><br>
 </form>
 
 <form action="PreInterview" method="post">
 Continue with candidate:
 <input type="submit" value="Schedule">
 </form>
</c:if>





</body>
</html>