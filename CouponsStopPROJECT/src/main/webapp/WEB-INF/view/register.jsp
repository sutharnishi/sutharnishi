<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8"/>
  <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
  <meta name="description" content=""/>
  <meta name="author" content=""/>
  <title>CouponsStop</title>
  <!--favicon-->
  <link rel="icon" href="assets/images/favicon.ico" type="image/x-icon">
  <!-- Bootstrap core CSS-->
  <link href="adminResources/css/bootstrap.min.css" rel="stylesheet"/>
  <!-- animate CSS-->
  <link href="adminResources/css/animate.css" rel="stylesheet" type="text/css"/>
  <!-- Icons CSS-->
  <link href="adminResources/css/icons.css" rel="stylesheet" type="text/css"/>
  <!-- Custom Style-->
  <link href="adminResources/css/app-style.css" rel="stylesheet"/>
  
</head>

<body>
 <!-- Start wrapper-->
 <div id="wrapper">
	<div class="card border-primary border-top-sm border-bottom-sm card-authentication1 mx-auto my-4 animated bounceInDown">
		<div class="card-body">
		 <div class="card-content p-2">
		 	<div class="text-center">
		 		<img src="adminResources/images/logo-icon.png">
		 	</div>
		  <div class="card-title text-uppercase text-center py-3">Sign Up</div>
		  <%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
		  
		    <f:form action="insert" modelAttribute="registerVO" method="post">
		    
			  <div class="form-group">
			   <div class="position-relative has-icon-right">
				  <label for="exampleInputName" class="sr-only">Name</label>
				  <f:input path="fullName" class="form-control form-control-rounded" required="required" placeholder="FullName"/>
				  <div class="form-control-position">
					  <i class="icon-user"></i>
				  </div>
			   </div>
			  </div>
			  
			  
			  <div class="form-group">
			   <div class="position-relative has-icon-right">
				  <label for="exampleInputName" class="sr-only">Contact</label>
				  <f:input path="mobileNumber"  required="required" class="form-control form-control-rounded" placeholder="mobileNumber" />
				  
				  <div class="form-control-position">
					  <i class="icon-user"></i>
				  </div>
			   </div>
			  </div>
	
		<div class="form-group">
			   <div class="position-relative has-icon-right">
				  <label for="exampleInputName" class="sr-only">Address</label>
				  <f:input path="address" class="form-control form-control-rounded" placeholder="Address"  required="required" />
				  <div class="form-control-position">
					  <i class="icon-user"></i>
				  </div>
			   </div>
			  </div>
			  
			  <div class="form-group">
			   <div class="position-relative has-icon-right">
				  <label for="exampleInputEmailId" class="sr-only">Email ID</label>
				  <f:input path="loginVO.username"  required="required"  class="form-control form-control-rounded" placeholder="Email ID"/>
				  <div class="form-control-position">
					  <i class="icon-envelope-open"></i>
				  </div>
			   </div>
			  </div>
			  <div class="form-group">
			   <div class="position-relative has-icon-right">
				  <label for="exampleInputPassword" class="sr-only">Password</label>
				  <f:input path="loginVO.password" type="password" required="required"  class="form-control form-control-rounded" placeholder="Password"/>
				  
				  <div class="form-control-position">
					  <i class="icon-lock"></i>
				  </div>
			   </div>
			  </div>
			  
			 <button type="submit" class="btn btn-primary shadow-primary btn-round btn-block waves-effect waves-light">Sign Up</button>
			  <div class="text-center pt-3">
				<p>or Sign up with</p>
				<a href="javascript:void()" class="btn-social btn-social-circle btn-facebook waves-effect waves-light m-1"><i class="fa fa-facebook"></i></a>
				<a href="javascript:void()" class="btn-social btn-social-circle btn-google-plus waves-effect waves-light m-1"><i class="fa fa-google-plus"></i></a>
				<a href="javascript:void()" class="btn-social btn-social-circle btn-twitter waves-effect waves-light m-1"><i class="fa fa-twitter"></i></a>
				<hr>
				<p class="text-muted">Already have an account? <a href="/"> Sign In here</a></p>
			  </div>
			 </f:form>
		   </div>
		  </div>
	     </div>
    
     <!--Start Back To Top Button-->
    <a href="javaScript:void();" class="back-to-top"><i class="fa fa-angle-double-up"></i> </a>
    <!--End Back To Top Button-->
	</div><!--wrapper-->
	
  <!-- Bootstrap core JavaScript-->
  <script src="adminResources/js/jquery.min.js"></script>
  <script src="adminResources/js/popper.min.js"></script>
  <script src="adminResources/js/bootstrap.min.js"></script>
  
</body>
</html>
    