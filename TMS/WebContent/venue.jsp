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

<body>
<%@include file="LogOutPage.jsp" %>
<%@include  file="myActSidePanelTrainingAdmin.jsp" %>
<form action="saveVenueServlet" method="POST">
<div id=h1>
<h1>Add Venue</h1>
Venue Name:<input type="text" name="venueName" placeholder="your venueName" required autofocus/></td></tr>  
<script>

document.getElemtById('venueName').setCustomValidity('your custom Validation message come true');
</script></td></tr><br>
Venue Description:<input type="text" name="venueDesc" placeholder="yourvenueDesc" required autofocus/></td></tr>  
<script>

document.getElemtById('venueDesc').setCustomValidity('your custom Validation message come true');
</script></td></tr><br>
    <input type="submit" name="submit" value="Submit">
  </div>
  </head>
</body>
</html>