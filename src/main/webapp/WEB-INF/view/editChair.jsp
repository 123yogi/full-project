<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
  <link rel="stylesheet" href='<c:url value="/resources/css/bootstrap.min.css"></c:url>' />
  <script src='<c:url value="/resources/js/jquery.min.js"></c:url>'></script>
  <script src='<c:url value="/resources/js/bootstrap.min.js"></c:url>'></script>
  <script src='<c:url value="/resources/js/angular.min.js"></c:url>'></script>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="landPage">Admin Home</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="retriveRecords">Manage Products</a></li>
      <li><a href="category">Manage Categories</a></li>
      <li><a href="manageSupplier">Manage Suppliers</a></li>
      </ul>
           <div><ul>
      		<li class="nav navbar-nav navbar-right"><a href="<c:url value='/j_spring_security_Logout'/>">
      		<span class="glyphicon glyphicon-log-in"></span>
						Logout</a></li></ul></div>
  </div>
</nav>
<h2>Edit Product</h2>
  <form:form id="st1" modelAttribute="chair" method="post" action="updateChair" enctype="multipart/form-data">
  <table class="table table-bordered">
    <form:hidden style="visibility:hidden" path="chairId" value="${chair.chairId}" />
    
      <tr><td><form:label path="chairName">Chair Name :</form:label></td>
               <td><form:input path="chairName" value="${chair.chairName}"/></td>
           </tr>
               <tr><td><form:label path="chairPrice">Chair Price :</form:label></td>
               <td><form:input path="chairPrice" value="${chair.chairPrice}"/></td>
           </tr>
           <tr><td><form:label path="chairDesc">Discription :</form:label></td>
               <td><form:input path="chairDesc" value="${chair.chairDesc}"/></td>
           </tr>
           
           <tr><td><form:label path="chairStyle">Style :</form:label></td>
               <td><form:input path="chairStyle" value="${chair.chairStyle}"/></td>
           </tr>
               <tr><td><form:label path="warranty">Warranty :</form:label></td>
               <td><form:input path="warranty" value="${chair.warranty}"/></td>
           </tr>
           <tr><td><form:label path="primaryMeterial">Primary Meterial :</form:label></td>
               <td><form:input path="primaryMeterial" value="${chair.primaryMeterial}"/></td>
           </tr>
           </tr>
               <tr><td><form:label path="capacity">Capacity :</form:label></td>
               <td><form:input path="capacity" value="${chair.capacity}"/></td>
           </tr>           
           <tr><td><form:label path="img">Chair Image :</form:label></td>
               <td><form:input path="img" type="file" />
               <font color="red"><form:errors path="img"></form:errors></font></td><tr>
           
           
               <tr><td></td>
               <td><input type="submit" value="submit"/></td>
           </tr>
           </table>
           
                      
  </form:form>   
  <%@include file="/WEB-INF/view/footer.jsp" %>
</body>
</html>
