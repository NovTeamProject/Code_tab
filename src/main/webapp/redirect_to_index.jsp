<%--
  Created by IntelliJ IDEA.
  User: eggja
  Date: 2023-12-02
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    response.sendRedirect(request.getContextPath() + "/index.do");
%>
</body>
</html>
