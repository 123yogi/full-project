<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
 </head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
      <ul class="nav navbar-nav">
      <li class="active"><a href="h1">Home</a></li>
      <li><a href="allpro">View All</a></li>
      </ul>
    <ul class="nav navbar-nav navbar-right">
         <sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_USER')"><li><a href="${pageContext.request.contextPath}/logout"><span>Logout</span></a></li>
    </sec:authorize>
    </ul>
  </div>
</nav>
</body>
  