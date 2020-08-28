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
  <link href="<%=request.getContextPath()%>//css/bootstrap.min.css" rel="stylesheet"/>
  <!-- animate CSS-->
  <link href="<%=request.getContextPath()%>//css/animate.css" rel="stylesheet" type="text/css"/>
  <!-- Icons CSS-->
  <link href="<%=request.getContextPath()%>//css/icons.css" rel="stylesheet" type="text/css"/>
  <!-- Custom Style-->
  <link href="<%=request.getContextPath()%>//css/app-style.css" rel="stylesheet"/>
  
</head>

<body>
 <!-- Start wrapper-->
 <div id="wrapper">
	<div class="card border-primary border-top-sm border-bottom-sm card-authentication1 mx-auto my-4 animated bounceInDown">
		<div class="card-body">
		 <div class="card-content p-2">
		 	<div class="text-center">
		 		<img src="<%=request.getContextPath()%>//images/logo-icon.png">
		 	</div>
		  <div class="card-title text-uppercase text-center py-3">User Sign Up</div>
		    <form>
			  <div class="form-group">
			   <div class="position-relative has-icon-right">
				  <label for="exampleInputName" class="sr-only">Name</label>
				  <input type="text" id="exampleInputName" class="form-control form-control-rounded" placeholder="Name">
				  <div class="form-control-position">
					  <i class="icon-user"></i>
				  </div>
			   </div>
			  </div>
			  
			  
			  <div class="form-group">
			   <div class="position-relative has-icon-right">
				  <label for="exampleInputEmailId" class="sr-only">Email ID</label>
				  <input type="text" id="exampleInputEmailId" class="form-control form-control-rounded" placeholder="Email ID">
				  <div class="form-control-position">
					  <i class="icon-envelope-open"></i>
				  </div>
			   </div>
			  </div>
			  
			  <div class="form-group">
			   <div class="position-relative has-icon-right">
				  <label for="exampleInputName" class="sr-only">contact</label>
				  <input type="text" id="exampleInputName" class="form-control form-control-rounded" placeholder="contact">
				  <div class="form-control-position">
					  <i class="icon-user"></i>
				  </div>
			   </div>
			  </div>
			  
			  <div class="form-group">
			   <div class="position-relative has-icon-right">
				  <label for="exampleInputName" class="sr-only">Address</label>
				  <input type="text" id="exampleInputName" class="form-control form-control-rounded" placeholder="Address">
				  <div class="form-control-position">
					  <i class="icon-user"></i>
				  </div>
			   </div>
			  </div>
			  <div class="form-group">
			   <div class="position-relative has-icon-right">
				  <label for="exampleInputPassword" class="sr-only">Password</label>
				  <input type="text" id="exampleInputPassword" class="form-control form-control-rounded" placeholder="Password">
				  <div class="form-control-position">
					  <i class="icon-lock"></i>
				  </div>
			   </div>
			  </div>
			  <div class="form-group">
			   <div class="position-relative has-icon-right">
				  <label for="exampleInputRetryPassword" class="sr-only">Retry Password</label>
				  <input type="password" id="exampleInputRetryPassword" class="form-control form-control-rounded" placeholder="Retry Password">
				  <div class="form-control-position">
					  <i class="icon-lock"></i>
				  </div>
			   </div>
			  </div>
			 <a href="login.jsp"><button type="button" class="btn btn-primary shadow-primary btn-round btn-block waves-effect waves-light">Sign Up</button></a>
			  <div class="text-center pt-3">
				<hr>
				<p class="text-muted">Already have an account? <a href="login.jsp"> Sign In here</a></p>
			  </div>
			 </form>
		   </div>
		  </div>
	     </div>
    
     <!--Start Back To Top Button-->
    <a href="javaScript:void();" class="back-to-top"><i class="fa fa-angle-double-up"></i> </a>
    <!--End Back To Top Button-->
	</div><!--wrapper-->
	
  <!-- Bootstrap core JavaScript-->
  <script src="<%=request.getContextPath()%>//js/jquery.min.js"></script>
  <script src="<%=request.getContextPath()%>//js/popper.min.js"></script>
  <script src="<%=request.getContextPath()%>//js/bootstrap.min.js"></script>
  
</body>
</html>
    