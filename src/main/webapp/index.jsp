<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/common/views/nav.jsp" />

<!DOCTYPE html>
<html>
<head>
  <title>index.html</title>
  <link href="${pageContext.request.contextPath}/common/css/style.css?ver=1" rel="stylesheet">
  <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>

  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Nanum+Pen+Script&display=swap" rel="stylesheet">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
  <style>
    button.mouse{
      background-color: transparent;
      border: 4px #0d0d0d;
      color: whitesmoke;
      font-size:3rem;
      position: absolute;
      bottom: 1rem;
      left: 50%;
      transform:translateX(-50%);
      animation:upDown 1s ease-in-out infinite;
      cursor:pointer;
    }
    @keyframes upDown {
      0%{
        bottom:1rem;
      }
      50%{
        bottom:1.5rem;
      }
      100%{
        bottom:1rem;
      }
    }
  </style>

</head>
<body class="d-flex flex-column h-100">
<main class="flex-shrink-0">
  <div id="mainBanner" class="carousel slide" data-bs-ride="carousel" data-bs-pause="false">
    <div class="carousel-inner">
      <div class="carousel-item active" data-bs-interval="7000">
        <img style="width: 100%; height: 620px;" class="d-block w-100" src="https://github.com/wwnoov/wwnoov/assets/145524959/73bcbcfe-93d6-4a1e-b082-9348c6929019" alt="...">
        <div class="carousel-caption px-md-5 custom-caption">
          <h5>진심을 담은 강의</h5>
          <hr class="bg-light border-4 border-top border-light">
          <p>코드탭은 여러분의 성장을 온 마음 다해 응원합니다.</p>
        </div>
        <button class="mouse" onclick="scrollToSection('section-bottom')"><i class="fa-regular fa-circle-down"></i></button>
      </div>
      <div class="carousel-item" data-bs-interval="7000">
        <img style="width: 100%; height: 620px;" class="d-block w-100" src="https://github.com/wwnoov/wwnoov/assets/145524959/bc8c1114-4748-4516-9e12-4e5ca970d09f" alt="...">
        <div class="carousel-caption px-md-5">
          <h5>인생에 꼭 필요한 강의</h5>
          <hr class="bg-light border-1 border-top border-light">
          <p>코드탭은 여러분의 성장을 온 마음 다해 응원합니다.</p>
        </div>
        <button class="mouse" onclick="scrollToSection('section-bottom')"><i class="fa-regular fa-circle-down"></i></button>
      </div>
      <div class="carousel-item" data-bs-interval="7000">
        <img style="width: 100%; height: 620px;" class="d-block w-100" src="https://github.com/wwnoov/wwnoov/assets/145524959/e19d9e96-2caf-49d2-a359-96e9a78d84eb" alt="...">
        <div class="carousel-caption px-md-5">
          <h5>평생 교육에 맞는 강의</h5>
          <hr class="bg-light border-4 border-top border-light">
          <p>코드탭은 여러분의 성장을 온 마음 다해 응원합니다.</p>
        </div>
        <button class="mouse" onclick="scrollToSection('section-bottom')"><i class="fa-regular fa-circle-down"></i></button>
      </div>
      <div class="carousel-item" data-bs-interval="7000">
        <img style="width: 100%; height: 620px;" class="d-block w-100" src="https://github.com/wwnoov/wwnoov/assets/145524959/f8beac1f-bf06-4397-9bf0-c34d43e4f4c2" alt="...">
        <div class="carousel-caption px-md-5">
          <h5>나의 현재를 위한 강의</h5>
          <hr class="bg-light border-4 border-top border-light">
          <p>코드탭은 여러분의 성장을 온 마음 다해 응원합니다.</p>
        </div>
        <button class="mouse" onclick="scrollToSection('section-bottom')"><i class="fa-regular fa-circle-down"></i></button>
      </div>
      <div class="carousel-item" data-bs-interval="7000">
        <img style="width: 100%; height: 620px;" class="d-block w-100" src="https://github.com/wwnoov/wwnoov/assets/145524959/d8944ebe-467f-4e5b-a0fc-49d9e2b8da1c" alt="...">
        <div class="carousel-caption px-md-5">
          <h5>나의 미래를 위한 강의</h5>
          <hr class="bg-light border-4 border-top border-light">
          <p>코드탭은 여러분의 성장을 온 마음 다해 응원합니다.</p>
        </div>
        <button class="mouse" onclick="scrollToSection('section-bottom')"><i class="fa-regular fa-circle-down"></i></button>
      </div>
    </div>
  </div>
  </div>

  <section class="py-5" style="padding-bottom: 0px!important;">
    <div class="container px-5 my-5">
      <div class="row gx-5 justify-content-center">
        <div class="col-lg-8 col-xl-6">
          <div class="text-center">
            <h2 class="fw-bolder">인기 강의</h2>
            <p class="lead fw-normal text-muted mb-5">수강 학생이 가장 많은 강의 Top 3!</p>
          </div>
        </div>
      </div>
        <div class="row gx-5">
          <c:forEach items="${topThreeClassList}" var="item" varStatus="loop">
            <div class="col-lg-4 mb-5">
              <div class="card h-100 shadow border-0">
                <img style="width: 100%; height: 300px;" class="card-img-top"
                     src="${pageContext.request.contextPath}/teacher/class-image/${item.classImageSavedFilename}" alt="..." />
                <div class="card-body p-4">
                  <div class="badge bg-primary bg-gradient rounded-pill mb-2">인기 강의 top-${loop.index + 1}!</div>
                  <a class="text-decoration-none link-dark stretched-link" href="${pageContext.request.contextPath}/class/detail.do?classIdx=${item.classIdx}">
                    <h5 class="card-title mb-3">${item.className}</h5>
                  </a>
                  <p class="card-text mb-0">${item.classExplain}</p>
                </div>
                <div class="card-footer p-4 pt-0 bg-transparent border-top-0">
                  <div class="d-flex align-items-end justify-content-between">
                    <div class="d-flex align-items-center">
                      <img style="width: 40px; height: 40px" class="rounded-circle me-3" src="${pageContext.request.contextPath}/programming.png" alt="..." />
                      <div class="small">
                        <div class="fw-bold">수강생: ${item.listenStudent}(명)</div>
                        <div class="text-muted">${item.classRegisterDateWithYearMonthDay}</div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </c:forEach>
        </div>
    </div>
  </section>


  <section class="py-5" style="padding-top: 0px!important;">
    <div class="container px-5 my-5">
      <div class="row gx-5 justify-content-center">
        <div class="col-lg-8 col-xl-6">
          <div class="text-center">
            <h2 class="fw-bolder">최근 등록된 강의</h2>
            <p class="lead fw-normal text-muted mb-5">누구보다 빠르게 수강신청 해보세요!</p>
          </div>
        </div>
      </div>
      <div class="row gx-5">
        <c:forEach items="${recentClassList}" var="item" varStatus="loop">
          <div class="col-lg-4 mb-5">
            <div class="card h-100 shadow border-0">
              <img style="width: 100%; height: 300px;" class="card-img-top"
                   src="${pageContext.request.contextPath}/teacher/class-image/${item.classImageSavedFilename}" alt="..." />
              <div class="card-body p-4">
                <div class="badge bg-success bg-gradient rounded-pill mb-2">최신 강의 #${loop.index + 1}</div>
                <a class="text-decoration-none link-dark stretched-link" href="${pageContext.request.contextPath}/class/detail.do?classIdx=${item.classIdx}">
                  <h5 class="card-title mb-3">${item.className}</h5>
                </a>
                <p class="card-text mb-0">${item.classExplain}</p>
              </div>
              <div class="card-footer p-4 pt-0 bg-transparent border-top-0">
                <div class="d-flex align-items-end justify-content-between">
                  <div class="d-flex align-items-center">
                    <img style="width: 40px; height: 40px" class="rounded-circle me-3" src="${pageContext.request.contextPath}/programming.png" alt="..." />
                    <div class="small">
                      <div class="fw-bold">수강생: ${item.listenStudent}(명)</div>
                      <div class="text-muted">${item.classRegisterDateWithYearMonthDay}</div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </c:forEach>
      </div>
    </div>
  </section>
  <br/><br/><br/><br/>
<script>
  window.onscroll = function() {
    const nav = document.querySelector('.navbar');
    if (window.pageYOffset > 50) {
      nav.classList.add('sticky');
    } else {
      nav.classList.remove('sticky');
    }
    // 페이지 콘텐츠의 높이를 확인하여 footer를 고정
    const contentHeight = document.body.clientHeight;
    const windowHeight = window.innerHeight;

    if (contentHeight <= windowHeight) {
      footer.classList.add('sticky-footer');
    } else {
      footer.classList.remove('sticky-footer');
    }
  };

  function scrollToSection(id) {
    const section = document.getElementById(id);
    section.scrollIntoView({ behavior: 'smooth' });
  }
</script>
</main>
</body>
</html>
<jsp:include page="/common/views/footer.jsp" />