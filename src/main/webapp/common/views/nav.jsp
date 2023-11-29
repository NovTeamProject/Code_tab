<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
  <title>ChunJae-Study</title>
  <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/common/image/로고.png" />
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />

</head>
<body>
<div>
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container px-5">
      <img src="${pageContext.request.contextPath}/common/image/작은로고.png" width="70rem" height="50rem">
      <a class="navbar-brand" href="${pageContext.request.contextPath}/index.jsp">천재스터디</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
          <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/about.jsp">강의실</a></li>
          <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/contact.jsp">선생님</a></li>
          <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/list.jsp">명예의전당</a></li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" id="navbarDropdownPortfolio" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">마이페이지</a>
            <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdownPortfolio">
              <li><a class="dropdown-item" href="${pageContext.request.contextPath}/faq.jsp">모의채점 </a></li>
              <li><a class="dropdown-item" href="${pageContext.request.contextPath}/portfolio-item.jsp">무엇을할까요 </a></li>
            </ul>
          </li>
          <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/membership/views/login2.jsp">로그인</a></li>
          <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/membership/views/join2.jsp">회원가입</a></li>
        </ul>
      </div>
    </div>
  </nav>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js" crossorigin="anonymous"></script>
</body>
</html>