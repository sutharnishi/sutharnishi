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
  <link href="<%=request.getContextPath()%>/adminResources/css/bootstrap.min.css" rel="stylesheet"/>
  <!-- animate CSS-->
  <link href="<%=request.getContextPath()%>/adminResources/css/animate.css" rel="stylesheet" type="text/css"/>
  <!-- Icons CSS-->
  <link href="<%=request.getContextPath()%>/adminResources/css/icons.css" rel="stylesheet" type="text/css"/>
  <!-- Custom Style-->
  <link href="<%=request.getContextPath()%>/adminResources/css/app-style.css" rel="stylesheet"/>
  
</head>

<body>
 <!-- Start wrapper-->
 <div id="wrapper">
	<div class="card border-primary border-top-sm border-bottom-sm card-authentication1 mx-auto my-5 animated bounceInDown">
		<div class="card-body">
		 <div class="card-content p-2">
		 	<div class="text-center">
		 		<img src="<%=request.getContextPath()%>/adminResources/images/logo-icon.png">
		 	</div>
		  <div class="card-title text-uppercase text-center py-3">Sign In</div>
		    
		    <form action="j_spring_security_check" method="post">
			 
			  <div class="form-group">
			   <div class="position-relative has-icon-right">
				  <label for="exampleInputUsername" class="sr-only">Username</label>
				  <input type="text" id="exampleInputUsername" name="username" class="form-control form-control-rounded" placeholder="Username">
				  <div class="form-control-position">
					  <i class="icon-user"></i>
				  </div>
			   </div>
			  </div>
			  <div class="form-group">
			   <div class="position-relative has-icon-right">
				  <label for="exampleInputPassword" class="sr-only">Password</label>
				  <input type="password" id="exampleInputPassword" name="password" class="form-control form-control-rounded" placeholder="Password">
				  <div class="form-control-position">
					  <i class="icon-lock"></i>
				  </div>
			   </div>
			  </div>
			<div class="form-row mr-0 ml-0">
			 <div class="form-group col-6">
			   <div class="demo-checkbox">
                <input type="checkbox" id="user-checkbox" class="filled-in chk-col-primary" checked="" />
                <label for="user-checkbox">Remember me</label>
			  </div>
			 </div>
			 <div class="form-group col-6 text-right">
			  <a href="step1">Forget Password</a>
			 </div>
			</div>
			 <button type="submit" class="btn btn-primary shadow-primary btn-round btn-block waves-effect waves-light">Sign In</button></br></br>
			  <a href="register">Don't have an account? Create new </a></br></br>
			 
			 </form>
		   </div>
		  </div>
	     </div>
    
     <!--Start Back To Top Button-->
    <a href="javaScript:void();" class="back-to-top"><i class="fa fa-angle-double-up"></i> </a>
    <!--End Back To Top Button-->
	</div><!--wrapper-->
	
  <!-- Bootstrap core JavaScript-->
  <script src="<%=request.getContextPath()%>/adminResources/js/jquery.min.js"></script>
  <script src="<%=request.getContextPath()%>/adminResources/js/popper.min.js"></script>
  <script src="<%=request.getContextPath()%>/adminResources/js/bootstrap.min.js"></script>
  
</body>
</html>
    