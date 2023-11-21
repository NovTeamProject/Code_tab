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
    <!-- jquery cdn-->
    <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
            crossorigin="anonymous"></script>
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
                                <input class="form-control" id="class-name" name="class-name" type="text"><!--서버 전송 강의 제목-->
                                <label for="class-name">강의 제목을 입력하세요</label>
                            </div>
                            <div class="form-floating mb-3">
                                <!--서버 전송 강의 설명-->
                                <textarea class="form-control" id="class-explain" name="class-explain" type="text" style="height: 10rem"></textarea>
                                <label for="class-explain">간단한 강의 설명을 입력하세요</label>
                            </div>
                            <div class="mb-3">
                                <p>강의 대표 사진을 선택하세요</p>
                                <!--서버 전송 강의 대표 사진-->
                                <input class="form-control" id="class-image" name="class-image" type="file" id="class-image" onchange="showThumbnail(event);">
                                <br />
                                <img id="class-image-thumbnail" width="100%" height="300px" style="border: 1px dashed grey"/>
                            </div>
                            <div class="lesson-container">
                                <!--서버 전송 강의 총 개수(수업 개수의 총 합)-->
                                <input type="hidden" name="class-total-lesson-count" id="class-total-lesson-count" value="1" /><br>
                                <!--서버 전송 강의 총 시간(수업 시간의 총 합)-->
                                <input type="hidden" name="class-total-time" id="class-total-time" value="0" />
                                <div>
                                    <!--보여지는 강의 (수업)의 총 개수랑 강의 (수업)의 총 시간/길이-->
                                    <h5>총 <span id="span-class-total-lesson-count">1</span>개 수업(<span id="span-class-total-time">0</span>&nbsp;초)</h5>
                                </div>
                                <div class="lesson__item lesson__item-1" id="lesson__item-1">
                                    <input type="text" class="form-control lesson-name lesson-name-1" name="lesson-name-1" id="lesson-name-1"
                                           placeholder="수업 제목을 입력해 주세요" /> <!--서버에 전송될 한 개 수업의 제목-->
                                    <!--서버에 전송될 한 개 수업의 동영상 파일-->
                                    <input type="file" class="form-control lesson-video lesson-video-1" name="lesson-video-1" id="lesson-video-1" />
                                    <!--보여질 한 개 수업의 동영상 길이 초-->
                                    <span id="span-lesson-time-1" class="span-lesson-time span-lesson-time-1"></span>(초)
                                    <!--서버에 전송될 한 개 수업의 동영상 길이 초-->
                                    <input type="hidden" id="lesson-time-1" class="lesson-time lesson-time-1" name="lesson-time-1" />
                                </div>
                                <br>
                                <button type="button" class="btn btn-outline-primary lesson-plus-button" name="lesson-plus-button" id="lesson-plus-button">
                                    수업 추가하기</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>

        </div>
    </div>
</section> <%--end </section>--%>
</body>
<!-- custom js-->
<script src="${pageContext.request.contextPath}/teacher/js/teacherClassUpload.js?ver=1"></script>
<!-- Bootstrap core JS-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</html>
