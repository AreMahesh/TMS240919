<%@page import="java.util.HashSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashSet"%>
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
<%@include  file="myActSidePanelTrainingAdmin.jsp" %>
<form action="saveScheduleTrainnigServlet" method="POST">

<div id=h1>
<h1>Add Schedule Training</h1>
<% 
ArrayList trainingsList1 = (ArrayList) request.getAttribute("trainingsList"); 
ArrayList al=new ArrayList();
ArrayList al2=new ArrayList();
HashSet hs=new HashSet();

for(int i=0;i<trainingsList1.size();i++){
		al.add(trainingsList1.get(i));
}
HashSet hs1=new HashSet(al);
al2.addAll(hs1);
request.setAttribute("hi", al2);
 %>
 
 <% 
ArrayList venuesList1 = (ArrayList) request.getAttribute("venuesList"); 
ArrayList al1=new ArrayList();

for(int i=0;i<venuesList1.size();i++){
		al1.add(venuesList1.get(i));
}
 request.setAttribute("hi1", al1);
 %>


List Of Trainings:<select style="width: 175px" name="trainingNameFinal" id="trainingNameFinal">
    <c:forEach var="line1" items="${hi}">
        <option><c:out value="${line1}"/></option>
    </c:forEach>
 </select><br><br>
 Schedule Date:<input type="date" name="scheduleDate"><br><br>

 Select Venue:<select style="width: 175px" name="venueIdFinal" id="venueIdFinal">
    <c:forEach var="line1" items="${hi1}">
        <option><c:out value="${line1}"/></option>
    </c:forEach>
 </select><br><br>

<input type="submit" name="submit" value="Submit">
  
  </div>
  
  
  </form>
</body>
</html>