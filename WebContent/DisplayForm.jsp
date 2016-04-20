<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<body background="https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcQVKicit_rgbITlRlAbVK2vU2fZ2QGTkBP0vcFbnxcIO9Wwl_J2">

	<%@ include file="CommonOptions.jsp"%>
<h2>${username}</h2>
<h3>${rolename}</h3>
<br>
<h3>Applicant Details</h3>
	<table class="table table-hover table-condensed">

		<c:if test="${roleid.equals(1)||roleid.equals(6)||roleid.equals(7)}">
			<form action="CheckList" method="post">
				<input type="submit" value="CheckList">
			</form>
		</c:if>

		<c:forEach items="${candidate}" var="candidate">

			<h2>Applicant Details</h2>

			<table class="table table-hover table-condensed">
				<tr>
					<td>Name:</td>
					<td><c:out value="${candidate.applicantname}" /></td>
				</tr>

				<tr>
					<td>Address:</td>
					<td><c:out value="${candidate.address}" /></td>
				</tr>

				<tr>
					<td>Birthday:</td>
					<td><c:out value="${candidate.birthdate}" /></td>
				</tr>

				<tr>
					<td>Job History:</td>
					<td><c:out value="${candidate.jobhistory}" /></td>
				</tr>

				<tr>
					<td>Reference:</td>
					<td><c:out value="${candidate.jobreference}" /></td>
				</tr>

				<tr>
					<td>Veteran Status:</td>
					<td><c:out value="${candidate.veteranstatus}" /></td>
				</tr>


			</table>

		</c:forEach>

		<br>
		<!-- Edit option only available to roleid 3 -->
		<table class="table table-condensed">
			<c:forEach items="${candidate}" var="candidate">

				<c:if test="${roleid.equals(3)}">
					<form action="EditServlet" method="post">
						<tr>
							<td>Name:</td>
							<td><input type="text" name="Name"
								value="<c:out value="${candidate.applicantname}" />"></td>
						</tr>
						<br>
						<tr>
							<td>Address:</td>
							<td><input type="text" name="Address"
								value="<c:out value="${candidate.address}"/>"></td>
						</tr>
						<br>
						<tr>
							<td>Job History:</td>
							<td><input type="text" name="Jobhistory"
								value="<c:out value="${candidate.jobhistory}"/>"></td>
						</tr>
						<br>
						<tr>
							<td>Reference:</td>
							<td><input type="text" name="Reference"
								value="<c:out value="${candidate.jobreference}"/>"></td>
						</tr>
						<br>
						<tr>
							<td>Veteran Status:</td>
							<td><input type="text" name="Veteranstatus"
								value="<c:out value="${candidate.veteranstatus}"/>"></td>
						</tr>
						<tr>
							<td><br> <input type="hidden" name="edit"
								value="${applicantid}"><br> <input type="submit"
								value="Update"></td>
						</tr>
					</form>
				</c:if>
			</c:forEach>
		</table>
		<br>

		<table class="table table-condensed">
			<c:forEach items="${candidate}" var="candidate">
				<tr>
					<td>Education:</td>
					<td>${candidate.education}</td>
				</tr>

			</c:forEach>

			<c:if test="${roleid.equals(2)}">
				<form action="Education" method="post">
					<tr>
					<td><input type="text" name="education"><br> <input
						type="submit"></td>
						</tr>
				</form>

				<c:forEach items="${applicantUpdate}" var="applicantUpdate">
	 		<tr><td>Updated Education:</td>
	
						<td><c:out value="${applicantUpdate.education}" /></td>
					</tr>
				</c:forEach>
			</c:if>
		</table>





		<c:forEach items="${candidate}" var="candidate">
			<table class="table table-condensed">
				<tr>
					<td>Drug Test:</td>
					<td>${candidate.drugtestresult}</td>
				</tr>
			</table>
		</c:forEach>
		<br>

		<c:if test="${roleid.equals(4)}">

			<table class="table table-condensed">
				<form action="DrugUser" method="post">
					<tr>
						<td><h4>Update test results</h4></td>
					</tr>
					<tr>
						<td>Standard Panel Test:</td>
						<td><input type="radio" name="test1" value="Pass">
							Pass</td>
						<td><input type="radio" name="test1" value="Fail">
							Fail</td>
					</tr>
					<tr>
						<td>Dot Test:</td>
						<td><input type="radio" name="test2" value="Pass">
							Pass</td>
						<td><input type="radio" name="test2" value="Fail">
							Fail</td>
					</tr>
					<tr>
						<td>Alcohol Test:</td>
						<td><input type="radio" name="test3" value="Pass">
							Pass</td>
						<td><input type="radio" name="test3" value="Fail">
							Fail</td>
					</tr>
					<tr>
						<td><input type="submit" value="submit"></td>
					</tr>

				</form>
				<c:forEach items="${applicantUpdate}" var="applicantUpdate">
					<tr>
						<td>Updated Drug Test:</td>

						<td><c:out value="${applicantUpdate.drugtestresult}" /></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>

		<br>





		<c:forEach items="${candidate}" var="candidate">
			<table class="table table-condensed">
				<tr>
					<td>Citizen:</td>
					<td>${candidate.citizenstatus}</td>
				</tr>
			</table>
		</c:forEach>


		<c:if test="${roleid.equals(5)}">
			<form action="Citizenship" method="post">
				<input type="radio" name="citizenship" value="Yes"> Citizen
				<br> <input type="radio" name="citizenship" value="No">
				Not a citizen <br> <input type="submit" value="submit">
			</form>

			<c:forEach items="${applicantUpdate}" var="applicantUpdate">
	Updated Citizenship:
	 <tr>
					<td><c:out value="${applicantUpdate.citizenstatus}" /></td>
				</tr>
			</c:forEach>
		</c:if>
		<br>
		<br>


		<tr>
			<td><c:if
					test="${roleid.equals(1)||roleid.equals(6)||roleid.equals(7)}">
					<form action="Reject" method="post">
					<c:forEach items="${candidate}" var="candidate">
					
					<input type="hidden" name="reject" value="${candidate.applicantname}">
				
						Candidate not the best fit: <input type="submit" value="reject"><br>
					</c:forEach>
					</form>

					<form action="PreInterview" method="post">
					<c:forEach items="${candidate}" var="candidate">
					
					<input type="hidden" name="reject" value="${candidate.applicantname}">
						Continue with candidate: <input type="submit" value="Schedule">
							</c:forEach>
					</form>
				</c:if></td>
		</tr>

	</table>

<br>
	<form action="ApplicantList.jsp" method="post">
	<input type="submit" value="Back">
    </form>
</body>
</html>