<%@page import="study.entity.SessionScheduleTable"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
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

 <!-- convert to utc time for Create meeting -->
  <script>
    function convert() {
      var datetimeLocal = document.getElementById("auction_end_time-input").value;
      var datetimeUTC = moment.utc(datetimeLocal).format();
      document.getElementById("auction_end_time_utc").value = datetimeUTC;
    }
  </script>
  <!-- convert to utc time for Create meeting -->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.19.3/moment-with-locales.min.js"></script>
</head>

<body>

   <%@ include file="navbar.jsp" %>
<%	SessionScheduleTable sessionobj = (SessionScheduleTable) request.getAttribute("session"); %>
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
          action="saveUpdateScedule" modelAttribute="sessionmodel">
    <div class="container rounded  mt-5 mb-5">
      <div class="d-flex justify-content-between align-items-center mb-3">
        <h4 style="color: aliceblue;" class="text-right">Edit Session Scedule</h4>
    </div>
      <div class="row">
         
        <div class="col-md-4">
          <div class="p-3 py-5">
           <div class="col-md-12"><input name="sessionId" id="sessionId"  type="hidden" class="form-control"  value="<%= sessionobj.getSessionId()%>"></div> 
              <div class="col-md-12"><label class="labels">Topic</label><input name="sessionTopic" id="sessionTopic" type="text" class="form-control" placeholder="Enter topic" value="<%= sessionobj.getSessionTopic()%>"></div> 
              <div class="col-md-12"><label class="labels">Scedule date and time</label><input onchange="convert()" 
                class="form-control" name="aution_end_time" required type="datetime-local" id="auction_end_time-input">
            </div> 
             </div>
      </div>
          <div class="col-md-4">
              <div class="p-3 py-5">
              <div class="col-md-12"><label class="labels">UTC Time</label><input type="text" readonly="readonly" class="form-control" 
              name="sessionDate"  id="auction_end_time_utc" value="<%= sessionobj.getSessionDate()%>"></div>
                <div class="col-md-12"><label class="labels">Agenda</label><input class="form-control" name="sessionDetails" id="sessionDetails" type="text"  placeholder="Enter agenda" value="<%= sessionobj.getSessionDetails()%>"></div> 
                <div class="mt-5 text-center"><button class="btn btn-primary profile-button" type="submit">Update</button></div>
              </div>
          </div>
          
          <div class="col-md-4">
              <div class="p-3 py-5">
                <div class="col-md-12"><label class="labels">Duration</label><input name="sessionDuration" id="sessionDuration" type="text" class="form-control" placeholder="additional details" value="<%= sessionobj.getSessionDuration()%>"></div>
                <div class="col-md-12"><label class="labels">Attendance</label><input name="sessionAttendance" id="sessionAttendance" type="number" class="form-control" placeholder="additional details" value="<%= sessionobj.getSessionAttendance()%>"></div>
                
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