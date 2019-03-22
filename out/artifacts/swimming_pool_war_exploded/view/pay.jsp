<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript">
  $(function(){
     $('#pay_button_id').click(function(){
         pay();
     })

     $('#start_date_id').datepicker({
         changeMonth:true,
         changeYear: true
     })  ;

     $('#end_date_id').datepicker({
         changeMonth:true,
         changeYear: true
     })  ;

     $('#person_id').change(function() {
        if($('#person_id').val()==1)
        {
            $('#start_date_id').hide();
            $('#end_date_id').hide();
            $('#lbl_start_date_id').hide();
            $('#lbl_end_date_id').hide();
        } else {
            $('#start_date_id').show();
            $('#end_date_id').show();
            $('#lbl_start_date_id').show();
            $('#lbl_end_date_id').show();
        }
     });

  })
</script>
<div class="container-fluid">
   <div class="row bg-title">
       <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
           <p class="page-title" style="font-size: 22px; font-style: italic;"> <code>  Ödəniş </code></p>
       </div>
       <div class="col-lg-9 col-sm-8 col-md-8 col-xs-12">
           <ol class="breadcrumb">
               <li><a href="#">Swimming Pool </a></li>
               <li class="active">Ödəniş</li>
           </ol>
       </div>
   </div>

   <div class="row">
       <div class="col-md-12 col-xs-12">
           <div class="white-box">
               <form class="form-horizontal form-material">
                   <div style="text-align: center">
                       <h3 id="pay_warning_id" style="color: red; font-style: italic; text-align: center; display: none;">
                        * simvolu olan xanaları boş saxlamayın !</h3>

                       <h3 id="pay_warning_id2" style="color: red; font-style: italic; text-align: center; display: none;">
                        Ayları qeyd edin ! </h3>
                   </div>

                   <div class="form-group">
                       <label class="col-sm-12">Şəxs *
                       </label>
                       <div class="col-sm-12">
                           <select id="person_id" name="person" class="form-control form-control-line"> </select>
                       </div>
                   </div>

                   <div class="form-group">
                       <label class="col-md-12">Məbləğ *</label>
                       <div class="col-md-12">
                           <input id="money_id" type="number" placeholder="manat" class="form-control form-control-line">
                       </div>
                   </div>

                   <div class="form-group">
                       <label for="start_date_id" class="col-md-12" id="lbl_start_date_id">Başlama tarixi</label>
                       <div class="col-md-12">
                           <input type="text" placeholder="il-ay-gün" class="form-control form-control-line" id="start_date_id">
                       </div>
                   </div>

                   <div class="form-group">
                       <label for="end_date_id" class="col-md-12" id="lbl_end_date_id">Son tarix</label>
                       <div class="col-md-12">
                           <input type="text" placeholder="il-ay-gün" class="form-control form-control-line" id="end_date_id">
                       </div>
                   </div>

                   <div class="form-group">
                       <div class="col-sm-3" style="float: right;">
                           <input type="button" id="pay_button_id" class="btn btn-success" value="Ödə" style="float: right ; width: 170px;">
                       </div>
                       <div class="col-sm-3" style="float: right;">
                           <input type="reset" class="btn btn-info" value="Təmizlə" style="float: right; width: 170px;">
                       </div>
                   </div>
               </form>
           </div>
       </div>
   </div>
</div> <!-- /.container-fluid -->
<footer class="footer text-center"> <i> 2018 &copy; Coded by <b>Sadiq Eyvazov</b> </i></footer>
