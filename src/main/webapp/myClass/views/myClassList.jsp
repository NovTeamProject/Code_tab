<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<jsp:include page="/common/views/nav.jsp"/>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>CODE-TAB</title>
    <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/common/image/로고.png" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/common/css/style.css?ver=1" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/membership/css/join.css?ver=1" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>


</head>
<body>

<section class="py-5">
    <div class="container px-5 my-5">
        <div class="text-center mb-5">
            <h1 class="fw-bolder">나의 강의실</h1>
            <p class="lead fw-normal text-muted mb-0">오늘도 성장하는 하루 되세요!</p>
        </div>

        <div class="row gx-5">
            <c:choose>
                <c:when test="${ClassList != null and not empty ClassList}">
                    <c:forEach items="${ClassList}" var="item" varStatus="status">


                        <div class="col-md-6 mb-5">
                            <div class="card">
                                <a href="${pageContext.request.contextPath}/student/myClass/detail.do?classIdx=${item.classIdx}">
                                    <img style="width: 100%; height: 400px;" class="card-img-top"
                                         src="${pageContext.request.contextPath}/teacher/class-image/${item.classImageSavedFilename}" alt="..." />
                                </a>
                                <div class="card-body d-flex justify-content-between">
                                    <div>
                                        <a class="h3 fw-bolder text-decoration-none link-dark" href="${pageContext.request.contextPath}/student/myClass/detail.do?classIdx=${item.classIdx}">
                                                ${item.className}
                                        </a><br>
                                        <a class="h5 fw-bolder text-decoration-none link-dark" href="#!">강사: ${item.teacherName}</a>
                                    </div>
                                    <div class="d-flex align-items-start">
                                        <button class="btn btn-primary mb-4 questionBtn mr-3" data-link="${item.classIdx}">
                                            질문하기
                                        </button>
                                        <button class="btn btn-danger mb-4" id="${item.classIdx}">수강 취소하기</button>
                                    </div>
                                </div>
                            </div>
                        </div>


                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <div class="text-center">
                        <h2 class="fw-bolder">현재 수강 중인 강의가 없습니다.</h2>
                        <p class="lead fw-normal text-muted mb-0">새로운 강의를 수강신청 해보세요.</p><br><br>
                        <a class="btn btn-lg btn-primary" href="${pageContext.request.contextPath}/class/list.do">수강 가능한 강의 목록 보기</a>
                    </div>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</section>

<section class="py-5 bg-light">
    <div class="container px-5 my-5">
        <h4 class="display-6 fw-bolder mb-4 text-dark">CODE TAB 회원님의 성장을 응원합니다.</h4>
        <h6 class="lead fw-normal text-muted mb-0">Believe in yourself.</h6>
    </div>
</section>

<%--강의 삭제 요청--%>
<script>
    document.querySelectorAll('button[id]').forEach(function(button) {
        button.addEventListener('click', function(event) {
            var classIdx = event.target.id;
            $.ajax({
                url: '${pageContext.request.contextPath}/student/myClass/delete.do',
                type: 'post',
                data: { classIdx: classIdx },
                success: function(response) {
                    if(response.trim() == 'success') {
                        alert('강의가 성공적으로 삭제되었습니다.');
                        location.href = '${pageContext.request.contextPath}/student/myClass/list.do';
                    } else {
                        alert('강의 삭제에 실패하였습니다.');
                    }
                },
                error: function() {
                    alert('강의 삭제에 실패하였습니다.');
                }
            });
        });
    });

    $(".questionBtn").on("click", function () {
        let classIdx = $(this).attr("data-link");
        console.log(classIdx);
        location.href = '${pageContext.request.contextPath}' + "/board/list.do?classIdx=" + classIdx;
    })
</script>
</body>
</html>
<jsp:include page="/common/views/footer.jsp"/>