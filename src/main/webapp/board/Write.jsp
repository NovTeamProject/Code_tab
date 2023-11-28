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
            <div class="text-center mb-5">
                <h1 class="fw-bolder">질문하기</h1>
            </div>
            <br class="row gx-5 justify-content-center">
            <form name="writeFrm" method="post" enctype="multipart/form-data"
                  action="../board/write.do" onsubmit="return validateForm(this);">
                <div class="row mb-3">
                    <label for="postTitle" class="col-sm-1 col-form-label">제목</label>
                    <div class="col-sm-8">
                        <input type="text" name="title" class="form-control" id="postTitle" placeholder="제목을 입력하세요">
                    </div>
                </div>
                <div class="row mb-3">
                    <label for="postContent" class="col-sm-1 col-form-label">내용</label>
                    <div class="col-sm-10">
                        <textarea name="content" class="form-control" id="postContent" rows="10" placeholder="내용을 작성하세요"></textarea>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-11 d-flex justify-content-end">
                        <button type="submit" class="btn btn-primary me-2">저장</button>
                        <button type="reset" class="btn btn-primary me-2">전체 지우기</button>
                        <button type="button" class="btn btn-primary me-2" onclick="location.href='../board/list.do?classIdx=${classIdx}';">
                            목록 바로가기
                        </button>
                    </div>
                </div>
            </form>
        </div>
    </section>

    <script>
        $(".page-link").on('click', function (event) {
            event.preventDefault(); // a 태그의 기본 동작을 하지 마라.
            //console.log($(this).attr('href'));
            let destination = $(this).attr('href');
            destination += ('&searchField=' + $('#select-option option:selected').val() + "&searchWord=" + $("#searchWord").val());
            console.log(destination);
            location.href = destination;
        })
    </script>
</main>
<!-- Bootstrap core JS-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- Core theme JS-->
<script src="js/scripts.js"></script>
</body>
</html>