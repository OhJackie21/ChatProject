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
<h1 class="h1text2">Chat with Friends</h1>
       
                <div class="card-body p-5 text-center" id="logmain">
      
                  <div class="mb-md-5 mt-md-4 pb-5">
      
                    <h2 class="fw-bold mb-2 text-uppercase">Login</h2>
                    <p class="text-white-50 mb-5">Please enter your login and password!</p>
                    
      					<form:form action="/user/login" method="POST" modelAttribute="newLogin">
		                    <div class="form-floating form-white mb-4">
		                      <form:input type="email" path="email" id="email" class="form-control form-control-lg" />
		                      <form:label path="email" class="form-label" for="email">Email</form:label>
		                      <form:errors path="email" class="text-danger" /><br />
		                      <form:errors path="password" class="text-danger" /><br />
		                    </div>
		      
		                    <div class="form-floating form-white mb-4">
		                      <form:input path="password" type="password" id="password" class="form-control form-control-lg" />
		                      <form:label path="password" class="form-label" for="password">Password</form:label>
		                    </div>
		      
		                    <button class="btn btn-outline-light btn-lg px-5" type="submit" id="logsubmit">Login</button>
      					</form:form>
      					
      					
                    <div class="d-flex justify-content-center text-center mt-4 pt-1">
              		
                    </div>
      					
                  </div>
      
                  <div>
                    <p class="mb-0">Don't have an account? <a href="/user/signup" class="text-white-50 fw-bold">Sign Up</a>
                    </p>
                  </div>
      
                </div>


</body>
</html>