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
    <link rel="stylesheet" href="/resources/assets/css/Dashboard.css">
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

     
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
    var setKey = [];
	var setValue = [];
	
    function createarr(name,value) {
    	
    
    		setKey.push(name);
    		setValue.push(value);
    		console.log(name+" " +value)
    	
    }
    
    
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);
      function drawChart() {

        var data = new google.visualization.DataTable();
        
        data.addColumn('string', 'Subject');
        data.addColumn('number', 'Covered%');
		data.addRow(["java", 3]); 
		data.addRow(['Wpt', 0.66]); 
		data.addRow(['Remaining', 96.44]); 
        
        var options = {
          title: 'Course complition',
          is3D: true
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart'));

        chart.draw(data, options);
      }
    </script> 
    
    
     	 <c:if test="${chartdata !=null}">
  		  <c:forEach items="${chartdata}" var="chartdata">
  			<c:out  value="${chartdata.key}, ${chartdata.value}"></c:out>
  		 <input type="hidden" oninput="createarr(${chartdata.key},${chartdata.value})" name="txt_temp" id="txt_temp"/>
    	</c:forEach>
  		</c:if>
  		
  		 <div class="d-flex justify-content-between align-items-center mb-3">
  	<!-- 	  Sidebar Dashboard -->
  		 <div class="col-lg-3 my-lg-0 my-md-1">
            <div id="sidebar" class="bg-purple">
                <div class="h4 text-white">Dashboard</div>
                <ul>    
                    <li class="active"> <a href="/listmeeting" class="text-decoration-none d-flex align-items-start">
                      
                      <div class="d-flex flex-column">
                          <div class="link">Upcoming Meetings</div>
                          <div class="link-desc"></div>
                      </div>
                  </a> </li>

                        
                        <li > <a href="/viewallmodule" class="text-decoration-none d-flex align-items-start">
                          <div class="d-flex flex-column">
                            <div class="link">Modules</div>
                            <div class="link"></div>
                              <div class="link-desc"></div>
                          </div>
                      </a> </li>
                      <li > <a href="/viewallfaculty" class="text-decoration-none d-flex align-items-start">
                        
                        <div class="d-flex flex-column">
                          <div class="link">Staf Details</div>
                            <div class="link-desc"></div>
                        </div>
                    </a> </li>
                    <security:authorize access="hasRole('ADMIN')">  
                    <li > <a href="/viewallstudents" class="text-decoration-none d-flex align-items-start">
                        
                        <div class="d-flex flex-column">
                          <div class="link">Students Details</div>
                            <div class="link-desc"></div>
                        </div>
                    </a> </li>
                    <li > <a href="/viewAccounts" class="text-decoration-none d-flex align-items-start">
                        
                        <div class="d-flex flex-column">
                          <div class="link">Zoom Details</div>
                            <div class="link-desc"></div>
                        </div>
                    </a> </li>
                      </security:authorize> 
                    <li> <a href="/viewallmodule" class="text-decoration-none d-flex align-items-start">
                      <div class="d-flex flex-column">
                        <div class="link">Notice</div>
                          <div class="link-desc"></div>
                      </div>
                  </a> </li>
                                    
                </ul>
            </div>
        </div>
      	<!-- 	  Sidebar Dashboard -->
  		
  		 <div class="col-lg-6">
        <div class="card mb-4">
            <div class="card-header">
                <i class="fas fa-chart-pie me-1"></i>
                Total teaching Completed
            </div>
            
           <div id="piechart" style="width: 100%; height: 50;"></div>
            <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
        </div>
    </div> 
  		
  		 </div>
       <!-- <div id="piechart" style="width: 900px; height: 500px;"></div> -->
      <div class="d-flex justify-content-between align-items-center mb-3">
       <h4 style="color: aliceblue;" class="text-right">Scedule</h4>
        <security:authorize access="hasRole('ADMIN')">  
        <div><a class="btn btn-primary" href="/schedulesession">Add Scedule</a></div> 
        </security:authorize> 
       
    </div>
    </div>
      <div class="row">
         <div class="table-responsive">
        <table class="table bg-light">
            <thead>
              <tr >
                <th scope="col">#</th>
                <th scope="col">Topic</th>
                <th scope="col">Date & Time</th>
                <th scope="col">Details</th>
                <th scope="col">Duration</th>
                <th scope="col">Join meeting</th>
                <security:authorize access="hasRole('STUDENT')">  
                <th scope="col">Feedback</th>
                </security:authorize> 
                <security:authorize access="hasRole('ADMIN')">  
                 <th scope="col">Start Meeting</th>
                <th scope="col">Edit</th>
                <th scope="col">Delete</th>
                </security:authorize> 


              </tr>
            </thead>
            <tbody>
                <c:forEach items="${session}" var="session" varStatus="counter">
              <tr>
                <th scope="row">${counter.count}</th>
                <td>${session.sessionTopic}</td>
                <td>${session.sessionDate}</td>
                <td>${session.sessionDetails}</td>
                <td>${session.sessionDuration}</td>
                <c:if test="${not empty session.sessionInvitationDetails}">
                <td><a class="btn btn-primary" href="${session.sessionInvitationDetails}">Join</a></td> 
				</c:if>
				 <c:if test="${empty session.sessionInvitationDetails}">
                <td>Yet to start</td> 
				</c:if>
                  
                 <security:authorize access="hasRole('STUDENT')">  
                <td><a class="btn btn-primary" href="/addfeedback?id=${session.moduleTable.module_id}">Feedback</a></td>  
                </security:authorize> 
                <security:authorize access="hasRole('ADMIN')">
                <c:if test="${not empty session.sessionStartUrl}"> 
                 <td><a class="btn btn-primary" href="${session.sessionStartUrl}">Start</a></td>  
                 </c:if> 
                 <c:if test="${empty session.sessionStartUrl}"> 
                 <td>Yet to start</td> 
                 </c:if> 
                 
                <td><a class="btn btn-primary" href="/editsession?id=${session.sessionId}">Edit</a></td>  
   				<td><a class="btn btn-danger" href="/deleteschedule?id=${session.sessionId}">Delete</a></td>  
   				</security:authorize> 
              </tr>
            </c:forEach>             
            </tbody>
          </table>
           <%--For Pagination --%>
         <div style="text-align:center">
    <%--For displaying Previous link --%>
    <c:if test="${pageNumber gt 1}">
        <a href="viewschedule?pageNumber=${pageNumber - 1}">Previous</a>
    </c:if>
    <c:forEach begin="1" end="${numberOfPages}" var="i">
        <c:choose>
            <c:when test="${i!=pageNumber}">
           		 <a  href="viewschedule?pageNumber=<c:out value="${i}"/>"><c:out value="${i}"/></a>
            </c:when>
        	<c:otherwise>
        		<c:out value="${i}"/>
        	</c:otherwise>        
        </c:choose>       
    </c:forEach>  
    <%--For displaying Next link --%>
    <c:if test="${pageNumber lt numberOfPages}">
        <a href="viewschedule?pageNumber=${pageNumber + 1}">Next</a>
    </c:if>
         </div>
       <%--End of pagination --%>
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




</html>