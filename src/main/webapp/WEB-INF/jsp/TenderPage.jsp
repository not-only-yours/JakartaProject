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
        Tender:
        ${tender.getTitle()}<br/>
        ${tender.getDescription()}<br/>
        http://localhost:8080/Tender_Kasiudyk/TenderServlet?tender=${tender.getTenderId()} - URL for this tender<br/>


        <c:if test="${user==tender.getUser()}">
            <form action="deleteServlet" method="POST">
                <input type="hidden" name="del" value="${tender.getTenderId()}">
                <input type="submit" value="delete">
            </form>
            Propositions:
            <c:forEach var="user" items="${tender.getProps()}">
                ${user.getName()}
            </c:forEach>
            <c:if test="${tender.isOpened()==true}">
                <form action="stopServlet" method="POST">
                    <input type="hidden" name="tender" value="${tender.getTenderId()}">
                    <input type="submit" value="stop">
                </form>
            </c:if> 
            <c:if test="${tender.isOpened()==false}">
                <form action="openServlet" method="POST">
                    <input type="hidden" name="tender" value="${tender.getTenderId()}">
                    <input type="submit" value="start">
                </form>
            </c:if> 
        </c:if>
        <c:if test="${user!=tender.getUser()}">
            <c:if test="${tender.isOpened()==true}">
                <form action="PropServlet" method="POST">
                    <input type="hidden" name="tender" value="${tender.getTenderId()}">
                    <input type="submit" value="Make proposition">
                </form>
            </c:if>
        </c:if>
    </body>
</html>
