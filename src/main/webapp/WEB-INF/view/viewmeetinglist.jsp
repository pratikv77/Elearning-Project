<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="TemplateMo">
    <link href="https://fonts.googleapis.com/css?family=Poppins:100,200,300,400,500,600,700,800,900" rel="stylesheet">

    <title>meeting list</title>

    <!-- Bootstrap core CSS -->
    <link href="/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">


    <!-- Additional CSS Files -->
    <link rel="stylesheet" href="/resources/assets/css/fontawesome.css">
    <link rel="stylesheet" href="/resources/assets/css/templatemo-edu-meeting.css">
    <link rel="stylesheet" href="/resources/assets/css/owl.css">
    <link rel="stylesheet" href="/resources/assets/css/lightbox.css">

  </head>
  
  <script>
    function compair(date) {
      var meetingdate = new Date(date);
      var mills=meetingdate.getTime();
      var currentmills = Date.now();
      if(mills>currentmills)
    	  {
    	  return true;
    	  
    	  }
      else
    	  {
    	  return false;
    	  }
    }
  </script>

<body>

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
     <div class="container rounded  mt-5 mb-5">
      
      <div class="d-flex justify-content-between align-items-center mb-3">
       <h4 style="color: aliceblue;" class="text-right">Meeting List</h4>
    </div>
      <div class="row">
         <div class="table-responsive">
        <table class="table bg-light">
            <thead>
              <tr >
                <th scope="col">#</th>
                <th scope="col">Meeting Id</th>
                <th scope="col">Topic</th>
                <th scope="col">Start time</th>
                <th scope="col">Agenda</th>
                <th scope="col">Duration</th>
                <th scope="col">Joining URL</th>
              </tr>
            </thead>
            <tbody>
                <c:forEach items="${meeting}" var="meeting" varStatus="counter">
              
              <tr onload="">
                <th scope="row">${counter.count}</th>
                <td>${meeting.id}</td>
                <td>${meeting.topic}</td>
                <td>${meeting.start_time}</td>
                <td>${meeting.agenda}</td>
                <td>${meeting.duration}</td>
                <td><a class="btn btn-primary" href="${meeting.join_url}">Join</a></td>  
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
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

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
