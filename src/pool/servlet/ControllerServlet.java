package pool.servlet;

import pool.dao.pool_dao;
import pool.dao.pool_dao_impl;
import pool.model.*;
import pool.service.pool_service_dao;
import pool.service.pool_service_dao_impl;
import pool.util.actions;

import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.util.List;


/**
 * Created with IntelliJ IDEA.
 * User: Sadiq
 * Date: 6/19/17
 * Time: 2:28 AM
 * To change this template use File | Settings | File Templates.
 */
public class ControllerServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
      get_post(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
       get_post(request,response);
    }


    private void get_post(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        String action = "" , address = "" ;
        pool_dao dao = new pool_dao_impl();
        pool_service_dao serviceDao = new pool_service_dao_impl(dao);
        if (request.getParameter("action")!=null)
           action = request.getParameter("action");

        try {

            if (action.equals(actions.REGISTER_SWIMMER))
            {
                  swimmer sw = new swimmer();
                  sw.setName(request.getParameter("name"));
                  sw.setSurname(request.getParameter("surname"));
                  sw.setPhone(request.getParameter("phone"));
                  sw.setEmail(request.getParameter("email"));
                  sw.setDob(request.getParameter("dob"));
                  sw.setGender(request.getParameter("gender"));
                  sw.setCategory_id(Integer.parseInt(request.getParameter("category")));
                  sw.setCode(String.valueOf(System.currentTimeMillis()).substring(8, 13));
                  serviceDao.register_swimmer(sw);
                  request.setAttribute("message","Successfully registered!");
                  address =  "WEB-INF/parse_jsp/response.jsp";

            }  else if (action.equals(actions.PAY))
            {
                pay p = new pay();
                p.setSwimmer_id(Integer.parseInt(request.getParameter("swimmer")));
                p.setMoney(Integer.parseInt(request.getParameter("money")));
                if (!request.getParameter("start_date").isEmpty() && !request.getParameter("end_date").isEmpty())
                {
                    p.setStart_date(request.getParameter("start_date"));
                    p.setEnd_date(request.getParameter("end_date"));
                }
                p.setLimit((p.getMoney()/40)*8);

                dao.pay(p.getSwimmer_id(),p.getMoney());
                if (p.getSwimmer_id()!=1)
                    dao.pay_to_swimmer(p);

                String message = "Payment is done successfully!";
                request.setAttribute("message",message);
                address =  "WEB-INF/parse_jsp/response.jsp";

            }  else if (action.equals(actions.SWIMMER_COMBO))
            {
                List<swimmer> swimmerComboList = serviceDao.get_swimmer_combo();
                request.setAttribute("swimmerComboList",swimmerComboList);
                address="WEB-INF/parse_jsp/combo/swimmer_combo.jsp";

            } else if (action.equals(actions.CATEGORY_COMBO))
            {
                List<category> categoryComboList = serviceDao.get_category_combo();
                request.setAttribute("categoryComboList",categoryComboList);
                address="WEB-INF/parse_jsp/combo/category_combo.jsp";

            }  else if (action.equals(actions.GET_SWIMMERS))
            {
                List<swimmer> swimmerList = serviceDao.get_swimmers();
                request.setAttribute("swimmerList",swimmerList);
                address="WEB-INF/parse_jsp/swimmers.jsp";
            }   else if (action.equals(actions.GET_PAYMENTS))
            {
                List<payment> paymentList = serviceDao.get_payments();
                request.setAttribute("paymentList",paymentList);
                address="WEB-INF/parse_jsp/payments.jsp";
            }   else if (action.equals(actions.GET_COMINGS))
            {
                List<coming> comingList = serviceDao.get_comings();
                request.setAttribute("comingList",comingList);
                address="WEB-INF/parse_jsp/comings.jsp";
            }   else if (action.equals(actions.GET_WORKERS))
            {
                List<login> loginList = serviceDao.get_logins();
                request.setAttribute("loginList",loginList);
                address="WEB-INF/parse_jsp/workers.jsp";
            }   else if (action.equals(actions.SEARCH_SW))
            {
                String keyword = request.getParameter("keyword") ;
                List<swimmer> swimmerList = serviceDao.search_sw(keyword);
                request.setAttribute("swimmerList",swimmerList);
                address="WEB-INF/parse_jsp/swimmers.jsp";
            }   else if (action.equals(actions.SEARCH_PAYMENT))
            {
                String keyword = request.getParameter("keyword") ;
                List<payment> paymentList = serviceDao.search_payment(keyword);
                request.setAttribute("paymentList",paymentList);
                address="WEB-INF/parse_jsp/payments.jsp";
            }   else if (action.equals(actions.SEARCH_COMING))
            {
                String keyword = request.getParameter("keyword") ;
                List<coming> comingList = serviceDao.search_coming(keyword);
                request.setAttribute("comingList", comingList);
                address="WEB-INF/parse_jsp/comings.jsp";
            }   else if (action.equals(actions.SEARCH_WORKER))
            {
                String keyword = request.getParameter("keyword") ;
                List<login> loginList = serviceDao.search_worker(keyword);
                request.setAttribute("loginList", loginList);
                address="WEB-INF/parse_jsp/workers.jsp";
            }  else if (action.equals(actions.DECREMENT_SW))
            {
                int id = Integer.parseInt(request.getParameter("id")) ;
                int limit = Integer.parseInt(request.getParameter("limit"))-1 ;
                dao.decrement_sw(id,limit);
                dao.insert_coming(id);
            }   else if (action.equals(actions.DELETE_SW))
            {
                int id = Integer.parseInt(request.getParameter("id")) ;
                dao.delete_sw(id);
            }   else if (action.equals(actions.DELETE_WORKER))
            {
                int id = Integer.parseInt(request.getParameter("id")) ;
                dao.delete_worker(id);
            }  else if (action.equals(actions.REGISTER_WORKER))
            {
                login login = new login();
                login.setFullname(request.getParameter("name")+request.getParameter("surname"));
                login.setUsername(request.getParameter("username"));
                login.setPassword(request.getParameter("password"));
                login.setEmail(request.getParameter("email"));

                int a = Integer.parseInt(request.getParameter("role"));
                if (a==1)
                 login.setRole("admin");
                else if (a==2)
                 login.setRole("user");

                serviceDao.register_worker(login);
                request.setAttribute("message","Successfully registered!");
                address =  "WEB-INF/parse_jsp/response.jsp";
            }
        }  catch (Exception e) {
            e.printStackTrace();
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request,response);
    }
}
