<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tenders</title>
    </head>
    <body>
        <%@include file="/WEB-INF/jsp/Navigation.jspf"%>
        <%@include file="/WEB-INF/jsp/Log.jspf"%>
        <c:forEach var="tender" items="${allTenders}">
            <c:if test="${tender.isOpened()==true}">
                <form action="TenderServlet" method="GET">
                    <input type="hidden" name="tender" value="${tender.getTenderId()}" />
                    <input type="submit" value="${tender.getTitle()}"/>
                </form>
            </c:if>
        </c:forEach>
        <form action ="SearchServlet" method="GET">
                <input type="title" name="title" placeholder="Enter here"/><br/>
                <input type="submit" value="Search"/>
        </form>
           
        
        
    </body>
</html>
