<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="2">
		<th>Policy Number
		<th>Policy Premium
	
		
		<c:forEach items="${policies}" var="policy">
			<tr>
				<td><c:out value="${policy.policyNumber}" /><br>
				<td><c:out value="${policy.policyPremium}" /><br>
				<td><a href="InsuredReportGenerationServlet?accNumber=${policy.accNumber}&polNumber=${policy.policyNumber}">View Policy</a>
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
		
		
		body {
			overflow: hidden;
			margin: 0;
			padding: 0;
			background: url("pic6.jpg");
			background-size: cover;
			background-position: center;
		}
	
	
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
		top: 50%;
		left: 20%;
		background-color: black;
		border-style:none;		
	}
	.container tr {
		background-color: white;
		color: black;
	}
	
		
		.table {
			height: 70px;
			width: 900px; 
			text-align:center;
			font-family:"Times New Roman";
			overflow:scroll;
			
		}
	.adminHP {
			width: 38%;
			height: 95%;
			background: none;
			position: absolute;
			top: 47%;
			left: 19%;
			transform: translate(-50%, -50%);
		}
		.header {
			background-color: green;
			width:263%;
			height: 11%;
			
		}
		.header button {
			float:left;
			color: black;
			margin: 2px;
			background-color: orange;
			cursor: pointer;
			text-align: right;
			padding: 17px 30px;
			text-decoration: none;
			font-size: 120%;
			position: relative;
			top:7%;
			left:0%;
			border: none;
		}
		.header-right {
			float: right;
			top:-17%;
			right : 0%;
			border: none;
			position: relative;
			padding: 20px 0px
			
		}
		.header button:hover {
			background-color: yellow;
			color: black;
			
		}
		
</style>

</head>
<body>

	<div class="adminHP">
		<div class="header">
			<button href="#default" class="logo">CompanyLogo</button>
			<div class="header-right">
				<button class="active" href="homepage2new.html">Logout</button>
			</div>
		</div>
		</div>
	
	<div class = "container">
	
	
	<table class = "table" cellpadding="20px" border="0px">
		<th>Policy Number
		<th>Policy Premium
		<th>
		<c:forEach items="${policies}" var="policy">
			<tr class = "tr">
				<td><c:out value="${policy.policyNumber}" /><br>
				<td><c:out value="${policy.policyPremium}" /><br>
				<td><a href="InsuredReportGenerationServlet?accNumber=${policy.accNumber}&polNumber=${policy.policyNumber}">View Policy</a>
			</tr>
		</c:forEach>
	</table>
	</div>
	
	
</body>
</html>