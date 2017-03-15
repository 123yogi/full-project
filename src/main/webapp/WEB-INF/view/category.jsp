<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<title>Category Page</title>
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
				<a class="navbar-brand" href="landPage">Admin Home</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="retriveRecords">Manage Products</a></li>
				<li><a href="manageSupplier">Manage Suppliers</a></li>
			</ul>
			<ul>
      		<li class="nav navbar-nav navbar-right"><a href="<c:url value='/j_spring_security_Logout'/>">
      		<span class="glyphicon glyphicon-log-in"></span>
						Logout</a></li></ul></div>
  
		</div>
	</nav>


${msg}
	<h1>Add a Category</h1>
	<c:url var="addAction" value="/manage_category_add"></c:url>
	<form:form action="${addAction}" commandName="category"  method="post">
		<table>
			<tr>
				<td><form:label path="id"> <spring:message text="ID" />	</form:label></td>
				<c:choose>
					<c:when test="${!empty category.id}">
						<td><form:input path="id" readonly="true" /></td>
					</c:when>
					<c:otherwise>
						<td><form:input path="id" pattern=".{5,20}" required="true"
								title="id should contains 5 to 20 characters" /></td>
					</c:otherwise>
				</c:choose>
			<tr>
				<td><form:label path="name">	<spring:message text="Name" /> </form:label></td>
				<td><form:input path="name" required="true" /></td>
			</tr>
			<tr>
				<td><form:label path="description"> <spring:message text="Description"/></form:label></td>
				<td><form:input path="description" required="true" /></td>
			</tr>
			
				
			<tr>
				<td colspan="2"><input type="submit" value="<spring:message text="Edit Category"/>" />
					<input type="submit" value="<spring:message text="Insert Category"/>" />
					<a href="${pageContext.servletContext.contextPath}/category" ><class="btn btn-primary"><span>Add Category</span></a>
					</td>
			</tr>
		</table>
	</form:form>
	<br>
	<h3>Category List</h3>
	<c:if test="${!empty categoryList}">
		<table class="tg">
			<tr>
				<th width="80">Category ID</th>
				<th width="120">Category Name</th>
				<th width="120">Category Description</th>
				<th width="60">Edit</th>
				<th width="60">Delete</th>
			</tr>
			<c:forEach items="${categoryList}" var="category">
				<tr>
					<td>${category.id}</td>
					<td>${category.name}</td>
					<td>${category.description}</td>
					<td><a href="<c:url value='/manage_category_edit/${category.id}' />">Edit</a></td>
					
					<td><a href="<c:url value='/manage_category_remove/${category.id}' />">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>






