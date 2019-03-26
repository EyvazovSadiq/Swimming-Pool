<%--
  Created by IntelliJ IDEA.
  User: Sadiq
  Date: 6/23/17
  Time: 6:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<option value="0">Choose :</option>
<option value="1">Only once</option>

<c:forEach items="${swimmerComboList}" var="model" begin="0">

<option value="${model.id}">${model.name} ${model.surname} - ${model.code} </option>

</c:forEach>
