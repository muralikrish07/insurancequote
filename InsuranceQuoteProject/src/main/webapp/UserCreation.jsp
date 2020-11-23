<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Creation</title>
<style>
body {
  background-image: url("user creation.jpg");
}
form{color: black;
font-size:20px}
</style>
</head>
<body>
<center>
<form action=" " method="post"/>
User Name:<br>
<input type="text" name="uname" placeholder="Enter the user name" pattern="[A-Z]{1}[A-Za-z0-9]{5}" title="First letter sholud be uppercase and remaining should be lowercase or numbers with length 6"required/><br>
Password:<br>
<input type="password" name="pass"placeholder="Enter the password"min="6" max="15" size="15"pattern="\w{6,15}"title="First letter should be uppercase and remaining should be lowercase,numbers and 1 underscore with length 8"required/><br>
Role code:<br>
<select name="Role codes" id="Role code" required>
<option value=" select">select</option>
<option value="Insured ">Insured</option>
<option value="Agent">Agent</option>
<option value="UnderWriter">UnderWriter</option>
</select><br>
<br>
<button>submit</button>
</form>
</center>
</body>
</html>