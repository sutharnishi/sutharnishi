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
  <!-- Vector CSS -->
  <link href="<%=request.getContextPath()%>/adminResources/css/jquery-jvectormap-2.0.2.css" rel="stylesheet" />
  <!-- simplebar CSS-->
  <link href="<%=request.getContextPath()%>/adminResources/css/simplebar.css" rel="stylesheet"/>
  <!-- Bootstrap core CSS-->
  <link href="<%=request.getContextPath()%>/adminResources/css/bootstrap.min.css" rel="stylesheet"/>
  <!-- animate CSS-->
  <link href="<%=request.getContextPath()%>/adminResources/css/animate.css" rel="stylesheet" type="text/css"/>
  <!-- Icons CSS-->
  <link href="<%=request.getContextPath()%>/adminResources/css/icons.css" rel="stylesheet" type="text/css"/>
  <!-- Sidebar CSS-->
  <link href="<%=request.getContextPath()%>/adminResources/css/sidebar-menu.css" rel="stylesheet"/>
  <!-- Custom Style-->
  <link href="<%=request.getContextPath()%>/adminResources/css/app-style.css" rel="stylesheet"/>
  
</head>

<body>

<!-- Start wrapper-->
 <div id="wrapper">
 
  <!--Start sidebar-wrapper-->
   <div id="sidebar-wrapper" data-simplebar="" data-simplebar-auto-hide="true">
     <div class="brand-logo">
      <a href="/">
       <img src="<%=request.getContextPath()%>/adminResources/images/logo-icon.png" class="logo-icon" alt="logo icon">
       <h5 class="logo-text">CouponsStop</h5>
     </a>
	 </div>
	 <jsp:include page="menu.jsp"></jsp:include>	 
   </div>
   <!--End sidebar-wrapper-->

<!--Start topbar header-->
<header class="topbar-nav">
 
 <jsp:include page="header.jsp"></jsp:include>
 
 </header>
<!--End topbar header-->
  
<div class="clearfix"></div>
	
  <div class="content-wrapper">
    <div class="container-fluid">

      <!--Start Dashboard Content-->
	  
      <div class="row mt-3">
        <div class="col-12 col-lg-6 col-xl-3">
          <div class="card border-info border-left-sm">
            <div class="card-body">
              <div class="media">
              <div class="media-body text-left">
                <h4 class="text-info">4500</h4>
                <span>Total Orders</span>
              </div>
              <div class="align-self-center w-circle-icon rounded-circle gradient-scooter">
                <i class="icon-basket-loaded text-white"></i></div>
            </div>
            </div>
          </div>
        </div>
        <div class="col-12 col-lg-6 col-xl-3">
          <div class="card border-danger border-left-sm">
            <div class="card-body">
              <div class="media">
               <div class="media-body text-left">
                <h4 class="text-danger">785</h4>
                <span>Total Offers</span>
              </div>
               <div class="align-self-center w-circle-icon rounded-circle gradient-bloody">
                <i class="icon-wallet text-white"></i></div>
            </div>
            </div>
          </div>
        </div>
        <div class="col-12 col-lg-6 col-xl-3">
          <div class="card border-success border-left-sm">
            <div class="card-body">
              <div class="media">
              <div class="media-body text-left">
                <h4 class="text-success">875</h4>
                <span>Total Coupons</span>
              </div>
              <div class="align-self-center w-circle-icon rounded-circle gradient-quepal">
                <i class="icon-pie-chart text-white"></i></div>
            </div>
            </div>
          </div>
        </div>
        <div class="col-12 col-lg-6 col-xl-3">
          <div class="card border-warning border-left-sm">
            <div class="card-body">
              <div class="media">
              <div class="media-body text-left">
                <h4 class="text-warning">8400</h4>
                <span>Total Users</span>
              </div>
              <div class="align-self-center w-circle-icon rounded-circle gradient-blooker">
                <i class="icon-user text-white"></i></div>
            </div>
            </div>
          </div>
        </div>
      </div><!--End Row-->
		  
		  
      <!--End Row-->

      <!--End Row-->

      <!--End Row-->

      <!--End Row-->
	  
       <!--End Dashboard Content-->

    </div>
    <!-- End container-fluid-->
    
    </div><!--End content-wrapper-->
   <!--Start Back To Top Button-->
    <a href="javaScript:void();" class="back-to-top"><i class="fa fa-angle-double-up"></i> </a>
    <!--End Back To Top Button-->
	
	<!--Start footer-->
	<footer class="footer">
      <div class="container">
        <div class="text-center">
        	 COUPONS STOP 
        </div>
      </div>
    </footer>
	<!--End footer-->
   
  </div><!--End wrapper-->

  <!-- Bootstrap core JavaScript-->
  <script src="<%=request.getContextPath()%>/adminResources/js/jquery.min.js"></script>
  <script src="<%=request.getContextPath()%>/adminResources/js/popper.min.js"></script>
  <script src="<%=request.getContextPath()%>/adminResources/js/bootstrap.min.js"></script>
	
  <!-- simplebar js -->
  <script src="<%=request.getContextPath()%>/adminResources/js/simplebar.js"></script>
  <!-- waves effect js -->
  <script src="<%=request.getContextPath()%>/adminResources/js/waves.js"></script>
  <!-- sidebar-menu js -->
  <script src="<%=request.getContextPath()%>/adminResources/js/sidebar-menu.js"></script>
  <!-- Custom scripts -->
  <script src="<%=request.getContextPath()%>/adminResources/js/app-script.js"></script>
  
  <!-- Vector map JavaScript -->
  <script src="<%=request.getContextPath()%>/adminResources/js/jquery-jvectormap-2.0.2.min.js"></script>
  <script src="<%=request.getContextPath()%>/adminResources/js/jquery-jvectormap-world-mill-en.js"></script>
  <!-- Chart js -->
  <script src="<%=request.getContextPath()%>/adminResources/js/Chart.min.js"></script>
  <!-- Index js -->
  <script src="<%=request.getContextPath()%>/adminResources/js/index.js"></script>
  
</body>
</html>
    