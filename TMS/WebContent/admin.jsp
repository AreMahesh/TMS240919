<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style> 
#example1 {
 background-color:  aqua;
  }
  #userName{
  margin-left: 450px;
  font-size: 20px;
  }
</style>
<script>
var myInput = document.getElementById("psw");
var letter = document.getElementById("letter");
var capital = document.getElementById("capital");
var number = document.getElementById("number");
var length = document.getElementById("length");

// When the user clicks on the password field, show the message box
myInput.onfocus = function() {
  document.getElementById("message").style.display = "block";
}

// When the user clicks outside of the password field, hide the message box
myInput.onblur = function() {
  document.getElementById("message").style.display = "none";
}

// When the user starts to type something inside the password field
myInput.onkeyup = function() {
  // Validate lowercase letters
  var lowerCaseLetters = /[a-z]/g;
  if(myInput.value.match(lowerCaseLetters)) {  
    letter.classList.remove("invalid");
    letter.classList.add("valid");
  } else {
    letter.classList.remove("valid");
    letter.classList.add("invalid");
  }
  
  // Validate capital letters
  var upperCaseLetters = /[A-Z]/g;
  if(myInput.value.match(upperCaseLetters)) {  
    capital.classList.remove("invalid");
    capital.classList.add("valid");
  } else {
    capital.classList.remove("valid");
    capital.classList.add("invalid");
  }

  // Validate numbers
  var numbers = /[0-9]/g;
  if(myInput.value.match(numbers)) {  
    number.classList.remove("invalid");
    number.classList.add("valid");
  } else {
    number.classList.remove("valid");
    number.classList.add("invalid");
  }
  
  // Validate length
  if(myInput.value.length >= 8) {
    length.classList.remove("invalid");
    length.classList.add("valid");
  } else {
    length.classList.remove("valid");
    length.classList.add("invalid");
  }
}
</script>

</head>
<body>
<div id="example1">
<form action="SaveLoginServlet" method="POST">
<h1><center>Training Management System</center></h1>

<h2><center>Login</center></h2><br><br>

<div id="userName">
User Name:<input type="text" name="uName" style="height: 30px;width:280px  " placeholder="your username" required autofocus/></td></tr>  
<script>

document.getElemtById('uName').setCustomValidity('your custom Validation message come true');
</script></td></tr><br><br>
Password:<input type="password" name="passWord" style="height: 30px;width: 280px;margin-left: 10px"   pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one
 number and one uppercase and lowercase letter, and at least 8 or more characters" required></td></tr><br>

<input type="hidden" name="adminId" value="1"><br>
<a href="adminRegistration.jsp?">New User</a><input type="submit" value="LogIn" style="margin-left: 60px;height: 30px;width:120px;"/>
</div>

<br><br><br><br><br><br><br><br><br><br><br><br><br><br>
</form>
<footer>
  <p>For More Information: <a href="https://www.virtusa.com">www.virtusa.com</a></p>
</footer>

</div>
</body>
 
</html>