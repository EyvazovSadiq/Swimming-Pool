<%--
  Created by IntelliJ IDEA.
  User: Sadiq
  Date: 6/27/17
  Time: 3:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container-fluid">
    <div class="row bg-title">
        <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
            <p class="page-title" style="font-size: 22px; font-style: italic;"> <code>  Registration </code></p>
        </div>
        <div class="col-lg-9 col-sm-8 col-md-8 col-xs-12">

            <ol class="breadcrumb">
                <li><a href="#">Main</a></li>
                <li class="active">Registration</li>
            </ol>
        </div>

    </div>
    <div class="row">
        <div class="col-sm-12">
            <div class="white-box" style="background-color: #2cc642; text-align: center;">
                <c:if test="${not empty message}">
                 <h2 style="color: #ffffff; font-style: italic;"> <i class="fa fa-smile-o fa-fw" aria-hidden="true"></i>${message}</h2>
                </c:if>
                <c:if test="${not empty invalid}">
                  <h2 style="color: #ffffff; font-style: italic;"> <i class="fa fa-frown-o fa-fw" aria-hidden="true"></i>${invalid}</h2>
                </c:if>

            </div>
        </div>
    </div>
</div>
<footer class="footer text-center"> <i> 2018 &copy; Coded by <b>Sadiq Eyvazov</b> </i></footer>