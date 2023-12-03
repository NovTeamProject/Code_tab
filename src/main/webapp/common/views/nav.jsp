<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <title>ChunJae-Study</title>
    <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/common/image/로고.png" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
</head>

<body>
<div>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container px-5">
            <img src="${pageContext.request.contextPath}/common/image/작은로고.png" width="70rem" height="50rem">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/redirect_to_index.jsp">코딩탭</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                    <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/class/list.do">전체강의목록</a></li>
                    <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/ranking.do">명예의전당</a></li>
                    <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/exam/views/exam.jsp">모의채점</a></li>
                    <c:if test="${empty sessionScope.loginMember}">
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
                                ${sessionScope.personType eq 0 ? "[선생님]" : "[학생]"}
                                ${sessionScope.name} 님!
                            </a>
                            <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdownMypage">
                                <c:if test="${not empty sessionScope.personType and sessionScope.personType eq 2}">
                                    <li><a class="dropdown-item" href="${pageContext.request.contextPath}/student/myClass/list.do">나의강의실</a></li>
                                </c:if>
                                <c:if test="${not empty sessionScope.personType and sessionScope.personType eq 0}">
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