<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<style>
	
 	.container{ 
		width: 100%;
		
	}
	.container th {
		background-color: orange;	
		opacity: 0.8;
  		color:black;		
	}
	.container table {
		position: absolute;
		top: 40%;
		left: 20%;
		background: yellow;
		border-style:none;		
	}
	.container tr {
		background-color:none;
		color: black;
		font-weight:bold;
	}
	
		
		.table {
			height: 70px;
			width: 900px; 
			text-align:center;
			font-family:"Times New Roman";
			overflow:scroll;
			
		}
		
</style>

</head>
<body>
	
	<div class = "container">
	
	
	<table class = "table" cellpadding="20px" border="0px">
		<th>Policy Number
		<th>Policy Premium
		<th>Account Number
		<th>
		<c:forEach items="${policies}" var="policy">
			<tr class = "tr">
				<td><c:out value="${policy.policyNumber}" /><br>
				<td><c:out value="${policy.policyPremium}" /><br>
				<td><c:out value="${policy.accNumber }" /><br>
				<td><a href="ReportGenerationServlet?accNumber=${policy.accNumber}&polNumber=${policy.policyNumber}">View Policy</a>
			</tr>
		</c:forEach>
	</table>
	</div>
</body>
</html>