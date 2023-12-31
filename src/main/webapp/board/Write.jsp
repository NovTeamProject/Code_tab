<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/common/views/nav.jsp" />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>게시판 질문</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" />
    <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
            crossorigin="anonymous"></script>

   <%--작성시 유효성 검사--%>
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
</head>
<body class="d-flex flex-column">
<main class="flex-shrink-0">
    <section class="bg-light py-5">
        <div class="container px-5 my-5">
            <div class="text-center mb-5">
                <h1 class="fw-bolder">질문하기</h1>
            </div>
            <br class="row gx-5 justify-content-center">
            <form name="writeFrm" method="post" action="${pageContext.request.contextPath}/board/write.do" onsubmit="return validateForm(this);"> <%--write.do로 보내줌--%>
                <input type="hidden" name="classIdx" value="${param.classIdx}" /> <%--매개변수로 부터 classIdx를 가져옴--%>
                <div class="row mb-3">
                    <label for="postTitle" class="col-sm-1 col-form-label">제목</label>
                    <div class="col-sm-8">
                        <input type="text" name="title" class="form-control" id="postTitle" placeholder="질문 제목을 입력하세요">
                    </div>
                </div>
                <div class="row mb-3">
                    <label for="postContent" class="col-sm-1 col-form-label">내용</label>
                    <div class="col-sm-10">
                        <textarea name="content" class="form-control" id="postContent" rows="10" placeholder="질문 내용을 작성하세요"></textarea>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-11 d-flex justify-content-end">
                        <button type="submit" class="btn btn-primary me-2">저장</button>
                        <button type="reset" class="btn btn-primary me-2" onclick="return confirmReset()">전체지우기</button>
                        <button type="button" class="btn btn-primary me-2" onclick="location.href='../board/list.do?classIdx=${classIdx}';"> <%--클릭시 해당 주소로 이동--%>
                            목록 바로가기
                        </button>
                    </div>
                </div>
            </form>
        </div>
    </section>
</main>

<script>
    // form 요소의 reset 버튼 클릭 시 실행되는 함수
    function confirmReset() {
        // 확인 대화상자 표시
        const isConfirmed = confirm("모든 내용을 지우시겠습니까?");
        return isConfirmed; // 사용자가 확인을 눌렀으면 true 반환, 아니면 false 반환
    }
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
<jsp:include page="/common/views/footer.jsp" />