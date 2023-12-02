<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>나의 강의실</title>
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
            <c:if test="${not empty classList}">
                <c:forEach items="${classList}" var="class">

<%--                    <div class="col-lg-6">--%>
<%--                        <div class="position-relative mb-5">--%>
<%--                            <img class="img-fluid rounded-3 mb-3" src="https://dummyimage.com/600x400/343a40/6c757d" alt="..." />--%>
<%--                            <a class="h3 fw-bolder text-decoration-none link-dark stretched-link" href="#!">${class.className}</a><br>--%>
<%--                            <a class="h5 fw-bolder text-decoration-none link-dark stretched-link" href="#!">강사 : ${class.teacherName}</a>--%>
<%--                            <button class="btn btn-primary position-absolute bottom-0 end-0 mb-4">질문하기</button>--%>
<%--                        </div>--%>
<%--                    </div>--%>


<%--                    수정된 코드--%>
                    <div class="position-relative mb-5">
                        <img class="img-fluid rounded-3 mb-3" src="https://dummyimage.com/600x400/343a40/6c757d" alt="..." />
                        <a class="h3 fw-bolder text-decoration-none link-dark stretched-link" href="#!">${class.className}</a><br>
                        <a class="h5 fw-bolder text-decoration-none link-dark stretched-link" href="#!">강사 : ${class.teacherName}</a>
                        <div class="float-end">
                            <button class="btn btn-primary mb-4">질문하기</button>
                            <button class="btn btn-danger mb-4" id="${class.classIdx}">강의 삭제하기</button>
                        </div>
                    </div>


                </c:forEach>
            </c:if>

        </div>
    </div>

</section>
<section class="py-5 bg-light">
    <div class="container px-5 my-5">
        <h4 class="display-6 fw-bolder mb-4">천재스터디 회원님의 성장을 응원합니다.</h4>
        <a class="btn btn-lg btn-primary" href="#!"></a>
    </div>
</section>


<%--강의 삭제 요청--%>
<script>
    document.querySelectorAll('button[id]').forEach(function(button) {
        button.addEventListener('click', function(event) {
            var classIdx = event.target.id;
            $.ajax({
                url: '/deleteClass',
                type: 'post',
                data: { classIdx: classIdx },
                success: function() {
                    alert('강의가 삭제되었습니다.');
                    location.reload();
                },
                error: function() {
                    alert('강의 삭제에 실패했습니다.');
                }
            });
        });
    });
</script>

</body>
</html>