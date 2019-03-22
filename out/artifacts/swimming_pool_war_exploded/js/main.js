/**
 * Created with IntelliJ IDEA.
 * User: Sadiq
 * Date: 6/19/17
 * Time: 3:24 PM
 * To change this template use File | Settings | File Templates.
 */
function get_swimmer_combo(){


    $.ajax ({

        type : 'GET',
        url: 'cs?action=get_swimmer_combo',
        dataType:'html',
        success:function(data){

            $('#person_id').html(data);

        }  ,
        error:function(){
            alert("ERROR !!!") ;
        }

    })
}

function get_category_combo(){


    $.ajax ({

        type : 'GET',
        url: 'cs?action=get_category_combo',
        dataType:'html',
        success:function(data){

            $('#category_id').html(data);

        }  ,
        error:function(){
            alert("ERROR !!!") ;
        }

    })
}

function get_swimmers(){

    $.ajax ({

        type : 'GET',
        url: 'cs?action=get_swimmers',
        dataType:'html',
        success:function(data){
            $('#index_div').hide();
            $('#empty_div').html(data);
            $('#empty_div').show();
        }  ,
        error:function(){
            alert("ERROR !!!") ;
        }

    })
}

function get_payments(){

    $.ajax ({

        type : 'GET',
        url: 'cs?action=get_payments',
        dataType:'html',
        success:function(data){
            $('#index_div').hide();
            $('#empty_div').html(data);
            $('#empty_div').show();
        }

    })
}

function get_comings(){

    $.ajax ({

        type : 'GET',
        url: 'cs?action=get_comings',
        dataType:'html',
        success:function(data){
            $('#index_div').hide();
            $('#empty_div').html(data);
            $('#empty_div').show();
        }  ,
        error:function(){
            alert("ERROR !!!") ;
        }

    })
}

function get_workers(){

    $.ajax ({

        type : 'GET',
        url: 'cs?action=get_workers',
        dataType:'html',
        success:function(data){
            $('#index_div').hide();
            $('#empty_div').html(data);
            $('#empty_div').show();
        }  ,
        error:function(){
            alert("ERROR !!!") ;
        }

    })
}

function pay(){

    var swimmer = $('#person_id').val();
    var money =  $('#money_id').val();
    var start_date = $('#start_date_id').val();
    var end_date =  $('#end_date_id').val();

    if( swimmer!=0 && money!="" )
    {
       if(swimmer!=1 && (start_date=="" || end_date==""))
       {
           $('#pay_warning_id').hide();
           $('#pay_warning_id2').show();
       }
       else
       {
           $.ajax({

            type: 'POST',
            url: 'cs?action=pay',
            data: 'swimmer='+swimmer+'&money='+money+'&start_date='+start_date+'&end_date='+end_date,
            dataType: 'html',
            success : function(data){

                $('#index_div').hide();
                $('#empty_div').html(data);
                $('#empty_div').show();

            }   ,
            error:function(){
            alert("ERROR !!!") ;
            }

            })
       }

    } else
    {
        $('#pay_warning_id2').hide();
        $('#pay_warning_id').show();
    }

}

function search_sw(keyword){

    $.ajax ({

        type : 'GET',
        url: 'cs?action=search_sw',
        dataType:'html',
        data: 'keyword=' + keyword,
        success:function(data){
            $('#index_div').hide();
            $('#empty_div').html(data);
            $('#empty_div').show();
        } ,
        error:function(){
        alert("ERROR !!!") ;
    }


})
}

function search_payment(keyword){

    $.ajax ({

        type : 'GET',
        url: 'cs?action=search_payment',
        dataType:'html',
        data: 'keyword=' + keyword,
        success:function(data){
            $('#index_div').hide();
            $('#empty_div').html(data);
            $('#empty_div').show();
        } ,
        error:function(){
            alert("ERROR !!!") ;
        }


    })
}

function search_coming(keyword){

    $.ajax ({

        type : 'GET',
        url: 'cs?action=search_coming',
        dataType:'html',
        data: 'keyword=' + keyword,
        success:function(data){
            $('#index_div').hide();
            $('#empty_div').html(data);
            $('#empty_div').show();
        } ,
        error:function(){
            alert("ERROR !!!") ;
        }


    })
}

function search_worker(keyword){
    $.ajax ({

        type : 'GET',
        url: 'cs?action=search_worker',
        dataType:'html',
        data: 'keyword=' + keyword,
        success:function(data){
            $('#index_div').hide();
            $('#empty_div').html(data);
            $('#empty_div').show();
        } ,
        error:function(){
            alert("ERROR !!!") ;
        }

    })
}

function decrement(id,limit,code){
   var f =    $('#search_id').val() ;
  if(limit!=0)
   {
       $.ajax ({

           type : 'POST',
           url: 'cs?action=decrement_sw',
           data: 'id='+id+'&limit=' + limit,
           success:function(){

               search_sw(code) ;
           }  ,
           error:function(){
               alert("ERROR !!!") ;
           }

       })
   }
}

function register_sw(){

    var name = $('#name_id').val();
    var surname = $('#surname_id').val();
    var phone = $('#phone_id').val();
    var email = $('#email_id').val();
    var dob = $('#dob_id').val();
    var gender = $('#gender_id').val();
    var category = $('#category_id').val();

    if(name!="" && surname!="" && phone!="" && dob!="" && gender!=0 && category!=0)
    {
        $.ajax ({

            type : 'POST',
            url: 'cs?action=register_swimmer',
            data: 'name='+name+'&surname=' + surname +'&phone=' + phone +'&email=' + email +'&dob=' + dob +'&gender=' + gender +'&category=' + category ,
            dataType: 'html',
            success:function(data){

                $('#index_div').hide();
                $('#empty_div').html(data);
                $('#empty_div').show();
            }  ,
            error:function(){
                alert("ERROR !!!") ;
            }

        })
    }
    else
    {
        $('#reg_warning_id').show();
    }
}

function register_worker(){

    var name = $('#worker_name_id').val() ;
    var surname = $('#worker_surname_id').val() ;
    var username = $('#worker_username_id').val();
    var password = $('#worker_password_id').val();
    var email = $('#worker_email_id').val();
    var role = $('#worker_role_id').val();

    if(name!="" && surname!="" && username!="" && password!="" && email!=0 && role!=0)
    {
        $.ajax ({

            type : 'POST',
            url: 'cs?action=register_worker',
            data: 'name='+name+'&surname=' + surname +'&username=' + username +'&email=' + email +'&password=' + password +'&role=' + role ,
            dataType: 'html',
            success:function(data){

                $('#index_div').hide();
                $('#empty_div').html(data);
                $('#empty_div').show();
            }  ,
            error:function(){
                alert("ERROR !!!") ;
            }

        })
    }
    else
    {
        $('#worker_reg_warning_id').show();
    }
}

function delete_sw(id,name) {

    var true_false = confirm(name + " silinsin ?");
    if(true_false)
    {
        $.ajax ({

            type : 'POST',
            url: 'cs?action=delete_sw',
            data: 'id='+id ,
            success:function(){
                get_swimmers();
            }  ,
            error:function(){
                alert("ERROR !!!") ;
            }

        })
    }



}

function delete_worker(id,fullname) {

    var true_false = confirm(fullname + " silinsin ?");
    if(true_false)
    {
        $.ajax ({

            type : 'POST',
            url: 'cs?action=delete_worker',
            data: 'id='+id ,
            success:function(){
                get_workers();
            }  ,
            error:function(){
                alert("ERROR !!!") ;
            }

        })
    }
}