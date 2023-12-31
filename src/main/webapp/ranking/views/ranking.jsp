<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/common/views/nav.jsp" />

<!DOCTYPE html>
<html>
<head>
    <link href="${pageContext.request.contextPath}/common/css/style.css?ver=1" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    <title>명예의 전당</title>
</head>
<body class="d-flex flex-column h-100">
<main class="flex-shrink-0">
<%--명예의전당--%>
    <section class="bg-light py-5">
        <div class="container px-5 my-5">
            <div class="text-center mb-5">
                <h1 class="fw-bolder">명예의 전당</h1>
                <p class="lead fw-normal text-muted mb-0">인기강의와 추천강의를 볼 수 있습니다.</p>
            </div>
            <div class="row gx-5 justify-content-center">
            <%-- 인기강의 수강중인 학생이 많은 순으로 인기강의를 출력한다. --%>
                <div class="col-lg-6 col-xl-4">
                    <div class="card mb-5 mb-xl-0">
                        <div class="card-body p-2">
                            <div class="small text-uppercase fw-bold text-muted" align="center" >
                                <h3><i class="bi bi-star-fill text-warning"></i> 인기강의</h3></div>

                            <ul class="list-unstyled mb-4">
            <%--  rankingClass라는 이름의 Collection을 순회하면서, 각각의 아이템을 className이라는 변수에 저장하고, 현재 반복의 상태를 loop라는 변수에 저장합니다. end="9"는 총 10개의 항목(0부터 시작하므로)만 반복하라는 의미입니다.   --%>
             <c:forEach items="${rankingClass}" var="className" varStatus="loop" end="9">
                 <c:set var="index" value="${loop.index}" />
                    <li class="mb-2">
                     <p>
            <%--   조건문을 통해서 인덱스가 0이면 1등으로 표시하고 아니면 순위를 표시한다. (1등을 강조하기 위해서)--%>
                         <c:choose>
                           <c:when test="${index == 0}">
                               <a href="${pageContext.request.contextPath}/class/detail.do?classIdx=${className.class_idx}"> <span class="display-6 fw-bold"><img width="32" height="32" src="https://img.icons8.com/cotton/64/crown--v1.png" alt="crown--v1"/></i>  ${className.class_name}</span></a>
                           </c:when>
                        <c:otherwise>
                            <a href="${pageContext.request.contextPath}/class/detail.do?classIdx=${className.class_idx}">   <img width="16" height="16" src="https://img.icons8.com/cotton/64/thumb-up--v5.png" alt="thumb-up--v5"/> ${index + 1} &nbsp ${className.class_name}</a>
                       </c:otherwise>
                         </c:choose>
                     </p>
                    </li>
             </c:forEach>
                            </ul>
                            <div class="d-grid"><a class="btn btn-outline-primary" href="${pageContext.request.contextPath}/class/list.do">강의신청</a></div>
                        </div>
                    </div>
                </div>
            <%--  추천강의 업로드 날짜로 해서 최신강의를 추천한다.  --%>
                <div class="col-lg-6 col-xl-4">
                    <div class="card mb-5 mb-xl-0">
                        <div class="card-body p-2">
                            <div class="small text-uppercase fw-bold text-muted" align="center" >
                                <h3><img width="32" height="32" src="https://img.icons8.com/external-nawicon-flat-nawicon/64/external-Quality-ecommerce-nawicon-flat-nawicon.png" alt="external-Quality-ecommerce-nawicon-flat-nawicon"/> 추천강의</h3></div>

                            <ul class="list-unstyled mb-4">
             <%--  uprankingClass 이름의 Collection을 순회하면서, 각각의 아이템을 className이라는 변수에 저장하고, 현재 반복의 상태를 loop라는 변수에 저장합니다. end="9"는 총 10개의 항목(0부터 시작하므로)만 반복하라는 의미입니다.   --%>
                                <c:forEach items="${uprankingClass}" var="upclassName" varStatus="loop" end="9">
                                    <c:set var="index" value="${loop.index}" />
                                    <li class="mb-2">
                                        <p>
              <%--   조건문을 통해서 인덱스가 0이면 1등으로 표시하고 아니면 순위를 표시한다. (1등을 강조하기 위해서)--%>
                                            <c:choose>
                                                <c:when test="${index == 0}">
                                                    <a href="${pageContext.request.contextPath}/class/detail.do?classIdx=${upclassName.class_idx}"><span class="display-6 fw-bold"><img width="32" height="32" src="https://img.icons8.com/cotton/64/crown--v1.png" alt="crown--v1"/></i>  ${upclassName.class_name}</span></a>
                                                </c:when>
                                                <c:otherwise>
                                                    <a href="${pageContext.request.contextPath}/class/detail.do?classIdx=${upclassName.class_idx}">  <img width="16" height="16" src="https://img.icons8.com/pastel-glyph/64/thumb-up--v2.png" alt="thumb-up--v2"/> ${index + 1} &nbsp ${upclassName.class_name}</a>
                                                </c:otherwise>
                                            </c:choose>
                                        </p>
                                    </li>
                                </c:forEach>
                            </ul>
                            <div class="d-grid"><a class="btn btn-primary" href="${pageContext.request.contextPath}/class/list.do">강의 신청</a></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <br/><br/><br/><br/>
</main>

</body>
</html>
<jsp:include page="/common/views/footer.jsp" />