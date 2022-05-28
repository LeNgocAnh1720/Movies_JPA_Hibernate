<%@page pageEncoding="utf-8" %>
<!doctype html>
<html lang="en">
  <head>
    <title>Title</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    <style>
      #id{
        position: relative;
      }
      #videoList{
        position: relative;
      }
      .card{
        position: absolute;
        width: 1500px;
        top: 60px;
        margin-top: 60px;
        left: 10px;
      }
      #label{
        font-weight: bold;
      }
      .i{
        color: red;
      }
      #icon{
        font-size: 25px;
        color: green;
      }
      #icon1{
        font-size: 25px;
        color: red;
      }
      #table{
      	width:1300px;
      	margin-left: 100px;
      }
    </style>
  </head>
  <body>
  		<c:url var="url" value="/java"/>
      <main class="container-fluid">
          <nav class="row">
            <nav class="navbar navbar-expand-sm navbar-light bg-light col">
                <a class="navbar-brand" href="#">Administration</a>
                <button class="navbar-toggler d-lg-none" type="button" data-toggle="collapse" data-target="#collapsibleNavId" aria-controls="collapsibleNavId"
                    aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="collapsibleNavId">
                    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                        <li class="nav-item active">
                            <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value=""/>"><i class="fa fa-info" aria-hidden="true"></i> Videos</a>
                        </li>
                        <li class="nav-item">
                            <a href="<c:url value="/ManageAdminVideo/findAllUser"/>" class="nav-link"><i class="fa fa-id-card" aria-hidden="true"></i> Users</a>
                        </li>
            
                        <li class="nav-item">
                            <a href="#" class="nav-link"><i class="fa fa-comments" aria-hidden="true"></i> Report</a>
                        </li>
                    </ul>
                </div>
            </nav>
          </nav>
          <section class="row">
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
            	<form action="" method="post" id="form">
                      <div class="card">
                        <div class="card-body">
                          <div class="row">
                            <div class="col-3">
                              <div class="border p-3">
                                <label for="" class="form-label" id="label">Poster(750*550) <i class="i">*</i></label>
                                <input type="file" class="img-fluid" name="poster" value="/templates/Images/${form.poster}">
                              </div>
                              <br>
                              <div class="border p-3">
                                <label for="" class="form-label" id="label">Banner(1370*980) <i class="i">*</i></label>
                                <input type="file" class="img-fluid" name="panner" value="/templates/Images/${form.panner}">
                              </div>
                            </div>

                            <div class="col-9">
                              <div class="form-group">
                                <label for="VideoId" id="label">Video Id <i class="i">*</i></label>
                                <input type="text" class="form-control" name="videoId" id="" aria-describedby="helpId" placeholder="" value="${form.videoId}">
                              </div>
                              <div class="form-group">
                                <label for="VideoTitle" id="label">Video Title <i class="i">*</i></label>
                                <input type="text" class="form-control" name="title" id="" aria-describedby="helpId" placeholder="" value="${form.title}">
                              </div>
                              <div class="row">
                                <div class="col-5">
                                  <label for="VideoTitle" id="label">Href <i class="i">*</i></label>
                                  <input type="text" class="form-control" name="href" id="" aria-describedby="helpId" placeholder="" value="${form.href}">
                                </div>
                                <div class="col-5">
                                  <label for="VideoTitle" id="label">VideoTrailler <i class="i">*</i></label>
                                  <input type="text" class="form-control" name="videoTrailler" id="" aria-describedby="helpId" placeholder="" value="${form.videoTrailler}">
                                </div>
                              </div>
                              <div class="row">
                                <div class="col-3">
                                  <label for="VideoTitle" id="label">Time <i class="i">*</i></label>
                                  <input type="text" class="form-control" name="time" id="" aria-describedby="helpId" placeholder="Vd: 120min" value="${form.time}">
                                </div>
                                <div class="col-5">
                                  <label for="VideoTitle" id="label">Date <i class="i">*</i></label>
                                  <input value="${form.date}" type="date" class="form-control" name="date" id="" aria-describedby="helpId" placeholder="" >
                                </div>
                                <div class="col-3">
                                  <label for="VideoTitle" id="label">Views <i class="i">*</i></label>
                                  <input type="text" class="form-control" name="views" id="" aria-describedby="helpId" placeholder="0" value="0" value="${form.views}">
                                </div>
                                
                              </div>
                            </div>
                          </div>
                          <div class="row">
                            <div class="col"> 
                              <label for="description" id="label">Description <i class="i">*</i></label> <br>
                              <textarea name="description" name="description" id="description" cols="190" rows="7" value="${form.description}"></textarea>
                            </div>
                          </div>
                          <div class="row">
                            <span><i class="i">*</i> Các trường bắt buộc nhập</span>
                          </div>
                        </div>
                        <div class="card-footer text-muted">
                          <button class="btn btn-primary" formaction="/java4Movies/ManageAdminVideo/insertVideo">Create</button>
                          <button class="btn btn-danger" formaction="/java4Movies/ManageAdminVideo/deleteVideo">Delete</button>
                          <button class="btn btn-success" formaction="/java4Movies/ManageAdminVideo/updateVideo">Update</button>
                          <button class="btn btn-warning" formaction="/java4Movies/ManageAdminVideo">Reset</button>
                        </div>
                        <br>
                        <br>
                        <table class="table table-bordered" id="table">
	                    <thead>
	                     <tr>
	                       <th scope="col">#ID</th>
	                       <th scope="col">Title</th>
	                       <th scope="col">Href</th>
	                       <th scope="col">Poster</th>
	                       <th scope="col">Banner</th>
	                       <th scope="col">Date</th>
	                       <th scope="col">Views</th>
	                       <th scope="col">VideoTrailler</th>
	                       <th scope="col"></th>
	                     </tr>
	                   </thead>
	                    <tbody>
	                    <c:forEach items="${videos}" var="item">
	                        <tr>
	                          <td>${item.videoId}</td>
	                          <td>${item.title}</td>
	                          <td>${item.href}</td>
	                          <td>${item.poster}</td>
	                          <td>${item.panner}</td>
	                          <td>${item.date}</td>
	                          <td>${item.views}</td>
	                          <td>${item.videoTrailler}</td>
	                          <td><a href="/java4Movies/ManageAdminVideo/editVideo?${item.videoId}" > <i class="fa fa-check" id="icon"></i></a>
	                          <a href="/java4Movies/ManageAdminVideo/deleteVideo?${item.videoId}"><i class="fa fa-times" id="icon1"></i></a></td>
	                        </tr> 
	                     </c:forEach>
	                    </tbody>
                  </table>
                      </div>
                     
                    </form>
         
          </section>
          <footer class="row">

          </footer>
      </main>
   
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
      
      <script>
          $('#myTab1 a').on('click', function (event) {
            event.preventDefault()
            $(this).tab('show')
            })
      </script>
</body>
</html>
