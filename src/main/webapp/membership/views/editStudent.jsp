<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<jsp:include page="/common/views/nav.jsp" />

<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>CODE-TAB</title>
    <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/common/image/로고.png" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/common/css/style.css?ver=1" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/membership/css/join.css?ver=1" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
</head>
<body>
<div class="wrapper fadeInDown">
    <div id="formContent">
        <form name="frm1" id="frm1" action="${pageContext.request.contextPath}/studentedit.do" method="post" onsubmit="return joinCheck(this)">
            <label class="fadeIn third"><h2 class="active">학생 정보수정</h2></label>
            <input type="password" id="studentPassword" class="fadeIn third" name="studentPassword" placeholder="비밀번호" autocomplete="off" required>
            <input type="password" id="studentPassword2" class="fadeIn third" name="studentPassword2" placeholder="비밀번호 확인" autocomplete="off" required>
            <input type="text" id="name" class="fadeIn third" name="studentName" placeholder="이름" autocomplete="off" required>
            <input type="text" name="postCode" id="sample4_postcode" placeholder="우편번호">
            <input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br>
            <input type="text" name="roadAddr" id="sample4_roadAddress" placeholder="도로명주소" size="60" ><br>
            <input type="hidden" name="jibunAddr" id="sample4_jibunAddress" placeholder="지번주소"  size="60">
            <span id="guide" style="color:#999;display:none"></span>
            <input type="text" name="detailAddr" id="sample4_detailAddress" placeholder="상세주소"  size="60"><br>
            <input type="hidden" id="sample4_extraAddress" placeholder="참고항목"  size="60">
            <input type="hidden" id="sample4_engAddress" placeholder="영문주소"  size="60" ><br><br>
            <input type="submit" class="submit-button" value="정보수정">
            <input type="reset" class="fadeIn fourth" value="취소">
        </form>
    </div>
</div>

<script>
    function joinCheck(f){
        if(f.studentPassword.value!=f.studentPassword2.value){
            alert("비밀번호와 비밀번호 확인이 서로 다릅니다.");
            f.studentPassword.focus();
            return false;
        }
    }
</script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
    //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
    function sample4_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var roadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 참고 항목 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                    extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample4_postcode').value = data.zonecode;
                document.getElementById("sample4_roadAddress").value = roadAddr;
                document.getElementById("sample4_jibunAddress").value = data.jibunAddress;

                document.getElementById("sample4_engAddress").value = data.addressEnglish;

                // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
                if(roadAddr !== ''){
                    document.getElementById("sample4_extraAddress").value = extraRoadAddr;
                } else {
                    document.getElementById("sample4_extraAddress").value = '';
                }

                var guideTextBox = document.getElementById("guide");
                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
                if(data.autoRoadAddress) {
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
                    guideTextBox.style.display = 'block';

                } else if(data.autoJibunAddress) {
                    var expJibunAddr = data.autoJibunAddress;
                    guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
                    guideTextBox.style.display = 'block';
                } else {
                    guideTextBox.innerHTML = '';
                    guideTextBox.style.display = 'none';
                }
            }
        }).open();
    }
</script>
<script>
    function joinCheck(f){

        var pw = f.studentPassword.value;

        var pwReg = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[!@#$%])[A-Za-z\d!@#$%]{8,}$/; // 비밀번호는 소문자,대문자,숫자,특수문자(!@#$%)를 각각 최소 한 개 이상 포함 하며  8글자 이상 이여야 합니다

        if(!pwReg.test(pw)){
            alert("비밀번호는 소문자,대문자,숫자,특수문자(!@#$%)를 각각 최소 한 개 이상 포함 하며  8글자 이상 이여야 합니다.");
            f.studentPassword.focus();
            return false;
        }
        if(f.studentPassword.value!=f.studentPassword2.value){
            alert("비밀번호와 비밀번호 확인이 서로 다릅니다.");
            f.studentPassword.focus();
            return false;
        }

    }
</script>
<jsp:include page="/common/views/footer.jsp" />
</body>
</html>
