<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">

<head>
  <title>Title</title>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
  <style>
    #id {
      position: relative;
    }

    #videoList {
      position: relative;
    }

    .card {
      position: absolute;
      width: 1500px;
      top: 60px;
      margin-top: 60px;
      left: 10px;
    }

    #label {
      font-weight: bold;
      font-size: 19px;
    }

    #icon {
      font-size: 25px;
      color: green;
    }

    #icon1 {
      font-size: 25px;
      color: red;
    }

    .row1 {
      width: 800px;
      margin-left: 300px;
      margin-top: 30px;
    }

    #table {
      margin-top: 30px;
    }
    
    #button{
    	margin-top: 30px;
    	margin-bottom: 30px;
    }
  </style>
</head>

<body>
	<c:url var="url" value="/java"/>
  <main class="container-fluid">
    <nav class="row">
      <nav class="navbar navbar-expand-sm navbar-light bg-light col">
        <a class="navbar-brand" href="#">Administration</a>
        <button class="navbar-toggler d-lg-none" type="button" data-toggle="collapse" data-target="#collapsibleNavId"
          aria-controls="collapsibleNavId" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="collapsibleNavId">
          <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
            <li class="nav-item active">
              <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href='<c:url value="/views/admin/manageVideo.jsp"/>'><i class="fa fa-info" aria-hidden="true"></i> Videos</a>
            </li>
            <li class="nav-item">
              <a href="<c:url value=""/>" class="nav-link"><i class="fa fa-id-card" aria-hidden="true"></i> Users</a>
            </li>

            <li class="nav-item">
              <a href="#" class="nav-link"><i class="fa fa-comments" aria-hidden="true"></i> Report</a>
            </li>
          </ul>
        </div>
      </nav>
    </nav>
    <section class="row1">
      <form class="row g-3">
        <div class="col-md-6">
          <label for="inputEmail4" class="form-label" id="label">User ID</label>
          <input type="text" class="form-control" id="userId" name="userId" value="${formUser.userId }">
        </div>
        <div class="col-md-6">
          <label for="inputPassword4" class="form-label" id="label">Password</label>
          <input type="password" class="form-control" id="inputPassword4" name="password" value="${formUser.password }">
        </div>
        <div class="col-12">
          <label for="inputAddress" class="form-label" id="label">Email</label>
          <input type="text" class="form-control" id="Email" placeholder="abc@gmail.com" name="email" value="${formUser.email }">
        </div>
        <div class="col-12">
          <label for="inputAddress2" class="form-label" id="label">Full Name</label>
          <input type="text" class="form-control" id="FullName" name="fullName" value="${formUser.fullName }">
        </div>
        <div class="col-md-6">
          <label for="" class="form-label" id="label">isAdmin</label> <br>
          <div class="form-check form-check-inline">
             <label class="ml-2"><input
						${admin?'checked':''} type="radio" name="isAdmin" required
						value="true" class="form-check-input">Admin</label>
						<br> 
			<label class="ml-2"><input ${!admin?'checked':''}
						type="radio" name="isAdmin" required value="false"
						class="form-check-input">User</label>
						
          </div>
        </div> <br> <br>

        <div class="col-12" id="button">
          <button class="btn btn-primary" formaction="/java4Movies/ManageAdminUser/insertUser">Create</button>
          <button class="btn btn-danger" formaction="/java4Movies/ManageAdminUser/deleteUser">Delete</button>
          <button class="btn btn-success" formaction="/java4Movies/ManageAdminUser/updateUser">Update</button>
          <button class="btn btn-warning" formaction="/java4Movies/ManageAdminUser">Reset</button>
        </div>
        <table class="table table-bordered" id="table">
          <thead>
            <tr>
              <th scope="col">#UserID</th>
              <th scope="col">Password</th>
              <th scope="col">Email</th>
              <th scope="col">FullName</th>
              <th scope="col">isAdmin</th>
              <th scope="col"></th>
            </tr>
          </thead>
          <tbody>
			<c:forEach items="${listuser}" var="item">
            <tr>
              <td>${item.userId}</td>
              <td>${item.password}</td>
              <td>${item.email}</td>
              <td>${item.fullName}</td>
              <td>${item.admin?'Admin':'User'}</td>
              <td><a href="/java4Movies/ManageAdminUser/editUser?${item.userId }"> <i class="fa fa-check" id="icon"></i></a>
                <a href="/java4Movies/ManageAdminUser/deleteUser?${item.userId }"><i class="fa fa-times" id="icon1"></i></a></td>
            </tr>
			</c:forEach>
          </tbody>
        </table>
      </form>

    </section>

  </main>


  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
    integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous">
  </script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
    integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous">
  </script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
    integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous">
  </script>

</body>

</html>