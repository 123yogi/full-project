<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        
 <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
   <style type="text/css">
.errStyle {
	color:red;
	font-style: italic;
	font-weight: bold;
}
</style>
</head>
<body>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
    </div>
    <ul class="nav navbar-nav">
        
     </ul>
  </div>
      
</nav>
<div class="container">

<c:url var="addUser" value="addUser"></c:url>
   <form:form commandName="user" method="post" action="storeUser">
   <form:errors path="*" cssClass="errStyle" element="div" />
<div class="form-group">
 	<form:label  path="name">
				<spring:message text="User Name"/>
	</form:label>
	<form:input class="form-control" path="name" />
		<form:errors path="name">
					
</p>
 </form:errors>
 </div>
  <div class="form-group">
 	<form:label  path="mail">
				<spring:message text="Email ID"/>
	</form:label>
	<form:input class="form-control" path="mail" />
		<form:errors path="mail" >
			<p class="errStyle">
					* Invalid email
</p>
 
 </form:errors>
 
  </div>
  <div class="form-group">
 	<form:label  path="phone">
				<spring:message text="Phone Number"/>
	</form:label>
	<form:input class="form-control" path="phone" />
		<form:errors path="phone" >
			<p class="errStyle">
					* Invalid Phone
</p>
 </form:errors>
 </div>
  
  <div class="form-group">
 	<form:label  path="password">
				<spring:message text="Password"/>
	</form:label>
	<form:input class="form-control" type="password" path="password" />
			<form:errors path="password">
			<p class="errStyle"> * Invalid password
</p>
 </form:errors>
 </div> 
 
 <div class="form-group">
 	<form:label  path="password">
				<spring:message text="Confirm Password"/>
	</form:label>
	<form:input class="form-control" type="password" path="confirmpassword" />
		<form:errors path="confirmpassword" >
			<p class="errStyle"> * Invalid Confirm Password
</p>
 </form:errors>
 </div> 
 
 <div class="form-group">
 	<form:label  path="apartmentNumber">
				<spring:message text="ApartmentNumber"/>
	</form:label>
	<form:input class="form-control" path="apartmentNumber" />
		<form:errors path="apartmentNumber" >
			<p class="errStyle">
					* Invalid ApartmentNumber.
</p>
 </form:errors>
 </div>
 
 <div class="form-group">
 	<form:label  path="streetName">
				<spring:message text="StreetName"/>
	</form:label>
	<form:input class="form-control" path="streetName" />
		<form:errors path="streetName" >
			<p class="errStyle">
					* Invalid StreetName.
</p>
 </form:errors>
 </div>
 
 
 <div class="form-group">
 	<form:label  path="city">
				<spring:message text="City"/>
	</form:label>
	<form:input class="form-control" path="city" />
		<form:errors path="city" >
			<p class="errStyle">
					* Invalid City.
</p>
 </form:errors>
 </div>
 
 <div class="form-group">
 	<form:label  path="state">
				<spring:message text="State"/>
	</form:label>
	<form:input class="form-control" path="state" />
		<form:errors path="state" >
			<p class="errStyle">
					* Invalid State.
</p>
 </form:errors>
 </div>
 
 
 
 <div class="form-group">
 	<form:label  path="country">
				<spring:message text="Country"/>
	</form:label>
	<form:input class="form-control" path="country" />
		<form:errors path="country" >
			<p class="errStyle">
					* Invalid Country.
</p>
 </form:errors>
 </div>
 
 
 <div class="form-group">
 	<form:label  path="zipCode">
				<spring:message text="ZipCode"/>
	</form:label>
	<form:input class="form-control" path="zipCode" />
		<form:errors path="zipCode" >
			<p class="errStyle">
					* Invalid ZipCode.
</p>
 </form:errors>
 </div>
 
 
 
  <button type="submit" class="btn btn-default">Submit</button>
</form:form>
</div>

</body>
</html>