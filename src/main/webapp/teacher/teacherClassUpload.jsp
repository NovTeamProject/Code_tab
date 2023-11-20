<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023-11-20
  Time: 오후 7:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="${pageContext.request.contextPath}/teacher/css/styles.css?ver=1" rel="stylesheet">
    <!-- Bootstrap icons-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet"/>
</head>
<body>

<section class="py-5">
    <div class="container px-5">
        <div class="bg-light rounded-3 py-5 px-4 px-md-5 mb-5">

            <div class="text-center mb-5">
                <div class="feature bg-primary bg-gradient text-white rounded-3 mb-3">
                    <i class="bi bi-cloud-upload-fill"></i>
                </div>
                <h1 class="fw-bolder">새 강의 등록</h1>
                <p class="lead fw-normal text-muted mb-0">선생님의 지식을 등록해서 공유하세요</p>
            </div>

            <div class="row gx-5 justify-content-center">
                <div class="col-lg-8 col-xl-6">
                    <form name="class-form" id="class-form">
                        <div class="class-information">
                            <div class="form-floating mb-3">
                                <input class="form-control" id="class-name" name="class-name" type="text">
                                <label for="class-name">강의 제목을 입력하세요</label>
                            </div>
                            <div class="form-floating mb-3">
                                <textarea class="form-control" id="class-explain" name="class-explain" type="text" style="height: 10rem"></textarea>
                                <label for="class-explain">간단한 강의 설명을 입력하세요</label>
                            </div>
                            <div class="form-floating mb-3">
                                <p>강의 대표 사진을 선택하세요</p>
                                <input type="file" name="class-image" id="class-image" />
                            </div>
                            <div class="lesson-container">
                                <input type="hidden" name="class-total-lesson-count" id="class-total-lesson-count" value="1" /><br>
                                <input type="hidden" name="class-total-time" id="class-total-time" value="0" />
                            </div>
                        </div>
                    </form>
                </div>
            </div>

        </div>
    </div>
</section> <%--end </section>--%>
</body>
<!-- Bootstrap core JS-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</html>
