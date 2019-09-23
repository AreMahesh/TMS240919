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
  margin-top: 2%;
}
</style>
</head>
<body>
<%@include file="LogOutPage.jsp" %>
<%@include  file="myActSidePanelEmployee.jsp" %>
<form action="nominationServlet" method="GET">

<div id=h1>
<h1>Add Nomination</h1>

<%    Object o=session.getAttribute("fname");
      Object o1=session.getAttribute("lname");
String fname=o.toString();
String lname=o1.toString();


%>


<%   
ArrayList<RoleBean> rolelist1 = (ArrayList<RoleBean>) request.getAttribute("roleList");
 ArrayList al1=new ArrayList();
for(int i=0;i<rolelist1.size();i++){
	//if(rolelist1.get(i).getRoleName()!=null){
	al1.add((i+1)+""+rolelist1.get(i).getRoleName());
	//}
}
 request.setAttribute("hi", al1);
 
%>
Role:  <select style="width: 175px" name="roleIdFinal" id="roleIdFinal" size="2%">
    <c:forEach var="line1" items="${hi}">
        <option><c:out value="${line1}" /></option>
    </c:forEach>
   
 </select><br><br><br>

<input type="submit" name="submit" value="send" style="margin-left: 5%;margin-bottom: -4%;margin-top:1%"><br><br><br>
   
 <% 
 if(request.getAttribute("trainingList")!=null){
ArrayList<TrainingBean> traininglist1 = (ArrayList<TrainingBean>) request.getAttribute("trainingList");
 ArrayList al2=new ArrayList();
for(int i=0;i<traininglist1.size();i++){
	al2.add(traininglist1.get(i).getTrainingId()+""+traininglist1.get(i).getTrainingName());
}
 request.setAttribute("hello", al2);
 }
 %>
  
 Training:<select style="width: 175px" name="trainingIdFinal" id="trainingIdFinal">
    <c:forEach var="line1" items="${hello}">
        <option><c:out value="${line1} " /></option>
    </c:forEach>
   
 </select><br><br><br>
<input type="hidden" name="fname" value=<%=fname %> placeholder="your fname" required autofocus/></td></tr>  
<script>

document.getElemtById('fname').setCustomValidity('your custom Validation message come true');
</script></td></tr><br>
 <input type="hidden" name="lname" value=<%=lname %>  placeholder="your lname" required autofocus/></td></tr>  
<script>

document.getElemtById('lname').setCustomValidity('your custom Validation message come true');
</script></td></tr><br>
 Interested Apply Date:<input type="date" name="applyDate" placeholder="your date" required autofocus/></td></tr>  
<script>

document.getElemtById('date').setCustomValidity('your custom Validation message come true');
</script></td></tr><br>     

<input type="submit" name="submit" value="Submit" style="margin-left: 10%">
  
  </div>
  
  
  </form>
</body>
</html>