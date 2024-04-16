<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tenders</title>
    </head>
    <body>
        <%@include file="Navigation.jspf"%>
        <%@include file="Log.jspf"%>
          <c:forEach var="tender" items="${myTenders}">
            <form action="TenderServlet" method="POST">
                <input type="hidden" name="tender" value="${tender.getTenderId()}" />
                <input type="submit" value="${tender.getTitle()}"/>
            </form>
        </c:forEach>
    </body>
</html>
