<%--
  Created by IntelliJ IDEA.
  User: Jaehyuk
  Date: 2023-12-29
  Time: 오후 8:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        HttpSession httpSession = request.getSession(false);
        if (httpSession == null) {
            System.out.println("Session is Null");
        } else {
            System.out.println("Session is NOT Null"); // 이거출력 BUT session="false" 가 설정되어 있다면, Session is Null 출력
            System.out.println(httpSession.getId());
        }
        if (httpSession != null) {
            System.out.println("session invalidated...");
            httpSession.invalidate();
        } else {
            System.out.println("session can't be invalidated");
        }
    %>
</body>
</html>
