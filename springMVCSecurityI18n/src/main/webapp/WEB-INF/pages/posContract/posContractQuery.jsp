<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<script src="http://code.jquery.com/jquery-2.1.1.min.js" type="text/javascript"></script>
<script type="text/javascript">

function update(){
	if($('#param_id').val().length==0){
		alert("error");
		return;
	}
    $('#param_content').val($('#content').val());
    //alert($('#param_content').val());
    document.getElementById("updateform").submit();
}

function query(){
	var t=$('#select').val();
	$('#qType').val(t);
    document.getElementById("queryFrom").submit();
}

$( document ).ready(function() {
	if($('#param_id').val().length==0){
		$('#updateBtn').hide();
	}
});
</script>
<body>
<select id="select">
	<c:forEach var	="combo" items="${list}">
  		<option value="${combo.type}"> ${combo.NAME}</option>
	</c:forEach>
</select> 
<a href="javascript:query()"><spring:message code="jsp.com.forward"/></a>
	<form action="/posContract/posContract/html/findByType" method="get" id="queryFrom" name="queryFrom">
		<input type="hidden" value="" id="qType" name="qType"/>
	</form>
	<form action="/posContract/posContract/html/update" method="post" id="updateform" name="udpateform">
	
		<input type="hidden" value="<c:out value="${posContract.id}"/>"  name="param_id" id="param_id"/>
		<input type="hidden" value="a" id="param_content" name="param_content"/>
		<input type="hidden" value="<c:out value="${posContract.type}"/>"  name="param_type"/>
		<table border="1">
			<thead>
				<tr>
					<th><spring:message code="jsp.posContract.type" /></th>
					<th><spring:message code="jsp.posContract.writer" /></th>
					<th><spring:message code="jsp.posContract.createDate" /></th>
					<th><spring:message code="jsp.posContract.updateDate" /></th>
					<th><spring:message code="jsp.posContract.version" /></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><c:out value="${posContract.name}"/></td>
					<td>
						<input name="param_writer" value="<c:out value="${posContract.writer}"/>"/>	
					</td>
					<td><c:out value="${posContract.createDate}"></c:out></td>
					<td><c:out value="${posContract.updateDate}"></c:out></td>
					<td><c:out value="${posContract.version}"></c:out></td>
					<!-- <td><a href="/webUI/bom/html/edit?id=<c:out value="${bom.id}"/>"><spring:message code="jsp.com.edit"/></a></td> -->
				</tr>
				<tr>
					<td colspan="4"><spring:message code="jsp.posContract.content" /></td>
					<td><a id="updateBtn" href="javascript:update()"><spring:message code="jsp.com.update" /></a></td>
				</tr>
				<tr>
					<td colspan="5">
						<textarea id="content" rows="50" cols="130"><c:out value="${posContract.content}"></c:out></textarea>
					</td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>