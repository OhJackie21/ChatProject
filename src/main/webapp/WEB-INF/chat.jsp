<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %> 
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %> 
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Kavoon&display=swap" rel="stylesheet">
	<title>Friend Chat</title>
</head>
<body>
	<h1 class="h1text">Chat with Friends</h1>
    <div class="info">
        <h4>Welcome ${user.username}</h4>
        <p>
        <a href="/user/logout">Logout</a> | 
        <a href="/user/info/${user.id}">update</a></p>
	</div>
	<div class="mainfield">
        <div class="left">
           <p class="commChat"> Chat</p>
        </div>
        <div class="right">
            <div class="messageList">
			  <c:forEach var="message" items="${message}">
			  	<p> < <c:out value="${message.user.username}" /> > <c:out value="${message.message}" /> </p>
			  </c:forEach>
			  
            </div>
            <div class="form">
				<form:form action="/chat/send" method="POST" modelAttribute="messages">
					
					<form:input path="message" type="text" id="typeMessage" class="form-control" placeholder="type here" />
               		<form:input type="hidden" path="user" value="${user.id}"/>
               		<button type="submit" id="sndBtn" class="btn btn-primary" >Send</button>
					<form:errors path="message" class="text-danger" /><br />
				</form:form>
            </div>
     	</div>
     </div>
</body>
</html>