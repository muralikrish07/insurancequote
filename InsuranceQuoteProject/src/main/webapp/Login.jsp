<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
<title> Login Page </title>
<style> 
Body {
  font-family: Calibri, Helvetica, sans-serif;
  background-color: blue;
}
button { 
       background-color: green; 
       width: 20%;
        color: orange; 
        padding: 15px; 
        margin: 10px 0px; 
        border: none; 
        cursor: pointer; 
         } 
 form { 
        border: 3px; 
    } 
 input[type=text], input[type=password] { 
        width: 150%; 
        margin: 8px 0;
        padding: 12px 20px; 
        display: inline-block; 
        border: 2px solid green; 
        box-sizing: border-box; 
    }
 button:hover { 
        opacity: 0.7; 
    } 
  .cancelbtn { 
        width: 30%; 
        padding: 10px 18px;
        margin: 10px 5px;
    } 
      
   
 .container { 
        width : 50%;
        padding: 25px; 
        background-color: lightblue;
    } 
</style> 
</head>  
<body>  
    <center> <h1> User Login </h1> </center> 
    <form action="loginServlet" method="post">
        <div class="container"> 
            <label>User ID : </label><br> 
            <input type="text" placeholder="Enter UserID" name="userid" required><br>
            <label>Password : </label><br> 
            <input type="password" placeholder="Enter Password" name="password" required><br>
            <button type="submit">Login</button><br>
            <input type="checkbox" checked="checked"> Remember me 
            <button type="button" class="cancelbtn"> Cancel</button> 
     
        </div>
    </form>
