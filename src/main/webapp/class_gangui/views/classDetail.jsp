<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023-11-20
  Time: 오후 7:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>강의 상세보기</title>
    <link href="${pageContext.request.contextPath}/teacher/css/styles.css?ver=1" rel="stylesheet">
    <!-- Bootstrap icons-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet"/>
    <!-- jquery cdn-->
    <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
            crossorigin="anonymous"></script>
    <!-- plyr cdn-->
    <link rel="stylesheet" href="https://cdn.plyr.io/3.7.8/plyr.css" />
    <script src="https://cdn.plyr.io/3.7.8/plyr.js"></script>
    <style>
    </style>
</head>
<body class="d-flex flex-column">

<jsp:include page="/common/views/nav.jsp"></jsp:include>

    <main class="flex-shrink-0">
        <section class="py-5 bg-light" id="scroll-target">
            <div class="container px-5 my-5">
                <div class="row gx-5 align-items-center">
                    <div class="col-lg-6">
                        <img class="img-fluid rounded mb-5 mb-lg-0"
                             src="${pageContext.request.contextPath}/teacher/class-image/${classDTO.classImageSavedFilename}" />
                    </div>
                    <div class="col-lg-6">
                        <h2 class="fw-bolder">
                            <c:out value="${classDTO.className}" />
                        </h2>
                        <p class="lead fw-normal text-muted mb-0">
                            <c:out value="${classDTO.classExplain}" />
                        </p>
                    </div>
                </div>
                <div class="my-3">
                    <table class="table table-borderless">
                        <tbody>
                            <tr>
                                <th scope="row">등록일시</th>
                                <td><c:out value="${classDTO.classRegisterDateWithYearMonthDayHourMinute}" /></td>
                            </tr>
                            <tr>
                                <th scope="row">강의길이</th>
                                <td><c:out value="${classDTO.classTotalTime} (초)" /></td>
                            </tr>
                            <tr>
                                <th scope="row">수업개수</th>
                                <td colspan="2"><c:out value="${classDTO.lessonList.size()} (개)" /></td>
                            </tr>
                            <tr>
                                <th scope="row">수강학생</th>
                                <td colspan="2"><c:out value="${classDTO.listenStudent} (명)" /></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <c:choose>
                    <c:when test="${not empty sessionScope.loginMember and not empty sessionScope.personType and sessionScope.personType eq 2}">
                        <div style="text-align: right">
                            <button type="button" class="btn btn-outline-warning" id="classRegisterBtn">수강 신청하기</button>
                        </div>
                    </c:when>
                    <c:when test="${not empty sessionScope.loginMember and not empty sessionScope.personType and sessionScope.personType eq 0 and sessionScope.teacherIdx eq classDTO.teacherIdx}">
                        <div style="text-align: right">
                            <button type="button" class="btn btn-outline-success" disabled>내가 등록한 강의</button>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div style="text-align: right">
                            <button type="button" class="btn btn-outline-danger" id="goToStudentLoginBtn">학생으로 로그인 후 수강신청할 수 있어요!</button>
                        </div>
                    </c:otherwise>
                </c:choose>
            </div>
        </section>

        <h3 style="text-align: center; margin-top: 50px;">강의 수업 리스트</h3>
        <div class="d-flex justify-content-center" style="margin-bottom: 50px;">
        <div class="accordion" id="accordionExample" style="width: 70%">
            <c:forEach items="${classDTO.lessonList}" var="lesson" varStatus="loop">
                <c:choose>
                    <c:when test="${loop.index + 1 == 1}">
                        <div class="accordion-item accordion-item-${loop.index + 1}">
                            <h2 class="accordion-header">
                                <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                                    ${lesson.lessonName}
                                </button>
                            </h2>
                            <div id="collapseOne" class="accordion-collapse collapse show" data-bs-parent="#accordionExample">
                                <div class="accordion-body">
                                    <div class="d-flex justify-content-center">
                                        <div style="width: 70%">
                                            <p>강의 재생 시간: ${lesson.lessonTime}(초)</p>
                                            <video id="lesson-video-${loop.index + 1}" playsinline controls data-poster="">
                                                <source src="${pageContext.request.contextPath}/teacher/lesson-video/${lesson.lessonSavedFilename}" type="video/mp4" />
                                            </video>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div class="accordion-item accordion-item-${loop.index + 1}">
                            <h2 class="accordion-header">
                                <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapse${loop.index + 1}" aria-expanded="false" aria-controls="collapse${loop.index + 1}">
                                    ${lesson.lessonName}
                                </button>
                            </h2>
                            <div id="collapse${loop.index + 1}" class="accordion-collapse collapse" data-bs-parent="#accordionExample">
                                <div class="accordion-body">
                                    <div class="d-flex justify-content-center">
                                        <div style="width: 70%">
                                            <p>강의 재생 시간: ${lesson.lessonTime}(초)</p>
                                            <h4>수강신청 후 전체 강의 동영상을 확인할 수 있어요!</h4>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </div>
        </div>
    </main>
<script>
    const playerList = {};
    let index = 1;
    <c:forEach items="${classDTO.lessonList}" varStatus="loop">
        playerList["lesson-video-" + (index++)] = new Plyr("#lesson-video-${loop.index + 1}");
    </c:forEach>
</script>
</body>
<script>
    $("#goToStudentLoginBtn").on("click", function() {
        location.href = '${pageContext.request.contextPath}' + "/membership/views/loginStudent.jsp";
    });
    $("#classRegisterBtn").on("click", function() {
        location.href = '${pageContext.request.contextPath}' + "/student/myClass/register.do?classIdx=" + '${classDTO.classIdx}';
    });
</script>
<!-- Bootstrap core JS-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</html>
<%--
<%
    request.setAttribute("testAttr", "Hello World!");
    request.getRequestDispatcher("/teacher/class/detail.do").forward(request, response);
    servlet으로 testArr의 값 잘 넘어감
%>
--%>
