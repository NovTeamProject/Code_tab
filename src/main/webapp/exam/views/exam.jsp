<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/common/views/nav.jsp" />
<html>
<head>
    <link href="${pageContext.request.contextPath}/exam/css/style.css?ver=1" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>

    <title>정답 서비스</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }

        table, th, td {
            border: 1px solid black;
            padding: 8px;
        }

        th {
            background-color: #f2f2f2;
            font-weight: bold;
            text-align: center;
        }

        td {
            text-align: center;
        }

        h3 {
            font-family: 'Noto Sans KR', sans-serif;
        }
    </style>
</head>
<body class="d-flex flex-column h-100">
<main class="flex-shrink-0">
      <section class="py-3">
        <div class="container px-5 my-5">
            <div class="exammain">
            <div class="row gx-5">
                <div class="col-xl-8">
                    <h2 class="fw-bolder mb-3">각종 시험의 정답을 확인 할 수 있습니다.</h2>
                    <div style="text-align: center;">
                    </div>
                    <div class="accordion mb-5" id="accordionExample">
                        <div class="accordion-item">
                            <form id="yourForm" name="writeFrm" method="post" action="${pageContext.request.contextPath}/exam.do" onsubmit="return validateInputs(this)">
                            <h3 class="accordion-header" id="headingOne">
                                <button class="accordion-button collapsed " type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                                     정보처리기사</button></h3>
                                <input type="hidden" name="examId" value="정보처리기사" />
                                <div class="accordion-collapse collapse show" id="collapseOne" aria-labelledby="headingOne" data-bs-parent="#accordionExample">
                                    <div class="accordion-body score">
                                       <%-- 정답을 입력받는 테이블--%>
                                      <table class="table table-striped" border="1" cellspacing="0">
                                        <tr>
                                            <th>번호</th>
                                            <th>&nbsp;&nbsp;&nbsp;정답</th>
                                            <th>번호</th>
                                            <th>&nbsp;&nbsp;&nbsp;정답</th>
                                            <th>번호</th>
                                            <th>&nbsp;&nbsp;&nbsp;정답</th>
                                            <th>번호</th>
                                            <th>&nbsp;&nbsp;&nbsp;정답</th>
                                        </tr>
                                          <tr>
                                              <td>1번</td>
                                              <td><input name="answer1" type="text" placeholder="정답" style="width:70px;"></td>
                                              <td>2번</td>
                                              <td><input name="answer2" type="text" placeholder="정답" style="width:70px;"></td>
                                              <td>3번</td>
                                              <td><input name="answer3" type="text" placeholder="정답" style="width:70px;"></td>
                                              <td>4번</td>
                                              <td><input name="answer4" type="text" placeholder="정답" style="width:70px;"></td>
                                          </tr>
                                          <tr>
                                              <td>5번</td>
                                              <td><input name="answer5" type="text" placeholder="정답" style="width:70px;"></td>
                                              <td>6번</td>
                                              <td><input name="answer6" type="text" placeholder="정답" style="width:70px;"></td>
                                              <td>7번</td>
                                              <td><input name="answer7" type="text" placeholder="정답" style="width:70px;"></td>
                                              <td>8번</td>
                                              <td><input name="answer8" type="text" placeholder="정답" style="width:70px;"></td>
                                          </tr>
                                          <tr>
                                              <td>9번</td>
                                              <td><input name="answer9" type="text" placeholder="정답" style="width:70px;"></td>
                                              <td>10번</td>
                                              <td><input name="answer10" type="text" placeholder="정답" style="width:70px;"></td>
                                              <td>11번</td>
                                              <td><input name="answer11" type="text" placeholder="정답" style="width:70px;"></td>
                                              <td>12번</td>
                                              <td><input name="answer12" type="text" placeholder="정답" style="width:70px;"></td>
                                          </tr>
                                          <tr>
                                              <td>13번</td>
                                              <td><input name="answer13" type="text" placeholder="정답" style="width:70px;"></td>
                                              <td>14번</td>
                                              <td><input name="answer14" type="text" placeholder="정답" style="width:70px;"></td>
                                              <td>15번</td>
                                              <td><input name="answer15" type="text" placeholder="정답" style="width:70px;"></td>
                                              <td>16번</td>
                                              <td><input name="answer16" type="text" placeholder="정답" style="width:70px;"></td>
                                          </tr>
                                          <tr>
                                              <td>17번</td>
                                              <td><input name="answer17" type="text" placeholder="정답" style="width:70px;"></td>
                                              <td>18번</td>
                                              <td><input name="answer18" type="text" placeholder="정답" style="width:70px;"></td>
                                              <td>19번</td>
                                              <td><input name="answer19" type="text" placeholder="정답" style="width:70px;"></td>
                                              <td>20번</td>
                                              <td><input name="answer20" type="text" placeholder="정답" style="width:70px;"></td>
                                          </tr>

                                    </table>
                                      <button type="submit" class="btn btn-primary me-2">정답 제출</button>
                                </div>
                            </div>
                            </form>
                        </div>
                        <div class="accordion-item">
                            <form id="yourFormTwo" name="writeFrm" method="post" action="${pageContext.request.contextPath}/exam.do" onsubmit="return validateInputs(this)">
                            <h3 class="accordion-header" id="headingTwo">
                                <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                                    SQL 개발자</button></h3>
                                <input type="hidden" name="examId" value="SQL 개발자" />
                                 <div class="accordion-collapse collapse"  id="collapseTwo" aria-labelledby="headingTwo" data-bs-parent="#accordionExample">
                                     <div class="accordion-body score">
                                         <%-- 정답을 입력받는 테이블--%>

                                         <table border="1" cellspacing="0">
                                                <tr>
                                                    <th>번호</th>
                                                    <th>&nbsp;&nbsp;&nbsp;정답</th>
                                                    <th>번호</th>
                                                    <th>&nbsp;&nbsp;&nbsp;정답</th>
                                                    <th>번호</th>
                                                    <th>&nbsp;&nbsp;&nbsp;정답</th>
                                                    <th>번호</th>
                                                    <th>&nbsp;&nbsp;&nbsp;정답</th>
                                                </tr>
                                                <tr>
                                                    <td>1번</td>
                                                    <td><input name="answer1" type="text" placeholder="정답" style="width:70px;"></td>
                                                    <td>2번</td>
                                                    <td><input name="answer2" type="text" placeholder="정답" style="width:70px;"></td>
                                                    <td>3번</td>
                                                    <td><input name="answer3" type="text" placeholder="정답" style="width:70px;"></td>
                                                    <td>4번</td>
                                                    <td><input name="answer4" type="text" placeholder="정답" style="width:70px;"></td>
                                                </tr>
                                                <tr>
                                                    <td>5번</td>
                                                    <td><input name="answer5" type="text" placeholder="정답" style="width:70px;"></td>
                                                    <td>6번</td>
                                                    <td><input name="answer6" type="text" placeholder="정답" style="width:70px;"></td>
                                                    <td>7번</td>
                                                    <td><input name="answer7" type="text" placeholder="정답" style="width:70px;"></td>
                                                    <td>8번</td>
                                                    <td><input name="answer8" type="text" placeholder="정답" style="width:70px;"></td>
                                                </tr>
                                                <tr>
                                                    <td>9번</td>
                                                    <td><input name="answer9" type="text" placeholder="정답" style="width:70px;"></td>
                                                    <td>10번</td>
                                                    <td><input name="answer10" type="text" placeholder="정답" style="width:70px;"></td>
                                                    <td>11번</td>
                                                    <td><input name="answer11" type="text" placeholder="정답" style="width:70px;"></td>
                                                    <td>12번</td>
                                                    <td><input name="answer12" type="text" placeholder="정답" style="width:70px;"></td>
                                                </tr>
                                                <tr>
                                                    <td>13번</td>
                                                    <td><input name="answer13" type="text" placeholder="정답" style="width:70px;"></td>
                                                    <td>14번</td>
                                                    <td><input name="answer14" type="text" placeholder="정답" style="width:70px;"></td>
                                                    <td>15번</td>
                                                    <td><input name="answer15" type="text" placeholder="정답" style="width:70px;"></td>
                                                    <td>16번</td>
                                                    <td><input name="answer16" type="text" placeholder="정답" style="width:70px;"></td>
                                                </tr>
                                                <tr>
                                                    <td>17번</td>
                                                    <td><input name="answer17" type="text" placeholder="정답" style="width:70px;"></td>
                                                    <td>18번</td>
                                                    <td><input name="answer18" type="text" placeholder="정답" style="width:70px;"></td>
                                                    <td>19번</td>
                                                    <td><input name="answer19" type="text" placeholder="정답" style="width:70px;"></td>
                                                    <td>20번</td>
                                                    <td><input name="answer20" type="text" placeholder="정답" style="width:70px;"></td>
                                                </tr>

                                            </table>
                                            <button type="submit" class="btn btn-primary me-2">정답 제출</button>

                                </div>
                            </div>
                            </form>
                        </div>
                        <div class="examresult"><br/><br/>
                        <h3> 응시한 ${examname} 시험의 예상 점수는 ${score*5} 점 입니다.</h3>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        </div>
    </section>
    </div>
    <br/><br/><br/><br/><br/>
</main>
<script>
   /* 유효성 검사 부분입니다.*/
    function validateInputs(form) {
        var isValid = true; // 유효성 검사 통과 여부를 저장하는 변수, 초기값은 true
        var regex = /^[1-4]$/; // 유효성 검사에 사용할 정규 표현식, 1부터 4까지의 숫자만 허용

        var inputs = form.querySelectorAll('input[name^="answer"]'); // 'answer'로 시작하는 name을 가진 모든 input 요소를 선택
        var invalidInputs = []; // 유효성 검사를 통과하지 못한 input 요소를 저장할 배열

        inputs.forEach(function(input) {
            var value = input.value.trim();     // input 요소의 값을 공백 제거 후 가져옴
            if (!regex.test(value)) {       // 값이 정규 표현식에 맞지 않으면 (즉, 1~4가 아니면)
                isValid = false;                // 유효성 검사 통과 여부를 false로 설정
                invalidInputs.push(input);       // 유효성 검사를 통과하지 못한 input 요소를 배열에 추가
            }
        });

        if (!isValid) {
            alert("1부터 4 사이의 숫자를 입력하세요!");

            invalidInputs.forEach(function(input) {
                input.style.border = "2px solid red";
            });
            // 유효성 검사 실패해도 스크롤되도록 변경
            var resultArea = document.querySelector('.examresult');
            if (resultArea) {
                setTimeout(function() {
                    resultArea.scrollIntoView({ behavior: 'smooth', block: 'start' });
                }, 100);
            }

            return false;
        }
    }
</script>
<script>
    document.addEventListener("DOMContentLoaded", function() {
        var submitButtons = document.querySelectorAll('button[type="submit"]');

        submitButtons.forEach(function(button) {
            button.addEventListener("click", function() {
                var resultArea = document.querySelector('.examresult'); // 여기에 결과 영역의 클래스 또는 ID를 넣어주세요
                if (resultArea) {
                    setTimeout(function() {
                        resultArea.scrollIntoView({ behavior: 'smooth', block: 'start' });
                    }, 100); // 스크롤 딜레이를 더 줄여보세요
                }
            });
        });
    });
</script>
</body>
</html>
<jsp:include page="/common/views/footer.jsp" />