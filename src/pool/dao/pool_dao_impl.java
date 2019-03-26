package pool.dao;

import pool.model.*;
import pool.util.jdbc_utility;
import pool.util.sqls;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Sadiq
 * Date: 6/19/17
 * Time: 2:31 AM
 * To change this template use File | Settings | File Templates.
 */
public class pool_dao_impl  implements  pool_dao {


    @Override
    public login check_login(String username, String password) throws Exception {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null ;
        String sql = sqls.check_login;
        login login = new login();
        try {
            c = jdbc_utility.getConnection();
            if (c!=null)
            {
                ps = c.prepareStatement(sql);
                ps.setString(1,username);
                ps.setString(2,password);
                rs = ps.executeQuery();
                if (rs.next())
                {
                    login.setUsername(rs.getString("username"));
                    login.setFullname(rs.getString("fullname"));
                    login.setRole(rs.getString("role"));
                }  else {
                    login = null ;
                }
            }
        }   catch (Exception e) {
            e.printStackTrace();
        }   finally {
            jdbc_utility.close(c,ps,rs);
        }
        return login;
    }

    @Override
    public List<swimmer> get_swimmer_combo() throws Exception {

          Connection c = null;
          PreparedStatement ps = null;
          ResultSet rs = null ;
          String sql = sqls.swimmer_combo;

          List<swimmer> swimmerList = new ArrayList<swimmer>();

          try {

             c = jdbc_utility.getConnection();
             if (c!=null)
             {
                 ps = c.prepareStatement(sql);
                 rs = ps.executeQuery();
                 while (rs.next())
                 {
                     swimmer sw = new swimmer();
                     sw.setId(rs.getLong("id"));
                     sw.setName(rs.getString("name"));
                     sw.setSurname(rs.getString("surname"));
                     sw.setCode(rs.getString("code"));
                     swimmerList.add(sw);
                 }

             }   else System.out.println("Connection is null !");

          }   catch (Exception e) {
              e.printStackTrace();
          }   finally {
                jdbc_utility.close(c,ps,rs);
          }

        return swimmerList;
    }

    @Override
    public void register_swimmer(swimmer s) throws Exception {
        Connection c = null;
        PreparedStatement ps = null;
        String sql = sqls.register_swimmer;
        try {
            c = jdbc_utility.getConnection();
            if (c!=null)
            {
                ps = c.prepareStatement(sql);
                ps.setString(1,s.getName());
                ps.setString(2,s.getSurname());
                ps.setString(3,s.getPhone());
                ps.setString(4,s.getEmail());
                ps.setString(5,s.getDob());
                if (s.getGender().equals("1"))
                    ps.setString(6,"male");
                 else
                    ps.setString(6, "female");
                ps.setInt(7,s.getCategory_id());
                ps.setString(8,s.getCode());
                ps.execute();
            }   else System.out.println("Connection is null !");

        }   catch (Exception e) {
            e.printStackTrace();
        }   finally {
            c.commit();
            jdbc_utility.close(c,ps,null);
        }
    }

    @Override
    public List<category> get_category_combo() throws Exception {

        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null ;
        String sql = sqls.category_combo;

        List<category> categoryList = new ArrayList<category>();

        try {

            c = jdbc_utility.getConnection();
            if (c!=null)
            {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next())
                {
                    category ct = new category();
                    ct.setId(rs.getInt("id"));
                    ct.setName(rs.getString("name"));
                    categoryList.add(ct);
                }

            }   else System.out.println("Connection is null !");

        }   catch (Exception e) {
            e.printStackTrace();
        }   finally {
            jdbc_utility.close(c,ps,rs);
        }

        return categoryList;

    }

    @Override
    public List<swimmer> get_swimmers() throws Exception {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null ;
        String sql = sqls.swimmer_list;
        long r = 1 ;
        List<swimmer> swimmerList = new ArrayList<swimmer>();
        try {
            c = jdbc_utility.getConnection();
            if (c!=null)
            {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next())
                {
                    swimmer sw = new swimmer();
                    sw.setRownum(r++);
                    sw.setId(rs.getLong("id"));
                    sw.setName(rs.getString("name"));
                    sw.setSurname(rs.getString("surname"));
                    sw.setPhone(rs.getString("phone"));
                    sw.setEmail(rs.getString("email"));
                    sw.setDob(rs.getString("birthday"));
                    sw.setGender(rs.getString("gender"));
                    sw.setCategory(rs.getString("category"));
                    sw.setCode(rs.getString("code"));
                    sw.setLimit(rs.getInt("limit"));
                    sw.setStart_date(rs.getString("start_date"));
                    sw.setEnd_date(rs.getString("end_date"));
                    swimmerList.add(sw);
                }
            }   else System.out.println("Connection is null !");
        }   catch (Exception e) {
            e.printStackTrace();
        }   finally {
            jdbc_utility.close(c,ps,rs);
        }
        return swimmerList;
    }

    @Override
    public List<payment> get_payments() throws Exception {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null ;
        String sql = sqls.payment_list;
        long r = 1 ;
        List<payment> paymentList = new ArrayList<payment>();
        try {
            c = jdbc_utility.getConnection();
            if (c!=null)
            {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next())
                {
                    payment p = new payment();
                    p.setRownum(r++);
                    p.setId(rs.getLong("id"));
                    p.setName(rs.getString("name"));
                    p.setSurname(rs.getString("surname"));
                    p.setCode(rs.getString("code"));
                    p.setCategory(rs.getString("category"));
                    p.setMoney(rs.getInt("money"));
                    p.setPay_date(rs.getDate("pay_date"));
                    paymentList.add(p);
                }
            }   else System.out.println("Connection is null !");
        }   catch (Exception e) {
            e.printStackTrace();
        }   finally {
            jdbc_utility.close(c,ps,rs);
        }
        return paymentList;
    }

    @Override
    public List<coming> get_comings() throws Exception {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null ;
        String sql = sqls.comings_list;
        long r = 1;
        List<coming> comingList = new ArrayList<coming>();
        try {
            c = jdbc_utility.getConnection();
            if (c!=null)
            {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next())
                {
                    coming cm = new coming();
                    cm.setRownum(r++);
                    cm.setId(rs.getInt("id"));
                    cm.setName(rs.getString("name"));
                    cm.setSurname(rs.getString("surname"));
                    cm.setCode(rs.getString("code"));
                    cm.setDate(rs.getString("i_date").substring(0,16));
                    comingList.add(cm);
                }
            }   else System.out.println("Connection is null !");
        }   catch (Exception e) {
            e.printStackTrace();
        }   finally {
            jdbc_utility.close(c,ps,rs);
        }
        return comingList;
    }

    @Override
    public List<login> get_logins() throws Exception {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null ;
        String sql = sqls.get_logins;
        List<login> loginList = new ArrayList<login>();
        try {
            c = jdbc_utility.getConnection();
            if (c!=null)
            {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next())
                {
                    login lg = new login();
                    lg.setRownum(rs.getInt("r"));
                    lg.setId(rs.getInt("id"));
                    lg.setFullname(rs.getString("fullname"));
                    lg.setUsername(rs.getString("username"));
                    lg.setPassword(rs.getString("password"));
                    lg.setEmail(rs.getString("email"));
                    lg.setRole(rs.getString("role"));
                    loginList.add(lg);
                }
            }   else System.out.println("Connection is null !");
        }   catch (Exception e) {
            e.printStackTrace();
        }   finally {
            jdbc_utility.close(c,ps,rs);
        }
        return loginList;
    }

    @Override
    public void pay(int swimmer_id, int money) throws Exception {

        Connection c = null;
        PreparedStatement ps = null;
        String sql = sqls.pay;
        try {
            c = jdbc_utility.getConnection();
            if (c!=null)
            {
                ps = c.prepareStatement(sql);
                ps.setInt(1,swimmer_id);
                ps.setInt(2, money);
                ps.execute();
            }   else System.out.println("Connection is null !");
        }   catch (Exception e) {
            e.printStackTrace();
        }   finally {
            c.commit();
            jdbc_utility.close(c,ps,null);
        }
    }

    @Override
    public void pay_to_swimmer(pay p) throws Exception {

        Connection c = null;
        PreparedStatement ps = null;
        String sql = sqls.pay_to_swimmer;
        try {
            c = jdbc_utility.getConnection();
            if (c!=null)
            {
                ps = c.prepareStatement(sql);
                ps.setInt(1,p.getLimit());
                ps.setString(2,p.getStart_date());
                ps.setString(3,p.getEnd_date());
                ps.setInt(4,p.getSwimmer_id());
                ps.execute();
            }   else System.out.println("Connection is null !");
        }   catch (Exception e) {
            e.printStackTrace();
        }   finally {
            c.commit();
            jdbc_utility.close(c,ps,null);
        }
    }

    @Override
    public List<swimmer> search_sw(String keyword) throws Exception {

        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null ;
        String sql = "select s.id,s.name,surname,phone,email,birthday,gender,c.name as category,code,limit,start_date,end_date from swimmers s \n" +
                "inner join category c on s.category_id = c.id \n" +
                "where s.active = 1 and s.id!=1 and ( lower(s.name) like lower('"+keyword+"%')\n" +
                "or lower(surname) like lower('"+keyword+"%')  \n" +
                "or lower(code) like lower('"+keyword+"%') ) order by s.id desc" ;
        long r = 1 ;
        List<swimmer> swimmerList = new ArrayList<swimmer>();

        try {

            c = jdbc_utility.getConnection();
            if (c!=null)
            {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next())
                {
                    swimmer sw = new swimmer();
                    sw.setRownum(r++);
                    sw.setId(rs.getLong("id"));
                    sw.setName(rs.getString("name"));
                    sw.setSurname(rs.getString("surname"));
                    sw.setPhone(rs.getString("phone"));
                    sw.setEmail(rs.getString("email"));
                    sw.setDob(rs.getString("birthday"));
                    sw.setGender(rs.getString("gender"));
                    sw.setCategory(rs.getString("category"));
                    sw.setCode(rs.getString("code"));
                    sw.setLimit(rs.getInt("limit"));
                    sw.setStart_date(rs.getString("start_date"));
                    sw.setEnd_date(rs.getString("end_date"));

                    swimmerList.add(sw);
                }

            }   else System.out.println("Connection is null !");

        }   catch (Exception e) {
            e.printStackTrace();
        }   finally {
            jdbc_utility.close(c,ps,rs);
        }

        return swimmerList;

    }

    @Override
    public List<payment> search_payment(String keyword) throws Exception {

        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null ;
        String sql = "select p.id,s.name,s.surname,s.code,c.name as category,money,pay_date from payment p\n" +
                "inner join swimmers s on p.swimmer_id = s.id\n" +
                "inner join category c on s.category_id = c.id\n" +
                "where p.active = 1 and \n" +
                "( lower(s.name) like lower('"+keyword+"%')\n" +
                "or lower(surname) like lower('"+keyword+"%') \n" +
                "or lower(code) like lower('"+keyword+"%')  )\n" +
                "order by pay_date desc ";
        long r = 1 ;
        List<payment> paymentList = new ArrayList<payment>();

        try {

            c = jdbc_utility.getConnection();
            if (c!=null)
            {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next())
                {
                    payment p = new payment();
                    p.setRownum(r++);
                    p.setId(rs.getLong("id"));
                    p.setName(rs.getString("name"));
                    p.setSurname(rs.getString("surname"));
                    p.setCode(rs.getString("code"));
                    p.setCategory(rs.getString("category"));
                    p.setMoney(rs.getInt("money"));
                    p.setPay_date(rs.getDate("pay_date"));
                    paymentList.add(p);
                }

            }   else System.out.println("Connection is null !");

        }   catch (Exception e) {
            e.printStackTrace();
        }   finally {
            jdbc_utility.close(c,ps,rs);
        }

        return paymentList;


    }

    @Override
    public List<coming> search_coming(String keyword) throws Exception {

        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null ;
        String sql = "select c.id,s.name,s.surname,s.code,C.I_DATE from comings  c \n" +
                "inner join swimmers s on C.SWIMMER_ID = s.id\n" +
                "where c.active = 1 and\n" +
                "( lower(s.name) like lower('"+keyword+"%')\n" +
                "or lower(surname) like lower('"+keyword+"%') \n" +
                "or lower(code) like lower('"+keyword+"%') )\n" +
                "order by i_date desc" ;
        long r = 1;
        List<coming> comingList = new ArrayList<coming>();

        try {

            c = jdbc_utility.getConnection();
            if (c!=null)
            {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next())
                {
                    coming cm = new coming();
                    cm.setRownum(r++);
                    cm.setId(rs.getInt("id"));
                    cm.setName(rs.getString("name"));
                    cm.setSurname(rs.getString("surname"));
                    cm.setCode(rs.getString("code"));
                    cm.setDate(rs.getString("i_date").substring(0,16));
                    comingList.add(cm);
                }

            }   else System.out.println("Connection is null !");

        }   catch (Exception e) {
            e.printStackTrace();
        }   finally {
            jdbc_utility.close(c,ps,rs);
        }

        return comingList;
    }

    @Override
    public List<login> search_worker(String keyword) throws Exception {

        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null ;
        String sql = "select ROWNUM r,id,fullname,username,password,email,role from login\n" +
                "where lower(fullname) like lower('%"+keyword+"%') order by id desc " ;

        List<login> loginList = new ArrayList<login>();
        try {

            c = jdbc_utility.getConnection();
            if (c!=null)
            {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next())
                {
                    login lg = new login();
                    lg.setRownum(rs.getInt("r"));
                    lg.setId(rs.getInt("id"));
                    lg.setFullname(rs.getString("fullname"));
                    lg.setUsername(rs.getString("username"));
                    lg.setPassword(rs.getString("password"));
                    lg.setEmail(rs.getString("email"));
                    lg.setRole(rs.getString("role"));
                    loginList.add(lg);
                }
            }   else System.out.println("Connection is null !");

        }   catch (Exception e) {
            e.printStackTrace();
        }   finally {
            jdbc_utility.close(c,ps,rs);
        }
        return loginList;
    }

    @Override
    public void decrement_sw(int id , int limit) throws Exception {
        Connection c = null;
        PreparedStatement ps = null;
        String sql = sqls.decrement_sw;
        try {
            c = jdbc_utility.getConnection();
            if (c!=null)
            {
                ps = c.prepareStatement(sql);
                ps.setInt(1,limit);
                ps.setInt(2,id);
                ps.execute();
            }   else System.out.println("Connection is null !");
        }   catch (Exception e) {
            e.printStackTrace();
        }   finally {
            c.commit();
            jdbc_utility.close(c,ps,null);
        }
    }

    @Override
    public void insert_coming(int id) throws Exception {

        Connection c = null;
        PreparedStatement ps = null;
        String sql = sqls.insert_coming;

        try {

            c = jdbc_utility.getConnection();
            if (c!=null)
            {
                ps = c.prepareStatement(sql);
                ps.setInt(1,id);
                ps.execute();
            }   else System.out.println("Connection is null !");

        }   catch (Exception e) {
            e.printStackTrace();
        }   finally {
            c.commit();
            jdbc_utility.close(c,ps,null);
        }

    }

    @Override
    public void delete_sw(int id) throws Exception {

        Connection c = null;
        PreparedStatement ps = null;
        String sql = sqls.delete_sw;

        try {

            c = jdbc_utility.getConnection();
            if (c!=null)
            {
                ps = c.prepareStatement(sql);
                ps.setInt(1,id);
                ps.execute();
            }   else System.out.println("Connection is null !");

        }   catch (Exception e) {
            e.printStackTrace();
        }   finally {
            c.commit();
            jdbc_utility.close(c,ps,null);
        }

    }

    @Override
    public void delete_worker(int id) throws Exception {

        Connection c = null;
        PreparedStatement ps = null;
        String sql = sqls.delete_worker;

        try {

            c = jdbc_utility.getConnection();
            if (c!=null)
            {
                ps = c.prepareStatement(sql);
                ps.setInt(1,id);
                ps.execute();
            }   else System.out.println("Connection is null !");

        }   catch (Exception e) {
            e.printStackTrace();
        }   finally {
            c.commit();
            jdbc_utility.close(c,ps,null);
        }


    }

    @Override
    public void register_worker(login login) throws Exception {

        Connection c = null;
        PreparedStatement ps = null;
        String sql = sqls.register_worker;

        try {

            c = jdbc_utility.getConnection();
            if (c!=null)
            {
                ps = c.prepareStatement(sql);
                ps.setString(1,login.getFullname());
                ps.setString(2,login.getUsername());
                ps.setString(3,login.getPassword());
                ps.setString(4,login.getEmail());
                ps.setString(5,login.getRole());
                ps.execute();
            }   else System.out.println("Connection is null !");

        }   catch (Exception e) {
            e.printStackTrace();
        }   finally {
            c.commit();
            jdbc_utility.close(c,ps,null);
        }

    }


}
