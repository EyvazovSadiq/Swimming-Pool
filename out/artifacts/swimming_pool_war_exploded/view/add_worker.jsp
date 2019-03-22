<%--
  Created by IntelliJ IDEA.
  User: Sadiq
  Date: 5/23/18
  Time: 9:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
    $(function(){
        $('#register_worker_id').click(function(){
              register_worker();
        })  ;
    })
</script>

<div class="container-fluid" >

 <div class="row bg-title">
     <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
         <p class="page-title" style="font-size: 22px; font-style: italic;"> <code> İşçilər </code></p>
     </div>
     <div class="col-lg-9 col-sm-8 col-md-8 col-xs-12">
         <ol class="breadcrumb">
             <li><a href="#"> Swimming Pool </a></li>
             <li class="active"> İşçilər </li>
         </ol>
     </div>
 </div>

 <div class="row">
     <div class="col-md-12 col-xs-12">
         <div class="white-box">

             <form class="form-horizontal form-material">
               <div style="text-align: center">
                  <h3 id="worker_reg_warning_id" style="color: red; font-style: italic; text-align: center; display: none;">
                  <i class="fa fa-frown-o fa-fw" aria-hidden="true"></i> Uğursuz !  * simvolu olan xanaları boş saxlamayın !</h3>
               </div>

               <div class="form-group">
                  <label class="col-md-12" style="display: inline-block">Ad * </label>
                  <div class="col-md-12">
                    <input type="text" placeholder="Eli" class="form-control form-control-line" id="worker_name_id">
                  </div>
               </div>

               <div class="form-group">
                  <label class="col-md-12">Soyad *</label>
                  <div class="col-md-12">
                    <input type="text" placeholder="Eliyev" class="form-control form-control-line" id="worker_surname_id">
                  </div>
               </div>

               <div class="form-group">
                  <label class="col-md-12">İstifadəçi adı *</label>
                  <div class="col-md-12">
                    <input type="text" placeholder="Eliyev" class="form-control form-control-line" id="worker_username_id">
                  </div>
               </div>

               <div class="form-group">
                  <label class="col-md-12">Parol *</label>
                  <div class="col-md-12">
                    <input type="password" placeholder="********" class="form-control form-control-line" id="worker_password_id">
                  </div>
               </div>

               <div class="form-group">
                  <label for="worker_email_id" class="col-md-12">Email </label>
                  <div class="col-md-12">
                    <input type="email" placeholder="example@admin.com" class="form-control form-control-line" id="worker_email_id">
                  </div>
               </div>

               <div class="form-group">
                  <label class="col-sm-12">Rol *</label>
                  <div class="col-sm-12">
                    <select id="worker_role_id" name="worker_role" class="form-control form-control-line">
                        <option value="0">Seçin :</option>
                        <option value="1">Admin</option>
                        <option value="2">User</option>
                    </select>
                  </div>
               </div>

               <div class="form-group">
                  <div class="col-sm-3" style="float: right;">
                     <input type="button" class="btn btn-success" value="Saxla" style="float: right; width: 170px;" id="register_worker_id">
                  </div>
                  <div class="col-sm-3" style="float: right;">
                     <input type="reset" class="btn btn-info" value="Təmizlə" style="float: right; width: 170px;">
                  </div>
               </div>
             </form>
         </div>
     </div>
 </div>
</div>  <!-- /.container-fluid -->
<footer class="footer text-center"><i> 2018 &copy; Coded by <b>Sadiq Eyvazov</b> </i></footer>