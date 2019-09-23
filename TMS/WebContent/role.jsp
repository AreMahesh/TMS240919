<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
#h1 {
  margin-left: 20%;
}
</style>
</head>
<body>
<%@include file="LogOutPage.jsp" %>
<%@include  file="myActSidePanelAdmin.jsp" %>
<form action="SaveRoleServlet" method="POST">
<div id=h1>
<h1>Add Roles</h1>
Role Name:<input type="text" name="roleName" placeholder="your rolename" required autofocus/></td></tr>  
<script>

document.getElemtById('roleName').setCustomValidity('your custom Validation message come true');
</script></td></tr><br><br>
Role Description:<input type="text" name="roleDesc" placeholder="your roledescription" required autofocus/></td></tr>  
<script>

document.getElemtById('roleDesc').setCustomValidity('your custom Validation message come true');
</script></td></tr><br><br>
    <input type="submit" name="submit" value="Submit">
  </div>
</body>
</html>