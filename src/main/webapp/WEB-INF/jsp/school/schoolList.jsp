<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학교 상세정보</title>
<!-- J쿼리 사용을 위해서 -->
<script src="https://code.jquery.com/jquery-3.7.1.js"
	integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
	crossorigin="anonymous"></script>

<!-- <script type="text/javascript">
  	function fn_detail(schoolIdx){  		
  		$("#schoolId").val(schoolIdx);
  		
  		console.log($("#schoolId").val());
   		var frm = $("#frm").serialize();
  		console.log(frm); 
	
  		$.ajax({
  			type : 'POST',
  			url: '/school/getSchoolInfo.do',
  			data : frm,
  			dataType : 'json',
  			beforeSend: function(jqXHR, settings){
  				console.log("beforeSend");
  			},
  			success: function(data, textStatus, errorThown) {
  				console.log("succes");
  				console.log(data);
  			// > 제이슨 데이터 뽑기> console.log(data);
  				var innerHtml = '';
  				innerHtml += '<tr>';
  				innerHtml += '<th>학교명</th>';
  				innerHtml += '<td>';
  				innerHtml += data.schoolInfo.schoolName;
  				innerHtml += '</td>';
  				innerHtml += '</tr>';
  				$("#schoolTb").html(innerHtml);
			},
  			error : function(jqXHR, textStaus, errorThrown) {
  				console.log("error");
  			},
			complete : function(jqXHR, textStatus){
				console.log("complete");
			}
  		});
  		
  	} -->
  		

  		
<!-- 	$.ajax({
			type : 'POST',
			url: '/school/getSchoolInfo.do',
			data : { 'schoolIdx' : schoolIdx},
			dataType : 'json',
			beforeSend: function(jqXHR, settings){
				console.log("beforeSend");
			},
			success: function(data, textStatus, errorThown) {
				console.log("succes");
				console.log(data);
				// 제이슨 데이터 뽑기> console.log(data);
				var innerHtml = '';
				innerHtml += '<tr>';
				innerHtml += '<tr>학교명</tr>';
				innerHtml += '<td>';
				innerHtml += data.schoolInfo.schoolName;
				innerHtml += '</td>';
				innerHtml += '</tr>';
				$("#schoolTb").html(innerHtml);
		},
			error : function(jqXHR, textStaus, errorThrown) {
				console.log("error");
			},
		complete : function(jqXHR, textStatus){
			console.log("complete");
		}
		}); 
  		
  		<input type="button" id="btn_insert" name="btn_insert" value="저장"/>
  		
  	}
  	-->
  	
 <script type="text/javascript">
  $( document ).ready(function() {
	  $("#btn_insert").on('click', function(){
		  fn_insertSchool();
	  })
	});
  
  	function fn_insertSchool(){
  		
  		var frm = $("#frm").serialize();

  		$.ajax({
  			type : 'POST',
  			url : '/school/insertSchoolInfo.do',
  			data : frm,
  			dataType : 'json',
  			beforeSend: function(jqXHR, settings){
  				console.log("beforeSend");
  			},
  			success : function(data, textStatus, jqXHR){
  				if(data.resultChk > 0){
  					alert("저장되었습니다.");	
  				}
  				
  			},  				
  			error: function(jqXHR, textStatus, errorThrown){
  				console.log("error");
  			},
  			complete : function(jqXHR, textStatus){
  				console.log("complete");
  			}
  		});
  	}

</script>


</head>
<body>

<%-- 	<form id="frm" name="frm">
		<input type="hidden" id="schoolId" name="schoolId" value="" />
	</form>
	<table id="schoolTb">
		<tr>
			<th style="border: 1px solid #444444;">학교명</th>
			<th style="border: 1px solid #444444;">지역구</th>
			<th style="border: 1px solid #444444;">주소</th>
			<th style="border: 1px solid #444444;">연락처</th>
		</tr>
		<c:forEach var="school" items="${schoolList }">
			<tr>
				<td style="border: 1px solid #444444;"><a
					href="/school/getSchoolInfo.do?schoolIdx=${school.schoolId}">${school.schoolName }</a></td>
				<td style="border: 1px solid #444444;"><a
					href="javascript:fn_detail(${school.schoolId});">${school.schoolName }</a></td>
				<td style="border: 1px solid #444444;">${school.schoolArea }</td>
				<td style="border: 1px solid #444444;">${school.schoolAddr }</td>
				<td style="border: 1px solid #444444;">${school.schoolPhone }</td>
			</tr>
		</c:forEach>
	</table> --%>



	<%-- 	
<from>

	<table id="schoolTb">
		<tr>
			<th style="border: 1px solid #444444;">학교명</th>
			<th style="border: 1px solid #444444;">지역구</th>
			<th style="border: 1px solid #444444;">주소</th>
			<th style="border: 1px solid #444444;">연락처</th>
		</tr>
		<c:forEach var="school" items="${schoolList }">
			<tr>
				<td style="border: 1px solid #444444;"><a href="/school/getSchoolInfo.do?schoolIdx=${school.schoolId}">${school.schoolName }</a></td>
				<td style="border: 1px solid #444444;"><a href="javascript:fn_detail(${school.schoolId});">${school.schoolName }</a></td>
				<td style="border: 1px solid #444444;">${school.schoolArea }</td>
				<td style="border: 1px solid #444444;">${school.schoolAddr }</td>
				<td style="border: 1px solid #444444;">${school.schoolPhone }</td>
			</tr>
		</c:forEach>
	</table> 
	
	</from>

	 --%>

	<form id="frm" name="frm">
		<input type="hidden" id="schoolId" name="schoolId" value="" />
		<table>
			<tr>
				<th>학교명</th>
				<td><input type="text" id="schoolName" name="schoolName" value=""/></td>
			</tr>
			<tr>
				<th>지역구</th>
				<td><input type="text" id="schoolArea" name="schoolArea" value=""/></td>
			</tr>
			<tr>
				<th>주소</th>
				<td><input type="text" id="schoolAddr" name="schoolAddr" value=""/></td>
			</tr>
			<tr>
				<th>연락처</th>
				<td><input type="text" id="schoolPhone" name="schoolPhone" value=""/></td>
			</tr>
		</table>
	</form> 
	
	<input type="button" id="btn_insert" name="btn_insert" value="저장"/>
	
	<!-- 실행링크 > http://localhost:8080/school/getSchoolList.do -->

</body>
</html>