<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Swimming Pool</title>
    <link rel="icon" type="image/png" sizes="16x16" href="plugins/images/favicon.png">
    <!-- Bootstrap Core CSS -->
    <link href="bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Menu CSS -->
    <link href="plugins/bower_components/sidebar-nav/dist/sidebar-nav.min.css" rel="stylesheet">
    <!-- toast CSS -->
    <link href="plugins/bower_components/toast-master/css/jquery.toast.css" rel="stylesheet">
    <!-- morris CSS -->
    <link href="plugins/bower_components/morrisjs/morris.css" rel="stylesheet">
    <!-- chartist CSS -->
    <link href="plugins/bower_components/chartist-js/dist/chartist.min.css" rel="stylesheet">
    <link href="plugins/bower_components/chartist-plugin-tooltip-master/dist/chartist-plugin-tooltip.css" rel="stylesheet">
    <!-- animation CSS -->
    <link href="css/animate.css" rel="stylesheet">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <!-- Custom CSS -->
    <link href="css/style.css" rel="stylesheet">
    <!-- color CSS -->
    <link href="css/colors/default.css" id="theme" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->

    <script src="js/jquery-3.1.1.js" type="text/javascript"></script>
    <script src="js/jquery-ui.js" type="text/javascript"></script>
    <script src="js/main.js" type="text/javascript"></script>


    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

    <script type="text/javascript">

        history.pushState(null, null, 'index.jsp');
        window.addEventListener('popstate', function(event) {
            history.pushState(null, null, 'index.jsp');
        });

        $(document).ready(function(){

          var glob_search_button = 'swimmer' ;
          get_category_combo();
          $('#register_button_id').click(function(){
                $('#empty_div').hide();
                $('#index_div').show();
                 get_category_combo();
          })   ;

          $('#payment_button_id').click(function(){
              $('#index_div').hide();
              $('#empty_div').load('view/pay.jsp');
              $('#empty_div').show();
               get_swimmer_combo();
          })   ;

          $('#add_worker_button_id').click(function(){
              glob_search_button = 'worker' ;
              $('#index_div').hide();
              $('#empty_div').load('view/add_worker.jsp');
              $('#empty_div').show();
            })   ;

          $('#swimmers_button_id').click(function(){
              glob_search_button = 'swimmer' ;
              get_swimmers();
          })   ;

          $('#payments_button_id').click(function(){
              glob_search_button = 'payment' ;
              get_payments();
          })   ;

          $('#coming_button_id').click(function(){
              glob_search_button = 'coming' ;
              get_comings();
          })   ;

          $('#workers_button_id').click(function(){
              glob_search_button = 'worker' ;
          })

          $('#view_workers_button_id').click(function(){
              glob_search_button = 'worker' ;
              get_workers();
          })

          $('#search_id').keyup(function(){
              switch (glob_search_button)
              {
                  case 'swimmer': search_sw($('#search_id').val()); break;
                  case 'payment': search_payment($('#search_id').val()); break;
                  case 'coming':  search_coming($('#search_id').val());break;
                  case 'worker':  search_worker($('#search_id').val());break;
                  default : alert('Choose table !') ;
              }
          })

          $('#register_id').click(function(){
              register_sw();
          })  ;

          $('#dob_id').datepicker({
                changeMonth:true,
                changeYear: true
          })  ;
        })
    </script>

    <style type="text/css">
        .menu_btn {
            letter-spacing: 2px;
            font-family: serif;
            font-size: 18px;
            margin-top: 8px;
        }

        .hr {
            margin-top: 0.5em;
            margin-bottom: 0.2em;
            margin-left: auto;
            margin-right: auto;
            border-style: solid;
            border-width: 0.4px;
            border-color: #2f323e;
        }
    </style>
</head>

<body class="fix-header">

<div class="preloader">
    <svg class="circular" viewBox="25 25 50 50">
        <circle class="path" cx="50" cy="50" r="20" fill="none" stroke-width="2" stroke-miterlimit="10" />
    </svg>
</div>

<div id="wrapper">
<!-- Topbar header - style you can find in pages.scss -->
<nav class="navbar navbar-default navbar-static-top m-b-0">
    <div class="navbar-header">
        <div class="top-left-part">
                <!-- Logo icon image, you can use font-icon also -->
                <%--<b>
                <!--This is dark logo icon--><img src="plugins/images/admin-logo.png" alt="home" class="dark-logo" />
                <!--This is light logo icon--><img src="plugins/images/admin-logo-dark.png" alt="home" class="light-logo" />
                </b>--%>
                <a class="light-logo" style="color: #2f4f4f; margin-left: 20px; letter-spacing: 2px;" ><b><i>Swimming Pool</i></b></a>
        </div>

        <ul class="nav navbar-top-links navbar-right pull-right">

            <li>
                <form role="search" class="app-search hidden-sm hidden-xs m-r-10">
                    <input type="text"  id="search_id" title="Search by name, surname or code" placeholder="Search..." class="form-control">
                    <a><i class="fa fa-search"></i></a>
                </form>
            </li>

            <li class="top-left">
                <a href="#" title="${login.role}"><b><i>${login.fullname}</i></b></a>
            </li>
        </ul>
    </div>
    <!-- /.navbar-header -->
    <!-- /.navbar-top-links -->
    <!-- /.navbar-static-side -->
</nav>
<!-- End Top Navigation -->
<!-- Left Sidebar - style you can find in sidebar.scss  -->
<div class="navbar-default sidebar" role="navigation">
    <div class="sidebar-nav slimscrollsidebar">
        <div class="sidebar-head">
            <h3><span class="fa-fw open-close"><i class="ti-close ti-menu"></i></span> <span class="hide-menu">Navigation</span></h3>
        </div>
        <ul class="nav" id="side-menu">

            <li style="padding: 70px 0 0;">
                <a id="register_button_id" href="#" class="waves-effect menu_btn"><i class="fa  fa-user-plus fa-fw" aria-hidden="true" ></i>Registration</a>
            </li>
            <li>
                <a id="payment_button_id" href="#" class="waves-effect menu_btn"><i class="fa  fa-dollar fa-fw" aria-hidden="true"></i>Pay</a>
            </li>

            <li>
                <a id="swimmers_button_id" href="#" class="waves-effect menu_btn"><i class="fa fa-user fa-fw" aria-hidden="true"></i>Swimmers</a>
            </li>
            <li>
                <a id="payments_button_id" href="#" class="waves-effect menu_btn"><i class="fa fa-bar-chart-o fa-fw " aria-hidden="true"></i>Payments</a>
            </li>
            <li>
                <a id="coming_button_id"  href="#" class="waves-effect menu_btn"><i class="fa  fa-clock-o fa-fw" aria-hidden="true"></i>Entries</a>
            </li>

            <c:if test="${login.role=='admin'}">
            <li>
                <a id="workers_button_id" href="javascript:;" data-toggle="collapse" data-target="#demo" class="menu_btn"><i class="fa fa-group fa-fw"></i> Workers</a>
                <ul  class="collapse" style="list-style-type: none;">
                    <li>
                        <a id="view_workers_button_id" href="#" class="waves-effect menu_btn"><i class="fa fa-hand-o-right fa-fw" aria-hidden="true"></i>Show</a>
                    </li>
                    <li>
                        <a id="add_worker_button_id" href="#" class="waves-effect menu_btn"><i class="fa fa-plus fa-fw " aria-hidden="true"></i>Add</a>
                    </li> <br>
                </ul>
            </li>
            </c:if>

            <hr  noshade class="hr" >

            <li>
                <a  href="logout.jsp" class="waves-effect menu_btn" style="color:red; "><i class="glyphicon glyphicon-log-out fa-fw " aria-hidden="true"></i>Log out</a>
            </li>
        </ul>
    </div>
</div>
<!-- End Left Sidebar -->

<!-- Page Content -->
<div id="page-wrapper">
 <div id="index_div">
    <div class="container-fluid" >

        <div class="row bg-title">
            <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                <p  style="font-size: 22px; font-style: italic;"> <code>  Registration </code></p>
            </div>
            <div class="col-lg-9 col-sm-8 col-md-8 col-xs-12">
                <ol class="breadcrumb">
                    <li><a href="#"> Swimming Pool </a></li>
                    <li class="active"> Registration </li>
                </ol>
            </div>
        </div>

        <div class="row">
            <div class="col-md-12 col-xs-12">
                <div class="white-box">
                    <br>
                    <form class="form-horizontal form-material">
                        <div style="text-align: center">
                            <h3 id="reg_warning_id" style="color: red; font-style: italic; text-align: center; display: none;">  Please, fill the required fields!</h3>
                        </div>

                        <div class="form-group">
                            <label class="col-md-12" style="display: inline-block">Name * </label>

                            <div class="col-md-12">
                                <input type="text" placeholder="Eli" class="form-control form-control-line" name="name" id="name_id">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-md-12">Surname *</label>
                            <div class="col-md-12">
                                <input type="text" placeholder="Eliyev" class="form-control form-control-line" name="surname" id="surname_id">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-md-12">Phone number * </label>
                            <div class="col-md-12">
                                <input type="tel" placeholder="055 7654321" class="form-control form-control-line" name="phone" id="phone_id">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="email_id" class="col-md-12">Email </label>
                            <div class="col-md-12">
                                <input type="email" placeholder="example@admin.com" class="form-control form-control-line"  name="email" id="email_id">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="dob_id" class="col-md-12">Date of Birth * </label>
                            <div class="col-md-12">
                                <input type="text" placeholder="yyyy-mm-dd"  class="form-control form-control-line"  name="dob" id="dob_id">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-12">Gender * </label>
                            <div class="col-sm-12">
                                <select id="gender_id" name="gender" class="form-control form-control-line">
                                    <option value="0">Choose :</option>
                                    <option value="1">Male</option>
                                    <option value="2">Female</option>
                                </select>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-12">Category *</label>
                            <div class="col-sm-12">
                                <select id="category_id" name="category" class="form-control form-control-line">
                                </select>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-sm-3" style="float: right;">
                                <input type="button" class="btn btn-success" value="Save" style="float: right; width: 170px;"  id="register_id">
                            </div>

                            <div class="col-sm-3" style="float: right;">
                                <input type="reset" class="btn btn-info" value="Clean" style="float: right; width: 170px;">
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>  <!-- /.container-fluid -->
    <footer class="footer text-center"><i> 2018 &copy; Coded by <b>Sadiq Eyvazov</b> </i></footer>
 </div>
 <div id="empty_div" style="display: none;"></div>

</div>  <!-- End Page Content -->
</div>  <!-- End Wrapper -->
<!-- All Jquery -->

<script src="bootstrap/dist/js/bootstrap.min.js"></script>
<!-- Menu Plugin JavaScript -->
<script src="plugins/bower_components/sidebar-nav/dist/sidebar-nav.min.js"></script>
<!--slimscroll JavaScript -->
<script src="js/jquery.slimscroll.js"></script>
<!--Wave Effects -->
<script src="js/waves.js"></script>
<!--Counter js -->
<script src="plugins/bower_components/waypoints/lib/jquery.waypoints.js"></script>
<script src="plugins/bower_components/counterup/jquery.counterup.min.js"></script>
<!-- chartist chart -->
<script src="plugins/bower_components/chartist-js/dist/chartist.min.js"></script>
<script src="plugins/bower_components/chartist-plugin-tooltip-master/dist/chartist-plugin-tooltip.min.js"></script>
<!-- Sparkline chart JavaScript -->
<script src="plugins/bower_components/jquery-sparkline/jquery.sparkline.min.js"></script>
<!-- Custom Theme JavaScript -->
<script src="js/custom.min.js"></script>
<script src="js/dashboard1.js"></script>
<%--<script src="plugins/bower_components/toast-master/js/jquery.toast.js"></script>--%>
</body>

</html>

