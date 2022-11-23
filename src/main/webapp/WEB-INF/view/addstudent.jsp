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
          action="savestudent" modelAttribute="student">
      <div class="container rounded mt-5 mb-5">
        <div class="row">
            <div class="col-md-3 border-right">
                <div class="d-flex flex-column align-items-center text-center p-3 py-5"><img class="rounded-circle mt-5" width="150px" src="https://st3.depositphotos.com/15648834/17930/v/600/depositphotos_179308454-stock-illustration-unknown-person-silhouette-glasses-profile.jpg"></div>
                 <input class="count-lable" type="file" id="studentImage" name="studentImage" accept="image/*">
                  
            </div>
            <div class="col-md-7 border-right">
                <div class="p-3 py-5">
                    <div class="d-flex justify-content-between align-items-center mb-3">
                        <h4 style="color: aliceblue;" class="text-right">Student Profile</h4>
                    </div>
                    <div class="row mt-3">
                        <div class="col-md-6"><label class="labels">First Name</label><input name="studentFname" id="studentFname" type="text" class="form-control" placeholder="Firstname" value=""></div> <br><br>
                        <div class="col-md-6"><label class="labels">Middle Name</label><input name="studentMiddle" id="studentMiddle" type="text" class="form-control" value="" placeholder="Middlename"></div> <br><br>
                        <div class="col-md-6"><label class="labels">Last Name</label><input name="studentLname" id="studentLname" type="text" class="form-control" value="" placeholder="Lastname"></div> <br><br>
                         <div class="col-md-6"><label class="labels">Date of Birth</label><input name="studentDateOfBirth" id="studentDateOfBirth" type="date" class="form-control"  value=""></div>
                        
                        <div class="col-md-12"><label class="labels">Gender</label>
                          <input type="radio" value="Male" name="studentGender" id="studentGender"><span style="color: floralwhite;">Male</span>   
                          <input type="radio" value="Female"name="studentGender" id="studentGender"><span style="color:floralwhite;">Female</span>
                          <input type="radio" value="Other" name="studentGender" id="studentGender"><span style="color: floralwhite;">Others</span>  
                        </div> <br><br>
                        <div class="col-md-12"><label class="labels">Education</label><input name="studentEducation" id="studentEducation" type="text" class="form-control" placeholder="Enter past Qualification" value=""></div> <br><br>
                        <div class="col-md-12"><label class="labels">Mobile Number</label><input name="studentMobileNo" id="studentMobileNo" type="text" class="form-control" placeholder="enter phone number" value=""></div> <br><br>
                        <div class="col-md-12"><label class="labels">Address</label><input name="studentAddress" id="studentAddress" type="text" class="form-control" placeholder="enter address" value=""></div> <br><br>
                        <div class="col-md-12"><label class="labels">Pincode</label><input name="studentPincode" id="studentPincode" type="text" class="form-control" placeholder="enter Pincode" value=""></div> <br><br>
                        <div class="col-md-12"><label class="labels">City</label><input name="studentCity" id="studentCity" type="text" class="form-control" placeholder="enter City" value=""></div> <br><br>
                        
                        
                    </div>
                    <div class="row mt-3">
                        <div class="col-md-6"><label class="labels">Username</label><input name="studentEmail" id="studentEmail" type="text" class="form-control" placeholder="enter Username" value=""></div>
                        <div class="col-md-6"><label class="labels">Password</label><input name="studentPassword" id="studentPassword" type="text" class="form-control" value="" placeholder="enter Password"></div>
                        <div class="col-md-6"><label class="labels">PRN Number</label><input name="studentPrnNo" id="studentPrnNo" type="text" class="form-control" value="" placeholder="enter PRN Number"></div>
                    
                      </div>
                    <div class="mt-5 text-center"><button class="btn btn-primary profile-button" type="submit">Save Profile</button></div>
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