<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login - Movie</title>
<%@include file="/common/head2.jsp" %>
</head>
<body>
	<c:url var="url" value="/java"/>
	<%@include file="/common/header.jsp" %>
	<section id="main-slider">
    <form method="post" class="col-md-4" id="form">
    	<div class="row">
			<div class="col">
				<c:if test="${not empty message }">
					<div class="alert alert-success"> ${message }</div>
				</c:if>
				<c:if test="${not empty error }">
					<div class="alert alert-danger"> ${error }</div>
				</c:if>
			</div>
		</div>
        <h1>LOGIN</h1>
        <div class="mb-3">
          <label for="exampleInputEmail1" class="form-label">User Name</label>
          <input type="text" class="form-control" name="userid" value="${userid}">
          <div id="emailHelp" class="form-text">Please Enter UserName!!</div>
        </div>
        <div class="mb-3">
          <label for="exampleInputPassword1" class="form-label">Password</label>
          <input type="password" class="form-control" name="password" value="${password}">
          <div id="emailPassword" class="form-text">Please Enter Password!!</div>
        </div>
        <div class="mb-3 form-check">
          <input type="checkbox" class="form-check-input" id="exampleCheck1" name="remember">
          <label class="form-check-label" for="exampleCheck1">Remember me</label>
        </div>
        <button type="submit" class="btn btn-primary" formaction="/java4Movies/LoginServlet" name="btnLogin">Log in</button> <br>
       
        
        <a href="/java4Movies/forgotPassword" >Forgot Password? </a>
        <a href="/java4Movies/registerAccount/register" >Register an account? </a>
      </form>
  </section>
	<%@include file="/common/footer.jsp" %>
</body>
</html>