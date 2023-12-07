<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <title>CODE-TAB</title>
    <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/common/image/작은로고2.png" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@500&display=swap" rel="stylesheet">

    <style>
        .nav-link {
            font-weight: bold;
            color: black !important;
        }
    </style>
    <style>
        .navbar-nav .nav-link {
            font-family: 'Noto Sans KR', sans-serif;
            font-size: 1.2rem; /* 폰트 크기 변경 */
            margin-right: 10px; /* 메뉴 사이 간격 설정 */
        }
    </style>

</head>
<%--back 이벤트 일 경우 글작성 후 back키 입력시 데이터가 남아있던 오류 수정하는 JSP--%>
<jsp:include page="/common/views/register.jsp" />
<body>
<div class="navbar1">
    <nav class="navbar navbar-expand-lg navbar-light bg-white">
        <div class="container px-5">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/redirect_to_index.jsp">
                <img src="${pageContext.request.contextPath}/common/image/logo01.png" width="380px" height="70px"></a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                    <li class="nav-item"><a class="nav-link dropdown-toggle" href="${pageContext.request.contextPath}/class/list.do">전체강의목록</a></li>
                    <li class="nav-item"><a class="nav-link dropdown-toggle" href="${pageContext.request.contextPath}/ranking.do">명예의전당</a></li>
                    <li class="nav-item"><a class="nav-link dropdown-toggle" href="${pageContext.request.contextPath}/exam/views/exam.jsp">정답서비스</a></li>
                    <%--  세션에 값(loginMember)에 따라 학생,선생님,비회원의 메뉴를 보여준다.--%>
                    <c:if test="${empty sessionScope.loginMember}">
                        <%--dropdonw메뉴--%>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" id="navbarDropdownBlog" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">로그인</a>
                            <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdownBlog">
                                <li><a class="dropdown-item" href="${pageContext.request.contextPath}/membership/views/loginStudent.jsp">학생 로그인</a></li>
                                <li><a class="dropdown-item" href="${pageContext.request.contextPath}/membership/views/loginTeacher.jsp">선생님 로그인</a></li>
                            </ul>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" id="navbarDropdownRegister" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">회원가입</a>
                            <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdownRegister">
                                <li><a class="dropdown-item" href="${pageContext.request.contextPath}/membership/views/joinStudent.jsp">학생 회원가입</a></li>
                                <li><a class="dropdown-item" href="${pageContext.request.contextPath}/membership/views/joinTeacher.jsp">선생님 회원가입</a></li>
                            </ul>
                        </li>
                    </c:if>

                    <c:if test="${not empty sessionScope.loginMember}">
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" id="navbarDropdownMypage" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                <%--로그인한 사람이 학생인지 선생님인지 확인하는 메뉴 (학생은 2 선생님은 0으로 지정)--%>
                                ${sessionScope.personType eq 0 ? "[선생님]" : "[학생]"}
                                ${sessionScope.name} 님!
                            </a>
                            <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdownMypage">
                                <c:if test="${not empty sessionScope.personType and sessionScope.personType eq 2}">
                                    <li><a class="dropdown-item" href="${pageContext.request.contextPath}/membership/views/editStudent.jsp">회원정보수정</a></li>
                                    <li><a class="dropdown-item" href="${pageContext.request.contextPath}/student/myClass/list.do">나의강의실</a></li>
                                </c:if>
                                <c:if test="${not empty sessionScope.personType and sessionScope.personType eq 0}">
                                    <li><a class="dropdown-item" href="${pageContext.request.contextPath}/membership/views/editTeacher.jsp">회원정보수정</a></li>
                                    <li><a class="dropdown-item" href="${pageContext.request.contextPath}/teacher/class/list.do">내가올린강의목록</a></li>
                                </c:if>
                            </ul>
                        </li>
                        <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/common/views/logout.jsp">로그아웃</a></li>
                    </c:if>
                </ul>
            </div>
        </div>
    </nav>
    </div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js" crossorigin="anonymous"></script>

</body>
</html>