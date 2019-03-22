package pool.servlet;
import pool.dao.pool_dao;
import pool.dao.pool_dao_impl;
import pool.model.login;
import pool.service.pool_service_dao;
import pool.service.pool_service_dao_impl;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import java.io.IOException;
/**
 * Created with IntelliJ IDEA.
 * User: Sadiq
 * Date: 7/3/17
 * Time: 2:26 AM
 * To change this template use File | Settings | File Templates.
 */
public class LoginServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        pool_dao pool_dao = new pool_dao_impl();
        pool_service_dao pool_service_dao = new pool_service_dao_impl(pool_dao);
        String address = "" , action = "" ;
        action = request.getParameter("action") ;
        if (action.equals("login"))
        {
            String username  = request.getParameter("username");
            String password = request.getParameter("password");
            if (username.isEmpty() || password.isEmpty()) {
                request.setAttribute("message","Login və parolu boş saxlamayın !");
            }  else
            {
                try {
                      login login = pool_service_dao.check_login(username,password);
                      if(login!=null) {
                          HttpSession session = request.getSession(true);
                          session.setAttribute("login",login);
                          address="index.jsp" ;
                      }  else {
                          request.setAttribute("message","Login və ya parol səhvdir !");
                          address = "/login.jsp";
                      }
                    } catch (Exception e) {
                     e.printStackTrace();
                }
            }
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(address);    dispatcher.forward(request,response);
    }
}
