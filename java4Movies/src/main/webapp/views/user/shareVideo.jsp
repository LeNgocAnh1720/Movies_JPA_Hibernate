<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login - Movie</title>
<%@include file="/common/head2.jsp" %>
<style type="text/css">
	.img-responsive{
		width:300px;
	}
</style>
</head>
<body>
	<%@include file="/common/header.jsp" %>
	<div class="container">
					<mark> ${message}</mark> <br>
                    <div class="modal-dialog modal-lg" role="document">
                        <div class="modal-content">
                            <div class="modal-body">
                                <div class="row">
                                    <div class="col-md-5 col-lg-5 block-image">
                                        <img src="<c:url value="/templates/Images/${video.poster }"/>" alt="" class="img-responsive">
                                    </div>
                                    <div class="col-md-6 col-lg-6 block-contact">
                                        <h3>Share Video</h3>
                                        <form action="" method="post">
                                            <div class="form-group">
                                                <label for="" class="form-label">User Send</label>
                                                <input type="text" class="form-control" placeholder="Users" value="${user.userId}" name="userId">
                                            </div>
                                            <br>
                                            <div class="form-group">
                                                <label for="" class="form-label">Video Id</label>
                                                <input type="text" class="form-control" placeholder="VideoId" value="${video.videoId}" name="videoId">
                                            </div>
                                             <br>
                                            <div class="form-group">
                                                <label for="" class="form-label">Link Video</label>
                                                <input type="text" class="form-control" value="${video.videoTrailler}" name="videoTrailler">
                                            </div>
                                             <br>
                                            <div class="form-group">
                                                <label for="" class="form-label">Subject</label>
                                                <input type="text" class="form-control" placeholder="Enter to Subject"  name="toSubject">
                                            </div>
                                             <br>
                                            <div class="form-group">
                                                <label for="" class="form-label">Send from Email</label>
                                                <input type="text" class="form-control" placeholder="Enter from Email" name="fromEmail">
                                            </div>
                                            <br>
                                            <div class="form-group">
                                                <button type="submit" class="btn btn-success" formaction="/java4Movies/ShareVideo/Share">SHARE</button>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    
                </div>            
	</div>
	<%@include file="/common/footer.jsp" %>
</body>
</html>