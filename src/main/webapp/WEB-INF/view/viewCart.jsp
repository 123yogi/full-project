<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
					
				<a class="navbar-brand" href="landPage">Home</a>
			</div>
			<sec:authorize access="hasRole('ROLE_ADMIN')">
			<ul class="nav navbar-nav">
				<li><a href="manageSupplier">Manage Suppliers</a></li>
				<li><a href="category">Manage Categories</a></li>
			</ul></sec:authorize>
			<div><ul>
      		<li class="nav navbar-nav navbar-right"><a href="<c:url value='/j_spring_security_Logout'/>">
      		<span class="glyphicon glyphicon-log-in"></span>
						Logout</a></li></ul></div>
  </div>
	</nav>
 <h3>Welcome... <%=session.getAttribute("loggedInUser")%></h3><br><br><br>
        <h1>Cart Items</h1>
<div ng-app="myApp" ng-controller="customersCtrl">
 
 
 <input type="text" class="form-control" placeholder="Search" ng-model="searchBy.chairName"/><br/>
 <a href="<spring:url value="/checkout"/>" class="btn btn-success pull-right"><span class="glyphicon glyphicon-shopping-cart"></span> Check out</a>

                     
              
<table class="table table-hover table-bordered">
  <tr>
       <th>Product Name</th>
       <th>QTY</th>
       <th>Price</th>
       
            
  </tr>
  <tr ng-repeat="x in names | filter:searchBy">
    <td>{{x.chairName}}</td>
    <td>{{x.quantity}}</td>
    <td>{{x.chairPrice | currency}}</td>
    
  <td> <a href="deleteItemCart?id={{x.cartItemId}}" class="label label-danger" ng-click="removeFromCart(item.product.productId)"><span class="glyphicon glyphicon-remove"></span>remove</a></th>
    </tr>
    <tr>
                        <th></th>
                        <th></th>
                        <th>Grand Total : {{calGrandTotal() | currency}}</th>
                        
                    </tr>
</table>
 <a href="${pageContext.servletContext.contextPath}/retriveRecords" class="btn btn-success pull-right">Continue Shopping</a>
 <a href="${pageContext.servletContext.contextPath}/removeAll"class="btn btn-danger pull-left" ng-click = "clearCart()"><span class="glyphicon glyphicon-remove-sign"></span> Clear Cart</a>
</div>

<script>
var app = angular.module('myApp', []);
app.controller('customersCtrl', function($scope, $http) {
    $http.get("listItems")
    .then(function (response) {$scope.names = response.data;});


$scope.calGrandTotal = function(){
    var grandTotal=0;
    

    for(var i=0; i<$scope.names.length; i++)
    {
        grandTotal+=$scope.names[i].chairPrice;
    }

    return grandTotal;
};
});

</script>
</div>
<%@include file="/WEB-INF/view/footer.jsp" %>
</body>
</html>



