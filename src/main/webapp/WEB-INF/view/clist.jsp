<%-- 
    Document   : dashboard_user
    Created on : Jan 24, 2018, 8:13:27 AM
    Author     : hoangit
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
                    <h1>Contact List</h1>
                    <!-- MESSAGE FOR SUCCESS CREATE NEW CONTACT-->
                    <c:if test="${param.act eq 'sv'}">
                        <p class="success">CREATE SUCCESSFULLY!</p>
                    </c:if>
                      <table border="1">
                          <tr>
                            <th>SELECT</th>
                            <th>SR</th>
                            <th>CID</th>
                            <th>NAME</th>
                            <th>PHONE</th>
                            <th>EMAIL</th>
                            <th>ADDRESS</th>
                            <th>REMARK</th>
                            <th>ACTION</th>
                          </tr>
                          
                          <c:if test="${ empty contactList}">
                              <tr>
                                <td align="center" colspan="8" class="error">
                                  No Record Present!
                                </td>
                              </tr>
                          </c:if>
                              
                          <!-- MESSAGE FOR REMOVE CONTACT --> 
                          <c:if test="${param.act eq 'del'}">
                              <p class="success">Remove Contact Successfully!<p>
                          </c:if>
                          <table width="100%">
                            <tr>
                                <td align="right">
                                   <form action="<s:url value="user/contact_search"/>">
                                    <input type="text" value="${param.freeText}" name="freeText" placeholder="Enter text to Search"
                                    <button>Find</button>
                                   </form> 
                              </td>
                            </tr>
                            
                            <form action="<s:url value="user/bulk_contact">">
                                  <button>Delete Selected Record</button>
                                </table>      
                          
                                    <c:forEach var="c" items="${contactList}" varStatus="st">
                                        <tr>
                                          <td align="center"><input type="checkbox" name="cid" value="${c.contactId}"></td>
                                          <td>${st.count}</td>
                                          <td>${c.contactId}</td>
                                          <td>${c.name}</td>
                                          <td>${c.phone}</td>
                                          <td>${c.email}</td>
                                          <td>${c.address}</td>
                                          <td>${c.address}</td>
                                          <!-- BINDING PARAMETER FOR REMOVE ACTION --->
                                          <s:url var="url_remove" value="user/remove_contact">
                                              <s:param  name="cid" value="${c.contactId}" />
                                          </s:url>
                                          <!-- BINDING PARAMETER FOR EDIT ACTION --->
                                          <s:url var="url_update" value="user/update_contact">
                                              <s:param  name="cid" value="${c.contactId}" />
                                          </s:url>
                                          <td><a href="${url_update}">Edit</a> | <a href="${url_remove}">Remove</a></td>
                                      </tr>
                                    </c:forEach>
                                 </table>
                            </form>
                          
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

