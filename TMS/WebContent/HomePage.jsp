<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
  margin: 0;
  background-image:url('abc.jpg');
  background-color:aqua;
  font-family: Arial, Helvetica, sans-serif;
  background-size:cover;
  border-color: aqua;
}
.header{
text-align:center;
font-size:30px;
color:green;
height:50px;
width:100%;  margin:25px;

}
.topnav {
  overflow: hidden;
margin:0 200px;
margin-left: 100px;
}

.topnav a {
  float: left;
  background-color: #333;
  color: #f2f2f2;
  text-align: center;
  padding: 25px 30px;
  margin:0 25px;
  text-decoration: none;
  font-size: 50px;
}

.topnav a:hover {
  background-color: #ddd;
  color: green;
}

.topnav a.active {
  background-color: #4CAF50;
  color: white;
}

</style>


</head>
<body>

<div class="header">
<h1>Training Management System</h1>
</div>
<div class="topnav"><br><br><br><br><br><br><br><br><br><br>
<%
Object o1=request.getAttribute("hiddenId");
/* Object o2=request.getAttribute("fname");
Object o3=request.getAttribute("lname");
String s1=o1.toString();
String s2=o2.toString();
String s3=o3.toString();
request.setAttribute("fname", s2);
request.setAttribute("lname", s3);
 */
 /* int a=Integer.parseInt(s1);

out.println("chalchal"+s2);
 */%>

<a href="role.jsp" onclick="return theFunction(a); id="adminId">Admin</a>
<a href="trainingsView.jsp" id="employeeId">Employee</a>
<a href="venue.jsp" id="trainingAdminId">Training Admin</a>
<script type="text/javascript">
    function theFunction (a) {
        if(a==1){
          return true;
         }else{
          return false;
           document.getElementById("demo").innerHTML = "Good day!";
       }
        // return true or false, depending on whether you want to allow the `href` property to follow through or not
    }
</script>



</div> 
</div>
</div>
</body>
</html>