<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<jsp:include page="/common/views/nav.jsp" />
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>ChunJae-Study</title>
    <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/common/image/로고.png" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/common/css/style.css?ver=1" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/membership/css/join.css?ver=1" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/membership/js/joincheck.js"></script>
    <script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
</head>
<body>
<div class="wrapper fadeInDown">
    <div id="formContent">
        <label class="fadeIn third"><h2 class="active">회원가입</h2> </label>
        <form action="${pageContext.request.contextPath}/member/login.do" method="post">
            <input type="text" id="login" class="fadeIn second" name="userID" placeholder="아이디">
            <input type="password" id="password" class="fadeIn third" name="userPW" placeholder="비밀번호" autocomplete="off">
            <input type="password" id="password2" class="fadeIn third" name="userPW" placeholder="비밀번호 확인" autocomplete="off">
            <input type="text" id="name" class="fadeIn third" name="userName" placeholder="이름" autocomplete="off">
            <div class="checkType">
                <label class="fadeIn third"><input type="radio" name="joins" value="student">학생</label>
                <label class="fadeIn third"><input type="radio" name="joins" value="teacher">선생님</label>
            </div>
            <input type="submit" class="fadeIn fourth" value="회원가입">
        </form>
    </div>
</div>
<jsp:include page="/common/views/footer.jsp" />
</body>
</html>
