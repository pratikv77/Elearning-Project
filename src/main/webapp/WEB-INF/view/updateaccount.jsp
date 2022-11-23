<%@page import="study.entity.ZoomAccountTable"%>
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

   <%@ include file="navbar.jsp" %>
	<%	ZoomAccountTable zoom = (ZoomAccountTable) request.getAttribute("zoom"); %>
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
          action="saveupdateaccount" modelAttribute="zoomaccount">
     
      <div class="container rounded  mt-5 mb-5">
      <div class="d-flex justify-content-between align-items-center mb-3">
        <h4 style="color: aliceblue;" class="text-right">Add zoom account details </h4>
    </div>
      <div class="row">
         
        <div class="col-md-4">
          <div class="p-3 py-5">
             <div class="col-md-12"><input name="zoom_id" id="zoom_id"  type="hidden" class="form-control"  value="<%=	zoom.getZoom_id() %>"></div> 
              <div class="col-md-12"><label class="labels">User name</label><input name="zoom_username" id="zoom_username" type="text" class="form-control" placeholder="Enter User name" value="<%= zoom.getZoom_username()%>"></div> 
             
            </div>
      </div>
          <div class="col-md-4">
              <div class="p-3 py-5">
                <div class="col-md-12"><label class="labels">Password</label><input name="zoom_password" id="zoom_password" type="text" class="form-control" placeholder="Enter password" value="<%= zoom.getZoom_password()%>"></div> 
                
                <div class="mt-5 text-center"><button class="btn btn-primary profile-button" type="submit">Update</button></div>
                
                  
               
              </div>
          </div>
          
          <div class="col-md-4">
            <div class="p-3 py-5">
              
              
                <div class="col-md-12"><label class="labels">Other Details</label><input name="zoom_account_details" id="zoom_account_details" class="form-control" placeholder="Enter other details" value="<%= zoom.getZoom_account_details() %>"></div> 
                
               
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