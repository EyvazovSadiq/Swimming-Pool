<%--
  Created by IntelliJ IDEA.
  User: Sadiq
  Date: 6/24/17
  Time: 1:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container-fluid">
    <div class="row bg-title">
        <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
            <p class="page-title" style="font-size: 22px; font-style: italic;"> <code>  Üzgüçülər </code></p>
        </div>
        <div class="col-lg-9 col-sm-8 col-md-8 col-xs-12">

            <ol class="breadcrumb">
                <li><a href="#">Swimming Pool</a></li>
                <li class="active">Üzgüçülər</li>
            </ol>
        </div>

    </div>

    <div class="row">
        <div class="col-sm-12">
            <div class="white-box">

                <c:if test="${not empty swimmerList}">
                <div class="table-responsive">
                    <table class="table table-hover">
                        <thead>
                        <tr>
                            <th>No</th>
                            <th>Ad</th>
                            <th>Soyad</th>
                            <th>Telefon</th>
                            <th>Email</th>
                            <th>Doğum tarixi</th>
                            <th>Cins</th>
                            <th>Kateqoriya</th>
                            <th>Kod</th>
                            <th>Limit</th>
                            <th>Başlama</th>
                            <th>Son</th>
                            <th><i  class="fa fa fa-arrow-down" aria-hidden="true"></i></th>
                            <th><i  class="fa fa fa-trash" aria-hidden="true"></i></th>
                        </tr>
                        </thead>

                        <tbody>
                        <c:forEach items="${swimmerList}" var="model" begin="0">


                            <tr <c:if test="${model.limit <3 }">
                             class="danger"
                            </c:if> >
                                <td>${model.rownum}</td>
                                <td>${model.name}</td>
                                <td>${model.surname}</td>
                                <td>${model.phone}</td>
                                <td>${model.email}</td>
                                <td>${model.dob}</td>
                                <td>${model.gender}</td>
                                <td>${model.category}</td>
                                <td>${model.code}</td>
                                <c:if test="${model.limit <3 }">
                                <td style="color: red;">${model.limit}</td>
                                </c:if>
                                <c:if test="${model.limit >= 3}">
                                    <td style="color: #7ace4c;">${model.limit}</td>
                                </c:if>

                                <td>${model.start_date}</td>
                                <td>${model.end_date}</td>
                                <td><a href="javascript:decrement('${model.id}','${model.limit}','${model.code}');"><i class="fa  fa-minus" aria-hidden="true"></i></a></td>
                                <td><a href="javascript:delete_sw('${model.id}','${model.name} ${model.surname}');" title="Sil"><i class="fa  fa-trash-o" aria-hidden="true"></i></a></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                </c:if>

                <c:if test="${empty swimmerList}">
                    <div class="alert alert-warning" style="text-align: center;">
                        <strong> Məlumat tapılmadı .</strong>
                    </div>
                </c:if>
            </div>
        </div>
    </div>
</div>
<footer class="footer text-center"> <i> 2018 &copy; Coded by <b>Sadiq Eyvazov</b> </i></footer>