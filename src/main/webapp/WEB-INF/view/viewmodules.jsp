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
     
      <div class="d-flex justify-content-between align-items-center mb-3">
        <!-- 	  Sidebar Dashboard -->
  		 <div class="col-lg-3 my-lg-0 my-md-1">
            <div id="sidebar" class="bg-purple">
                <div class="h4 text-white">Modules Details</div>
                <ul>    
                 <li class="active"> <a href="/viewallschedule" class="text-decoration-none d-flex align-items-start">
                      
                      <div class="d-flex flex-column">
                          <div class="link">Dashboard</div>
                          <div class="link-desc"></div>
                      </div>
                  </a> </li>
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
  		
      
      <div class="row">
      <div class="d-flex justify-content-between align-items-center mb-3">
     <h4 style="color: aliceblue;" class="text-right"></h4> 
    
      
       <security:authorize access="hasRole('ADMIN')"> 
     <div><a  class="btn btn-primary" href="/addmodule">Add Module</a></div> 
     </security:authorize> 
      </div>
         <div style="overflow-x: auto;">
        <table class="table bg-light ">
            <thead>
              <tr >
                <th scope="col">#</th>
                <th scope="col">Name</th>
                <th scope="col">Details</th>
                <th scope="col">Module hours</th>
                <security:authorize access="hasRole('ADMIN')"> 
                <th scope="col">Edit</th>
                <th scope="col">Delete</th>
                </security:authorize> 
              
                
               

              </tr>
            </thead>
            <tbody>
                <c:forEach items="${module}" var="module" varStatus="counter">
              <tr>
                <th scope="row">${counter.count}</th>
                <td>${module.moduleName }</td>
                <td>${module.module_details}</td>
                <td>${module.module_hours}</td>
                <security:authorize access="hasRole('ADMIN')"> 
                <td><a class="btn btn-primary" href="/updatemodule?id=${module.module_id}">Edit</a></td>  
   				<td><a class="btn btn-danger" href="/deletemodule?id=${module.module_id}">Delete</a></td>  
   				</security:authorize> 
              </tr>
            </c:forEach>             
            </tbody>
          </table>
     <%--For Pagination --%>
         <div style="text-align:center">
    <%--For displaying Previous link --%>
    <c:if test="${pageNumber gt 1}">
        <a href="modulepage?pageNumber=${pageNumber - 1}">Previous</a>
    </c:if>
    <c:forEach begin="1" end="${numberOfPages}" var="i">
        <c:choose>
            <c:when test="${i!=pageNumber}">
           		 <a  href="modulepage?pageNumber=<c:out value="${i}"/>"><c:out value="${i}"/></a>
            </c:when>
        	<c:otherwise>
        		<c:out value="${i}"/>
        	</c:otherwise>        
        </c:choose>       
    </c:forEach>  
    <%--For displaying Next link --%>
    <c:if test="${pageNumber lt numberOfPages}">
        <a href="modulepage?pageNumber=${pageNumber + 1}">Next</a>
    </c:if>
         </div>
       <%--End of pagination --%>
             
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