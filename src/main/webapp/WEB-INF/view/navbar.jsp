
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="Template Mo">
<link
	href="https://fonts.googleapis.com/css?family=Poppins:100,200,300,400,500,600,700,800,900"
	rel="stylesheet">


<title>E-Learning Automation - Profile Page</title>

<!-- Bootstrap core CSS -->
<link href="/resources/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">


<!-- Additional CSS Files -->
<link rel="stylesheet" href="/resources/assets/css/fontawesome.css">
<link rel="stylesheet"
	href="/resources/assets/css/templatemo-edu-meeting.css">
<link rel="stylesheet" href="/resources/assets/css/owl.css">
<link rel="stylesheet" href="/resources/assets/css/lightbox.css">
<link rel="stylesheet" href="/resources/assets/css/login.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
<!--

TemplateMo 569 Edu Meeting

https://templatemo.com/tm-569-edu-meeting

-->
</head>



<body>

   
  <!-- ***** Header Area Start ***** -->
  <header class="header-area header-sticky">
      <div class="container">
          <div class="row">
              <div class="col-12">
                  <nav class="main-nav">
                                    
                    <a href="/home" class="logo">
                     <img class="logo-image" src="/resources/assets/images/logo.png"/>
                  </a>
                      <!-- ***** Menu Start ***** -->
                      <ul class="nav">
                        
                          <li ><a href="/home"><i class="bi bi-house-door"></i>Home</a></li>
                           
                            <li ><a href="/viewallschedule">Dashboard</a></li>
                            
					
                          <li><a href="ContactUs.html">Contact us</a></li> 
                         <li class="has-sub"><a href="javascript:void(0)"><i class="bi bi-person"></i>
                         				<security:authorize access="isAuthenticated()">               
                          			     <security:authentication property="principal.user" /> 
                         				</security:authorize> </a>
								<ul class="sub-menu">
                         			<security:authorize access="!isAuthenticated()">               
                          				<li><a href="login.html">Login</a></li> 
                         			</security:authorize>   
                          			<security:authorize access="isAuthenticated()">
                         				 <li><a href="/logout"><i class="bi bi-box-arrow-left"></i> logout</a></li>   
                         		   </security:authorize>  
                         		   <security:authorize access="hasRole('ADMIN')">  
                         		    <li ><a href="/viewallcoordinators">Coordinators Details</a></li>
                              <li ><a href="/zoomcontrols">Zoom Controls</a></li>
                              </security:authorize> 
                          		</ul>
                          			</ul>
						
                      <a class='menu-trigger'>
                          <span>Menu</span>
                      </a>
                      <!-- ***** Menu End ***** -->
                  </nav>
              </div>
          </div>
      </div>
  </header>
  <!-- ***** Header Area End ***** -->



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