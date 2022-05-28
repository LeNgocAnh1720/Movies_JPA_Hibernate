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
    	<mark>${message}</mark>
        <div class="card">
            <div class="card-header">
                <span>Forgot Password</span>
            </div>
            <div class="card-body">
                <div class="row">
                    <div class="mb-3">
                        <label class="form-label">UserName</label>
                        <input type="text" class="form-control" id="userId" name="userId">
                      </div>

                        <div class="mb-3">
                            <label for="exampleInputEmail1" class="form-label">Email address</label>
                            <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="emails">
                            <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
                        </div>
                </div>
                <button type="submit" class="btn btn-primary" formaction="/java4Movies/forgotPassword">Submit</button>
            </div>
        </div>
      </form>
  	</section>
	<%@include file="/common/footer.jsp" %>
</body>
</html>