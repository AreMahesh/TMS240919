
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Registration</title>
<style type="text/css">
body {

  margin: 0;
  background-image:url('abc.jpg');
  background-color:aqua;
  font-family: Arial, Helvetica, sans-serif;
  background-size:cover;
  border-color: aqua;
}
.A{
margin-top: 5px;
margin-left: -100px;
width: 225px;
height: 20px;

}
</style>
</head>

<body>
<h1><center>Registration</center></h1>
<form action="SaveRegistrationServlet" method="POST">

<center>
<table>
<tr><td>First Name:</td><td><input type="text" class ="A" name="userFirstname" placeholder="your userFirstname" required autofocus/></td></tr>  
<script>

document.getElemtById('userFirstname').setCustomValidity('your custom Validation message come true');
</script></td></tr><br>
<tr><td>Last Name:</td><td><input type="text" class ="A" name="userLastname" placeholder="your userLastname" required autofocus/></td></tr>  
<script>

document.getElemtById('userLastname').setCustomValidity('your custom Validation message come true');
</script></td></tr><br>
<tr><td>Email:</td><td><input type="email" class ="A" name="userEmail" placeholder="your Email" required autofocus/></td></tr>  
<script>

document.getElemtById('userLastname').setCustomValidity('your custom Validation message come true');
</script></td></tr><br>
<tr><td>Date Of Birth:</td><td><input type="date" class ="A" name="userDOB" placeholder="your dob" required autofocus/></td></tr>  
<script>

document.getElemtById('userDOB').setCustomValidity('your custom Validation message come true');
</script></td></tr><br>
<tr><td>Address:</td><td><input type="text" class ="A" name="userAddress" placeholder="your userAddress" required autofocus/></td></tr>  
<script>

document.getElemtById('userAddress').setCustomValidity('your custom Validation message come true');
</script></td></tr><br>
<tr><td>User Name:</td><td><input type="text" class ="A" name="userName" placeholder="your userName" required autofocus/></td></tr>  
<script>

document.getElemtById('userName').setCustomValidity('your custom Validation message come true');
</script></td></tr><br>
<tr><td>Password:</td><td><input type="password"  class ="A" name="userPassword"  placeholder="your userPassword"  pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one
 number and one uppercase and lowercase letter, and at least 8 or more characters" required>

<tr><td>Confirm Password:</td><td><input type="password" class ="A" name="userConfirmPW" placeholder="your userConfirmPW" required autofocus/></td></tr>  
<script>

document.getElemtById('userConfirmPW').setCustomValidity('your custom Validation message come true');
</script></td></tr><br>
<tr><td>User Type:<select name="userType" style="margin-right: 30px;margin-top: 5px;width: 125px">
  <option value="1">Admin</option>
  <option value="2">Employee</option>
  <option value="3">Training Admin</option>
  </select>
</td></tr>
<tr><td><input type="submit" name="submit" style="margin-top: 5px;margin-left: 200px"></td></tr>
</table>
</center>

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
</script>
     </form>
   </body>
</html>
