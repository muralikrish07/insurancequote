<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%-- <html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
body, html {
  /* background-image: url("image5.jpg"); */
  background-repeat: no-repeat;
  background-size: cover;
  height: 20%;
  font-family: Arial, Helvetica, sans-serif;
  left-padding:0px;
  max-height: 0px;
  min-height: 0px;
  
}

* {
  box-sizing: border-box;
  top:50px;
}

.rolecode {
			position: relative;
			font-family: Arial;
		}


/* Add styles to the form container */
.container {
  position: center;
  center: 0;
  margin: 30px;
  max-width: 600px;
  max-height: 3000px;
  padding: 0px;
  background-color: white;
}

/* Full-width input fields */
input[type=text], [type=number] {
  width: 100%;
  padding: 10px;
  margin: 5px 0 22px 0;
  border: none;
  background: #f1f1f1;
}

input[type=text]:focus {
  background-color: #ddd;
  outline: none;
}

/* Set a style for the submit button */
.createbtn {
  background-color: #20b2aa;
  color: white;
  padding: 16px 20px;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
}

.createbtn:hover {
  opacity: 1;
}

.header {
	background-color: #20b2aa;
	font-size: 6;
	
}
</style>
</head>
<body>
<jsp:include page="logoutpage.jsp"></jsp:include>
<script type="text/javascript">
window.history.forward();
function noBack() {
	window.history.forward();
}	
</script>
<div align = "center" class = "img-4">
	<form action ="AgentAccountCreationServlet" class = "container " align ="center" method="post">
	<table align = "center">
		<div class = "header">
		<br>
		<h1 align = "center">Account Creation</h1>
		<p align = "center">Enter the following details</p><br>
		</div>
		
		<tr>
		<br>
		<td>
		<label for = "username"><b>User Name</b></label>
		<br><br>
		<td><input type = "text" placeholder="Enter Username name" name = "userName" required><br>
		
		
		<tr>
		<br>
		<td>
		<label for = "insuredname"><b>Insured Name</b></label>
		<br><br>
		<td><input type = "text" placeholder="Enter insured name" name = "insuredName" required><br>
		<tr>
		<td><label for = "insuredstreet"><b>Insured Street</b></label>
		<br><br>
		<td><input type = "text" placeholder="Enter insured street" name = "insuredStreet" required><br>
		<tr>
		<td><label for = "insuredcity"><b>Insured City</b></label>
		<br><br>
		<td><input type = "text" placeholder="Enter insured city" name = "insuredCity" required><br>
		<tr>
		<td><label for = "insuredstate"><b>Insured State</b></label>
		<br><br>
		<td><input type = "text" placeholder="Enter insured state" name = "insuredState" required><br>
		<tr>
		<td><label for = "insuredzip"><b>Insured Zip</b></label>
		<br><br>
		<td><input type = "text" placeholder="Enter insured zip" name = "insuredZip" required><br>
		<tr>
		<td><label for = "businesssegment" width = "100%"><b>Business Segment</b></label>
		<br><br>
		
		<td><select name = "busSegName">
			<option value = "businessauto">Business Auto</option>
			<option value = "Restaurant">Restaurant</option>
			<option value = "apartment">Apartment</option>
			<option value = "generalmerchant">General Merchant</option>
		</select><br><br>
		<tr>
		<td><td>
		<button type = "submit" class = "createbtn" style="width:100%">Create</button>
		</tr>
		
		</table>
	</form>
	</div>
</body>
</html> --%>

<html>

<head>
<title>Account Creation</title>
<style>
body {
	margin: 0;
	padding: 0;
	overflow: hidden;
	<!--background: url("pic8.jpg");-->
	background-size: cover;
	background-repeat: no-repeat;
	background-position: center;
        background-color: yellow;
	font-family: sans-serif;
}	

.accountbox {
	width: 580px;
	height: 750px;
	background:orange;
	color: black;
	top: 62%;
	left: 50%;
	position: absolute;
	transform: translate(-50%, -50%);
	box-sizing: border-box;
	padding: 60px 30px;
	box-shadow: white;
}

h1 {
	margin: 0;
	padding: 15 0 20px;
	text-align: center;
	font-size: 35px;
}

.accountbox p {
	margin: 0;
	padding: 0;
	font-weight: bold;
}

.accountbox input[type = "text"] {
	border: none;
	width: 100%;
	border-bottom: 1px solid black;
	background: transparent;
	outline: none;
	height: 22px;
	color: black;
        font-size: 16px;
	padding: 0px;
	margin: 10px 10 10px 0;
}

.accountbox select {
	width: 100%;
	height: 30px;
	background: transparent;
	border: 1px solid black;
	cursor: pointer;
}

.accountbox input[type = "submit"] {
	border: none;
	outline: none;
	height: 30px;
	width: 50%;
	background: blue;
	color: #fff;
	font-size: 18px;
	border-radius: 15px;
}

.accountbox input[type = "submit"]:hover {
	cursor: pointer;
	background: #708090;
	color: white;
}

</style>
</head>

<body>
	<div class = "accountbox">
	<h1>Account Creation</h1>
	<br>
	<form action = "AgentAccountCreationServlet" method = "post">
		<p>User Name</p>
		<input type = "text" name = "userName" pattern = "[a-zA-Z][a-zA-Z0-9]{8,20}" title = "The insured name should contain letters and numbers with atleast 8 characters" required>
		<br><br><p>Insured Name</p>
		<input type = "text" name = "insuredName" pattern = "[a-zA-Z][a-zA-Z0-9]{8,20}" title = "The insured name should contain letters and numbers with atleast 8 characters" required>
		<br><br><p>Insured Street</p>
		<input type = "text" name = "insuredStreet" pattern = "[a-zA-Z]{6,20}" title = "The street name should contain only letters with atleast 6 characters" required>
		<br><br><p>Insured City</p>
		<input type = "text" name = "insuredCity"  pattern = "[a-zA-Z]{8,20}" title = "The city name should contain only letters with atleast 8 characters" required>
		<br><br><p>Insured State</p>
		<input type = "text" name = "insuredState"  pattern = "[a-zA-Z]{8,20}" title = "The state name should contain only letters with atleast 8 characters" required>
		<br><br><p>Insured zip</p>
		<input type = "text" name = "insuredZip"  required>
		<br><br><p>Business Segment</p>
		<br>
		<select name = "busSegName">
			<option value = "Business Auto">Business Auto</option>
			<option value = "Restaurant">Restaurant</option>
			<option value = "Apartment">Apartment</option>
			<option value = "General Merchant">General Merchant</option>
			<!-- <option value = "life">Life</option> -->
		</select>
		<br><br><center><input type = "submit" name = "submit" value = "Create Account"></center>
	</form>
</body>

</html>