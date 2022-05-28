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
  <section id="main-slider" action="${url}/index1" method="post">
    <div class="swiper mySwiper">
      <div class="swiper-wrapper">
      
        	<c:forEach items="${videos}" var="video" >
        		<!-----1####-->
		        <div class="swiper-slide">
		          <!--box-------->
		          <div class="main-slider-box">
		            <!--overlayer-->
		            <a href="/java4Movies/HomeMoviePage/SelectById?videoId=${video.videoId}" class="main-slider-overlay">
		              <i class="fas fa-play" ></i>
		            </a>
		
		            <!---img------------->
		            <div class="main-slider-img">
		              <img src="<c:url value='/templates/Images/${video.poster }' />" alt="Poster">
		            </div>
		
		            <!--text------------->
		            <div class="main-slider-text">
		              <!--quality------>
		              <span class="quality">Full HD</span>
		
		              <!--bottom text-->
		              <div class="bottom-text">
		                <!--name movie-->
		                <div class="movie-name">
		                  <span> ${video.date }</span>
		                  <strong>${video.title }</strong>
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
		        </div>
		        
        	</c:forEach>
      <div class="swiper-pagination"></div>
    </div>
    </div>
  </section>

  <!--btns-->
  <div class="slider-btns">
    <div class="swiper-button-next"></div>
    <div class="swiper-button-prev"></div>
  </div>


  <!--=====Latest Movie-->
  <section id="latest">
    <!--heading-->
    <div class="latest-heading">
      <h1>Latest Movies</h1>
    </div>
    <!--Container-->
    <div class="post-container">
    
      <c:forEach var="video" items="${videos}">
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
		              <a href="/java4Movies/HomeMoviePage/SelectById?videoId=${video.videoId}">${video.title}</a>
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