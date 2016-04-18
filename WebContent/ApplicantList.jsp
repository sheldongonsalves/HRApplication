<!--yash-->

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

		<c:forEach var="Applicant" items="${applicantlist}">
			<tr>
				 <td><c:out value="${Applicant.applicantid}"/></td>
				<!--  <td><input type="hidden" name="Applicantid"
					value="${Applicant.applicantid}"> 
					 <a href='<c:out value="#ApplicantServlet" />'>${Applicant.applicantname}</a> 
					

				</td>
				-->
			</tr>
		</c:forEach>
	</table>

	<!--  	<form action="/NewApplicant.jsp">
		<input type="hidden" name="add" value="${Loginid}">
		<input type="submit" name="add" value="Add New Applicant" >
		</form>-->


	<c:if test="${roleid.equals(3)}"> <!-- need to confirm loginid and role id -->
		<form action="NewApplication.jsp">
			<input type="button" value="Add Applicant">
		</form>
	</c:if>
</body>
</html>