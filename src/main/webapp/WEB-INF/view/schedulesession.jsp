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

 <section class="meetings-page" id="meetings">
 
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
 
  <form:form method="POST" 
          action="savesession" modelAttribute="session">
    <div class="container rounded  mt-5 mb-5">
      <div class="d-flex justify-content-between align-items-center mb-3">
        <h4 style="color: aliceblue;" class="text-right">Session Scedule</h4>
    </div>
      <div class="row">
         
        <div class="col-md-4">
          <div class="p-3 py-5">
              <div class="col-md-12"><label class="labels">Topic</label><input name="sessionTopic" id="sessionTopic" type="text" class="form-control" placeholder="Enter topic" value=""></div> 
              <div class="col-md-12"><label class="labels">Scedule date and time</label><input onchange="convert()" 
                class="form-control" name="aution_end_time" required type="datetime-local" id="auction_end_time-input">
            </div> 
            <div class="col-md-12"><label class="labels">UTC Time</label><input type="text" readonly="readonly" class="form-control" 
              name="sessionDate"  id="auction_end_time_utc"></div>
            </div>
      </div>
          <div class="col-md-4">
              <div class="p-3 py-5">
                <div class="col-md-12"><label class="labels">Agenda</label><input class="form-control" name="sessionDetails" id="sessionDetails" type="text"  placeholder="Enter agenda" value=""></div> 
                <div class="col-md-12"><label class="labels">Duration</label><input name="sessionDuration" id="sessionDuration" type="text" class="form-control" placeholder="additional details" value=""></div>
                  <div class="col-md-12">
                    <label class="labels">Choose Module</label><br>
                  <select class="form-control" name="moduleTable" id="moduleTable">
                    <option >Module</option>
                    <c:forEach items="${module}" var="module">
                    <option value="${module.module_id}">${module.moduleName}</option>
                    </c:forEach>       
                  </select>

                </div>
                <div class="mt-5 text-center"><button class="btn btn-primary profile-button" type="submit">Save Session</button></div>
                
              </div>
          </div>
          
          <div class="col-md-4">
            <div class="p-3 py-5">
              <div class="col-md-12">
                <label class="labels">Choose Faculty</label><br>
              <select class="form-control" name="facultyInfoTable" id="facultyInfoTable">
                <option >Faculty</option>
                <c:forEach items="${fac}" var="fac">
                 <option value="${fac.facultyId}">${fac.facultyFname}</option>
                 </c:forEach>  
              </select>
            </div>
             <div class="col-md-12">
                <label class="labels">Choose Zoom Account</label><br>
              <select class="form-control" name="zoomAccountTable" id="zoomAccountTable">
                <option  >Zoom Account</option>
                <c:forEach items="${zoomaccount}" var="zoomaccount">
                 <option value="${zoomaccount.zoom_id}">${zoomaccount.zoom_username}</option>
                 </c:forEach>  
              </select>
            </div> 
                <br>  
                  <div class="col-md-12"><label class="labels">EnableRecording : </label>
                    <input type="radio" value="1" name="sessionEnableRecording" id="sessionEnableRecording"><span style="color: floralwhite;">Yes</span>   
                    <input type="radio" value="0"name="sessionEnableRecording" id="sessionEnableRecording"><span style="color:floralwhite;">No</span>
    
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