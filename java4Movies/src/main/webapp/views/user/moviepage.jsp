<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Movie Page</title>
 
  <%@include file="/common/head.jsp" %>
</head>
<body>
  <%@include file="/common/header.jsp" %>
	<c:url var="url" value="/java"/>
  <!--Movie Panner-->
  <section class="movie-banner">

    <!--===img=====================-->
    <div class="m-banner-img">
      <img src="<c:url value="/templates/Images/${video.panner}"/>" alt="">
    </div>

    <!--content=====================-->
    <div class="banner-container">
      <div class="title-container">
        <!--=====Title top-->
        <div class="title-top">
          <div class="movie-title">
            <h1>${video.title}</h1>
          </div>
          <!--more-about-movie-->
          <div class="more-about-movie">
            <span class="quality">FULL HD</span>
            <div class="rating">
              8.2 <img src="<c:url value="/templates/Images/IMDb-icon.png"/>" alt="imbd">
            </div>
            <span>	${video.date}</span>
            <span> ${video.time}</span>
          </div>
          <div class="language">
            <span>English</span>
          </div>
          
          <div class="like1">
            <a href="#">
              <i class="fas fa-eye">  ${video.views} </i>
            </a>
            <a href="#">
              <i class="fas fa-heart"> 100 </i>
            </a>
            <a href="/java4Movies/HomeMoviePage/addVideoFavorite?videoId=${video.videoId}">
              <span>Thêm vào Video yêu thích</span>
            </a>
            <a href="/java4Movies/ShareVideo/LoadData?videoId=${video.videoId}">
              <span>Chia sẻ</span>
            </a>
          </div>
        </div>

        <!--Title bottom-->
        <div class="title-bottom">
          <!--category-->
          <div class="category">
            <strong>Category</strong> <br>
            <a href="#">Horror</a>,<a href="#">Mistery</a>,<a href="#">Thriller</a>.
          </div>
          <!--trailer btn-->
          <a href="${video.videoTrailler}" class="watch-btn">Watch Trailer</a>
        </div>
      </div>
      <div class="play-btn-container">
        <div class="play-btn">
          <a href="javascript:void">
            <i class="fas fa-play"></i>
          </a>
        </div>
      </div>

      <!--video/fullll-->
      <div id="play" class="play">
        <!--Close Video-->
        <a href="javascript:void" class="close-movie">
          <i class="fas fa-times"></i>
        </a>

        <div class="play-movie">
          <!-- 
            <video src="Video/Movie.mp4" id="m-movie" controls> </video>
          -->
          <iframe id="m-movie" src="https://www.youtube.com/embed/${video.href}"controls></iframe>
          </div>
      </div>
    </div>
  </section>

  <section id="latest">
    <!--heading-->
    <div class="latest-heading">
      <h1>Latest Movies</h1>
    </div>
    <div class="swiper mySwiper">
      <div class="swiper-wrapper">
        <c:forEach items="${videos}" var="video">
        	<!-----1####-->
		        <div class="swiper-slide">
		          <!--box-------->
		          <div class="main-slider-box">
		            <!--overlayer-->
		            <a href="/java4Movies/HomeMoviePage/SelectById?videoId=${video.videoId}" class="main-slider-overlay">
		              <i class="fas fa-play"></i>
		            </a>
		
		            <!---img------------->
		            <div class="main-slider-img">
		              <img src="<c:url value='/templates/Images/${video.poster}' />" alt="Poster">
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

  <section id="latest">
    <!--heading-->
    <div class="latest-heading">
      <h1>New Movies</h1>
    </div>
    <div class="swiper mySwiper1">
      <div class="swiper-wrapper">
       <c:forEach items="${videos }" var="video">
        	<!-----1####-->
		        <div class="swiper-slide">
		          <!--box-------->
		          <div class="main-slider-box">
		            <!--overlayer-->
		            <a href="/java4Movies/HomeMoviePage/SelectById?videoId=${video.videoId}" class="main-slider-overlay">
		              <i class="fas fa-play"></i>
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
  
  <!--footer-->
  <%@include file="/common/footer.jsp" %>
  
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
          slidesPerView: 4,
          spaceBetween: 50,
        },
      },
      
    });

    var swiper1 = new Swiper(".mySwiper1", {
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

    /*=====popup open====*/
    $(document).on('click','.play-btn a',function(){
      $('.play').addClass('active-popup');
    });

    /*=====close video====*/
    $(document).on('click','.close-movie',function(){
      $('.play').removeClass('active-popup');
    });

    /*=========auto play========*/
    $('.play-btn a').click(function(){
      $('#m-movie').get(0).play();
    });

    $('.close-movie').click(function(){
      $('#m-movie').get(0).pause();
    });
    
  </script>
</body>

</html>