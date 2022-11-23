<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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

<section class="meetings-page" id="meetings">
 	
 	 <div class="container rounded  mt-5 mb-5">
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
     <div class="d-flex justify-content-between align-items-center mb-3">
     <h4 style="color: aliceblue;" class="text-right">Coordinator</h4> 
     <security:authorize access="hasRole('ADMIN')"> 
     <div><a  class="btn btn-primary" href="/addcoordinator">Add Coordinator</a></div> 
     </security:authorize> 
    </div>
      <div class="row">
         <div style="overflow-x: auto;">
        <table class="table bg-light ">
            <thead>
              <tr >
                <th scope="col">#</th>
                <th scope="col">Name</th>
                <th scope="col">Email</th>
                <security:authorize access="hasRole('ADMIN')"> 
                <th scope="col">Edit</th>
                <th scope="col">Delete</th>
                </security:authorize> 
              </tr>
            </thead>
            <tbody>
                <c:forEach items="${coordinator}" var="coordinator" varStatus="counter">
              <tr>
                <th scope="row">${counter.count}</th>
                <td>${coordinator.coordinatorFname } ${coordinator.coordinatorLname}</td>
                <td>${coordinator.coordinatorEmail}</td>
                <security:authorize access="hasRole('ADMIN')"> 
                <td><a class="btn btn-primary" href="/updatecoordinator?id=${coordinator.coordinatorId}">Edit</a></td>  
   				<td><a class="btn btn-danger" href="/deletebyid?id=${coordinator.coordinatorId}">Delete</a></td> 
   				 </security:authorize>  
              </tr>
            </c:forEach>             
            </tbody>
          </table>
   
             
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