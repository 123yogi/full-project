<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>All Products</h1>

           
        </div>

        <table class="table table-striped table-hover">
            <thead>
            <tr class="bg-success">
                <th>Photo Thumb</th>
                <th>Product Name</th>
                <th>Product Style</th>
                <th>Warranty</th>
                <th>Price</th>
                <th></th>
            </tr>
            </thead>
            <c:forEach items="${chairs}" var="chair">
                <tr>                   
                 <td><img src='<c:url value="/resources/images/${chair.image}" /> ' alt="image"
                             style="width:30%"/></td>    
                               
                    <td>${chair.chairName}</td>
                    <td>${chair.chairStyle}</td>
                    <td>${chair.warranty}</td>
                    <td>${chair.chairPrice}</td>
                    
                    
                </tr>
            </c:forEach>
        </table>


</div></div></body>