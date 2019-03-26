<%--
  Created by IntelliJ IDEA.
  User: Sadiq
  Date: 6/24/17
  Time: 3:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container-fluid">
    <div class="row bg-title">
        <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
       <p class="page-title" style="font-size: 22px; font-style: italic;"> <code>  Payments </code></p>
        </div>
        <div class="col-lg-9 col-sm-8 col-md-8 col-xs-12">

            <ol class="breadcrumb">
                <li><a href="#">Swimming Pool</a></li>
                <li class="active">Payments</li>
            </ol>
        </div>

    </div>

    <div class="row">
        <div class="col-sm-12">
            <div class="white-box">
                <div class="table-responsive">
                    <table class="table table-hover">
                        <thead>
                        <tr>
                            <th>No</th>
                            <th>Name</th>
                            <th>Surname</th>
                            <th>Code</th>
                            <th>Category</th>
                            <th>Payment</th>
                            <th>Payment date</th>
                        </tr>
                        </thead>

                        <tbody>
                        <c:forEach items="${paymentList}" var="model" begin="0">
                            <tr>
                                <td>${model.rownum}</td>
                                <td>${model.name}</td>
                                <td>${model.surname}</td>
                                <td>${model.code}</td>
                                <td>${model.category}</td>
                                <td>${model.money} AZN</td>
                                <td>${model.pay_date}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
<footer class="footer text-center"> <i> 2018 &copy; Coded by <b>Sadiq Eyvazov</b> </i></footer>