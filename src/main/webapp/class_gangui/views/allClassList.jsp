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
    <title>전체 등록된 강의 목록</title>
    <link href="${pageContext.request.contextPath}/teacher/css/styles.css?ver=1" rel="stylesheet">
    <!-- Bootstrap icons-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet"/>
    <!-- jquery cdn-->
    <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
            crossorigin="anonymous"></script>
    <style>
        img {
            width: 500px!important;
            height: 300px!important;
        }
    </style>
</head>
<body class="d-flex flex-column h-100">
    <main class="flex-shrink-0">
        <section class="py-5">
            <div class="container px-5 my-5">
                <div class="text-center mb-5">
                    <h1 class="fw-bolder">전체 강의</h1>
                    <p class="lead fw-normal text-muted mb-5">등록된 강의: (${pageMaker.totalCount})개</p>
                </div>
                <c:choose>
                    <c:when test="${pageMaker.totalCount > 0 and not empty classList}">
                        <c:set var="no" value="${pageMaker.totalCount - ((pageMaker.cri.pageNum - 1) * 10)}" />
                        <div class="row gx-5">
                            <c:forEach items="${classList}" var="item" varStatus="loop">
                                <div class="col-lg-4">
                                    <div class="position-relative mb-5">
                                        <div>
                                            <img class="img-fluid rounded-3 mb-3" src="${pageContext.request.contextPath}/teacher/class-image/${item.classImageSavedFilename}" />
                                            <br /><a class="h3 fw-bolder text-decoration-none link-dark stretched-link"
                                                     href="${pageContext.request.contextPath}/teacher/class/detail.do?classIdx=${item.classIdx}">${item.className}</a>
                                        </div><br />
                                        <p class="fw-light">등록일: ${item.classRegisterDateWithYearMonthDay}</p>
                                    </div>
                                </div>
                                <c:set var="no" value="${no - 1}" />
                            </c:forEach>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <h3>아직 등록한 강의가 없습니다</h3>
                    </c:otherwise>
                </c:choose>
            </div>

            <%--paging--%>
            <c:if test="${pageMaker.totalCount > 0 and not empty classList}">
                <nav aria-label="Page navigation example">
                    <ul class="pagination justify-content-center">
                        <c:if test="${pageMaker.prev}">
                            <li class="page-item">
                                <a class="page-link" href="${pageMaker.startPage - 1}" tabindex="-1" aria-disabled="true">이전</a>
                            </li>
                        </c:if>
                        <c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
                            <c:choose>
                                <c:when test="${pageMaker.cri.pageNum == num}">
                                    <li class="page-item active">
                                        <span class="page-link">${num}</span>
                                    </li>
                                </c:when>
                                <c:otherwise>
                                    <li class="page-item">
                                        <a class="page-link" href="${num}">${num}</a>
                                    </li>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                        <c:if test="${pageMaker.next}">
                            <li class="page-item"><a class="page-link" href="${pageMaker.endPage + 1}">다음</a></li>
                        </c:if>
                    </ul>
                </nav>
            </c:if>
        </section>
    </main>
</body>
<!-- Bootstrap core JS-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<script>
    $("a.page-item").on("click", function(e) {
        e.preventDefault();
        location.href = '${pageContext.request.contextPath}' + "/class/list.do?pageNum=" + $(this).attr("href");
    });
</script>
</html>
