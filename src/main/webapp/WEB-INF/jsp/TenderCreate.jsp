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
        <form action="AddServlet" method="POST">
            <input type="text" name="title" placeholder="Enter title"/><br/>
            <textarea cols="40" rows="10" name="description" placeholder="Enter description"></textarea>
            <input type="submit" value="Add"/>
        </form>
    </body>
</html>
