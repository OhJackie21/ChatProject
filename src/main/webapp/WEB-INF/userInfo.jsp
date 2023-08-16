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
        <h4>Welcome ${userInfo.username}</h4>
        <p>
        <a href="/user/logout">Logout</a> | 
        <a href="/chat">Chat</a></p>
	</div>
	

         
            <div class="card-body p-5" id="mainreg2">
              <h2 class="text-uppercase text-center mb-5">Edit Account</h2>

              <form:form action="/user/info/${userInfo.id}" method="POST" modelAttribute="userInfo" class="form-floating">

                <div class="form-floating mb-4">
                  <form:input type="text" path="username" id="form3Example1cg" class="form-control form-control-lg" />
                  <form:label  path="username" class="form-label" for="form3Example1cg">User Name</form:label>
                  <form:errors path="username" class="text-danger" /><br />
                </div>

                <div class="form-floating mb-4">
                  <form:input type="email" path="email" id="form3Example3cg" class="form-control form-control-lg" />
                  <form:label class="form-label" path="email" for="form3Example3cg">Email</form:label>
                  <form:errors path="email" class="text-danger" /><br />
                </div>

				<form:input type="hidden" path="id" value="${userInfo.id}"/>
                <div class="d-flex justify-content-center">
                  <button type="submit"
                    class="btn btn-success btn-block btn-lg gradient-custom-4 text-body">Update</button>
                </div>

              </form:form>
				
            </div>
       
  

</body>
</html>