<%--
  Created by IntelliJ IDEA.
  User: Sadiq
  Date: 7/2/17
  Time: 1:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
  <title>Login - Swimming Pool</title>
  <link rel="icon" type="image/png" sizes="16x16" href="plugins/images/favicon.png">

  <link href="bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
  <link href="css/login.css" rel="stylesheet" >
  <script src="js/jquery-3.1.1.js" type="text/javascript"></script>


   <script type="text/javascript">
       $(function(){

           history.pushState(null, null, 'login.jsp');
           window.addEventListener('popstate', function(event) {
               history.pushState(null, null, 'login.jsp');
           });

       }) ;
    </script>

</head>

<body style="background-color: #14141f;">
<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <div class="panel panel-login">

                <div class="panel-heading">
                    <div class="row">
                        <div class="col-xs-12">
                            <a href="#" class="active" id="login-form-link">Sign In</a>
                        </div>
                    </div>
                    <hr>
                </div>

                <div class="panel-body">
                    <div class="row">
                        <div class="col-lg-12">

                            <form id="login-form" action="ls?action=login" method="post" role="form" style="display: block;">
                                <c:if test="${not empty message}">
                                  <div  class="text-center">
                                    <h3 class="text-warning">${message}</h3>
                                  </div>
                                </c:if>

                                <div class="input-group">
                                    <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                    <input type="text"  name="username" id="username_login"  class="form-control" placeholder="Username">
                                </div>
                                <br>
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                                    <input type="password" name="password" id="password_login"  class="form-control"  placeholder="Password">
                                </div>
                                <br>

                                <div class="form-group">
                                    <div class="row">
                                        <div class="col-sm-6 col-sm-offset-3" >
                                            <input type="submit" name="login-submit" id="login-submit" tabindex="4" class="form-control btn btn-login" value="Log In">
                                        </div>
                                    </div>
                                </div>

                            </form>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>