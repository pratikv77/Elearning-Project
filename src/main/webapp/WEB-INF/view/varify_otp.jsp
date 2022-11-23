<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="Template Mo">
  <link href="https://fonts.googleapis.com/css?family=Poppins:100,200,300,400,500,600,700,800,900" rel="stylesheet">


  <title>Verify OTP</title>

  <!-- Bootstrap core CSS -->
  <link href="/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">


  <!-- Additional CSS Files -->
  <link rel="stylesheet" href="/resources/assets/css/fontawesome.css">
  <link rel="stylesheet" href="/resources/assets/css/templatemo-edu-meeting.css">
  <link rel="stylesheet" href="/resources/assets/css/owl.css">
  <link rel="stylesheet" href="/resources/assets/css/lightbox.css">
  <link rel="stylesheet" href="/resources/assets/css/login.css">
  <!--

TemplateMo 569 Edu Meeting

https://templatemo.com/tm-569-edu-meeting

-->
</head>

<body>

   <%@ include file="navbar.jsp" %>
    <div>
		<%
		String message = (String) request.getAttribute("msg");
		String error = (String) request.getAttribute("error");
		%>

	</div>

  <section class="meetings-page" id="meetings">

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
            <div class="wrapper fadeInDown">
              <div id="formContent">
                <!-- Tabs Titles -->
                <h2 class="active"> Verify OTP </h2>
              
            <div>
				<% if (message != null) { %>
            	 
            			<div class="alert alert-success" role="alert">
 						<%=message %> 
						</div>
				<% } %>
				</div>
				
				<div>
				<% if (error != null) { %>
            	 
            			<div class="alert alert-warning" role="alert">
 						<%=error %> 
						</div>
				<% } %>
				</div>
               
                <!-- Login Form -->
                <form method="post" action="/verify-otp">
                  <input type="text" id="otp" class="fadeIn second" name="otp" placeholder="Enter OTP">
                  <input type="submit" class="fadeIn fourth" value="Verify otp">
                </form>
            
            
              </div>
            </div>
           
          </div>
        </div>


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