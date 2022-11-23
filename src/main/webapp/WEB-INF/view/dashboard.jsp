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
 
  <!--

TemplateMo 569 Edu Meeting

https://templatemo.com/tm-569-edu-meeting


-->

</head>

<body>

   <%@ include file="navbar.jsp" %>

<section class="meetings-page" id="meetings">
     <div class="container rounded  mt-5 mb-5">
     

     
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
  		 <input type="hidden" name="txt_temp" id="txt_temp"/>
  		  <c:forEach items="${chartdata}" var="chartdata">
  		<c:out  value="${chartdata.key}, ${chartdata.value}"></c:out>
  		 <input type="hidden" onload="createarr(${chartdata.key},${chartdata.value})" name="txt_temp" id="txt_temp"/>
    </c:forEach>
  		</c:if>
  		
  		 <div class="d-flex justify-content-between align-items-center mb-3">
  		 
  	<div class="container">
     
      <div class="row" ">
        <div class="col-lg-3 my-lg-0 my-md-1">
            <div id="sidebar" class="bg-purple">
                <div class="h4 text-white">Account</div>
                <ul>    
                    <li class="active"> <a href="Admin-Dashboard.html" class="text-decoration-none d-flex align-items-start">
                      
                      <div class="d-flex flex-column">
                          <div class="link">Dashboard</div>
                          <div class="link-desc"></div>
                      </div>
                  </a> </li>

                        
                        <li > <a href="Schedule-Meeting.html" class="text-decoration-none d-flex align-items-start">
                          <div class="d-flex flex-column">
                            <div class="link">Schedule Meeting</div>
                            <div class="link"></div>
                              <div class="link-desc"></div>
                          </div>
                      </a> </li>
                      <li > <a href="ZoomDetails.html" class="text-decoration-none d-flex align-items-start">
                        
                        <div class="d-flex flex-column">
                          <div class="link">Zoom Details</div>
                            <div class="link-desc"></div>
                        </div>
                    </a> </li>
                    <li> <a href="Module-Details.html" class="text-decoration-none d-flex align-items-start">
                        
                      <div class="d-flex flex-column">
                        <div class="link">Module Details</div>
                          <div class="link-desc"></div>
                      </div>
                  </a> </li>
                                    
                </ul>
            </div>
        </div>
      
      
  		
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