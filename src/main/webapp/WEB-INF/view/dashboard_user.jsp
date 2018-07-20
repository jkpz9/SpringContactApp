<%-- 
    Document   : dashboard_user
    Created on : Jan 24, 2018, 8:13:27 AM
    Author     : hoangit
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <s:url var="url_css" value="/static/css/style.css" />
        <title>User DASHBOARD</title>
        <link rel="stylesheet" href="${url_css}"/>
    </head>
    <s:url var="url_bg" value="/static/images/pexels-photo-755726" />
    <body background="${url_bg}">
        <table width="80%" align="center">
            <tr>
                <td  height="100px">
                    <!-- Header -->
                    <jsp:include page="/include/header.jsp" />
                </td>
            </tr> 
            <tr>
                <td height="25px">
                    <!-- Menu -->
                     <jsp:include page="/include/menu.jsp" />
                </td>
            </tr
            <tr>
                <td height="350px" valign="top">
                    <!-- Main Content -->
                    <h1>User Login</h1>
                </td>
            </tr>
            <tr>
                <td height="25px">
                    <!-- Footer -->
                     <jsp:include page="/include/footer.jsp" />
                </td>
            </tr
        </table>
    </body>
</html>

