<%--
  Created by IntelliJ IDEA.
  User: Sadiq
  Date: 5/23/18
  Time: 6:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    session.removeAttribute("login");
    session.invalidate();
    response.sendRedirect("login.jsp");
%>