<%--
  Created by IntelliJ IDEA.
  User: Sadiq
  Date: 6/25/17
  Time: 1:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--<script type="text/javascript">
    $(function(){
        $('#table_id').DataTable();
    })
</script>--%>

<div class="container-fluid">
    <div class="row bg-title">
        <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
            <p class="page-title" style="font-size: 22px; font-style: italic;"> <code> Girişlər </code></p>
        </div>
        <div class="col-lg-9 col-sm-8 col-md-8 col-xs-12">

            <ol class="breadcrumb">
                <li><a href="#">Swimming Pool</a></li>
                <li class="active">Girişlər</li>
            </ol>
        </div>

    </div>
    <!-- /row -->
    <div class="row">
        <div class="col-sm-12">
            <div class="white-box">
                <div class="table-responsive">
                    <table class="table table-hover" id="table_id">
                        <thead>
                        <tr>
                            <th>No</th>
                            <th>Ad</th>
                            <th>Soyad</th>
                            <th>Kod</th>
                            <th>Tarix</th>
                        </tr>
                        </thead>

                        <tbody>
                        <c:forEach items="${comingList}" var="model" begin="0">
                            <tr>
                                <td>${model.rownum}</td>
                                <td>${model.name}</td>
                                <td>${model.surname}</td>
                                <td>${model.code}</td>
                                <td>${model.date}</td>
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