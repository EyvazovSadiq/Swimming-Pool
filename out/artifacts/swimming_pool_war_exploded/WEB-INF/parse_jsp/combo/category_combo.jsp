<%--
  Created by IntelliJ IDEA.
  User: Sadiq
  Date: 6/24/17
  Time: 12:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<option value="0">Seçin :</option>

<c:forEach items="${categoryComboList}" var="model" begin="0">

<option value="${model.id}"> ${model.name} </option>

</c:forEach>