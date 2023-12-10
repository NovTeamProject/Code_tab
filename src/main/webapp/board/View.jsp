<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/common/views/nav.jsp" />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>게시판 질문</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <!-- Bootstrap icons-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" />
    <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
            crossorigin="anonymous"></script>

    <%--검색 폼의 유효성 검사--%>
    <script type="text/javascript">
        function validateForm(form) {  // 필수 항목 입력 확인
            if (form.title.value == "") {
                alert("제목을 입력하세요.");
                form.title.focus();
                return false;
            }
            if (form.content.value == "") {
                alert("내용을 입력하세요.");
                form.content.focus();
                return false;
            }
        }
    </script>

    <%--삭제시 유효성 검사--%>
    <script>
        function deletePost(boardIdx, classIdx) {
            if (confirm("정말로 삭제하시겠습니까?")) {
                // AJAX를 사용하여 삭제 요청을 서버로 전송
                $.ajax({
                    type: "POST",
                    url: "${pageContext.request.contextPath}/board/delete.do",
                    data: {
                        boardIdx: boardIdx,
                        classIdx: classIdx
                    }, // boardIdx와 classIdx 값 지정
                    success: function (response) {
                        if (response === "success") {  // 삭제를 하였을 경우
                            alert("삭제되었습니다.");
                            window.location.href = "${pageContext.request.contextPath}/board/list.do?classIdx=" + classIdx;
                        } else {
                            alert("삭제에 실패했습니다.");
                        }
                    },
                    error: function () {
                        alert("삭제 요청을 처리하는 동안 오류가 발생했습니다.");
                    }
                });
            }
        }

    </script>

    <%--질문하기 유효성 검사--%>
    <script>
        function validateCommentForm(form) {
            if (form.commentContent.value.trim() === "") {
                alert("답변을 입력하세요.");
                form.commentContent.focus();
                return false;
            }
        }
    </script>
</head>

<body class="d-flex flex-column">
<main class="flex-shrink-0">
    <section class="bg-light py-5">
        <div class="container px-5 my-5">
            <div class="row gx-5 justify-content-center">
                <div class="col-lg-8">
                    <!-- 게시글 내용 -->
                    <h2 class="fw-bolder">${dto.title}</h2>  <%--dto에 저장된 title 값을 가져옴--%>
                    <br>
                    <p>작성자: ${dto.studentName} | 작성일: ${dto.classRegisterDateWithYearMonthDayHourMinute} | 조회수: ${dto.visitcount}</p> <%--dto에서 해당 값을 불러옴--%>
                    <p class="lead">
                        ${dto.content}
                    </p>
                    <!-- 수정하기, 뒤로가기 버튼 -->
                    <div class="d-flex justify-content-end">
                        <c:if test="${sessionScope.personType eq 2 and sessionScope.studentIdx eq dto.studentIdx}">   <%--세션의 personType이 2이고 studentIdx 값이 dto에 저장된 studentIdx 값과 같을 경우 실행--%>
                            <%--수정하기, 삭제하기 버튼이 나타남--%>
                            <a href="${pageContext.request.contextPath}/board/edit.do?classIdx=${classIdx}&boardIdx=${boardIdx}" class="btn btn-primary me-2">수정하기</a>
                            <a href="#" class="btn btn-primary me-2" onclick="deletePost(${dto.boardIdx}, ${classIdx})">삭제하기</a>
                        </c:if>
                        <a href="../board/list.do?classIdx=${classIdx}" class="btn btn-secondary">목록바로가기</a> <%--게시판으로 가기--%>
                    </div>

                    <!-- 답변 목록 -->
                    <div class="mt-5">
                        <h3 class="fw-bolder">답변목록</h3>
                        <div class="card">
                            <input type="hidden">
                            <div class="card-body">
                                <c:forEach items="${comments}" var="comment" varStatus="loop"> <%--comments 컬렉션에서 comment라는 변수를 사용하여 반복문 수행, varStatus를 통해 현재 반복상태 저장--%>
                                    <c:forEach begin="1" end="${loop.index}" varStatus="innerLoop"> <%--innerLoop라는 변수를 사용하여 loop.index(반복 횟수)만큼 공백을 생성<들여쓰기>--%>
                                        &nbsp;&nbsp;&nbsp;
                                    </c:forEach>
                                    <c:if test="${loop.index > 0}">ㄴ</c:if> <%--현재 반복이 첫번째가 아닌 경우 'ㄴ' 을 출력, "계층구조"를 표현--%>
                                    ${comment.personName} : ${comment.content}<br/> <%--작성자 : 답변 형태로 데이터 보여줌--%>
                                </c:forEach>

                                <c:choose>
                                    <c:when test="${comments.size() < 5}">  <%--comments 사이즈가 5보다 작을 경우에만 아래 내용을 실행--%>
                                        <c:if test="${sessionScope.personType != null and sessionScope.loginMember != null}">
                                            <!-- 답변 입력 폼 -->
                                            <div class="mt-5">
                                                <h3 class="fw-bolder">답변하기</h3>
                                                <form method="post" action="${pageContext.request.contextPath}/board/comment.do"  onsubmit="return validateCommentForm(this);">
                                                    <input type="hidden" name="boardIdx" value="${boardIdx}" /> <%--boardIdx 값을 전송--%>
                                                    <input type="hidden" name="classIdx" value="${classIdx}" /> <%--classIdx 값을 전송--%>
                                                    <div class="mb-3">
                                                        <textarea class="form-control" id="commentContent" name="commentContent" rows="4" placeholder="답변을 작성해주세요"></textarea>
                                                    </div>
                                                    <div class="d-flex justify-content-end">
                                                        <button type="submit" class="btn btn-primary">답변저장</button>
                                                    </div>
                                                </form>
                                            </div>
                                        </c:if>
                                        <c:if test="${sessionScope.personType eq null and sessionScope.loginMember eq null}">
                                            <div class="mt-5">
                                                <h4 style="color: black;" class="fw-bolder">로그인 후 답변을 작성할 수 있습니다</h4>
                                            </div>
                                        </c:if>
                                    </c:when>
                                    <c:otherwise>  <%--답변의 개수가 5번이 넘을 경우 답변을 달 수 없도록 구현, 답변이 너무 길어지지 않도록 새로운 질문을 하도록--%>
                                        <br/>
                                        <h5><strong>더이상 답변을 작성할 수 없습니다. 새로운 질문글을 작성해주세요</strong></h5>
                                    </c:otherwise>
                                </c:choose>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</main>
<!-- Bootstrap core JS-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- Core theme JS-->
<script src="js/scripts.js"></script>
</body>
</html>
<jsp:include page="/common/views/footer.jsp" />