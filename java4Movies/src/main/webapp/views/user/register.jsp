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
	<%@include file="/common/header.jsp" %>
	<section id="main-slider">
    	<form method="post" class="col-md-6" id="form1">
    	<mark> ${message}</mark>
        <div class="card">
            <div class="card-header">
                <span>Registration</span>
            </div>
            <div class="card-body">
                <div class="row">
                    <div class="mb-3">
                        <label class="form-label">UserName</label>
                        <input type="text" class="form-control" id="username" name="userId" value="${user.userId}">
                      </div>
                      <div class="mb-3">
                        <label for="exampleInputPassword1" class="form-label">Password</label>
                        <input type="password" class="form-control" id="exampleInputPassword1" name="passwords" value="${user.password}">
                      </div>
                      <div class="mb-3">
                        <label for="exampleInputPassword1" class="form-label">FullName</label>
                        <input type="text" class="form-control" id="exampleInputPassword1" name="fullName" value="${user.fullName}">
                      </div>
            
                        <div class="mb-3">
                            <label for="exampleInputEmail1" class="form-label">Email address</label>
                            <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="email" value="${user.email}">
                            <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
                        </div>
                </div>
                <button type="submit" class="btn btn-primary" formaction="/java4Movies/registerAccount/register">Submit</button>
                <button type="submit" class="btn btn-success" formaction="/java4Movies/registerAccount/upload">Update</button>
            </div>
        </div>
      </form>
  	</section>
	<%@include file="/common/footer.jsp" %>
</body>
</html>