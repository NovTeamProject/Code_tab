<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/common/views/nav.jsp" />
<html>
<head>
    <link href="${pageContext.request.contextPath}/common/css/style.css?ver=1" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    <meta charset="utf-8" />
    <meta
            name="viewport"
            content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>ChunJae-Study</title>
     <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet"    />
    <link href="exam/css//style.css" rel="stylesheet" />
    <script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $("#headers").load("nav.html"); //헤더 인클루드
            $("#footers").load("footer.html"); //푸터부분 인클루드
        });
    </script>
</head>
<body class="d-flex flex-column h-100">
<main class="flex-shrink-0">
    <!-- Navigation--><div id="headers"></div>
    <!-- Page Content-->
    <section class="py-5">
        <div class="container px-5 my-5">
            <div class="text-center mb-5">
                <h1 class="fw-bolder">모의 채점</h1>
                <p class="lead fw-normal text-muted mb-0">How can we help you?</p>
            </div>
            <div class="row gx-5">
                <div class="col-xl-8">
                    <!-- FAQ Accordion 1-->
                    <h2 class="fw-bolder mb-3">Account &amp; Billing</h2>
                    <div class="accordion mb-5" id="accordionExample">
                        <div class="accordion-item">
                            <h3 class="accordion-header" id="headingOne">
                                <button
                                        class="accordion-button"
                                        type="button"
                                        data-bs-toggle="collapse"
                                        data-bs-target="#collapseOne"
                                        aria-expanded="true"
                                        aria-controls="collapseOne"
                                >
                                    Accordion Item #1
                                </button>
                            </h3>
                            <div
                                    class="accordion-collapse collapse show"
                                    id="collapseOne"
                                    aria-labelledby="headingOne"
                                    data-bs-parent="#accordionExample"
                            >
                                <div class="accordion-body">
                                    <strong>This is the first item's accordion body.</strong>
                                    It is shown by default, until the collapse plugin adds the
                                    appropriate classes that we use to style each element.
                                    These classes control the overall appearance, as well as
                                    the showing and hiding via CSS transitions. You can modify
                                    any of this with custom CSS or overriding our default
                                    variables. It's also worth noting that just about any HTML
                                    can go within the
                                    <code>.accordion-body</code>
                                    , though the transition does limit overflow.
                                </div>
                            </div>
                        </div>
                        <div class="accordion-item">
                            <h3 class="accordion-header" id="headingTwo">
                                <button
                                        class="accordion-button collapsed"
                                        type="button"
                                        data-bs-toggle="collapse"
                                        data-bs-target="#collapseTwo"
                                        aria-expanded="false"
                                        aria-controls="collapseTwo"
                                >
                                    Accordion Item #2
                                </button>
                            </h3>
                            <div
                                    class="accordion-collapse collapse"
                                    id="collapseTwo"
                                    aria-labelledby="headingTwo"
                                    data-bs-parent="#accordionExample"
                            >
                                <div class="accordion-body">
                                    <strong>This is the second item's accordion body.</strong>
                                    It is hidden by default, until the collapse plugin adds
                                    the appropriate classes that we use to style each element.
                                    These classes control the overall appearance, as well as
                                    the showing and hiding via CSS transitions. You can modify
                                    any of this with custom CSS or overriding our default
                                    variables. It's also worth noting that just about any HTML
                                    can go within the
                                    <code>.accordion-body</code>
                                    , though the transition does limit overflow.
                                </div>
                            </div>
                        </div>
                        <div class="accordion-item">
                            <h3 class="accordion-header" id="headingThree">
                                <button
                                        class="accordion-button collapsed"
                                        type="button"
                                        data-bs-toggle="collapse"
                                        data-bs-target="#collapseThree"
                                        aria-expanded="false"
                                        aria-controls="collapseThree"
                                >
                                    Accordion Item #3
                                </button>
                            </h3>
                            <div
                                    class="accordion-collapse collapse"
                                    id="collapseThree"
                                    aria-labelledby="headingThree"
                                    data-bs-parent="#accordionExample"
                            >
                                <div class="accordion-body">
                                    <strong>This is the third item's accordion body.</strong>
                                    It is hidden by default, until the collapse plugin adds
                                    the appropriate classes that we use to style each element.
                                    These classes control the overall appearance, as well as
                                    the showing and hiding via CSS transitions. You can modify
                                    any of this with custom CSS or overriding our default
                                    variables. It's also worth noting that just about any HTML
                                    can go within the
                                    <code>.accordion-body</code>
                                    , though the transition does limit overflow.
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
=======
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/common/views/nav.jsp" />
<html>
<head>
    <link href="${pageContext.request.contextPath}/common/css/style.css?ver=1" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    <meta charset="utf-8" />
    <meta
            name="viewport"
            content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>ChunJae-Study</title>
     <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet"    />
    <link href="exam/css//style.css" rel="stylesheet" />
    <script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $("#headers").load("nav.html"); //헤더 인클루드
            $("#footers").load("footer.html"); //푸터부분 인클루드
        });
    </script>
</head>
<body class="d-flex flex-column h-100">
<main class="flex-shrink-0">
    <!-- Navigation--><div id="headers"></div>
    <!-- Page Content-->
    <section class="py-5">
        <div class="container px-5 my-5">
            <div class="text-center mb-5">
                <h1 class="fw-bolder">모의 채점</h1>
                <p class="lead fw-normal text-muted mb-0">How can we help you?</p>
            </div>
            <div class="row gx-5">
                <div class="col-xl-8">
                    <!-- FAQ Accordion 1-->
                    <h2 class="fw-bolder mb-3">Account &amp; Billing</h2>
                    <div class="accordion mb-5" id="accordionExample">
                        <div class="accordion-item">
                            <h3 class="accordion-header" id="headingOne">
                                <button
                                        class="accordion-button"
                                        type="button"
                                        data-bs-toggle="collapse"
                                        data-bs-target="#collapseOne"
                                        aria-expanded="true"
                                        aria-controls="collapseOne"
                                >
                                    Accordion Item #1
                                </button>
                            </h3>
                            <div
                                    class="accordion-collapse collapse show"
                                    id="collapseOne"
                                    aria-labelledby="headingOne"
                                    data-bs-parent="#accordionExample"
                            >
                                <div class="accordion-body">
                                    <strong>This is the first item's accordion body.</strong>
                                    It is shown by default, until the collapse plugin adds the
                                    appropriate classes that we use to style each element.
                                    These classes control the overall appearance, as well as
                                    the showing and hiding via CSS transitions. You can modify
                                    any of this with custom CSS or overriding our default
                                    variables. It's also worth noting that just about any HTML
                                    can go within the
                                    <code>.accordion-body</code>
                                    , though the transition does limit overflow.
                                </div>
                            </div>
                        </div>
                        <div class="accordion-item">
                            <h3 class="accordion-header" id="headingTwo">
                                <button
                                        class="accordion-button collapsed"
                                        type="button"
                                        data-bs-toggle="collapse"
                                        data-bs-target="#collapseTwo"
                                        aria-expanded="false"
                                        aria-controls="collapseTwo"
                                >
                                    Accordion Item #2
                                </button>
                            </h3>
                            <div
                                    class="accordion-collapse collapse"
                                    id="collapseTwo"
                                    aria-labelledby="headingTwo"
                                    data-bs-parent="#accordionExample"
                            >
                                <div class="accordion-body">
                                    <strong>This is the second item's accordion body.</strong>
                                    It is hidden by default, until the collapse plugin adds
                                    the appropriate classes that we use to style each element.
                                    These classes control the overall appearance, as well as
                                    the showing and hiding via CSS transitions. You can modify
                                    any of this with custom CSS or overriding our default
                                    variables. It's also worth noting that just about any HTML
                                    can go within the
                                    <code>.accordion-body</code>
                                    , though the transition does limit overflow.
                                </div>
                            </div>
                        </div>
                        <div class="accordion-item">
                            <h3 class="accordion-header" id="headingThree">
                                <button
                                        class="accordion-button collapsed"
                                        type="button"
                                        data-bs-toggle="collapse"
                                        data-bs-target="#collapseThree"
                                        aria-expanded="false"
                                        aria-controls="collapseThree"
                                >
                                    Accordion Item #3
                                </button>
                            </h3>
                            <div
                                    class="accordion-collapse collapse"
                                    id="collapseThree"
                                    aria-labelledby="headingThree"
                                    data-bs-parent="#accordionExample"
                            >
                                <div class="accordion-body">
                                    <strong>This is the third item's accordion body.</strong>
                                    It is hidden by default, until the collapse plugin adds
                                    the appropriate classes that we use to style each element.
                                    These classes control the overall appearance, as well as
                                    the showing and hiding via CSS transitions. You can modify
                                    any of this with custom CSS or overriding our default
                                    variables. It's also worth noting that just about any HTML
                                    can go within the
                                    <code>.accordion-body</code>
                                    , though the transition does limit overflow.
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
>>>>>>> 007d1a7bc15ff8105b02ce2eef816b13cfc353cd
<jsp:include page="/common/views/footer.jsp" />