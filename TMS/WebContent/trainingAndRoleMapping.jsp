<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.virtusa.bean.RoleBean"%> 
<%@page import="com.virtusa.bean.TrainingBean" %>
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
<form action="TrainingAndRoleMappingServlet2" method="POST">
<div id="h1">
<h1>Add Role-Training Mapping</h1>

<%   
ArrayList<RoleBean> rolelist1 = (ArrayList<RoleBean>) request.getAttribute("roleList");
 ArrayList al1=new ArrayList();
for(int i=0;i<rolelist1.size();i++){
	al1.add((i+1)+""+rolelist1.get(i).getRoleName());
}
 request.setAttribute("hi", al1);
%>
<%   
ArrayList<TrainingBean> traininglist1 = (ArrayList<TrainingBean>) request.getAttribute("trainingList");
ArrayList al2=new ArrayList();
for(int i=0;i<traininglist1.size();i++){
	al2.add((i+1)+" "+traininglist1.get(i).getTrainingName());
}
request.setAttribute("hi1", al2);
%>

Role:<select style="width: 175px" name="roleIdFinal" id="roleIdFinal">
    <c:forEach var="line1" items="${hi}">
        <option><c:out value="${line1}"/></option>
    </c:forEach>
 </select><br><br><br>
 
Trainings:<br>
   <c:set var="count" value="0" scope="page" />
   <c:forEach var="item" items="${hi1}">
   ${item}  <input type="checkbox" name="item"  value="${item}"/><br>
  </c:forEach>
 
     <br><br>
      <input type="submit" name="submit" value="Submit">
  </div>
</form>

</body>
</html>