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

         <div class="card" style="border-radius: 15px;">
            <div class="card-body p-5" id="mainreg">
              <h2 class="text-uppercase text-center mb-5">Create an account</h2>

              <form:form action="/user/register" method="POST" modelAttribute="newUser" class="form-floating">

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

                <div class="form-floating mb-4">
                  <form:input type="password" path="password" id="form3Example4cg" class="form-control form-control-lg" />
                  <form:label class="form-label" path="password" for="form3Example4cg">Password</form:label>
                  <form:errors path="password" class="text-danger" /><br />
                </div>

                <div class="form-floating mb-4">
                  <form:input type="password" id="form3Example4cdg" path="confirmpass" class="form-control form-control-lg" />
                  <form:label class="form-label" path="confirmpass"  for="form3Example4cdg">Confirm Password</form:label>
                  <form:errors path="confirmpass" class="text-danger" /><br />
                </div>


                <div class="d-flex justify-content-center">
                  <button type="submit"
                    class="btn btn-success btn-block btn-lg gradient-custom-4 text-body">Register</button>
                </div>

                <p class="text-center text-muted mt-5 mb-0"><span style="color: white;">Have already an account?</span> <a href="/"
                    class="fw-bold text-body"><u>Login here</u></a></p>
                    
				
              </form:form>
				
            </div>
          </div>
        
</body>
</html>