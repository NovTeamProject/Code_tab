<%--
  Created by IntelliJ IDEA.
  작성자: 차소영
  최종 수정일 : 2023-12-11
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<jsp:include page="/common/views/nav.jsp"></jsp:include>
<html>
<head>

    <title>학생 - 내 강의 상세 보기</title>

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
<body class="d-flex flex-column"> <%--해당 요소의 자식 요소들은 수직으로 일렬로 배치되게 된다. 이를 통해 레이아웃을 쉽게 조정할 수 있다.--%>
<main class="flex-shrink-0">  <!-- 'flex-shrink-0' 클래스는 메인 컨텐츠가 축소되지 않도록 설정 -->
    <%--    <section class="py-5 bg-light" id="scroll-target">--%>
    <section class="py-5" style="background-color: #ddf3ff;" id="scroll-target">
        <div class="container px-5 my-5">
            <%--py-5, px-5, my-5, mb-5, mb-lg-0: 이들 클래스는 각각 요소의 상하 여백(padding)과 마진(margin)을 설정한다.
            p는 패딩, m은 마진을 의미하며 y, x는 각각 수직, 수평 방향을 의미한다.
            숫자는 크기를 의미하며, 1부터 5까지 있다.
            mb-lg-0은 화면 크기가 lg(large) 이상일 때 마진 값을 0으로 설정한다. --%>

            <div class="text-center mb-5">
                <h1 class="fw-bolder">강의 상세 보기</h1>
                <p class="lead fw-normal text-muted mb-0">강의 상세 정보를 확인하세요.</p>
            </div> <%--fw-bolder, fw-normal: 글자 긁기 설정. fw는 font-weight를 의미하며, bolder는 더 굵게, normal은 일반 두께를 의미.--%>
            <div class="row gx-5 align-items-center"> <%--gx-5는 수평 갭(gap) 사이즈를 설정--%>
                <div class="col-lg-6">
                    <img class="img-fluid rounded mb-5 mb-lg-0" <%-- img-fluid : 이미지의 최대 너비를 현재 컨테이너의 너비로 설정하여, 이미지가 컨테이너의 너비를 넘어가지 않도록 한다.--%>
                         src="${pageContext.request.contextPath}/teacher/class-image/${classDTO.classImageSavedFilename}" />
                </div>
                <div class="col-lg-6">
                    <h2 class="fw-bolder">
                        <c:out value="${classDTO.className}" /> <!-- c:out 태그는 JSP Expression Language(EL) 표현식의 값을 출력한다. 여기서는 강의 이름을 출력 -->
                    </h2>
                    <p class="lead fw-normal text-muted mb-0">
                        <c:out value="${classDTO.classExplain}" /> <!-- c:out 태그로 강의 설명을 출력 -->
                    </p>
                </div>
            </div>

            <div class="my-3">  <!-- my-3은 margin-top과 margin-bottom의 값을 3으로 설정하는 Bootstrap 클래스 -->
                <table class="table table-borderless">
                    <tbody>
                    <tr>
                        <th scope="row">등록 일시</th> <!-- th : 테이블의 헤더 셀을 정의하는 태그. scope="row"는 이 헤더 셀이 행에 대한 헤더임을 나타냄. -->
                        <fmt:parseDate pattern="yyyy-MM-dd'T'HH:mm"
                                       var="parsedDateTime" value="${classDTO.classRegisterDate}" type="both" />
                        <!-- fmt:parseDate 태그는 문자열로 된 날짜를 Date 객체로 변환. -->
                        <!-- pattern 속성은 날짜의 패턴을 지정하고, var 속성은 변환된 Date 객체를 저장할 변수의 이름을 지정 -->
                        <!-- value 속성은 변환할 날짜 문자열을 지정하고, type 속성은 날짜와 시간 모두를 포함하는 Date 객체를 생성하도록 지정. -->

                        <fmt:formatDate pattern="yyyy-MM-dd HH:mm" var="registeredDate" value="${parsedDateTime}" />

                        <td><c:out value="${registeredDate}" /></td>
                        <!-- td 태그는 테이블의 데이터 셀을 정의하는 태그 -->
                        <!-- c:out 태그는 JSP Expression Language(EL) 표현식의 값을 출력 -->

                    </tr>
                    <tr>
                        <th scope="row">총 강의 시간</th>
                        <td><c:out value="${classDTO.hourMinSec}" /></td>
                    </tr>
                    <tr>
                        <th scope="row">수업 개수</th>
                        <td colspan="2"><c:out value="${classDTO.lessonList.size()} (개)" /></td>
                    </tr>
                    <tr>
                        <th scope="row">수강 중인 학생 수</th>
                        <td colspan="2"><c:out value="${classDTO.listenStudent} (명)" /></td>
                    </tr>
                    </tbody>
                </table>
            </div>
            <br>
            <div style="text-align: right">
                <button class="btn btn-lg btn-primary questionBtn" data-link="${classDTO.classIdx}">
                    질문 게시판 바로가기
                </button>
            </div>


        </div>
    </section>

    <h2 class="fw-bolder" style="text-align: center; margin-top: 50px;">강의 수업 리스트</h2>
    <div class="d-flex justify-content-center" style="margin-bottom: 50px;">  <!-- 'd-flex' 클래스는 컨테이너를 플렉스 박스로 설정하고, 'justify-content-center' 클래스는 요소들을 가로 방향으로 가운데 정렬 -->
        <div class="accordion" id="accordionExample" style="width: 70%"> <!-- 'accordion' 클래스는 아코디언 스타일의 컨테이너를 생성하고, 'width: 70%' 속성은 너비를 70%로 설정. -->
            <c:forEach items="${classDTO.lessonList}" var="lesson" varStatus="loop"> <!-- 'lessonList' 속성 값을 반복하여 출력. -->
                <c:choose>
                    <c:when test="${loop.index + 1 == 1}">  <!-- 첫 번째 수업일 경우 -->
                        <div class="accordion-item accordion-item-${loop.index + 1}">  <%-- 아코디언 아이템을 생성하고, 'accordion-item- ${loop.index + 1}' 클래스를 추가--%>
                            <h2 class="accordion-header">
                                <button style="font-weight: bolder; font-size: 18px" class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                                        ${lesson.lessonName}
                                </button>
                            </h2>
                            <div id="collapseOne" class="accordion-collapse collapse show" data-bs-parent="#accordionExample">
                                <div class="accordion-body">
                                    <div class="d-flex justify-content-center">
                                        <div style="width: 70%">
                                            <p style="font-size: 20px;">수업 재생 시간: ${lesson.hourMinSec}</p>
                                            <video id="lesson-video-${loop.index + 1}" playsinline controls data-poster="">
                                                <source src="${pageContext.request.contextPath}/teacher/lesson-video/${lesson.lessonSavedFilename}" type="video/mp4" />
                                            </video>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:when>
                    <c:otherwise> <!-- 첫 번째 수업이 아닌 경우 -->
                        <div class="accordion-item accordion-item-${loop.index + 1}">  <%-- 아코디언 아이템을 생성하고, 'accordion-item-${loop.index + 1}' 클래스를 추가 --%>
                            <h2 class="accordion-header">
                                <button style="font-weight: bolder; font-size: 18px" class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapse${loop.index + 1}" aria-expanded="false" aria-controls="collapseTwo">
                                        ${lesson.lessonName}
                                </button>
                            </h2>
                            <div id="collapse${loop.index + 1}" class="accordion-collapse collapse" data-bs-parent="#accordionExample">
                                <div class="accordion-body">
                                    <div class="d-flex justify-content-center">
                                        <div style="width: 70%">
                                            <p style="font-size: 20px;">수업 재생 시간: ${lesson.hourMinSec}</p>
                                            <video id="lesson-video-${loop.index + 1}" playsinline controls data-poster="">
                                                <source src="${pageContext.request.contextPath}/teacher/lesson-video/${lesson.lessonSavedFilename}" type="video/mp4" />
                                            </video>
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
    const playerList = {}; // 플레이어 목록을 담을 빈 객체를 생성, 플레이어들을 저장하기 위한 용도로 사용
    let index = 1; // 인덱스 변수를 초기화, 이 변수는 플레이어 객체의 id에 사용
    <c:forEach items="${classDTO.lessonList}" varStatus="loop"> // classDTO의 lessonList를 순회하면서 플레이어를 생성하여 playerList에 추가.
    playerList["lesson-video-" + (index++)] = new Plyr("#lesson-video-${loop.index + 1}");  //플레이어 객체의 id는 lesson-video-1, lesson-video-2, ...와 같이 순차적으로 지정
    </c:forEach>

    $(".questionBtn").on("click", function () { // 질문 버튼을 클릭했을 때의 동작을 정의
        let classIdx = $(this).attr("data-link"); // data-link 속성에서 classIdx 값을 가져옴.
        location.href = '${pageContext.request.contextPath}' + "/board/list.do?classIdx=" + classIdx; // 게시판 페이지로 이동
    })

</script>
<script>
    window.onscroll = function() {
        const nav = document.querySelector('.navbar');
        if (window.pageYOffset > 50) {
            nav.classList.add('sticky');
        } else {
            nav.classList.remove('sticky');
        }
    };

    function scrollToSection(id) {
        const section = document.getElementById(id);
        section.scrollIntoView({ behavior: 'smooth' });
    }
</script>
</body>


<%--<script>--%>
<%--    $("#classModifyBtn").on("click", function() {--%>
<%--        location.href = '${pageContext.request.contextPath}' + "/teacher/class/modify.do?classIdx=" + '${param.classIdx}';--%>
<%--    })--%>
<%--</script>--%>
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
<jsp:include page="/common/views/footer.jsp" />