<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Reset password</title> 
<link rel="stylesheet" type="text/css" href="style.css"> 
</head>
<body>
<h2>Admin Password Reset</h2>|<br>        <div class="login">    

    <form method="post">    
        <label><b>User Name     
        </b>    
        </label>    
        <input type="text" name="Uname" id="Uname" placeholder="Username">    
        <br><br>    
        <label><b>Old Password     
        </b>    
        </label>    
        <input type="Password" name="OPass" id="Pass" placeholder="Old Password">    
        <br><br>
         <label><b>New Password     
        </b>    
        </label>    
        <input type="Password" name="NPass" id="Pass" placeholder="New Password">      
        <input type="submit" name="log" id="log" value="Reset password">       
        <br><br>      
        <br><br>
        <br>
        <font color="red">${errorMessage}</font>  
    </form> 
    </div> 
    </body> 
    <footer>
     <div class="footer">
       Developed  by senthilkumar
</div>
</footer>
</body>
</html>