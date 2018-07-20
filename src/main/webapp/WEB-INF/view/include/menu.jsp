<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>


<c:if test="${sessionScope.userId == null}">
    <!-- MENU FOR GUEST -->
    <a href="#">Home</a> | <a href="#">Login</a> | <a href="/register">Register</a> | <a href="#">About</a> | <a href="#">Help</a>
</c:if>
    
<c:if test="${sessionScope.userId != null && sessionScope.role == 1}">
    
    <s:url var="url_clist" value="/logout"
    <!-- MENU FOR STANDARD USER -->
     <a href="#">Home</a> | <a href="#">User List</a>| <a href="$url_logout}">Logout</a>
</c:if>
     
     
<c:if test="${sessionScope.userId != null && sessionScope.role == 1}">
    <!-- MENU FOR ADMINISTRATOR -->
    <s:url var="url_clist" value="user/clist"
    <s:url var="url_uhome" value="user/dashboard">
    <s:url var="url_cform" value="user/contact_form">
    <a href="${url_uhome}">Home</a> | <a href="${url_cform}">Add Contact</a> | <a href="${url_clist}">Contact List</a>| <a href="$url_logout}">Logout</a>
</c:if>
         
   