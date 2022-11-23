<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="Template Mo">
  <link href="https://fonts.googleapis.com/css?family=Poppins:100,200,300,400,500,600,700,800,900" rel="stylesheet">


  <title>E-Learning Automation - Profile Page</title>

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
     <!-- Message box -->
   

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
                <h2 class="active"> Sign In </h2>
                
              <!--  will show error msg if any error -->
				<div id="alert">
               	<c:if test="${param.error!=null}">
   			 	<div class="alert alert-danger" role="alert">Wrong credentials!!</div>
				</c:if>
				</div>
				
				
                <!-- Login Form -->
                <form method="post" action="/login">
                  <input required="required" type="text" id="username" class="fadeIn second" name="username" placeholder="login">
                  <input required="required" type="password" id="password" class="fadeIn third" name="password" placeholder="password">
                  <input type="submit" class="fadeIn fourth" value="Log In">
                </form>
            
                <!-- Remind Passowrd -->
                <div id="formFooter">
                  <a class="underlineHover" href="/forgot">Forgot Password?</a>
                </div>
            
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