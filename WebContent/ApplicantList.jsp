<!-- yash -->


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

	<table class="table">
		<tr>
			<th>Applicant ID</th>
			<th>Applicant Name</th>
		</tr>


		<c:forEach var="item" items="${applicantlist}">
			
				<tr>
					<td><c:out value="${item.applicantid}"></c:out></td>
					<td><c:out value="${item.applicantname}"></c:out></td>
					<form action="ApplicantServlet" method="post">
					<td><input type="hidden" name="applicantid" value="${item.applicantid}"> 
					<input type="submit" value="view details"></td>
					</form>
				</tr>
			
		</c:forEach>

	</table>

	<!--  	<form action="/NewApplicant.jsp">
		<input type="hidden" name="add" value="${Loginid}">
		<input type="submit" name="add" value="Add New Applicant" >
		</form>-->


	<c:if test="${roleid.equals(3)}">
		<!-- need to confirm loginid and role id -->
	<!--  	<form action="NewApplicant.jsp" method="post">
			<input type="button" value="Add Applicant">
		</form>  -->
		
		<a href="NewApplicant.jsp"> Add new applicant </a>
		
	</c:if>
</body>
</html>