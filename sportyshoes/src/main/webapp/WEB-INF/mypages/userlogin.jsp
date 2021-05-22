<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>sporty shoes login</title> 
<link rel="stylesheet" type="text/css" href="/style.css">     
</head>
<body>
<h2>Sporty Shoes Login Page</h2><br>        <div class="login">    

    <form method="post">    
        <label><b>User Name     
        </b>    
        </label>    
        <input type="text" name="Uname" id="Uname" placeholder="Username">    
        <br><br>    
        <label><b>Password     
        </b>    
        </label>    
        <input type="Password" name="Pass" id="Pass" placeholder="Password">    
        <br><br>    
        <input type="submit" name="log" id="log" value="Log In Here">       
        <br><br>    
        <input type="checkbox" id="check">    
        <span>Remember me</span>    
        <br><br>    
         <a href="/user">New User Register Here</a>
        <br>
        <h3><font color="red">${errorMessage}</font></h3> 
    </form> 
    </div> 
    </body> 
    <footer>
     <div class="footer">
       Developed  by senthilkumar
</div>
</footer>
</html>