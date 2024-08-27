<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table>
		<tr>
			<th>학생명</th>
			<td>${studentInfo.studentName}</td>
		</tr>
	
		<tr>
			<th>학교명</th>
			<td>${studentInfo.schoolName}</td>
		</tr>
	
	
		<tr>
			<th>졸업여부</th>
			<td>${studentInfo.graduateYn}</td>
		</tr>
	
	</table>
	
	<a href="/studentMng/getStudentMngList.do">목록으로</a>

</body>
</html>