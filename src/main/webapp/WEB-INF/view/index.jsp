<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="TemplateMo">
    <link href="https://fonts.googleapis.com/css?family=Poppins:100,200,300,400,500,600,700,800,900" rel="stylesheet">

    <title>Education Meeting HTML5 Template</title>

    <!-- Bootstrap core CSS -->
   <link href="/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">


    <!-- Additional CSS Files -->
   <link rel="stylesheet" href="/resources/assets/css/fontawesome.css">
  <link rel="stylesheet" href="/resources/assets/css/templatemo-edu-meeting.css">
  <link rel="stylesheet" href="/resources/assets/css/owl.css">
  <link rel="stylesheet" href="/resources/assets/css/lightbox.css">
  <link rel="stylesheet" href="/resources/assets/css/profile.css">

  </head>

<body>

<!-- Sub Header -->
   <div class="sub-header">
    <div class="container">
      <div class="row">
        <div class="col-lg-8 col-sm-8">
          <div class="left-content">
            <p>  <!-- ***** Logo Start ***** -->
              <a href="index.html" class="logo">
                E-Learning 
              </a>
              <!-- ***** Logo End ***** -->
            </p>
          </div>
        </div>
       
      </div>
    </div>
  </div>
 

   <%@ include file="navbar.jsp" %>
   

  <!-- ***** Main Banner Area Start ***** -->
  <section class="section main-banner" id="top" data-section="section1">
     
      <img src="/resources/assets\images\E-Learning1.jpg" alt="">

      <div class="video-overlay header-text">
          <div class="container">
           <!--  message box -->
		<div id="alert">
  		<c:if test="${not empty error}">
       	<div class="alert alert-danger"  role="alert">  <c:out value = "${error}"/></div>
      	</c:if>
      	</div>
      	<div id="alert">
  		<c:if test="${not empty message}">
       	<div class="alert alert-success"  role="alert">  <c:out value = "${message}"/></div>
      	</c:if>
      	</div>
    <!--  message box -->
            <div class="row">
              <div class="col-lg-12">
                <div class="caption">
              <h6>Hello Students</h6>
              <h2>Welcome to E-learning 
     
</h2>

             
          </div>
              </div>
            </div>
          </div>
      </div>
  </section>
  <!-- ***** Main Banner Area End ***** -->

  <section class="services">
    <div class="container">
      <div class="row">
        <div class="col-lg-12">
          <div class="owl-service-item owl-carousel">
          
            <div class="item">
              <div class="icon">
                <img src="/resources/assets/images/service-icon-01.png" alt="">
              </div>
              <div class="down-content">
                <h4>Best Education</h4>
                <p>Education is door to future</p>
              </div>
            </div>
            
            <div class="item">
              <div class="icon">
                <img src="/resources/assets/images/service-icon-02.png" alt="">
              </div>
              <div class="down-content">
                <h4>Best Teachers</h4>
                <p>Teachers have the power to make or break lives.</p>
              </div>
            </div>
            
            <div class="item">
              <div class="icon">
                <img src="/resources/assets/images/service-icon-03.png" alt="">
              </div>
              <div class="down-content">
                <h4>Best Students</h4>
                <p>Focus on your goal. Don't look in any direction but ahead.</p>
              </div>
            </div>
            
            <div class="item">
              <div class="icon">
                <img src="/resources/assets/images/service-icon-02.png" alt="">
              </div>
              <div class="down-content">
                <h4>Online Meeting</h4>
                <p>More accessibility for the students to engage with teachers in other locations. </p>
              </div>
            </div>
            
            
            <div class="item">
              <div class="icon">
                <img src="/resources/assets/images/service-icon-03.png" alt="">
              </div>
              <div class="down-content">
                <h4>Best Networking</h4>
                <p>Make the most of your digital interactions by learning how to recognize opportunities.</p>
              </div>
            </div>
            
            
            
          </div>
        </div>
      </div>
      
    </div>
   
  </section>
   
  <section class="contact-us" id="contact">
    <%@ include file="footer.jsp" %>
    
  </section>

  <!-- Scripts -->
  <!-- Bootstrap core JavaScript -->
  <script src="/resources/vendor/jquery/jquery.min.js"></script>
  <script src="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <script src="/resources/assets/js/isotope.min.js"></script>
  <script src="/resources/assets/js/owl-carousel.js"></script>
  <script src="/resources/assets/js/lightbox.js"></script>
  <script src="/resources/assets/js/tabs.js"></script>
  <script src="/resources/assets/js/video.js"></script>
  <script src="/resources/assets/js/slick-slider.js"></script>
  <script src="/resources/assets/js/custom.js"></script>

</body>

</body>
</html>