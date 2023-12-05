<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>수강생 전용 게시판</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <!-- Bootstrap icons-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" />
    <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
            crossorigin="anonymous"></script>

    <%--검색폼에 대한 유효성검사--%>
    <script>
        function validateSearchForm(form) {
            if (form.searchWord.value.trim() === "") {
                alert("검색어를 입력하세요.");
                form.searchWord.focus();
                return false;
            }
        }
    </script>

    <%--personType에 따른 질문하기 버튼 구현--%>
    <script>
        $(document).ready(function (){
            // ${map.personType} 값 확인
            var personType = ${map.personType};

            // personType이 0이면 질문하기 버튼을 숨김.
            if(personType === 0) {
                $("#questionBtn").hide();
            } else if (personType === 2) {
                // personType이 2이면 질문하기 버튼 생김
                $("#questionBtn").show();
            }

        });
    </script>
</head>

<body class="d-flex flex-column">
<jsp:include page="/common/views/nav.jsp"></jsp:include>
<main class="flex-shrink-0">
    <section class="bg-light py-5">
        <div class="container px-5 my-5">
            <div class="text-center mb-5">
                <h1 class="fw-bolder">수강생 전용 게시판</h1>
                <p class="lead fw-normal text-muted mb-0">${map.className}</p>
            </div>
            <br class="row gx-5 justify-content-center">
            <form method="get" onsubmit="return validateSearchForm(this);">
                <input type="hidden" name="classIdx" value=${map.classIdx}>
                <select name="searchField" id="select-option">
<%--                    map.searchField 가 null과 공백문자가 아니고, map.searchField가 title이랑 동일하면 selected를 출력해라--%>
                    <option value="title" ${(not empty map.searchField and map.searchField eq 'title') ? 'selected' : ''}>제목</option>
                    <option value="studentName" ${(not empty map.searchField and map.searchField eq 'studentName') ? 'selected' : ''}>작성자</option>
                </select>
                <input type="text" id="searchWord"  name="searchWord" placeholder="검색어를 입력하세요" value="${not empty map.searchWord ? map.searchWord : ''}" />
                <input type="submit" value="검색하기"/>
                <c:if test="${map.check == 1}"> <%--map에 check가 1인 경우 수강을 신청한 학생이므로 질문 작성가능--%>
                    <div class="container" style="display: flex; justify-content: flex-end;">
                        <button type="button" class="btn btn-primary" id="questionBtn">질문하기</button>
                    </div>
                </c:if>
            </form>
            <br />
            <br />
            <table style="border-collapse: collapse; width: 100%; border: 1px solid #ddd;">
                <thead>
                    <tr>
                        <th style="text-align: center;">번호</th>
                        <th style="text-align: center;">제목</th>
                        <th style="text-align: center;">작성자</th>
                        <th style="text-align: center;">조회수</th>
                        <th style="text-align: center;">작성일</th>
                    </tr>
                </thead>
                <tbody>
                    <c:choose>
                        <c:when test="${empty boardLists}">  <%--해당 값이 비어있으면 출력--%>
                            <tr>
                                <td colspan="5" align="center">
                                    등록된 질문이 없습니다.
                                </td>
                            </tr>
                        </c:when>
                        <c:otherwise>
                            <!--반복 -->
                            <c:forEach items="${boardLists}" var="row" varStatus="loop">
                            <tr align="center">
                                <td>${ map.totalCount - (((map.pageNum-1) * map.pageSize) + loop.index)}</td>
                                <td align="center">
                                    <a href="${pageContext.request.contextPath}/board/view.do?classIdx=${map.classIdx}&boardIdx=${ row.boardIdx }">${ row.title }</a>
                                </td>
                                <td>${row.studentName}</td>
                                <td>${row.visitcount}</td>
                                <td>${row.classRegisterDateWithYearMonthDayHourMinute}</td>
                            </tr>
                            </c:forEach>
                        </c:otherwise>
                    </c:choose>
                </tbody>
            </table>
            </br>
            <c:if test="${not empty boardLists}">
                ${ map.pagingImg }
            </c:if>
        </div>

    </section>
</main>

    <script>
        $(".page-link").on('click', function (event) {
            event.preventDefault(); // a 태그의 기본 동작을 하지 마라.
            //console.log($(this).attr('href'));
            let destination = $(this).attr('href');
            destination += ('&searchField=' + $('#select-option option:selected').val() + "&searchWord=" + $("#searchWord").val());
            console.log(destination);
            location.href = destination;
        })
        $("#questionBtn").on("click", function (event) {
            location.href = '${pageContext.request.contextPath}' + "/board/write.do?classIdx=" + '${param.classIdx}';
        })
    </script>

<script>
    $(document).ready(function (){
        // 첫 번째 페이지의 1번 페이징을 선택하고 클릭 이벤트를 막고 경고창을 표시합니다.
        $(".page-item:first-child .page-link").on('click', function(event) {
            event.preventDefault(); // 기본 클릭 동작을 막습니다.
            alert('첫 번째 페이지입니다.'); // 경고창을 표시합니다.
        });
    });
</script>


<script>
    $(document).ready(function() {
        $(".page-item:last-child .page-link").on('click', function(event) {
            event.preventDefault(); // 기본 클릭 동작을 막습니다.
            alert('마지막 페이지입니다.'); // 경고창을 표시합니다.
        });
    });

</script>




<!-- Bootstrap core JS-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- Core theme JS-->
<script src="js/scripts.js"></script>
<jsp:include page="/common/views/footer.jsp"></jsp:include>
</body>
</html>
