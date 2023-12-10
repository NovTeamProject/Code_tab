<%--
  Created by IntelliJ IDEA.
  작성자: 차소영
  최종 수정일 : 2023-12-11
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<jsp:include page="/common/views/nav.jsp"/>
<html>
<head>
    <title>나의 강의실</title>
    <link href="${pageContext.request.contextPath}/teacher/css/styles.css?ver=1" rel="stylesheet">
    <!-- Bootstrap icons-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet"/>
    <!-- jquery cdn-->
    <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
            crossorigin="anonymous"></script>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>


</head>
<body>

<section class="py-5"> <!-- py-5 클래스 : 상하 여백(padding)을 나타냄 -->
    <div class="container px-5 my-5"> <!--container 클래스로 내용을 감싸고, px-5 클래스로 가로 여백(padding)을 나타냄 -->
        <div class="text-center mb-5"> <!--mb-5 클래스 : 하단 여백(margin-bottom)을 나타냄.-->
            <h1 class="fw-bolder">나의 강의실</h1> <!-- fw-bolder 클래스 : 글꼴을 두껍게(bold) 설정 -->
            <p class="lead fw-normal text-muted mb-0">오늘도 성장하는 하루 되세요!</p> <!-- text-muted 클래스는 텍스트를 회색으로 설정 -->
        </div> <!-- lead 클래스는 Bootstrap에서 제공하는 클래스로, 글의 리드(중요한 내용을 강조하는 부분) 스타일을 나타냄. 주로 단락의 첫 번째 문장에 적용되어 글을 강조하고 시각적인 효과를 준다.-->

        <div class="row gx-5"> <!--gx-5 클래스는 가로 여백(gutter)을 나타냄 -->
            <c:choose> <!--c:choose 태그를 사용하여 조건에 따라 다른 내용을 표시 -->
                <c:when test="${ClassList != null and not empty ClassList}">  <!-- 조건이 true인 경우, 수강 중인 강의가 있는 경우-->
                    <c:forEach items="${ClassList}" var="item" varStatus="status">
                        <!-- ClassList 변수에 저장된 강의 목록을 순회하는 반복문
                        각각의 강의 정보는 item 변수에 저장되며, 순회 중인 상태 정보는 status 변수에 저장됨. -->

                        <div class="col-md-6 mb-5"> <!--col-md-6 클래스는 반응형 그리드 시스템에서 강의 카드의 너비를 조정, mb-5 클래스는 하단 여백(margin-bottom)을 나타냄 -->
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
                                            질문하기 <!--questionBtn 클래스와 해당 강의의 classIdx를 속성으로 가지는 버튼을 클릭하면 질문하기 페이지로 이동 -->
                                        </button>
                                        <button class="btn btn-danger mb-4" id="${item.classIdx}">수강 취소하기</button>
                                    </div>
                                </div>
                            </div>
                        </div>


                    </c:forEach>
                </c:when> <%-- <c:when> 조건문의 조건이 모두 false인 경우에 실행되는 부분 --%>
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
<%-- ajax 사용 : 웹 페이지 응답성 향상, 사용자 편리성 증대, 부분 업데이트, 서버 부하 감소, 비동기적 결과 처리(사용자에게 즉각적인 피드백 제공)--%>
<script>
    document.querySelectorAll('button[id]').forEach(function(button) {
        button.addEventListener('click', function(event) { <%--각 버튼에 클릭 이벤트를 추가하고, 클릭된 버튼의 id 값을 가져와 classIdx 변수에 저장--%>
            var classIdx = event.target.id; <%-- 클릭된 버튼의 id 값을 가져와 classIdx 변수에 저장. 이 값은 강의의 식별자 역할을 함--%>
            $.ajax({ <%--.ajax() 함수를 사용하여 서버로 강의 삭제 요청을 보냄--%>
                url: '${pageContext.request.contextPath}/student/myClass/delete.do',
                type: 'post', <%--  HTTP 요청 메서드를 설정--%>
                data: { classIdx: classIdx },
                success: function(response) { <%--요청이 성공했을 때 실행되는 콜백 함수를 정의--%>
                    if(response.trim() == 'success') { <%-- 응답 데이터가 'success'인 경우를 확인. 응답 데이터는 response 변수에 저장되며, trim() 함수를 사용하여 앞뒤 공백을 제거한 후 비교.--%>
                        alert('강의가 성공적으로 삭제되었습니다.'); <%--요청이 성공하면 '강의가 성공적으로 삭제되었습니다.' 알림을 표시하고, 페이지를 강의 목록 페이지로 이동--%>
                        location.href = '${pageContext.request.contextPath}/student/myClass/list.do';
                    } else { <%--응답 데이터가 'success'가 아닌 경우를 처리 --%>
                        alert('강의 삭제에 실패하였습니다.');
                    }
                },
                error: function() { <%--요청이 실패했을 때 실행되는 콜백 함수를 정의--%>
                    alert('강의 삭제에 실패하였습니다.');
                }
            });
        });
    });


    <%-- 질문하기 게시판 이동--%>
    $(".questionBtn").on("click", function () { <%--.questionBtn 클래스를 가진 버튼을 클릭하면 해당 버튼의 data-link 속성 값인 classIdx를 가져와 질문하기 페이지로 이동--%>
        let classIdx = $(this).attr("data-link"); <%--클릭된 버튼의 data-link 속성 값을 가져와 classIdx 변수에 저장. 이 값은 질문하기 페이지로 전달될 강의의 식별자 역할을 함--%>
        console.log(classIdx);
        location.href = '${pageContext.request.contextPath}' + "/board/list.do?classIdx=" + classIdx;
    })
</script>
</body>
</html>
<jsp:include page="/common/views/footer.jsp"/>