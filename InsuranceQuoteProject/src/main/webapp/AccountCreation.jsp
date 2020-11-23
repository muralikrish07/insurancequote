<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Account Creation</title>
<style>
body {
	margin: 0;
	padding: 0;
	overflow: hidden;
	
	background-size: cover;
	background-repeat: no-repeat;
	background-position: center;
	font-family: sans-serif;
}	

.accountbox {
	width: 580px;
	height: 750px;
	background: rgba(235, 242, 242, 0.7);
	color: black;
	top: 52%;
	left: 50%;
	position: absolute;
	transform: translate(-50%, -50%);
	box-sizing: border-box;
	padding: 60px 30px;
	box-shadow: 0 15px 25px rgba(0,0,0,0.3);
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
	background: black;
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
	<form action = "AccountCreationServlet" method = "post">
		<p>User Name</p>
		<input type = "text" name = "userName" placeholder = "Enter Insured name" pattern = "[a-zA-Z][a-zA-Z0-9]{8,20}" title = "The insured name should contain letters and numbers with atleast 8 characters" required>
		<p>Insured Name</p>
		<input type = "text" name = "insuredName" placeholder = "Enter Insured name" pattern = "[a-zA-Z][a-zA-Z0-9]{8,20}" title = "The insured name should contain letters and numbers with atleast 8 characters" required>
		<p>Insured Street</p>
		<input type = "text" name = "insuredStreet" placeholder = "Enter Insured street" pattern = "[a-zA-Z]{6,20}" title = "The street name should contain only letters with atleast 6 characters" required>
		<p>Insured City</p>
		<input type = "text" name = "insuredCity" placeholder = "Enter Insured city" pattern = "[a-zA-Z]{8,20}" title = "The city name should contain only letters with atleast 8 characters" required>
		<p>Insured State</p>
		<input type = "text" name = "insuredState" placeholder = "Enter Insured state" pattern = "[a-zA-Z]{8,20}" title = "The state name should contain only letters with atleast 8 characters" required>
		<p>Insured zip</p>
		<input type = "text" name = "insuredZip" placeholder = "Enter Insured zip" required><br><br>
		<p>Business Segment</p>
		<select name = "busSegName">
			<option value = "Business Auto">Business Auto</option>
			<option value = "Restaurant">Restaurant</option>
			<option value = "Apartment">Apartment</option>
			<option value = "General Merchant">General Merchant</option>
			<!-- <option value = "life">Life</option> -->
		</select><br><br>
		<center><input type = "submit" name = "submit" value = "Create Account"></center>
	</form>
</body>

</html>