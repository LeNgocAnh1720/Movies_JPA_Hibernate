<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Video Movie</title>
  <%@include file="/common/head.jsp" %>
</head>
				
<body>
  <%@include file="/common/header.jsp" %>
  <c:url var="url" value="/java"/>
  <!--Slider----------------------------------->

  <!--=====Latest Movie-->
  <section id="latest">
    <!--heading-->
    <div class="latest-heading">
      <h1>My Favorite Video</h1>
    </div>
    <!--Container-->
    <div class="post-container">
    
      <c:forEach var="video" items="${videoFavorite}">
      		<!--post-box 1--->
		      <div class="post-box">
		        <!---img-->
		        <div class="post-img">
		          <img src="<c:url value='/templates/Images/${video.poster}' />" alt="">
		        </div>
		
		        <!--text------------->
		        <div class="main-slider-text">
		          <!--quality------>
		          <span class="quality">Full HD</span>
		
		          <!--bottom text-->
		          <div class="bottom-text">
		            <!--name movie-->
		            <div class="movie-name">
		              <span> ${video.date}</span>
		              <a href="/java4Movies/HomeMoviePage?videoId=${video.videoId}">${video.title}</a>
		            </div>
		
		            <!--category and rating-->
		            <div class="category-rating">
		              <div class="category">
		                <a href="#">Horror</a>,<a href="#">Mistery</a>,<a href="#">Thriller</a>
		              </div>
		              <div class="rating">
		                5.2 <img src="<c:url value='/templates/Images/IMDb-icon.png' />" alt="imbd">
		              </div>
		            </div>
		          </div>
		        </div>
		      </div>
		      
      </c:forEach>
    </div>

    <!--Container end-->
    <!--page-number=====================-->
    <div class="page-number">
      <a href="#" class="page-active">1</a>
      <a href="#">2</a>
      <a href="#">3</a>
      <a href="#">...</a>
      <a href="#">100</a>
    </div>
  </section>

	<%@include file="/common/footer.jsp" %>
	
	
	
	
  <!-- Initialize Swiper -->
  <script>
    var swiper = new Swiper(".mySwiper", {
      slidesPerView: 1,
      spaceBetween: 10,
      pagination: {
        el: ".swiper-pagination",
        clickable: true,
      },
      autoplay: {
        delay: 5000,
        disableOnInteraction: false,
      },
      navigation: {
        nextEl: ".swiper-button-next",
        prevEl: ".swiper-button-prev",
      },
      breakpoints: {
        640: {
          slidesPerView: 2,
          spaceBetween: 20,
        },
        768: {
          slidesPerView: 4,
          spaceBetween: 40,
        },
        1024: {
          slidesPerView: 3,
          spaceBetween: 50,
        },
      },
    });
  </script>
</body>

</html>