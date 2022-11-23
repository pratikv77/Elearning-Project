<%@page import="study.entity.CoordinatorTable"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="ISO-8859-1">
 
  
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

<table border=1>


 </table>

   <%@ include file="navbar.jsp" %>

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

    
       <form:form method="POST" 
          action="savecoordinator" modelAttribute="coordinator">
     <div class="container rounded  mt-5 mb-5">
      <div class="d-flex justify-content-between align-items-center mb-3">
        <h4 style="color: aliceblue;" class="text-right">Add Coordinator</h4>
    </div>
      <div class="row">
         
        <div class="col-md-4">
          <div class="p-3 py-5">
             <div class="col-md-12"><label class="labels">First Name</label><input name="coordinatorFname" id="coordinatorFname" type="text" class="form-control" value="" placeholder="Firstname"></div>
             <div class="col-md-12"><label class="labels">Last Name</label><input name="coordinatorLname" id="coordinatorLname" type="text" class="form-control" value="" placeholder="Lastname"></div>
            </div>
      </div>
          <div class="col-md-4">
              <div class="p-3 py-5">
               <div class="col-md-12"><label class="labels">Username</label><input name="coordinatorEmail" id="coordinatorEmail" type="text" class="form-control" value="" placeholder="enter Username" ></div>
                        <div class="col-md-12"><label class="labels">Password</label><input name="coordinatorPassword" id="coordinatorPassword" type="text" class="form-control" value="" placeholder="enter Password"></div>
                <div class="mt-5 text-center"><button class="btn btn-primary profile-button" type="submit">Save Coordinator</button></div>
              </div>
          </div>
          
          
          
          
          <div class="col-md-4">
            <div class="p-3 py-5">
            <br>
            <div class="col-md-12"><label class="labels">Is Active </label>
                    <input type="radio" value="1" name="coordinatorIsActive" id="coordinatorIsActive"><span style="color: floralwhite;">Yes</span>   
                    <input type="radio" value="0"name="coordinatorIsActive" id="coordinatorIsActive"><span style="color:floralwhite;">No</span>
    
                  </div>
                  
              </div>
        </div>
       
      </div>
  </div>
          
    
    </form:form>
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