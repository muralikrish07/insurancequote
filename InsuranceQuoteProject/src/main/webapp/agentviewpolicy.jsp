<%-- <%@page import="com.cg.qgs.model.Policy"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table border="2">
		<th>Policy Number
		<th>Policy Premium
		<th>Account Number
		<th>
		<c:forEach items="${policies}" var="policy">
			<tr>
				<td><c:out value="${policy.policyNumber}" /><br>
				<td><c:out value="${policy.policyPremium}" /><br>
				<td><c:out value="${policy.accNumber }" /><br>
				<td><a href="AgentReportGenerationServlet?accNumber=${policy.accNumber}&polNumber=${policy.policyNumber}">View Policy</a>
			</tr>
		</c:forEach>
	</table>
</body>
</html> --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<style>
	body{
		overflow:hidden;
	}
	
 	.container{ 
		width: 100%;
		
	}
	.container th {
		background-color: #412252;	
		opacity: 0.8;
  		color:white;		
	}
	.container table {
		position: absolute;
		top: 15%;
		left: 20%;
		background-color: #ced2cc;
		border-style:none;		
	}
	.container tr {
		background-color: #ced2cc;
		color: black;
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
				<td><a href="AgentReportGenerationServlet?accNumber=${policy.accNumber}&polNumber=${policy.policyNumber}">View Policy</a>
			</tr>
		</c:forEach>
	</table>
	</div>
</body>
</html>