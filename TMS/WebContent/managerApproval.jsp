
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.virtusa.bean.ManagerApprovalBean" %>
<%@page import="java.util.List"%> 
<%@page import="java.util.ArrayList"%>
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
<form action="managerApprovalServlet" method="GET">
<div id="h1">
<h1>Add Manager Approval</h1>

<% 
ArrayList<ManagerApprovalBean> nominationsList = (ArrayList<ManagerApprovalBean>) request.getAttribute("nominationsList"); 
request.setAttribute("hi", nominationsList);
 %>
 
<table>
     <tr>
     <td><u>Select</u></td><td><u>ID</u></td><td><u>Name</u></td><td><u>TrainingId</u></td><td><u>TrainingName</u></td><td><u>ApplyDate</u></td>
      <tr>

    <c:forEach items="${hi}" var="dataItem">
        <tr>
         <td align="center">  
            <input type="checkbox" name="selectedItems"   
                value="<c:out value="${dataItem.id}"/>"/>  
          </td>
            <td>${dataItem.id}</td>
            <td>${dataItem.name}</td>
            <td>${dataItem.trainingId}</td>
            <td>${dataItem.trainingName}</td>
            <td>${dataItem.applyDate}</td>
        </tr>
    </c:forEach>
</table><br>

<input type="submit" name="status" value="Approve" style="margin-left: 100px"/>
 <input type="submit" name="status" value="Reject"/>
     <br><br>
     
  </div>
</form>

</body>
</html>
