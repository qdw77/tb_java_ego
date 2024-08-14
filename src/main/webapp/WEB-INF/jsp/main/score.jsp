<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table>
		<tr>
			<th>과목 아이디</th>
			<th>이름</th>
			<th>구분</th>
			<th>학기</th>
			<th>과목</th>
			<th>점수</th>
			<th>학생아이디</th>
		</tr>
		<c:forEach var="score" items="${list}">
			<tr>
				<td>${score.score_idx }</td>
				<td>${score.score_season }</td>
				<td>${score.score_semester }</td>
				<td>${score.score_exam_type }</td>
				<td>${score.score_subject }</td>
				<td>${score.score_point }</td>
				<td>${score.student_idx }</td>
				<%-- <td>${score.student_idx }</td> --%>
			</tr>
		</c:forEach>
	</table>

</body>
</html>