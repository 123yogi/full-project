<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">

<html>
<head>
  <link rel="stylesheet" href='<x:url value="/resources/css/bootstrap.min.css"></x:url>' />
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="Admin">Admin Home</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="retriveRecords">Manage Products</a></li>
				<li><a href="manageSupplier">Manage Suppliers</a></li>
				<li><a href="category">Manage Categories</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				  <li><a href="${pageContext.request.contextPath}/logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
			</ul>
		</div>
	</nav>
 <h3>Welcome... <%=session.getAttribute("loggedInUser")%></h3>
    <div class="container">
        
<div ng-app="myApp" ng-controller="customersCtrl">
<input type="text" class="form-control" placeholder="Search" ng-model="searchBy.name"/><br/>
 <table class="table table-striped table-hover">
            <thead>
            <tr bgcolor="#A52A2A">
                  <th>Id</th>
                  <th>UserName</th>
                  <th>Mail</th>
                  <th>Mobile No</th>
                  <th>StreetName</th>
                  <th>City</th>                 
      
  </tr>
  </thead>
    <tr ng-repeat="x in names | filter:searchBy">
    
    <td>{{x.id}}</td>
    <td>{{x.name}}</td>
    <td>{{x.mail}}</td>
    <td>{{x.phone}}</td>
    <td>{{x.streetName}}</td>
    <td>{{x.city}}</td>
    <td>
    
    
    <a href="${pageContext.servletContext.contextPath}/editChair?id={{x.chairId}}"><span class="glyphicon glyphicon-pencil"></span></a>
    <a href="${pageContext.servletContext.contextPath}/deleteUser?id={{x.id}}"><span class="glyphicon glyphicon-remove"></span></a>
   
   </td>
     </tr>
</table>
</div>

<script>
var app = angular.module('myApp', []);
app.controller('customersCtrl', function($scope, $http) {
    $http.get("listUser")
    .then(function (response) {$scope.names = response.data;});
});
</script>
</div>
</body>
</html>



