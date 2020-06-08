<%@ page import="static am.basic.jdbcStart.util.constants.ParameterKeys.USER_ATTRIBUTE_KEY" %>
<%@ page import="am.basic.jdbcStart.model.User" %>
<%@ page import="static am.basic.jdbcStart.util.constants.ParameterKeys.MESSAGE_ATTRIBUTE_KEY" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 08.06.2020
  Time: 19:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Note</title>
</head>
<body>
<a href="/logout" style="float: right">Logout</a>
<h1 style="background: cornflowerblue">This is note page</h1>

<%
    User user = (User) session.getAttribute(USER_ATTRIBUTE_KEY);
    response.getWriter().write("Hello dear " + user.getName() + " " + user.getSurname());
%>

<br><br>
<% if (request.getAttribute(MESSAGE_ATTRIBUTE_KEY) != null) { %>
<%=request.getAttribute(MESSAGE_ATTRIBUTE_KEY)%>
<% } %>
<br><br>

<form method="post" action="/note">
    heading : <input type="text" name="heading"><br/>
    text : <input type="text" name="Text"><br>
    <input type="submit" name="submit"><br>
</form>


</body>
</html>
