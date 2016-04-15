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


<form action="Education" method="post">

Name:  
${name} 
<br>
<!--  Address: ${address}
<br>
Birthday: ${birthday}
<br>
Job History: ${jobhistory}
<br>
Reference: ${reference}
<br>
Veteran Status: ${veteran}
<br>
-->
</form>

 

Education: ${education}

<!-- Visible only if HR Specialist logs in -->

<form action="Education" method="post">
<c:if test="${rolename.equals('HR Specialist')}" >
	<input type="text" name="education"><br>
	<br> <input type="submit" value="education">
</c:if>
</form>




Drug User: ${druguser}

<!-- Visible only if Health care professional logs in -->

<form action="DrugUser" method="post">
<c:if test="${rolename.equals('Health Care Professional')}" >
Standard Panel Test:
 <input type="checkbox" name="drug" value="StandardPanelTest"> Pass<br>
  <input type="checkbox" name="drug" value="StandardPanelTest"> Fail<br>

Dot Test:
 <input type="checkbox" name="drug" value="DotTest"> Pass <br>
  <input type="checkbox" name="drug" value="DotTest"> Fail <br>

Alcohol Test:
 <input type="checkbox" name="drug" value="AlcoholTest"> Pass <br>
 <input type="checkbox" name="drug" value="AlcoholTest"> Fail <br>   
 
 <input type="submit" value="submit">
</c:if>
</form>





Citizenship: ${citizenship}

<!-- Visible only if Compliance Officer logs in -->

<form action="Citizenship" method="post">
<c:if test="${rolename.equals('Health Care Professional')}" >
<input type="radio" name="citizenship" value="IsCitizen"> Citizen <br>
 <input type="radio" name="citizenship" value="IsNotACitizen"> Not a citizen <br>
  <input type="submit" value="submit">  
</c:if>
</form>



<!-- Visible only if HR Manager logs in -->

<form action="HRManager" method="post">
<c:if test="${rolename.equals('HR Manager')}" >
 <input type="radio" name="reject"><br>
 <input type="radio" name="schedule"><br> 
 <input type="submit" value="schedule">
</c:if>
</form>




</body>
</html>