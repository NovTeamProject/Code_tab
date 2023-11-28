<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/common/views/nav.jsp" />

<!DOCTYPE html>
<html>
<head>
  <title>index.html</title>
  <link href="${pageContext.request.contextPath}/common/css/style.css?ver=1" rel="stylesheet">
  <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body class="d-flex flex-column h-100">
<main class="flex-shrink-0">
    <div id="mainBanner" class="carousel slide" data-bs-ride="carousel" data-bs-pause="false">
      <div class="carousel-inner">
            <div class="carousel-item active" data-bs-interval="7000">

          <img src="https://images.pexels.com/photos/2387873/pexels-photo-2387873.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1" class="d-block w-100" alt="...">
          <div class="carousel-caption px-md-5">
            <h5>진심을 담은 강의</h5>
            <hr class="bg-light border-4 border-top border-light">
            <p>천재스터디는 여러분의 성장을 온 마음 다해 응원합니다.</p>
            <div class="banner-btn">
              <button type="button" class="btn btn-secondary px-lg-5 px-md-4 px-2 py-2 rounded-0 border">천재스터디란?</button>
              <button type="button" class="btn btn-success px-lg-5 px-md-4 px-2 py-2 rounded-0 border">인기 강의</button>
            </div>
          </div>
        </div>
        <div class="carousel-item" data-bs-interval="7000">
          <img src="https://images.pexels.com/photos/206359/pexels-photo-206359.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1" class="d-block w-100" alt="...">
          <div class="carousel-caption px-md-5">
            <h5>인생에 꼭 필요한 강의</h5>
            <hr class="bg-light border-1 border-top border-light">
            <p>천재스터디는 여러분의 성장을 온 마음 다해 응원합니다.</p>
            <div class="banner-btn">
              <button type="button" class="btn btn-secondary px-lg-5 px-md-4 px-2 py-2 rounded-0 border">천재스터디란?</button>
              <button type="button" class="btn btn-success px-lg-5 px-md-4 px-2 py-2 rounded-0 border">인기 강의</button>
            </div>
          </div>
        </div>
        <div class="carousel-item" data-bs-interval="7000">
          <img src="https://images.pexels.com/photos/933054/pexels-photo-933054.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1" class="d-block w-100" alt="...">
          <div class="carousel-caption px-md-5">
            <h5>평생 교육에 맞는 강의</h5>
            <hr class="bg-light border-4 border-top border-light">
            <p>천재스터디는 여러분의 성장을 온 마음 다해 응원합니다.</p>
            <div class="banner-btn">
              <button type="button" class="btn btn-secondary px-lg-5 px-md-4 px-2 py-2 rounded-0 border">천재스터디란?</button>
              <button type="button" class="btn btn-success px-lg-5 px-md-4 px-2 py-2 rounded-0 border">인기 강의</button>
            </div>
          </div>
        </div>
        <div class="carousel-item" data-bs-interval="7000">
          <img src="https://images.pexels.com/photos/531602/pexels-photo-531602.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1" class="d-block w-100" alt="...">
          <div class="carousel-caption px-md-5">
            <h5>나의 현재를 위한 강의</h5>
            <hr class="bg-light border-4 border-top border-light">
            <p>천재스터디는 여러분의 성장을 온 마음 다해 응원합니다.</p>
            <div class="banner-btn">
              <button type="button" class="btn btn-secondary px-lg-5 px-md-4 px-2 py-2 rounded-0 border">천재스터디란?</button>
              <button type="button" class="btn btn-success px-lg-5 px-md-4 px-2 py-2 rounded-0 border">인기 강의</button>
            </div>
          </div>
        </div>
        <div class="carousel-item" data-bs-interval="7000">
          <img src="https://images.pexels.com/photos/2876511/pexels-photo-2876511.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1" class="d-block w-100" alt="...">
          <div class="carousel-caption px-md-5">
            <h5>나의 미래를 위한 강의</h5>
            <hr class="bg-light border-4 border-top border-light">
            <p>천재스터디는 여러분의 성장을 온 마음 다해 응원합니다.</p>
            <div class="banner-btn">
              <button type="button" class="btn btn-secondary px-lg-5 px-md-4 px-2 py-2 rounded-0 border">천재스터디란?</button>
              <button type="button" class="btn btn-success px-lg-5 px-md-4 px-2 py-2 rounded-0 border">인기 강의</button>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <section class="py-5" id="features">
    <div class="container px-5 my-5">
      <div class="row gx-5">
        <div class="col-lg-4 mb-5 mb-lg-0"><h2 class="fw-bolder mb-0">인기 강의</h2></div>
        <div class="col-lg-8">
          <div class="row gx-5 row-cols-1 row-cols-md-2">
            <div class="col mb-5 h-100">
              <div class="feature bg-primary bg-gradient text-white rounded-3 mb-3"><i class="bi bi-collection"></i></div>
              <h2 class="h5">강의 1</h2>
              <p class="mb-0">Paragraph of text beneath the heading to explain the heading. Here is just a bit more text.</p>
            </div>
            <div class="col mb-5 h-100">
              <div class="feature bg-primary bg-gradient text-white rounded-3 mb-3"><i class="bi bi-building"></i></div>
              <h2 class="h5">강의 2</h2>
              <p class="mb-0">Paragraph of text beneath the heading to explain the heading. Here is just a bit more text.</p>
            </div>
            <div class="col mb-5 mb-md-0 h-100">
              <div class="feature bg-primary bg-gradient text-white rounded-3 mb-3"><i class="bi bi-toggles2"></i></div>
              <h2 class="h5">강의 3</h2>
              <p class="mb-0">Paragraph of text beneath the heading to explain the heading. Here is just a bit more text.</p>
            </div>
            <div class="col h-100">
              <div class="feature bg-primary bg-gradient text-white rounded-3 mb-3"><i class="bi bi-toggles2"></i></div>
              <h2 class="h5">강의 4</h2>
              <p class="mb-0">Paragraph of text beneath the heading to explain the heading. Here is just a bit more text.</p>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
  <section class="py-5">
    <div class="container px-5 my-5">
      <div class="row gx-5 justify-content-center">
        <div class="col-lg-8 col-xl-6">
          <div class="text-center">
            <h2 class="fw-bolder">등록된 강의</h2>
            <p class="lead fw-normal text-muted mb-5">Lorem ipsum, dolor sit amet consectetur adipisicing elit. Eaque fugit ratione dicta mollitia. Officiis ad.</p>
          </div>
        </div>
      </div>
      <div class="row gx-5">
        <div class="col-lg-4 mb-5">
          <div class="card h-100 shadow border-0">
            <img class="card-img-top" src="https://dummyimage.com/600x350/ced4da/6c757d" alt="..." />
            <div class="card-body p-4">
              <div class="badge bg-primary bg-gradient rounded-pill mb-2">News</div>
              <a class="text-decoration-none link-dark stretched-link" href="#!"><h5 class="card-title mb-3">Blog post title</h5></a>
              <p class="card-text mb-0">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
            </div>
            <div class="card-footer p-4 pt-0 bg-transparent border-top-0">
              <div class="d-flex align-items-end justify-content-between">
                <div class="d-flex align-items-center">
                  <img class="rounded-circle me-3" src="https://dummyimage.com/40x40/ced4da/6c757d" alt="..." />
                  <div class="small">
                    <div class="fw-bold">Kelly Rowan</div>
                    <div class="text-muted">March 12, 2023 &middot; 6 min read</div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="col-lg-4 mb-5">
          <div class="card h-100 shadow border-0">
            <img class="card-img-top" src="https://dummyimage.com/600x350/adb5bd/495057" alt="..." />
            <div class="card-body p-4">
              <div class="badge bg-primary bg-gradient rounded-pill mb-2">Media</div>
              <a class="text-decoration-none link-dark stretched-link" href="#!"><h5 class="card-title mb-3">Another blog post title</h5></a>
              <p class="card-text mb-0">This text is a bit longer to illustrate the adaptive height of each card. Some quick example text to build on the card title and make up the bulk of the card's content.</p>
            </div>
            <div class="card-footer p-4 pt-0 bg-transparent border-top-0">
              <div class="d-flex align-items-end justify-content-between">
                <div class="d-flex align-items-center">
                  <img class="rounded-circle me-3" src="https://dummyimage.com/40x40/ced4da/6c757d" alt="..." />
                  <div class="small">
                    <div class="fw-bold">Josiah Barclay</div>
                    <div class="text-muted">March 23, 2023 &middot; 4 min read</div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="col-lg-4 mb-5">
          <div class="card h-100 shadow border-0">
            <img class="card-img-top" src="https://dummyimage.com/600x350/6c757d/343a40" alt="..." />
            <div class="card-body p-4">
              <div class="badge bg-primary bg-gradient rounded-pill mb-2">News</div>
              <a class="text-decoration-none link-dark stretched-link" href="#!"><h5 class="card-title mb-3">The last blog post title is a little bit longer than the others</h5></a>
              <p class="card-text mb-0">Some more quick example text to build on the card title and make up the bulk of the card's content.</p>
            </div>
            <div class="card-footer p-4 pt-0 bg-transparent border-top-0">
              <div class="d-flex align-items-end justify-content-between">
                <div class="d-flex align-items-center">
                  <img class="rounded-circle me-3" src="https://dummyimage.com/40x40/ced4da/6c757d" alt="..." />
                  <div class="small">
                    <div class="fw-bold">Evelyn Martinez</div>
                    <div class="text-muted">April 2, 2023 &middot; 10 min read</div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
</main>
</body>
</html>
<jsp:include page="/common/views/footer.jsp" />