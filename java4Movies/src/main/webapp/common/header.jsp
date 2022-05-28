<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--Navigation=============-->
<c:url var="url" value="/java"/>
  <nav class="navigation">
    <!--Menu-btn-->
    <input type="checkbox" class="menu-btn" id="menu-btn">
    <label for="menu-btn" class="menu-icon">
      <span class="nav-icon"></span>
    </label>

    <!--logo=====================-->
    <a href="${url }/index1" class="logo">
      Movies<span>.hd</span>
    </a>

    <!--MENU================-->
    <c:choose>
    	<c:when test="${role == true}">
    		<ul class="menu">
		      <li><a href="#">HOME</a></li>
		      <li><a href="/java4Movies/ManageAdminVideo">LIST MOVIES</a></li>
		      <li><a href="/java4Movies/ManageAdminUser">LIST USER</a></li>
		      <li><a href="/java4Movies/LogoutServlet">LOG OUT</a></li>
		    </ul>
    	</c:when>
    	<c:otherwise>
    		<ul class="menu">
		      <li><a href="#">HOME</a></li>
		      <li><a href="/java4Movies/MyFavoriteVideo">My Favorite Movie</a></li>
		      <li><a href="/java4Movies/registerAccount/update?userId=${user.userId}">Update File</a></li>
		      <li><a href="/java4Movies/LogoutServlet">Log out</a></li>
		    </ul>
    	</c:otherwise>
    </c:choose>
    

    <!--Search box==================-->
    <form action class="search-box">
      <input type="text" name="searchVideo" placeholder="Search Movie" >

      <button type="submit" formaction="/java4Movies/searchVideo">
        <i class="fas fa-search"></i>
      </button>
    </form>
    <ul class="nav-menu" id="nav-menu">
      <li>
        <a href="/java4Movies/views/user/login.jsp" class="btn btn-hover" name="login">
          <span>
          	<c:choose>
				<c:when test="${empty sessionScope.user}">
					Log in
				</c:when>
				<c:otherwise>
					Welcome ${sessionScope.user.userId}
				</c:otherwise>
			</c:choose>
          </span>
        </a>
      </li>
    </ul>
  </nav>