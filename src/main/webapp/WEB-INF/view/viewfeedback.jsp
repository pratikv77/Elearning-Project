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
        <h4 style="color: aliceblue;" class="text-right">Feedback</h4> 
    </div>
      <div class="row">
         <div style="overflow-x: auto;">
        <table class="table bg-light ">
            <thead>
              <tr >
                <th scope="col">#</th>
                <th scope="col">Name of student</th>
                 <th scope="col">Module</th>
                <th scope="col">Feedback</th>
                <th scope="col">Edit</th>
                <th scope="col">Delete</th>
              
                
               

              </tr>
            </thead>
            <tbody>
                <c:forEach items="${feedback}" var="feedbackobj" varStatus="counter">
              <tr>
                <th scope="row">${counter.count}</th>
                <td>${feedbackobj.studentInfoTable.studentFname}</td>
                <td>${feedbackobj.moduleTable.moduleName}</td>
                <td>${feedbackobj.feedback}</td>
               <td><a class="btn btn-primary" href="/updatefeedback?id=${feedbackobj.feedbackId}">Edit</a></td>  
   				<td><a class="btn btn-danger" href="/deletefeedback?id=${feedbackobj.feedbackId}">Delete</a></td>  
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