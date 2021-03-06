<%-- 
    Document   : admin_menu.jsp
    Author     : jongmin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="cse.maven_webmail.model.UserAdminAgent"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@taglib tagdir="/WEB-INF/tags" prefix="mytags" %>
<%@page errorPage="ErrorPage.jsp"%>

<!DOCTYPE html>

<html lang="en" xml:lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>사용자 관리 메뉴</title>
        <link type="text/css" rel="stylesheet" href="css/main_style.css" />
    </head>
    <body>
        <jsp:include page="header.jsp" />
        <%
            String userid = (String) session.getAttribute("userid");

            if (userid.equals("admin")) {
        %>
        <div id="sidebar">
            <jsp:include page="sidebar_admin_menu.jsp" />
        </div>
        <div id="main">
            <h2> 메일 사용자 목록 </h2>
            <c:catch var="errorReason">
                <mytags:listusers user="jdbctester" password="43319521"
                                  schema="webmail" table="userinfo" />
            </c:catch>
            ${empty errorReason ? "<noerror/>" : errorReason} 
            <%
                }
            %>

        </div>
        <jsp:include page="footer.jsp" />
    </body>
</html>
