<%-- <%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="logoutpage.jsp"></jsp:include>
<!-- <script type="text/javascript">
window.history.forward();
function noBack() {
	window.history.forward();
}	
</script>
 --><input type="button" name="accountCreation" value="Account Creation" onClick="location.href='AgentAccountCreation.jsp'">
 <input type="button" name="PolicyCreation" value="Policy Creation" onClick="location.href='AgentPolicyCreation.jsp'">
 <!-- <form action = "AgentViewPolicy" method = "post">
 <input type="button" name="ViewPolicy" value="View Policy">
 </form> -->
 <a href = "AgentViewPolicy">View Policy</a>
 <%
//System.out.println(session.getAttribute("username"));
 if(session.getAttribute("usernameA")==null)
{
     response.sendRedirect("login.jsp");
}	 
%> 
<%
if(request.getAttribute("accountNotFound")!=null)
{
	out.println(request.getAttribute("accountNotFound"));
}
%>
</body>
</html> --%>
<!-- 
<html>
<head>
<title>Agent Home Page</title>
<style>
		body {
			margin: 0;
			padding: 0;
			background: url("pic3.jfif");
			background-size: cover;
			background-position: center;
		}
		.userHP {
			width: 100%;
			height: 590px;
			background: none;
			color: black;
			top: 290px;
			left: 960px;
			position: absolute;
			transform: translate(-50%, -50%);
		}
		.header {
			background-color: black;
			color: white;
			width:100%;
			height: 16%;
		}
		.header a {
			float:left;
			color: #f2f2f2;
			text-align: right;
			padding: 35px 40px;
			text-decoration: none;
			font-size: 25px;
			top:250px;
			left:100px;
		}
		.header-right {
			float: right;
			left: 110px;
			color: white;
		}

		.header button:hover {
			background-color: #ddd;
			color: white;
			
		}
		ul {
			list-style-type: none;
			margin: 0;
			padding: 0;
			position: absolute;
			top:16%;
			left: 0%;
			width: 100%;
			overflow: hidden;
			background-color: rgba(93, 109, 126 , 0.5);
		}

		li {
			float: left;
			width: 33.33%;
		}

		li button {
			display: block;
			color: blue;
			text-align: center;
			padding: 20px 16px;
			text-decoration: none;
			width:100%;
			cursor: pointer;
		}

		li button:hover {
			background-color: rgba(162, 217, 206 ,0.7);
		}
		.userframe {
		width:80%;
	
		margin-left:10%;
		margin-top:10%;
		height:60vh;
		border-style:none;
		}
		
		
	</style>
	<script>
	function accountCreation() {
	document.getElementById("displayIframe").innerHTML="<iframe src ='AgentAccountCreation.jsp' class ='userframe'></iframe>";
	}
	function policyCreation() {
	document.getElementById("displayIframe").innerHTML="<iframe src ='AgentPolicyCreation.jsp' class ='userframe'></iframe>";
	}
	</script>
</head>
<body>
<div class = "userHP">
		<div class="header">
			<a href="#default" class="logo">CompanyLogo</a>
			<div class="header-right">
				<a href="homepage2new.html">Logout</a>
			</div>
		</div>
		<div id ="displayIframe"></div>
		<ul>
			<li><button type = "submit" onclick="accountCreation()"><b>Account Creation</b></button></li>
			<li><button type = "submit" onclick="policyCreation()"><b>Policy  Creation</b></button></li>
			<li><button type = "submit" onclick="viewPolicy()"><b>View Policy</b></button></li>  
		</ul>
</body>
</html>  -->

<html>
<head>
<title>Agent Home Page</title>
<style>
		* {
			margin: 0;
			padding: 0;
		}
		body {
			overflow: hidden;
			margin: 0;
			padding: 0;
			background: url("pic6.jpg");
			background-size: cover;
			background-position: center;
			background-repeat: no-repeat;
		}
		
		.adminHP {
			width: 58%;
			height: 55%;
			background: none;
			position: absolute;
			top: 47%;
			left: 19%;
			transform: translate(-50%, -50%);
		}
		.header {
			background-color:green;
			width:100%;
			height: 10%;
			
		}
		.header a {
			float:left;
			color: black;
			margin: 0.3px;
			background-color: orange;
			cursor: pointer;
			text-align: right;
			padding: 20px 30px;
			text-decoration: none;
			font-size: 100%;
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
		.header a:hover {
			background-color: blue;
			color: white;
			
		}		
		ul {
			list-style-type: none;
			margin: 0;
			padding: 0;
			position: absolute;
			top:9.5%;
			left: 0%;;
			width: 100%;
			overflow: hidden;
			background-color: none;
		}

		li {
			float: left;
			width: 33.33%;
			
		}

		li button {
			display: block;
			color: blue;
			text-align: center;
			padding: 20px;
			text-decoration: none;
			width:100%;
			height:10%;
			font-size: 100%;
			background-color: white;
			cursor: pointer;
			border-left: black;
			
		}

		li button:hover {
			background-color: yellow;
		}
		.userframe {
		width:80%;
		margin-left:10%;
		margin-top:10%;
		height:63%;
		border-style:none;
		}
		
		
		
		
	</style>
	<script>
	function accountCreation() {
	document.getElementById("displayIframe").innerHTML="<iframe src ='AgentAccountCreation.jsp' class ='userframe'></iframe>";
	}
	function policyCreation() {
	document.getElementById("displayIframe").innerHTML="<iframe src ='policycreation.html' class ='userframe'></iframe>";
	}
	function viewPolicy() {
		document.getElementById("displayIframe").innerHTML="<iframe src ='AgentViewPolicy' class ='userframe'></iframe>";
		}
	</script>
</head>
<body>
<div class = "userHP">
		<div class="header">
			<a href="index.html" class="logo">CompanyLogo</a>
			<div class="header-right">
				<a href="index.html">Logout</a>
			</div>
		</div>
		<div id ="displayIframe"></div>
		<ul>
			<li><button type = "submit" onclick="accountCreation()"><b>Account Creation</b></button></li>
			<li><button type = "submit" onclick="policyCreation()"><b>Policy  Creation</b></button></li>
			<li><button type = "submit" onclick="viewPolicy()"><b>View Policy</b></button></li>  
		</ul>
</body>
</html>