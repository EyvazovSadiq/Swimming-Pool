package pool.util;

/**
 * Created with IntelliJ IDEA.
 * User: Sadiq
 * Date: 6/23/17
 * Time: 2:36 AM
 * To change this template use File | Settings | File Templates.
 */
public class sqls {

    public static final String get_logins = " select ROWNUM r,id,fullname,username,password,email,role from login " ;

    public static final String check_login = " select fullname , username , role from login \n" +
            "where  username = ? and password = ? " ;

    public static final String register_swimmer = "insert into swimmers(id,name,surname,phone,email,birthday,gender,category_id,code)\n" +
            "values(swimmer_seq.nextval,?,?,?,?,?,?,?,?)" ;

    public static final String swimmer_combo = "select id,name,surname,code from swimmers where active = 1 and id!=1 order by id desc" ;

    public static final String category_combo = "select id,name from category where active = 1 and id!=1 " ;

    public static final String swimmer_list = "select s.id,s.name,surname,phone,email,birthday,gender,c.name as category,code,limit,start_date,end_date from swimmers s \n" +
            "inner join category c on s.category_id = c.id  where s.active = 1 and s.id!=1 order by s.id desc" ;

    public static final String payment_list ="select p.id,s.name,s.surname,s.code,c.name as category,money,pay_date from payment p\n" +
            "inner join swimmers s on p.swimmer_id = s.id\n" +
            "inner join category c on s.category_id = c.id\n" +
            "where p.active = 1 order by pay_date desc" ;

    public static final String comings_list = "select c.id,s.name,s.surname,s.code,C.I_DATE from comings  c \n" +
            "inner join swimmers s on C.SWIMMER_ID = s.id\n" +
            "where c.active = 1 order by i_date desc " ;

    public static final String pay = "insert into payment(id,swimmer_id,money)\n" +
            "values(payment_seq.nextval,?,?)" ;

    public static final String pay_to_swimmer = "update swimmers set limit = ? ,start_date = ?,end_date =? \n" +
            "where id = ?" ;

   /* public static final String search_sw = "select s.id,s.name,surname,phone,email,birthday,gender,c.name as category,code,limit,start_date,end_date from swimmers s \n" +
            "inner join category c on s.category_id = c.id \n" +
            "where s.active = 1 and s.id!=1 and lower(s.name) like lower('%71%')\n" +
            "or lower(surname) like lower('%71%')  \n" +
            "or lower(code) like lower('%71%') order by s.id desc"   ;*/

    public static final String decrement_sw = "update swimmers set limit = ? where id =?" ;

    public static final String insert_coming = "insert into comings(id,swimmer_id)\n" +
            "values(comings_seq.nextval,?)"  ;

    public static final String delete_sw = "delete from swimmers\n" +
            "where id = ?" ;

    public static final String delete_worker = "delete from login\n" +
            "where id = ?" ;

    public static final String register_worker = "insert into login(id,fullname,username,password,email,role)\n" +
            "values(LOGIN_SEQ.nextval,?,?,?,?,?)" ;
}
