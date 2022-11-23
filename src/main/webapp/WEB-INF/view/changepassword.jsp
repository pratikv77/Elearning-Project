<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="Template Mo">
  <link href="https://fonts.googleapis.com/css?family=Poppins:100,200,300,400,500,600,700,800,900" rel="stylesheet">


  <title>Create password</title>

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
   
   <script>
        function validate()
        {
            var pass= document.getElementById("pass").value;
            var confirmpass= document.getElementById("pass1").value;
            
            if(pass === confirmpass)
            {
                document.getElementById("form").submit()

            }

            else if(pass=="" || confirmpass=="")
            { 
            	alert("please confirm password")
            	
           	}
            
            else if(!pass !== confirmpass)
            { 
            	alert("Both password entry should be same!!")
            	
           	}
           
            else 
            { 
            	alert("Something went wrong!!")
            	
           	}

        }

    </script>
    <div>
		<%
		String message = (String) request.getAttribute("msg");
		%>

	</div>

  <section class="meetings-page" id="meetings">
  
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

        <div class="container">
          <div class="row">
            <div class="wrapper fadeInDown">
              <div id="formContent">
                <!-- Tabs Titles -->
                <h2 class="active"> Create new password </h2>
              
            <div>
				<% if (message != null) { %>
            	 
            			<div class="alert alert-success" role="alert">
 						<%=message %> 
						</div>
				<% } %>
				</div>
               
                <!-- Login Form -->
                <form id="form" method="post" action="/changepass">
                  <input required="required" type="text" id="pass" class="fadeIn second" name="pass" placeholder="Enter new password"/>
                  <input required="required" type="text" id="pass1" class="fadeIn second" name="pass1" placeholder="Verify your new password"/>
                  <input type="button" class="fadeIn fourth" value="Change password" onclick="validate()"/>
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