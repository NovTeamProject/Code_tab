<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="utf-8" %>

<%
    //방법1. 회원 인증정보 속성삭제
    session.removeAttribute("loginMember");

    //방법2. 모든 속성 한꺼번에 삭제
    session.invalidate();

    //속성 상제 후 페이지이동
    response.sendRedirect(request.getContextPath() +"/index.jsp");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>
