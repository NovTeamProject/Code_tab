<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                    },
                    success: function (response) {
                        if (response === "success") {
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

</head>
<body class="d-flex flex-column">
<main class="flex-shrink-0">
    <!-- Navigation-->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container px-5">
            <a class="navbar-brand" href="index.html">Start Bootstrap</a>
            <button
                    class="navbar-toggler"
                    type="button"
                    data-bs-toggle="collapse"
                    data-bs-target="#navbarSupportedContent"
                    aria-controls="navbarSupportedContent"
                    aria-expanded="false"
                    aria-label="Toggle navigation"
            >
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link" href="index.html">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="about.html">About</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="contact.html">Contact</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="pricing.html">Pricing</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="faq.html">FAQ</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a
                                class="nav-link dropdown-toggle"
                                id="navbarDropdownBlog"
                                href="#"
                                role="button"
                                data-bs-toggle="dropdown"
                                aria-expanded="false"
                        >Blog</a
                        >
                        <ul
                                class="dropdown-menu dropdown-menu-end"
                                aria-labelledby="navbarDropdownBlog"
                        >
                            <li>
                                <a class="dropdown-item" href="blog-home.html">Blog Home</a>
                            </li>
                            <li>
                                <a class="dropdown-item" href="blog-post.html">Blog Post</a>
                            </li>
                        </ul>
                    </li>
                    <li class="nav-item dropdown">
                        <a
                                class="nav-link dropdown-toggle"
                                id="navbarDropdownPortfolio"
                                href="#"
                                role="button"
                                data-bs-toggle="dropdown"
                                aria-expanded="false"
                        >Portfolio</a
                        >
                        <ul
                                class="dropdown-menu dropdown-menu-end"
                                aria-labelledby="navbarDropdownPortfolio"
                        >
                            <li>
                                <a class="dropdown-item" href="portfolio-overview.html"
                                >Portfolio Overview</a
                                >
                            </li>
                            <li>
                                <a class="dropdown-item" href="portfolio-item.html"
                                >Portfolio Item</a
                                >
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <section class="bg-light py-5">
        <div class="container px-5 my-5">
            <div class="row gx-5 justify-content-center">
                <div class="col-lg-8">
                    <!-- 게시글 내용 -->
                    <h2 class="fw-bolder">${dto.title}</h2>
                    <br>
                    <p class="lead">작성자: ${dto.studentName} | 작성일: ${dto.registerDate} | 조회수: ${dto.visitcount}</p>
                    <p>
                        ${dto.content}
                    </p>
                    <!-- 수정하기, 뒤로가기 버튼 -->
                    <div class="d-flex justify-content-end">
                        <a href="${pageContext.request.contextPath}/board/edit.do?classIdx=${classIdx}&boardIdx=${boardIdx}" class="btn btn-primary me-2">수정하기</a>
                        <%--<a href="#" class="btn btn-primary me-2">삭제하기</a>--%>
                        <a href="#" class="btn btn-primary me-2" onclick="deletePost(${dto.boardIdx}, ${classIdx})">삭제하기</a>
                        <a href="../board/list.do?classIdx=${classIdx}" class="btn btn-secondary">목록바로가기</a>
                    </div>
                    <!-- 답변 목록 -->
                    <div class="mt-5">
                        <h3 class="fw-bolder">답변 목록</h3>
                        <div class="card">
                            <input type="hidden" >
                            <div class="card-body">
                                <c:forEach items="${comments}" var="comment" varStatus="loop">
                                    <c:forEach begin="1" end="${loop.index}" varStatus="innerLoop">
                                        &nbsp;&nbsp;&nbsp;
                                    </c:forEach>
                                    <c:if test="${loop.index > 0}">ㄴ</c:if>
                                    ${comment.personName} : ${comment.content}<br/>
                                </c:forEach>

                                <c:choose>
                                    <c:when test="${comments.size() < 5}">
                                        <!-- 답변 입력 폼 -->
                                        <div class="mt-5">
                                            <h3 class="fw-bolder">답변하기</h3>
                                            <form method="post" action="${pageContext.request.contextPath}/board/comment.do">
                                                <input type="hidden" name="boardIdx" value="${boardIdx}" />
                                                <input type="hidden" name="classIdx" value="${classIdx}" />
                                                <div class="mb-3">
                                                    <textarea class="form-control" id="commentContent" name="commentContent" rows="4" placeholder="답변을 작성하세요"></textarea>
                                                </div>
                                                <div class="d-flex justify-content-end">
                                                    <button type="submit" class="btn btn-primary">답변 저장</button>
                                                </div>
                                            </form>
                                        </div>
                                    </c:when>
                                    <c:otherwise>
                                        <h3>더이상 댓글을 작성할 수 없습니다. 새로운 질문글을 작성해주세요</h3>
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