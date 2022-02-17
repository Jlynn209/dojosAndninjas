<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <title>Tacos</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div>
		<h1>New Ninja</h1>
			<form:form action="/ninja/new" method="post" modelAttribute="ninja">
				<div>
			        <form:select path="dojo">
			        	<c:forEach var="dojo" items="${allDojos}">
			        		<form:option value="${dojo.id}">
			        			<c:out value ="${dojo.name}"/>
			        		</form:option>
			        	</c:forEach>
			        </form:select>
			    </div>
			    <div>
			        <form:label path="firstName">First Name:</form:label>
			        <form:errors path="firstName"/>
			        <form:input path="firstName"/>
			    </div>
			    <div>
			        <form:label path="lastName">Last Name:</form:label>
			        <form:errors path="lastName"/>
			        <form:input path="lastName"/>
			    </div>
			    <div>
			        <form:label path="age">Age:</form:label>
			        <form:errors path="age"/>
			        <form:input type="age" path="age"/>
			    </div>
			    <input type="submit" value="Submit"/>
			</form:form>
	</div>
</body>
</html>