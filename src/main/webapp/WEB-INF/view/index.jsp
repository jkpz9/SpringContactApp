<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <s:url var="url_css" value="/static/css/style.css" />
        <title>Login | Contact App</title>
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
                    <h3>User Login</h3>
                    
                     <!-- MESSAGE FOR LOGIN FAIL -->
                    <c:if test="${err != null}">
                        <p class="error">${err}</p>
                    </c:if>
                    
                    <!-- MESSAGE FOR LOGOUT SUCCESS -->
                    <c:if test="${param.act eq 'lo'}">
                        <p class="success">Logout Successfully!</p>
                    </c:if>
                        
                     <!-- MESSAGE FOR REGISTER SUCCESS -->
                    <c:if test="${param.act eq 'reg'}">
                        <p class="success">Register Successfully!</p>
                    </c:if>
                    
                    <s:url var="url_login" value="/login" />
                    <f:form action="${url_login}" modelAttribute="command">
                        <table border="1">
                            <tr>
                                <td>UserName</td>
                                <td><f:input path="loginName" /></td>
                            </tr>
                            <tr>
                                <td>Password</td>
                                <td><f:password path="password" /></td>
                            </tr>
                            <tr>
                                <td colspan="2" align="right">
                                    <button>Login</button>
                                    <a href="#">New User Registration</a>
                                </td>
                            </tr>
                        </table>
                    </f:form>
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
