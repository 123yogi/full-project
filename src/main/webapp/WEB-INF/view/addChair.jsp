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
<h2>Add a Chair</h2>
    <div class="container" ng-app="imgApp" ng-controller="imgCtrl">
    <c:url var="addChair" value="addChair"></c:url>
   <form:form commandName="chair" method="post" action="storeChair" enctype="multipart/form-data">
       <table class="table table-bordered" >
           
           <tr><td><form:label path="chairName">Chair Name :</form:label></td>
               <td><form:input path="chairName"/>
               <font color="red"><form:errors path="chairName"></form:errors></font></td>
           </tr>
           <tr><td><form:label path="chairPrice">Chair Price :</form:label></td>
               <td><form:input path="chairPrice"/>
               <font color="red"><form:errors path="chairPrice"></form:errors></font></td>
           </tr>
           <tr><td><form:label path="chairDesc">Description :</form:label></td>
               <td><form:input path="chairDesc"/>
               <font color="red"><form:errors path="chairDesc"></form:errors></font></td>
           </tr>           
           <tr><td><form:label path="chairStyle">Style :</form:label></td>
               <td><form:input path="chairStyle"/>
               <font color="red"><form:errors path="chairStyle"></form:errors></font></td>
               
               
                              
               
               
           </tr>
           <tr><td><form:label path="warranty">Warranty :</form:label></td>
               <td><form:input path="warranty"/>
               <font color="red"><form:errors path="warranty"></form:errors></font></td>
           </tr>
           <tr><td><form:label path="primaryMeterial">Primary Meterial :</form:label></td>
               <td><form:input path="primaryMeterial"/>
               <font color="red"><form:errors path="primaryMeterial"></form:errors></font></td>
           </tr>
           
           <tr><td><form:label path="capacity">Capacity :</form:label></td>
               <td><form:input path="capacity"/>
               <font color="red"><form:errors path="capacity"></form:errors></font></td>
           </tr>          
           <tr><td><form:label path="img">Chair Image :</form:label></td>
               <td><form:input path="img" type="file"/>
               <font color="red"><form:errors path="img"></form:errors></font></td>
               
           </tr>
           <tr><td><form:label path="supplier">Supplier Name:</form:label></td>
               <td><select name="Supplier.id">
   				 <option value="">---Select---</option>
   				 <c:forEach var="Supplier" items="${suppliers}">
   				 <option value="${Supplier.id}">${Supplier.supname}</option>
    		</c:forEach>
    		</select></td></tr>
    		<tr><td><form:label path="category">Category Name:</form:label></td>
               <td><select name="Category.id">
   				 <option value="">---Select---</option>
   				 <c:forEach var="Category" items="${categories}">
   				 <option value="${Category.id}">${Category.name}</option>
    		</c:forEach>
    		</select></td></tr>
           <tr><td></td>
               <td><input type="submit" value="submit" class="btn"/></td>
           </tr>
           
       </table>
   </form:form> 
   <%@include file="/WEB-INF/view/footer.jsp" %>
</body>
</html>