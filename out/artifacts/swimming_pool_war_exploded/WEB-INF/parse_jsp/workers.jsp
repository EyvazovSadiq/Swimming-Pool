<%--
  Created by IntelliJ IDEA.
  User: Sadiq
  Date: 5/23/18
  Time: 7:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container-fluid">
    <div class="row bg-title">
        <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
            <p class="page-title" style="font-size: 22px; font-style: italic;"> <code>  İşçilər </code></p>
        </div>
        <div class="col-lg-9 col-sm-8 col-md-8 col-xs-12">

            <ol class="breadcrumb">
                <li><a href="#">Swimming Pool</a></li>
                <li class="active">İşçilər</li>
            </ol>
        </div>

    </div>

    <div class="row">
        <div class="col-sm-12">
            <div class="white-box">

                <c:if test="${not empty loginList}">
                    <div class="table-responsive">
                        <table class="table table-hover">
                            <thead>
                            <tr>
                                <th>No</th>
                                <th>Ad & Soyad</th>
                                <th>Login</th>
                                <th>Parol</th>
                                <th>Email</th>
                                <th>Rolu</th>
                                <th><i  class="fa fa fa-trash" aria-hidden="true"></i></th>
                            </tr>
                            </thead>

                            <tbody>
                            <c:forEach items="${loginList}" var="model" begin="0">
                                <tr >
                                    <td>${model.rownum}</td>
                                    <td>${model.fullname}</td>
                                    <td>${model.username}</td>
                                    <td>${model.password}</td>
                                    <td>${model.email}</td>
                                    <td>${model.role}</td>
                                    <td><a href="javascript:delete_worker('${model.id}','${model.fullname}');" title="Sil"><i class="fa  fa-trash-o" aria-hidden="true"></i></a></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </c:if>

                <c:if test="${empty loginList}">
                    <div class="alert alert-warning" style="text-align: center;">
                        <strong> Məlumat tapılmadı .</strong>
                    </div>
                </c:if>
            </div>
        </div>
    </div>
</div>
<footer class="footer text-center"> <i> 2018 &copy; Coded by <b>Sadiq Eyvazov</b> </i></footer>